package Util;

import Enumiration.Gender;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    static Scanner scanner;

    public static void printMainMenu(){
        System.out.println("1. add costumer:");
        System.out.println("2. give service to costumer:");
        System.out.println("3. view costmer's bill:");
    }

    public static int numberScanner(){
        int number;
        while (true){
            try{
                scanner = new Scanner(System.in);
                number = scanner.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("you should enter number:");
            }
        }
        return number;
    }

    public static String stringScanner(){
        String string = "";
        while (string.isBlank() || string.isEmpty()){
                scanner = new Scanner(System.in);
                string = scanner.next();
        }
        return string;
    }

    public static String lineScanner(){
        String string = "";
        while (string.isBlank() || string.isEmpty()){
            scanner = new Scanner(System.in);
            string = scanner.nextLine();
        }
        return string;
    }

    public static int selectMainMenu(){
        int selection = 0;
        while (selection < 1 || selection > 3){
            selection = numberScanner();
        }
        return selection;
    }

    public static Gender chooseGender(){
        int selection = 0;
        System.out.println("1. Male:");
        System.out.println("2. Female:");
        while (selection < 1 || selection > 2){
            selection = Menu.numberScanner();
        }
        if(selection == 1){
            return Gender.MALE;
        }else {
            return Gender.Female;
        }
    }

}
