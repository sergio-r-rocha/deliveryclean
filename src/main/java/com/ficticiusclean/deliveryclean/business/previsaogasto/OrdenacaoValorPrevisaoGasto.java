package com.ficticiusclean.deliveryclean.business.previsaogasto;

import java.util.Comparator;
import java.util.List;

import org.springframework.context.annotation.Configuration;

@Configuration
public class OrdenacaoValorPrevisaoGasto extends OrdenacaoPrevisaoGastoDefault {

	@Override
	public void doSort(List<PrevisaoGasto> list) {
		list.sort(Comparator.comparing(PrevisaoGasto::getValorGasto));
	}

}
