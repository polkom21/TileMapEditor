package com.renieckik.tilemapeditor.screens;

import com.renieckik.tilemapeditor.TileMapEditor;
import com.renieckik.tilemapeditor.entities.Project;
import com.renieckik.tilemapeditor.gui.Gui;

public class ProjectViewScreen extends AbstractScreen {

	private Project project;
	private Gui gui;

	public ProjectViewScreen(final TileMapEditor editor, Project project) {
		super(editor);
		this.project = project;
		
		gui = new Gui(this.stage);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
	}

}
