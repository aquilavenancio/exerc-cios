package com.aquila.udemyacademi;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aquila.udemyacademi.models.entities.Categoria;
import com.aquila.udemyacademi.models.entities.Produto;
import com.aquila.udemyacademi.repository.ProdutoRepository;
import com.aquila.udemyacademi.services.CategoriaService;

@SpringBootApplication
public class UdemyacademiApplication implements CommandLineRunner{


	@Autowired
	private CategoriaService catService;
	@Autowired
	private ProdutoRepository repositoryProduto;

	public static void main(String[] args) {
		SpringApplication.run(UdemyacademiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// List<Categoria> categorias = catService.findAll();

		// categorias.forEach(categoria -> {
		
		// 	Produto produto = new Produto(null,
		// 						"Monitor AOC "+categoria.getNome(),
		// 						129.65);
		

		// 	produto.getCategorias().add(categoria);	
			
		// 	repositoryProduto.save(produto);
		// });


	}

}
