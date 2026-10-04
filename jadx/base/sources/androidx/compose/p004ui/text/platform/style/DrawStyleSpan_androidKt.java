package androidx.compose.p004ui.text.platform.style;

import android.graphics.Paint;
import androidx.compose.p004ui.graphics.StrokeCap;
import androidx.compose.p004ui.graphics.StrokeJoin;
import kotlin.Metadata;

/* JADX INFO: compiled from: DrawStyleSpan.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"toAndroidJoin", "Landroid/graphics/Paint$Join;", "Landroidx/compose/ui/graphics/StrokeJoin;", "toAndroidJoin-Ww9F2mQ", "(I)Landroid/graphics/Paint$Join;", "toAndroidCap", "Landroid/graphics/Paint$Cap;", "Landroidx/compose/ui/graphics/StrokeCap;", "toAndroidCap-BeK7IIE", "(I)Landroid/graphics/Paint$Cap;", "ui-text"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DrawStyleSpan_androidKt {
    /* JADX INFO: renamed from: toAndroidJoin-Ww9F2mQ, reason: not valid java name */
    public static final Paint.Join m10754toAndroidJoinWw9F2mQ(int i) {
        return StrokeJoin.m8530equalsimpl0(i, StrokeJoin.INSTANCE.m8535getMiterLxFBmk8()) ? Paint.Join.MITER : StrokeJoin.m8530equalsimpl0(i, StrokeJoin.INSTANCE.m8536getRoundLxFBmk8()) ? Paint.Join.ROUND : StrokeJoin.m8530equalsimpl0(i, StrokeJoin.INSTANCE.m8534getBevelLxFBmk8()) ? Paint.Join.BEVEL : Paint.Join.MITER;
    }

    /* JADX INFO: renamed from: toAndroidCap-BeK7IIE, reason: not valid java name */
    public static final Paint.Cap m10753toAndroidCapBeK7IIE(int i) {
        return StrokeCap.m8520equalsimpl0(i, StrokeCap.INSTANCE.m8524getButtKaPHkGw()) ? Paint.Cap.BUTT : StrokeCap.m8520equalsimpl0(i, StrokeCap.INSTANCE.m8525getRoundKaPHkGw()) ? Paint.Cap.ROUND : StrokeCap.m8520equalsimpl0(i, StrokeCap.INSTANCE.m8526getSquareKaPHkGw()) ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
    }
}
