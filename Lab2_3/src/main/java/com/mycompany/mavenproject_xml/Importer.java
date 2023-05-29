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
public abstract class Importer {
    private Importer neighbour;
    private Reader reader;

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Importer getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(Importer neighbour) {
        this.neighbour = neighbour;
    }

    public abstract ArrayList<Reactor> getReactors(String path);
}
