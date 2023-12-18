package com.crop_production.crop_production_app.service;

import com.crop_production.crop_production_app.entity.CropData;
import com.crop_production.crop_production_app.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CropService {
    @Autowired
    private CropRepository cropRepository;

    public Iterable<CropData> getAllCrops() {
        return cropRepository.findAll();
    }

    public String addCrop(CropData cropData) {
        CropData addedCropData = cropRepository.save(cropData);
        return "Crop added successfully with Id "+addedCropData.getCropId();
    }
}
