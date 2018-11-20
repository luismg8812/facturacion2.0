package com.invoice.empalme.dao.invoice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.invoice.empalme.model.invoice.Producto;


public interface ProductoDao extends JpaRepository<Producto, Long>{

	@Modifying
    @Transactional
    @Query("select p from Producto p where p.codigoInterno = :codigoInterno")
	List<Producto> getByCodigoInterno(@Param("codigoInterno")String codigoInterno);
}
