package com.mycompany.mavenproject_xml;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class readerJSON implements Reader {

//    protected String path = "";
    protected ArrayList<Reactor> reactList = new ArrayList();



//    public  readerJSON(String path){
//        this.path = path;
//    }

    Reactor realCurrentReactor;

    @Override
    public ArrayList<Reactor> readFile(String path)
    {

        try {
            //ReactorJSON realCurrentReactor = new ReactorJSON();
            File file = new File(path);
            JsonParser jsonParser = new JsonFactory().createParser(file);
            
            
            while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                
                String s =  jsonParser.getCurrentName();
                
                if("name".equals(s)) {
                    this.realCurrentReactor = new Reactor();
                    jsonParser.nextToken();
                    System.out.println("val = " + jsonParser.getValueAsString());
                    realCurrentReactor.setName(jsonParser.getValueAsString());
                    
                } else if ("burnup".equals(s)) {
                    jsonParser.nextToken();
                    // System.out.println("val burnup = " + jsonParser.getFloatValue());
                    realCurrentReactor.setBurnup(jsonParser.getFloatValue());
                    
                    
                } else if ("kpd".equals(s)) {
                    jsonParser.nextToken();
                    realCurrentReactor.setKpd(jsonParser.getFloatValue());
                    
                } else if ("enrichment".equals(s)) {
                    jsonParser.nextToken();
                    realCurrentReactor.setEnrichment(jsonParser.getFloatValue());
                    
                } else if ("termal_capacity".equals(s)) {
                    jsonParser.nextToken();
                    realCurrentReactor.setTermal_capacity(jsonParser.getFloatValue());
                    
                } else if ("electrical_capacity".equals(s)) {
                    
                    jsonParser.nextToken();
                    realCurrentReactor.setElectrical_capacity(jsonParser.getFloatValue());
                    
                } else if ("life_time".equals(s)) {
                    jsonParser.nextToken();
                    realCurrentReactor.setLife_time(jsonParser.getFloatValue());
                    
                }
                else if ("first_load".equals(s)) {
                    jsonParser.nextToken();
                    realCurrentReactor.setFirst_load(jsonParser.getFloatValue());
                    realCurrentReactor.setSource("JSON");
                    reactList.add( realCurrentReactor);
                    // System.out.println("from list item burnUp = " + reactList.get(0).getBurnup());
                    jsonParser.nextToken();
                }
                
                // System.out.println("current token = " + jsonParser.getCurrentToken());
                
                
            }
            
            return reactList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

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
//
//    @Override
//    public  List<Reactor>   getReactors() {
//        return this.reactList;
//    }
}
