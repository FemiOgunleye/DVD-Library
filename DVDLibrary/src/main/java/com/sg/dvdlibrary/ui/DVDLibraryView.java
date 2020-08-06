/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author TheFemiFactor
 */
public class DVDLibraryView {
    
    private UserIO io;
    
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add a DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit a DVD");
        io.print("4. List all DVDs");
        io.print("5. Search and display DVD");
        io.print("6. Exit");
        
        return io.readInt("Please select from the above choices: ", 1, 6);
    }
    
    // ADD
    public DVD getNewDVDinfo() throws ParseException {
        String title = io.readString("Please enter the DVD title:");
        String releaseDate = io.readString("Please enter the Release Date:");//Try date format here
        String mpaaRating = io.readString("Please enter the MPAA Rating:");
        String director = io.readString("Please enter the Director's name:");
        String studio = io.readString("Please enter the Studio's name:");
        String userNote = io.readString("Please enter a user rating/note");
        
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserNote(userNote);
        
        return currentDVD;
    }
    
    public void displayAddDVDBanner() {
        io.print("=== ADD DVD ===");
    }
    
    public void displayAddDVDSuccess() {
        io.readString(
                "DVD succssefully added. Please hit enter to continue...");
    }
    
    // REMOVE
    public void displayRemoveDVD() {
        io.print("=== Remove DVD ===");
    }
    
    public void displayRemoveSuccessBanner() {
        io.readString(
                "DVD successfully removed. Please hit enter to continue...");
    }
    
    
    // EDIT
    public void displayEditDVDBanner() {
        io.print("=== Edit DVD ===");
    }
    
    public void displayEditSuccessfulBanner() {
        io.readString(
                "DVD successfully edited. Please hit enter to continue...");
    }
    
    
    // LIST
    public void displayDVDList(List<DVD> dvdList) {
        for(DVD currentDVD : dvdList) {
            io.print(currentDVD.getTitle() + ": " 
                    + currentDVD.getReleaseDate() + ": "
                    + currentDVD.getMpaaRating() + ": "
                    + currentDVD.getDirector() + ": "
                    + currentDVD.getStudio() + ": "
                    + currentDVD.getUserNote());
        }
        io.readString("Please hit enter to continue...");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }
    
    // DISPLAY
    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }
    
    public String getDVDTitleChoice() {
        return io.readString("Please enter the DVD title:");
    }
    
    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirector());
            io.print(dvd.getStudio());
            io.print(dvd.getUserNote());
            io.print("");
        }
        else {
            io.print("DVD not found.");
            io.print("Try adding it from the Main Menu.");
        }
        
        io.readString("Please hit enter to continue...");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye.");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!");
    }
    
    public void displayErrorMEssage(String errorMsg) {
        io.print("=== Error ===");
        io.print(errorMsg);
    }
    
    public void displayDVDNotFound() {
        io.print("DVD not found.");
    }
    
}
