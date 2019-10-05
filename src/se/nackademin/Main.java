package se.nackademin;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
    }

    public Main() {
        //det behövs starta fibonaccis sekvens:
        // regeln säger att ett tal är summan av de två föregående talen.
        // Men de första två tal har inte två föregående tal!
        // Man får initiera dem.
        while (true) {
            int limit = input();
            int num1 = 0;
            int num2 = 1;
            JOptionPane.showMessageDialog(null, limit + " = " + fibonacci(limit, num1, num2));
        }//while(true)
    }//Main

    public static double fibonacci(int limit, int num1, int num2) {
        int sum = num1 + num2;
        if (limit == 0)
            return num1;
        else if (limit == 1)
            return num2;
        else if (limit == 2) //{0,1,1...} limit = 2 är den riktiga starten av sekvensen
            return sum;
        else
            return fibonacci((limit-1), num2, sum);
    }//metod fibonacci

    public static int input () {
        int limit=0;
        boolean inputOk = false;
        while(!inputOk) {
        String input = JOptionPane.showInputDialog(null, "limit?");
        if (input == null)
            System.exit(0);

        try {
        limit = Integer.parseInt(input);
         if (limit < 0)
            throw new IllegalArgumentException("invalid value (negativ integer)");
        inputOk = true;
            }
            catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(null, "invalid value (no integer)");
            }
            catch (IllegalArgumentException e2) {
                JOptionPane.showMessageDialog(null, e2.getMessage());
            }
        }//while
        return limit;
    }//metoden input

}//class Main