/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject_xml.Excel;

/**
 *
 * @author 79509
 */
public abstract class ConnectionRunners {
    
    public SQL_Preparator preparator;
    protected String url = "jdbc:postgresql://dpg-chlqe4jhp8uej73fmgm0-a.frankfurt-postgres.render.com:5432/maxdb";   
   // "postgres://max:gXN16s9z1Be7BZFaWxA2by1qsZcLnI7q@dpg-chlqe4jhp8uej73fmgm0-a.frankfurt-postgres.render.com/maxdb"
    protected  String user = "max";
    protected  String password = "gXN16s9z1Be7BZFaWxA2by1qsZcLnI7q";
    
   
    
    
    public void run(){
    // different realisation depends on Creator or Inserter are running
    
    }
    
    
}
