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
    
    double x;
    double y;

    public Point(int intPoint) {
        this.intPoint = intPoint;
        objRing = new Ring(intPoint, intPoint);
    }

    public Point(int intPoint, Ring objRing, double x, double y) {
        this.intPoint = intPoint;
        this.objRing = objRing;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public Point clone(){
        return new Point(intPoint, objRing, x, y);
    }

    //<editor-fold defaultstate="collapsed" desc="comment">
     public int getIntPoint() {
        return intPoint;
    }

    public void setIntPoint(int intPoint) {
        this.intPoint = intPoint;
    }

    public Ring getObjRing() {
        return objRing;
    }

    public void setObjRing(Ring objRing) {
        this.objRing = objRing;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
//</editor-fold>

   
    
    
    
}
