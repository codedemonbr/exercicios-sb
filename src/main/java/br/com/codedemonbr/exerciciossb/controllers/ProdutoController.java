package br.com.codedemonbr.exerciciossb.controllers;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.codedemonbr.exerciciossb.model.entities.Produto;
import br.com.codedemonbr.exerciciossb.model.repositories.ProdutoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

//	@PostMapping
//	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
//		produtoRepository.save(produto);
//		return produto;
//	}

	@GetMapping(path = "/all")
	public Iterable<Produto> obterProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
	public Page<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdePagina) {
		if (qtdePagina >= 5) {
			qtdePagina = 5;
		}
		PageRequest page = PageRequest.of(numeroPagina, qtdePagina);
		return produtoRepository.findAll(page);
	}

	@GetMapping(path = "/{id}")
	public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}

//	@PutMapping
//	public Produto alterarProduto(@Valid Produto produto) {
//		produtoRepository.save(produto);
//		return produto;
//	}

	@GetMapping(path = "/name/{parteNome}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
//		return produtoRepository.findByNameContainingIgnoreCase(parteNome);
		return produtoRepository.searchByNameLike(parteNome);
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public Produto alterarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}

	@DeleteMapping(path = "/{id}")
	public String excluirProduto(@PathVariable int id) {
		Optional<Produto> produto = produtoRepository.findById(id);

		if (!produto.isEmpty()) {
			String str = "O produto " + id + " foi deletado";
			produtoRepository.deleteById(id);
			return str;

		}
		return "Produto não encontrado";
	}

}
