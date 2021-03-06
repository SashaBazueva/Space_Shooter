package ru.bzbzz.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.bzbzz.base.Sprite;
import ru.bzbzz.math.Rect;
import ru.bzbzz.pool.BulletPool;

public class Ship extends Sprite {

    private static final float SCALE = 0.18f;
    private static final float VELOCITY = 0.27f;
    private static final int INVALID_POINTER = -1;

    private Vector2 v;
    private Vector2 tmp;

    private boolean isPressedLeft;
    private boolean isPressedRight;

    private int leftPointer;
    private int rightPointer;

    private Rect worldBounds;
    private BulletPool bulletPool;
    private TextureRegion bulletRegion;
    private Vector2 bulletV;
    private Sound shoot;
    private long timer;

    public Ship(TextureAtlas atlas, BulletPool bulletPool) {
        super(atlas.findRegion("ship2"));
        v = new Vector2();
        tmp = new Vector2();
        leftPointer = INVALID_POINTER;
        rightPointer = INVALID_POINTER;
        this.bulletPool = bulletPool;
        bulletRegion = atlas.findRegion("bullet2");
        bulletV = new Vector2(0f, 0.5f);
        shoot = Gdx.audio.newSound(Gdx.files.internal("sounds/shoot1.wav"));
        timer = System.currentTimeMillis();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (v.len() != 0) {
            pos.mulAdd(v, delta);
        }
        if ((getRight() - getHalfWidth()) < worldBounds.getLeft()) {
            setRight(worldBounds.getLeft() + getHalfWidth());
        }
        if ((getLeft() + getHalfWidth()) > worldBounds.getRight()) {
            setLeft(worldBounds.getRight() - getHalfWidth());
        }
        if (System.currentTimeMillis() - timer > 329){
            shoot();
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
        if (keycode == Input.Keys.LEFT | keycode == Input.Keys.A) {
            isPressedLeft = true;
            v.set(-VELOCITY, 0f);
            return true;
        }
        if (keycode == Input.Keys.RIGHT | keycode == Input.Keys.D) {
            isPressedRight = true;
            v.set(VELOCITY, 0f);
            return true;
        }
        if (keycode == Input.Keys.UP | keycode == Input.Keys.W) {
            shoot();
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:
                v.setZero();
                isPressedLeft = false;
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                v.setZero();
                isPressedRight = false;
                break;
        }
        if (isPressedRight) {
            v.set(VELOCITY, 0f);
        }
        if (isPressedLeft) {
            v.set(-VELOCITY, 0f);
        }
        if (!isPressedLeft && !isPressedRight) {
            v.setZero();
        }
        return super.keyUp(keycode);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        if (touch.x < worldBounds.getHalfWidth()) {
            leftPointer = pointer;
            v.set(-VELOCITY, 0f);
        } else {
            rightPointer = pointer;
            v.set(VELOCITY, 0f);
        }
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        if (leftPointer == pointer) {
            leftPointer = INVALID_POINTER;
            if (rightPointer != INVALID_POINTER) {
                v.set(VELOCITY, 0f);
            } else {
                v.setZero();
            }
        }
        if (rightPointer == pointer) {
            rightPointer = INVALID_POINTER;
            if (leftPointer != INVALID_POINTER) {
                v.set(-VELOCITY, 0f);
            } else {
                v.setZero();
            }
        }
        return super.touchUp(touch, pointer, button);
    }

    private void shoot() {
        timer = System.currentTimeMillis();
        shoot.play(0.15f);
        Bullet bullet = bulletPool.obtain();
        tmp.set(this.pos.x, this.pos.y + getHalfHeight());
        bullet.set(this, bulletRegion, tmp, bulletV, worldBounds, 0.04f, 1);
    }

    public void dispose(){
        shoot.dispose();
    }
}
