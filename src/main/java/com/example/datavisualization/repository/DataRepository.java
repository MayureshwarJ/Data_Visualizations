package com.example.datavisualization.repository;

import com.example.datavisualization.entity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  DataRepository extends JpaRepository<DataEntity, Long> {

}
