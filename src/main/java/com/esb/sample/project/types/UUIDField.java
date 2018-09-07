package com.esb.sample.project.types;

import com.esb.sample.project.types.validator.constraints.AntiSqlInjectionString;
import com.esb.sample.project.types.validator.constraints.UuidString;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UUIDField {
	
	@UuidString
	@AntiSqlInjectionString(name="Id")
	private String id;
	
	public UUIDField(String id) {
		this.id = id;
	}

}
