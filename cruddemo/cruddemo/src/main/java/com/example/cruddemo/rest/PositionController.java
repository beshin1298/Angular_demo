package com.example.cruddemo.rest;

import com.example.cruddemo.entity.Position;
import com.example.cruddemo.service.PositionImplService;
import com.example.cruddemo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PositionController {
    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }
    @GetMapping("/position")
    public List<Position> getAllPosition(){
        return positionService.getAll();
    }
    @GetMapping("/position/{id}")
    public Position findPositionById(@PathVariable int id){

        return positionService.findById(id);
    }
    @PostMapping("/position")
    public Position updatePosition(@RequestBody Position position){

        return positionService.updatePosition(position);
    }
    @PutMapping("/position")
    public Position addNewPosition(@RequestBody Position position){
        position.setId(0);
        return positionService.addNewPosition(position);
    }
    @DeleteMapping("/position/{id}")
    public String deletePosition(@PathVariable int id){
        if(id < 0){
            throw new RuntimeException("Invalid id");
        }
        Position position = positionService.findById(id);
        if(position == null){
            throw new RuntimeException("Not found position id: "+id);
        }
        positionService.deletePositon(id);

        return "Delete position: "+id+" success";
    }


}
