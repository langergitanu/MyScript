package com.myscript.nebo.common.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: loaded from: classes3.dex */
public class DrawableUtils {
    public static Drawable setSize(Drawable drawable, int i) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setSize(i, i);
            return drawable;
        }
        drawable.setBounds(0, 0, i, i);
        return drawable;
    }

    public static Drawable addPaddingArround(int i, Drawable drawable) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable});
        layerDrawable.setLayerInset(0, i, i, i, i);
        return layerDrawable;
    }
}
