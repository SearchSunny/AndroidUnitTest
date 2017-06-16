package com.androidunittest.utils;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *AndroidJUnit4实现单元测试
 */
@RunWith(AndroidJUnit4.class)
public class MyTest {

    @Test
    public void testRead(){
        Context targetContext = InstrumentationRegistry.getTargetContext();
       // ReadJsonEngine.readContants(targetContext);
        ReadJsonEngine.getAppsToJson(targetContext);
    }
}
