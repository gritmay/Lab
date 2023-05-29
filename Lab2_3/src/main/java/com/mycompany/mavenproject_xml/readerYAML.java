    package com.mycompany.mavenproject_xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.yaml.snakeyaml.Yaml;

public class readerYAML implements Reader {

//    public String path = "";
    private ArrayList<Reactor> reactList = new ArrayList();
    
//    public  readerYAML(String path){
//        this.path = path;
//        
//    }
    Reactor currentReactor;
    @Override
    public ArrayList<Reactor> readFile(String path) {
        try {
            InputStream inputStream = null;
            
            Yaml yaml = new Yaml();
            File file = new File(path);
            inputStream = new FileInputStream(file);
            //Map<String, Map<String,Object>> data = yaml.load(inputStream);
            Map<String, Map<String,?>> data = yaml.load(inputStream);
            Iterator iterator = data.keySet().iterator();
            while(iterator.hasNext())
            {
                this.currentReactor = new Reactor();
                Object key = iterator.next();
                Map<String,?> value = data.get(key);
                if(value.containsKey("name"))
                {
                    currentReactor.setName(value.get("name").toString());
                }
                if(value.containsKey("burnup"))
                {
                    currentReactor.setBurnup(Float.parseFloat( value.get("burnup").toString()));
                }
                if(value.containsKey("kpd"))
                {
                    currentReactor.setKpd(Float.parseFloat(value.get("kpd").toString()));
                }
                if(value.containsKey("enrichment"))
                {
                    currentReactor.setEnrichment(Float.parseFloat(value.get("enrichment").toString()));
                }
                if(value.containsKey("termal_capacity"))
                {
                    currentReactor.setTermal_capacity(Float.parseFloat(value.get("termal_capacity").toString()));
                }
                if(value.containsKey("electrical_capacity"))
                {
                    currentReactor.setElectrical_capacity(Float.parseFloat( value.get("electrical_capacity").toString()));
                }
                if(value.containsKey("life_time"))
                {
                    currentReactor.setLife_time(Float.parseFloat(value.get("life_time").toString()));
                }
                if(value.containsKey("first_load"))
                {
                    currentReactor.setFirst_load(Float.parseFloat(value.get("first_load").toString()));
                }
                currentReactor.setSource("YAML");
                
                this.reactList.add( currentReactor);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return reactList;

    }

//    @Override
//    public List<Reactor> getReactors() {
//        return this.reactList;
//    }
//    
//    
//
//    
//        public void getInfoFile(){
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
