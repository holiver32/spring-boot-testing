package io.reflectoring.reserva.business;

class VueloInexistenteException extends RuntimeException {

  VueloInexistenteException(String numeroVuelo) {
    super(String.format("El vuelo con ID '%d' no existe!", numeroVuelo));
  }

}
