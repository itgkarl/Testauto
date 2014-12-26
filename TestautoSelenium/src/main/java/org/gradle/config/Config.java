package org.gradle.config;

import org.gradle.Person;
import org.gradle.po.ByFactory;
import org.gradle.po.toDo.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config  {
@Bean
public Person person() {
	Person person = new Person("Larry");
	return person;
}

@Bean
public ByFactory byFactory() {
	return new ByFactory();
}

@Bean
public WebDriver webDriver(){
	WebDriver driver = new FirefoxDriver();
	driver.get("localhost:3000/welcome/index");
	return driver;
}

@Bean
public WelcomePage welcomePage(){
	return new WelcomePage();
}
}
