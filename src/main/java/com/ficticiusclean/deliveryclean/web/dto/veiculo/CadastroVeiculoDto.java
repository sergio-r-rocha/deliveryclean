package com.ficticiusclean.deliveryclean.web.dto.veiculo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroVeiculoDto(
		
		@NotBlank
		String nome,
		@NotBlank
		String marca,
		@NotBlank
		String modelo,
		@NotNull
		LocalDate dataFabricacao,
		@NotNull
		BigDecimal consumoCidade,
		@NotNull
		BigDecimal consumoRodovias) {

}
