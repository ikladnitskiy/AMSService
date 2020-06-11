package ru.kladnitskiy.AMSService.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.model.TypeAms;
import ru.kladnitskiy.AMSService.model.dto.AmsDto;
import ru.kladnitskiy.AMSService.service.AmsService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static ru.kladnitskiy.AMSService.model.dto.AmsDto.convertToAmsDto;

@RestController
@RequestMapping(value = "/api/user/ams")
public class AmsUserRestController {

    private AmsService amsService;

    @Autowired
    public void setAmsService(AmsService amsService) {
        this.amsService = amsService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmsDto> getById(@PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Ams ams = this.amsService.getById(id);
        return new ResponseEntity<>(convertToAmsDto(ams), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AmsDto>> getAll(@RequestParam(name = "code", required = false) String code,
                                               @RequestParam(name = "number", required = false) Integer number,
                                               @RequestParam(name = "cluster", required = false) String cluster,
                                               @RequestParam(name = "address", required = false) String address,
                                               @RequestParam(name = "type", required = false) TypeAms typeAms,
                                               @RequestParam(name = "minHeight", required = false) Double minHeight,
                                               @RequestParam(name = "maxHeight", required = false) Double maxHeight,
                                               @RequestParam(name = "serviceContractor", required = false) String serviceContractor,
                                               @RequestParam(name = "afterServiceDate", required = false) @DateTimeFormat(
                                                       iso = DateTimeFormat.ISO.DATE) LocalDate afterServiceDate,
                                               @RequestParam(name = "beforeServiceDate", required = false) @DateTimeFormat(
                                                       iso = DateTimeFormat.ISO.DATE) LocalDate beforeServiceDate,
                                               @RequestParam(name = "reportContractor", required = false) String reportContractor,
                                               @RequestParam(name = "afterReportDate", required = false) @DateTimeFormat(
                                                       iso = DateTimeFormat.ISO.DATE) LocalDate afterReportDate,
                                               @RequestParam(name = "beforeReportDate", required = false) @DateTimeFormat(
                                                       iso = DateTimeFormat.ISO.DATE) LocalDate beforeReportDate,
                                               @RequestParam(name = "order") AmsOrder order,
                                               @RequestParam(name = "pageNumber") Integer pageNumber,
                                               @RequestParam(name = "pageSize") Integer pageSize) {

        List<Ams> amsList = this.amsService.getAll(code, number, cluster, address, typeAms, minHeight, maxHeight, serviceContractor,
                afterServiceDate, beforeServiceDate, reportContractor, afterReportDate, beforeReportDate, order, pageNumber, pageSize);
        if (amsList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<AmsDto> result = amsList.stream()
                .map(AmsDto::convertToAmsDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> count(@RequestParam(name = "code", required = false) String code,
                                      @RequestParam(name = "number", required = false) Integer number,
                                      @RequestParam(name = "cluster", required = false) String cluster,
                                      @RequestParam(name = "address", required = false) String address,
                                      @RequestParam(name = "type", required = false) TypeAms typeAms,
                                      @RequestParam(name = "minHeight", required = false) Double minHeight,
                                      @RequestParam(name = "maxHeight", required = false) Double maxHeight,
                                      @RequestParam(name = "serviceContractor", required = false) String serviceContractor,
                                      @RequestParam(name = "afterServiceDate", required = false) @DateTimeFormat(
                                              iso = DateTimeFormat.ISO.DATE) LocalDate afterServiceDate,
                                      @RequestParam(name = "beforeServiceDate", required = false) @DateTimeFormat(
                                              iso = DateTimeFormat.ISO.DATE) LocalDate beforeServiceDate,
                                      @RequestParam(name = "reportContractor", required = false) String reportContractor,
                                      @RequestParam(name = "afterReportDate", required = false) @DateTimeFormat(
                                              iso = DateTimeFormat.ISO.DATE) LocalDate afterReportDate,
                                      @RequestParam(name = "beforeReportDate", required = false) @DateTimeFormat(
                                              iso = DateTimeFormat.ISO.DATE) LocalDate beforeReportDate) {

        Long count = this.amsService.count(code, number, cluster, address, typeAms, minHeight, maxHeight, serviceContractor,
                afterServiceDate, beforeServiceDate, reportContractor, afterReportDate, beforeReportDate);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}