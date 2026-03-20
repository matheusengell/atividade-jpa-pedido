package com.atividade.jpa_pedido.dto.pedido;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record PedidoRequisicaoDto(

        @PastOrPresent(message = "A data deve ser no passado/presente")
        @NotNull(message = "A data é obrigatória")
        LocalDate data_pedido

) {
}
