package com.crop_production.crop_production_app.repository;

import com.crop_production.crop_production_app.entity.CropData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends CrudRepository<CropData, Integer> {
}
