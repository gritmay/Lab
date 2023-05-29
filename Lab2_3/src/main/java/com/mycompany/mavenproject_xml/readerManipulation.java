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
public class readerManipulation {
    private importerBuilder builder = new importerBuilder();
    
    public ArrayList<Reactor> importData(String filePath) {
        ArrayList<Reactor> reactorList = new ArrayList<>();
        reactorList = builder.getData(filePath);
        return reactorList;
    }
}
