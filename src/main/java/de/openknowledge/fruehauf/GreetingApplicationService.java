/*
 * Copyright (C) open knowledge GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package de.openknowledge.fruehauf;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Service for greeting message.
 */
@ApplicationScoped
public class GreetingApplicationService {

  @PersistenceContext(unitName = "default")
  private EntityManager em;

  private final AtomicReference<String> greeting = new AtomicReference<>();

  @Transactional
  public GreetingDTO createGreeting(String name) {
    GreetingDTO greetingDTO = new GreetingDTO(name);
    em.persist(greetingDTO);
    return greetingDTO;
  }

  public GreetingApplicationService() {
    super();
  }

  /**
   * Create a new greeting provider, reading the message from configuration.
   *
   * @param greeting greeting to use
   */
  @Inject
  public GreetingApplicationService(@ConfigProperty(name = "app.greeting") final String greeting) {
    this();
    this.greeting.set(greeting);
  }

  public String getGreeting() {
    return greeting.get();
  }

  public String getMessage(final String who) {
    return String.format("%s %s!", getGreeting(), who);
  }

  public void updateGreeting(final String greeting) {
    this.greeting.set(greeting);
  }
}
