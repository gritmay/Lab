package com.mycompany.maven_lab4_stat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelProvider {
    private Calculations calculator = new Calculations();
    private ArrayList<double[]> samples = new ArrayList<>();
    
    public ArrayList<double[]> readFile(String path) throws IOException 
    {
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        ArrayList<Double> z = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(path));
        XSSFSheet sheet = workbook.getSheet("Вариант 4");
        Iterator<Row> iterator = sheet.iterator();

        while (iterator.hasNext()) 
        {
            Row row = iterator.next();
            Cell cellX = row.getCell(0);
            Cell cellY = row.getCell(1);
            Cell cellZ = row.getCell(2);

            if (cellX.getCellType() == CellType.NUMERIC) {
                x.add(cellX.getNumericCellValue());
            }

            if (cellY.getCellType() == CellType.NUMERIC) {
                y.add(cellY.getNumericCellValue());
            }

            if (cellZ.getCellType() == CellType.NUMERIC) {
                z.add(cellZ.getNumericCellValue());
            }
        }

        samples.add(x.stream().mapToDouble(Double::doubleValue).toArray());
        samples.add(y.stream().mapToDouble(Double::doubleValue).toArray());
        samples.add(z.stream().mapToDouble(Double::doubleValue).toArray());
        
        return samples;
    }

    public void writeToFile(String path, ArrayList<ArrayList<Object>> results, double[][] cov_results) throws IOException 
    {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Calculations");

        AtomicInteger rowIndex = new AtomicInteger();
        Row headerRow = sheet.createRow(rowIndex.getAndIncrement());
        headerRow.createCell(0).setCellValue("sample");
        headerRow.createCell(1).setCellValue("geom mean");
        headerRow.createCell(2).setCellValue("mean");
        headerRow.createCell(3).setCellValue("sd");
        headerRow.createCell(4).setCellValue("R");
        headerRow.createCell(5).setCellValue("N");
        headerRow.createCell(6).setCellValue("coeff of variation");
        headerRow.createCell(7).setCellValue("Confidence interval");
        headerRow.createCell(8).setCellValue("var");
        headerRow.createCell(9).setCellValue("min");
        headerRow.createCell(10).setCellValue("max");

        String[] names = {"X","Y","Z"};
        int nameIndex = 0;
        for(int i=0; i<results.size(); i++)
        {
            Row row = sheet.createRow(rowIndex.getAndIncrement());
            row.createCell(0).setCellValue(names[nameIndex]);
            row.createCell(1).setCellValue(String.valueOf(results.get(i).get(0)));
            row.createCell(2).setCellValue(results.get(i).get(1).toString());
            row.createCell(3).setCellValue(results.get(i).get(2).toString());
            row.createCell(4).setCellValue(results.get(i).get(3).toString());
            row.createCell(5).setCellValue( results.get(i).get(4).toString());
            row.createCell(6).setCellValue(results.get(i).get(5).toString());
            row.createCell(7).setCellValue((String.valueOf(results.get(i).get(6))));
            row.createCell(8).setCellValue( results.get(i).get(7).toString());
            row.createCell(9).setCellValue(results.get(i).get(8).toString());
            row.createCell(10).setCellValue(results.get(i).get(9).toString());
            nameIndex++;
        }

        Sheet sheetCov = workbook.createSheet("Covariance matrix");
        Row roww;
        int indRow=0;
        Row row = sheetCov.createRow(indRow);
        row.createCell(0).setCellValue("X");
        row.createCell(1).setCellValue("Y");
        row.createCell(2).setCellValue("Z");
        for(int i=0; i<3; i++)
        {
            indRow++;
            roww = sheetCov.createRow(indRow);
            for(int j=0; j<3; j++)
            {
            roww.createCell(j).setCellValue(cov_results[i][j]);
            }
        }
        workbook.write(new FileOutputStream(path));
        workbook.close();

    }
}
