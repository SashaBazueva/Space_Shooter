package ru.bzbzz.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.bzbzz.base.BaseScreen;
import ru.bzbzz.math.Rect;
import ru.bzbzz.sprite.ButtonExit;
import ru.bzbzz.sprite.ButtonPlay;

public class MenuScreen extends BaseScreen {
    private final Game game;

    private TextureAtlas atlas;

    private ButtonExit exit;
    private ButtonPlay play;

    public MenuScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        atlas = new TextureAtlas("textures/buttons.atlas");
        exit = new ButtonExit(atlas);
        play = new ButtonPlay(atlas, game);
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        atlas.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        exit.resize(worldBounds);
        play.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        exit.touchDown(touch, pointer, button);
        play.touchDown(touch, pointer, button);
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        exit.touchUp(touch, pointer, button);
        play.touchUp(touch, pointer, button);
        return super.touchUp(touch, pointer, button);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ENTER) {
            game.setScreen(new GameScreen());
        }
        return super.keyDown(keycode);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }

    @Override
    public void draw() {
        ScreenUtils.clear(0.06f, 0.06f, 0.1f, 1);
        batch.begin();
        super.draw();
        exit.draw(batch);
        play.draw(batch);
        batch.end();
    }
}