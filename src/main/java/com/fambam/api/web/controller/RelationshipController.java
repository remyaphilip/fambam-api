package com.fambam.api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fambam.api.model.RelationType;
import com.fambam.api.service.RelationshipService;
import com.fambam.api.web.dto.RelationshipDTO;

@RestController
public class RelationshipController {

	@Autowired
	RelationshipService relationshipService;

	@RequestMapping(method = RequestMethod.GET, path = "/relation/{idFrom}/{idTo}/{relationType}")
	public void modifyRelationsip(@PathVariable("idFrom") Long idFrom, @PathVariable("idTo") Long idTo,
			@PathVariable("relationType") String type) {
		RelationType relationType = RelationType.valueOf(type);
		relationshipService.modifyRelationship(idFrom, idTo, relationType);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/relation/{idFrom}/{idTo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RelationshipDTO getRelationship(@PathVariable("idFrom") Long idFrom, @PathVariable("idTo") Long idTo) {
		return relationshipService.getRelationship(idFrom, idTo);
	}
	
}
