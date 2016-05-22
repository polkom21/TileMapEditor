package com.renieckik.tilemapeditor;

import com.badlogic.gdx.Game;
import com.renieckik.tilemapeditor.screens.ProjectsScreen;

public class TileMapEditor extends Game {

	@Override
	public void create () {
		this.setScreen(new ProjectsScreen(this));
	}

}
