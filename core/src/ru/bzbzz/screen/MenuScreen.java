package ru.bzbzz.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.bzbzz.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private int imgHalfHeight;
    private int imgHalfWidth;
    //private Texture background;

    private Vector2 pos;//вектор для отрисовки изображения
    private Vector2 tmp;
    private Vector2 v;//вектор скорости

    @Override
    public void show() {
        super.show();
        img = new Texture("frog.jpg");
        imgHalfHeight = img.getHeight() / 2;
        imgHalfWidth = img.getWidth() / 2;
        //background = new Texture("background.jpg");

        pos = new Vector2(-0.5f, -0.5f);
        tmp = new Vector2();
        v = new Vector2();
    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0.36f, 0.09f, 0.53f, 1);


        batch.begin();
        batch.draw(img, pos.x, pos.y, 1f, 1f);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        //background.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        pos.set(touch);
        return super.touchDown(touch, pointer, button);
    }
}
