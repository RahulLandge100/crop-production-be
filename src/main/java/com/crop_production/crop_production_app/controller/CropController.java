package com.crop_production.crop_production_app.controller;

import com.crop_production.crop_production_app.entity.CropData;
import com.crop_production.crop_production_app.exception.NoCropPresentException;
import com.crop_production.crop_production_app.model.CropDataLookUp;
import com.crop_production.crop_production_app.service.CropService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/crop")
@CrossOrigin
public class CropController {

    private final Logger logger = Logger.getLogger(CropController.class.getName());

    @Autowired
    private CropService cropService;

    @PostMapping("/add-crop")
    public String addCrop(@Valid @RequestBody CropData cropData) {
        logger.log(Level.INFO, "Inside addCrop method of CropController!");
        String response =cropService.addCrop(cropData);
        return response;
    }

    @GetMapping("/get-all-crops")
    public List<CropDataLookUp> getAllCrops() {
        logger.log(Level.INFO, "Inside getAllCrops method of CropController!");
        Iterable<CropData> crops =cropService.getAllCrops();
        List<CropDataLookUp> cropDataLookUpList = new ArrayList<>();
        for (CropData cropData : crops) {
            CropDataLookUp cropDataLookUp = CropData.prepareCropDataLookUp(cropData);
            cropDataLookUpList.add(cropDataLookUp);
        }
        if (cropDataLookUpList.size() <= 0) {
            throw new NoCropPresentException("Currently no crops present to show!");
        }
        return cropDataLookUpList;
    }
}
