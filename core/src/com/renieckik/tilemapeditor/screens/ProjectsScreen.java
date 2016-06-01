package com.renieckik.tilemapeditor.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.renieckik.tilemapeditor.TileMapEditor;
import com.renieckik.tilemapeditor.entities.Project;

public class ProjectsScreen extends AbstractScreen {
	
	private ArrayList<Project> projects;
	private Json json;
	private FileHandle file;
	
	public ProjectsScreen(TileMapEditor editor) {
		super(editor);
		
		json = new Json();
		file = Gdx.files.absolute(TileMapEditor.programDir+"projects.json");
		projects = new ArrayList<Project>();
		loadProjectsList();
	}
	
	@SuppressWarnings("unchecked")
	private void loadProjectsList() {
		if(!file.exists())
			writeProjectsList();
		
		projects = json.fromJson(ArrayList.class, Project.class, file);
	}
	
	private void writeProjectsList() {
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
	}

}
