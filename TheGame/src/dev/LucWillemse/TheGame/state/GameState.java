package dev.LucWillemse.TheGame.state;

import java.awt.Graphics;

import dev.LucWillemse.TheGame.gfx.Assets;

public class GameState extends State {
	
	public GameState() {
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.sand, 0, 0, null);
	}

}
