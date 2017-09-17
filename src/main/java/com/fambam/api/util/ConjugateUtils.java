package com.fambam.api.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fambam.api.model.RelationType;
import com.fambam.api.model.User;
import com.fambam.api.util.helpers.Conjugate;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConjugateUtils {

	//private static Logger LOGGER = LoggerFactory.getLogger(ConjugateUtils.class);
	
	private static final String CONJUGATE_DATA_PATH = "src/main/resources/relation-conjugate-data.json";
	private static Set<Conjugate> conjugates;

	public static RelationType getConjugateRelation(User userFrom, User userTo, RelationType relationTo) {
		createStaticSet();
		return conjugates.stream()
				.filter(con -> con.getRelationTo().equals(relationTo)
						&& con.getGenderFrom().equals(userFrom.getGender())
						&& con.getGenderTo().equals(userTo.getGender()))
				.collect(Collectors.toList()).get(0).getRelationFrom();
	}

	private static Set<Conjugate> createStaticSet() {
		Set<Conjugate> set;
		if (!(conjugates == null)) {
			set = conjugates;
		} else {

			byte[] jsonData = null;
			try {
				jsonData = Files.readAllBytes(Paths.get(CONJUGATE_DATA_PATH));
			} catch (IOException e) {
				log.error("file doesn't exist!");
			} catch (NullPointerException e) {
				log.error("Property could not be resolved!");
			}
			String jsonStr = new String(jsonData);
			Gson gson = new Gson();
			Conjugate conjugates[] = gson.fromJson(jsonStr, Conjugate[].class);
			set = new HashSet<Conjugate>(Arrays.asList(conjugates));
		}
		return set;
	}
}
