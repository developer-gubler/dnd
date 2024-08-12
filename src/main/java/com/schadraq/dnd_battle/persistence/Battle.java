package com.schadraq.dnd_battle.persistence;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "battle")
@Data
public class Battle extends BaseEntity {


	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
}
