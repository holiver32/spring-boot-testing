package io.reflectoring.cliente;

import io.reflectoring.cliente.business.ClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ClienteConfiguration {

  @Bean
  public ClienteService clienteService(){
    return new ClienteService();
  }

}
