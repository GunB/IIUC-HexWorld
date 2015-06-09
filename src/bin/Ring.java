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
        SearchRing(intPoint);
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
            
            for (int i = 0; i < arrayList.size(); i++) {
                
                if(i == lstPointsVertices.get(0)){
                    lstPoints.put(0, new Point(intRing, this, (pointPerSide + 1) / 2, -intRing));
                }else if(i < lstPointsVertices.get(1) && i > lstPointsVertices.get(0)){
                    
                    
                    
                }else if(i == lstPointsVertices.get(1)){
                    
                }else if(i < lstPointsVertices.get(2) && i > lstPointsVertices.get(1)){
                    
                }else if(i == lstPointsVertices.get(2)){
                    
                }else if(i < lstPointsVertices.get(3) && i > lstPointsVertices.get(2)){
                    
                }else if(i == lstPointsVertices.get(3)){
                    
                }else if(i < lstPointsVertices.get(4) && i > lstPointsVertices.get(3)){
                    
                }else if(i == lstPointsVertices.get(4)){
                    
                }else if(i < lstPointsVertices.get(5) && i > lstPointsVertices.get(4)){
                    
                }else if(i == lstPointsVertices.get(5)){
                    
                }
                
                lstPoints.put(arrayList.get(i),
                        new Point(intRing, this, 0, 0));
            }

        }
    }

    public static int[] PointsOfRing(int intPosibleRing) {
        int[] intRingEx = new int[2];

        intRingEx[1] = 6 + ((intPosibleRing - 1) * 6);

        if (intPosibleRing > 1) {
            intRingEx[0] = 6 + ((intPosibleRing - 2) * 6) + 1;
        } else {
            intRingEx[0] = 1;
        }

        return intRingEx;
    }

    private void SearchRing(int intPoint) {
        if (intPoint == 0) {
            intPointsRing[0] = 0;
            intPointsRing[1] = 0;
        } else {
            boolean isRingable = false;
            int cont = 1;

            while (!isRingable) {
                int[] PointsOfRing = Ring.PointsOfRing(cont);

                if (intPoint >= PointsOfRing[0] && intPoint <= PointsOfRing[1]) {
                    isRingable = true;
                    intPointsRing = PointsOfRing;
                }
                cont++;
            }
        }
    }

}
