package ru.kladnitskiy.AMSService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.repository.AmsRepository;

import java.util.List;

@Slf4j
@Service
public class AmsServiceImpl implements AmsService {

    private AmsRepository amsRepository;

    @Autowired
    public void setAmsRepository(AmsRepository amsRepository) {
        this.amsRepository = amsRepository;
    }

    @Override
    public List<Ams> getAll() {
        return this.amsRepository.findAll();
    }

    @Override
    public Ams getById(Integer id) {
        log.info("In AmsServiceImpl method getById, id={}", id);
        return this.amsRepository.findById(id).orElse(null);
    }

    @Override
    public Ams save(Ams ams) {
        log.info("In AmsServiceImpl method save, {}", ams);
        return this.amsRepository.save(ams);
    }

    @Override
    public Ams update(Integer id, Ams ams) {
        log.info("In AmsServiceImpl method update, id={}, {}", id, ams);
        Ams updatedAms = this.amsRepository.findById(id).orElse(null);
        updatedAms.setCode(ams.getCode());
        updatedAms.setNumber(ams.getNumber());
        updatedAms.setAddress(ams.getAddress());
        updatedAms.setHeight(ams.getHeight());
        updatedAms.setType(ams.getType());
        updatedAms.setServiced(ams.isServiced());
        updatedAms.setTypesOfWork(ams.getTypesOfWork());
        updatedAms.getTypesOfWork().setAms(updatedAms);
        updatedAms.getTypesOfWork().setId(id);
        return this.amsRepository.save(updatedAms);
    }

    @Override
    public void delete(Integer id) {
        this.amsRepository.deleteById(id);
    }
}
