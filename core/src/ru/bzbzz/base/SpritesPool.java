package ru.bzbzz.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public abstract class SpritesPool<T extends Sprite> {

    protected List<T> activeObject = new ArrayList<>();
    protected List<T> freeObject = new ArrayList<>();

    protected abstract T createNewObject();

    public T obtain (){
        T object;
        if (freeObject.isEmpty()){
            object = createNewObject();
        }else{
            object = freeObject.remove(freeObject.size()-1);
        }
        activeObject.add(object);
        return object;
    }

    public void updateActiveSprites(float delta){
        for (Sprite sprite: activeObject) {
            if (!sprite.getIsDestroyed()){
                sprite.update(delta);
            }
        }
    }

    public void drawActiveSprites(SpriteBatch batch){
        for (Sprite sprite: activeObject) {
            if (!sprite.getIsDestroyed()){
                sprite.draw(batch);
            }
        }
    }

    public void setObjectFree(T object){
        if (activeObject.remove(object)){
            freeObject.add(object);
        }
    }

    public void freeAllDestroy(){
        for (int i = 0; i < activeObject.size(); i++) {
            T object = activeObject.get(i);
            if (object.getIsDestroyed()){
                setObjectFree(object);
                i--;
                object.flushDestroy();
            }
        }
    }

    public List<T> getActiveObject() {
        return activeObject;
    }

    public void dispose(){
        activeObject.clear();
        freeObject.clear();
    }
}
