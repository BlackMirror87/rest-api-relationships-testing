package com.example.restapirelationship3.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Telephone {

	private Integer number;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany(mappedBy = "telephones", cascade = CascadeType.ALL)
	Set<Employee> employees = new HashSet<>();

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
		employee.getTelephones().add(this);
	}
}