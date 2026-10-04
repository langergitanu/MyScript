package com.myscript.nebo.discoverability.p024ui.compose;

import android.graphics.Point;
import android.graphics.PointF;
import androidx.compose.p004ui.geometry.RoundRect;
import androidx.compose.p004ui.geometry.RoundRectKt;
import androidx.compose.p004ui.graphics.AndroidPath_androidKt;
import androidx.compose.p004ui.graphics.Outline;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpeechBubbleShape.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0007\u0018\u0000  2\u00020\u0001:\u0003\u001e\u001f B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/ui/compose/SpeechBubbleShape;", "Landroidx/compose/ui/graphics/Shape;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "caretSize", TtmlNode.CENTER, "Landroid/graphics/Point;", TypedValues.AttributesType.S_TARGET, "<init>", "(FFLandroid/graphics/Point;Landroid/graphics/Point;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "caretLocation", "Lcom/myscript/nebo/discoverability/ui/compose/SpeechBubbleShape$Caret;", "targetPoint", "bubbleSize", "caretSizePx", "", "cornerRadiusPx", "caretLocation-x_KDEd0", "(Landroid/graphics/Point;JFF)Lcom/myscript/nebo/discoverability/ui/compose/SpeechBubbleShape$Caret;", "Direction", "Caret", "Companion", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SpeechBubbleShape implements Shape {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float caretSize;
    private final Point center;
    private final float cornerRadius;
    private final Point target;

    /* JADX INFO: compiled from: SpeechBubbleShape.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Direction.values().length];
            try {
                iArr[Direction.RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Direction.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Direction.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Direction.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ SpeechBubbleShape(float f, float f2, Point point, Point point2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, point, point2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: caretDirection-12SF9DM, reason: not valid java name */
    public static final Direction m12946caretDirection12SF9DM(Point point, long j, Point point2) {
        return INSTANCE.m12948caretDirection12SF9DM(point, j, point2);
    }

    private SpeechBubbleShape(float f, float f2, Point center, Point point) {
        Intrinsics.checkNotNullParameter(center, "center");
        this.cornerRadius = f;
        this.caretSize = f2;
        this.center = center;
        this.target = point;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SpeechBubbleShape.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/ui/compose/SpeechBubbleShape$Direction;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "LEFT", "RIGHT", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Direction {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Direction[] $VALUES;
        public static final Direction TOP = new Direction("TOP", 0);
        public static final Direction BOTTOM = new Direction("BOTTOM", 1);
        public static final Direction LEFT = new Direction("LEFT", 2);
        public static final Direction RIGHT = new Direction("RIGHT", 3);

        private static final /* synthetic */ Direction[] $values() {
            return new Direction[]{TOP, BOTTOM, LEFT, RIGHT};
        }

        public static EnumEntries<Direction> getEntries() {
            return $ENTRIES;
        }

        public static Direction valueOf(String str) {
            return (Direction) Enum.valueOf(Direction.class, str);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        private Direction(String str, int i) {
        }

        static {
            Direction[] directionArr$values = $values();
            $VALUES = directionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(directionArr$values);
        }
    }

    /* JADX INFO: compiled from: SpeechBubbleShape.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/ui/compose/SpeechBubbleShape$Caret;", "", TtmlNode.LEFT, "Landroid/graphics/PointF;", TtmlNode.RIGHT, "tip", "<init>", "(Landroid/graphics/PointF;Landroid/graphics/PointF;Landroid/graphics/PointF;)V", "getLeft", "()Landroid/graphics/PointF;", "getRight", "getTip", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Caret {
        public static final int $stable = 8;
        private final PointF left;
        private final PointF right;
        private final PointF tip;

        public static /* synthetic */ Caret copy$default(Caret caret, PointF pointF, PointF pointF2, PointF pointF3, int i, Object obj) {
            if ((i & 1) != 0) {
                pointF = caret.left;
            }
            if ((i & 2) != 0) {
                pointF2 = caret.right;
            }
            if ((i & 4) != 0) {
                pointF3 = caret.tip;
            }
            return caret.copy(pointF, pointF2, pointF3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PointF getLeft() {
            return this.left;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PointF getRight() {
            return this.right;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PointF getTip() {
            return this.tip;
        }

        public final Caret copy(PointF left, PointF right, PointF tip) {
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            Intrinsics.checkNotNullParameter(tip, "tip");
            return new Caret(left, right, tip);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Caret)) {
                return false;
            }
            Caret caret = (Caret) other;
            return Intrinsics.areEqual(this.left, caret.left) && Intrinsics.areEqual(this.right, caret.right) && Intrinsics.areEqual(this.tip, caret.tip);
        }

        public int hashCode() {
            return (((this.left.hashCode() * 31) + this.right.hashCode()) * 31) + this.tip.hashCode();
        }

        public String toString() {
            return "Caret(left=" + this.left + ", right=" + this.right + ", tip=" + this.tip + ")";
        }

        public Caret(PointF left, PointF right, PointF tip) {
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            Intrinsics.checkNotNullParameter(tip, "tip");
            this.left = left;
            this.right = right;
            this.tip = tip;
        }

        public final PointF getLeft() {
            return this.left;
        }

        public final PointF getRight() {
            return this.right;
        }

        public final PointF getTip() {
            return this.tip;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a5 A[PHI: r0
      0x00a5: PHI (r0v2 float) = (r0v1 float), (r0v5 float) binds: [B:3:0x0024, B:17:0x00a3] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.compose.p004ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Outline mo2085createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        RoundRect RoundRect;
        Caret caretM12947caretLocationx_KDEd0;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        float fMo2191toPx0680j_4 = density.mo2191toPx0680j_4(this.caretSize);
        float fMo2191toPx0680j_42 = density.mo2191toPx0680j_4(this.cornerRadius);
        Path Path = AndroidPath_androidKt.Path();
        Point point = this.target;
        if (point != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[INSTANCE.m12948caretDirection12SF9DM(this.center, size, point).ordinal()];
            if (i == 1) {
                RoundRect = RoundRectKt.RoundRect(0.0f, 0.0f, Float.intBitsToFloat((int) (size >> 32)) - fMo2191toPx0680j_4, Float.intBitsToFloat((int) (size & 4294967295L)), fMo2191toPx0680j_42, fMo2191toPx0680j_42);
            } else if (i == 2) {
                RoundRect = RoundRectKt.RoundRect(0.0f, 0.0f, Float.intBitsToFloat((int) (size >> 32)), Float.intBitsToFloat((int) (size & 4294967295L)) - fMo2191toPx0680j_4, fMo2191toPx0680j_42, fMo2191toPx0680j_42);
            } else if (i == 3) {
                RoundRect = RoundRectKt.RoundRect(fMo2191toPx0680j_4, 0.0f, Float.intBitsToFloat((int) (size >> 32)), Float.intBitsToFloat((int) (size & 4294967295L)), fMo2191toPx0680j_42, fMo2191toPx0680j_42);
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                RoundRect = RoundRectKt.RoundRect(0.0f, fMo2191toPx0680j_4, Float.intBitsToFloat((int) (size >> 32)), Float.intBitsToFloat((int) (size & 4294967295L)), fMo2191toPx0680j_42, fMo2191toPx0680j_42);
                fMo2191toPx0680j_4 = fMo2191toPx0680j_4;
            }
            if (RoundRect == null) {
                RoundRect = RoundRectKt.RoundRect(0.0f, 0.0f, Float.intBitsToFloat((int) (size >> 32)), Float.intBitsToFloat((int) (size & 4294967295L)), fMo2191toPx0680j_42, fMo2191toPx0680j_42);
            }
        }
        Path.addRoundRect$default(Path, RoundRect, null, 2, null);
        Point point2 = this.target;
        if (point2 != null && (caretM12947caretLocationx_KDEd0 = m12947caretLocationx_KDEd0(point2, size, fMo2191toPx0680j_4, fMo2191toPx0680j_42)) != null) {
            Path.moveTo(caretM12947caretLocationx_KDEd0.getLeft().x, caretM12947caretLocationx_KDEd0.getLeft().y);
            Path.lineTo(caretM12947caretLocationx_KDEd0.getRight().x, caretM12947caretLocationx_KDEd0.getRight().y);
            Path.lineTo(caretM12947caretLocationx_KDEd0.getTip().x, caretM12947caretLocationx_KDEd0.getTip().y);
            Path.close();
        }
        return new Outline.Generic(Path);
    }

    /* JADX INFO: renamed from: caretLocation-x_KDEd0, reason: not valid java name */
    private final Caret m12947caretLocationx_KDEd0(Point targetPoint, long bubbleSize, float caretSizePx, float cornerRadiusPx) {
        int i = (int) (bubbleSize >> 32);
        float f = 0.5f * caretSizePx;
        float f2 = cornerRadiusPx + f;
        int i2 = (int) (4294967295L & bubbleSize);
        PointF pointF = new PointF(Math.min(Float.max(((Float.intBitsToFloat(i) / 2.0f) + targetPoint.x) - this.center.x, f2), (Float.intBitsToFloat(i) - cornerRadiusPx) - f), Math.min(Float.max(((Float.intBitsToFloat(i2) / 2.0f) + targetPoint.y) - this.center.y, f2), (Float.intBitsToFloat(i2) - cornerRadiusPx) - f));
        int i3 = WhenMappings.$EnumSwitchMapping$0[INSTANCE.m12948caretDirection12SF9DM(this.center, bubbleSize, targetPoint).ordinal()];
        if (i3 == 1) {
            float f3 = caretSizePx / 2.0f;
            return new Caret(new PointF(Float.intBitsToFloat(i) - caretSizePx, pointF.y - f3), new PointF(Float.intBitsToFloat(i) - caretSizePx, pointF.y + f3), new PointF(Float.intBitsToFloat(i), pointF.y));
        }
        if (i3 == 2) {
            float f4 = caretSizePx / 2.0f;
            return new Caret(new PointF(pointF.x - f4, Float.intBitsToFloat(i2) - caretSizePx), new PointF(pointF.x + f4, Float.intBitsToFloat(i2) - caretSizePx), new PointF(pointF.x, Float.intBitsToFloat(i2)));
        }
        if (i3 == 3) {
            float f5 = caretSizePx / 2.0f;
            return new Caret(new PointF(caretSizePx, pointF.y - f5), new PointF(caretSizePx, pointF.y + f5), new PointF(0.0f, pointF.y));
        }
        if (i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        float f6 = caretSizePx / 2.0f;
        return new Caret(new PointF(pointF.x - f6, caretSizePx), new PointF(pointF.x + f6, caretSizePx), new PointF(pointF.x, 0.0f));
    }

    /* JADX INFO: compiled from: SpeechBubbleShape.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/ui/compose/SpeechBubbleShape$Companion;", "", "<init>", "()V", "caretDirection", "Lcom/myscript/nebo/discoverability/ui/compose/SpeechBubbleShape$Direction;", "bubbleCenter", "Landroid/graphics/Point;", "bubbleSize", "Landroidx/compose/ui/geometry/Size;", "targetPoint", "caretDirection-12SF9DM", "(Landroid/graphics/Point;JLandroid/graphics/Point;)Lcom/myscript/nebo/discoverability/ui/compose/SpeechBubbleShape$Direction;", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: caretDirection-12SF9DM, reason: not valid java name */
        public final Direction m12948caretDirection12SF9DM(Point bubbleCenter, long bubbleSize, Point targetPoint) {
            Intrinsics.checkNotNullParameter(bubbleCenter, "bubbleCenter");
            Intrinsics.checkNotNullParameter(targetPoint, "targetPoint");
            PointF pointF = new PointF(targetPoint.x - bubbleCenter.x, bubbleCenter.y - targetPoint.y);
            PointF pointF2 = new PointF(Float.intBitsToFloat((int) (bubbleSize >> 32)) / 2.0f, Float.intBitsToFloat((int) (bubbleSize & 4294967295L)) / 2.0f);
            PointF pointF3 = new PointF(0.0f, 1.0f);
            float fAtan2 = (((float) Math.atan2(pointF3.y, pointF3.x)) - ((float) Math.atan2(pointF2.y, pointF2.x))) * 2.0f;
            float f = 3.1415927f - fAtan2;
            float fAtan22 = ((float) Math.atan2(pointF.y, pointF.x)) - ((float) Math.atan2(pointF2.y, pointF2.x));
            if (fAtan22 < 0.0f) {
                fAtan22 += 6.2831855f;
            }
            if (0.0f <= fAtan22 && fAtan22 <= fAtan2) {
                return Direction.TOP;
            }
            if (fAtan2 <= fAtan22 && fAtan22 <= fAtan2 + f) {
                return Direction.LEFT;
            }
            float f2 = f + fAtan2;
            if (fAtan22 <= fAtan2 + f2 && f2 <= fAtan22) {
                return Direction.BOTTOM;
            }
            return Direction.RIGHT;
        }
    }

    public /* synthetic */ SpeechBubbleShape(float f, float f2, Point point, Point point2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C1486Dp.m11017constructorimpl(15) : f, (i & 2) != 0 ? C1486Dp.m11017constructorimpl(15) : f2, point, point2, null);
    }
}
