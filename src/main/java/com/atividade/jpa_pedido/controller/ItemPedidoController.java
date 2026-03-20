package com.atividade.jpa_pedido.controller;

import com.atividade.jpa_pedido.dto.itemPedido.ItemPedidoRequestDto;
import com.atividade.jpa_pedido.dto.itemPedido.ItemPedidoResponseDto;
import com.atividade.jpa_pedido.service.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService service;

    @PostMapping
    public ItemPedidoResponseDto criarItem(@RequestBody ItemPedidoRequestDto itemPedidoRequestDto){
        return service.criarItem(itemPedidoRequestDto);
    }

    @GetMapping
    public List<ItemPedidoResponseDto> listar(){
        return service.listarItens();
    }

    @PutMapping("/{id}")
    public ItemPedidoResponseDto atualizar(@RequestBody ItemPedidoRequestDto requestDto, @PathVariable Long id){
        return service.atualizar(requestDto, id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
