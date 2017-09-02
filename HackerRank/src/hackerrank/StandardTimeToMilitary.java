/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Scanner;

/**
 *
 * @author s542046
 */
public class StandardTimeToMilitary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(":");
        int h = Integer.valueOf(data[0]);
        int m = Integer.valueOf(data[1]);
        int s = Integer.valueOf(data[2].substring(0, 2));
        String state = data[2].substring(2, 4);
        if (state.equals("AM") && h == 12) {
            h -= 12;
        }

        if (state.equals("PM") && h != 12) {
            h += 12;
        }

        System.out.printf("%02d", h);
        System.out.print(":");
        System.out.printf("%02d", m);
        System.out.print(":");
        System.out.printf("%02d", s);

    }
}
