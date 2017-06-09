package com.lnrisk.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lnrisk.demo.controller.UserController;

/**
 * Basic integration tests for service demo application.
 *
 * @author Aravind
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserController.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	@Test
	public void given2XMLS_whenIdentical_thenCorrect() {
	    String controlXml = "<struct><int>3</int><boolean>false</boolean></struct>";
	    String testXml = "<struct><int>3</int><boolean>false</boolean></struct>";
	    //Assert.assertEquals(testXml, CompareMatcher.isIdenticalTo(controlXml));
	}
}
