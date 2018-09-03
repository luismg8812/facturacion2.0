package com.facturacion.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.web.model.ActivacionUsuario;

public interface ActivacionUsuarioDao extends JpaRepository<ActivacionUsuario, Long>{
	
	    @Modifying
	    @Transactional
	    @Query("delete from ActivacionUsuario ou where ou.usuarioId =:usuarioId ")
	    void deleteByUsuarioId(@Param("usuarioId")Long usuarioId);
	
}
