package ru.bzbzz.math;

import com.badlogic.gdx.math.Vector2;

public class Rect {

    public Vector2 pos = new Vector2();
    private float halfWidth;
    private float halfHeight;

    public Rect() {

    }

    public Rect(float x, float y, float halfWidth, float halfHeight) {
        pos.set(x, y);
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
    }

    //Getters
    public float getLeft() {
        return pos.x - halfWidth;
    }

    public float getRight() {
        return pos.x + halfWidth;
    }

    public float getBottom() {
        return pos.y - halfHeight;
    }

    public float getTop() {
        return pos.y + halfHeight;
    }

    public float getWidth() {
        return halfWidth * 2f;
    }

    public float getHalfWidth() {
        return halfWidth;
    }

    public float getHalfHeight() {
        return halfHeight;
    }

    public float getHeight() {
        return halfHeight * 2f;
    }

    //Setters
    public void set(Rect from) {
        pos.set(from.pos);
        halfHeight = from.halfHeight;
        halfWidth = from.halfWidth;
    }

    public void set(float x, float y, float width, float height) {
        pos.set(x, y);
        setSize(width, height);
    }

    public void setLeft(float left) {
        pos.x = left + halfWidth;
    }

    public void setRight(float right) {
        pos.x = right - halfWidth;
    }

    public void setBottom(float down) {
        pos.y = down + halfHeight;
    }

    public void setTop(float top) {
        pos.y = top - halfHeight;
    }

    public void setWidth(float width) {
        this.halfWidth = width / 2;
    }

    public void setHeight(float height) {
        this.halfHeight = height / 2;
    }

    public void setSize(float width, float height) {
        this.halfWidth = width / 2;
        this.halfHeight = height / 2;
    }

}
