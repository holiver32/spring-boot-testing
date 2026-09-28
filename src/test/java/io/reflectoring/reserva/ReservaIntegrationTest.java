package io.reflectoring.reserva;

import io.reflectoring.cliente.data.Cliente;
import io.reflectoring.cliente.data.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ReservaIntegrationTest {

  @Autowired
  private WebApplicationContext applicationContext;

  @Autowired
  private ClienteRepository clienteRepository;

  private MockMvc mockMvc;

  @BeforeEach
  void setup() {
    this.mockMvc = MockMvcBuilders
            .webAppContextSetup(applicationContext)
            .build();
  }

  @Test
  void bookVueloReturnsHttpStatusOk() throws Exception {
    this.clienteRepository.save(Cliente.builder()
            .name("Hurley")
            .build());

    this.mockMvc.perform(
            post("/reserva")
                    .param("clienteId", "1")
                    .param("numeroVuelo", "Oceanic 815"))
            .andExpect(status().isOk());
  }

}
