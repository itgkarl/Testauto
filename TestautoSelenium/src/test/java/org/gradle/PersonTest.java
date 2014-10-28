package org.gradle;

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
import org.gradle.config.*;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class, loader=AnnotationConfigContextLoader.class)
public class PersonTest {
	@Autowired
	Person person;
	
    @Test
    public void canConstructAPersonWithAName() {
        assertEquals("Larry", person.getName());
    }
    
    @Test
    public void test() throws InterruptedException {
    	 // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new FirefoxDriver();


        // And now use this to visit Google
        driver.get("localhost:3000/welcome/index");
        

        // Find the text input element by its name
        WebElement element = driver.findElement(By.id("bEnter"));

        // Enter something to search for
        element.click();;

       Thread.sleep(100000);

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        
        driver.quit();

    }
}
