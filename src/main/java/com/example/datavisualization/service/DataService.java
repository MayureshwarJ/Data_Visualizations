package com.example.datavisualization.service;

import com.example.datavisualization.entity.DataEntity;
import com.example.datavisualization.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    public List<DataEntity> getAllData() {
        return dataRepository.findAll();
    }

    public Optional<DataEntity> getDataById(Long id) {
        return dataRepository.findById(id);
    }

    public DataEntity createData(DataEntity dataEntity) {
        return dataRepository.save(dataEntity);
    }

    public Optional<DataEntity> updateData(Long id, DataEntity newDataEntity) {
        Optional<DataEntity> optionalDataEntity = dataRepository.findById(id);
        if (optionalDataEntity.isPresent()) {
            DataEntity existingDataEntity = optionalDataEntity.get();
            existingDataEntity.setName(newDataEntity.getName());
            existingDataEntity.setValue(newDataEntity.getValue());
            return Optional.of(dataRepository.save(existingDataEntity));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteData(Long id) {
        dataRepository.deleteById(id);
        return false;
    }
}
