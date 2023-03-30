package com.ficticiusclean.deliveryclean.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ficticiusclean.deliveryclean.business.previsaogasto.OrdenacaoAnoPrevisaoGasto;
import com.ficticiusclean.deliveryclean.business.previsaogasto.OrdenacaoPrevisaoGasto;
import com.ficticiusclean.deliveryclean.business.previsaogasto.OrdenacaoValorPrevisaoGasto;

@Configuration
public class OrdenacaoPrevisaoGastoConfig {
	
	@Bean
	@Qualifier("economia")
	public OrdenacaoPrevisaoGasto createOrdenacaoValorPrevisaoGasto() {
		return new OrdenacaoValorPrevisaoGasto();
	}
	
	@Bean
	@Qualifier("antigos")
	public OrdenacaoPrevisaoGasto createOrdenacaoAnoPrevisaoGasto() {
		return new OrdenacaoAnoPrevisaoGasto();
	}

}
