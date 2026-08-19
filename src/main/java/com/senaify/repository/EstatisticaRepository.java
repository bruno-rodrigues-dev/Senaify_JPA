package com.senaify.repository;

import com.senaify.model.Estatistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstatisticaRepository extends JpaRepository<Estatistica, Long> {

    // Buscar estatísticas pela música associada (por ID da música)
    Optional<Estatistica> findByMusicaId(Long musicaId);

    // Buscar o total de reproduções de todas as músicas de um artista
    @Query("SELECT SUM(e.totalReproducoes) FROM Estatistica e WHERE e.musica.artista.id = :artistaId")
    Long buscarTotalReproducoesPorArtista(@Param("artistaId") Long artistaId);

    // Buscar estatísticas com mais de X reproduções
    List<Estatistica> findByTotalReproducoesGreaterThan(Long minimo);

    // Buscar estatísticas com mais curtidas que o valor informado, ordenadas por curtidas
    @Query("SELECT e FROM Estatistica e WHERE e.totalCurtidas > :curtidas ORDER BY e.totalCurtidas DESC")
    List<Estatistica> buscarMaisCurtidas(@Param("curtidas") Long curtidas);

    // Buscar estatísticas com reproduções acima do mínimo, ordenadas pelo título da música
    List<Estatistica> findByTotalReproducoesGreaterThanOrderByMusicaTituloDesc(Long minimo);
}