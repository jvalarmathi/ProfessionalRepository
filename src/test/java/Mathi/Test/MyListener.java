package Mathi.Test;
import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.agiletestware.bumblebee.annotations.config.BumblebeeConfiguration;
import com.agiletestware.bumblebee.annotations.config.BumblebeeeConfigurationFactory;
import com.agiletestware.bumblebee.annotations.testng.TestNGTestContext;
import com.agiletestware.bumblebee.annotations.webdriver.WebDriverTest;

/**
 * {@link ITestListener} implementation. It tries to get {@link RemoteWebDriver}
 * from object which test method is being executed and put some metadata and
 * screenshot (if test fails) to test result.
 *
 * @author Sergey Oplavin
 *
 */
public class MyListener implements ITestListener {

	/**
	 * The name of attribute to get/put {@link TestNGTestContext} from/to test
	 * result {@link ITestResult#getAttribute(String)}.
	 */
	public static final String BUMBLEBEE_TEST_CONTEXT_ATTR_NAME = "BumblebeeTestContext";
	private final BumblebeeConfiguration bumblebeeConfiguration = BumblebeeeConfigurationFactory.getConfiguration();
	private static final Logger LOGGER = Logger.getLogger(MyListener.class);

@Override
	public void onTestSuccess(final ITestResult result) {
		onTestFinish(result, true);
	}

	@Override
	public void onTestFailure(final ITestResult result) {
		onTestFinish(result, true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
		onTestFinish(result, true);
	}

	private void onTestFinish(final ITestResult result, final boolean hasFailed) {
		final TestNGTestContext context = new TestNGTestContext();
		result.setAttribute(BUMBLEBEE_TEST_CONTEXT_ATTR_NAME, context);
		final Object testClassInstance = result.getInstance();
		final String testName = result.getName();
		if (!(testClassInstance instanceof WebDriverTest)) {
			LOGGER.info("Skipping test: " + testName + " because it does not implement " + WebDriverTest.class);
			return;
		}
		final RemoteWebDriver driver = ((WebDriverTest) testClassInstance).getWebDriver();
		if (driver == null) {
			LOGGER.info("Skipping test: " + testName + " because WebDriver is null");
			return;
		}
		final SessionId sessionId = driver.getSessionId();
		if (sessionId != null) {
			context.setSessionId(sessionId.toString());
		}
		//if (hasFailed && bumblebeeConfiguration.isTakeScreenshotOnFail()) {
			//final File screenshot = driver.getScreenshotAs(OutputType.FILE);
			//LOGGER.info("Taking screenshot: " + screenshot.getAbsolutePath());
			//context.setScreenshot(screenshot);
		}

	

	@Override
	public void onTestStart(final ITestResult result) {
	}

	@Override
	public void onTestSkipped(final ITestResult result) {

	}

	@Override
	public void onStart(final ITestContext context) {
	}

	@Override
	public void onFinish(final ITestContext context) {

	}

}
