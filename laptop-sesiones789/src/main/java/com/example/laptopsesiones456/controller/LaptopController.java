package com.example.laptopsesiones456.controller;

import com.example.laptopsesiones456.entities.Laptop;
import com.example.laptopsesiones456.repository.LaptopRepository;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {


    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    // atributos
    private LaptopRepository laptopRepository;

    // constructores

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // CRUD  ENTIDAD LAPTOP

    /**
     *Crear un laptop  en base de datos
     */

    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));

        if(laptop.getId() != null){ // Existe un laptop con ese identificador
            log.warn("trying to create a laptop with id");
            System.out.println("trying to create a laptop with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result); // el libro devuelto tiene una clave primaria
    }

    /**
     *Mostrar todos los laptop existente en base de datos
     */

    /** vinculamos la url http://localhost:8080/api/laptops
     * @return
     */

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    /**
     *Encuentra un laptop por su ID en base de datos
     */
    /**
     * http://localhost:8080/api/laptops/1
     * Request
     * Response
     * @param id
     * @return
     */

    @GetMapping("/api/laptops/{id}")
    @ApiOperation("Buscar un laptops por clave primaria id Long")
    @ApiParam("Clave primaria tipo Long")
    public ResponseEntity<Laptop> findOneById( @PathVariable Long id){

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if(laptopOpt.isPresent())
           return ResponseEntity.ok(laptopOpt.get());
        else
           return ResponseEntity.notFound().build();

    }

    /**
     * Actualizar un laptop existente en base de datos
     */
    @PutMapping("/api/laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null ){
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
           log.warn("Trying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }

        // El proceso de actualización
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result); // el libro devuelto tiene una clave primaria
    }

    /**
     * Borrar un laptop existente en base de datos
     */

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            log.warn("Trying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }

       laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Borrar todos los  laptop existente en base de datos
     */
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request for delete all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }


}
