package io.reflectoring.reserva.business;

import java.util.Optional;

import io.reflectoring.reserva.data.Reserva;
import io.reflectoring.reserva.data.ReservaRepository;
import io.reflectoring.cliente.data.Cliente;
import io.reflectoring.cliente.data.ClienteRepository;
import io.reflectoring.vuelo.data.Vuelo;
import io.reflectoring.vuelo.data.VueloService;

public class ReservaService {

  private ReservaRepository reservaRepository;

  private ClienteRepository clienteRepository;

  VueloService vueloService;

  public ReservaService(
          ReservaRepository reservaRepository,
          ClienteRepository clienteRepository,
          VueloService vueloService) {
    this.reservaRepository = reservaRepository;
    this.clienteRepository = clienteRepository;
    this.vueloService = vueloService;
  }

  /**
   * Books the given vuelo for the given cliente.
   */
  public Reserva bookVuelo(Long clienteId, String numeroVuelo) {

    Optional<Cliente> cliente = clienteRepository.findById(clienteId);
    if (!cliente.isPresent()) {
      throw new ClienteInexistenteException(clienteId);
    }

    Optional<Vuelo> vuelo = vueloService.findVuelo(numeroVuelo);
    if (!vuelo.isPresent()) {
      throw new VueloInexistenteException(numeroVuelo);
    }

    Reserva reserva = Reserva.builder()
            .cliente(cliente.get())
            .numeroVuelo(vuelo.get().getNumeroVuelo())
            .build();

    return this.reservaRepository.save(reserva);
  }

}
