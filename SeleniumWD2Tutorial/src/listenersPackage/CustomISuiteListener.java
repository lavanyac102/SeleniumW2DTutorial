package listenersPackage;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class CustomISuiteListener implements ISuiteListener{
	
	public void onStart(ISuite suite) {
	  //when <suite> tag starts
		System.out.println("OnStart:  before suite start");
	  }

	public void onFinish(ISuite suite) {
		//when <suite> tag ends
		System.out.println("OnFinish:  after suite ends");
	  }

}
