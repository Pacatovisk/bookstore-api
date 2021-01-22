package com.marcelo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.bookstore.domain.Categoria;
import com.marcelo.bookstore.domain.Livro;
import com.marcelo.bookstore.repositories.CategoriaRepository;
import com.marcelo.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "TI", "livro de TI");
		Livro livro1 = new Livro(null, "Java", "João Silva", "lorem ipsum", cat1);

		Categoria cat2 = new Categoria(null, "TI", "livro de TI");
		Livro livro2 = new Livro(null, "Html", "Julio Albuquerque", "lorem ipsum", cat2);

		Categoria cat3 = new Categoria(null, "COMÉDIA", "livro de TI");
		Livro livro3 = new Livro(null, "TI", "Waldir Braz", "lorem ipsum", cat3);

		cat1.getLivros().addAll(Arrays.asList(livro1));
		cat2.getLivros().addAll(Arrays.asList(livro2));
		cat3.getLivros().addAll(Arrays.asList(livro3));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3));
	}
}
