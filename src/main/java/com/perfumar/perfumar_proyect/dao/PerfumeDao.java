package com.perfumar.perfumar_proyect.dao;

import com.perfumar.perfumar_proyect.model.Perfume;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PerfumeDao {
    int insertPerfume(UUID id, Perfume perfume);

    default int insertPerfume(Perfume perfume){
        UUID id = UUID.randomUUID();
        return insertPerfume(id, perfume);
    }

    List<Perfume> selectAllPerfumes();

    //creamos los metodos en la interfaz y lurgo los importamos en la DAO
    Optional<Perfume> selectPerfumeById(UUID id);

    int deletePerfumeById(UUID id);

    int updatePerfumeById(UUID id, Perfume perfume );

}
