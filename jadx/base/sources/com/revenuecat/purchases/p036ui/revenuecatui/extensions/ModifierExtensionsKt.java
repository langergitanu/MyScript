package com.revenuecat.purchases.p036ui.revenuecatui.extensions;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.LayoutModifierKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.runtime.MutableState;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModifierExtensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aV\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00032#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0000¢\u0006\u0002\u0010\t\u001a@\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\bH\u0000¢\u0006\u0002\u0010\u000b\u001a-\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\bH\u0000\u001a\"\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0000¨\u0006\u0014"}, m1599d2 = {"applyIfNotNull", "Landroidx/compose/ui/Modifier;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "value", "value2", "modifier", "Lkotlin/Function3;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "Lkotlin/Function2;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "conditional", "condition", "", "Lkotlin/Function1;", "trackMainAxisUnbounded", "isHorizontal", "unboundedState", "Landroidx/compose/runtime/MutableState;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ModifierExtensionsKt {
    public static final Modifier trackMainAxisUnbounded(Modifier modifier, final boolean z, final MutableState<Boolean> unboundedState) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(unboundedState, "unboundedState");
        return LayoutModifierKt.layout(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt.trackMainAxisUnbounded.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m14268invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m14268invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                MutableState<Boolean> mutableState = unboundedState;
                boolean z2 = true;
                if (!z ? Constraints.m10965getHasBoundedHeightimpl(j) || Constraints.m10971getMinHeightimpl(j) != 0 : Constraints.m10966getHasBoundedWidthimpl(j) || Constraints.m10972getMinWidthimpl(j) != 0) {
                    z2 = false;
                }
                mutableState.setValue(Boolean.valueOf(z2));
                final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(j);
                return MeasureScope.layout$default(layout, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt.trackMainAxisUnbounded.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout2) {
                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                        Placeable.PlacementScope.place$default(layout2, placeableMo9625measureBRTryo0, 0, 0, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        });
    }

    public static final Modifier conditional(Modifier modifier, boolean z, Function1<? super Modifier, ? extends Modifier> modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return z ? modifier.then(modifier2.invoke(Modifier.INSTANCE)) : modifier;
    }

    public static final <T> Modifier applyIfNotNull(Modifier modifier, T t, Function2<? super Modifier, ? super T, ? extends Modifier> modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return t != null ? modifier.then(modifier2.invoke(Modifier.INSTANCE, t)) : modifier;
    }

    public static final <T, V> Modifier applyIfNotNull(Modifier modifier, T t, V v, Function3<? super Modifier, ? super T, ? super V, ? extends Modifier> modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return (t == null || v == null) ? modifier : modifier.then(modifier2.invoke(Modifier.INSTANCE, t, v));
    }
}
