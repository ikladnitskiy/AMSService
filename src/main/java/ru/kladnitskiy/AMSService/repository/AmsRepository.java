package ru.kladnitskiy.AMSService.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kladnitskiy.AMSService.model.Ams;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AmsRepository extends JpaRepository<Ams, Integer> {
}
