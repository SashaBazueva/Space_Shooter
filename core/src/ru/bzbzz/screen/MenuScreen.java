package ru.bzbzz.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.bzbzz.base.BaseScreen;
import ru.bzbzz.math.Rect;
import ru.bzbzz.sprite.Background;
import ru.bzbzz.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Background background;

    private Texture lg;
    private Logo logo;

    @Override
    public void show() {
        super.show();

        bg = new Texture("background.jpg");//путь к текстуре
        background = new Background(bg);

        lg = new Texture("UFO.png");
        logo = new Logo(lg);
    }

    @Override
    public void render(float delta) {
        logo.update(delta);
        ScreenUtils.clear(0.36f, 0.09f, 0.53f, 1);


        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        lg.dispose();
        bg.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch, pointer, button);
        return super.touchDown(touch, pointer, button);
    }
}
