package com.unir.buscador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.buscador.data.MercanciasRepository;
import com.unir.buscador.model.Entities.MercanciaEntity;
import com.unir.buscador.model.request.EntradaMercanciaRequest;
import org.springframework.util.StringUtils;

@Service
public class MercanciasServiceImpl implements MercanciasService {

    @Autowired
    private MercanciasRepository repository;

    @Override
    public List<MercanciaEntity> getMercancias() {
        List<MercanciaEntity> products = repository.findAll();
        return products.isEmpty() ? null : products;
    }

    @Override
    public MercanciaEntity getMercancia(String productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMercancia'");
    }

    @Override
    public MercanciaEntity entrarMercancia(EntradaMercanciaRequest request) {
        if (request != null && StringUtils.hasLength(request.getNombre().trim())
                && StringUtils.hasLength(request.getCodigo().trim())
                && StringUtils.hasLength(request.getUbicacion().trim())) {

            MercanciaEntity mercancia = MercanciaEntity.builder().nombre(request.getNombre()).codigo(request.getCodigo())
                    .cantidad(request.getCantidad()).precio(request.getPrecio()).ubicacion(request.getUbicacion())
                    .vencimiento(request.getVencimiento()).build();

            return repository.save(mercancia);
        } else {
            return null;
        }
    }

}
