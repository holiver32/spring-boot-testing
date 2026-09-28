package io.reflectoring.reserva;

import io.reflectoring.reserva.business.ReservaService;
import io.reflectoring.reserva.data.ReservaRepository;
import io.reflectoring.cliente.ClienteConfiguration;
import io.reflectoring.cliente.data.ClienteRepository;
import io.reflectoring.vuelo.VueloConfiguration;
import io.reflectoring.vuelo.data.VueloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ClienteConfiguration.class, VueloConfiguration.class})
@ComponentScan
public class ReservaConfiguration {

  @Bean
  public ReservaService reservaService(
          ReservaRepository reservaRepository,
          ClienteRepository clienteRepository,
          VueloService vueloService) {
    return new ReservaService(reservaRepository, clienteRepository, vueloService);
  }

}
