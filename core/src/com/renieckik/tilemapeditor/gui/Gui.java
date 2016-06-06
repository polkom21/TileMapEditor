package com.renieckik.tilemapeditor.gui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.kotcrab.vis.ui.VisUI;

public class Gui implements Disposable {
	
	private Table table;
	
	private MenuBarElement menu;
	
	public Gui(Stage stage) {
		VisUI.load();
		
		table = new Table();
		table.setWidth((int)stage.getCamera().viewportWidth);
		table.setPosition(0, stage.getCamera().viewportHeight - 12);
		
		menu = new MenuBarElement();
		
		table.add(menu.getActor()).fillX().expandX().row();
		stage.addActor(table);
	}

	@Override
	public void dispose() {
		VisUI.dispose();
	}
	
}
