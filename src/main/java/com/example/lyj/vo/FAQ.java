package com.example.lyj.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FAQ {
	
	private int id;
	private String regDate;
	private String updateDate;
	private String question;
	private String answer;
	
}
