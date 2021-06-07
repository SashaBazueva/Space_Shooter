package ru.bzbzz.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.bzbzz.base.Sprite;
import ru.bzbzz.math.Rect;

public class Logo extends Sprite {

    private static float V_LEN = 0.008f;

    private Vector2 touch;
    private Vector2 v;
    private Vector2 tmp;


    public Logo(Texture region){
        super(new TextureRegion(region));

        this.touch = new Vector2();
        v = new Vector2();
        this.tmp = new Vector2();
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        tmp.set(touch);
        if (tmp.sub(pos).len()<=V_LEN){
            pos.set(touch);
        }else{
            pos.add(v);
        }

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.15f);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        v.set(touch.x - pos.x, touch.y - pos.y).setLength(V_LEN);
        return super.touchDown(touch, pointer, button);
    }
}
