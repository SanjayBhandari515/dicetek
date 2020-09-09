package axiom.utils.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxTryCount  = 5;

    public boolean retry(ITestResult iTestResult) {
        if(retryCount < maxTryCount){
            retryCount++;
            return true;
        }
        return false;
    }
}
