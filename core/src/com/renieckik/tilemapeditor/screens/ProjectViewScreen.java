package com.renieckik.tilemapeditor.screens;

import com.renieckik.tilemapeditor.TileMapEditor;
import com.renieckik.tilemapeditor.entities.Project;

public class ProjectViewScreen extends AbstractScreen {

	private Project project;

	public ProjectViewScreen(final TileMapEditor editor, Project project) {
		super(editor);
		this.project = project;
	}

}
