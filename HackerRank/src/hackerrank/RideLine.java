/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author s542046
 */
public class RideLine {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int numPeople = sc.nextInt();
            ArrayList<Integer> sortedList = new ArrayList<Integer>();
            for (int k = 0; k < numPeople; k++) {
                sortedList.add(sc.nextInt());
            }
//            System.out.print("Sorted List: ");
//            for (int k : sortedList) {
//                System.out.print(k + " ");
//            }
            ArrayList<Integer> list = (ArrayList<Integer>) sortedList.clone();
            Collections.sort(sortedList);

//            System.out.println("List: " + list);
//            System.out.println("Sorted List" + sortedList);
            boolean chaotic = false;

            for (int j = 0; j < sortedList.size(); j++) {
                int num = sortedList.get(j);
                if (j - list.indexOf(num) > 2) {
                    chaotic = true;
                    System.out.println("Too chaotic");

                    break;
                }
            }
            if (chaotic == false) {
                int switches = 0;
                boolean done = false;
                int min = 0;
                int max = list.size();
                while (done == false) {
                    done = true;
                    int prevMax = max;
                    for (int j = min; j + 1 < prevMax; j++) {
                        if (list.get(j) > list.get(j + 1)) {
                            int temp = list.get(j);
                            list.set(j, list.get(j + 1));
                            list.set(j + 1, temp);
                            switches++;
                            if(done){
                                min = j-2;
                                if(min<0)min=0;
                                done = false;
                            }
                            max = j+2;
                            if(max>list.size())max = list.size();

                        }
                    }
                }
//                System.out.print("List: ");
//                for (int k : list) {
//                    System.out.print(k + " ");
//                }
//                System.out.println();
//                System.out.print("Sorted List: ");
//                for (int k : sortedList) {
//                    System.out.print(k + " ");
//                }
//                System.out.println();
                System.out.println(switches);
            }

        }

    }

    public static int getLeastNumSwitches(ArrayList<Integer> list) {

        for (int j = 0; j + 1 < list.size(); j++) {
            if (list.get(j) > list.get(j + 1)) {
                ArrayList<Integer> tempList = (ArrayList<Integer>) list.clone();
                int temp = tempList.get(j);
                tempList.set(j, list.get(j + 1));
                tempList.set(j + 1, temp);
                return getLeastNumSwitches(tempList) + 1;
            }
        }

        return 0;
    }
}
