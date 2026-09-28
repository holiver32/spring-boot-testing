package io.reflectoring.reserva.web;

import java.util.Arrays;

import io.reflectoring.reserva.business.ReservaService;
import io.reflectoring.reserva.data.Reserva;
import io.reflectoring.cliente.data.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ReservaControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ApplicationContext applicationContext;

  @MockBean
  private ReservaService reservaService;

  @BeforeEach
  void printApplicationContext() {
    Arrays.stream(applicationContext.getBeanDefinitionNames())
            .map(name -> applicationContext.getBean(name).getClass().getName())
            .sorted()
            .forEach(System.out::println);
  }

  @Test
  void bookVueloReturnsHttpStatusOk() throws Exception {
    when(reservaService.bookVuelo(eq(42L), eq("Oceanic 815")))
            .thenReturn(expectedReserva());

    mockMvc.perform(
            post("/reserva")
                    .param("clienteId", "42")
                    .param("numeroVuelo", "Oceanic 815"))
            .andExpect(status().isOk());
  }

  private Reserva expectedReserva() {
    return Reserva.builder()
            .cliente(Cliente.builder()
                    .id(42L)
                    .name("Zaphod")
                    .build())
            .numeroVuelo("Oceanic 815")
            .build();
  }

}