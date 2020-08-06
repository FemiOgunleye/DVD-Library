/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TheFemiFactor
 */
public class DVD {
    
    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String director;
    private String studio;
    private String userNote;
    
    public DVD(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) throws DateTimeParseException {
        LocalDate date1 = null;
        
        try {
        DateTimeFormatter formatter1 =
                      DateTimeFormatter.ofPattern("MMM d yyyy");
        date1 = LocalDate.parse( releaseDate , formatter1 );
            
        this.releaseDate = ("" + date1);
        }
        catch (DateTimeParseException e) {
            System.out.println("Please enter the date with format: MMM D YYYY");
}
        this.releaseDate = ("" + date1);
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        int rate = 0;
        
        try {
        
            rate = Integer.parseInt(mpaaRating);
        
        } catch (NumberFormatException e) { 
        System.out.println("Please enter a number for the rating.");
        
    }
        String rateString = ("" + rate);
                
        this.mpaaRating = rateString;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
    
    
    
    
}
