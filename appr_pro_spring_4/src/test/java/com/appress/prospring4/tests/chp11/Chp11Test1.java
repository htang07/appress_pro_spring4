package com.appress.prospring4.tests.chp11;

import static org.junit.Assert.*;

import java.util.concurrent.Future;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring4.ch11.AsyncService;
import com.apress.prospring4.ch11.TaskToExecute;

public class Chp11Test1 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testScheduleTaskSample() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:META-INF/spring/task-namespace-app-context.xml");
		ctx.load("classpath:chp11/spring/task-namespace-app-context-test.xml");
		ctx.refresh();

		while (true) {
		}
	}
	
	@Test
	public void testAsyncTask() {
		 GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	        ctx.load("classpath:chp11/spring/async-app-context.xml");
	        ctx.refresh();

	        AsyncService asyncService = ctx.getBean("asyncService", AsyncService.class);

	        for (int i = 0; i < 5; i++) {
	            asyncService.asyncTask();
	        }

	        Future<String> result1 = asyncService.asyncWithReturn("Chris");
	        Future<String> result2 = asyncService.asyncWithReturn("John");
	        Future<String> result3 = asyncService.asyncWithReturn("Robert");

	        try {
	            Thread.sleep(6000);

	            System.out.println("Result1: " + result1.get());
	            System.out.println("Result2: " + result2.get());
	            System.out.println("Result3: " + result3.get());
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	}
	
	@Test
	public void testTaskExecutorSample() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chp11/spring/simpleAsyncTaskExecutor.xml");
        ctx.refresh();

        TaskToExecute taskToExecute = ctx.getBean(TaskToExecute.class);
        taskToExecute.executeTask();
	}

}
