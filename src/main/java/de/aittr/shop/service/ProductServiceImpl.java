package de.aittr.shop.service;

import de.aittr.shop.domain.dto.ProductDto;
import de.aittr.shop.domain.entity.Product;
import de.aittr.shop.repository.ProductRepository;
import de.aittr.shop.service.interfaces.ProductService;
import de.aittr.shop.service.mapping.ProductMappingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;
    private ProductMappingService mappingService;

    public ProductServiceImpl(ProductRepository repository, ProductMappingService mappingService) {
        this.repository = repository;
        this.mappingService = mappingService;
    }

    @Override
    public ProductDto save(ProductDto product) {
        return null;
    }

    @Override
    public List<ProductDto> getAll() {
        return List.of();
    }

    @Override
    public ProductDto getById(Long id) {
       if (id == null || id < 1) {
           throw new RuntimeException("Invalid product id");
       }
       Product product = repository.findById(id).orElse(null);

       if (product == null) {
           throw new RuntimeException("Product not found");
       }

       return mappingService.mapEntityToDto(product);
    }

    @Override
    public void update(ProductDto product) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteByTitle(String title) {

    }

    @Override
    public void restoreById(Long id) {

    }

    @Override
    public int getTotalQuantity() {
        return 0;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return null;
    }

    @Override
    public BigDecimal getAveragePrice() {
        return null;
    }
}