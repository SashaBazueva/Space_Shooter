package ru.bzbzz.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.bzbzz.base.BaseScreen;
import ru.bzbzz.math.Rect;
import ru.bzbzz.sprite.Background;
import ru.bzbzz.sprite.ButtonExit;
import ru.bzbzz.sprite.ButtonPlay;
import ru.bzbzz.sprite.Star;

public class MenuScreen extends BaseScreen {
    private static final int STAR_COUNT = 256;
    private final Game game;


    private Texture bg;
    private Background background;

    private TextureAtlas atlas;

    private Star[] stars;
    private ButtonExit exit;
    private ButtonPlay play;

    public MenuScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("back2.png");
        background = new Background(bg);


        atlas = new TextureAtlas("textures/buttons and star.atlas");
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }
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
        bg.dispose();
        atlas.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        exit.resize(worldBounds);
        play.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        exit.touchDown(touch,pointer,button);
        play.touchDown(touch, pointer, button);
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        exit.touchUp(touch,pointer,button);
        play.touchUp(touch, pointer, button);
        return super.touchUp(touch, pointer, button);
    }

    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);
    }

    private void update(float delta){
        for (Star star : stars) {
            star.update(delta);
        }

    }

    private void draw(){
        ScreenUtils.clear(0.36f, 0.09f, 0.53f, 1);
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        exit.draw(batch);
        play.draw(batch);
        batch.end();
    }
}