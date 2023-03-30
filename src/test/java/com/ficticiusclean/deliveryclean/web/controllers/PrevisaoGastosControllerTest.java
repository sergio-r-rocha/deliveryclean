package com.ficticiusclean.deliveryclean.web.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import com.ficticiusclean.deliveryclean.business.previsaogasto.PrevisaoGastoService;

@SpringBootTest
@AutoConfigureMockMvc
class PrevisaoGastosControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private PrevisaoGastoService service;
	
	@Test
	void calcular_previsao_parametros_corretos_status_200() throws Exception {
		var response = mvc.perform(get("/previsoes-gastos?precoGasolina=5&kmCidade=5&kmRodovias=5")).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualByComparingTo(HttpStatus.OK.value());
	}
	
	@Test
	void calcular_previsao_nenhum_parametro_informado_status_400() throws Exception {
		var response = mvc.perform(get("/previsoes-gastos")).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST.value());
	}

	@Test
	void calcular_previsao_preco_gasolina_nao_informado_status_400() throws Exception {
		var response = mvc.perform(get("/previsoes-gastos?kmCidade=5&kmRodovias=5")).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	void calcular_previsao_km_cidade_nao_informado_status_400() throws Exception {
		var response = mvc.perform(get("/previsoes-gastos?precoGasolina=5&kmRodovias=5")).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	void calcular_previsao_km_rodovias_nao_informado_status_400() throws Exception {
		var response = mvc.perform(get("/previsoes-gastos?precoGasolina=5&kmCidade=5")).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST.value());
	}

}
