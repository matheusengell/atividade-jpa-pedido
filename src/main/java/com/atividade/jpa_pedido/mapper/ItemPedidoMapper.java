package com.atividade.jpa_pedido.mapper;

import com.atividade.jpa_pedido.dto.itemPedido.ItemPedidoRequestDto;
import com.atividade.jpa_pedido.dto.itemPedido.ItemPedidoResponseDto;
import com.atividade.jpa_pedido.model.ItemPedido;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoMapper {

    public ItemPedido paraEntidade(ItemPedidoRequestDto itemPedidoRequestDto){
        return new ItemPedido(
                itemPedidoRequestDto.nomeProduto(),
                itemPedidoRequestDto.quantidade(),
                itemPedidoRequestDto.precoUnitario()
        );
    }

    public ItemPedidoResponseDto paraDto(ItemPedido itemPedido){
        return new ItemPedidoResponseDto(
                itemPedido.getId(),
                itemPedido.getNomeProduto(),
                itemPedido.getQuantidade(),
                itemPedido.getPrecoUnitario(),
                itemPedido.getPedido().getId()
        );
    }
}
