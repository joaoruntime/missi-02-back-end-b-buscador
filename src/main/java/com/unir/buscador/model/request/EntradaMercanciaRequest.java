package com.unir.buscador.model.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaMercanciaRequest {

	private String codigo;
	private String nombre;
	private Integer cantidad;
	private Float precio;
	private String ubicacion;
	private Date vencimiento;
}
