package com.revenuecat.purchases.p036ui.revenuecatui.components.stack;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VerticalStack.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B6\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJc\u0010\u001c\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2F\u0010\u001f\u001aB\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\t0 ¢\u0006\u0002\b\n¢\u0006\u0002\b\u0010H\u0016¢\u0006\u0002\u0010&R2\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\b\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/VerticalStackScopeImpl;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/VerticalStackScope;", "distribution", "Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;", "spacing", "Landroidx/compose/ui/unit/Dp;", "fillSpaceSpacer", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/Composable;", "height", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "(Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;FLkotlin/jvm/functions/Function3;Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "columnContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "getColumnContent", "()Lkotlin/jvm/functions/Function3;", "setColumnContent", "(Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "hasAnyItemsWithFillHeight", "", "shouldApplyFillSpacers", "getShouldApplyFillSpacers", "()Z", "F", FirebaseAnalytics.Param.ITEMS, "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "itemContent", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "item", "(Ljava/util/List;Lkotlin/jvm/functions/Function5;)V", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
final class VerticalStackScopeImpl implements VerticalStackScope {
    private Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> columnContent;
    private final FlexDistribution distribution;
    private final Function3<Float, Composer, Integer, Unit> fillSpaceSpacer;
    private boolean hasAnyItemsWithFillHeight;
    private final SizeConstraint height;
    private final float spacing;

    public /* synthetic */ VerticalStackScopeImpl(FlexDistribution flexDistribution, float f, Function3 function3, SizeConstraint sizeConstraint, DefaultConstructorMarker defaultConstructorMarker) {
        this(flexDistribution, f, function3, sizeConstraint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private VerticalStackScopeImpl(FlexDistribution distribution, float f, Function3<? super Float, ? super Composer, ? super Integer, Unit> fillSpaceSpacer, SizeConstraint height) {
        Intrinsics.checkNotNullParameter(distribution, "distribution");
        Intrinsics.checkNotNullParameter(fillSpaceSpacer, "fillSpaceSpacer");
        Intrinsics.checkNotNullParameter(height, "height");
        this.distribution = distribution;
        this.spacing = f;
        this.fillSpaceSpacer = fillSpaceSpacer;
        this.height = height;
        this.columnContent = ComposableSingletons$VerticalStackKt.INSTANCE.m13977getLambda1$revenuecatui_defaultsRelease();
    }

    public final boolean getShouldApplyFillSpacers() {
        return ((this.height instanceof SizeConstraint.Fit) || this.hasAnyItemsWithFillHeight) ? false : true;
    }

    public final Function3<ColumnScope, Composer, Integer, Unit> getColumnContent() {
        return this.columnContent;
    }

    public final void setColumnContent(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.columnContent = function3;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.components.stack.VerticalStackScope
    public void items(final List<? extends ComponentStyle> items, final Function5<? super ColumnScope, ? super Integer, ? super ComponentStyle, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        List<? extends ComponentStyle> list = items;
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(((ComponentStyle) it.next()).getSize().getHeight(), SizeConstraint.Fill.INSTANCE)) {
                    z = true;
                    break;
                }
            }
        }
        this.hasAnyItemsWithFillHeight = z;
        this.columnContent = ComposableLambdaKt.composableLambdaInstance(552023703, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStackScopeImpl.items.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                invoke(columnScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope columnScope, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(columnScope, "$this$null");
                ComposerKt.sourceInformation(composer, "C*98@3800L24:VerticalStack.kt#280jdz");
                int i2 = (i & 6) == 0 ? i | (composer.changed(columnScope) ? 4 : 2) : i;
                if ((i2 & 19) != 18 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(552023703, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStackScopeImpl.items.<anonymous> (VerticalStack.kt:96)");
                    }
                    List<ComponentStyle> list2 = items;
                    Function5<ColumnScope, Integer, ComponentStyle, Composer, Integer, Unit> function5 = itemContent;
                    VerticalStackScopeImpl verticalStackScopeImpl = this;
                    int i3 = 0;
                    for (Object obj : list2) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ComponentStyle componentStyle = (ComponentStyle) obj;
                        boolean z2 = i3 == list2.size() - 1;
                        function5.invoke(columnScope, Integer.valueOf(i3), componentStyle, composer, Integer.valueOf(i2 & 14));
                        composer.startReplaceGroup(-1867284315);
                        ComposerKt.sourceInformation(composer, "101@3915L51,103@4041L78");
                        if (StackComponentViewKt.getUsesAllAvailableSpace(verticalStackScopeImpl.distribution) && !z2) {
                            SpacerKt.Spacer(SizeKt.m2912heightInVpY3zN4$default(Modifier.INSTANCE, verticalStackScopeImpl.spacing, 0.0f, 2, null), composer, 0);
                            if (verticalStackScopeImpl.getShouldApplyFillSpacers()) {
                                verticalStackScopeImpl.fillSpaceSpacer.invoke(Float.valueOf(verticalStackScopeImpl.distribution == FlexDistribution.SPACE_AROUND ? 2.0f : 1.0f), composer, 0);
                            }
                        }
                        composer.endReplaceGroup();
                        i3 = i4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        });
    }
}
