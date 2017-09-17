package com.fambam.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fambam.api.model.Relationship;
import com.fambam.api.model.RelationshipId;

public interface RelationshipRepository extends JpaRepository<Relationship, RelationshipId>{

}
