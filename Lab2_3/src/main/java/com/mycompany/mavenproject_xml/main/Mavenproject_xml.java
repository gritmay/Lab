package com.mycompany.mavenproject_xml.main;

import com.mycompany.mavenproject_xml.Excel.Data2DB;
import com.mycompany.mavenproject_xml.Excel.FixerExcel;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class Mavenproject_xml {



public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, IllegalAccessException {

    Data2DB d = new Data2DB("auto");
    d.StartCreate();
    
        d.StartInsert("ReactorData.xlsx");
       // d.StartInsert(array_reactors);
      

        
        }

    }



