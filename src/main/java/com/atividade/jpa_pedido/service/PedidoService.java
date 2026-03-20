package com.atividade.jpa_pedido.service;

import com.atividade.jpa_pedido.dto.PedidoRequisicaoDto;
import com.atividade.jpa_pedido.dto.PedidoRespostaDto;
import com.atividade.jpa_pedido.mapper.PedidoMapper;
import com.atividade.jpa_pedido.model.Pedido;
import com.atividade.jpa_pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final PedidoMapper mapper;

    public PedidoRespostaDto criarPedido(PedidoRequisicaoDto requisicaoDto)throws SQLException{
        Pedido pedido = mapper.paraEntidade(requisicaoDto);
        repository.save(pedido);
        return mapper.paraDto(pedido);
    }

    public List<PedidoRespostaDto> listarTodos()throws SQLException{
        List<Pedido> pedidos = repository.findAll();
        return pedidos.stream()
                .map(mapper:: paraDto)
                .toList();
    }

    public PedidoRespostaDto atualizarPedido(PedidoRequisicaoDto requisicaoDto, Long id)throws SQLException{
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setData_pedido(requisicaoDto.data_pedido());

        Pedido pedidoAtualizado = repository.save(pedido);
        return mapper.paraDto(pedidoAtualizado);
    }

    public void deletarPedido(Long id)throws SQLException{
        repository.deleteById(id);
    }
}
