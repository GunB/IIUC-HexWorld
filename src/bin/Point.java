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
public class Point {
    int intPoint;
    int intRing;
    
    int[] intPointsRing;

    public Point(int intPoint) {
        this.intPoint = intPoint;
        
    }
    
    private void SearchRing(){
        if(intPoint == 0){
            intRing = 0;
        }else{
            boolean isRingable = false;
            int cont=1;
            
            while(!isRingable){
                int[] PointsOfRing = PointsOfRing(cont);
                
                if(intPoint >= PointsOfRing[0] && intPoint <= PointsOfRing[1]){
                    isRingable = true;
                    intPointsRing = PointsOfRing;
                    intRing = cont;
                }
            }
        }
    }
    
    private int[] PointsOfRing(int intPosibleRing){
        int[] intRingEx = new int[2];
        
        intRingEx[1] = 6 + ( (intPosibleRing -1) * 6 );
        intRingEx[0] = intRingEx[1] - (6 + ( (intPosibleRing -1) * 6 )) + 1;
        
        return null;
    }
}
