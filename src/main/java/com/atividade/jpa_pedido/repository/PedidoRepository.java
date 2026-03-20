package com.atividade.jpa_pedido.repository;

import com.atividade.jpa_pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
