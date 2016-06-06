package com.renieckik.tilemapeditor.gui;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.kotcrab.vis.ui.widget.Menu;
import com.kotcrab.vis.ui.widget.MenuBar;

public class MenuBarElement extends GuiElement {
	
	private MenuBar menuBar;
	
	public MenuBarElement() {
		this.setName("MenuBar");
		
		menuBar = new MenuBar();
		Menu file = new Menu("File");
		menuBar.addMenu(file);
	}
	
	public Table getActor() {
		return menuBar.getTable();
	}
	
}
