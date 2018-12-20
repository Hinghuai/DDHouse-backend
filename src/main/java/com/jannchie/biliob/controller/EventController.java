package com.jannchie.biliob.controller;

import com.jannchie.biliob.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jannchie
 */
@RestController
public class EventController {

  private final EventService eventService;

  @Autowired
  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/api/event")
  public ResponseEntity pageEvent(
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "20") Integer pagesize) {
    return eventService.pageEvent(page, pagesize);
  }
}