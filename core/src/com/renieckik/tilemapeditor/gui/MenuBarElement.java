package com.renieckik.tilemapeditor.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.kotcrab.vis.ui.widget.Menu;
import com.kotcrab.vis.ui.widget.MenuBar;
import com.kotcrab.vis.ui.widget.MenuItem;

public class MenuBarElement extends GuiElement {
	
	private MenuBar menuBar;
	
	public MenuBarElement() {
		this.setName("MenuBar");
		
		menuBar = new MenuBar();
		Menu file = new Menu("File");
		menuBar.addMenu(file);
		
		MenuItem quit = new MenuItem("Quit");
		quit.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();
			}
		});
		file.addItem(quit);
	}
	
	public Table getActor() {
		return menuBar.getTable();
	}
	
}
