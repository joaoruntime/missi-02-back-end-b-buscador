package com.unir.buscador.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unir.buscador.model.Entities.MercanciaEntity;

public interface MercanciasRepository extends JpaRepository<MercanciaEntity, Long> {

	// List<MercanciaEntity> findByName(String name);

	// @Query(value = "SELECT * FROM your_table_name WHERE condition", nativeQuery = true)
    // List<MercanciaEntity> executeCustomQuery();
}
