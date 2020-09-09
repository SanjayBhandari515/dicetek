package axiom.framework.common;

import com.aventstack.extentreports.Status;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import axiom.utils.report.ExtentTestManager;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import org.apache.commons.io.output.WriterOutputStream;

import static io.restassured.filter.log.RequestLoggingFilter.logRequestTo;

import java.io.PrintStream;
import java.io.StringWriter;


public class Requests {

    public static Response deleteRequest(Headers headers, String url, ContentType contentType, String accept) {

        StringWriter stringWriter = new StringWriter();
        PrintStream captor = new PrintStream(new WriterOutputStream(stringWriter), true);

        EncoderConfig encoderConfig = new EncoderConfig();

        Response response = RestAssured.given()
                .config(RestAssured.config()
                        .encoderConfig(encoderConfig.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .contentType(contentType)
                .headers(headers)
                .accept(accept)
                .filter(logRequestTo(captor))
                .delete(url);

        ExtentTestManager.getTest().log(Status.INFO, stringWriter.toString());
        ExtentTestManager.getTest().log(Status.INFO, "Response code" + response.statusCode());

        return response;
    }

    public static Response getRequest(String url, ContentType contentType, String accept) {

        StringWriter stringWriter = new StringWriter();
        PrintStream captor = new PrintStream(new WriterOutputStream(stringWriter), true);

        EncoderConfig encoderConfig = new EncoderConfig();

        Response response = RestAssured.given()
                .config(RestAssured.config()
                        .encoderConfig(encoderConfig.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .filter(logRequestTo(captor))
                .get(url);

        ExtentTestManager.getTest().log(Status.INFO, stringWriter.toString());
        ExtentTestManager.getTest().log(Status.INFO, "Response code" + response.statusCode());

        return response;
    }

    public static Response postRequest(Headers headers, String url, String body, ContentType contentType, String accept) {

        StringWriter stringWriter = new StringWriter();
        PrintStream captor = new PrintStream(new WriterOutputStream(stringWriter), true);

        EncoderConfig encoderConfig = new EncoderConfig();

        Response response = RestAssured.given()
                .config(RestAssured.config()
                        .encoderConfig(encoderConfig.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .contentType(contentType)
                .headers(headers)
                .accept(accept)
                .body(body)
                .filter(logRequestTo(captor))
                .post(url);

        ExtentTestManager.getTest().log(Status.INFO, stringWriter.toString());
        ExtentTestManager.getTest().log(Status.INFO, "Response code" + response.statusCode());

        return response;
    }
}
