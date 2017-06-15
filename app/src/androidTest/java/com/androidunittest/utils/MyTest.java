package com.androidunittest.utils;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 */
@RunWith(AndroidJUnit4.class)
public class MyTest {

    @Test
    public void testRead(){
        Context targetContext = InstrumentationRegistry.getTargetContext();
       // ReadContantsEngine.readContants(targetContext);
        ReadContantsEngine.getAppsToJson(targetContext);
    }
}
