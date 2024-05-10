package de.aittr.shop.controller;

import de.aittr.shop.domain.dto.ProductDto;
import de.aittr.shop.exception_handlig.exceotions.FirstTestException;
import de.aittr.shop.exception_handlig.Response;
import de.aittr.shop.service.interfaces.ProductService;
import org.springframework.http.HttpStatus;
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

        if (id < 1){
            throw new FirstTestException("Id is incorrect!");
        }
        return service.getById(id);
    }

    // Сохранять новый продукт в базе данных
// может только администратор (пользователь с ролью ADMIN)
    @PostMapping
    public ProductDto save(@RequestBody ProductDto product) {
        return service.save(product);
    }

    // 1 способ обработки исключений
    // + позволяет точечно настроить обработку исключений применительно к данному конкретному контроллеру, в случае, если нам требуется
    //разная логика обработки того же самого исключения в разных контроллерах
    // - если нам не требуется разной логики обработки ошибки для разных
    //контроллеров, такой обработчик придется писать в каждом контроллере
    @ExceptionHandler(FirstTestException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Response handleException(FirstTestException e) {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
        return new Response(e.getMessage());

    }
}
