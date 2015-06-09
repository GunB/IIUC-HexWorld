/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author hangarita
 */
public class Ring {

    int intRing;
    int[] intPointsRing;

    HashMap<Integer, Point> lstPoints = new HashMap<>();

    public Ring(int intRing, int[] intPointsRing) {
        this.intRing = intRing;
        this.intPointsRing = intPointsRing;
    }

    public Ring(int intRing, int intPoint) {
        this.intRing = intRing;
        intPointsRing = SearchRing(intPoint, 1, 0).intPointsRing;
    }

    private void DefineRing() {
        //intRingEx[1] = 6 + ( (intPosibleRing -1) * 6 );
        int pointPerSide = ((intRing - 1));
        if (pointPerSide < 0) {
            lstPoints.put(0, new Point(intRing, this, 0, 0));
        } else {
            double intStart = 1;
            if (pointPerSide % 2 != 0) {
                intStart = 0.5;
            }

            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(intPointsRing[1]);
            for (int i = intPointsRing[0]; i < intPointsRing[1]; i++) {
                arrayList.add(i);
            }

            ArrayList<Integer> lstPointsVertices = new ArrayList<>();
            //<editor-fold defaultstate="collapsed" desc="Describiendo los vertices del Hexagono">
            lstPointsVertices.add(1 - 1);
            lstPointsVertices.add(lstPointsVertices.get(lstPointsVertices.size() - 1) + pointPerSide + 1);
            lstPointsVertices.add(lstPointsVertices.get(lstPointsVertices.size() - 1) + pointPerSide + 1);
            lstPointsVertices.add(lstPointsVertices.get(lstPointsVertices.size() - 1) + pointPerSide + 1);
            lstPointsVertices.add(lstPointsVertices.get(lstPointsVertices.size() - 1) + pointPerSide + 1);
            lstPointsVertices.add(lstPointsVertices.get(lstPointsVertices.size() - 1) + pointPerSide + 1);
            //</editor-fold>

            for (int i = 0; i < arrayList.size(); i++) {

                if (i == lstPointsVertices.get(0)) {
                    lstPoints.put(arrayList.get(i), new Point(intRing, this, (pointPerSide + 1) / 2, -intRing));
                } else if (i < lstPointsVertices.get(1) && i > lstPointsVertices.get(0)) {
                    
                } else if (i == lstPointsVertices.get(1)) {

                } else if (i < lstPointsVertices.get(2) && i > lstPointsVertices.get(1)) {

                } else if (i == lstPointsVertices.get(2)) {

                } else if (i < lstPointsVertices.get(3) && i > lstPointsVertices.get(2)) {

                } else if (i == lstPointsVertices.get(3)) {

                } else if (i < lstPointsVertices.get(4) && i > lstPointsVertices.get(3)) {

                } else if (i == lstPointsVertices.get(4)) {

                } else if (i < lstPointsVertices.get(5) && i > lstPointsVertices.get(4)) {

                } else if (i == lstPointsVertices.get(5)) {

                }

                lstPoints.put(arrayList.get(i),
                        new Point(intRing, this, 0, 0));
            }

        }
    }

    public static Ring SearchRing(int intPoint, int intPosibleRing, int intStart) {
        int[] intRingEx = new int[2];
        if (intPoint == 0) {
            intRingEx[0] = intRingEx[1] = 0;
            return new Ring(intPoint, intRingEx);
        }

        intRingEx[0] = intStart + 1;
        intRingEx[1] = intStart + 6 + ((intPosibleRing - 1) * 6);

        if (intPoint >= intRingEx[0] && intPoint <= intRingEx[1]) {
            return new Ring(intPoint, intRingEx);
        } else {
            intPosibleRing++;
            return SearchRing(intPoint, intPosibleRing, intRingEx[1]);
        }
    }

}
