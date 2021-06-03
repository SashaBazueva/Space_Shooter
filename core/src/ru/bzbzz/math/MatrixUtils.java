package ru.bzbzz.math;

import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;

public class MatrixUtils {

    private MatrixUtils() {
    }

    public static void calcTransitionMatrix(Matrix4 mat, Rect from, Rect to){
        float scaleX = to.getWidth()/from.getWidth();
        float scaleY = to.getHeight()/from.getHeight();

        mat.idt().translate(to.pos.x, to.pos.y, 0f).translate(scaleX, scaleY, 1f).translate(-from.pos.x, -from.pos.y, 0f);
    }

    public static void calcTransitionMatrix(Matrix3 mat, Rect from, Rect to){
        float scaleX = to.getWidth()/from.getWidth();
        float scaleY = to.getHeight()/from.getHeight();

        mat.idt().translate(to.pos.x, to.pos.y).translate(scaleX, scaleY).translate(-from.pos.x, -from.pos.y);
    }
}
