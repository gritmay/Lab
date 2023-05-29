/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject_xml.Excel;

import com.mycompany.mavenproject_xml.Reactor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author 79509
 */
public class SQL_Preparator {
    
    String mode;
    private File f;
    private FileInputStream fis;
    private XSSFWorkbook wb;
    private  String path;
    public PreparedStatement query_prepared = null;
    private ArrayList<Reactor> sourseOther;
    
    
    public SQL_Preparator(String selected_mode, String path){
    this.mode = selected_mode; // prepare Excel or other_source
    this.path = path;

   
    }
    
     public SQL_Preparator(String selected_mode, ArrayList<Reactor> sourseOther){
    this.mode = selected_mode; // prepare Excel or other_source
    
    this.sourseOther = sourseOther;
   
    }
    
    

    public void openFile() throws FileNotFoundException, IOException{
        
        this.f = new File(this.path);
	this.fis = new FileInputStream(this.f);
        this.wb= new XSSFWorkbook(this.fis);
       
        
    }
    
    public void SetWB() throws IOException{
        
    }

    public int getNrows(String sheetName) throws IOException{
        return this.wb.getSheet(sheetName).getPhysicalNumberOfRows();
 
    }
     public int getNcols(String sheetName){
        
        return this.wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
 
    }
    
    public String getValue(String sheetName,int NRow, int NCol) throws IOException{
        //  int nRows = getNrows(sheetName);
        //   int rowNumber = rand.nextInt(this.getNrows(sheetName));
        CellType type = this.wb.getSheet(sheetName).getRow(NRow).getCell(NCol).getCellType();
        
        
        String value = this.wb.getSheet(sheetName).getRow(NRow).getCell(NCol).toString();
        return value;
     
   }
    public void close() throws IOException{
       
        this.wb.close();
    
    }
    
    public PreparedStatement getPreparedSQL_insert(String unprepared_SQL, Connection engine, String table_name) throws IOException, SQLException{
        
    
        if(this.mode.equals("excel")){
            FixerExcel F = new FixerExcel();
            openFile();
            PreparedStatement query_prepared = engine.prepareStatement(unprepared_SQL);
             int nRows = getNrows(table_name);
             int nCols = getNcols(table_name);
             for(int row = 1; row < nRows; row++){
//               System.out.println("N row = " + row);
                 
              for(int col = 0; col < nCols; col++){
      
                  CellType type = this.wb.getSheet(table_name).getRow(row).getCell(col).getCellType();
                  // System.out.println(type);
                  
                  if( (type == CellType.STRING || type == CellType.BOOLEAN) & type != CellType.BLANK){
                      String value = this.wb.getSheet(table_name).getRow(row).getCell(col).toString().trim();
                      
                      String value_fixed =F.fix(value, col);
                     
                    query_prepared.setString(col+1, value_fixed);
                  }
                  
                  if(type == CellType.NUMERIC & col != 0){
                      
                      XSSFCell value = this.wb.getSheet(table_name).getRow(row).getCell(col);

                      if(DateUtil.isCellDateFormatted(value)){
                        //  System.out.println("date found");
                          Date value_date = value.getDateCellValue();
                       //   System.out.println(value_date);
                          query_prepared.setDate(col+1,    new java.sql.Date(value_date.getTime()) );
                         
                      } else{
                          //System.out.println("no date");
                       query_prepared.setDouble(col+1, value.getNumericCellValue());
                      }
                       //System.out.println(value);
                  }
                   if(type == CellType.NUMERIC & col == 0){
                   
                      double value_id = this.wb.getSheet(table_name).getRow(row).getCell(col).getNumericCellValue();
                      // System.out.println(value_id);
                      int value_id_int = (int)value_id;
                       query_prepared.setInt(col+1, value_id_int);
                       
                  }
                   if(type == CellType._NONE || type == CellType.BLANK){
                      XSSFCell value = this.wb.getSheet(table_name).getRow(row).getCell(col);
                       query_prepared.setNull(col+1, java.sql.Types.NULL);
                  }
                   
                   
                    }
              query_prepared.addBatch();
             // System.out.println( query_prepared.toString());
             
             }
             this.query_prepared = query_prepared;
        
        
        }
        if(this.mode.equals("other")){
            System.out.println("START PREPARE JSON");
        // cook from XML files
        PreparedStatement query_prepared = engine.prepareStatement(unprepared_SQL);
        
       /*
        INSERT INTO reactors (id, name, burnup, kpd, enrichment,electrical_capacity, termal_capacity,, life_time, first_load)
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
        */
          int i =0;
    for( Reactor reactor :  this.sourseOther ){
        query_prepared.setInt(1, i);
        String name = reactor.getName().replace("_", "-");
        query_prepared.setString(2, name);
        query_prepared.setDouble(3, reactor.getBurnup());
        query_prepared.setDouble(4, reactor.getKpd());
        query_prepared.setDouble(5, reactor.getEnrichment());
        query_prepared.setDouble(6, reactor.getElectrical_capacity());
        query_prepared.setDouble(7, reactor.getTermal_capacity());
        query_prepared.setDouble(8, reactor.getLife_time());
        query_prepared.setDouble(9, reactor.getFirst_load());
         
        query_prepared.addBatch(); 
         
          i++;
   
             }
            //System.out.println(query_prepared);
     this.query_prepared = query_prepared;
            
       
        }
        
        
    
    return this.query_prepared;
        
    }
    
    
    
    
    
    public String getPreparedSQL_create(String unprepared_SQL, Connection engine){
        
        return null;
    
    }
    
    
}
