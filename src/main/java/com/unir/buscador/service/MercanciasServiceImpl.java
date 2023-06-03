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
    public MercanciaEntity getMercancia(String mercanciaId) {
        return repository.findById(Long.valueOf(mercanciaId)).orElse(null);
    }

    @Override
    public MercanciaEntity entrarMercancia(EntradaMercanciaRequest request) {
        if (request != null && StringUtils.hasLength(request.getNombre().trim())
                && StringUtils.hasLength(request.getCodigo().trim())
                && StringUtils.hasLength(request.getUbicacion().trim())) {

            MercanciaEntity mercancia = MercanciaEntity.builder().nombre(request.getNombre())
                    .codigo(request.getCodigo())
                    .cantidad(request.getCantidad()).precio(request.getPrecio()).ubicacion(request.getUbicacion())
                    .vencimiento(request.getVencimiento()).build();

            return repository.save(mercancia);
        } else {
            return null;
        }
    }

    @Override
    public Boolean removeMercancia(String productId) {
        MercanciaEntity mercancia = repository.findById(Long.valueOf(productId)).orElse(null);

        if (mercancia != null) {
            repository.delete(mercancia);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public MercanciaEntity updateMercancia(String mercanciaId, EntradaMercanciaRequest request) {

        MercanciaEntity mercancia = repository.findById(Long.valueOf(mercanciaId)).orElse(null);

        // Actualiza los campos del usuario según los valores proporcionados en el DTO
        if (request.getCantidad() != null) {
            mercancia.setCantidad(request.getCantidad());
        }

        return repository.save(mercancia);
    }

}




// @Autowired
// private ProductRepository repository;

// @Override
// public List<Product> getProducts() {

//     List<Product> products = repository.findAll();
//     return products.isEmpty() ? null : products;
// }

// @Override
// public Product getProduct(String productId) {
//     return repository.findById(Long.valueOf(productId)).orElse(null);
// }

// @Override
// public Boolean removeProduct(String productId) {

//     Product product = repository.findById(Long.valueOf(productId)).orElse(null);

//     if (product != null) {
//         repository.delete(product);
//         return Boolean.TRUE;
//     } else {
//         return Boolean.FALSE;
//     }
// }

// @Override
// public Product createProduct(CreateProductRequest request) {

//     if (request != null && StringUtils.hasLength(request.getName().trim())
//             && StringUtils.hasLength(request.getDescription().trim())
//             && StringUtils.hasLength(request.getCountry().trim()) && request.getVisible() != null) {

//         Product product = Product.builder().name(request.getName()).description(request.getDescription())
//                 .country(request.getCountry()).visible(request.getVisible()).build();

//         return repository.save(product);
//     } else {
//         return null;
//     }
// }