package dev.LucWillemse.TheGame.state;

import java.awt.Graphics;

import dev.LucWillemse.TheGame.Game;
import dev.LucWillemse.TheGame.entities.creatures.Player;
import dev.LucWillemse.TheGame.gfx.Assets;

public class GameState extends State {
	
	private Player player;
	
	public GameState(Game game) {
		super(game);
		player = new Player(100, 100);
	}

	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}

}
