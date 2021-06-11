package com.fatec.carro.service;

import com.fatec.carro.model.Carro;
import com.fatec.carro.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<Carro> buscarTodos() {
        return carroRepository.findAll();
    }

    public Optional<Carro> buscarPorId(Long id) {
        return carroRepository.findById(id);
    }

    public void salvar(Carro carro) {
        carroRepository.save(carro);
    }

    public void excluir(Carro carro) {
        carroRepository.delete(carro);
    }

}