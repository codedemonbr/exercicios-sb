package br.com.codedemonbr.exerciciossb.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.codedemonbr.exerciciossb.model.entities.Produto;

public interface ProdutoRepository  extends CrudRepository<Produto, Integer> {

}
