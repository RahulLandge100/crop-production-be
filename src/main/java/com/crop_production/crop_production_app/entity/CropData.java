package com.crop_production.crop_production_app.entity;

import com.crop_production.crop_production_app.model.CropDataLookUp;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "crop_data")
public class CropData {

    @Id
    private Integer cropId;
    @NotBlank(message = "Crop name should be present, Please check!")
    @Size(min = 2, max = 30, message = "Crop name size must be between 5 and 30")
    private String cropName;
    private String state;
    private String district;
    @NotBlank(message = "Year should be present, Please check!")
    @Size(min = 3, max = 30, message = "Year size must be between 5 and 30")
    private String year;
    private String season;
    private Double area;
    private String areaUnits = "Hectare";
    private Double production;
    @Enumerated(EnumType.STRING)
    private ProductionUnits productionUnits;
    private Double yield;

    public static CropDataLookUp prepareCropDataLookUp(CropData cropData) {
        CropDataLookUp cropDataLookUp = new CropDataLookUp();
        cropDataLookUp.setCropId(cropData.getCropId());
        cropDataLookUp.setCropName(cropData.getCropName());
        cropDataLookUp.setState(cropData.getState());
        cropDataLookUp.setDistrict(cropData.getDistrict());
        cropDataLookUp.setYear(cropData.getYear());
        cropDataLookUp.setSeason(cropData.getSeason());
        cropDataLookUp.setArea(cropData.getArea());
        cropDataLookUp.setAreaUnits(cropData.getAreaUnits());
        cropDataLookUp.setProduction(cropData.getProduction());
        cropDataLookUp.setProductionUnits(cropData.getProductionUnits());
        cropDataLookUp.setYield(cropData.getYield());
        return cropDataLookUp;
    }
}
