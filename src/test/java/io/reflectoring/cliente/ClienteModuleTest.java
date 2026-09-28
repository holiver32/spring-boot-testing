package io.reflectoring.cliente;

import io.reflectoring.reserva.business.ReservaService;
import io.reflectoring.reserva.data.ReservaRepository;
import io.reflectoring.reserva.web.ReservaController;
import io.reflectoring.cliente.business.ClienteService;
import io.reflectoring.cliente.data.ClienteRepository;
import io.reflectoring.cliente.web.ClienteController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ClienteModuleTest {

  @Autowired(required = false)
  private ReservaController reservaController;
  @Autowired(required = false)
  private ReservaService reservaService;
  @Autowired(required = false)
  private ReservaRepository reservaRepository;

  @Autowired
  private ClienteController clienteController;
  @Autowired
  private ClienteService clienteService;
  @Autowired
  private ClienteRepository clienteRepository;

  @Test
  void onlyClienteModuleIsLoaded() {
    assertThat(clienteController).isNotNull();
    assertThat(clienteService).isNotNull();
    assertThat(clienteRepository).isNotNull();
    assertThat(reservaController).isNull();
    assertThat(reservaService).isNull();
    assertThat(reservaRepository).isNull();
  }

}