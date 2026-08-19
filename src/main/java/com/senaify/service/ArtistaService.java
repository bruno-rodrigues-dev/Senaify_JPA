package com.senaify.service;

import com.senaify.model.Artista;
import com.senaify.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    public List<Artista> listarTodos() {
        return artistaRepository.findAll();
    }

    public Optional<Artista> buscarPorId(Long id) {
        return artistaRepository.findById(id);
    }

    public Artista salvar(Artista artista) {
        return artistaRepository.save(artista);
    }

    public void deletar(Long id) {
        artistaRepository.deleteById(id);
    }

    public List<Artista> buscarPorNome(String nome) {
        return artistaRepository.findByNomeContaining(nome);
    }

    public List<Artista> buscarPorNacionalidade(String nacionalidade) {
        return artistaRepository.buscarPorNacionalidade(nacionalidade);
    }

    public List<Artista> buscarPorNomeParecido(String nome) {
        return artistaRepository.buscarPorNomeParecido(nome);
    }
}
