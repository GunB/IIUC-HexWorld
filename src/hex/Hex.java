/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hex;

import bin.Point;
import java.text.DecimalFormat;
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
        
        Double Distance = solving.Distance(solving.a, solving.b);
        
        DecimalFormat df = new DecimalFormat("#.###"); 
        
        System.out.print(df.format(solving.b.getIntPoint() - solving.a.getIntPoint()));
        System.out.print(" ");
        System.out.print(df.format(Distance));
        
    }

    public Hex Run(int intA, int intB) {
        a = new Point(intA);
        b = new Point(intB);

        return this;
    }
    
    public Double Distance(Point a, Point b){
        
        Double distance = Math.sqrt( (Math.pow(b.getX() - a.getX(), 2)) + (Math.pow(b.getY() - a.getY(), 2)) );
        
        return distance;
    }

}
