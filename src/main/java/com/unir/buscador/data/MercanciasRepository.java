package com.unir.buscador.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unir.buscador.model.Entities.MercanciaEntity;

public interface MercanciasRepository extends JpaRepository<MercanciaEntity, Long> {

	// List<MercanciaEntity> findByName(String name);
}
