package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Utility {

    public static WebDriver driver;
    public String sheetname;

    // ✅ Launch browser in Incognito mode
    public void browserLaunch() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");               // Launch incognito
        options.addArguments("--start-maximized");         // Maximize window
        options.addArguments("--disable-notifications");   // Optional: block pop-ups

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    // ✅ Close the browser
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ✅ Read data from Excel
    public static String[][] readExcel(String sheetname) throws IOException {
        if (sheetname == null || sheetname.isEmpty()) {
            throw new RuntimeException("Sheet is null or empty, please check the data");
        }

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/data/Swag-labs-data.xlsx");

        try (XSSFWorkbook book = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = book.getSheet(sheetname);
            if (sheet == null) {
                throw new RuntimeException("Sheet not found");
            }

            int rowCount = sheet.getLastRowNum();
            short columnCount = sheet.getRow(0).getLastCellNum();
            String data[][] = new String[rowCount][columnCount];

            for (int i = 1; i <= rowCount; i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) continue;

                for (int j = 0; j < columnCount; j++) {
                    XSSFCell cell = row.getCell(j);
                    data[i - 1][j] = getCellValue(cell);
                }
            }
            return data;
        }
    }

    public static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf((long) cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
