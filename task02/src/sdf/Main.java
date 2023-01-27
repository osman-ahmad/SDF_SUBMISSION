package sdf;


import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {

        boolean exit = false;

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome");
        
        while (!exit) {
            System.out.print("> ");
            String response = input.nextLine();
            String[] terms = response.trim().split(" ");
            

                switch (terms.length) {
                    case 1:
                        exit = true;
                        break;

                    case 3:
                    double number1 = Double.parseDouble(terms[0]);
                    double number2 = Double.parseDouble(terms[2]);                       
                    double result;   
                        switch (terms[1].trim()) {
                            case "+":
                                result = number1 + number2;
                                System.out.println(result);
                                break;
                             
                            case "-":
                                result = number1 - number2;
                                System.out.println(result);
                                break;

                            case "/":
                                result = number1 / number2;
                                System.out.println(result);
                                break;

                            case "*":
                                result = number1 * number2;
                                System.out.println(result);
                                break;

                            default:
                                System.out.println("Invalid operators: Please use only (+ , - , / , *)");// ignore
                                                                                                         // everything
                                                                                                         // else
                        }

                    default:

                }
            
        }

        input.close();
    }
}
