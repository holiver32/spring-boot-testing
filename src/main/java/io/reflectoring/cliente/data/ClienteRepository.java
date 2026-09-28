package io.reflectoring.cliente.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

  List<Cliente> findByName(String name);

}
