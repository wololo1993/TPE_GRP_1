package de.hsmannheim.ss2016.tpe.dell.grp1.uebung4;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class Simulation implements Runnable {

    private boolean running = true;
    private Strecke strecke;
    private Zug[] zuege;
    private Object printLock;
    private HashMap<Integer,LinkedList<Zug>> globalCrashMap;

    private JFrame frame;
    private JTextArea trainTrack;
    private JTextArea finished;
    private JTextArea crashed;

    String crashedString = "";

    public static void main(String[] args) {

        JFrame chooseFrame = new JFrame();
        chooseFrame.setLayout(new FlowLayout());

        JButton sim1 = new JButton("sim1");
        JButton sim2 = new JButton("sim2");

        chooseFrame.getContentPane().add(sim1);
        chooseFrame.getContentPane().add(sim2);

        sim1.addActionListener(e -> {
            Strecke strecke = new Strecke(70);

            Block[] blocks = new Block[8];

            blocks[0] = new Block(10, 0);
            blocks[1] = new Block(5, 10);
            blocks[2] = new Block(10, 15);
            blocks[3] = new Block(10, 25);
            blocks[4] = new Block(15, 35);
            blocks[5] = new Block(10, 50);
            blocks[6] = new Block(5, 60);
            blocks[7] = new Block(5, 65);

            for (int i = 0; i < blocks.length; i++) {
                strecke.addBlock(blocks[i]);
            }

            Zug[] zuege = new Zug[5];

            Object printLock = new Object();

            zuege[0] = new Zug(6, 'A', 5, strecke, printLock);
            zuege[1] = new Zug(11, 'B', 15, strecke, printLock);
            zuege[2] = new Zug(20, 'C', 5, strecke, printLock);
            zuege[3] = new Zug(30, 'D', 10, strecke, printLock);
            zuege[4] = new Zug(45, 'E', 6, strecke, printLock);


            Simulation sim = new Simulation(strecke, zuege, printLock);

            chooseFrame.setVisible(false);
        });

        sim2.addActionListener(e -> {


            Strecke strecke = new Strecke(70);

            Block[] blocks = new Block[8];

            blocks[0] = new Block(10, 0);
            blocks[1] = new Block(5, 10);
            blocks[2] = new Block(10, 15);
            blocks[3] = new Block(10, 25);
            blocks[4] = new Block(15, 35);
            blocks[5] = new Block(10, 50);
            blocks[6] = new Block(5, 60);
            blocks[7] = new Block(5, 65);

            for (int i = 0; i < blocks.length; i++) {
                strecke.addBlock(blocks[i]);
            }

            Zug[] zuege = new Zug[5];

            Object printLock = new Object();

            zuege[0] = new Zug(1, 'A', 5, strecke, printLock);
            zuege[1] = new Zug(2, 'B', 15, strecke, printLock);
            zuege[2] = new Zug(3, 'C', 5, strecke, printLock);
            zuege[3] = new Zug(4, 'D', 10, strecke, printLock);
            zuege[4] = new Zug(5, 'E', 6, strecke, printLock);


            Simulation sim = new Simulation(strecke, zuege, printLock);
            ((JButton)e.getSource()).setVisible(false);
            chooseFrame.setVisible(false);
        });


        chooseFrame.setSize(200,70);
        chooseFrame.setLocationRelativeTo(null);
        chooseFrame.setVisible(true);


    }

    public Simulation(Strecke strecke, Zug[] zuege, Object printLock) {
        this.strecke = strecke;
        this.zuege = zuege;
        this.printLock = printLock;

        globalCrashMap = new HashMap<>();

        crashed = new JTextArea();
        finished = new JTextArea();
        trainTrack = new JTextArea();

        crashed.setEnabled(false);
        finished.setEnabled(false);
        trainTrack.setEnabled(false);

        JButton button = new JButton("Start");
        button.addActionListener(e -> {
            Thread x = new Thread(this);
            x.start();
            button.setVisible(false);
        });
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 100);
        frame.setBackground(Color.cyan);
        frame.setLayout(new FlowLayout());
        frame.add(trainTrack);
        frame.add(button);
        frame.add(finished);
        frame.add(crashed);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void run() {

        Thread[] threads = new Thread[zuege.length];


        strecke.initLocks(zuege);

        for (int i = 0; i < zuege.length; i++) {
            threads[i] = new Thread(zuege[i]);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }


        while (running) {

            synchronized (printLock) {
                try {
                    printLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(addZuege());
            trainTrack.setText(addZuege());

        }
        System.out.println("Print is Fertig");
    }

    private String addZuege() {
        HashMap<Integer, Zug> localCrashMap = new HashMap<>();
        String finishedString = "";

        String s = strecke.getString();

        int count = 0;
        int allFinished = 0;

        for (Zug zug : zuege) {

            if (!zug.getRunning()) {
                allFinished++;
                finishedString += "Zug " + zug.getName() + " is finished\n";
            } else {
                Zug crashed = localCrashMap.put(zug.getPosition(), zug.getZug());
                boolean crashedCrash = globalCrashMap.containsKey(zug.getPosition());

                if(crashedCrash){
                    try {
                        throw new SimulationException(zug,globalCrashMap.get(zug.getPosition()));
                    } catch (SimulationException e) {
                        e.printStackTrace();
                        globalCrashMap.get(zug.getPosition()).add(zug);
                    }
                }

                if (crashed != null) {
                    try {
                        throw new SimulationException(crashed,localCrashMap.get(crashed.getPosition()));
                    } catch (SimulationException e) {
                        e.printStackTrace();
                        LinkedList<Zug> list = new LinkedList();
                        list.add(zug);
                        list.add(crashed);
                        globalCrashMap.put(zug.getPosition(),list);
                        crashedString += "Crahed :" + crashed.getPosition() +
                                " Zuge :" + localCrashMap.get(crashed.getPosition()).getName() + " " + crashed.getName()+"\n";
                    }
                }
            }
            if (zug.getPosition() >= strecke.length) {
                s += zug.getName();
                count++;
            } else {
                s = s.substring(0, zug.getPosition() + count + 1) + zug.getName() + s.substring(zug.getPosition() + count + 1);
                count++;
            }
        }

        if(allFinished >= zuege.length){
            this.running = false;
        }

        finished.setText(finishedString);
        crashed.setText(crashedString);
        return s;

    }
}
