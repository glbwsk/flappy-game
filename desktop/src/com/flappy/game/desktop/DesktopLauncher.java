package com.flappy.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.flappy.game.FlappyGame;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Flappy-game";
		config.useGL30 = true;
		config.height = 800;
		config.width = 480;
		config.resizable = false;
		new LwjglApplication(new FlappyGame(), config);
	}
}
