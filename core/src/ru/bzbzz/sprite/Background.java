package ru.bzbzz.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.bzbzz.base.Sprite;
import ru.bzbzz.math.Rect;

public class Background extends Sprite {

    private static final float VELOCITY = -0.04f;
    private Rect worldBounds;

    public Background(TextureAtlas atlas, String name) {
        super(atlas.findRegion(name));
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(2f);
        this.pos.set(worldBounds.pos);
        setBottom(worldBounds.getBottom());
        this.worldBounds = worldBounds;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.set(pos.x, pos.y + VELOCITY * delta);

        if (getTop() < worldBounds.getBottom()) {
            setBottom(worldBounds.getBottom()+getHeight()-0.001f);
        }
    }
}
