package dev.LucWillemse.TheGame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.LucWillemse.TheGame.display.Display;
import dev.LucWillemse.TheGame.gfx.Assets;
import dev.LucWillemse.TheGame.gfx.ImageLoader;
import dev.LucWillemse.TheGame.gfx.SpriteSheet;
import dev.LucWillemse.TheGame.state.GameState;
import dev.LucWillemse.TheGame.state.MenuState;
import dev.LucWillemse.TheGame.state.State;

public class Game implements Runnable {

	private Display display;
	
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	private State menuState;
	
	
	public Game(String title, int width, int height) {
		
		this.width = width;
		this.height = height;		
		this.title = title;
	}
	
	private void init() {
		display = new Display(title, width, height);
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
	}
	
	
	
	private void tick() {
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0, 0, width, height);
		//draw here
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//end draw
		bs.show();
		g.dispose(); 
		
	}
	
	public void run() {
		 
		init();
		
		while(running) {
			tick();
			render();
		}
		
		stop();
		
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
