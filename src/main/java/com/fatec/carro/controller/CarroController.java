package com.fatec.carro.controller;

import com.fatec.carro.dto.CarroDTO;
import com.fatec.carro.model.Carro;
import com.fatec.carro.model.TipoCarro;
import com.fatec.carro.service.CarroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping({"/carros", ""})
    public String buscarCarros(Model model) {

        List<Carro> carros = carroService.buscarTodos();

        model.addAttribute("carros", carros);

        return "carro/lista";
    }

    @GetMapping("/carros/novo")
    public String novoCarro(Model model) {

        model.addAttribute("carroDTO", new CarroDTO());
        model.addAttribute("isEdicao", false);
        model.addAttribute("tipos", TipoCarro.values());

        return "carro/form";
    }

    @PostMapping("/carros/novo")
    public String novoCarro(@Valid CarroDTO carroDTO,
                            BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/carros/novo";
        }

        Carro carro = carroDTO.toCarro();

        carroService.salvar(carro);

        return "redirect:/carros";
    }

    @GetMapping("/carros/{carroId}/editar")
    public String editarCarro(@PathVariable Long carroId,
                              CarroDTO carroDTO,
                              Model model) {

        Optional<Carro> carroOptional = carroService.buscarPorId(carroId);

        if (!carroOptional.isPresent()) {
            return "redirect:/carros";
        }

        if (carroDTO == null) {
            model.addAttribute("carroDTO", new CarroDTO(carroOptional.get()));
        }
        model.addAttribute("isEdicao", true);
        model.addAttribute("tipos", TipoCarro.values());

        return "carro/form";
    }

    @PostMapping("/carros/{carroId}/editar")
    public String editarCarro(@PathVariable Long carroId,
                              @Valid CarroDTO carroDTO,
                              BindingResult result) {

        if (result.hasErrors()) {
            return String.format("redirect:/carros/%s/editar", carroId);
        }

        Optional<Carro> carroOptional = carroService.buscarPorId(carroId);

        if (!carroOptional.isPresent()) {
            return "redirect:/carros";
        }

        carroService.salvar(
                carroDTO.toCarro(carroOptional.get())
        );

        return "redirect:/carros";
    }

    @GetMapping("/carros/{carroId}/excluir")
    public String excluirCarro(@PathVariable Long carroId) {

        Optional<Carro> carroOptional = carroService.buscarPorId(carroId);

        if (!carroOptional.isPresent()) {
            return "redirect:/carros";
        }

        carroService.excluir(carroOptional.get());

        return "redirect:/carros";
    }

}