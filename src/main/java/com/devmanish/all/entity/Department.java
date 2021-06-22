package com.devmanish.all.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long departmentId;
	/*These are all the hibernate validators to check the data coming from the api is valid or not.
	 * @Length
	 * 
	 * @Email
	 * 
	 * @Positive
	 * 
	 * @NegativeOrZero
	 * 
	 * @Future
	 * 
	 * @Past
	 */
	@NotBlank(message = "Please add department name")
	private String departmentName;

	private String departmentAddress;

	private String departmentCode;
}
