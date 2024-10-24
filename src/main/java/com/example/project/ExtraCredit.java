package com.example.project;
import java.util.Scanner;


public class ExtraCredit {


    public static String calculateTip(int people, int percent, double cost, String items) {
        StringBuilder result = new StringBuilder();

                //COPY AND PASTE YOUR CODE HERE 
        double costBefore = cost; // total cost before tip
        double tip = percent * cost/100; // value of tip
        double totalCost = cost + tip; // total cost after tip
        double costEachBefore = cost / people; // cost per person before tip
        double tipEach = tip/people; // tip per person
        double costEachAfter = totalCost / people; // total cost per person


        
        /* Math.round rounds to the nearest int, so I multiply by 100 to convert from dollars and cents to just cents, then round to the nearest
        cent and then divide by 100.0 in order to convert back to dollars and cents. It has to be 100.0 and not 100, because the rounded value
        is an int, so if I divide by an int, it's int division, which gives and int, whereas I need a double.
        I found out about the Math.round method at https://www.w3schools.com/java/ref_math_round.asp*/
        
        // this section is just using the above principle to round values.
        tip = Math.round(tip * 100)/100.0;
        totalCost = Math.round(totalCost * 100)/100.0;
        costEachBefore = Math.round(costEachBefore * 100)/100.0;
        tipEach =Math.round(tipEach * 100)/100.0;
        costEachAfter = Math.round(costEachAfter * 100)/100.0;
                       
        result.append("-------------------------------\n");
        result.append("Total bill before tip: $" + costBefore + "\n"); //concatenate to this string. DO NOT ERASE AND REWRITE
        result.append("Total percentage: " + percent + "%\n");
        result.append("Total tip: $" + tip + "\n");
        result.append("Total Bill with tip: $" + totalCost + "\n");
        result.append("Per person cost before tip: $" + costEachBefore + "\n");
        result.append("Tip per person: $" + tipEach + "\n");
        result.append("Total cost per person: $" + costEachAfter + "\n");
        result.append("-------------------------------\n");

        //the two lines  should go below result.append("-------------------------------\n"); 
        result.append("Items ordered:\n");
        result.append(items);


        return result.toString();
    }
                                   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = 10;
        int percent = 18;
        double cost = 105.53;
        String items = ""; 
        String lastInput = "";

        //Your scanner object and while loop should go here

        while (!lastInput.equals("-1")){ // loops until the user enters "-1"
            System.out.println("Enter an item name, or \"-1\" to exit.");
            lastInput = scanner.nextLine();
            if (!lastInput.equals("-1")){
                items = items + lastInput + "\n"; // adds the item entered to the end of the items string with a linebreak
            }
        }

        scanner.close();
                             
        System.out.println(calculateTip(people,percent,cost,items));
    }
}
