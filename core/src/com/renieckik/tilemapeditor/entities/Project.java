package com.renieckik.tilemapeditor.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

public class Project {
	public String name;
	
	private String source;
	private Json json;
	
	public Project() {
		
	}
	
	public Project(String name, String source) {
		this.name = name;
		this.source = source;
	}
	
	public void saveProject() {
		json = new Json();
		FileHandle file = Gdx.files.absolute(source+"project.json");
		String data = json.toJson(this);
		file.writeString(data, false);
	}
}
