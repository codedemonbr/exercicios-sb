package br.com.codedemonbr.exerciciossb.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metodos")
public class MetodosHttpController {

	@GetMapping
	public String get() {
		return "Requisição GET";
	}

	@PostMapping
	public String post() {
		return "Um POST";

	}

	@PutMapping
	public String put() {
		return "Um PUT";
	}

	@PatchMapping
	public String patch() {
		return "Um Patch";
	}

	@DeleteMapping
	public String detele() {
		return "um delete";
	}
}
