package com.ficticiusclean.deliveryclean.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ficticiusclean.deliveryclean.business.veiculo.VeiculoService;
import com.ficticiusclean.deliveryclean.entities.Veiculo;
import com.ficticiusclean.deliveryclean.web.dto.veiculo.AtualizaVeiculoDto;
import com.ficticiusclean.deliveryclean.web.dto.veiculo.CadastroVeiculoDto;
import com.ficticiusclean.deliveryclean.web.dto.veiculo.ConsultaVeiculoDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping
	public ResponseEntity<ConsultaVeiculoDto> cadastrar(@RequestBody @Valid CadastroVeiculoDto dados) {
		Veiculo veiculo = veiculoService.cadastrar(new Veiculo(dados));
		ConsultaVeiculoDto consultaVeiculo = new ConsultaVeiculoDto(veiculo);
		return ResponseEntity.status(HttpStatus.CREATED).body(consultaVeiculo);
	}
	
	@PutMapping
	public ResponseEntity<ConsultaVeiculoDto> atualizar(@RequestBody @Valid AtualizaVeiculoDto dados) {
		Veiculo veiculo = veiculoService.atualizar(new Veiculo(dados));
		ConsultaVeiculoDto consultaVeiculo = new ConsultaVeiculoDto(veiculo);
		return ResponseEntity.ok(consultaVeiculo);
	}

	@GetMapping
	public ResponseEntity<Page<ConsultaVeiculoDto>> listar(Pageable pageable) {
		var page = veiculoService.listar(pageable).map(ConsultaVeiculoDto::new);
		return ResponseEntity.ok(page);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		veiculoService.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
