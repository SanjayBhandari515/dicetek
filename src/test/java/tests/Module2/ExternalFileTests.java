package tests.Module2;

import axiom.pages.Module2.ExternalFile;
import org.testng.annotations.Test;
import tests.SetUp;

import java.io.IOException;

public class ExternalFileTests extends SetUp {

    @Test
    public void readExcelFile() throws IOException {

        ExternalFile externalFile = new ExternalFile();
        externalFile
                .getParticularEmployeeDetails();

    }
}
