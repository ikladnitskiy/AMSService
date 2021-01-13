package ru.kladnitskiy.AMSService.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.model.TypeAms;
import ru.kladnitskiy.AMSService.rest.dto.AmsDto;
import ru.kladnitskiy.AMSService.service.AmsService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static ru.kladnitskiy.AMSService.model.Ams.convertToAms;
import static ru.kladnitskiy.AMSService.rest.dto.AmsDto.convertToAmsDto;

/**
 * Контроллер действий с АМС.
 */
@RestController
@RequestMapping(value = "/api/ams")
public class AmsController {

    private AmsService amsService;

    @Autowired
    public void setAmsService(AmsService amsService) {
        this.amsService = amsService;
    }

    /**
     * Получение информации об АМС по ее ID.
     *
     * @param id - ID антенно-мачтового сооружения;
     * @return информация об АМС.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<AmsDto> getById(@PathVariable("id") Integer id) {
        Ams ams = this.amsService.getById(id);
        return new ResponseEntity<>(convertToAmsDto(ams), HttpStatus.OK);
    }

    /**
     * Сохранение информации об АМС в БД.
     *
     * @param amsDto - информация об АМС;
     * @return информация об АМС.
     */
    @PostMapping(value = "")
    public ResponseEntity<AmsDto> createAms(@Valid @RequestBody AmsDto amsDto) {
        Ams result = this.amsService.save(convertToAms(amsDto));
        return new ResponseEntity<>(convertToAmsDto(result), HttpStatus.CREATED);
    }

    /**
     * Удаление информации об АМС из БД по ее ID.
     *
     * @param id - ID АМС.
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAms(@PathVariable("id") Integer id) {
        this.amsService.delete(id);
    }

    /**
     * Обновление информации об АМС в БД по ее ID.
     *
     * @param id     - ID антенно-мачтового сооружения;
     * @param amsDto - информация об АМС;
     * @return обновленная информация об АМС.
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<AmsDto> updateAms(@PathVariable("id") Integer id, @Valid @RequestBody AmsDto amsDto) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Ams updatedAms = this.amsService.update(id, convertToAms(amsDto));
        return new ResponseEntity<>(convertToAmsDto(updatedAms), HttpStatus.OK);
    }

    /**
     * Получение списка АМС, соответствующих заданным параметрам.
     *
     * @param order      - параметр, по которому упорядочиваются полученные данные, значение по умолчанию - "NUMBER";
     * @param pageNumber - номер страницы, значение по умолчанию - "0";
     * @param pageSize   - размер страницы (кол-во элементов на одной странице), значение по умолчанию - "5";
     * @return список сущностей, содержащий информацию об АМС, соответствующих переданным параметрам.
     * @see AmsOrder
     */
    @GetMapping
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
                                               @RequestParam(name = "isAccess", required = false) Boolean isAccess,
                                               @RequestParam(name = "order", required = false, defaultValue = "NUMBER") AmsOrder order,
                                               @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                               @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        List<Ams> amsList = this.amsService.getAll(code, number, cluster, address, typeAms, minHeight, maxHeight,
                serviceContractor, afterServiceDate, beforeServiceDate, reportContractor, afterReportDate,
                beforeReportDate, isAccess, order, pageNumber, pageSize);
        if (amsList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<AmsDto> result = amsList.stream()
                .map(AmsDto::convertToAmsDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Получение количества АМС, соответствующих переданным параметрам.
     *
     * @return количество АМС, соотвествующих заданным в запросе параметрам.
     */
    @GetMapping(value = "/count")
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
                                              iso = DateTimeFormat.ISO.DATE) LocalDate beforeReportDate,
                                      @RequestParam(name = "isAccess", required = false) Boolean isAccess) {

        Long count = this.amsService.count(code, number, cluster, address, typeAms, minHeight, maxHeight, serviceContractor,
                afterServiceDate, beforeServiceDate, reportContractor, afterReportDate, beforeReportDate, isAccess);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
