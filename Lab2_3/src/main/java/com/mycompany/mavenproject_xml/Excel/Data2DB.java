
package com.mycompany.mavenproject_xml.Excel;

import com.mycompany.mavenproject_xml.Reactor;
import java.util.ArrayList;

/*


умеет, используя своих двух рабочих -creator'а и inserter'а 
СОЗДАВАТЬ ТАБЛИЧКИ В БД, 
ДАЛЕЕ ПРОИСХОДИТ ИХ ЗАПОЛНЕНИЕ 

*/

public class Data2DB {

    private InserterSQL inserter;
    private CreatorSQL creator;
    private  String mode = "auto";
    
    
    public  Data2DB(String mode) {
        this.mode = mode;

    }

    public void StartCreate(){
           this.creator = new CreatorSQL(); 
        this.creator.run();
    
    }
    

    public void StartInsert(String sourse){
        
     
        InserterSQL excelInserter = new InserterSQL(this.mode, sourse);
        excelInserter.run();

    }
    
        public void StartInsert(ArrayList<Reactor> sourse){
        InserterSQL OtherInserter = new InserterSQL(this.mode, sourse);
        OtherInserter.run();

    }
    

   
    
    
}
