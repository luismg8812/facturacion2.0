package com.facturacion.web.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.web.model.InfoDiario;

public interface InformeDiarioDao extends JpaRepository<InfoDiario, Long>{
	
	@Modifying
    @Transactional
    @Query("select d from InfoDiario d where d.fechaInforme >= :fechaInicio AND d.fechaInforme <= :fechaFinal ")
	List<InfoDiario> buscarInfodiarioByFecha(@Param("fechaInicio")Date fechaInicio, @Param("fechaFinal") Date fechaFinal);

}
