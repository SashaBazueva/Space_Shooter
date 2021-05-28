package ru.bzbzz;

import com.badlogic.gdx.Game;

import ru.bzbzz.screen.MenuScreen;

public class CosmoShooter extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen());
    }
}
