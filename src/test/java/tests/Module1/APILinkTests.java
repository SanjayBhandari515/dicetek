package tests.Module1;

import axiom.pages.Module1.APILink;
import tests.SetUp;
import org.testng.annotations.Test;

public class APILinkTests extends SetUp {

    @Test
    public void getAPILink(){

        APILink apiLink= new APILink();

        apiLink
                .getAPILink();
    }
}
