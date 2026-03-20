package com.atividade.jpa_pedido.service;

import com.atividade.jpa_pedido.dto.itemPedido.ItemPedidoRequestDto;
import com.atividade.jpa_pedido.dto.itemPedido.ItemPedidoResponseDto;
import com.atividade.jpa_pedido.mapper.ItemPedidoMapper;
import com.atividade.jpa_pedido.model.ItemPedido;
import com.atividade.jpa_pedido.model.Pedido;
import com.atividade.jpa_pedido.repository.ItemPedidoRepository;
import com.atividade.jpa_pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemPedidoService {

    private final ItemPedidoRepository repository;
    private final PedidoRepository pedidoRepository;
    
    private final ItemPedidoMapper mapper;

    public ItemPedidoResponseDto criarItem(ItemPedidoRequestDto requestDto){
        Pedido pedido = pedidoRepository.findById(requestDto.idPedido())
                .orElseThrow(()-> new RuntimeException("Pedido não existe"));

        ItemPedido itemPedido = mapper.paraEntidade(requestDto);
        
        itemPedido.setPedido(pedido);
        
        return mapper.paraDto(repository.save(itemPedido));
    }


    public List<ItemPedidoResponseDto> listarItens(){
        List<ItemPedido> itemPedidos = repository.findAll();

        return itemPedidos.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public ItemPedidoResponseDto atualizar(ItemPedidoRequestDto requestDto, Long id){
        ItemPedido itemPedido = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrado"));

        if (!itemPedido.getPedido().getId().equals(requestDto.idPedido())){
            Pedido pedidoNovo = pedidoRepository.findById(requestDto.idPedido())
                    .orElseThrow(()-> new RuntimeException("Não encontrado"));
            itemPedido.setPedido(pedidoNovo);
        }

        itemPedido.setNomeProduto(requestDto.nomeProduto());
        itemPedido.setQuantidade(requestDto.quantidade());
        itemPedido.setPrecoUnitario(requestDto.precoUnitario());

        ItemPedido itemPedidoAtualizado = repository.save(itemPedido);
        return mapper.paraDto(itemPedidoAtualizado);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
