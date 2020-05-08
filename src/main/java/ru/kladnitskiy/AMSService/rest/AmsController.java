package ru.kladnitskiy.AMSService.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.model.dto.AmsDto;
import ru.kladnitskiy.AMSService.service.AmsService;

import static ru.kladnitskiy.AMSService.model.Ams.convertToAms;
import static ru.kladnitskiy.AMSService.model.dto.AmsDto.convertToAmsDto;

@RestController
@RequestMapping(value = "/api/ams/")
public class AmsController {

    private AmsService amsService;

    @Autowired
    public void setAmsService(AmsService amsService) {
        this.amsService = amsService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmsDto> getById(@PathVariable("id") Integer id) {
        if (id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Ams ams = this.amsService.getById(id);
        if (ams == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Address: " + ams.getAddress());
        return new ResponseEntity<>(convertToAmsDto(ams), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmsDto> deleteAms(@PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Ams ams = this.amsService.getById(id);
        if (ams == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.amsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmsDto> createAms(@RequestBody AmsDto amsDto){
        if (amsDto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Ams createdAms = convertToAms(amsDto);
        createdAms.getTypesOfWork().setAms(createdAms);
        this.amsService.save(createdAms);
        return new ResponseEntity<>(convertToAmsDto(createdAms), HttpStatus.CREATED);
    }
}
