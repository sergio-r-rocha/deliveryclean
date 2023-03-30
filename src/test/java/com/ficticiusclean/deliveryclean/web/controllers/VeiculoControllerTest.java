package com.ficticiusclean.deliveryclean.web.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ficticiusclean.deliveryclean.business.veiculo.VeiculoService;
import com.ficticiusclean.deliveryclean.entities.Veiculo;
import com.ficticiusclean.deliveryclean.web.dto.veiculo.AtualizaVeiculoDto;
import com.ficticiusclean.deliveryclean.web.dto.veiculo.CadastroVeiculoDto;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class VeiculoControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private VeiculoService serviceMock;
	
	@Mock
	private Page<Veiculo> pageMock;
	
	@Mock
	private Veiculo veiculoMock;
	
	@Autowired
	private JacksonTester<CadastroVeiculoDto> cadastroVeiculoDtoJson;
	
	@Autowired
	private JacksonTester<AtualizaVeiculoDto> atualizaVeiculoDtoJson;

	@Test
	void listar_status_200() throws Exception {
		Mockito.when(serviceMock.listar(any())).thenReturn(pageMock);
		var response = mvc.perform(get("/veiculos")).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualByComparingTo(HttpStatus.OK.value());
	}
	
	@Test
	void listar_status_400() throws Exception {
		Mockito.when(serviceMock.listar(any())).thenThrow(new RuntimeException());
		
		boolean erro = false;
		
		try {
			mvc.perform(get("/veiculos"));
		} catch (Exception e) {
			erro = true;
		}
		
		assertTrue(erro);
	}
	
	@Test
	void cadastrar_status_200() throws Exception {
		Mockito.when(serviceMock.cadastrar(any())).thenReturn(veiculoMock);
		var cadastroVeiculoDto = new CadastroVeiculoDto("Veiculo " + UUID.randomUUID().toString(), "Marca", "Modelo",
				LocalDate.now(), BigDecimal.TEN, BigDecimal.TEN);
		String json = cadastroVeiculoDtoJson.write(cadastroVeiculoDto).getJson();
		var response = mvc.perform(post("/veiculos").contentType(MediaType.APPLICATION_JSON).content(json)).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualByComparingTo(HttpStatus.CREATED.value());
	}
	
	@Test
	void cadastrar_status_400() throws Exception {
		Mockito.when(serviceMock.cadastrar(any())).thenThrow(new RuntimeException());
		
		var cadastroVeiculoDto = new CadastroVeiculoDto("Veiculo " + UUID.randomUUID().toString(), "Marca", "Modelo",
				LocalDate.now(), BigDecimal.TEN, BigDecimal.TEN);
		String json = cadastroVeiculoDtoJson.write(cadastroVeiculoDto).getJson();
		
		boolean erro = false;
		
		try {
			mvc.perform(post("/veiculos").contentType(MediaType.APPLICATION_JSON).content(json));
		} catch (Exception e) {
			erro = true;
		}
		
		assertTrue(erro);
	}

	@Test
	void atualizar_status_200() throws Exception {
		Mockito.when(serviceMock.atualizar(any())).thenReturn(veiculoMock);
		var atualizaVeiculoDto = new AtualizaVeiculoDto(1L, "Veiculo " + UUID.randomUUID().toString(), "Marca", "Modelo",
				LocalDate.now(), BigDecimal.TEN, BigDecimal.TEN);
		String json = atualizaVeiculoDtoJson.write(atualizaVeiculoDto).getJson();
		var response = mvc.perform(put("/veiculos").contentType(MediaType.APPLICATION_JSON).content(json)).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualByComparingTo(HttpStatus.OK.value());
	}
	
	@Test
	void atualizar_status_400() throws Exception {
		Mockito.when(serviceMock.atualizar(any())).thenThrow(new RuntimeException());
		
		var atualizaVeiculoDto = new AtualizaVeiculoDto(1L, "Veiculo " + UUID.randomUUID().toString(), "Marca", "Modelo",
				LocalDate.now(), BigDecimal.TEN, BigDecimal.TEN);
		String json = atualizaVeiculoDtoJson.write(atualizaVeiculoDto).getJson();
		
		boolean erro = false;
		
		try {
			mvc.perform(put("/veiculos").contentType(MediaType.APPLICATION_JSON).content(json));
		} catch (Exception e) {
			erro = true;
		}
		
		assertTrue(erro);
	}
	
	@Test
	void excluir_status_200() throws Exception {
		var response = mvc.perform(delete("/veiculos/1")).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualByComparingTo(HttpStatus.NO_CONTENT.value());
	}
	
	@Test
	void excluir_status_400() throws Exception {
		Mockito.doThrow(new RuntimeException()).when(serviceMock).excluir(any());
		
		boolean erro = false;
		
		try {
			mvc.perform(delete("/veiculos/1"));
		} catch (Exception e) {
			erro = true;
		}
		
		assertTrue(erro);
	}

}
