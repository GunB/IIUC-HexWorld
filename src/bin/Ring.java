/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

/**
 *
 * @author hangarita
 */
public class Ring {
    int intRing;
    int[] intPointsRing;

    public Ring(int intRing, int[] intPointsRing) {
        this.intRing = intRing;
        this.intPointsRing = intPointsRing;
    }

    public Ring(int intRing, int intPoint) {
        this.intRing = intRing;
        SearchRing(intPoint);
    }
    
    public static int[] PointsOfRing(int intPosibleRing){
        int[] intRingEx = new int[2];
        
        intRingEx[1] = 6 + ( (intPosibleRing -1) * 6 );
        
        if(intPosibleRing > 1){
            intRingEx[0] = 6 + ( (intPosibleRing -2) * 6 ) + 1;
        }else{
            intRingEx[0] = 1;
        }
        
        return intRingEx;
    }
    
    private void SearchRing(int intPoint){
        if(intPoint == 0){
            intPointsRing[0] = 0;
            intPointsRing[1] = 0;
        }else{
            boolean isRingable = false;
            int cont=1;
            
            while(!isRingable){
                int[] PointsOfRing = Ring.PointsOfRing(cont);
                
                if(intPoint >= PointsOfRing[0] && intPoint <= PointsOfRing[1]){
                    isRingable = true;
                    intPointsRing = PointsOfRing;
                }
                cont++;
            }
        }
    }
    
    
}
