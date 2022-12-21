package com.example.apirest.repositories;


import com.example.apirest.models.Norecurrentes;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.apirest.models.Turnos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TurnosRepo extends JpaRepository<Turnos, Long> {

    @Query(value = "SELECT o.nombre_org as orgName, n.nombre as EventName, n.active as isActive FROM organizacion as o inner join norecurrentes as n ON o.id_org = n.id_org where o.nombre_org = ?1",
    nativeQuery = true)
    Collection<Result> orgName(String orgName);

    @Query(value = "SELECT o.nombre_org as orgName, n.nombre as EventName, n.active as isActive FROM organizacion as o inner join norecurrentes as n ON n.id_org = o.id_org where n.active = true and n.nombre = ?2 and o.nombre_org = ?1",
    nativeQuery = true)
    Collection<Result> orgName1(String orgName, String eventName);

}
