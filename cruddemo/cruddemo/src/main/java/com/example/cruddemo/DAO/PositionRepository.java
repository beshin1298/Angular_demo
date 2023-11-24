package com.example.cruddemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cruddemo.entity.Position;


public interface PositionRepository extends JpaRepository<Position,Integer> {
}
