package com.senaify.repository;

import com.senaify.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    // Buscar artistas cujo nome contenha o texto informado
    List<Artista> findByNomeContaining(String nome);

    // Buscar artistas por nacionalidade
    @Query("SELECT a FROM Artista a WHERE a.nacionalidade = :nacionalidade")
    List<Artista> buscarPorNacionalidade(@Param("nacionalidade") String nacionalidade);

    // Buscar artistas que possuem biografia preenchida
    List<Artista> findByBiografiaIsNotNull();

    // Buscar artistas cujo nome seja parecido com o informado (LIKE)
    @Query("SELECT a FROM Artista a WHERE a.nome LIKE %:nome%")
    List<Artista> buscarPorNomeParecido(@Param("nome") String nome);

}
