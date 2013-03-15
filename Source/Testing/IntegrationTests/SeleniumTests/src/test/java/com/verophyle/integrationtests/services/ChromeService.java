/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.integrationtests.services;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeService {

  private static ChromeDriverService service;
  private static int refCount = 0;
  
  static {
    if (service == null) {
      service = new ChromeDriverService.Builder()
        .usingDriverExecutable(new File("chromedriver" + File.separator + getChromePath()))
        .usingAnyFreePort()
        .build();
    }    
  }
  
  protected ChromeService() {
  }
  
  public synchronized static void startService() throws IOException {
    if (service != null && !service.isRunning()) {
      refCount++;
      service.start();
    }
  }
  
  public static WebDriver createDriver() throws IOException {
      return new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
  }

  public synchronized static void stopService() {
    if (service != null && service.isRunning() && --refCount < 1) {
      service.stop();
      service = null;
    }
  }
  
  private static String getChromePath() {
    String os = System.getProperty("os.name").toLowerCase();
    if (os.contains("win"))
      return "windows" + File.separator + "chromedriver.exe";
    
    throw new RuntimeException("Unable to get Chrome driver directory for " + os);
  }

}
