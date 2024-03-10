package com.aquila.udemyacademi.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquila.udemyacademi.exceptions.BusinessException;
import com.aquila.udemyacademi.models.entities.Produto;
import com.aquila.udemyacademi.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id) throws BusinessException{
        if(Objects.isNull(id))
            throw new BusinessException("É obrigatório informar um id", 001);

        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto save(Produto produto) throws BusinessException{
        if(Objects.nonNull(produto)){
            
                return produtoRepository.save(produto);
        }else{
            return null;
        }

    }

}
