package com.caixm.utils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.caixm.script_app.LoginApp;
import com.caixm.script_app.StartApp;
import com.caixm.script_app.TruckManage;
import com.caixm.script_web.Login;
import com.caixm.script_web.SaleDataCase.SaleOrderManage;
import com.caixm.script_web.WorkPlatformCase;

@RunWith(Suite.class)
/*@SuiteClasses({Driver.class,
	Login.class,WorkPlatformCase.class})
@SuiteClasses({StartApp.class,LoginApp.class,OrderCenter.class})*/
@SuiteClasses({StartApp.class,LoginApp.class,TruckManage.class})

public class TestProcess {

}
