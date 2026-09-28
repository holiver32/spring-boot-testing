package io.reflectoring.reserva.business;

import java.util.Optional;

import io.reflectoring.reserva.data.Reserva;
import io.reflectoring.reserva.data.ReservaRepository;
import io.reflectoring.cliente.data.Cliente;
import io.reflectoring.cliente.data.ClienteRepository;
import io.reflectoring.vuelo.data.Vuelo;
import io.reflectoring.vuelo.data.VueloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReservaServiceTest {

  private ClienteRepository clienteRepository = Mockito.mock(ClienteRepository.class);

  private VueloService vueloService = Mockito.mock(VueloService.class);

  private ReservaRepository reservaRepository = Mockito.mock(ReservaRepository.class);

  private ReservaService reservaService;

  @BeforeEach
  void setup() {
    this.reservaService = new ReservaService(reservaRepository, clienteRepository, vueloService);
  }

  @Test
  void bookVueloReturnsReserva() {
    when(clienteRepository.findById(42L)).thenReturn(cliente());
    when(vueloService.findVuelo("Oceanic 815")).thenReturn(vuelo());
    when(reservaRepository.save(eq(reserva()))).thenReturn(reserva());
    Reserva reserva = reservaService.bookVuelo(42L, "Oceanic 815");

    assertThat(reserva).isNotNull();
    verify(reservaRepository).save(eq(reserva));

  }

  private Optional<Vuelo> vuelo() {
    return Optional.of(Vuelo.builder()
            .numeroVuelo("Oceanic 815")
            .aerolinea("Oceanic")
            .build());
  }

  private Reserva reserva() {
    return Reserva.builder()
            .numeroVuelo("Oceanic 815")
            .cliente(cliente().get())
            .build();
  }

  private Optional<Cliente> cliente() {
    return Optional.of(Cliente.builder()
            .id(42L)
            .name("Hurley")
            .build());
  }

}