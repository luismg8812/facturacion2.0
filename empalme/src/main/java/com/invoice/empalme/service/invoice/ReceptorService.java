package com.invoice.empalme.service.invoice;

import java.util.List;

import com.invoice.empalme.model.invoice.Receptor;

public interface ReceptorService {

	Receptor save(Receptor receptor);

	Receptor getById(String receptorId);
	
	Receptor getByIdentificacion(String identificacion);

	List<Receptor> getByAll();
	

}
