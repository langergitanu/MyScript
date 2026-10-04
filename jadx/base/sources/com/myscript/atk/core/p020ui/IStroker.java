package com.myscript.atk.core.p020ui;

import com.myscript.atk.core.InkStroke;
import com.myscript.atk.core.Path;
import com.myscript.atk.core.Transform;

/* JADX INFO: loaded from: classes4.dex */
public interface IStroker<T> {
    public static final int CALLIGRAPHIC_BRUSH = 3;
    public static final int CALLIGRAPHIC_QUILL = 2;
    public static final int CALLIGRAPHIC_QUILL_DIRECTIONAL = 4;
    public static final int DYNAMIC_ENVELOPE = 9;
    public static final int FELT_PEN = 0;
    public static final int FOUNTAIN_PEN = 1;
    public static final int HIGHLIGHTER = 6;
    public static final int POLYLINE = 11;
    public static final int QALAM = 5;
    public static final int QUAD_BEZIER = 10;
    public static final int ROUNDED = 8;
    public static final int SQUARE = 7;

    int getStroking();

    float getWidth();

    void setStroking(int i);

    void setWidth(float f);

    void stroke(InkStroke inkStroke, Transform transform, T t);

    void stroke(Path path, T t);
}
