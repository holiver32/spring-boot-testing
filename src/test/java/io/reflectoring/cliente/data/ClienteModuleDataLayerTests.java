package io.reflectoring.cliente.data;

import io.reflectoring.reserva.data.ReservaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class ClienteModuleDataLayerTests {

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired(required = false)
  private ReservaRepository reservaRepository;

  @Test
  void onlyClienteRepositoryIsLoaded() {
    assertThat(clienteRepository).isNotNull();
    assertThat(reservaRepository).isNull();
  }

  @Test
  void versionTest(){
    Cliente hans = new Cliente();
    hans.setName("Hans");
    clienteRepository.save(hans);
  }

}