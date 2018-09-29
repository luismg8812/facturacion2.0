package com.facturacion.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.web.model.ConsecutivoDian;

public interface ConsecutivoDianDao extends JpaRepository<ConsecutivoDian, Long>{

	@Modifying
    @Transactional
    @Query(value = "SELECT nextval('s_consecutivo_dian') where 1= ?1", nativeQuery = true)
	 Integer getconsecutivoDian(Integer consecutivo);
}
