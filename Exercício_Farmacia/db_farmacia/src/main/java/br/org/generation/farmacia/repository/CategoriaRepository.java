package br.org.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.farmacia.model.CategoriaFarmacia;

@Repository
public interface CategoriaRepository extends JpaRepository <CategoriaFarmacia, Long>{

	
		public List <CategoriaFarmacia> findAllByNomeContainingIgnoreCase (String nome);
	
}
