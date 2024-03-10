package com.aquila.udemyacademi.resorce;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquila.udemyacademi.models.entities.Categoria;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micrometer.common.util.StringUtils;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    
    @GetMapping
    public String listar(){

        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNome("Informática");

        Categoria categoria1 = new Categoria();
        categoria1.setId(2L);
        categoria1.setNome("Office");


        Categoria categoria3 = new Categoria();
        categoria3.setId(2L);
        categoria3.setNome("Office");



        ObjectMapper mapper = new ObjectMapper();
        String serializedCategoriaString  = "";
        try {
            serializedCategoriaString = mapper.writeValueAsString(Arrays.asList(categoria, categoria1, categoria3));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return serializedCategoriaString;
    }
}
