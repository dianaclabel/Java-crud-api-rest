package com.dianaclabel.apirest.demo.Repositories;

import com.dianaclabel.apirest.demo.Entities.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

//aquí esta extendiendo de la entidad producto
public interface ProductoRepository extends JpaRepository<Producto,Long > {

}
