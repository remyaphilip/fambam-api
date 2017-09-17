package com.fambam.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum RelationType {
	
	BROTHER("BROTHER"),
	SISTER("SISTER"),
	FATHER("FATHER"),
	MOTHER("MOTHER"),
	AUNT("AUNT"),
	UNCLE("UNCLE"),
	GRANDFATHER("GRANDFATHER"),
	GRANDMOTHER("GRANDMOTHER"),
	SON("SON"),
	DAUGHTER("DAUGHTER"),
	GRANDSON("GRANDSON"),
	GRANDDAUGHTER("GRANDDAUGHTER"),
	NIECE("NIECE"),
	NEPHEW("NEPHEW");
	
	@Getter
	private String value;

}
