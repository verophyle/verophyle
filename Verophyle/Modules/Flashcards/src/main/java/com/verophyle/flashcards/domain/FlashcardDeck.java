package com.verophyle.flashcards.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import com.verophyle.core.domain.CoreEntity;

@Entity
public class FlashcardDeck extends CoreEntity<Long> {
	
	@Size(min = 1, max = 400)
	private String name;
	
	private int num;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
}
