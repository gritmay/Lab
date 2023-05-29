/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject_xml.Excel;

/**
 *
 * @author 79509
 */
public class FixerExcel {
    
    
    public String fix(String value, int col){
        String value_ = value;
      
        if(value.equals("AGR") & col == 7){
        value_ = "MAGNOX";
        return value_;
        }
        if(value.equals( "CNP-1000") & col == 7){
         value_ = "CPR-1000";
        return value_;
        }
        if(value.indexOf("PWR") != -1){
            value_ = "PWR";
        return value_;
        }
        if(value.indexOf("VVER") != -1){
            value_ = "VVER-1000";
        return value_;
        }
    return value_;
    }
    
}
