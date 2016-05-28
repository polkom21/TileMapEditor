package com.renieckik.tilemapeditor.screens;

import com.kotcrab.vis.ui.VisUI;
import com.renieckik.tilemapeditor.TileMapEditor;

public class ProjectsScreen extends AbstractScreen {
	
	public ProjectsScreen(TileMapEditor editor) {
		super(editor);
		VisUI.load();
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		spriteBatch.begin();
		spriteBatch.end();
	}
	
	@Override
	public void dispose() {
		VisUI.dispose();
	}

}
