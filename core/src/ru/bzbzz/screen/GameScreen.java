package ru.bzbzz.screen;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.bzbzz.base.BaseScreen;
import ru.bzbzz.math.Rect;
import ru.bzbzz.sprite.Ship;

public class GameScreen extends BaseScreen {

    private TextureAtlas atlas;

    private Ship ship;

    @Override
    public void show() {
        isGameStart = true;
        super.show();
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
        ship.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        atlas.dispose();
    }

    @Override
    public void update(float delta){
        super.update(delta);
        ship.update(delta);
    }

    @Override
    public void draw(){
        ScreenUtils.clear(0.36f, 0.09f, 0.53f, 1);
        batch.begin();
        super.draw();
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

    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        return ship.touchDragged(touch, pointer);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return ship.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return ship.touchUp(touch, pointer, button);
    }
}
