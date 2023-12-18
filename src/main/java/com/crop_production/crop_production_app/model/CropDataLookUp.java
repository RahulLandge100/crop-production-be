package com.crop_production.crop_production_app.model;

import com.crop_production.crop_production_app.entity.CropData;
import com.crop_production.crop_production_app.entity.ProductionUnits;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CropDataLookUp {
    private Integer cropId;
    private String cropName;
    private String state;
    private String district;
    private String year;
    private String season;
    private Double area;
    private String areaUnits;
    private Double production;
    @Enumerated(EnumType.STRING)
    private ProductionUnits productionUnits;
    private Double yield;

    public static CropData prepareCropDataLookUp(CropDataLookUp cropDataLookUp) {
        CropData cropData = new CropData();
        cropData.setCropId(cropDataLookUp.getCropId());
        cropData.setCropName(cropDataLookUp.getCropName());
        cropData.setState(cropDataLookUp.getState());
        cropData.setDistrict(cropDataLookUp.getDistrict());
        cropData.setYear(cropDataLookUp.getYear());
        cropData.setSeason(cropDataLookUp.getSeason());
        cropData.setArea(cropDataLookUp.getArea());
        cropData.setAreaUnits(cropDataLookUp.getAreaUnits());
        cropData.setProduction(cropDataLookUp.getProduction());
        cropData.setProductionUnits(cropDataLookUp.getProductionUnits());
        cropData.setYield(cropDataLookUp.getYield());
        return cropData;
    }

}
