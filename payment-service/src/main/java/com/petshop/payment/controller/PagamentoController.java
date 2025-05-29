package com.petshop.paymentservice.controller;

import com.petshop.paymentservice.model.Pagamento;
import com.petshop.paymentservice.service.PagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @Operation(summary = "Processar pagamento (simulado)")
    @PostMapping
    public ResponseEntity<Pagamento> processarPagamento(@RequestBody Pagamento pagamento) {
        Pagamento resultado = pagamentoService.processarPagamento(pagamento);
        return ResponseEntity.ok(resultado);
    }

    @Operation(summary = "Buscar pagamento por pedido")
    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<Pagamento> buscarPorPedido(@PathVariable Long pedidoId) {
        Optional<Pagamento> pagamento = pagamentoService.buscarPorPedidoId(pedidoId);
        return pagamento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}