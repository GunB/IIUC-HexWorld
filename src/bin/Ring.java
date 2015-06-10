/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

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

    public Ring(int intPoint) {
        Ring SearchRing = SearchRing(intPoint, 1, 0);
        intPointsRing = SearchRing.intPointsRing;
        this.intRing = SearchRing.intRing;
        DefineRing();
    }

    private void DefineRing() {
        //intRingEx[1] = 6 + ( (intPosibleRing -1) * 6 );
        int pointPerSide = ((intRing - 1));
        if (pointPerSide < 0) {
            lstPoints.put(0, new Point(0, this, 0, 0));
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

            Point lastPoint = null;

            for (int i = 0; i < arrayList.size(); i++) {

                float distance = (((float)pointPerSide + 1) / 2);
                
                if (i == lstPointsVertices.get(0)) {
                    lastPoint = new Point(arrayList.get(i), this,distance , -intRing);
                    lstPoints.put(arrayList.get(i), lastPoint.clone());

                } else if (i == lstPointsVertices.get(1)) {
                    lastPoint = new Point(arrayList.get(i), this, intRing, 0);
                    lstPoints.put(arrayList.get(i), lastPoint.clone());

                } else if (i == lstPointsVertices.get(2)) {
                    lastPoint = new Point(arrayList.get(i), this, distance, intRing);
                    lstPoints.put(arrayList.get(i), lastPoint.clone());

                } else if (i == lstPointsVertices.get(3)) {
                    lastPoint = new Point(arrayList.get(i), this, -distance, intRing);
                    lstPoints.put(arrayList.get(i), lastPoint.clone());

                } else if (i == lstPointsVertices.get(4)) {
                    lastPoint = new Point(arrayList.get(i), this, -intRing, 0);
                    lstPoints.put(arrayList.get(i), lastPoint.clone());

                } else if (i == lstPointsVertices.get(5)) {
                    lastPoint = new Point(arrayList.get(i), this, -distance, -intRing);
                    lstPoints.put(arrayList.get(i), lastPoint.clone());
                }

            }

            for (int i = 0; i < arrayList.size(); i++) {

                if (i == lstPointsVertices.get(0)) {
                    lastPoint = lstPoints.get(arrayList.get(lstPointsVertices.get(0))).clone();
                } else if (i < lstPointsVertices.get(1) && i > lstPointsVertices.get(0)) {
                    Point a = lstPoints.get(arrayList.get(lstPointsVertices.get(0)));
                    Point b = lstPoints.get(arrayList.get(lstPointsVertices.get(1)));
                    
                    double distancia = ((b.x - a.x) / (pointPerSide + 1));
                    lastPoint = new Point(arrayList.get(i), this, lastPoint.x + distancia, lastPoint.y - 1);

                    
                    
                    lstPoints.put(arrayList.get(i), lastPoint.clone());
                } else if (i == lstPointsVertices.get(1)) {
                    lastPoint = lstPoints.get(arrayList.get(lstPointsVertices.get(1))).clone();
                } else if (i < lstPointsVertices.get(2) && i > lstPointsVertices.get(1)) {
                    Point a = lstPoints.get(arrayList.get(lstPointsVertices.get(1)));
                    Point b = lstPoints.get(arrayList.get(lstPointsVertices.get(2)));
                    
                    double distancia = ((a.x - b.x) / (pointPerSide + 1));
                    lastPoint = new Point(arrayList.get(i), this, lastPoint.x - distancia, lastPoint.y + 1);

                    
                    
                    lstPoints.put(arrayList.get(i), lastPoint.clone());
                } else if (i == lstPointsVertices.get(2)) {
                    lastPoint = lstPoints.get(arrayList.get(lstPointsVertices.get(2))).clone();
                } else if (i < lstPointsVertices.get(3) && i > lstPointsVertices.get(2)) {
                    double distancia = 1;
                    lastPoint = new Point(arrayList.get(i), this, lastPoint.x - distancia, lastPoint.y);
                    
                    
                    lstPoints.put(arrayList.get(i), lastPoint.clone());
                } else if (i == lstPointsVertices.get(3)) {
                    lastPoint = lstPoints.get(arrayList.get(lstPointsVertices.get(3))).clone();
                } else if (i < lstPointsVertices.get(4) && i > lstPointsVertices.get(3)) {
                    Point a = lstPoints.get(arrayList.get(lstPointsVertices.get(3)));
                    Point b = lstPoints.get(arrayList.get(lstPointsVertices.get(4)));
                    
                    double distancia = ((Math.abs(b.x) - Math.abs(a.x)) / (pointPerSide + 1));
                    lastPoint = new Point(arrayList.get(i), this, lastPoint.x - distancia, lastPoint.y - 1);
                    
                    
                    
                    lstPoints.put(arrayList.get(i), lastPoint.clone());
                } else if (i == lstPointsVertices.get(4)) {
                    lastPoint = lstPoints.get(arrayList.get(lstPointsVertices.get(4))).clone();
                } else if (i < lstPointsVertices.get(5) && i > lstPointsVertices.get(4)) {
                    Point a = lstPoints.get(arrayList.get(lstPointsVertices.get(4)));
                    Point b = lstPoints.get(arrayList.get(lstPointsVertices.get(5)));
                    
                    double distancia = ((Math.abs(a.x) - Math.abs(b.x)) / (pointPerSide + 1));
                    lastPoint = new Point(arrayList.get(i), this, lastPoint.x + distancia, lastPoint.y - 1);
                    
                    
                    lstPoints.put(arrayList.get(i), lastPoint.clone());
                } else if (i == lstPointsVertices.get(5)) {
                    lastPoint = lstPoints.get(arrayList.get(lstPointsVertices.get(5))).clone();
                } else if (i > lstPointsVertices.get(5)) {
                    double distancia = 1;
                    lastPoint = new Point(arrayList.get(i), this, lastPoint.x + distancia, lastPoint.y);
                    
                    
                    lstPoints.put(arrayList.get(i), lastPoint.clone());
                }

            }

            for (Entry<Integer, Point> entry : lstPoints.entrySet()) {
                Integer key = entry.getKey();
                Point value = entry.getValue();

                //System.out.println(value.intPoint + " x:" + value.x + " y:" + value.y);
            }
        }
    }

    public Point GetPoint(int intPoint) {
        return lstPoints.get(intPoint);
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
            return new Ring(intPosibleRing, intRingEx);
        } else {
            intPosibleRing++;
            return SearchRing(intPoint, intPosibleRing, intRingEx[1]);
        }
    }

}
