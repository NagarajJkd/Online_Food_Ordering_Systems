package com.OFOS.testscript;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.OFOS.generic.BaseClass;

public class Trail extends BaseClass{
	
	@Test
	public void trailTest() {
		Reporter.log("Trail is successfully completed", true);
	}

}
