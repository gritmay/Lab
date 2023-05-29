package com.mycompany.mavenproject_xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Reader {



    public ArrayList<Reactor> readFile(String path);
//    public List<Reactor> getReactors();


}

