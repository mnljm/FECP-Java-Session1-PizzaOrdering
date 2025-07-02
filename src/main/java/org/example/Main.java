package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        int choice = 0;

        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Orders");
        System.out.println("5. Exit");

        while (choice != 5) {
            System.out.print("Choose option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Pizza type: ");
                    String pizzaType = sc.nextLine();
                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    addOrder(pizzas, quantities, pizzaType, quantity);
                    break;
                case 2:
                    System.out.print("Order number to update: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Quantity: ");
                    int newQuantity = sc.nextInt();
                    sc.nextLine();
                    updateOrder(quantities, index-1, newQuantity);
                    break;
                case 3:
                    System.out.println("Order number to remove");
                    index = sc.nextInt();
                    sc.nextLine();
                    removeOrder(pizzas, quantities, index-1);
                    break;
                case 4:
                    printOrders(pizzas, quantities);
                    break;
                case 5:
                    System.out.println("---Thank you!---");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }



        }


    }

    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity){
        if(pizzaType == null || quantity <= 0){
            System.out.println("Invalid inputs.");
        }
        else{
            pizzas.add(pizzaType);
            quantities.add(quantity);
            System.out.println();
        }

    }

    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity){
        try{
            if(newQuantity <= 0){
                System.out.println("Invalid quantity.");
            }
            else{
                quantities.set(index, newQuantity);
                System.out.println();
            }
        }
        catch (Exception e){
            System.out.println("Error: Invalid inputs");
        }

    }
    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index){
        try{
            pizzas.remove(index);
            quantities.remove(index);
            System.out.println();
        }
        catch(Exception e){
            System.out.println("Error: Invalid inputs");
        }

    }
    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities){
        System.out.println("--- Current Orders ---");
        for(int i = 0; i < pizzas.size(); i++){
            System.out.println((i+1) + ". " + pizzas.get(i) + " x " + quantities.get(i));
        }
        System.out.println();
    }

}