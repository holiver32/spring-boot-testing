package io.reflectoring.cliente.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

  @PostMapping("/cliente")
  public String hello() {
    return "hello";
  }

}
