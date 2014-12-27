package org.gradle.po.toDo;

import org.gradle.po.Control;
import org.gradle.po.ToDoPageObject;
import org.openqa.selenium.WebDriver;

public class ToDoShowPage extends ToDoPageObject {

	Control bBack = control(by.link("bBack"));

	public ToDoShowPage(WebDriver driver) {
		super();
		super.driver = driver;
	}


	public ToDoListPage clickBack() {
		bBack.click();
		return new ToDoListPage(super.driver);
	}

}
