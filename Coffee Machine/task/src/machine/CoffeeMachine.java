package machine;

import java.util.Scanner;

enum ActionMachine {
    CHOOSING_ACTION,
    CHOOSING_COFFEE,
    FILLING_WATER,
    FILLING_MILK,
    FILLING_BEANS,
    FILLING_CUPS
}

enum TypeCoffee {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);
    int water;
    int milk;
    int beans;
    int price;

    TypeCoffee(int water, int milk, int beans, int price) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.price = price;
    }
}

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine coffeeMachine = new Machine(400, 540, 120, 9, 550);
        String action;
        do {
            coffeeMachine.menu();
            action = scanner.next();
            coffeeMachine.actionMachine(action);
        } while (scanner.hasNextLine() && !action.toLowerCase().equals("exit"));
    }
}

class Machine {
    int water, milk, beans, cups, money;
    int minWater = 0;
    int minMilk = 0;
    int minBeans = 0;
    ActionMachine statusMachine;

    public Machine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
        this.statusMachine = ActionMachine.CHOOSING_ACTION;

    }

    public void menu() {
        switch (statusMachine) {
            case CHOOSING_ACTION:
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                break;
            case CHOOSING_COFFEE:
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino,  back - to main menu ");
                break;
            case FILLING_WATER:
                System.out.println("Write how many ml of water do you want to add: ");
                break;
            case FILLING_MILK:
                System.out.println("Write how many ml of milk do you want to add:");
                break;
            case FILLING_BEANS:
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                break;
            case FILLING_CUPS:
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                break;
        }
    }

    public void actionMachine(String action) {
        switch (statusMachine) {
            case CHOOSING_ACTION:
                switch (action) {
                    case "buy":
                        statusMachine = ActionMachine.CHOOSING_COFFEE;
                        break;
                    case "fill":
                        statusMachine = ActionMachine.FILLING_WATER;
                        break;
                    case "take":
                        takeMoney();
                        break;
                    case "remaining":
                        printRemaining(water, milk, beans, cups, money);
                        break;
                }
                break;
            case CHOOSING_COFFEE:
                switch (action) {
                    case "1":
                        minWater = water / TypeCoffee.ESPRESSO.water;
                        minBeans = beans / TypeCoffee.ESPRESSO.beans;
                        int minCups = Math.min(minWater, minBeans);
                        if (minCups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water = water - TypeCoffee.ESPRESSO.water;
                            beans = beans - TypeCoffee.ESPRESSO.beans;
                            cups = cups - 1;
                            money = money + TypeCoffee.ESPRESSO.price;
                        } else {
                            if (water < TypeCoffee.ESPRESSO.water) {
                                System.out.println("Sorry, not enough water!");
                            }
                            if (beans < TypeCoffee.ESPRESSO.beans) {
                                System.out.println("Sorry, not enough coffee beans!");
                            }
                            if (cups <= 0) {
                                System.out.println("Sorry, not enough disposable cups!");
                            }
                        }
                        statusMachine = ActionMachine.CHOOSING_ACTION;
                        break;
                    case "2":
                        minWater = water / TypeCoffee.LATTE.water;
                        minMilk = milk / TypeCoffee.LATTE.milk;
                        minBeans = beans / TypeCoffee.LATTE.beans;
                        minCups = Math.min(minWater, Math.min(minMilk, minBeans));
                        if (minCups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water = water - TypeCoffee.LATTE.water;
                            milk = milk - TypeCoffee.LATTE.milk;
                            beans = beans - TypeCoffee.LATTE.beans;
                            cups = cups - 1;
                            money = money + TypeCoffee.LATTE.price;
                        } else {
                            if (water < TypeCoffee.LATTE.water) {
                                System.out.println("Sorry, not enough water!");
                            }
                            if (milk < TypeCoffee.LATTE.milk) {
                                System.out.println("Sorry, not enough milk!");
                            }
                            if (beans < TypeCoffee.LATTE.beans) {
                                System.out.println("Sorry, not enough coffee beans!");
                            }
                            if (cups <= 0) {
                                System.out.println("Sorry, not enough disposable cups!");
                            }
                        }
                        statusMachine = ActionMachine.CHOOSING_ACTION;
                        break;
                    case "3":
                        minWater = water / TypeCoffee.CAPPUCCINO.water;
                        minMilk = milk / TypeCoffee.CAPPUCCINO.milk;
                        minBeans = beans / TypeCoffee.CAPPUCCINO.beans;
                        minCups = Math.min(minWater, Math.min(minMilk, minBeans));
                        if (minCups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water = water - TypeCoffee.CAPPUCCINO.water;
                            milk = milk - TypeCoffee.CAPPUCCINO.milk;
                            beans = beans - TypeCoffee.CAPPUCCINO.beans;
                            cups = cups - 1;
                            money = money + TypeCoffee.CAPPUCCINO.price;
                        } else {
                            if (water < TypeCoffee.CAPPUCCINO.water) {
                                System.out.println("Sorry, not enough water!");
                            }
                            if (milk < TypeCoffee.CAPPUCCINO.milk) {
                                System.out.println("Sorry, not enough milk!");
                            }
                            if (beans < TypeCoffee.CAPPUCCINO.beans) {
                                System.out.println("Sorry, not enough coffee beans!");
                            }
                            if (cups <= 0) {
                                System.out.println("Sorry, not enough disposable cups!");
                            }
                        }
                        statusMachine = ActionMachine.CHOOSING_ACTION;
                        break;
                    case "back":
                        statusMachine = ActionMachine.CHOOSING_ACTION;
                        break;
                }
                break;
            case FILLING_WATER:
                water = water + Integer.valueOf(action);
                statusMachine = ActionMachine.FILLING_MILK;
                break;
            case FILLING_MILK:
                milk = milk + Integer.valueOf(action);
                statusMachine = ActionMachine.FILLING_BEANS;
                break;
            case FILLING_BEANS:
                beans = beans + Integer.valueOf(action);
                statusMachine = ActionMachine.FILLING_CUPS;
                break;
            case FILLING_CUPS:
                cups = cups + Integer.valueOf(action);
                statusMachine = ActionMachine.CHOOSING_ACTION;
                break;
        }
    }

    public void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void printRemaining(int water, int milk, int beans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

}