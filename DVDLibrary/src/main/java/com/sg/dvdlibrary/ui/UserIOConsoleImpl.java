/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import java.util.Scanner;
import java.lang.NumberFormatException;

/**
 *
 * @author TheFemiFactor
 */
public class UserIOConsoleImpl implements UserIO {
    Scanner userInput = new Scanner(System.in);

    @Override
    public void print(String prompt) {
     System.out.println(prompt);
    }

    @Override
    public double readDouble(String prompt) {
    System.out.println(prompt);
    String userValue = userInput.nextLine();
    double value = Double.parseDouble(userValue);
     return value;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
    System.out.println(prompt);
    String userValue = userInput.nextLine();
    double value = Double.parseDouble(userValue);
    while(value < min || value > max)
        { System.out.println("Please enter a value between " + min + " and"
                + " " + max); 
            userValue = userInput.nextLine();
            value = Double.parseDouble(userValue);
        }
    return value;

    }

    @Override
    public float readFloat(String prompt) {
    System.out.println(prompt);
    String userValue = userInput.nextLine();
    float value = Float.parseFloat(userValue);
    return value;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
    System.out.println(prompt);
    String userValue = userInput.nextLine();
    float value = Float.parseFloat(userValue);
    while(value < min || value > max)
        { System.out.println("Please enter a value between " + min + " and"
                + " " + max); 
            userValue = userInput.nextLine();
            value = Float.parseFloat(userValue);
        }
    return value;
    }

    @Override
    public int readInt(String prompt) {
    System.out.println(prompt);
    String userValue = userInput.nextLine();
    int value = Integer.parseInt(userValue);
    return value;
    }

    @Override
    public int readInt(String prompt, int min, int max) {

    Scanner userInput;
    String userValue;
    int value = 0;
    
    
    while (true) {
        System.out.println(prompt);
        userInput = new Scanner(System.in);
        userValue = userInput.nextLine();
    try {

    
    value = Integer.parseInt(userValue);
    break;
    
    } catch (NumberFormatException e) { 
        System.out.println("Please enter a number.");
        
    }
    
    }
    
    
    while (value < min || value > max)
        { System.out.println("Please enter a value between " + min + " and"
                + " " + max); 
            userValue = userInput.nextLine();
            value = Integer.parseInt(userValue);
        }
    
    return value;
    }

    @Override
    public long readLong(String prompt) {
    System.out.println(prompt);
    String userValue = userInput.nextLine();
    long value = Long.parseLong(userValue);
    return value;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
    System.out.println(prompt);
    String userValue = userInput.nextLine();
    long value = Long.parseLong(userValue);
    while(value < min || value > max)
        { System.out.println("Please enter a value between " + min + " and"
                + " " + max); 
            userValue = userInput.nextLine();
            value = Long.parseLong(userValue);
        } 
    return value;
    }

    @Override
    public String readString(String prompt) {
    System.out.println(prompt);
    String userValue = userInput.nextLine();
    return userValue;
    }
    
}
