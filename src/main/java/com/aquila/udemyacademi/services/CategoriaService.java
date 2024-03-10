package com.aquila.udemyacademi.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquila.udemyacademi.exceptions.BusinessException;
import com.aquila.udemyacademi.models.entities.Categoria;
import com.aquila.udemyacademi.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Long id) throws BusinessException{
        if(Objects.isNull(id))
            throw new BusinessException("É obrigatório informar um id", 001);

        return categoriaRepository.findById(id).orElse(null);
    }

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) throws BusinessException{
        if(Objects.nonNull(categoria)){
            if(!this.exists(categoria)){
                return categoriaRepository.save(categoria);
            }else {
                throw new BusinessException("Categoria já existe!", 2);
            }
        }else{
            return null;
        }

    }

    public boolean exists(Categoria categoria){
        Categoria categoriNoUnique = categoriaRepository.findByName(categoria.getNome());

        return Objects.nonNull(categoriNoUnique);
    }
}
