package org.conan.domain;

import lombok.Data;

@Data
public class Ticket {
	private int tno;
	private String owner, grade;
}
