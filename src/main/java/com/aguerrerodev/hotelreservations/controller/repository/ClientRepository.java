/**
 * 
 */
package com.aguerrerodev.hotelreservations.controller.repository;

import java.util.List;

import com.aguerrerodev.hotelreservations.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface para definir las operaciones de DB relacionadas con Clientes
 * @author anderson
 *
 */
public interface ClientRepository extends JpaRepository<Client, String> {
    /**
     * Definicaion de metodo para buscar los clientes por apellido.
     * @param lastname
     * @return
     */
    public List<Client> findByLastname(String lastname);
    public Client findByCi(String ci);
}
