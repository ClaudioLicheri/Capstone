package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;


import javax.persistence.Lob;

/**
 * DTO della classe User. Ha gli stessi attributi di User
 *
 * @author Vittorio Valent & Girolamo Murdaca
 *
 *@see Users
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class UserDTO {

	private int id;

	@NotNull(message = "Username NON può essere NULLO")
	private String username;

	@NotNull(message = "Password NON può essere NULLO")
	private String password;

	private String usertype;

	private String address;

	private String phone_number;

	@Email(message = "La Mail non è valida")
	private String email;

	private String name;

	private String surname;

	private String propic;
}

