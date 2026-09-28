package io.reflectoring.reserva.business;

class ClienteInexistenteException extends RuntimeException {

  ClienteInexistenteException(Long clienteId) {
    super(String.format("A cliente with ID '%d' doesn't exist!", clienteId));
  }

}
