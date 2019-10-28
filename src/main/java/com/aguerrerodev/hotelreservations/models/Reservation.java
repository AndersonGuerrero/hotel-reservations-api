/**
 * 
 */
package com.aguerrerodev.hotelreservations.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla para Reservas
 * @author anderson
 *
 */

@Data
@Entity
@Table(name = "reservations")
public class Reservation {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idRes;
	@Temporal(TemporalType.DATE)
	private Date created_date;
	@Temporal(TemporalType.DATE)
	private Date finish_date;
	private int number_people;
	private String description;
	@ManyToOne
	@JoinColumn(name = "idCli")
	private Client client;
}
