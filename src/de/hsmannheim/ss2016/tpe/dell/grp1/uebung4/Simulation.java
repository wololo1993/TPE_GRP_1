package de.hsmannheim.ss2016.tpe.dell.grp1.uebung4;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author TPE_GRP_1
 */
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

    private String crashedString = "";

    /**
     * Macht ein Frame Sichtbar der 2 Buttons enthält die jeweils eine Simulation machen
     * @param args
     */
    public static void main(String[] args) {

        JFrame chooseFrame = new JFrame();
        chooseFrame.setLayout(new FlowLayout());

        JButton sim1 = new JButton("Simulation");
        JButton sim2 = new JButton("Crashes");

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

            for (Block block : blocks) {
                strecke.addBlock(block);
            }

            Zug[] zuege = new Zug[5];

            Object printLock = new Object();

            zuege[0] = new Zug(6, 'A', 5, strecke, printLock);
            zuege[1] = new Zug(11, 'B', 15, strecke, printLock);
            zuege[2] = new Zug(20, 'C', 5, strecke, printLock);
            zuege[3] = new Zug(30, 'D', 10, strecke, printLock);
            zuege[4] = new Zug(45, 'E', 6, strecke, printLock);


            new Simulation(strecke, zuege, printLock);

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

            for (Block block : blocks) {
                strecke.addBlock(block);
            }

            Zug[] zuege = new Zug[5];

            Object printLock = new Object();

            zuege[0] = new Zug(1, 'A', 5, strecke, printLock);
            zuege[1] = new Zug(2, 'B', 15, strecke, printLock);
            zuege[2] = new Zug(3, 'C', 5, strecke, printLock);
            zuege[3] = new Zug(4, 'D', 10, strecke, printLock);
            zuege[4] = new Zug(5, 'E', 6, strecke, printLock);


            new Simulation(strecke, zuege, printLock);

            chooseFrame.setVisible(false);
        });


        chooseFrame.setSize(300,70);
        chooseFrame.setLocationRelativeTo(null);
        chooseFrame.setVisible(true);


    }


    /**
     * constructor erstellt neuen frame mit der Erstellten Strecke Zuege etc
     * mit startButton der aus dem Object ein Thread macht und ihn startet
     * @param strecke Strecke
     * @param zuege Zug[]
     * @param printLock Object
     */
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

    /**
     * Run Methode ruft initLocks auf und startet alle zuege
     * dann wartet sie so lange am printLock bis jmd es aufruft
     * wenn aufgerufen printet es auf die console bzw in das TextFeld
     *
     * (überprüft auch auf Crashes)
     */
    @Override
    public void run() {

        Thread[] threads = new Thread[zuege.length];



        strecke.initLocks(zuege);

        System.out.println(updateZuge());
        trainTrack.setText(updateZuge());

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

            System.out.println(updateZuge());
            trainTrack.setText(updateZuge());

        }
    }

    /**
     * iteriert alle Züge
     * prüft auf crashes, dann
     * @return
     */
    private String updateZuge() {
        HashMap<Integer, Zug> localCrashMap = new HashMap<>();
        String finishedString = "";

        String s = strecke.getString();

        int count = 0;
        int allFinished = 0;

        for (Zug zug : zuege) {

            //Crash Abfrage Beginn
            if (!zug.getRunning()) {        //Zug Beendet
                allFinished++;
                finishedString += "Zug " + zug.getName() + " is finished\n";
            } else {
                Zug crashed = localCrashMap.put(zug.getPosition(), zug.getZug());
                boolean crashedCrash = globalCrashMap.containsKey(zug.getPosition());

                if(crashedCrash){ //wenn in Unfall reingefahren
                    try {
                        throw new SimulationException(zug,globalCrashMap.get(zug.getPosition()));
                    } catch (SimulationException e) {
                        e.printStackTrace();
                        globalCrashMap.get(zug.getPosition()).add(zug); //füge neuen Zug an den Crash an
                        crashedString += "Crashed :"+zug.getName()+" in Crash at :"+zug.getPosition();
                    }
                }

                if (crashed != null) { //Neuer Unfall
                    try {
                        throw new SimulationException(crashed,localCrashMap.get(crashed.getPosition()));
                    } catch (SimulationException e) {
                        e.printStackTrace();
                        LinkedList<Zug> list = new LinkedList();        //Macht einen neuen Crash an der position
                        list.add(zug);                                  // in der globalCrashMap
                        list.add(crashed);                              // und fügt beide Züge an
                        globalCrashMap.put(zug.getPosition(),list);
                        crashedString += "Crashed :" + crashed.getPosition() +
                                " Zuge :" + localCrashMap.get(crashed.getPosition()).getName() + " " + crashed.getName()+"\n";
                    }
                }
            } //Crash Abfrage Ende

            if (zug.getPosition() >= strecke.length) {      //wenn zug länger als Strecke häng ihn einfach hinten an;
                s += zug.getName();
                count++;
            } else {                                        // ansonsten per Substring an seiner Position
                s = s.substring(0, zug.getPosition() + count + 1) + zug.getName() + s.substring(zug.getPosition() + count + 1);
                count++;
            }
        }

        if(allFinished >= zuege.length){
            this.running = false;           //Wenn alle beendet dann soll die Sim aufhören
        }

        finished.setText(finishedString);   //frame ausgabe für alle beendeten
        crashed.setText(crashedString);     //frame ausgabe für alle crashes
        return s;

    }
}
