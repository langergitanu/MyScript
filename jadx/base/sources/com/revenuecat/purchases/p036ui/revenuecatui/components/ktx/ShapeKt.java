package com.revenuecat.purchases.p036ui.revenuecatui.components.ktx;

import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.RectangleShapeKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.LayoutDirection;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Shape.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0006H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"SCALE_Y_OFFSET_CONCAVE_CONVEX", "", "convertCornerRadiusesToShape", "Landroidx/compose/ui/graphics/Shape;", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;", "toShape", "Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class ShapeKt {
    private static final float SCALE_Y_OFFSET_CONCAVE_CONVEX = 0.1f;

    public static final /* synthetic */ Shape toShape(com.revenuecat.purchases.paywalls.components.properties.Shape shape) {
        Intrinsics.checkNotNullParameter(shape, "<this>");
        return convertCornerRadiusesToShape(shape.getCornerRadiuses());
    }

    public static final /* synthetic */ Shape toShape(MaskShape maskShape) {
        Shape shapeConvertCornerRadiusesToShape;
        Intrinsics.checkNotNullParameter(maskShape, "<this>");
        if (maskShape instanceof MaskShape.Rectangle) {
            CornerRadiuses corners = ((MaskShape.Rectangle) maskShape).getCorners();
            return (corners == null || (shapeConvertCornerRadiusesToShape = convertCornerRadiusesToShape(corners)) == null) ? RectangleShapeKt.getRectangleShape() : shapeConvertCornerRadiusesToShape;
        }
        if (maskShape instanceof MaskShape.Concave) {
            return new GenericShape(new Function3<Path, Size, LayoutDirection, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt.toShape.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Path path, Size size, LayoutDirection layoutDirection) {
                    m13907invoke12SF9DM(path, size.m7977unboximpl(), layoutDirection);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-12SF9DM, reason: not valid java name */
                public final void m13907invoke12SF9DM(Path $receiver, long j, LayoutDirection layoutDirection) {
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 1>");
                    float fM7969getHeightimpl = Size.m7969getHeightimpl(j) * 0.1f * 2.0f;
                    $receiver.moveTo(0.0f, 0.0f);
                    $receiver.lineTo(Size.m7972getWidthimpl(j), 0.0f);
                    $receiver.lineTo(Size.m7972getWidthimpl(j), Size.m7969getHeightimpl(j));
                    $receiver.quadraticTo(Size.m7972getWidthimpl(j) / 2, Size.m7969getHeightimpl(j) - fM7969getHeightimpl, 0.0f, Size.m7969getHeightimpl(j));
                    $receiver.lineTo(0.0f, 0.0f);
                }
            });
        }
        if (maskShape instanceof MaskShape.Convex) {
            return new GenericShape(new Function3<Path, Size, LayoutDirection, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt.toShape.2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Path path, Size size, LayoutDirection layoutDirection) {
                    m13908invoke12SF9DM(path, size.m7977unboximpl(), layoutDirection);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-12SF9DM, reason: not valid java name */
                public final void m13908invoke12SF9DM(Path $receiver, long j, LayoutDirection layoutDirection) {
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 1>");
                    float fM7969getHeightimpl = Size.m7969getHeightimpl(j) * 0.1f;
                    $receiver.moveTo(0.0f, 0.0f);
                    $receiver.lineTo(Size.m7972getWidthimpl(j), 0.0f);
                    $receiver.lineTo(Size.m7972getWidthimpl(j), Size.m7969getHeightimpl(j) - fM7969getHeightimpl);
                    $receiver.quadraticTo(Size.m7972getWidthimpl(j) / 2, Size.m7969getHeightimpl(j) + fM7969getHeightimpl, 0.0f, Size.m7969getHeightimpl(j) - fM7969getHeightimpl);
                    $receiver.lineTo(0.0f, 0.0f);
                }
            });
        }
        if (maskShape instanceof MaskShape.Circle) {
            return RoundedCornerShapeKt.getCircleShape();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Shape convertCornerRadiusesToShape(CornerRadiuses cornerRadiuses) {
        if (cornerRadiuses instanceof CornerRadiuses.Percentage) {
            CornerRadiuses.Percentage percentage = (CornerRadiuses.Percentage) cornerRadiuses;
            return RoundedCornerShapeKt.RoundedCornerShape(percentage.getTopLeading(), percentage.getTopTrailing(), percentage.getBottomTrailing(), percentage.getBottomLeading());
        }
        if (!(cornerRadiuses instanceof CornerRadiuses.C7411Dp)) {
            throw new NoWhenBranchMatchedException();
        }
        CornerRadiuses.C7411Dp c7411Dp = (CornerRadiuses.C7411Dp) cornerRadiuses;
        return RoundedCornerShapeKt.m3236RoundedCornerShapea9UjIt4(C1486Dp.m11017constructorimpl((float) c7411Dp.getTopLeading()), C1486Dp.m11017constructorimpl((float) c7411Dp.getTopTrailing()), C1486Dp.m11017constructorimpl((float) c7411Dp.getBottomTrailing()), C1486Dp.m11017constructorimpl((float) c7411Dp.getBottomLeading()));
    }
}
