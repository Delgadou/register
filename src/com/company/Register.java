package com.company;

import java.util.ArrayList;

public class Register {
    private ArrayList<User> users;

    public Register(){
        this.users = new ArrayList<User>();
    }

    public boolean addUser(User user){
        if(findUser(user.getLogin()) >= 0){
            System.out.println("This login is already registered");
            return false;
        }
        this.users.add(user);
        return true;
    }

    public boolean removeUser(User user){
        int foundPosition = findUser(user);
        if(foundPosition < 0){
            System.out.println(user.getLogin() + " was not found.");
            return false;
        }

        this.users.remove(foundPosition);
        System.out.println(user.getLogin() + " was deleted.");
        return true;
    }

    private int findUser(User user){
        return this.users.indexOf(user);
    }

    private int findUser(String userLogin){
        for(int i = 0; i < this.users.size(); i++){
        User user = this.users.get(i);
            if(user.getLogin().equals(userLogin)){
                return i;
            }
        }
        return -1;
    }

    public boolean changeLogin(String currentLogin, String newLogin){
        int findPosition = findUser(currentLogin);
        if(findPosition < 0){
            return false;
        } else if(findUser(newLogin) != -1){
            System.out.println("This login already exist");
            return false;
        }

        this.users.get(findPosition).setLogin(newLogin);
        return true;
    }

    public boolean changePassword(String login, String currentPassword, String newPassword){
        int findPosition = findUser(login);
        if(findPosition < 0){
            System.out.println(login + " was not found.");
            return false;
        }
        if(!checkPassword(findPosition, currentPassword)){
            System.out.println("The password typed is wrong");
            return false;
        }

        this.users.get(findPosition).setPassword(newPassword);
        return true;
    }

    private boolean checkPassword(int loginPosition,String currentPassword){
        return this.users.get(loginPosition).getPassword().equals(currentPassword);
    }

    public User queryUser(String login){
        int position = findUser(login);
        if(position >= 0){
            return this.users.get(position);
        }
        return null;
    }

    public String queryUser(User user){
        if(findUser(user) >= 0){
            return user.getLogin();
        }
        return null;
    }

    public void printUsers(){
        System.out.println("Users list");
        for(int i = 0; i < this.users.size(); i++){
            System.out.println((i + 1) + ". " +
                    this.users.get(i).getLogin() + " " +
                    this.users.get(i).getPassword());
        }
    }

}
