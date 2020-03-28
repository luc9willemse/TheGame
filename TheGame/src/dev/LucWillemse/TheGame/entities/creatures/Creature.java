package dev.LucWillemse.TheGame.entities.creatures;

import dev.LucWillemse.TheGame.entities.Entity;

public abstract class Creature extends Entity{
	
	protected int health;

	public Creature(float x, float y) {
		super(x, y);
	}

}
