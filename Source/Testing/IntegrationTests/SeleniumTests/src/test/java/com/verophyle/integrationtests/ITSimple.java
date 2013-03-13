/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.integrationtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verophyle.integrationtests.services.ChromeService;

public class ITSimple {
  
  private WebDriver driver;
  
  @BeforeClass
  public static void startService() throws IOException {
    ChromeService.startService();
  }
  
  @AfterClass
  public static void stopService() {
    ChromeService.stopService();
  }
  
  @Before
  public void createDriver() throws IOException {
    driver = ChromeService.createDriver();
  }
  
  @After
  public void quitDriver() {
    driver.quit();
  }
  
  @Test
  public void alwaysPasses() {
    assertTrue(true);
  }
  
  @Test
  public void simpleSeleniumTest() {
    driver.get(Common.TEST_URL);
    
    assertEquals("Verophyle", driver.getTitle());
    
    WebElement historyFrame = driver.findElement(By.id("__gwt_historyFrame"));
    assertNotNull(historyFrame);
  }
  
}