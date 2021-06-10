package ru.bzbzz.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import ru.bzbzz.base.ScaledButton;
import ru.bzbzz.math.Rect;

public class ButtonPlay extends ScaledButton {
    private static final float HEIGHT = 0.17f;

    public ButtonPlay(TextureAtlas atlas) {
        super(atlas.findRegion("play"));
    }

    @Override
    protected void action() {

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getBottom() + 0.03f);
        setLeft(worldBounds.getLeft() + 0.03f);
    }
}
