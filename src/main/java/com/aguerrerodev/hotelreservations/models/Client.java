/**
 * 
 */
package com.aguerrerodev.hotelreservations.models;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla Cliente
 * @author anderson
 *
 */

@Data
@Entity
@Table(name = "clients")
@NamedQuery(name = "Client.findByCi", query = "Select c from Client c where c.ci = ?1")
public class Client {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idCli;
	private String name;
	private String lastname;
	private String ci;
	private String address;
	private String phone;
	private String email;
	@OneToMany(mappedBy = "client")
	private Set<Reservation> reservations;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}	
}
