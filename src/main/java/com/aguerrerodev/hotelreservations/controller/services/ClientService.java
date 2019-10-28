package com.aguerrerodev.hotelreservations.controller.services;

import java.util.List;

import com.aguerrerodev.hotelreservations.controller.repository.ClientRepository;
import com.aguerrerodev.hotelreservations.models.Client;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase para definir los servicios de client
 * ClientService
 * @author Anderson Guerrero
 */

@Service
@Transactional(readOnly = true)
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    /**
     * Metodo para realizar la operacion de guardado de cliente
     * @param client
     * @return
     */
    @Transactional
    public Client create(Client client){
        return this.clientRepository.save(client);
    }

    /**
     * Metodo para realizar la operecion de actualizar cliente
     * @param client
     * @return
     */
    @Transactional
    public Client update(Client client){
        return this.clientRepository.save(client);
    }
    /**
     * Método para realizar la operación de eliminar un cliente
     * @param client
     */
    @Transactional
    public void delete(Client client){
        this.clientRepository.delete(client);
    }

    /**
     * Método para buscar un cliente por cedula de identidad
     * @param ci
     * @return
     */
    public Client findByCi(String ci){
        return this.clientRepository.findByCi(ci);
    }

    /**
     * Método para mostrar todos los clientes
     * @param ci
     * @return
     */
    public List<Client> findAll(){
        return this.clientRepository.findAll();
    }

    /**
     * Busca todos los clientes por apellido
     * @param ci
     * @return
     */
    public List<Client> findLastName(String lastname){
        return this.clientRepository.findByLastname(lastname);
    }
}