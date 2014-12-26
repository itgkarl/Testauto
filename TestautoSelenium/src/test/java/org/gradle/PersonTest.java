package org.gradle;

import org.gradle.config.Config;
import org.gradle.po.toDo.ToDoListPage;
import org.gradle.po.toDo.WelcomePage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class, loader = AnnotationConfigContextLoader.class)
public class PersonTest {
	@Autowired
	Person person;

	@Autowired
	WebDriver webDriver;
	
	@Autowired
	WelcomePage welcomePage;

	@Test
	public void canConstructAPersonWithAName() {
		assertEquals("Larry", person.getName());
	}

	@Test
	public void test() throws InterruptedException {
		// Create a new instance of the html unit driver
		// Notice that the remainder of the code relies on the interface,
		// not the implementation.
		// And now use this to visit Google

		ToDoListPage toDoListPage = welcomePage.clickEnter();
		

		Thread.sleep(1000);
		
		welcomePage = toDoListPage.clickAToDoApp();

		Thread.sleep(10000);
		// Check the title of the page
		System.out.println("Page title is: " + webDriver.getTitle());

		webDriver.quit();

	}
}
