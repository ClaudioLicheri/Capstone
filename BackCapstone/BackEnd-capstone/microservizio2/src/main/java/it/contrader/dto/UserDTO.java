package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;

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
	@NotNull(message = "username non può essere null")
	private String username;

	@NotNull(message = "password non può essere null")
	private String password;

	private String usertype;

	private String address;

	private String phone_number;

	@Email(message = "email non valida")
	private String email;

	private String name;

	private String surname;

	private String propic;
}

