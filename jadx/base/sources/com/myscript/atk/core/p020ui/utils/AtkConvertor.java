package com.myscript.atk.core.p020ui.utils;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.Glyph;
import com.myscript.atk.core.InkStyle;
import com.myscript.atk.core.InvalidateType;
import com.myscript.atk.core.Rectangle;

/* JADX INFO: loaded from: classes4.dex */
public class AtkConvertor {
    public static RectF toRectF(Rectangle rectangle) {
        return new RectF(rectangle.getLeft(), rectangle.getTop(), rectangle.getRight(), rectangle.getBottom());
    }

    public static Rect toRect(Rectangle rectangle) {
        return new Rect((int) rectangle.getLeft(), (int) rectangle.getTop(), (int) rectangle.getRight(), (int) rectangle.getBottom());
    }

    public static String toString(InkStyle inkStyle) {
        return String.format("InkStyle[%s, %s, %s, %f]", inkStyle.getBrush(), inkStyle.getFontFamily(), String.valueOf(Integer.toHexString(inkStyle.getColor())), Float.valueOf(inkStyle.getWidth()));
    }

    public static String toString(Canvas canvas) {
        Rect clipBounds = canvas.getClipBounds();
        return String.format("Canvas[%d %d, %s]", Integer.valueOf(clipBounds.width()), Integer.valueOf(clipBounds.height()), hashCode(Integer.valueOf(canvas.hashCode())));
    }

    public static String toString(Extent extent) {
        if (extent == null) {
            return "Extent[null]";
        }
        return String.format("Extent[%.0f %.0f, %s]", Float.valueOf(Math.abs(extent.getXMax() - extent.getXMin())), Float.valueOf(Math.abs(extent.getYMax() - extent.getYMin())), hashCode(Integer.valueOf(extent.hashCode())));
    }

    public static String toString(Glyph glyph) {
        return String.format("Glyph[%s]", glyph.getLabel());
    }

    public static InvalidateType toInvalidateType(int i) {
        if ((i >> 2) == 1) {
            return InvalidateType.CAPTURE;
        }
        if (i == 1) {
            return InvalidateType.DOCUMENT;
        }
        if ((i >> 1) == 1) {
            return InvalidateType.TEMPORARY;
        }
        return InvalidateType.DOCUMENT;
    }

    private static String hashCode(Object obj) {
        return String.valueOf(Integer.toHexString(obj.hashCode()));
    }
}
