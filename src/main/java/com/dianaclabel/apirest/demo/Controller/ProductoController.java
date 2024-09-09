package com.dianaclabel.apirest.demo.Controller;

import com.dianaclabel.apirest.demo.Entities.Producto;
import com.dianaclabel.apirest.demo.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    //Con esta notacion hace una instancia de el repositorio que utilizamos
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> obtenerProductos(){
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id){
        return productoRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID" + id));
    }


    @PostMapping
    //RequestBody representa a los atributos de la clase
    public Producto crearProductos(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto){
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID" + id));

        producto.setNombre(detallesProducto.getNombre());
        producto.setPrecio(detallesProducto.getPrecio());

        return productoRepository.save(producto);

    }

    @DeleteMapping("/{id}")
    public String borrarProducto(@PathVariable Long id){
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID" + id));

        productoRepository.delete(producto);

        return "El producto co el ID: " + id + " fue eliminado correctamente";
    }

}
