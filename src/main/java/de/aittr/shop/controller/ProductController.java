package de.aittr.shop.controller;

import de.aittr.shop.domain.dto.ProductDto;
import de.aittr.shop.domain.entity.Product;
import de.aittr.shop.service.interfaces.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // GET - localhost:8080/products/all

    // Просматривать все продукты могут все пользователи,
// даже не зарегистрированные
    @GetMapping("/all")
    public List<ProductDto> getAll() {
        return service.getAll();
    }

// 2 способ: передача ID в виде параметра запроса
// GET - localhost:8080/products?id=5

    // Обращаться к одному конкретному продукту
// может только зарегистрированный пользователь (с любой ролью)
    @GetMapping
    public ProductDto getById(@RequestParam Long id) {
        return service.getById(id);
    }

    // Сохранять новый продукт в базе данных
// может только администратор (пользователь с ролью ADMIN)
    @PostMapping
    public ProductDto save(@RequestBody ProductDto product) {
        return service.save(product);
    }
}
