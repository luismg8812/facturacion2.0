package com.facturacion.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.web.model.Menu;

public interface MenuDao extends JpaRepository<Menu, Long>{

}
