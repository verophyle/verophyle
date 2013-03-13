package com.verophyle.integrationtests.services;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

/**
 * Base class for services.
 *
 */
public abstract class Service {

  private static final List<Service> ALL_SERVICES = new ArrayList<Service>();

  protected Service() {
    addService(this);
  }

  public abstract WebDriver getDriver();
  
  public static List<Service> getAllServices() {
    return ALL_SERVICES;
  }

  protected static void addService(Service service) {
    if (!ALL_SERVICES.contains(service))
      ALL_SERVICES.add(service);
  }

}
