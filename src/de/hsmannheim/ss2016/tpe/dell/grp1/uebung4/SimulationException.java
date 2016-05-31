package de.hsmannheim.ss2016.tpe.dell.grp1.uebung4;

import java.util.LinkedList;

/**
 * @Author TPE_GRP_1
 *
 * printed trains in crash and stopps trains
 */
public class SimulationException extends Exception {

    /**
     * 2 trains crashed / stopps both trains
     * @param zug1 Zug
     * @param zug2 Zug
     */
    public SimulationException(Zug zug1, Zug zug2) {
        super();
        zug1.setRunning(false);
        zug2.setRunning(false);
        System.err.println("Zug " + zug1.getName() + " " + zug2.getName() +
                "  crashed; at pos zug1 :" + zug1.getPosition() + " zug2 :" + zug2.getPosition());

    }

    /**
     * crash in an Crash / stopps new train
     * @param zug1 Zug
     * @param zuge2 LinkedList< Zug >
     */
    public SimulationException(Zug zug1, LinkedList<Zug> zuge2) {
        super();
        zug1.setRunning(false);
        String s = "Zug " + zug1.getName() + " + ";
        for (Zug zug : zuge2){
            s += zug.getName()+":";
        }
        s += " crashed; at pos zug1 :" + zug1.getPosition();
        System.err.println(s);
    }

}
