package ru.bzbzz.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import ru.bzbzz.base.ScaledButton;
import ru.bzbzz.math.Rect;
import ru.bzbzz.screen.GameScreen;

public class ButtonPlay extends ScaledButton {
    private static final float HEIGHT = 0.15f;
    private Game game;

    public ButtonPlay(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("play"));
        this.game = game;
    }

    @Override
    protected void action() {
        game.setScreen(new GameScreen());
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT * worldBounds.getWidth());
        setBottom(worldBounds.getBottom() + 0.03f);
        setLeft(worldBounds.getLeft() + 0.03f);
    }
}
