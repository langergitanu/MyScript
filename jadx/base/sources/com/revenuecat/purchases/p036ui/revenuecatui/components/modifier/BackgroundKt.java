package com.revenuecat.purchases.p036ui.revenuecatui.components.modifier;

import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.draw.DrawModifierKt;
import androidx.compose.p004ui.geometry.InlineClassHelperKt;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.RectangleShapeKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.layout.ScaleFactorKt;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntSizeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: Background.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0001\u001a$\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000e"}, m1599d2 = {"background", "Landroidx/compose/ui/Modifier;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "drawImageBehind", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class BackgroundKt {
    public static /* synthetic */ Modifier background$default(Modifier modifier, ColorStyle colorStyle, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return background(modifier, colorStyle, shape);
    }

    public static final /* synthetic */ Modifier background(Modifier modifier, ColorStyle color, Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(shape, "shape");
        if (color instanceof ColorStyle.Solid) {
            return androidx.compose.foundation.BackgroundKt.m2015backgroundbw27NRU(modifier, ((ColorStyle.Solid) color).m13951unboximpl(), shape);
        }
        if (color instanceof ColorStyle.Gradient) {
            return androidx.compose.foundation.BackgroundKt.background(modifier, ((ColorStyle.Gradient) color).m13943unboximpl(), shape, 1.0f);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Modifier background$default(Modifier modifier, BackgroundStyle backgroundStyle, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return background(modifier, backgroundStyle, shape);
    }

    public static final /* synthetic */ Modifier background(Modifier modifier, BackgroundStyle background, Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(shape, "shape");
        if (background instanceof BackgroundStyle.Color) {
            return background(modifier, ((BackgroundStyle.Color) background).m13921unboximpl(), shape);
        }
        if (background instanceof BackgroundStyle.Image) {
            BackgroundStyle.Image image = (BackgroundStyle.Image) background;
            return drawImageBehind(ClipKt.clip(modifier, shape), image.getPainter(), image.getContentScale(), Alignment.INSTANCE.getTopCenter());
        }
        if (background instanceof BackgroundStyle.Video) {
            return modifier;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Modifier drawImageBehind(Modifier modifier, final Painter painter, final ContentScale contentScale, final Alignment alignment) {
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BackgroundKt.drawImageBehind.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope drawWithContent) {
                float fM7972getWidthimpl;
                float fM7969getHeightimpl;
                long jM7981getZeroNHjbRc;
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                long jMo8849getIntrinsicSizeNHjbRc = painter.getIntrinsicSize();
                if (jMo8849getIntrinsicSizeNHjbRc != InlineClassHelperKt.UnspecifiedPackedFloats && Math.abs(Size.m7972getWidthimpl(jMo8849getIntrinsicSizeNHjbRc)) <= Float.MAX_VALUE) {
                    fM7972getWidthimpl = Size.m7972getWidthimpl(jMo8849getIntrinsicSizeNHjbRc);
                } else {
                    fM7972getWidthimpl = Size.m7972getWidthimpl(drawWithContent.mo8729getSizeNHjbRc());
                }
                if (jMo8849getIntrinsicSizeNHjbRc != InlineClassHelperKt.UnspecifiedPackedFloats && Math.abs(Size.m7969getHeightimpl(jMo8849getIntrinsicSizeNHjbRc)) <= Float.MAX_VALUE) {
                    fM7969getHeightimpl = Size.m7969getHeightimpl(jMo8849getIntrinsicSizeNHjbRc);
                } else {
                    fM7969getHeightimpl = Size.m7969getHeightimpl(drawWithContent.mo8729getSizeNHjbRc());
                }
                long jSize = SizeKt.Size(fM7972getWidthimpl, fM7969getHeightimpl);
                if (Size.m7972getWidthimpl(drawWithContent.mo8729getSizeNHjbRc()) != 0.0f && Size.m7969getHeightimpl(drawWithContent.mo8729getSizeNHjbRc()) != 0.0f) {
                    jM7981getZeroNHjbRc = ScaleFactorKt.m9756timesUQTWf7w(jSize, contentScale.mo9618computeScaleFactorH7hwNQA(jSize, drawWithContent.mo8729getSizeNHjbRc()));
                } else {
                    jM7981getZeroNHjbRc = Size.INSTANCE.m7981getZeroNHjbRc();
                }
                long j = jM7981getZeroNHjbRc;
                long jMo7571alignKFBX0sM = alignment.mo7571alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m7972getWidthimpl(j)), MathKt.roundToInt(Size.m7969getHeightimpl(j))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m7972getWidthimpl(drawWithContent.mo8729getSizeNHjbRc())), MathKt.roundToInt(Size.m7969getHeightimpl(drawWithContent.mo8729getSizeNHjbRc()))), drawWithContent.getLayoutDirection());
                ContentDrawScope contentDrawScope = drawWithContent;
                float fM11145getXimpl = IntOffset.m11145getXimpl(jMo7571alignKFBX0sM);
                float fM11146getYimpl = IntOffset.m11146getYimpl(jMo7571alignKFBX0sM);
                Painter painter2 = painter;
                contentDrawScope.getDrawContext().getTransform().translate(fM11145getXimpl, fM11146getYimpl);
                try {
                    Painter.m8854drawx_KDEd0$default(painter2, contentDrawScope, j, 0.0f, null, 6, null);
                    contentDrawScope.getDrawContext().getTransform().translate(-fM11145getXimpl, -fM11146getYimpl);
                    drawWithContent.drawContent();
                } catch (Throwable th) {
                    contentDrawScope.getDrawContext().getTransform().translate(-fM11145getXimpl, -fM11146getYimpl);
                    throw th;
                }
            }
        });
    }
}
