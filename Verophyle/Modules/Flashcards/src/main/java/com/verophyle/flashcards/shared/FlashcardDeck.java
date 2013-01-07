package com.verophyle.flashcards.shared;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import com.verophyle.core.shared.CoreEntity;

@Entity
public class FlashcardDeck extends CoreEntity<Long> {
	
	@Size(min = 1, max = 400)
	private String name;
	
	private int num;
	
	public FlashcardDeck() {
		name = "Ozymandias";
		num = 314;
	}
	
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
