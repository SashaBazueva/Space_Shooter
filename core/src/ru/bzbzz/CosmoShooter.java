package ru.bzbzz;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class CosmoShooter extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("frog.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.5f, 0.2f, 0.7f, 1);
		batch.begin();
		batch.draw(img, 0, 0, 256, 256);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
