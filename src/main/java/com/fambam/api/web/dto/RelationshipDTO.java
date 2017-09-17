package com.fambam.api.web.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fambam.api.model.RelationType;
import com.fambam.api.model.Relationship;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RelationshipDTO implements Serializable{

	private static final long serialVersionUID = 14543242342532L;
	private final Long idFrom;
	private final Long idTo;
	private final RelationType relationType;
	private RelationType conjugate;
	
	public static RelationshipDTO build(Relationship relationship){
		RelationshipDTO dto = new RelationshipDTO(
				relationship.getId().getUserTo(), 
				relationship.getId().getUserFrom(), 
				relationship.getRelationType(), 
				relationship.conjugateRelation());
		return dto;
	}
	
	public static List<RelationshipDTO> build(Set<Relationship> relationships){
		List<RelationshipDTO> dtos = new ArrayList<RelationshipDTO>();
		relationships.forEach(reln->dtos.add(build(reln)));
		return dtos;
	}
	
	
}
