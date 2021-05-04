package com.eventosapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventosapp.models.Eventos;

public interface EventoRepository extends CrudRepository<Eventos,String> {

}
