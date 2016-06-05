package com.renieckik.tilemapeditor;

import com.badlogic.gdx.Game;
import com.renieckik.tilemapeditor.screens.ProjectsListScreen;

public class TileMapEditor extends Game {

	public static final String programDir = System.getProperty("user.home") + "/AppData/Local/TileMapEditor/";
	
	@Override
	public void create () {
		this.setScreen(new ProjectsListScreen(this));
	}

}
