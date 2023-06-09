package com.unir.buscador.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.unir.buscador.model.Entities.MercanciaEntity;
import com.unir.buscador.model.request.EntradaMercanciaRequest;
import com.unir.buscador.service.MercanciasService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MercanciasController {

	private final MercanciasService service;

	@GetMapping("/mercancias")
	public ResponseEntity<List<MercanciaEntity>> getProducts(@RequestHeader Map<String, String> headers) {

		log.info("headers: {}", headers);
		List<MercanciaEntity> products = service.getMercancias();

		if (products != null) {
			return ResponseEntity.ok(products);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}

	@GetMapping("/mercancias/{mercanciaId}")
	public ResponseEntity<MercanciaEntity> getProduct(@PathVariable String mercanciaId) {

		log.info("Request received for product {}", mercanciaId);
		MercanciaEntity product = service.getMercancia(mercanciaId);

		if (product != null) {
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping("/mercancia")
	public ResponseEntity<MercanciaEntity> getProduct(@RequestBody EntradaMercanciaRequest request) {

		MercanciaEntity createdProduct = service.entrarMercancia(request);

		if (createdProduct != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	@PutMapping("/mercancia/{mercanciaId}")
	public ResponseEntity<MercanciaEntity> updateMercancia(@PathVariable String mercanciaId,
			@RequestBody EntradaMercanciaRequest request) {

		MercanciaEntity updateMercancia = service.updateMercancia(mercanciaId, request);

		if (updateMercancia != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updateMercancia);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	@DeleteMapping("/mercancias/{mercanciaId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable String mercanciaId) {

		Boolean removed = service.removeMercancia(mercanciaId);

		if (Boolean.TRUE.equals(removed)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}
