package ru.bzbzz.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.bzbzz.base.Sprite;
import ru.bzbzz.math.Rand;
import ru.bzbzz.math.Rect;

public class Star extends Sprite {

    private final Vector2 v;
    private Rect worldBounds;

    public Star(TextureAtlas atlas) {
        super(atlas.findRegion("star"));
        v = new Vector2();
        float vX = Rand.nextFloat(-0.0005f, 0.0005f);
        float vY = Rand.nextFloat(-0.1f, -0.05f);
        v.set(vX, vY);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(v, delta);
        if (getRight() < worldBounds.getLeft()){
            setLeft(worldBounds.getRight());
        }
        if (getLeft() > worldBounds.getRight()){
            setRight(worldBounds.getLeft());
        }
        if (getTop() < worldBounds.getBottom()){
            setBottom(worldBounds.getTop());
        }
        if (getBottom() > worldBounds.getTop()){
            setTop(worldBounds.getBottom());
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        setHeightProportion(Rand.nextFloat(0.015f, 0.025f));
        float x = Rand.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
        float y = Rand.nextFloat(worldBounds.getBottom(), worldBounds.getTop());
        pos.set(x,y);
    }
}
