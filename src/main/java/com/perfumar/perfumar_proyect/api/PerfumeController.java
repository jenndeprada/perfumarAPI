package com.perfumar.perfumar_proyect.api;

import com.perfumar.perfumar_proyect.model.Perfume;
import com.perfumar.perfumar_proyect.service.PerfumeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/perfume")
@RestController
public class PerfumeController {

    private final PerfumeService perfumeService;

    public PerfumeController(PerfumeService perfumeService){
        this.perfumeService = perfumeService;
    }

    @PostMapping
    public void addPerfume(@RequestBody Perfume perfume){
        perfumeService.addPerfume(perfume);
    }

    @GetMapping
    public List<Perfume> getAllPerfumes(){
        return perfumeService.getAllPerfumes();
    }

    @GetMapping(path = "{id}")
    public Perfume getPerfumeById(@PathVariable("id") UUID id) {
     return perfumeService.selectPerfumeById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerfumeById(@PathVariable("id") UUID id){
        perfumeService.deletePerfume(id);
    }
    @PutMapping(path = "{id}")
    public void updatePerfume(@PathVariable("id") UUID id, @RequestBody Perfume perfumeToUpdate){
        perfumeService.updatePerfumeById(id, perfumeToUpdate);
    }

}
