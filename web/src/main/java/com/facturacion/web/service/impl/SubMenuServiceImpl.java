package com.facturacion.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.facturacion.web.Utils.RestResponse;
import com.facturacion.web.dao.OpcionUsuarioDao;
import com.facturacion.web.dao.SubMenuDao;
import com.facturacion.web.model.OpcionUsuario;
import com.facturacion.web.model.SubMenu;
import com.facturacion.web.service.SubMenuService;

@Service
public class SubMenuServiceImpl implements SubMenuService {
	
	private static Logger log = Logger.getLogger(SubMenuServiceImpl.class);

	@Autowired
	protected SubMenuDao subMenuDao;
	
	@Autowired
	protected OpcionUsuarioDao opcionUsuarioDao;

	@Override
	public List<SubMenu> geSubMenuByOU(List<String> opcionUsuarioIdList) {
		 
		List<Long> opcionUsuarioId = new ArrayList<>();
		for(String id : opcionUsuarioIdList) {
			opcionUsuarioId.add(Long.valueOf(id));
		}
		return  subMenuDao.findAllById(opcionUsuarioId);
	}

	@Override
	public List<SubMenu> getSubMenuAll() {		
		return subMenuDao.findAll();
	}

	@Override
	public List<SubMenu> getSubMenuByUsuario(String usuarioId) {
		
		OpcionUsuario opcionUsuario= new OpcionUsuario(); 
		opcionUsuario.setUsuarioId(Long.valueOf(usuarioId));
		Example<OpcionUsuario> example = Example.of(opcionUsuario);
		List<OpcionUsuario> op=  opcionUsuarioDao.findAll(example);
		List<Long> opcionUsuarioId = new ArrayList<>();
		for(OpcionUsuario id : op) {
			opcionUsuarioId.add(id.getSubMenuId());
		}
		return  subMenuDao.findAllById(opcionUsuarioId);			
	}

	@Override
	public RestResponse guardarRutas(String usuarioId, List<String> idSubmenu) {
		RestResponse response = new RestResponse(200);
		opcionUsuarioDao.deleteByUsuarioId(Long.valueOf(usuarioId));
		for(String id : idSubmenu) {
			log.info("submenuId:"+id);
			OpcionUsuario op = new OpcionUsuario();
			op.setSubMenuId(Long.valueOf(id));
			op.setUsuarioId(Long.valueOf(usuarioId));
			op.setFechaRegistro(new Date());
			op.setEstado(1l);
			opcionUsuarioDao.save(op);
		}
		
		return response;
	}
	
	



	
}
