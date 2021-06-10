package ru.bzbzz.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.bzbzz.base.BaseScreen;
import ru.bzbzz.math.Rect;
import ru.bzbzz.sprite.Background;

public class GameScreen extends BaseScreen {

    protected Texture bg;
    protected Background background;

    @Override
    public void show() {
        super.show();
        bg = new Texture("back2.png");
        background = new Background(bg);
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
        background.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
    }

    private void update(float delta){

    }

    private void draw(){
        ScreenUtils.clear(0.36f, 0.09f, 0.53f, 1);
        batch.begin();
        background.draw(batch);
        batch.end();
    }
}
