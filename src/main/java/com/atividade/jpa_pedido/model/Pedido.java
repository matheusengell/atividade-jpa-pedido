package com.atividade.jpa_pedido.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Pedido")

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonProperty("data_pedido")
    private LocalDate data_pedido;

    public Pedido(LocalDate data_pedido) {
        this.data_pedido = data_pedido;
    }

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;
}
