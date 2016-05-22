package de.hsmannheim.ss2016.tpe.dell.grp1.uebung4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Simulation implements Runnable {

    private Strecke strecke;
    private Zug[] zuege;
    private Object printLock;
    private boolean running = true;

    private JFrame frame;
    private JTextArea txt;

    public static void main(String[] args) {

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

        zuege[0] = new Zug(6, 'A', 100, strecke, printLock);
        zuege[1] = new Zug(11, 'B', 15, strecke, printLock);
        zuege[2] = new Zug(20, 'C', 5, strecke, printLock);
        zuege[3] = new Zug(30, 'D', 10, strecke, printLock);
        zuege[4] = new Zug(45, 'E', 6, strecke, printLock);



        Simulation sim = new Simulation(strecke, zuege, printLock);

    }

    public Simulation(Strecke strecke, Zug[] zuege, Object printLock) {
        this.strecke = strecke;
        this.zuege = zuege;
        this.printLock = printLock;

        txt = new JTextArea();
        JButton button = new JButton("Start");
        button.addActionListener(e -> {
            Thread x = new Thread(this);
            x.start();
            button.setVisible(false);
        });
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600,100);
        frame.setBackground(Color.cyan);
        frame.setLayout(new FlowLayout());
        frame.add(txt);
        frame.add(button);

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

           // System.err.println(addZuege());
            txt.setText(addZuege());

            synchronized (printLock) {
                try {
                    printLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }

    }

    private String addZuege() {
        String s = strecke.getString();
        int count = 0;
        for (Zug zug : zuege) {
            if(zug.getPosition() >= strecke.length){
                s += zug.getName();
                count++;
            } else {
                s = s.substring(0, zug.getPosition() + count + 1) + zug.getName() + s.substring(zug.getPosition() + count + 1);
                count++;
            }
        }

        return s;

    }


}
