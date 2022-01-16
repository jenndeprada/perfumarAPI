package com.perfumar.perfumar_proyect.service;

import com.perfumar.perfumar_proyect.dao.PerfumeDao;
import com.perfumar.perfumar_proyect.model.Perfume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PerfumeService {

    private final PerfumeDao perfumeDao;

    @Autowired
    public PerfumeService(PerfumeDao perfumeDao){
        this.perfumeDao = perfumeDao;
    }

    public int addPerfume(Perfume perfume){
        return perfumeDao.insertPerfume(perfume);
    }

    public List<Perfume> getAllPerfumes(){
        return perfumeDao.selectAllPerfumes();
    }

    public Optional<Perfume> selectPerfumeById(UUID id) {
        return perfumeDao.selectPerfumeById(id);
    }

    public int deletePerfume(UUID id){
        return perfumeDao.deletePerfumeById(id);
    }

    public int updatePerfumeById(UUID id, Perfume newPerfumeUpdated){
        return perfumeDao.updatePerfumeById(id, newPerfumeUpdated);
    }

}
