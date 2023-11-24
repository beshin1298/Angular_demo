package com.example.cruddemo.service;

import com.example.cruddemo.DAO.PositionRepository;
import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PositionImplService implements PositionService{
    private PositionRepository positionRepository;

    @Autowired
    public PositionImplService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }


    @Override
    public List<Position> getAll() {
        return positionRepository.findAll(Sort.by(Sort.Direction.DESC, "positionName"));
    }

    @Override
    public Position findById(int id) {
        Optional<Position>  result= positionRepository.findById(id);
        Position position = null;
        if(result.isPresent()){
            position = result.get();
        }
        return position;
    }

    @Override
    public Position updatePosition(Position position) {


        if(position.getId() < 0){
            throw new RuntimeException("id not found");

        }
        if(position.getPositionName() == null){
            throw new RuntimeException("position name is empty");

        }
        Position positionDb = positionRepository.findById(position.getId()).isPresent() ? positionRepository.findById(position.getId()).get() : null;
        if(positionDb == null){
            throw new RuntimeException("Not found user");
        }



        return positionRepository.save(position);
    }

    @Override
    public Position addNewPosition(Position position) {
        if(position.getPositionName().isEmpty()){
            throw new RuntimeException("position name is empty");

        }

        return positionRepository.save(position);
    }

    @Override
    public void deletePositon(int id) {
        positionRepository.deleteById(id);
    }


}
