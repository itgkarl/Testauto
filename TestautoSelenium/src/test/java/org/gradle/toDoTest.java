package org.gradle;

import static org.junit.Assert.assertEquals;

import org.gradle.config.Config;
import org.gradle.po.ToDoPageObject;
import org.gradle.po.toDo.ToDoListPage;
import org.gradle.po.toDo.ToDoNewPage;
import org.gradle.po.toDo.WelcomePage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class, loader = AnnotationConfigContextLoader.class)
public class toDoTest {

	@Autowired
	ToDoPageObject toDoPageObject;


	@Test
	public void createNewEntry() throws InterruptedException {
		final String TITLE = "title1";
		final String NOTES = "note1";
		
		WelcomePage welcomePage = toDoPageObject.starteVorgang().clickAToDoApp();
		
		ToDoListPage toDoListPage = welcomePage.clickEnter();
		
		ToDoNewPage toDoNewPage = toDoListPage.clickBNew();
		toDoNewPage.setTitle(TITLE).setNotes(NOTES);
		
		toDoListPage = toDoNewPage.clickCreateToDo().clickBack();
		

		assertEquals(toDoListPage.getTitleOfLastEntry(), TITLE);
		assertEquals(toDoListPage.getNotesOfLastEntry(), NOTES);
	}
	
	@After
	public void tearDown(){
		toDoPageObject.getDriver().quit();
	}
}
