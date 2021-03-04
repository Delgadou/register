package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Register register = new Register();

    public static void main(String[] args) {
        boolean quit = false;
        printActions();

        while(!quit){
            System.out.println("Enter actions: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    register.printUsers();
                    break;
                case 1:
                    addUser();
                    break;
                case 2:
                    removeUser();
                    break;
                case 3:
                    changeLogin();
                    break;
                case 4:
                    changePassword();
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void addUser(){
        System.out.print("Enter new login:");
        String login = scanner.nextLine();
        System.out.print("Enter the password: ");
        String password = scanner.nextLine();

        User newUser = new User(login, password);
        if(register.addUser(newUser)){
            System.out.println("New user added");
        }else {
            System.out.println("An error occurred. Please try again");
        }
    }

    private static void removeUser(){
        System.out.print("Enter an existing login: ");
        String login = scanner.nextLine();

        User existingUser = register.queryUser(login);
        if(existingUser == null){
            System.out.println("Login not found.");
            return;
        }

        register.removeUser(existingUser);
    }

    private static void changeLogin(){
        System.out.print("Enter the current login: ");
        String currentLogin = scanner.nextLine();
        System.out.print("Enter the new login: ");
        String newLogin = scanner.nextLine();

        if(register.changeLogin(currentLogin, newLogin)){
            System.out.println("Login change from " + currentLogin + " to " + newLogin + ".");
        }else {
            System.out.println("No login found. Please try again.");
        }
    }

    private static void changePassword(){
        System.out.print("Enter login: ");
        String login = scanner.nextLine();
        System.out.print("Enter the current password: ");
        String currentPassword = scanner.nextLine();
        System.out.print("Enter the new password: ");
        String newPassword = scanner.nextLine();

        if(register.changePassword(login, currentPassword, newPassword)){
            System.out.println("The password change from " + currentPassword + " to " + newPassword + ".");
        }else {
            System.out.println("Please try again.");
        }
    }

    private static void queryContact(){
        System.out.printf("Enter login: ");
        String login = scanner.nextLine();

        if(register.queryUser(login) == null){
            System.out.printf("Login not found. Please try again.");
            return;
        }

        register.queryUser(login);
    }

    private static void printActions(){
        System.out.println("Options");
        System.out.printf("0 - to show users\n" +
                "1 - to add new user\n" +
                "2 - to remove contact\n" +
                "3 - to change login\n"+
                "4 - to change password\n" +
                "5 - query if an existing contact exists\n" +
                "6 - to print a list of availabe actions.\n");
    }
}

















