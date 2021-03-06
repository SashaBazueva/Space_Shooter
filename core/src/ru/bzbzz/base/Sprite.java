package ru.bzbzz.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.bzbzz.math.Rect;

public class Sprite extends Rect {

    protected float angle;
    protected float scale = 1;
    protected TextureRegion[] regions;
    protected int frame;
    protected boolean isDestroyed;

    public Sprite() {
    }

    public Sprite(TextureRegion region) {
        regions = new TextureRegion[1];
        regions[0] = region;
    }

    public void setHeightProportion(float height) {
        setHeight(height);
        float aspect = (float) regions[0].getRegionWidth() / (float) regions[0].getRegionHeight();
        setWidth(height * aspect);
    }

    public void update(float delta) {
    }

    public void draw(SpriteBatch batch) {
        batch.draw(regions[frame], getLeft(), getBottom(), getHalfWidth(), getHalfHeight(), getWidth(), getHeight(), scale, scale, angle);
    }

    public void resize(Rect worldBounds) {

    }

    public boolean touchDragged(Vector2 touch, int pointer){
        return false;
    }

    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return false;
    }

    public boolean keyDown(int keycode) {
        return false;
    }

    public boolean keyUp(int keycode) {
        return false;
    }

    public float getAngle() {
        return angle;
    }

    public float getScale() {
        return scale;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public boolean getIsDestroyed() {
        return isDestroyed;
    }

    public void destroy(){
        isDestroyed = true;
    }

    public void flushDestroy(){
        isDestroyed = false;
    }
}
