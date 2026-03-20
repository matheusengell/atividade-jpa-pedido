package com.atividade.jpa_pedido.dto.itemPedido;

public record ItemPedidoRequestDto(

        String nomeProduto,
        Integer quantidade,
        Double precoUnitario,
        Long idPedido
) {
}
