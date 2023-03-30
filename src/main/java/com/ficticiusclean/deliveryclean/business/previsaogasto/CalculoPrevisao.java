package com.ficticiusclean.deliveryclean.business.previsaogasto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ficticiusclean.deliveryclean.entities.Veiculo;
import com.ficticiusclean.deliveryclean.repositories.VeiculoRepository;

@Component
public class CalculoPrevisao {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private CalculoQuantidadeCombustivel calculoQuantidadeCombustivel;
	@Autowired
	private CalculoValorGasto calculoValorGasto;
	
	public List<PrevisaoGasto> calcularPrevisao(BigDecimal precoGasolina, BigDecimal kmCidade, BigDecimal kmRodovias) {
		List<Veiculo> listVeiculos = veiculoRepository.findAll();
		List<PrevisaoGasto> listPrevisaoGastos = new ArrayList<>(listVeiculos.stream().map(veiculo -> {
			return extracted(precoGasolina, kmCidade, kmRodovias, veiculo);
		}).toList());
		
		return listPrevisaoGastos;
	}

	private PrevisaoGasto extracted(BigDecimal precoGasolina, BigDecimal kmCidade, BigDecimal kmRodovias,
			Veiculo veiculo) {
		BigDecimal quantidadeCombustivel = calculoQuantidadeCombustivel.calcular(veiculo, kmCidade, kmRodovias);
		BigDecimal valorGasto = calculoValorGasto.calcular(precoGasolina, quantidadeCombustivel);
		
		return new PrevisaoGasto(veiculo, quantidadeCombustivel, valorGasto);
	}

}
