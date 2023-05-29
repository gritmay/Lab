
package com.mycompany.mavenproject_xml.Excel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CreatorSQL extends ConnectionRunners{
    
    String mode = "auto";
    String drop_SQL = "DROP TABLE IF EXISTS public.reactors;"
    + "DROP TABLE IF EXISTS public.regions CASCADE;"
    + "DROP TABLE IF EXISTS public.countries CASCADE;" 
    + "DROP TABLE IF EXISTS public.companies CASCADE;"
    + "DROP TABLE IF EXISTS public.sites CASCADE;"
    + "DROP TABLE IF EXISTS public.units CASCADE;"
    +"DROP TABLE IF EXISTS public.aggregation_countries;"
    +"DROP TABLE IF EXISTS public.aggregation_companies;"
    +"DROP TABLE IF EXISTS public.aggregation_regions;";
    String unprepared_SQL = "CREATE TABLE public.reactors\n" +            
    "(\n" +
    "	id INTEGER PRIMARY KEY,\n" +
    "	name VARCHAR,\n" +
    "	burnup DECIMAL,\n" +
    "	kpd DECIMAL,\n" +
    "	enrichment DECIMAL,\n" +
    "   electrical_capacity INTEGER,\n" +
    "	termal_capacity INTEGER,\n" +
    "	life_time INTEGER,\n" +
    "	first_load DECIMAL\n" +
    ");" 
    + "CREATE TABLE public.regions\n" +
    "(\n" +
    "	id INTEGER PRIMARY KEY,\n" +
    "	region_name VARCHAR\n" +
    ");"
    + "CREATE TABLE public.countries\n" +
    "(\n" +
    "	id INTEGER PRIMARY KEY,\n" +
    "	country_name VARCHAR,\n" +
    "	subregion VARCHAR,\n" +
    "	region VARCHAR,\n" +
    "	region_id INTEGER REFERENCES regions (id)\n" +
    ");"
    + "CREATE TABLE public.companies\n" +
    "(\n" +
    "	id INTEGER PRIMARY KEY,\n" +
    "	companies_name VARCHAR,\n" +
    "	full_name VARCHAR,\n" +
    "	country_id INTEGER REFERENCES countries (id)\n" +
    ");"
    + "CREATE TABLE public.sites\n" +
    "(\n" +
    "	id INTEGER PRIMARY KEY,\n" +
    "	npp_name VARCHAR,\n" +
    "	place INTEGER REFERENCES countries (id),\n" +
    "   owner_id INTEGER,\n" +
    "	operator INTEGER REFERENCES companies (id),\n" +
    "   builder INTEGER\n" +
    ");" 
    + "CREATE TABLE public.units\n" +
    "(\n" +
    "	id INTEGER PRIMARY KEY,\n" +
    "	code VARCHAR,\n" +
    "	unit_name VARCHAR,\n" +
    "	site INTEGER ,\n" +
    "	status VARCHAR,\n" +
    "	type VARCHAR,\n" +
    "	model VARCHAR,\n" +
    "	class VARCHAR,\n" +
    "	ru_design VARCHAR,\n" +
    "	operator INTEGER,\n" +
    "	nsss_supplier INTEGER,\n" +
    "	thermal_capacity INTEGER,\n" +
    "	gross_capacity INTEGER,\n" +
    "	net_capacity INTEGER,\n" +
    "	construction_start DATE,\n" +
    "	commercial_operation DATE,\n" +
    "	date_shutdown DATE,\n" +
    "	enrichment DECIMAL,\n" +
    "	load_factor INTEGER\n" +
    ");";
    String update_SQL = "ALTER TABLE public.units\n" +
    "ADD burnup DECIMAL, \n" +
    "ADD first_load DECIMAL;" +
    "UPDATE public.units\n" +
    "SET burnup = reactors.burnup, first_load = reactors.first_load FROM reactors\n" +
    "WHERE reactors.name = units.class;" +
    "UPDATE public.units\n" +
    "SET load_factor = 90\n" +
    "WHERE load_factor IS NULL;" +
    "ALTER TABLE public.units\n" +
    "ADD yearly_p DECIMAL;" +
    "UPDATE public.units\n" +
    "SET yearly_p = ( 365 * units.thermal_capacity * units.load_factor )/ (100 * 1000 * units.burnup)\n" +
    "WHERE EXTRACT(YEAR FROM units.commercial_operation) <> '2023' AND units.status = 'in operation';" +
    "UPDATE public.units\n" +
    "SET yearly_p = units.first_load\n" +
    "WHERE EXTRACT(YEAR FROM units.commercial_operation) = '2023' AND units.status = 'in operation';";
    String agreg1 = "CREATE TABLE IF NOT EXISTS public.aggregation_countries AS\n" +
    "(\n" +
    "SELECT country_name as \"Страна\", SUM(yearly_P) as \"Объем ежегодного потребления,т.\"  \n" +
    "FROM public.units RIGHT JOIN public.sites ON units.site = sites.id\n" +
    "RIGHT JOIN public.countries ON sites.place = countries.id\n" +
    "GROUP BY country_name\n" +
    "ORDER BY country_name\n" +
    ");";
    String agreg2 = "CREATE TABLE IF NOT EXISTS public.aggregation_companies AS\n" +
    "(\n" +
    "SELECT companies_name as \"Компания\", SUM(yearly_P) as \"Объем ежегодного потребления,т.\"  \n" +
    "FROM public.units RIGHT JOIN public.sites ON units.site = sites.id\n" +
    "RIGHT JOIN public.companies ON sites.operator = companies.id\n" +
    "GROUP BY companies_name\n" +
    "ORDER BY companies_name\n" +
    ");";
    String agreg3 = "CREATE TABLE IF NOT EXISTS public.aggregation_regions AS\n" +
    "(\n" +
    "SELECT region_name as \"Регион\", SUM(yearly_P) as \"Объем ежегодного потребления,т.\"  \n" +
    "FROM public.units RIGHT JOIN public.sites ON units.site = sites.id\n" +
    "RIGHT JOIN public.countries ON sites.place = countries.id\n" +
    "RIGHT JOIN public.regions ON countries.region_id = regions.id\n" +
    "GROUP BY region_name\n" +
    "ORDER BY region_name\n" +
    ");";
    
    public CreatorSQL(String mode){
      this.mode = mode;
        
    }
    
     public CreatorSQL(){    }
      
    @Override
     public void run(){
        try {
            // different realisation depends on Creator or Inserter are running
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            
            /*
            dont need a preparator unprepared_SQL = prepared sql
            */
            Statement stmt = engine.createStatement();
            
            String query = this.unprepared_SQL;
            stmt.execute(query);
            engine.close();
        } catch (SQLException ex) {
            Logger.getLogger(CreatorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void dropSQL()
    {
        try {
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            Statement stmt = engine.createStatement();
            String query = this.drop_SQL;
            stmt.execute(query);
            engine.close();
        } catch (SQLException ex) {
            Logger.getLogger(CreatorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void calc()
    {
        try {
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            Statement stmt = engine.createStatement();
            String query = this.update_SQL;
            stmt.execute(query);
            engine.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog (null, "Вычисления уже произведены или таблиц не существует", "Oшибка", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void agreg(Integer q)
    {
        try {
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            Statement stmt = engine.createStatement();
            String query = null;
            switch(q)
            {
                case 1: 
                {
                    query = this.agreg1;
                    break;
                }
                case 2: 
                {
                    query = this.agreg2;
                    break;
                }
                case 3: 
                {
                    query = this.agreg3;
                    break;
                }
            }
            stmt.execute(query);
            engine.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog (null, "Проблемы с агрегацией(возможно не сделаны вычисления)", "Oшибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}
