package com.senaify.service;

import com.senaify.model.Musica;
import com.senaify.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    public List<Musica> listarTodas() {
        return musicaRepository.findAll();
    }

    public Optional<Musica> buscarPorId(Long id) {
        return musicaRepository.findById(id);
    }

    public Musica salvar(Musica musica) {
        return musicaRepository.save(musica);
    }

    public void deletar(Long id) {
        musicaRepository.deleteById(id);
    }

    public List<Musica> buscarPorGenero(String genero) {
        return musicaRepository.findByGenero(genero);
    }

    public List<Musica> buscarMusicasLongas(Integer duracaoMinima) {
        return musicaRepository.buscarMusicasLongas(duracaoMinima);
    }

    public List<Musica> buscarPorArtista(Long artistaId) {
        return musicaRepository.findByArtistaIdOrderByTituloAsc(artistaId);
    }

    public List<Musica> buscarPorAnoLancamento(Integer ano) {
        return musicaRepository.buscarPorAnoLancamento(ano);
    }
}
