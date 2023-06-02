package com.unir.buscador.service;

import java.util.List;

import com.unir.buscador.model.Entities.MercanciaEntity;
import com.unir.buscador.model.request.EntradaMercanciaRequest;

public interface MercanciasService {
    
    List<MercanciaEntity> getMercancias();
	
	MercanciaEntity getMercancia(String productId);
	
	// Boolean removeMercancia(String productId);
	
	MercanciaEntity entrarMercancia(EntradaMercanciaRequest request);
}
