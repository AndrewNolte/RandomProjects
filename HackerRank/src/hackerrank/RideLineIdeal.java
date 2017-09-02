/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author s542046
 */
public class RideLineIdeal {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int numPeople = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int k = 0; k < numPeople; k++) {
                list.add(sc.nextInt());
            }

            int ans = 0;
            boolean done = false;
            for (int k = list.size() - 1; k >= 0; k--) {
                if (list.get(k) - (k + 1) > 2) {
                    System.out.println("Too chaotic");
                    done = true;
                    break;
                }
                for (int j = Math.max(0, list.get(k) - 2); j < k; j++) {
                    if (list.get(j) > list.get(k)) {
                        ans++;
                    }
                }
            }
            if(!done)System.out.println(ans);


        }
    }
}
