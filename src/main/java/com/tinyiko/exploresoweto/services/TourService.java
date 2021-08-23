package com.tinyiko.exploresoweto.services;

import com.tinyiko.exploresoweto.domain.Difficulty;
import com.tinyiko.exploresoweto.domain.Region;
import com.tinyiko.exploresoweto.domain.Tour;
import com.tinyiko.exploresoweto.domain.TourPackage;
import com.tinyiko.exploresoweto.repositories.TourPackageRepository;
import com.tinyiko.exploresoweto.repositories.TourRepository;
import org.springframework.stereotype.Service;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String description, String blurb,
                           Integer price, String duration, String bullets,
                           String keywords, String tourPackageName,
                           Difficulty difficulty, Region region){

        TourPackage aTourPackage = tourPackageRepository.findById(tourPackageName)
                .orElseThrow(() -> new RuntimeException("Tour package "+ tourPackageName +" does not exists"));

        return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets,
                keywords, aTourPackage, difficulty, region));

    }
    public Iterable<Tour> lookup(){
        return tourRepository.findAll();
    }
    public long tourCounter(){
        return tourRepository.count();
    }
}
