package com.aquila.udemyacademi.resorce;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.aquila.udemyacademi.exceptions.BusinessException;
import com.aquila.udemyacademi.models.entities.Categoria;
import com.aquila.udemyacademi.repository.CategoriaRepository;
import com.aquila.udemyacademi.services.CategoriaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    
    @Autowired
    private CategoriaService service;


    @GetMapping
    public ResponseEntity<List<Categoria>> listar(){

        List<Categoria> categorias = service.findAll();
        
        
        if(!CollectionUtils.isEmpty(categorias))
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND)  ;
        

    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria>  getById(@PathVariable("id") Long idCategoria) {
        
        try{

            Categoria categoria = service.findById(idCategoria);
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        }catch(BusinessException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
       
    }
    

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody Categoria entity) {
        Categoria savedData = null;
        if(Objects.nonNull(entity)){
            try {
                
                savedData = service.save(entity);
            } catch (BusinessException e) {
                return new ResponseEntity<>(entity, HttpStatus.CONFLICT);
            }
        }

        return new ResponseEntity<>(savedData, HttpStatus.OK);
    }
        
}
