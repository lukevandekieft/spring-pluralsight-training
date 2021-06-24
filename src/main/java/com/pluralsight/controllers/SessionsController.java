package com.pluralsight.controllers;

import com.pluralsight.models.Session;
import com.pluralsight.repositories.SessionRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
  @Autowired
  private SessionRepository sessionRepository;

  @GetMapping
  public List<Session> list() {
    return sessionRepository.findAll();
  }

  @GetMapping
  @RequestMapping("{id}")
  public Session get(@PathVariable Long id) {
    return sessionRepository.getOne(id);
  }

  @PostMapping
  public Session create(@RequestBody final Session session) {
    return sessionRepository.saveAndFlush(session);
  }

  // No such thing as DeleteMapping, hence RequestMapping
  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    // Also need to check for children records before deleting. In real implementation we'd have orphaned info as-is
    sessionRepository.deleteById(id);
  }

  // Consider PATCH if I'm only trying to replace certain fields
  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  public Session update(@PathVariable Long id, @RequestBody Session session) {
    // in production we'd want to verify body attributes
    Session existingSession = sessionRepository.getOne(id);
    BeanUtils.copyProperties(session, existingSession, "session_id");
    return sessionRepository.saveAndFlush(existingSession);
  }
}
