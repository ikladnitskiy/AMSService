package ru.kladnitskiy.AMSService.service;

import ru.kladnitskiy.AMSService.model.Ams;

import java.util.List;

public interface AmsService {

    List<Ams> getAll();

    Ams getById(Integer id);

    Ams save(Ams ams);

    Ams update(Integer id, Ams ams);

    void delete(Integer id);
}
