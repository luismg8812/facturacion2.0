package com.invoice.electonic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.invoice.electonic.model.Receptor;

public interface ReceptorDao extends JpaRepository<Receptor, Long>{
	
}
