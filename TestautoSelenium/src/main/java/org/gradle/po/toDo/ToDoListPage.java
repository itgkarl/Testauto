package org.gradle.po.toDo;

import org.gradle.po.Control;
import org.gradle.po.ToDoPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToDoListPage extends ToDoPageObject {

	public Control bNew = control(by.id("bNew"));

	public ToDoListPage(WebDriver driver) {
		super();
		super.driver = driver;
	}

	public ToDoNewPage clickBNew() {
		bNew.click();
		return new ToDoNewPage(super.driver);
	}
	
	public String getTitleOfLastEntry(){
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement title = super.driver.findElement(by.xpath("//table/tbody/tr[last()]/td[2]"));
		return title.getText();
	}
	
	public String getNotesOfLastEntry(){
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement title = super.driver.findElement(by.xpath("//table/tbody/tr[last()]/td[3]"));
		return title.getText();
	}

}
