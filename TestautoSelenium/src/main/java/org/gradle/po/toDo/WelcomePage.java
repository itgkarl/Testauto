package org.gradle.po.toDo;

import org.gradle.po.Control;
import org.gradle.po.PageObject;
import org.gradle.po.ToDoPageObject;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends ToDoPageObject {

	Control bEnter = control(by.link("bEnter"));
	
	
	public WelcomePage(WebDriver driver) {
		super(driver);
	}


	public ToDoListPage clickEnter(){
		bEnter.click();
		return new ToDoListPage(super.driver);
	}
	
}
