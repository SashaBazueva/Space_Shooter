package ru.bzbzz.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.bzbzz.base.Sprite;
import ru.bzbzz.math.Rect;

public class Ship extends Sprite {

    private static float SCALE = 0.22f;
    private static float VELOCITY = 0.0065f;

    private boolean isMovingON;
    private Rect worldBounds;

    public Ship(TextureAtlas atlas) {
        super(atlas.findRegion("ship1"));
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (isMovingON) {
            pos.set(pos.x + VELOCITY, pos.y);
        }
        if (getRight() < worldBounds.getLeft()) {
            setLeft(worldBounds.getRight());
        }
        if (getLeft() > worldBounds.getRight()) {
            setRight(worldBounds.getLeft());
        }
        if (getTop() < worldBounds.getBottom()) {
            setBottom(worldBounds.getTop());
        }
        if (getBottom() > worldBounds.getTop()) {
            setTop(worldBounds.getBottom());
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(SCALE);
        setBottom(worldBounds.getBottom() + 0.02f);
        this.worldBounds = worldBounds;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == 21) {
            if (VELOCITY > 0) {
                VELOCITY *= -1;
            }
            isMovingON = true;
            return true;
        }
        if (keycode == 22) {
            if (VELOCITY<0){
                VELOCITY *= -1;
            }
            isMovingON = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == 21 | keycode == 22) {
            isMovingON = false;
        }
        return super.keyUp(keycode);
    }
}
