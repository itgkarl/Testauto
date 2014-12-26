package org.gradle.po.toDo;

import org.gradle.po.Control;
import org.gradle.po.PageObject;

public class WelcomePage extends PageObject {

	Control bEnter = control(by.link("bEnter"));
	
	public ToDoListPage clickEnter(){
		bEnter.click();
		return new ToDoListPage(super.driver);
	}
	
}
