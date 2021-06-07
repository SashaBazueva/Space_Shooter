package ru.bzbzz.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.bzbzz.base.BaseScreen;
import ru.bzbzz.math.Rect;
import ru.bzbzz.sprite.Background;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Background background;

    private Texture img;
    private Vector2 pos;//вектор для отрисовки изображения

    @Override
    public void show() {
        super.show();
        img = new Texture("UFO.png");
        pos = new Vector2(-0.5f, -0.5f);

        bg = new Texture("background.jpg");//путь к текстуре
        background = new Background(bg);
    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0.36f, 0.09f, 0.53f, 1);


        batch.begin();
        background.draw(batch);
        batch.draw(img, pos.x, pos.y, 0.256f, 0.136f);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        bg.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        pos.set(touch);
        return super.touchDown(touch, pointer, button);
    }
}
