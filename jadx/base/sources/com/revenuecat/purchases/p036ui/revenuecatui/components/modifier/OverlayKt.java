package com.revenuecat.purchases.p036ui.revenuecatui.components.modifier;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.CacheDrawScope;
import androidx.compose.p004ui.draw.DrawModifierKt;
import androidx.compose.p004ui.draw.DrawResult;
import androidx.compose.p004ui.graphics.Outline;
import androidx.compose.p004ui.graphics.OutlineKt;
import androidx.compose.p004ui.graphics.RectangleShapeKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Overlay.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¨\u0006\u0007"}, m1599d2 = {"overlay", "Landroidx/compose/ui/Modifier;", "color", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "shape", "Landroidx/compose/ui/graphics/Shape;", "underlay", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class OverlayKt {
    public static /* synthetic */ Modifier overlay$default(Modifier modifier, ColorStyle colorStyle, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return overlay(modifier, colorStyle, shape);
    }

    public static final /* synthetic */ Modifier overlay(Modifier modifier, final ColorStyle color, final Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return DrawModifierKt.drawWithCache(modifier, new Function1<CacheDrawScope, DrawResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.OverlayKt.overlay.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawResult invoke(CacheDrawScope drawWithCache) {
                Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
                final Outline outlineMo2085createOutlinePq9zytI = shape.mo2085createOutlinePq9zytI(drawWithCache.m7683getSizeNHjbRc(), drawWithCache.getLayoutDirection(), drawWithCache);
                final ColorStyle colorStyle = color;
                return drawWithCache.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.OverlayKt.overlay.1.1
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
                    public final void invoke2(ContentDrawScope onDrawWithContent) {
                        Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                        onDrawWithContent.drawContent();
                        ColorStyle colorStyle2 = colorStyle;
                        if (colorStyle2 instanceof ColorStyle.Solid) {
                            OutlineKt.m8423drawOutlinewDX37Ww$default(onDrawWithContent, outlineMo2085createOutlinePq9zytI, ((ColorStyle.Solid) colorStyle2).m13951unboximpl(), 0.0f, null, null, 0, 60, null);
                        } else if (colorStyle2 instanceof ColorStyle.Gradient) {
                            OutlineKt.m8421drawOutlinehn5TExg$default(onDrawWithContent, outlineMo2085createOutlinePq9zytI, ((ColorStyle.Gradient) colorStyle2).m13943unboximpl(), 0.0f, null, null, 0, 60, null);
                        }
                    }
                });
            }
        });
    }

    public static /* synthetic */ Modifier underlay$default(Modifier modifier, ColorStyle colorStyle, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return underlay(modifier, colorStyle, shape);
    }

    public static final /* synthetic */ Modifier underlay(Modifier modifier, final ColorStyle color, final Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return DrawModifierKt.drawBehind(modifier, new Function1<DrawScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.OverlayKt.underlay.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawBehind) {
                Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                Outline outlineMo2085createOutlinePq9zytI = shape.mo2085createOutlinePq9zytI(drawBehind.mo8729getSizeNHjbRc(), drawBehind.getLayoutDirection(), drawBehind);
                ColorStyle colorStyle = color;
                if (colorStyle instanceof ColorStyle.Solid) {
                    OutlineKt.m8423drawOutlinewDX37Ww$default(drawBehind, outlineMo2085createOutlinePq9zytI, ((ColorStyle.Solid) colorStyle).m13951unboximpl(), 0.0f, null, null, 0, 60, null);
                } else if (colorStyle instanceof ColorStyle.Gradient) {
                    OutlineKt.m8421drawOutlinehn5TExg$default(drawBehind, outlineMo2085createOutlinePq9zytI, ((ColorStyle.Gradient) colorStyle).m13943unboximpl(), 0.0f, null, null, 0, 60, null);
                }
            }
        });
    }
}
