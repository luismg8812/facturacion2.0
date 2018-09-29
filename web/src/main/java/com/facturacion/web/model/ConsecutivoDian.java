package com.facturacion.web.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="CONSECUTIVO_DIAN")
public class ConsecutivoDian {

	@Id
	@SequenceGenerator(name="S_CONSECUTIVO_DIAN", sequenceName="S_CONSECUTIVO_DIAN", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_CONSECUTIVO_DIAN")	
	@NotNull
	@Column(name="CONSECUTIVO_DIAN_ID")
	private Long consecutivoDianId;

	public Long getConsecutivoDianId() {
		return consecutivoDianId;
	}

	public void setConsecutivoDianId(Long consecutivoDianId) {
		this.consecutivoDianId = consecutivoDianId;
	}
	
	
	
}
