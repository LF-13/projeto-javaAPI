package br.co.alura.linguagensapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }

    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
//        Linguagem linguagemSalva = repositorio.save(linguagem);
//        return linguagemSalva;
        return repositorio.save(linguagem);
    }

    @DeleteMapping("/linguagens/{linguagemId}")
    public void deleteLinguagem(@PathVariable String linguagemId) {
        repositorio.deleteById(linguagemId);
    }

}
