package com.flappy.game;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * this class represents single Pipe 
 * including upper and lower pipe on the same X position
 */

public class Pipe {
	private Sprite pipeUpSprite;
	private Sprite pipeLowSprite;
	private Texture pipeTexture;
	private Rectangle pipeUp;
	private Rectangle pipeLow;
	
	private int gapHeight;
	private int speed;
	private float startPos;
	
	private Random generator;
	
	
	public Pipe() {
		generator = new Random();
		pipeTexture = new Texture("pipe.png");
		
		startPos = Game.window.x;
		
		gapHeight = 120;
		speed = 200;
		
		pipeUpSprite = new Sprite();
		pipeLowSprite = new Sprite();
		pipeUpSprite.setTexture(pipeTexture);
		pipeLowSprite.setTexture(pipeTexture);
		
		pipeUp = new Rectangle();
		pipeLow = new Rectangle();
		setPipes();
	}
	
	public float getRandHeight() {
		return generator.nextFloat()*(Game.window.x-20)+10;
	}
	
	public void setPipes() {
			
		pipeLow.width = 80;
		pipeLow.height = getRandHeight();
		pipeLow.x = startPos;
		pipeLow.y = 0;
		
		pipeUp.width = pipeLow.width;
		pipeUp.height = Game.window.y - pipeLow.height - gapHeight;
		pipeUp.x = startPos;
		pipeUp.y = pipeLow.height + gapHeight;
			
		pipeLowSprite.setBounds(pipeLow.x, pipeLow.y, pipeLow.width, pipeLow.height);
		pipeUpSprite.setBounds(pipeUp.x, pipeUp.y, pipeUp.width, pipeUp.height);
	}
	
	public void updatePipes(float deltaTimeSeconds) {
		pipeLow.x -= speed*deltaTimeSeconds;
		pipeUp.x = pipeLow.x;
		pipeLowSprite.setPosition(pipeLow.x, pipeLow.y);
		pipeUpSprite.setPosition(pipeUp.x, pipeUp.y);
	}
	
	public void drawPipes(SpriteBatch sprbatch) {
		pipeLowSprite.draw(sprbatch);
		pipeUpSprite.draw(sprbatch);
	}
	
	public void disposePipes() {
		pipeTexture.dispose();
	}
	
	// setters & getters
	public void setXPos(float x) {
		pipeUp.x = x;
		pipeLow.x = x;
	}
	
	public Rectangle getPipeUp() {
		return pipeUp;
	}

	public Rectangle getPipeLow() {
		return pipeLow;
	}	
}
