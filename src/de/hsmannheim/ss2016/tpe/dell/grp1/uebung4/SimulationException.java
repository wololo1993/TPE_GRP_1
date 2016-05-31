package de.hsmannheim.ss2016.tpe.dell.grp1.uebung4;

import java.util.LinkedList;

public class SimulationException extends Exception {

    public SimulationException(Zug zug1, Zug zug2) {
        super();
        zug1.setRunning(false);
        zug2.setRunning(false);
        System.err.println("Zug " + zug1.getName() + " + " + zug2.getName() +
                "crashed; at pos zug1 :" + zug1.getPosition() + " zug2 :" + zug2.getPosition());

    }

    public SimulationException(Zug zug1, LinkedList<Zug> zuge2) {
        super();
        zug1.setRunning(false);
        String s = "Zug " + zug1.getName() + " + ";
        for (Zug zug : zuge2){
            s += zug.getName()+":";
        }
        s += "crashed; at pos zug1 :" + zug1.getPosition();
        System.err.println(s);
    }

}
