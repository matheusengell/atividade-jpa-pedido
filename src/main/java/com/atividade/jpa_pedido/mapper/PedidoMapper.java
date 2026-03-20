package com.atividade.jpa_pedido.mapper;

import com.atividade.jpa_pedido.dto.pedido.PedidoRequisicaoDto;
import com.atividade.jpa_pedido.dto.pedido.PedidoRespostaDto;
import com.atividade.jpa_pedido.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public Pedido paraEntidade(PedidoRequisicaoDto requisicaoDto){
        return new Pedido(
                requisicaoDto.data_pedido()
        );
    }

    public PedidoRespostaDto paraDto(Pedido pedido){
        return new PedidoRespostaDto(
                pedido.getId(),
                pedido.getData_pedido()
        );
    }
}
