package dev.LucWillemse.TheGame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage grass, sand, water, player;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/test.png"));
		
		player = sheet.crop(0, 160, width, height);
		grass = sheet.crop(0, 0, width, height);
		sand = sheet.crop(160, 0, width, height);
		water = sheet.crop(160, 160, width, height);
		
	}

}
