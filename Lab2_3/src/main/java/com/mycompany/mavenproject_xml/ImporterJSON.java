/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject_xml;

import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Амина
 */
public class ImporterJSON extends Importer{
    
    public ImporterJSON() 
    {
        setReader(new readerJSON());
    }
    
    @Override
    public ArrayList<Reactor> getReactors(String path) {
        try {
            System.out.println("get reader JSON");
            return getReader().readFile(path);
        } catch (Exception e) {
            System.out.println("wrong reader");
            return getNeighbour().getReactors(path);
        }
    }
    
}
