package ru.bzbzz.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.bzbzz.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;

    @Override
    public void show() {
        super.show();
        img = new Texture("frog.jpg");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.5f, 0.2f, 0.7f, 1);
        batch.begin();
        batch.draw(img, 0, 0, 256, 256);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }
}
