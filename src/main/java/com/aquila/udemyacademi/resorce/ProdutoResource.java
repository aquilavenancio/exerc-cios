package com.aquila.udemyacademi.resorce;

import java.util.List;
import java.util.Objects;

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

import com.aquila.udemyacademi.exceptions.BusinessException;
import com.aquila.udemyacademi.models.entities.Categoria;
import com.aquila.udemyacademi.models.entities.Produto;
import com.aquila.udemyacademi.services.CategoriaService;
import com.aquila.udemyacademi.services.ProdutoService;



@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
    
    @Autowired
    private ProdutoService service;


    @GetMapping
    public ResponseEntity<List<Produto>> listar(){

        List<Produto> produto = service.findAll();
        
        
        if(!CollectionUtils.isEmpty(produto))
            return new ResponseEntity<>(produto, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND)  ;
        

    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto>  getById(@PathVariable("id") Long idProduto) {
        
        try{

            Produto produto = service.findById(idProduto);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        }catch(BusinessException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
       
    }
    

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto entity) {
        Produto savedData = null;
        if(Objects.nonNull(entity)){
              
            try {
                savedData = service.save(entity);

            } catch (BusinessException e) {
                e.printStackTrace();
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity<>(savedData, HttpStatus.OK);
    }
        
}
