package com.invoice.empalme.dao.invoice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.invoice.empalme.model.invoice.Receptor;



public interface ReceptorDao extends JpaRepository<Receptor, Long>{
	
	@Modifying
    @Transactional
    @Query("select r from Receptor r where r.identificacion = :identificacion")
	List<Receptor> getByIdentificacion(@Param("identificacion")String identificacion);

}
