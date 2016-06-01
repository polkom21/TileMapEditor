package com.renieckik.tilemapeditor.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.kotcrab.vis.ui.VisUI;
import com.renieckik.tilemapeditor.TileMapEditor;
import com.renieckik.tilemapeditor.entities.Project;

public class ProjectsScreen extends AbstractScreen {
	
	private ArrayList<Project> projects;
	
	public ProjectsScreen(TileMapEditor editor) {
		super(editor);
		
		projects = new ArrayList<Project>();
		loadProjectsList();
		
		VisUI.load();
	}
	
	@SuppressWarnings("unchecked")
	private void loadProjectsList() {
		Json json = new Json();
		FileHandle file = Gdx.files.absolute(TileMapEditor.programDir+"projects.json");
		
		if(!file.exists())
			writeProjectsList();
		
		projects = json.fromJson(ArrayList.class, Project.class, file);
	}
	
	private void writeProjectsList() {
		Json json = new Json();
		FileHandle file = Gdx.files.absolute(TileMapEditor.programDir+"projects.json");
		
		String data = json.toJson(projects, ArrayList.class, Project.class);
		
		file.writeString(data, false);
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
