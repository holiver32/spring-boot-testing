package io.reflectoring.vuelo.data;

import java.util.Optional;

public class VueloService {

  public Optional<Vuelo> findVuelo(String numeroVuelo) {
    return Optional.of(Vuelo.builder()
            .aerolinea("Oceanic")
            .numeroVuelo("815")
            .build());
  }

}
