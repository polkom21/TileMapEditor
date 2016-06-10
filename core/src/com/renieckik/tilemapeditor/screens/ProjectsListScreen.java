package com.renieckik.tilemapeditor.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.renieckik.tilemapeditor.TileMapEditor;
import com.renieckik.tilemapeditor.entities.Project;

public class ProjectsListScreen extends AbstractScreen {
	
	private ArrayList<Project> projects;
	private Array<String> projectsNames;
	private Json json;
	private FileHandle file;
	private Table container;
	private TextButton newProject, openProject, deleteProject, exitApp;
	private List<String> projectsList;
	
	public ProjectsListScreen(final TileMapEditor editor) {
		super(editor);
		
		json = new Json();
		file = Gdx.files.absolute(TileMapEditor.programDir+"projects.json");
		projects = new ArrayList<Project>();
		projectsNames = new Array<String>();
		loadProjectsList();
		
		container = new Table(skin);
		container.setFillParent(true);
		stage.addActor(container);
		
		container.add(new Label("List of projects", skin)).colspan(4).growX();
		container.row();
		
		projectsList = new List<String>(skin);
		projectsList.setItems(projectsNames);
		
		projectsList.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(getTapCount() > 1) {
					editor.setScreen(new ProjectViewScreen(editor, projects.get(projectsList.getSelectedIndex())));
				}
			}
		});
		
		container.add(projectsList).colspan(4).grow();
		container.row();
		
		newProject = new TextButton("New project", skin);
		container.add(newProject).align(Align.right);
		
		newProject.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				createNewProject();
			}
		});
		
		openProject = new TextButton("Open project", skin);
		container.add(openProject);
		
		openProject.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				editor.setScreen(new ProjectViewScreen(editor, projects.get(projectsList.getSelectedIndex())));
			}
		});
		
		deleteProject = new TextButton("Delete project", skin);
		container.add(deleteProject);
		
		deleteProject.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				int selectedProject = projectsList.getSelectedIndex();
				if(selectedProject >= 0){
					projectsNames.removeIndex(selectedProject);
					projectsList.setItems(projectsNames);
					projects.remove(selectedProject);
					writeProjectsList();
				}
			}
		});
		
		exitApp = new TextButton("Exit editor", skin);
		container.add(exitApp).align(Align.left);
		
		exitApp.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();
			}
		});
	}
	
	protected void createNewProject() {
		final Dialog dialog = new Dialog("Create project", skin);
		
		dialog.add(new Label("Name: ", skin));
		
		final TextField nameProject = new TextField("", skin);
		dialog.add(nameProject);
		
		dialog.row();
		
		TextButton create = new TextButton("Create", skin);
		dialog.add(create);
		
		create.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				projects.add(new Project(nameProject.getText(), TileMapEditor.programDir + nameProject.getText() + "/"));
				writeProjectsList();
				projectsNames.add(nameProject.getText());
				projectsList.setItems(projectsNames);
				dialog.hide();
			}
		});
		
		TextButton cancel = new TextButton("Cancel", skin);
		dialog.add(cancel);
		
		cancel.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				dialog.hide();
			}
		});
		
		dialog.show(stage);
	}

	@SuppressWarnings("unchecked")
	private void loadProjectsList() {
		if(!file.exists())
			writeProjectsList();
		
		projects = json.fromJson(ArrayList.class, Project.class, file);
		
		for(Project p : projects) {
			projectsNames.add(p.name);
		}
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
