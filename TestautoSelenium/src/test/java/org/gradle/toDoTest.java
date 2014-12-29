package org.gradle;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.gradle.config.Config;
import org.gradle.po.ToDoPageObject;
import org.gradle.po.toDo.ToDoEditPage;
import org.gradle.po.toDo.ToDoListPage;
import org.gradle.po.toDo.ToDoNewPage;
import org.gradle.po.toDo.WelcomePage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class, loader = AnnotationConfigContextLoader.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class toDoTest {

	@Autowired
	ToDoPageObject toDoPageObject;

	public void setUp(){
		try {
            Process proc = Runtime.getRuntime().exec("rake -f ../Webanwendung/toDo/Rakefile db:setup");
            BufferedReader read = new BufferedReader(new InputStreamReader(
                    proc.getInputStream()));
            try {
                proc.waitFor();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            while (read.ready()) {
                System.out.println(read.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}

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
	
	@Test
	public void updateEntry() throws InterruptedException {
		final String TITLE = "titleUpdated";
		final String NOTES = "noteUpdated";
		
		WelcomePage welcomePage = toDoPageObject.starteVorgang().clickAToDoApp();
		
		ToDoListPage toDoListPage = welcomePage.clickEnter();
		
		ToDoEditPage clickEditLastEntry = toDoListPage.clickEditLastEntry();
		clickEditLastEntry.setTitle(TITLE).setNotes(NOTES);
		
		toDoListPage = clickEditLastEntry.clickUpdateToDo().clickBack();
		

		assertEquals(toDoListPage.getTitleOfLastEntry(), TITLE);
		assertEquals(toDoListPage.getNotesOfLastEntry(), NOTES);
	}
	
}
