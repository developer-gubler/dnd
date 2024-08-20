package com.schadraq.dnd_battle.persistence;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "creature_family", uniqueConstraints={@UniqueConstraint(columnNames = {"classification_id", "name"})
	})
@Data
@EqualsAndHashCode(callSuper=false)
public class CreatureFamily extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	/**
	 * NOTE: R2DBC does NOT support relations  (ie foreign key definitions).
	 * 		 As a result, I had to change this to just a UUID.  It is important
	 * 		 to create your tables outside of JPA so that the table
	 * 		 is created with the foreign key and the database (instead of the
	 * 		 application) can still enforce the relation.
	 */
	@Column(nullable = false)
	@NotNull
	private UUID classification_id;

	@Column(nullable = false)
	@NotNull(message = "Name must be between 1 to 32 characters")
	@Size(min = 1, max = 32)
	private String name;

	protected CreatureFamily() {
		
	}

	public CreatureFamily(UUID classification_id, String name) {
		this.classification_id = classification_id;
		this.name = name;
	}

	public CreatureFamily(UUID id, UUID classification_id, String name) {
		this(classification_id, name);
		this.id = id;
	}
}
