package com.invoice.electonic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.invoice.electonic.model.Empresa;

public interface EmpresaDao extends JpaRepository<Empresa, Long>{

}
