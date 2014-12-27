package org.gradle.po.toDo;

import org.gradle.po.Control;
import org.gradle.po.ToDoPageObject;
import org.openqa.selenium.WebDriver;

public class ToDoNewPage extends ToDoPageObject {

	Control iTitle = control(by.input("todo_title"));
	Control iNotes = control(by.input("todo_notes"));

	Control bCreateToDo = control(by.button("Create Todo"));

	public ToDoNewPage(WebDriver driver) {
		super();
		super.driver = driver;
	}

	public ToDoNewPage setTitle(String title) {
		iTitle.set(title);
		return this;
	}

	public ToDoNewPage setNotes(String notes) {
		iNotes.set(notes);
		return this;
	}

	public ToDoShowPage clickCreateToDo() {
		bCreateToDo.click();
		return new ToDoShowPage(super.driver);
	}

}
