package com.renieckik.tilemapeditor.screens;

import com.badlogic.gdx.graphics.Texture;
import com.renieckik.tilemapeditor.TileMapEditor;

public class ProjectsScreen extends AbstractScreen {

	private Texture testImg;
	
	public ProjectsScreen(TileMapEditor editor) {
		super(editor);
		testImg = new Texture("badlogic.jpg");
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();
		spriteBatch.draw(testImg, 0, 0);
		spriteBatch.end();
	}

}
