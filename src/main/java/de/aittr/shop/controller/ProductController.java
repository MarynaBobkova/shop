package de.aittr.shop.controller;

import de.aittr.shop.domain.dto.ProductDto;
import de.aittr.shop.domain.entity.Product;
import de.aittr.shop.service.interfaces.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // GET - localhost: 8080/products/example

//    @GetMapping ("/example/{id}")
//    public Product getById(@PathVariable Long id) {
//        return service.getById(id);
//    }

    // GET - localhost: 8080/products/example?id5

    @GetMapping ("/example")
    public ProductDto getById(@RequestParam Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto product) {
        return service.save(product);
    }
}
