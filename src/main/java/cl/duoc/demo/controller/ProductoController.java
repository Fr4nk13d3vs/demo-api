package cl.duoc.demo.controller;

import cl.duoc.demo.model.Producto;
import cl.duoc.demo.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoRepository repository;

    public ProductoController(ProductoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Producto registrar(@RequestBody Producto producto) {
        return repository.save(producto);
    }

    @GetMapping
    public List<Producto> cargar() {
        return repository.findAll();
    }
}
