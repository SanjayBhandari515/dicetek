package axiom.pages.Module1;

import axiom.framework.common.Requests;
import axiom.framework.pojo.Module1.Datum;
import axiom.framework.pojo.Module1.Employee;
import axiom.pages.AdvancedPage;
import axiom.utils.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
import io.restassured.response.Response;
import org.testng.Assert;

public class APILink extends AdvancedPage {

    public APILink getAPILink(){

        String url = readConfig("employee.details.url");

        Response response = Requests.getRequest(url, contentTypeJson, acceptTypeJson);
        System.out.println("Response code --> "+response.statusCode());
        Assert.assertEquals(response.statusCode(), 200, "Status code doesn't match");

        ExtentTestManager.getTest().log(Status.INFO, "Response body : "+ response.asString());

        Employee employee =
                response.as(Employee.class);

        int counter = 1;
        for(Datum d1 : employee.getData()){
            System.out.println(counter + "--> " + d1.getProfileImage());
            Assert.assertTrue(d1.getProfileImage() == null || d1.getProfileImage() == "", "Profile image is not null or empty");
            counter++;
        }
        return new APILink();
    }
}
