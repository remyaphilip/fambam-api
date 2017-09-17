package com.fambam.api.util.helpers;

import java.io.Serializable;

import com.fambam.api.model.Gender;
import com.fambam.api.model.RelationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conjugate implements Serializable {
	private static final long serialVersionUID = 3394226043589829768L;

	private RelationType relationTo;
	private Gender genderFrom;
	private Gender genderTo;
	private RelationType relationFrom;
}
