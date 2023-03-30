package com.ficticiusclean.deliveryclean.web.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ficticiusclean.deliveryclean.business.previsaogasto.PrevisaoGasto;
import com.ficticiusclean.deliveryclean.business.previsaogasto.PrevisaoGastoService;
import com.ficticiusclean.deliveryclean.web.dto.previsao.PrevisaoGastoDto;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("previsoes-gastos")
public class PrevisaoGastosController {

	@Autowired
	private PrevisaoGastoService previsaoGastoService;

	@GetMapping
	public List<PrevisaoGastoDto> listarRankeado(
			@RequestParam @NotNull BigDecimal precoGasolina,
			@RequestParam @NotNull BigDecimal kmCidade, 
			@RequestParam @NotNull BigDecimal kmRodovias) {
		List<PrevisaoGasto> listPrevisao = previsaoGastoService.calcularPrevisao(precoGasolina, kmCidade, kmRodovias);
		return listPrevisao.stream().map(PrevisaoGastoDto::new).toList();
	}

}
