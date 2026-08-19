package com.senaify.repository;

import com.senaify.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {

    // Buscar músicas por gênero musical
    List<Musica> findByGenero(String genero);

    // Buscar músicas com duração maior que o valor informado (em segundos)
    @Query("SELECT m FROM Musica m WHERE m.duracaoSegundos > :duracao")
    List<Musica> buscarMusicasLongas(@Param("duracao") Integer duracaoMinima);

    // Buscar músicas de um artista ordenadas por título em ordem ascendente
    List<Musica> findByArtistaIdOrderByTituloAsc(Long artistaId);

    // Buscar músicas lançadas em determinado ano
    @Query("SELECT m FROM Musica m WHERE m.anoLancamento = :ano")
    List<Musica> buscarPorAnoLancamento(@Param("ano") Integer ano);

    // Buscar músicas lançadas entre dois anos
    List<Musica> findByAnoLancamentoBetween(Integer anoInicio, Integer anoFim);
}
