package io.reflectoring.cliente.web;

import io.reflectoring.reserva.web.ReservaController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.assertj.core.api.Assertions.*;

@WebMvcTest
class ClienteModuleWebLayerTests {

  @Autowired
  private ClienteController clienteController;

  @Autowired(required = false)
  private ReservaController reservaController;

  @Test
  void onlyClienteControllerIsLoaded() {
    assertThat(clienteController).isNotNull();
    assertThat(reservaController).isNull();
  }

}