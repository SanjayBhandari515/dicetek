package axiom.pages.Module2;

import axiom.framework.common.Requests;
import axiom.framework.pojo.Module2.Employee;
import axiom.pages.AdvancedPage;
import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import axiom.utils.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
import io.restassured.response.Response;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ExternalFile extends AdvancedPage {

    public ExternalFile getParticularEmployeeDetails()throws IOException {

        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\excel\\";
        String fileName = "Employee.xlsx";
        String sheetName = "Sheet1";
        File file =    new File(filePath + fileName);

        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = null;
        workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

        for (int i = 1; i < rowCount+1; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                if(row.getCell(j).getCellType() == Cell.CELL_TYPE_NUMERIC){
                    row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                }
                System.out.print(row.getCell(j).getStringCellValue());
                String employeeId = row.getCell(j).getStringCellValue();
                String url = readConfig("employee.details.url") + employeeId;

                Response response = Requests.getRequest(url, contentTypeJson, acceptTypeJson);
                System.out.println("Response code --> "+response.statusCode());
                Assert.assertEquals(response.statusCode(), 200, "Status code doesn't match");

                ExtentTestManager.getTest().log(Status.INFO, "Response body : "+ response.asString());

                Employee employee =
                        response.as(Employee.class);

                Assert.assertEquals(employee.getMessage(), "Successfully! Record has been fetched.",  "Message doesn't match" );
            }
            System.out.println();
        }
        return new ExternalFile();
    }
}
