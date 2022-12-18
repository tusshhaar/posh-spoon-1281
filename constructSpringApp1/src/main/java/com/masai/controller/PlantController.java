package com.masai.controller;

import com.masai.exception.CustomerException;
import com.masai.exception.PlantNotFoundException;
import com.masai.exception.PlanterException;
import com.masai.model.Plant;
import com.masai.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService pService;



    // View plant by Plant Id

    @GetMapping("/{id}/{key}")
    public ResponseEntity<Plant> viewPlantByIdHandler(@PathVariable("id") Integer plantId, @PathVariable("key") String key) throws PlantNotFoundException, CustomerException, PlanterException {

        Plant plant = pService.viewPlantById(plantId,key);

        return new ResponseEntity<Plant>(plant, HttpStatus.OK);

    }


    // Find Plant by Plant name

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Plant>> viewPlantByPlantNameHandler(@PathVariable("name") String name)
            throws PlantNotFoundException {

        List<Plant> list = pService.viewPlantByName(name);

        return new ResponseEntity<List<Plant>>(list, HttpStatus.OK);

    }


    //	View all plants details

    @GetMapping("/plants")
    public ResponseEntity<List<Plant>> getAllPlantsHandler() throws PlantNotFoundException {

        List<Plant> plants = pService.viewAllPlants();

        return new ResponseEntity<List<Plant>>(plants, HttpStatus.OK);
    }

    // View plants by plantType
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Plant>> viewPlantsByPlantTypeHandler(@PathVariable("type") String type)
            throws PlantNotFoundException {

        List<Plant> list = pService.viewPlantsByPlantType(type);

        return new ResponseEntity<List<Plant>>(list, HttpStatus.OK);
    }

}
