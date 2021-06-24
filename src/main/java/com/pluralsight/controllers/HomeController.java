package com.pluralsight.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
  //  The appVersion variables LOOKS unset but the @Value annotation is actually giving it a value.
  //  Time to get used to reading Spring setup!
  @Value("${app.version}")
  private String appVersion;
  // This is an example of pulling into the application properties

  @GetMapping
  @RequestMapping("/")
  public Map getStatus() {
    Map map = new HashMap<String, String>();
    map.put("app-version", appVersion);
    return map;
  }
}
