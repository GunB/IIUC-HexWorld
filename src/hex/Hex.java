/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hex;

import bin.Point;
import java.util.Scanner;

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

        Scanner scanIn = new Scanner(System.in);
        String a = scanIn.nextLine();
        String b = scanIn.nextLine();
        scanIn.close();
        
        Hex solving = new Hex().Run(Integer.parseInt(a), Integer.parseInt(b));
        
        
        
    }

    public Hex Run(int intA, int intB) {
        a = new Point(intA);
        b = new Point(intB);

        return this;
    }

}
