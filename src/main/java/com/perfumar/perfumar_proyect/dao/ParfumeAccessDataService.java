package com.perfumar.perfumar_proyect.dao;

import com.perfumar.perfumar_proyect.model.Perfume;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ParfumeAccessDataService implements PerfumeDao{

    private static List<Perfume> DB = new ArrayList<>();

    @Override
    public int insertPerfume(UUID id, Perfume perfume) {
        DB.add(new Perfume(id, perfume.getName()));
        return 1;
    }

    @Override
    public List<Perfume> selectAllPerfumes() {
        return DB;
    }

    @Override
    public Optional<Perfume> selectPerfumeById(UUID id) {
        return DB.stream().filter(perfume -> perfume.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePerfumeById(UUID id) {
        Optional<Perfume> theresPerfume = selectPerfumeById(id);
        if(theresPerfume.isEmpty()){
            return 0; // if there is not a perfume in database, return 0. Otherwise, delete it.
        }
        DB.remove(theresPerfume.get());
        return 1;
    }

    @Override
    public int updatePerfumeById(UUID id, Perfume perfume) {
        return selectPerfumeById(id).map(p -> {
            int indexOfPerfumeToUpdate = DB.indexOf(p);
            if(indexOfPerfumeToUpdate >= 0){
                DB.set(indexOfPerfumeToUpdate, new Perfume(id, perfume.getName()));
                return 1;
            }
            return 0;
        }) .orElse(0);

    }
}
