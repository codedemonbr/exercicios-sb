package br.com.codedemonbr.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.codedemonbr.exerciciossb.model.entities.Produto;

interface CRUDOptions extends CrudRepository<Produto, Integer>, PagingAndSortingRepository<Produto, Integer> {
}

public interface ProdutoRepository extends CRUDOptions {

	public Iterable<Produto> findByNameContainingIgnoreCase(String parteNome);

//	findByNomeContaining
//	findByNomeIsContaining
//	findByNomeContains
//	
//	findByNomeStartsWith
//	findByNomeEndsWith
//	
//	findByNomeNotContaining

	@Query("SELECT p FROM Produto p WHERE p.name LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String nome);

}
