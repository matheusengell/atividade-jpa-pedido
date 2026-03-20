package com.atividade.jpa_pedido.controller;

import com.atividade.jpa_pedido.dto.PedidoRequisicaoDto;
import com.atividade.jpa_pedido.dto.PedidoRespostaDto;
import com.atividade.jpa_pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public PedidoRespostaDto criarPedido(@RequestBody PedidoRequisicaoDto requisicaoDto){
        try {
            return service.criarPedido(requisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<PedidoRespostaDto> listarTodos(){
        try {
            return service.listarTodos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public PedidoRespostaDto atualizarPedido(@RequestBody PedidoRequisicaoDto requisicaoDto, @PathVariable Long id){
        try {
            return service.atualizarPedido(requisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id){
        try {
            service.deletarPedido(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
