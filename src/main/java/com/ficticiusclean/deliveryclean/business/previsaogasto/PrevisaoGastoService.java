package com.ficticiusclean.deliveryclean.business.previsaogasto;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PrevisaoGastoService {

	@Autowired
	private CalculoPrevisao calculoPrevisao;
	@Autowired
	@Qualifier("economia")
	private OrdenacaoPrevisaoGasto ordenacao;

	public List<PrevisaoGasto> calcularPrevisao(BigDecimal precoGasolina, BigDecimal kmCidade, BigDecimal kmRodovias) {
		List<PrevisaoGasto> listPrevisaoGastos = calculoPrevisao.calcularPrevisao(precoGasolina, kmCidade, kmRodovias);
		ordenacao.executar(listPrevisaoGastos);
		
		return listPrevisaoGastos;
	}

}
