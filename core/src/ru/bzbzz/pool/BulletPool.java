package ru.bzbzz.pool;

import ru.bzbzz.base.Sprite;
import ru.bzbzz.base.SpritesPool;
import ru.bzbzz.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet createNewObject() {
        return new Bullet();
    }
}
