package machine;
import java.util.Scanner;

/**
 * @author Chawek
 * Program simulates the coffee machine. The machine starts with
 * fixed resources ( water, milk, coffee beans, cups and money).
 * The user types command to the console. There are 5 commands that
 * user can invoke: buy, fill, take, remaining, exit.
 *
 *
 */
public class CoffeeMachine {

    Scanner scanner = new Scanner(System.in);
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;


    public CoffeeMachine() {
        water = 400 ;
        milk = 540;
        coffeeBeans= 120;
        cups = 9;
        money = 550;
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        boolean working;
        do {
            working = coffeeMachine.machineState();
        } while(working);

    }

    public boolean machineState() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = scanner.nextLine();
        switch (action) {
            case "buy": {
                this.buy();
                break;
            }
            case "fill": {
                this.fill();
                break; }
            case "take": {
                this.take();
                break; }
            case "remaining": {
                this.remaining();
                break; }
            case "exit":
                return false;

        }
        return true;
    }



    private void remaining() {
        System.out.println("The coffee machine has: ");
        System.out.println(water +" of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");

    }

    private void take() {
        System.out.println("I gave you $" + money);
        money = 0;

    }

    private void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();

    }

    private void buy() {

        //For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
        //For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
        //For the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.

        int water = 0;
        int milk = 0;
        int coffeeBeans = 0;
        int money = 0;

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeChoice = scanner.nextLine();
        switch(coffeChoice) {
            case "1": {
                water = 250;
                milk = 0;
                coffeeBeans = 16;
                money = 4;
                break;
            }
            case "2": {
                water = 350;
                milk = 75;
                coffeeBeans = 20;
                money = 7;
                break;
            }
            case "3": {
                water = 200;
                milk = 100;
                coffeeBeans = 12;
                money = 6;
                break;
            }
            case "break": {
                break;
            }
        }
        if (this.water < water) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.coffeeBeans < coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (this.cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= water;
            this.milk -= milk;
            this.coffeeBeans -= coffeeBeans;
            this.cups--;
            this.money += money;
        }
    }
}
