package org.gradle.po;

import org.gradle.po.toDo.WelcomePage;
import org.openqa.selenium.WebDriver;

public class ToDoPageObject extends PageObject {

	Control aToDoApp = control(by.link("ToDo-App"));
	
	public ToDoPageObject(WebDriver driver) {
		super();
		super.driver = driver;
	}
	
	public ToDoPageObject() {
		super();
	}

	public ToDoPageObject starteVorgang(){
		driver.get("localhost:3000/welcome/index");
		return this;
	}
	
	public WelcomePage clickAToDoApp() {
		aToDoApp.click();
		return new WelcomePage(driver);
	}

}
