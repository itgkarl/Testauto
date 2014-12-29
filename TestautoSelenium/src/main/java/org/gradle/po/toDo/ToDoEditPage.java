package org.gradle.po.toDo;

import org.gradle.po.Control;
import org.gradle.po.ToDoPageObject;
import org.openqa.selenium.WebDriver;

public class ToDoEditPage extends ToDoPageObject {

	Control iTitle = control(by.input("todo_title"));
	Control iNotes = control(by.input("todo_notes"));

	Control bUpdateToDo = control(by.button("Update Todo"));

	public ToDoEditPage(WebDriver driver) {
		super();
		super.driver = driver;
	}

	public ToDoEditPage setTitle(String title) {
		iTitle.set(title);
		return this;
	}

	public ToDoEditPage setNotes(String notes) {
		iNotes.set(notes);
		return this;
	}

	public ToDoShowPage clickUpdateToDo() {
		bUpdateToDo.click();
		return new ToDoShowPage(super.driver);
	}

}
