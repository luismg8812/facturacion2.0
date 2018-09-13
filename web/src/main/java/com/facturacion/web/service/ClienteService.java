package com.facturacion.web.service;

import java.util.List;

import com.facturacion.web.model.Cliente;

public interface ClienteService {

	Cliente save(Cliente cliente);

	Cliente getById(String clienteId);

	List<Cliente> getByAll();

}
