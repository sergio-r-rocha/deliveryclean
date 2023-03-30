package com.ficticiusclean.deliveryclean.business.veiculo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.ficticiusclean.deliveryclean.entities.Veiculo;

@SpringBootTest
@TestPropertySource(properties = { "delivery.clean.soft-delete=true" })
class VeiculoServiceExcluirSoftDeleteTest {
	
	@Autowired
	private VeiculoService service;
	
	@Test
	void excluir() {
		Long id = 1L;
		Veiculo veiculo = service.buscarPorId(id);
		assertThat(veiculo.isExcluido()).isFalse();
		service.excluir(id);
		veiculo = service.buscarPorId(id);
		assertNotNull(service.buscarPorId(id));
		assertThat(veiculo.isExcluido()).isTrue();
	}

}
