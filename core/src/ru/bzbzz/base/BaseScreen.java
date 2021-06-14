package ru.bzbzz.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

import ru.bzbzz.math.MatrixUtils;
import ru.bzbzz.math.Rect;
import ru.bzbzz.sprite.Background;
import ru.bzbzz.sprite.Star;

public class BaseScreen implements Screen, InputProcessor {
    private static final int STAR_COUNT = 256;

    protected SpriteBatch batch;
    protected Vector2 touch;//вектор к точке нажатия

    protected static TextureAtlas bg;
    protected static Background background1;
    protected static Background background2;
    protected Star[] stars;

    private Rect screenBounds;
    private Rect worldBounds;
    private Rect gLBounds;

    private Matrix4 worldToGl;
    private Matrix3 screenToWorld;

    public boolean isGameStart;

    @Override
    public void show() {
        bg = new TextureAtlas("textures/background.atlas");
        background1 = new Background(bg, "part1");
        background2 = new Background(bg, "part2");
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(bg);
        }


        touch = new Vector2();

        screenBounds = new Rect();
        worldBounds = new Rect();
        gLBounds = new Rect(0, 0, 1f, 1f);
        worldToGl = new Matrix4();
        screenToWorld = new Matrix3();

        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        screenBounds.set(0, 0, width, height);

        float aspect = (float) width / height;
        worldBounds.setHeight(1f);
        worldBounds.setWidth(1f * aspect);

        MatrixUtils.calcTransitionMatrix(worldToGl, worldBounds, gLBounds);
        MatrixUtils.calcTransitionMatrix(screenToWorld, screenBounds, worldBounds);
        batch.setProjectionMatrix(worldToGl);
        resize(worldBounds);
    }

    public void resize(Rect worldBounds) {
        background1.resize(worldBounds);
        background2.resize(worldBounds);
        background2.setBottom(background1.getTop());
        for (Star star : stars) {
            star.resize(worldBounds);
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        bg.dispose();

    }

    public void update(float delta) {
        if (isGameStart) {
            background1.update(delta);
            background2.update(delta);
        }
        for (Star star : stars) {
            star.update(delta);
        }
    }

    public void draw() {
        background1.draw(batch);
        background2.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, screenBounds.getHeight() - screenY);//сохраняем координаты точки нажатия
        touch.mul(screenToWorld);
        touchDown(touch, pointer, button);
        return false;
    }

    public boolean touchDown(Vector2 touch, int pointer, int button) {
        System.out.println("touchX = " + touch.x + " | touchY = " + touch.y);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, screenBounds.getHeight() - screenY);//сохраняем координаты точки нажатия
        touch.mul(screenToWorld);
        touchUp(touch, pointer, button);
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        touch.set(screenX, screenBounds.getHeight() - screenY);//сохраняем координаты точки нажатия
        touch.mul(screenToWorld);
        touchDragged(touch, pointer);
        return false;
    }

    public boolean touchDragged(Vector2 touch, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
