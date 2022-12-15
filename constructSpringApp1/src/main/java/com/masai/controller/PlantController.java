package com.masai.controller;

import com.masai.exception.PlantNotFoundException;
import com.masai.model.Plant;
import com.masai.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlantController {

    @Autowired
    private PlantService pService;

    @PostMapping("/plants")
    public ResponseEntity<Plant> addPlantHandler( @RequestBody Plant plant) throws PlantNotFoundException {

            Plant pObj = pService.addPlant(plant);

            return new ResponseEntity<Plant>(pObj, HttpStatus.CREATED);


        }


    // Updating existing plant details

    @PutMapping("plants")
    public ResponseEntity<Plant> updatePlantHandler(@RequestBody Plant plant) throws PlantNotFoundException{

            Plant pObj = pService.updatePlant(plant);

            return new ResponseEntity<Plant>(pObj, HttpStatus.ACCEPTED);


        }

    // Delete existing plant by Plant Id

    @DeleteMapping("/plants/{id}")
    public ResponseEntity<Plant> deletePlantByIdHandler(@PathVariable("id") Integer plantId) throws PlantNotFoundException {


            Plant plant = pService.deletePlantById(plantId);

            return new ResponseEntity<Plant>(plant, HttpStatus.OK);


        }

    // View plant by Plant Id

    @GetMapping("/plants/{id}")
    public ResponseEntity<Plant> viewPlantByIdHandler(@PathVariable("id") Integer plantId) throws PlantNotFoundException {

        Plant plant = pService.viewPlantById(plantId);

        return new ResponseEntity<Plant>(plant, HttpStatus.OK);

    }


    // Find Plant by Plant name

    @GetMapping("/plant/{name}")
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
    @GetMapping("/getplants/{plant_type}")
    public ResponseEntity<List<Plant>> viewPlantsByPlantTypeHandler(@PathVariable("plant_type") String type)
            throws PlantNotFoundException {

        List<Plant> list = pService.viewPlantsByPlantType(type);

        return new ResponseEntity<List<Plant>>(list, HttpStatus.OK);
    }

}
