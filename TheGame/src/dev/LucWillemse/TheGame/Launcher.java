package dev.LucWillemse.TheGame;

import dev.LucWillemse.TheGame.display.Display;

public class Launcher {
	
	public static void main(String[] args) {
		Game game = new Game("the game", 600, 600);
		game.start();
	}
}