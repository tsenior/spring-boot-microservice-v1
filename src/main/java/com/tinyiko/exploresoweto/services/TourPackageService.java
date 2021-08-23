package com.tinyiko.exploresoweto.services;

import com.tinyiko.exploresoweto.domain.TourPackage;
import com.tinyiko.exploresoweto.repositories.TourPackageRepository;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {

    private TourPackageRepository tourPackageRepository;


    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code, String name){
        return tourPackageRepository.findById(code)
                .orElse(tourPackageRepository.save(new TourPackage(code, name)));

    }

    public Iterable<TourPackage> lookup(){
        return tourPackageRepository.findAll();
    }
    public long tourPackagesCounter(){
        return tourPackageRepository.count();
    }
}
