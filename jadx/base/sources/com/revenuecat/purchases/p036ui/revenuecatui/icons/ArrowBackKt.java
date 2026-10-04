package com.revenuecat.purchases.p036ui.revenuecatui.icons;

import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.SolidColor;
import androidx.compose.p004ui.graphics.StrokeCap;
import androidx.compose.p004ui.graphics.StrokeJoin;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.graphics.vector.PathBuilder;
import androidx.compose.p004ui.graphics.vector.VectorKt;
import androidx.compose.p004ui.unit.C1486Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ArrowBack.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m1599d2 = {"ArrowBack", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getArrowBack", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_arrowBack", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ArrowBackKt {
    private static ImageVector _arrowBack;

    public static final ImageVector getArrowBack() {
        ImageVector imageVector = _arrowBack;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("AutoMirrored.Filled.ArrowBack", C1486Dp.m11017constructorimpl(24.0f), C1486Dp.m11017constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, true, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m8174getBlack0d7_KjU(), null);
        int iM8524getButtKaPHkGw = StrokeCap.INSTANCE.m8524getButtKaPHkGw();
        int iM8534getBevelLxFBmk8 = StrokeJoin.INSTANCE.m8534getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(20.0f, 11.0f);
        pathBuilder.horizontalLineTo(7.83f);
        pathBuilder.lineToRelative(5.59f, -5.59f);
        pathBuilder.lineTo(12.0f, 4.0f);
        pathBuilder.lineToRelative(-8.0f, 8.0f);
        pathBuilder.lineToRelative(8.0f, 8.0f);
        pathBuilder.lineToRelative(1.41f, -1.41f);
        pathBuilder.lineTo(7.83f, 13.0f);
        pathBuilder.horizontalLineTo(20.0f);
        pathBuilder.verticalLineToRelative(-2.0f);
        pathBuilder.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m8886addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, iM8524getButtKaPHkGw, iM8534getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _arrowBack = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
