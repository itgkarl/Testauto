package org.gradle.config;

import org.gradle.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config  {
@Bean
public Person person() {
	Person person = new Person("Larry");
	return person;
}
}