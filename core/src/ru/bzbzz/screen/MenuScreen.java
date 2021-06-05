package ru.bzbzz.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.bzbzz.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    int imgHalfHeight;
    int imgHalfWidth;
    private Texture background;

    private Vector2 pos;//вектор для отрисовки изображения
    private Vector2 tmp;
    private Vector2 v;//вектор скорости
    private Vector2 dest;//вектор траектории движения

    @Override
    public void show() {
        super.show();
        img = new Texture("frog.jpg");
        imgHalfHeight = img.getHeight()/2;
        imgHalfWidth = img.getWidth()/2;
        background = new Texture("background.jpg");

        pos = new Vector2(imgHalfWidth, Gdx.graphics.getHeight() - imgHalfHeight);
        tmp = new Vector2();
        v = new Vector2();
        dest = new Vector2();
    }

    @Override
    public void render(float delta) {
        tmp.set(dest);
        if (tmp.sub(pos).len() <= v.len()) {
            pos.set(dest);
        } else {
            pos.add(v);
        }

        ScreenUtils.clear(0.36f, 0.09f, 0.53f, 1);


        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(img, pos.x -  imgHalfWidth, Gdx.graphics.getHeight() - pos.y - imgHalfHeight);
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
        dest.set(screenX, screenY);//сохраняем координаты точки нажатия
        v.set((screenX - pos.x) / 80, (screenY - pos.y) / 80);//с какой скоростью будет двигаться картинка

        return super.touchDown(screenX, screenY, pointer, button);
    }

}
