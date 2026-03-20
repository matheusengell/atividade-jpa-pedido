package com.atividade.jpa_pedido.dto.pedido;

import java.time.LocalDate;

public record PedidoRespostaDto(

         Long id,
         LocalDate data_pedido
) {
}
