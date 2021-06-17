package ru.bzbzz.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.bzbzz.base.BaseScreen;
import ru.bzbzz.math.Rect;
import ru.bzbzz.pool.BulletPool;
import ru.bzbzz.sprite.Ship;

public class GameScreen extends BaseScreen {

    private TextureAtlas atlas;

    private Ship ship;
    private BulletPool bulletPool;

    private  Music gameMusic;
    @Override
    public void show() {
        isGameStart = true;
        super.show();
        atlas = new TextureAtlas("textures/ship and enemy.atlas");
        bulletPool = new BulletPool();
        ship = new Ship(atlas, bulletPool);
        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/game_sound.mp3"));
        gameMusic.setLooping(true);
        gameMusic.setVolume(0.3f);
        gameMusic.play();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        freeAllDestroy();
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
        bulletPool.dispose();
        gameMusic.dispose();
        ship.dispose();
    }

    @Override
    public void update(float delta){
        super.update(delta);
        ship.update(delta);
        bulletPool.updateActiveSprites(delta);
    }

    @Override
    public void draw(){
        ScreenUtils.clear(0.06f, 0.06f, 0.1f, 1);
        batch.begin();
        super.draw();
        bulletPool.drawActiveSprites(batch);
        ship.draw(batch);
        batch.end();
    }

    private void freeAllDestroy(){
        bulletPool.freeAllDestroy();
    }

    @Override
    public boolean keyDown(int keycode) {
        ship.keyDown(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        ship.keyUp(keycode);
        return false;
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        return false;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        ship.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        ship.touchUp(touch, pointer, button);
        return false;
    }
}
