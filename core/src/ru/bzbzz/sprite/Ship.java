package ru.bzbzz.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.bzbzz.base.Sprite;
import ru.bzbzz.math.Rect;

public class Ship extends Sprite {
    private static final float SCALE = 0.2f;

    private static float velocity;
    private Vector2 touch;

    private Rect worldBounds;

    public Ship(TextureAtlas atlas) {
        super(atlas.findRegion("ship2"));
        touch = new Vector2();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (velocity != 0) {
            pos.set(pos.x + velocity, pos.y);
        }
        if ((getRight() - getHalfWidth()) < worldBounds.getLeft()) {
            setRight(worldBounds.getLeft() + getHalfWidth());
        }
        if ((getLeft() + getHalfWidth()) > worldBounds.getRight()) {
            setLeft(worldBounds.getRight() - getHalfWidth());
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
            velocity = -0.0065f;
            return true;
        }
        if (keycode == 22) {
            velocity = 0.0065f;
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == 21 | keycode == 22) {
            velocity = 0f;
        }
        return super.keyUp(keycode);
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        this.touch.set(touch);
        pos.set(touch.x - worldBounds.getHalfWidth(), pos.y);
        return super.touchDragged(touch, pointer);
    }

}
