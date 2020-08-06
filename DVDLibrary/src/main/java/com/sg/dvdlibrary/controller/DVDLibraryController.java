/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author TheFemiFactor
 */
public class DVDLibraryController {
    
    DVDLibraryView view;
    DVDLibraryDao dao;
    
    public DVDLibraryController(DVDLibraryView view, DVDLibraryDao dao) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() throws ParseException {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                
                switch(menuSelection) {
                    case 1:
                        // ADD 
                        addDVD();
                        break;
                    case 2:
                        // REMOVE
                        removeDVD();
                        break;
                    case 3:
                        // EDIT
                        editDVD();
                        break;
                    case 4:
                        // LIST
                        listDVDs();
                        break;
                    case 5:
                        // DISPLAY
                        displayDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                         unknownCommand();
                }
            }
             exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMEssage(e.getMessage());
            
           
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    /**
     * 
     *  private void editDVD() throws DVDLibraryDaoException, ParseException {
        view.displayEditDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.displayDVD(title);
        view.displayDVD(dvd);
        if(dvd != null) {
        dvd = view.getNewDVDinfo();
        view.displayDVD(dvd);
        dao.editDVD(title, dvd);
        view.displayEditSuccessfulBanner();
        }   
    }
     */
    
    private void addDVD() throws DVDLibraryDaoException, ParseException {
        view.displayAddDVDBanner();
        DVD newDVD = view.getNewDVDinfo();
        view.displayDVD(newDVD);
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayAddDVDSuccess();
    }
    
    private void listDVDs() throws DVDLibraryDaoException, ParseException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }
    
    private void displayDVD() throws DVDLibraryDaoException, ParseException {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.displayDVD(title);
        view.displayDVD(dvd);
    }
    
    private void removeDVD() throws DVDLibraryDaoException, ParseException {
        view.displayRemoveDVD();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.displayDVD(title);
        if(dvd != null) {
        dao.removeDVD(title);
        view.displayRemoveSuccessBanner(); 
        }
        else
            view.displayDVDNotFound();
    }
    
    private void editDVD() throws DVDLibraryDaoException, ParseException {
        view.displayEditDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.displayDVD(title);
        view.displayDVD(dvd);
        if(dvd != null) {
        dvd = view.getNewDVDinfo();
        view.displayDVD(dvd);
        dao.editDVD(title, dvd);
        view.displayEditSuccessfulBanner();
        }   
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
}
