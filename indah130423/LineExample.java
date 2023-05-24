/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah130423;

/**
 *
 * @author A409FA
 */
public class LineExample {
    public static void main(String[] args){
        Relation myline = new Line();
        Line line1 = new Line (2, 5, 2, 7);
        Line line2 = new Line (2, 5, 2, 2);
        boolean lineA_lineB = myline.isGreater(line1,line2);
        System.out.println(" Line A > Line B "+ lineA_lineB);
    }
}