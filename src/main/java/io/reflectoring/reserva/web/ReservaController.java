package io.reflectoring.reserva.web;

import io.reflectoring.reserva.business.ReservaService;
import io.reflectoring.reserva.data.Reserva;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservaController {

  private ReservaService reservaService;

  public ReservaController(ReservaService reservaService) {
    this.reservaService = reservaService;
  }

  @PostMapping("/reserva")
  public ResponseEntity<ReservaResultResource> bookVuelo(
          @RequestParam("clienteId") Long clienteId,
          @RequestParam("numeroVuelo") String numeroVuelo) {
    Reserva reserva = reservaService.bookVuelo(clienteId, numeroVuelo);
    ReservaResultResource reservaResult = ReservaResultResource.builder()
            .success(true)
            .build();
    return ResponseEntity.ok(reservaResult);
  }

}
