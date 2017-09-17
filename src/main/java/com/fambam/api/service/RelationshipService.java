package com.fambam.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fambam.api.model.RelationType;
import com.fambam.api.model.Relationship;
import com.fambam.api.model.RelationshipId;
import com.fambam.api.model.User;
import com.fambam.api.repository.RelationshipRepository;
import com.fambam.api.repository.UserRepository;
import com.fambam.api.web.dto.RelationshipDTO;

@Service
@Transactional
public class RelationshipService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RelationshipRepository relationshipRepository;
	
	public void modifyRelationship(Long idFrom, Long idTo, RelationType relationType){
		User userFrom = userRepository.findOne(idFrom);
		User userTo = userRepository.findOne(idTo);
		Relationship relationship = new Relationship(new RelationshipId(idFrom, idTo),relationType, userTo, userFrom);
		relationshipRepository.save(relationship);
	}
	
	public RelationshipDTO getRelationship( Long idFrom, Long idTo){
		Relationship rel = relationshipRepository.getOne(new RelationshipId(idFrom, idTo));
		RelationshipDTO dto = RelationshipDTO.builder().idFrom(rel.getId().getUserFrom()).idTo(rel.getId().getUserTo())
				.relationType(rel.getRelationType()).conjugate(rel.conjugateRelation()).build();
		return dto;
	}
	
}
