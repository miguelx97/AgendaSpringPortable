package com.miguelmartin.agendaSpring.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguelmartin.agendaSpring.modelo.Contacto;

public interface Servicios extends JpaRepository<Contacto, Integer>{
}
