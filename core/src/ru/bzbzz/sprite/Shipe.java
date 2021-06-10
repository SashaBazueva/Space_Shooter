package ru.bzbzz.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.bzbzz.base.Sprite;
import ru.bzbzz.math.Rect;

public class Shipe extends Sprite {
    private final static float VELOCITY = 0.25f;

    public Shipe(TextureAtlas atlas) {
        super(atlas.findRegion("ship"));
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.2f);
    }

    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);

    }
}
