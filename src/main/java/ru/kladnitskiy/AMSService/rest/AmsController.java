package ru.kladnitskiy.AMSService.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.model.dto.AmsDto;
import ru.kladnitskiy.AMSService.service.AmsService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Ams ams = this.amsService.getById(id);
        if (ams == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(convertToAmsDto(ams), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmsDto> createAms(@Valid @RequestBody AmsDto amsDto) {
        if (amsDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Ams requestAms = convertToAms(amsDto);
        requestAms.getTypesOfWork().setAms(requestAms);
        Ams result = this.amsService.save(requestAms);
        return new ResponseEntity<>(convertToAmsDto(result), HttpStatus.CREATED);
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

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmsDto> updateAms(@PathVariable("id") Integer id, @Valid @RequestBody AmsDto amsDto) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Ams ams = this.amsService.getById(id);
        if (ams == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Ams requestAms = convertToAms(amsDto);
        Ams updatedAms = this.amsService.update(id, requestAms);
        return new ResponseEntity<>(convertToAmsDto(updatedAms), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AmsDto>> getAll(){
        List<Ams> amsList = this.amsService.getAll();
        if (amsList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<AmsDto> amsDtoList = amsList.stream().map(AmsDto::convertToAmsDto).collect(Collectors.toList());
        return new ResponseEntity<>(amsDtoList, HttpStatus.OK);
    }
}
