package io.reflectoring.reserva.data;

import javax.persistence.*;

import io.reflectoring.cliente.data.Cliente;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Reserva {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private Cliente cliente;

  @Column
  private String numeroVuelo;

}
