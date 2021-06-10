package ru.bzbzz.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.bzbzz.base.ScaledButton;
import ru.bzbzz.math.Rect;

public class ButtonExit extends ScaledButton {
    private static final float HEIGHT = 0.16f;

    public ButtonExit(TextureAtlas atlas) {
        super(atlas.findRegion("exit"));
    }

    @Override
    protected void action() {
        Gdx.app.exit();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getBottom() + 0.03f);
        setRight(worldBounds.getRight() - 0.03f);
    }
}
