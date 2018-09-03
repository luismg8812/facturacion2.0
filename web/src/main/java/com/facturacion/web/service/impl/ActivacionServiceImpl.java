package com.facturacion.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.facturacion.web.Utils.RestResponse;
import com.facturacion.web.dao.ActivacionDao;
import com.facturacion.web.dao.ActivacionUsuarioDao;
import com.facturacion.web.model.Activacion;
import com.facturacion.web.model.ActivacionUsuario;
import com.facturacion.web.model.OpcionUsuario;
import com.facturacion.web.service.ActivacionService;

@Service
public class ActivacionServiceImpl implements ActivacionService {
	
	private static Logger log = Logger.getLogger(ActivacionServiceImpl.class);

	@Autowired
	protected ActivacionDao activacionDao;
	
	@Autowired
	protected ActivacionUsuarioDao activacionUsuarioDao;


	@Override
	public List<Activacion> getActivacionAll() {
		return activacionDao.findAll();
	}


	@Override
	public List<Activacion> getByUsuario(String usuarioId) {
		ActivacionUsuario activacionUsuario= new ActivacionUsuario(); 
		activacionUsuario.setUsuarioId(Long.valueOf(usuarioId));
		Example<ActivacionUsuario> example = Example.of(activacionUsuario);
		List<ActivacionUsuario> op=  activacionUsuarioDao.findAll(example);
		List<Long> activacionUsuarioId = new ArrayList<>();
		for(ActivacionUsuario id : op) {
			activacionUsuarioId.add(id.getActivacionId());
		}
		return  activacionDao.findAllById(activacionUsuarioId);
	}


	@Override
	public RestResponse guardarActivaciones(String usuarioId, List<String> idActivaciones) {
		RestResponse response = new RestResponse(200);
		activacionUsuarioDao.deleteByUsuarioId(Long.valueOf(usuarioId));
		for(String id : idActivaciones) {
			log.info("activacion:"+id);
			ActivacionUsuario op = new ActivacionUsuario();
			op.setActivacionId(Long.valueOf(id));
			op.setUsuarioId(Long.valueOf(usuarioId));
			op.setFechaRegistro(new Date());
			op.setEstado(1l);
			activacionUsuarioDao.save(op);
		}
		
		return response;
	}


	
}
