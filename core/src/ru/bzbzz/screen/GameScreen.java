package ru.bzbzz.screen;

import com.badlogic.gdx.utils.ScreenUtils;

import ru.bzbzz.base.BaseScreen;
import ru.bzbzz.math.Rect;

public class GameScreen extends BaseScreen {
    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    private void update(float delta){

    }

    private void draw(){
        ScreenUtils.clear(0.36f, 0.09f, 0.53f, 1);
        batch.begin();
        batch.end();
    }
}
