package com.mycompany.mavenproject_xml;

import java.lang.reflect.Field;
import java.util.Map;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public  class Reactor {
    String name;
    Float burnup;
    Float kpd;
    Float enrichment;
    Float electrical_capacity;
    Float termal_capacity;
    Float life_time;
    Float first_load;
    String source;
    public void setName(String name) {
        this.name = name;
    }

    public void setBurnup(Float burnup) {
        this.burnup = burnup;
    }

    public void setKpd(Float kpd) {
        this.kpd = kpd;
    }

    public void setEnrichment(Float enrichment) {
        this.enrichment = enrichment;
    }

    public void setElectrical_capacity(Float electrical_capacity) {
        this.electrical_capacity = electrical_capacity;
    }

    public void setTermal_capacity(Float termal_capacity) {
        this.termal_capacity = termal_capacity;
    }

    public void setLife_time(Float life_time) {
        this.life_time = life_time;
    }

    public void setFirst_load(Float first_load) {
        this.first_load = first_load;
    }

    public String getName() {
        return name;
    }

    public Float getBurnup() {
        return burnup;
    }

    public Float getKpd() {
        return kpd;
    }

    public Float getEnrichment() {
        return enrichment;
    }

    public Float getElectrical_capacity() {
        return electrical_capacity;
    }

    public Float getTermal_capacity() {
        return termal_capacity;
    }

    public Float getLife_time() {
        return life_time;
    }

    public Float getFirst_load() {
        return first_load;
    }
    public void setSource(String s){
        this.source = s;

    }
    public String getSource(){
       return this.source;

    }

    public DefaultMutableTreeNode  getNode() throws IllegalAccessException {
        
    DefaultMutableTreeNode rNode = new DefaultMutableTreeNode(this.getName());
  
    
    
    for(Field field : Reactor.class.getDeclaredFields()){
     
        String key = field.getName();
        field.setAccessible(true);
       Object value = field.get(this).toString();
        String record = key + " : " + value;
        rNode.add(new DefaultMutableTreeNode(record));
        int depth = rNode.getDepth();
     
        
    }
    
    
    return rNode;
    
    
    }



}



