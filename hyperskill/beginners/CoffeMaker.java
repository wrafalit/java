package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
    
            Scanner scanner = new Scanner(System.in);
        
        // System.out.println("Starting to make a coffee");
        // System.out.println("Grinding coffee beans");
        // System.out.println("Boiling water");
        // System.out.println("Mixing boiled water with crushed coffee beans");
        // System.out.println("Pouring coffee into the cup");
        // System.out.println("Pouring some milk into the cup");
        // System.out.println("Coffee is ready!");
        
        int waterSupplies = 400;
        int milkSupplies = 540;
        int coffeeSupplies = 120;
        int dipsosableCups = 9;
        int money = 550;
        
        boolean coffeOn = true;
        
        
        while (coffeOn) {
            String buyInput = "back";
            
            // Menu coffemaker
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String menuInput = scanner.nextLine();
            
            switch (menuInput) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    buyInput = scanner.nextLine();
                    break;
                case "fill":
                    System.out.println("Write how many ml of water the coffee machine has:");
                    waterSupplies = waterSupplies + scanner.nextInt();
                    System.out.println("Write how many ml of milk the coffee machine has:");
                    milkSupplies = milkSupplies + scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans the coffee machine has:");
                    coffeeSupplies = coffeeSupplies + scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    dipsosableCups = dipsosableCups + scanner.nextInt();
                    break;
                case "take":
                    money = takeMoney(money);
                    break;
                case "remaining":
                    status(waterSupplies, milkSupplies, coffeeSupplies, dipsosableCups, money);
                    break;
                case "exit":
                    coffeOn = false;
                    break;
            }
            
            int water = 0;
            int milk = 0;
            int coffee = 0;
            int cups = 0;
            int cost = 0;
            switch (buyInput) {
                case "1":
                    water = 250;
                    milk = 1;
                    coffee = 16;
                    cups = 1;
                    cost = 4;
                    break;
                case "2":
                    water = 350;
                    milk = 75;
                    coffee = 20;
                    cups = 1;
                    cost = 7;
                    break;
                case "3":
                    water = 200;
                    milk = 100;
                    coffee = 12;
                    cups = 1;
                    cost = 6;
                    break;
                case "back":
                    break;
            }
            
            if (!(buyInput.equals("back"))) {
                    int numberCups = 1;
                    int waterCup = water * numberCups;
                    int milkCup = milk * numberCups;
                    int coffeeCup = coffee * numberCups;
                    int needCup = cups * numberCups;
                    
                    int waterCalc = waterSupplies / water;
                    int milkCalc = milkSupplies / milk;
                    int coffeeCalc = coffeeSupplies / coffee;
                    int cupsCalc = dipsosableCups / cups;
                    
                    // System.out.println(waterCalc + " " + milkCalc + " " + coffeeCalc);
                    int smaller = waterCalc;
                    
                    if (smaller >= waterCalc ) {
                        smaller = waterCalc;
                    } 
                    if (smaller >= milkCalc ) {
                        smaller = milkCalc;
                    } 
                    if (smaller >= coffeeCalc) {
                        smaller = coffeeCalc;
                    }
                    if (smaller >= cupsCalc) {
                        smaller = cupsCalc;
                    }
                    
                     // System.out.println(smaller);    
                if ((smaller == 1) || (numberCups == 0)) {
                    System.out.println("Yes, I can make that amount of coffee");
                    waterSupplies = waterSupplies -water;
                    if (milk > 1) {
                        milkSupplies = milkSupplies -milk;
                    }
                    coffeeSupplies = coffeeSupplies - coffee;
                    dipsosableCups = dipsosableCups - cups;
                    money = money + cost;
                    
                    
                } else if (smaller >1) {
                    int quant = smaller - numberCups;
                    // System.out.println(quant);
                    if (quant >= 0) {
                            System.out.println("Yes, I can make that amount of coffee (and even " + quant +" more than that)");
                            waterSupplies = waterSupplies -water;
                            if (milk > 1) {
                                milkSupplies = milkSupplies -milk;
                            }
                            coffeeSupplies = coffeeSupplies - coffee;
                            dipsosableCups = dipsosableCups - cups;
                            money = money + cost;
                            
                            
                    }  else {
                        System.out.println("No, I can make only " + smaller + " cup(s) of coffee");
                    }
                } else {
                    System.out.println("No, I can make only " + smaller + " cup(s) of coffee");
                    
                }
            }
            
        }
            
        } //while
        

        
        static int takeMoney(int money) {
            System.out.println("I gave you $" + money);
            return money = 0;
        }
        
        static void  status(int waterSupplies, int milkSupplies, int coffeeSupplies, int dipsosableCups, int money) {
            System.out.println();
            System.out.println("The coffee machine has:");
            System.out.println(waterSupplies + " ml of water");
            System.out.println(milkSupplies + " ml of milk");
            System.out.println(coffeeSupplies + " g of coffee beans");
            System.out.println(dipsosableCups + " disposable cups");
            System.out.println("$" + money + " of money");
            System.out.println();
        
      
      
        }
}
