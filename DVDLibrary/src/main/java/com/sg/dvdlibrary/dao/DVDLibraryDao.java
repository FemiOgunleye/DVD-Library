/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author TheFemiFactor
 */
public interface DVDLibraryDao {
    
    /**
     * Adds a DVD to the Library and associates it with the title.
     * If there is already a DVD with that name it will return the DVD object, 
     * otherwise it will return null.
     * @param title title with which dvd will be associated with
     * @param dvd dvd to be added to library
     * @return the dvd associated with the title, if none exists then a null dvd
     */
    DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException, ParseException;
    
    
    /**
     * Removes the dvd associated with the title from the library.
     * Returns the dvd object that is being removed or null if there is no dvd
     * associated with the given title
     * @param title title of dvd to be removed
     * @return DVD object that was removed or null if no dvd was associated with
     * the given title
     */
    DVD removeDVD(String title) throws DVDLibraryDaoException, ParseException;
    
    /**
     * Edits the dvd object associated with a preexisting title. Returns null if
     * it doesn't exist.
     * @param title title dvd is associated with
     * @param dvd DVD object to be modified
     * @return 
     */
    DVD editDVD(String title, DVD dvd) throws DVDLibraryDaoException, ParseException;
    
    /**
     * Returns a String array containing all dvds in the library
     * 
     * @return String array containing titles of all dvds in the library
     */
    List<DVD> getAllDVDs() throws DVDLibraryDaoException, ParseException;
    
    
    /**
     * Returns the dvd object associated with the given id. Returns null if no
     * such dvd exists
     * @param title title of dvd to retrieve
     * @return return the DVD object associated with the title and null if none
     */
    DVD displayDVD(String title) throws DVDLibraryDaoException, ParseException;
       
}
