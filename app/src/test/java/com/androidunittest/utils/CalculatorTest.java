package com.androidunittest.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @Before使用该注释来指定一个包含测试设置操作的代码块。测试类调用这个代码块在每个测试之前
 * @After这个注释指定一个包含测试的代码块销毁操作,安卓测试库提供支持,如ActivityTestRule或ServiceTestRule。
 * @Rule:规则允许灵活地添加或重新定义每个测试方法的行为在一个可重用的方法。
 *@BeforeClass:使用该注释来指定为每个测试类静态方法只调用一次。这对于昂贵的测试步骤是有用的操作,比如连接到一个数据库。
 * @AfterClass:使用该注释指定测试类来调用静态方法只有在班里所有的测试运行。这个测试步骤是有用@BeforeClass释放任何资源分配的块。
 * @Test(超时=):一些注释支持通过元素的能力你可以设置值。例如,您可以指定一个超时时间测试
 */
public class CalculatorTest {

    private Calculator mCalculator;

    //使用该注释来指定一个包含测试设置操作的代码块。测试类调用这个代码块在每个测试之前
    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    //这个注释指定一个包含测试的代码块销毁操作
    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void sum() throws Exception {
        assertEquals("result=",7,mCalculator.sum(3,4));
    }
}