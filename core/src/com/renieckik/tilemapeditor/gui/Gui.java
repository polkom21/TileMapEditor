package com.renieckik.tilemapeditor.gui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.kotcrab.vis.ui.VisUI;

public class Gui extends Stage {
	
	private Table table;
	
	private MenuBarElement menu;
	
	public Gui() {
		VisUI.load();
		
		table = new Table();
		
		menu = new MenuBarElement();
		
		table.add(menu.getActor());
		
		this.addActor(table);
	}
	
	@Override
	public void dispose() {
		VisUI.dispose();
	}
	
}
