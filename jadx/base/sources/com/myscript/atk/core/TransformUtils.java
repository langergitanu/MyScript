package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public final class TransformUtils {
    private TransformUtils() {
    }

    public static Point mapped(Point point, Transform transform) {
        return ATKCore.mapped(point, transform);
    }

    public static PointerInfo mapped(PointerInfo pointerInfo, Transform transform) {
        return ATKCore.mapped(pointerInfo, transform);
    }

    public static Line mapped(Line line, Transform transform) {
        return ATKCore.mapped(line, transform);
    }

    public static Rectangle mapped(Rectangle rectangle, Transform transform) {
        return ATKCore.mapped(rectangle, transform);
    }

    public static Path mapped(Path path, Transform transform) {
        return ATKCore.mapped(path, transform);
    }

    public static Extent mapped(Extent extent, Transform transform) {
        return ATKCore.mapped(extent, transform);
    }
}
