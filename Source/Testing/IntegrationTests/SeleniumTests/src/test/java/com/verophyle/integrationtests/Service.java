package com.verophyle.integrationtests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

/**
 * Base class for services.
 *
 */
public abstract class Service {

  private static final List<Service> ALL_SERVICES = new ArrayList<Service>();

  private WebDriver driver;

  protected Service() {
  }

  public WebDriver getDriver() {
    return driver;
  }

  protected void setDriver(WebDriver driver) {
    this.driver = driver;
  }

  public static List<Service> getAllServices() {
    return ALL_SERVICES;
  }

  protected static void addService(Service service) {
    if (!ALL_SERVICES.contains(service))
      ALL_SERVICES.add(service);
  }

}
