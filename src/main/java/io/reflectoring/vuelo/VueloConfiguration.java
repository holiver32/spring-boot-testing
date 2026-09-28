package io.reflectoring.vuelo;

import io.reflectoring.vuelo.data.VueloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan
public class VueloConfiguration {

  @Bean
  public VueloService vueloService(){
    return new VueloService();
  }

}
