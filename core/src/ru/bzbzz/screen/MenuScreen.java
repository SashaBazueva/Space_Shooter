package ru.bzbzz.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.bzbzz.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture background;

    private Vector2 pos;//вектор для отрисовки изображения
    private Vector2 center;
    private Vector2 destination;
    private Vector2 v;//вектор скорости
    private Vector2 h;//вектор траектории движения

    @Override
    public void show() {
        super.show();
        img = new Texture("UFO.png");
        background = new Texture("bckground.jpg");

        pos = new Vector2(0, Gdx.graphics.getHeight());
        center = new Vector2((float) img.getWidth() / 2, (float) (Gdx.graphics.getHeight() - img.getHeight() / 2));
        destination = new Vector2(0, Gdx.graphics.getHeight());
        v = new Vector2();
        h = new Vector2();
    }

    @Override
    public void render(float delta) {
        if (Math.round(center.x) == Math.round(destination.x)) {
            v.set(0, v.y);
        }
        if (Math.round(center.y) == Math.round(destination.y)) {
            v.set(v.x, 0);
        } else {
            pos.add(v);
            center.add(v);
        }
        ScreenUtils.clear(0.36f, 0.09f, 0.53f, 1);


        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(img, pos.x, Gdx.graphics.getHeight() - pos.y, 256, 136);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        background.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        destination.set(screenX, screenY);
        h.set(destination.x - center.x, destination.y - center.y);//вычисление траектории движения

        v.set(h.x / 80, h.y / 80);//с какой скоростью будет двигаться картинка

        return super.touchDown(screenX, screenY, pointer, button);
    }

}
