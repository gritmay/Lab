/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject_xml;

import java.util.ArrayList;

/**
 *
 * @author Амина
 */
public class ImporterYAML extends Importer{
    public ImporterYAML() 
    {
        setReader(new readerYAML());
    }
    
    @Override
    public ArrayList<Reactor> getReactors(String path) {
        try {
            return getReader().readFile(path);
        } catch (Exception e) {
            return getNeighbour().getReactors(path);
        }
    }
}
