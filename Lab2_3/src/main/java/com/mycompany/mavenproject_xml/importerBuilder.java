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
public class importerBuilder {
    private Importer ImporterXML;
    private Importer ImporterYAML;
    private Importer ImporterJSON;
    private Importer ImporterNULL;

    public ArrayList<Reactor> getData(String path){
        setParam();
        return ImporterJSON.getReactors(path);
    }

    private void setParam() {
        this.ImporterXML = new ImporterXML();
        this.ImporterYAML = new ImporterYAML();
        this.ImporterJSON = new ImporterJSON();
        this.ImporterNULL = new ImporterNULL();
        System.out.println("I set param");
        ImporterJSON.setNeighbour(ImporterYAML);
        ImporterYAML.setNeighbour(ImporterXML);
        ImporterXML.setNeighbour(ImporterNULL);
    }
}
