package com.example.cruddemo.service;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.entity.Position;

import java.util.List;
import java.util.Optional;

public interface PositionService {
    public List<Position> getAll();
    public Position findById(int id);
    public Position updatePosition(Position position);

    public Position addNewPosition(Position position);

    public void deletePositon(int id);


}
