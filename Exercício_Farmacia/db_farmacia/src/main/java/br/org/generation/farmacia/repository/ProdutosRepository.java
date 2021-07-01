package br.org.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.farmacia.model.ProdutosFarmacia;


@Repository
public interface ProdutosRepository extends JpaRepository <ProdutosFarmacia, Long> {
	
	
		
		public List <ProdutosFarmacia> findAllByTituloContainingIgnoreCase (String titulo);
		
}