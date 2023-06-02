package com.unir.buscador.model.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "mercancias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MercanciaEntity {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk")
	private Long id;

    @Column(name = "codigo", unique = true)
	private String codigo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "precio")
	private Float precio;
	
	@Column(name = "ubicacion")
	private String ubicacion;

    @Column(name = "vencimiento")
	private Date vencimiento;
}
