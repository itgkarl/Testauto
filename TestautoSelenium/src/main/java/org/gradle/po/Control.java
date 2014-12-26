package org.gradle.po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * @author Matthias Karl
 */
public class Control {

	private final PageObject parent;
	private final By[] bys;

	/**
	 * @param driver
	 */
	public Control(PageObject parent, By... bys) {
		this.parent = parent;
		this.bys = bys;
	}

	public WebElement resolve() {
		NoSuchElementException problem = new NoSuchElementException("No 'By' specified!");
		for (By by : bys) {
			try {
				return parent.find(by);
			}
			catch (NoSuchElementException e) {
				problem = e;
			}
		}
		throw problem;
	}

	public void sendKeys(String t) {
		resolve().sendKeys(t);
	}

	public void uncheck() {
		parent.check(resolve(), false);
	}

	public void check() {
		parent.check(resolve(), true);
	}

	public void check(boolean state) {
		parent.check(resolve(), state);
	}

	public void click() {
		resolve().click();
	}

	public void set(String text) {
		WebElement e = resolve();
		e.clear();
		e.sendKeys(text);
	}

	public void set(Object text) {
		set(text.toString());
	}

	/**
	 * Select an option.
	 */
	public void select(String option) {
		WebElement e = resolve();
		e.findElement(parent.by.option(option)).click();

		// move the focus away from the select control to fire onchange event
		e.sendKeys(Keys.TAB);
	}

	/**
	 * @return value des Elements
	 */
	public String value() {
		WebElement e = resolve();
		return e.getAttribute("value");
	}

	/**
	 * @return true, wenn das Attribut "readonly" auf Wert "readonly" oder "true" ist
	 */
	public boolean isReadOnly() {
		WebElement e = resolve();
		String attribute = e.getAttribute("readonly");
		if (attribute == null) {
			return false;
		}
		else if (attribute.equalsIgnoreCase("true") || attribute.equalsIgnoreCase("readonly")) {
			return true;
		}
		else {
			throw new RuntimeException(
					"Control.isReadOnly() -- Unbekannter readonly-Attribut-Wert: " + attribute);
		}
	}
}
