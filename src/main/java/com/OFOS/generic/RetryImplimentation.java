package com.OFOS.generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplimentation implements IRetryAnalyzer{

	public boolean retry(ITestResult result) {

		int count=0;
		int limit=4;
		if (count<=limit) {
			count++;
			return true;
		}
		
		
		return false;
	}

}
