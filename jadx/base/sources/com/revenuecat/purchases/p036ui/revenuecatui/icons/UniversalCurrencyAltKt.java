package com.revenuecat.purchases.p036ui.revenuecatui.icons;

import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.PathFillType;
import androidx.compose.p004ui.graphics.SolidColor;
import androidx.compose.p004ui.graphics.StrokeCap;
import androidx.compose.p004ui.graphics.StrokeJoin;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.graphics.vector.PathBuilder;
import androidx.compose.p004ui.unit.C1486Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UniversalCurrencyAlt.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m1599d2 = {"UniversalCurrencyAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getUniversalCurrencyAlt", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_Universal_currency_alt", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class UniversalCurrencyAltKt {
    private static ImageVector _Universal_currency_alt;

    public static final ImageVector getUniversalCurrencyAlt() {
        ImageVector imageVector = _Universal_currency_alt;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        float f = 24;
        ImageVector.Builder builder = new ImageVector.Builder("UniversalCurrencyAlt", C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(f), 960.0f, 960.0f, 0L, 0, false, 224, null);
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m8174getBlack0d7_KjU(), null);
        int iM8524getButtKaPHkGw = StrokeCap.INSTANCE.m8524getButtKaPHkGw();
        int iM8535getMiterLxFBmk8 = StrokeJoin.INSTANCE.m8535getMiterLxFBmk8();
        int iM8447getNonZeroRgk1Os = PathFillType.INSTANCE.m8447getNonZeroRgk1Os();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(600.0f, 640.0f);
        pathBuilder.horizontalLineToRelative(160.0f);
        pathBuilder.verticalLineToRelative(-160.0f);
        pathBuilder.horizontalLineToRelative(-60.0f);
        pathBuilder.verticalLineToRelative(100.0f);
        pathBuilder.horizontalLineTo(600.0f);
        pathBuilder.close();
        pathBuilder.moveToRelative(-120.0f, -40.0f);
        pathBuilder.quadToRelative(50.0f, 0.0f, 85.0f, -35.0f);
        pathBuilder.reflectiveQuadToRelative(35.0f, -85.0f);
        pathBuilder.reflectiveQuadToRelative(-35.0f, -85.0f);
        pathBuilder.reflectiveQuadToRelative(-85.0f, -35.0f);
        pathBuilder.reflectiveQuadToRelative(-85.0f, 35.0f);
        pathBuilder.reflectiveQuadToRelative(-35.0f, 85.0f);
        pathBuilder.reflectiveQuadToRelative(35.0f, 85.0f);
        pathBuilder.reflectiveQuadToRelative(85.0f, 35.0f);
        pathBuilder.moveTo(200.0f, 480.0f);
        pathBuilder.horizontalLineToRelative(60.0f);
        pathBuilder.verticalLineToRelative(-100.0f);
        pathBuilder.horizontalLineToRelative(100.0f);
        pathBuilder.verticalLineToRelative(-60.0f);
        pathBuilder.horizontalLineTo(200.0f);
        pathBuilder.close();
        pathBuilder.moveTo(80.0f, 760.0f);
        pathBuilder.verticalLineToRelative(-560.0f);
        pathBuilder.horizontalLineToRelative(800.0f);
        pathBuilder.verticalLineToRelative(560.0f);
        pathBuilder.close();
        pathBuilder.moveToRelative(80.0f, -80.0f);
        pathBuilder.horizontalLineToRelative(640.0f);
        pathBuilder.verticalLineToRelative(-400.0f);
        pathBuilder.horizontalLineTo(160.0f);
        pathBuilder.close();
        pathBuilder.moveToRelative(0.0f, 0.0f);
        pathBuilder.verticalLineToRelative(-400.0f);
        pathBuilder.close();
        ImageVector.Builder.m8886addPathoIyEayM$default(builder, pathBuilder.getNodes(), iM8447getNonZeroRgk1Os, "", solidColor, 1.0f, null, 1.0f, 1.0f, iM8524getButtKaPHkGw, iM8535getMiterLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        ImageVector imageVectorBuild = builder.build();
        _Universal_currency_alt = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
