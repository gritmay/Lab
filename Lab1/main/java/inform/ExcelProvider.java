package inform;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelProvider {

    private File file;
    private XSSFWorkbook wb;

    public ExcelProvider(String path) {
        setFile(path);
    }

    private void setFile(String path) {
        this.file = new File(path);
    }

    public void openFile() {
        try {
            wb = new XSSFWorkbook(file);
        } catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(ExcelProvider.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getValue(String sheetName) throws IOException {
        Random random = new Random();
        XSSFSheet sheet = this.wb.getSheet(sheetName);
        int rowNumber = random.nextInt(sheet.getLastRowNum() + 1);
        String value = sheet.getRow(rowNumber).getCell(0).getStringCellValue();
        return value;

    }

    public void close() throws IOException {
        this.wb.close();

    }

}
