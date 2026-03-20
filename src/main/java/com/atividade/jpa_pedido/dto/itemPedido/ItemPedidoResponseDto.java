package com.atividade.jpa_pedido.dto.itemPedido;

public record ItemPedidoResponseDto(
        Long id,
        String nomeProduto,
        Integer quantidade,
        Double precoUnitario,
        Long idPedido
) {
}
