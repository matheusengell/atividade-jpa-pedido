package com.atividade.jpa_pedido.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record PedidoRespostaDto(

         Long id,
         LocalDate data_pedido
) {
}
