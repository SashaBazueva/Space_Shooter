package ru.bzbzz.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.bzbzz.base.BaseScreen;
import ru.bzbzz.math.Rect;
import ru.bzbzz.sprite.Background;
import ru.bzbzz.sprite.Ship;

public class GameScreen extends BaseScreen {

    private Texture bg;
    private Background background;
    private TextureAtlas atlas;

    private Ship ship;

    @Override
    public void show() {
        super.show();
        bg = new Texture("back1.png");
        background = new Background(bg);
        atlas = new TextureAtlas("textures/ship and enemy.atlas");
        ship = new Ship(atlas);
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
        ship.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlas.dispose();
    }

    private void update(float delta){
        ship.update(delta);
    }

    private void draw(){
        ScreenUtils.clear(0.36f, 0.09f, 0.53f, 1);
        batch.begin();
        background.draw(batch);
        ship.draw(batch);
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        return ship.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return ship.keyUp(keycode);
    }


}
