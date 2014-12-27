package org.gradle.config;

import org.gradle.po.ByFactory;
import org.gradle.po.ToDoPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config  {

@Bean
public ByFactory byFactory() {
	return new ByFactory();
}

@Bean
public WebDriver webDriver(){
	WebDriver driver = new FirefoxDriver();
	return driver;
}

@Bean
public ToDoPageObject toDoPageObject(){
	return new ToDoPageObject();
}
}
