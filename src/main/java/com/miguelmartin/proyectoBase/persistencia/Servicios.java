package com.miguelmartin.proyectoBase.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguelmartin.proyectoBase.modelo.Contacto;

public interface Servicios extends JpaRepository<Contacto, Integer>{
}
