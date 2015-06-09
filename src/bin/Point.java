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
    Ring objRing;

    public Point(int intPoint) {
        this.intPoint = intPoint;
        objRing = new Ring(intPoint, intPoint);
    }
    
}
