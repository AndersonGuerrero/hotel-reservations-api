package com.aguerrerodev.hotelreservations.views.resources;

import java.util.List;

import com.aguerrerodev.hotelreservations.controller.services.ClientService;
import com.aguerrerodev.hotelreservations.models.Client;
import com.aguerrerodev.hotelreservations.views.resources.vo.ClientVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que represente el servicio web de cliente
 * ClientResource
 * @author Anderson Guerrero
 */

@RestController
@RequestMapping("/api/client")
@Api(tags = "Clients")
public class ClientResource {

    private final ClientService clientService; 
    
    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }
    
    @PostMapping
    @ApiOperation(value = "Crear cliente", notes = "Servicio para crear clientes")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Cliente creado correctamente"),
        @ApiResponse(code = 400, message = "Solicitud invalida")
    })
    public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVo){
        Client client = new Client();
        client.setName(clientVo.getName());
        client.setLastname(clientVo.getLastname());
        client.setAddress(clientVo.getAddress());
        client.setEmail(clientVo.getEmail());
        client.setPhone(clientVo.getPhone());
        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
    }

    @PutMapping("/{ci}")
    @ApiOperation(value = "Actualizar cliente", notes = "Servicio para actualizar clientes")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
        @ApiResponse(code = 404, message = "cliente no encontrado")
    })
    public ResponseEntity<Client> updateClient(@PathVariable("ci") String ci, ClientVO clientVo){
        Client client = this.clientService.findByCi(ci);
        if (client == null){
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        } else {
            client.setName(clientVo.getName());
            client.setLastname(clientVo.getLastname());
            client.setAddress(clientVo.getAddress());
            client.setEmail(clientVo.getEmail());
            client.setPhone(clientVo.getPhone());
        }
        return new ResponseEntity<>(this.clientService.update(client), HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation(value = "Eliminar cliente", notes = "Servicio para eliminar clientes")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
        @ApiResponse(code = 404, message = "cliente no encontrado")
    })
    public void removeClient(@PathVariable("ci") String ci){
        Client client = this.clientService.findByCi(ci);
        if (client != null){
            this.clientService.delete(client);
        }
    }
    
    @GetMapping
    @ApiOperation(value = "Listar clientes", notes = "Servicio para listar clientes")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Clientes encontrados"),
        @ApiResponse(code = 404, message = "clientes no encontrados")
    })
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok(this.clientService.findAll());
    }


    @GetMapping("/{lastname}")
    @ApiOperation(value = "Buscar clientes", notes = "Servicio para buscar clientes por apellido")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Clientes encontrados"),
        @ApiResponse(code = 404, message = "clientes no encontrados")
    })
    public ResponseEntity<List<Client>> findLastname(@PathVariable("lastname") String lastname){
        return ResponseEntity.ok(this.clientService.findLastName(lastname));
    }
}