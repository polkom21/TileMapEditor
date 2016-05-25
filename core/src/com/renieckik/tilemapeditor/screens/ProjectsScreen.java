package com.renieckik.tilemapeditor.screens;

import com.renieckik.tilemapeditor.TileMapEditor;

public class ProjectsScreen extends AbstractScreen {
	
	public ProjectsScreen(TileMapEditor editor) {
		super(editor);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();
		spriteBatch.end();
	}

}
