package com.revenuecat.purchases.p036ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.p036ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.p036ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenViewState;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrency;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirtualCurrencyBalancesScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ComposableSingletons$VirtualCurrencyBalancesScreenKt {
    public static final ComposableSingletons$VirtualCurrencyBalancesScreenKt INSTANCE = new ComposableSingletons$VirtualCurrencyBalancesScreenKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f2940lambda1 = ComposableLambdaKt.composableLambdaInstance(-1342872368, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation(composer, "C77@3475L27:VirtualCurrencyBalancesScreen.kt#870w7w");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1342872368, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt.lambda-1.<anonymous> (VirtualCurrencyBalancesScreen.kt:77)");
            }
            CustomerCenterLoadingViewKt.CustomerCenterLoadingView(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f2941lambda2 = ComposableLambdaKt.composableLambdaInstance(1446237222, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C191@8051L297:VirtualCurrencyBalancesScreen.kt#870w7w");
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1446237222, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt.lambda-2.<anonymous> (VirtualCurrencyBalancesScreen.kt:191)");
                }
                VirtualCurrencyBalancesScreenKt.InternalVirtualCurrencyBalancesScreen(CustomerCenterConfigTestData.INSTANCE.getStandardAppearance(), CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), new VirtualCurrencyBalancesScreenViewState.Loaded(CollectionsKt.emptyList()), null, composer, 0, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f2942lambda3 = ComposableLambdaKt.composableLambdaInstance(-1872635862, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C206@8554L412:VirtualCurrencyBalancesScreen.kt#870w7w");
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1872635862, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt.lambda-3.<anonymous> (VirtualCurrencyBalancesScreen.kt:206)");
                }
                VirtualCurrencyBalancesScreenKt.InternalVirtualCurrencyBalancesScreen(CustomerCenterConfigTestData.INSTANCE.getStandardAppearance(), CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), new VirtualCurrencyBalancesScreenViewState.Loaded(CollectionsKt.sortedWith(CustomerCenterConfigTestData.INSTANCE.getFourVirtualCurrencies().getAll().values(), new Comparator() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-3$1$invoke$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((VirtualCurrency) t2).getBalance()), Integer.valueOf(((VirtualCurrency) t).getBalance()));
                    }
                })), null, composer, 0, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f2943lambda4 = ComposableLambdaKt.composableLambdaInstance(1987147076, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C223@9171L412:VirtualCurrencyBalancesScreen.kt#870w7w");
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1987147076, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt.lambda-4.<anonymous> (VirtualCurrencyBalancesScreen.kt:223)");
                }
                VirtualCurrencyBalancesScreenKt.InternalVirtualCurrencyBalancesScreen(CustomerCenterConfigTestData.INSTANCE.getStandardAppearance(), CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), new VirtualCurrencyBalancesScreenViewState.Loaded(CollectionsKt.sortedWith(CustomerCenterConfigTestData.INSTANCE.getFiveVirtualCurrencies().getAll().values(), new Comparator() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-4$1$invoke$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((VirtualCurrency) t2).getBalance()), Integer.valueOf(((VirtualCurrency) t).getBalance()));
                    }
                })), null, composer, 0, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f2944lambda5 = ComposableLambdaKt.composableLambdaInstance(-1907101527, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C240@9774L285:VirtualCurrencyBalancesScreen.kt#870w7w");
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1907101527, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt.lambda-5.<anonymous> (VirtualCurrencyBalancesScreen.kt:240)");
                }
                VirtualCurrencyBalancesScreenKt.InternalVirtualCurrencyBalancesScreen(CustomerCenterConfigTestData.INSTANCE.getStandardAppearance(), CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), VirtualCurrencyBalancesScreenViewState.Loading.INSTANCE, null, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f2945lambda6 = ComposableLambdaKt.composableLambdaInstance(669156317, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C255@10246L476:VirtualCurrencyBalancesScreen.kt#870w7w");
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(669156317, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt.lambda-6.<anonymous> (VirtualCurrencyBalancesScreen.kt:255)");
                }
                VirtualCurrencyBalancesScreenKt.InternalVirtualCurrencyBalancesScreen(CustomerCenterConfigTestData.INSTANCE.getStandardAppearance(), CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), new VirtualCurrencyBalancesScreenViewState.Error(new PurchasesError(PurchasesErrorCode.UnknownError, "Mock error")), null, composer, 0, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsRelease, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m14153getLambda1$revenuecatui_defaultsRelease() {
        return f2940lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$revenuecatui_defaultsRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m14154getLambda2$revenuecatui_defaultsRelease() {
        return f2941lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$revenuecatui_defaultsRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m14155getLambda3$revenuecatui_defaultsRelease() {
        return f2942lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$revenuecatui_defaultsRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m14156getLambda4$revenuecatui_defaultsRelease() {
        return f2943lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$revenuecatui_defaultsRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m14157getLambda5$revenuecatui_defaultsRelease() {
        return f2944lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$revenuecatui_defaultsRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m14158getLambda6$revenuecatui_defaultsRelease() {
        return f2945lambda6;
    }
}
