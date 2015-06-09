/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hex;

import bin.Point;

/**
 *
 * @author hangarita
 */
public class Hex {
    
    Point a;
    Point b;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public Hex Run(int intA, int intB){
        a = new Point(intA);
        b = new Point(intB);
        
        return this;
    }
    
}
