package ru.bzbzz.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.bzbzz.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 pos;
    private Vector2 destination;

    @Override
    public void show() {
        super.show();
        img = new Texture("frog.jpg");
        pos = new Vector2(0, 0);
        destination = new Vector2(0, Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        pos.set(destination);
        ScreenUtils.clear(0.5f, 0.2f, 0.7f, 1);
        batch.begin();
        batch.draw(img, pos.x, Gdx.graphics.getHeight() - pos.y, 256, 256);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        destination.set(screenX - 128, screenY + 128);
        return super.touchDown(screenX, screenY, pointer, button);
    }

}
