package com.petshop.paymentservice.service;

import com.petshop.paymentservice.model.Pagamento;
import com.petshop.paymentservice.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;
    private final Random random = new Random();

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento processarPagamento(Pagamento pagamento) {
        boolean sucesso = random.nextBoolean();
        pagamento.setStatus(sucesso ? "CONFIRMADO" : "FALHA");
        return pagamentoRepository.save(pagamento);
    }

    public Optional<Pagamento> buscarPorPedidoId(Long pedidoId) {
        return pagamentoRepository.findByPedidoId(pedidoId);
    }
}