/**
 * 
 */
package com.aguerrerodev.hotelreservations.views.resources.vo;

import lombok.Data;

/**
 * Clase que representa Cliente
 * @author anderson
 *
 */

@Data
public class ClientVO {
	private String idCli;
	private String name;
	private String lastname;
	private String ci;
	private String address;
	private String phone;
    private String email;
}
