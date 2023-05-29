package com.mycompany.mavenproject_xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class readerXML implements Reader {
//    public String path = "";
    public ArrayList<Reactor> reactList = new ArrayList();

//    public  readerXML(String path) {
//        this.path = path;
//
//    }


    Reactor realCurrentReactor;

    @Override
    public ArrayList<Reactor> readFile(String path)
    {


        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            Document doc = db.parse(new File(path));
            NodeList list = doc.getElementsByTagName("reactor");
            
            
            for (int i = 0; i < list.getLength(); i++) {
                this.realCurrentReactor = new Reactor(); ;
                
                Node node = list.item(i);
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element element = (Element) node;
                    
                    // get info
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    Float burnup = Float.parseFloat( element.getElementsByTagName("burnup").item(0).getTextContent());
                    Float kpd = Float.parseFloat( element.getElementsByTagName("kpd").item(0).getTextContent());
                    Float enrichment = Float.parseFloat( element.getElementsByTagName("enrichment").item(0).getTextContent());
                    Float termal_capacity = Float.parseFloat( element.getElementsByTagName("termal_capacity").item(0).getTextContent());
                    Float electrical_capacity = Float.parseFloat( element.getElementsByTagName("electrical_capacity").item(0).getTextContent());
                    Float life_time = Float.parseFloat( element.getElementsByTagName("life_time").item(0).getTextContent());
                    Float first_load = Float.parseFloat( element.getElementsByTagName("first_load").item(0).getTextContent());
                    
                    
                    
                    //System.out.println("name = " + name);
                    realCurrentReactor.setName(name);
                    realCurrentReactor.setSource("XML");
                    realCurrentReactor.setBurnup(burnup);
                    realCurrentReactor.setKpd(kpd);
                    realCurrentReactor.setEnrichment(enrichment);
                    realCurrentReactor.setTermal_capacity(termal_capacity);
                    realCurrentReactor.setElectrical_capacity(electrical_capacity);
                    realCurrentReactor.setLife_time(life_time);
                    realCurrentReactor.setFirst_load(first_load);
                    
                }
                
                reactList.add(realCurrentReactor);
            }
            return reactList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//        @Override
//        public List<Reactor> getReactors(){
//
//            return this.reactList;
//        }
//    public void getInfoFile(){
//
//
//        System.out.println("LIST SIZE = " + reactList.size());
//
//        System.out.println("*****");
//        for(int i =0; i < reactList.size(); i++){
//            Reactor react =  (Reactor)reactList.get(i);
//            System.out.println(react.getName());
//            System.out.println(react.getBurnup());
//            System.out.println(react.getKpd());
//            System.out.println(react.getEnrichment());
//            System.out.println(react.getTermal_capacity());
//            System.out.println(react.getFirst_load());
//
//        }
//    }

}
