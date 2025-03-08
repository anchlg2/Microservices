package com.springboot.web.entities;





import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="users")
public class User {
	@Id
	private String userId;
	@Column(name="uName", length=100)
	private String name;
	private String email;
	private String about;
	//additional properties
	@Transient
	private List<Rating> ratings;

}
