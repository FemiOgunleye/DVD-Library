/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author TheFemiFactor
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    
    private Map<String, DVD> dvds = new HashMap<>();
    public static final String LIBRARY_FILE = "roster.txt";
    public static final String DELIMETER = "::";    // tsv and csv
    
    private void loadLibrary() throws DVDLibraryDaoException, ParseException {
        Scanner scanner;
        
        try {
            // Create Scanner for reading the file
            scanner = new Scanner( new BufferedReader 
                        (new FileReader(LIBRARY_FILE)));
        }   catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException("-_- Could not load library data"
                    + " into memory.", e);
        }
        
        // currentLine holds the most recent line read from the file
        String currentLine;
        
        /**currentTokens holds each of the parts of the currentLine after it has
        *been split on our DELIMTER.
        *NOTE FOR APPRENTICES: In our case we use :: as our delimeter. If 
        * currentLine looks like this:
        * 1234::Joe::Smith::Java-September2013
        * then currenTokens will be a string array that looks like this:
        * 
        *   ___________________________________
        *   |    |   |     |                  |
	*   |1234|Joe|Smith|Java-September2013|
	*   |    |   |     |                  |
	*   -----------------------------------
        *    [0]  [1]  [2]         [3]
        **/
        String[] currentTokens;
        
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // student object.
        // Process while we have more lines in the file.
        while(scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMETER);
            
            // Create a new DVD object and put it into the map of students
            // We are going to use the title which is currentTokens[0] as the 
            // map key for the dvd object.
            // We also have to pass the title into the DVD constructor
            DVD currentDVD = new DVD(currentTokens[0]);
            
            // Set remaining values on currentDVD manually
            currentDVD.setReleaseDate(currentTokens[1]);
            currentDVD.setMpaaRating(currentTokens[2]);
            currentDVD.setDirector(currentTokens[3]);
            currentDVD.setStudio(currentTokens[4]);
            currentDVD.setUserNote(currentTokens[5]);
            
            // Put current DVD into the map using title as the key
            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        
        // close scanner
        scanner.close();
    }
    
    /** 
     *  Writes all DVDs in the roster out to a LIBRARY_File. See loadLibrary for
     *  file format.
     * 
     * @throws DVDLibraryDaoException if an error occurs writing to the file
     */
    private void writeLibrary() throws DVDLibraryDaoException, ParseException {
        // Note: We are note handling the IOException - but we are translating 
        // it to an application specific exception and then simply throwing it
        // (ie 'reporting' it) to the code that called us. It is the 
        // responsibility of the calling code to handle any errors that occur.
        
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        }   catch (IOException e) {
            throw new DVDLibraryDaoException (
                "Could not save DVD data.", e);
        }
        
        // Write out the DVD objects to the Library file.
        // Note: We could just grab the student map, get the Collection of 
        // Students and iterate over them but we've already created a method 
        // that gets a List of DVDs so we'll reuse it/
        List<DVD> dvdList = this.getAllDVDs();
        for(DVD currentDVD : dvdList) {
            // write the DVD object to the file
            out.println(currentDVD.getTitle() + DELIMETER
                + currentDVD.getReleaseDate() + DELIMETER
                + currentDVD.getMpaaRating() + DELIMETER
                + currentDVD.getDirector() + DELIMETER
                + currentDVD.getStudio() + DELIMETER
                + currentDVD.getUserNote());
            
            // force PrintWriter to write lines if needed
            out.flush();
        }
        
        out.close();
    }

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException, ParseException {
        DVD newDVD = dvds.put(title, dvd);
        writeLibrary();
        return newDVD;
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException, ParseException {
        DVD removedDVD = dvds.remove(title);
        writeLibrary();
        return removedDVD;
    }

    @Override
    public DVD editDVD(String title, DVD dvd) throws DVDLibraryDaoException, ParseException {
        DVD newDVD = dvds.put(title, dvd);
        writeLibrary();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException, ParseException {
        loadLibrary();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD displayDVD(String title) throws DVDLibraryDaoException, ParseException{
        loadLibrary();
        return dvds.get(title);
    }
    
}
