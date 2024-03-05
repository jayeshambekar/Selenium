package commonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation  implements ITestListener{
	ExtentReports report;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestStart(result);
//		
//		String methodName = result.getMethod().getMethodName();
//		Reporter.log(methodName+"Testscript execution is started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSuccess(result);
//		String methodName = result.getMethod().getMethodName();
//		Reporter.log(methodName+"Testscript execution is pass",true);
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailure(result);
//		String message = result.getThrowable().toString();
//		String methodName = result.getMethod().getMethodName();
//		Reporter.log(methodName+"Testscript execution is fail"+message ,true);
		  
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSkipped(result);
//		String methodName = result.getMethod().getMethodName();
//		Reporter.log(methodName+"Testscript execution is skip",true);
//		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onStart(context);
//		
//		Reporter.log("Execution is started",true);
		
		
		//Use ExtentSparkReporter class just to configure extent report
		JavaUtil jUtil = new JavaUtil (); 
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report"+jUtil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Pune");
		
		//It use to generate extentreport
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS","Windows");
		report.setSystemInfo("Browser","Chrome");
		report.setSystemInfo("ChromeVersion", "121");
		report.setSystemInfo("Author","Jayesh");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context);
//		Reporter.log("Execution is finished",true);
		report.flush();
	}

	

	}


