package com.revenuecat.purchases.p036ui.revenuecatui;

import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.TemplateConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InternalPaywall.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
/* synthetic */ class InternalPaywallKt$LoadedPaywall$2$1$1 extends FunctionReferenceImpl implements Function1<TemplateConfiguration.PackageInfo, Unit> {
    InternalPaywallKt$LoadedPaywall$2$1$1(Object obj) {
        super(1, obj, PaywallViewModel.class, "selectPackage", "selectPackage(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TemplateConfiguration.PackageInfo packageInfo) {
        invoke2(packageInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TemplateConfiguration.PackageInfo p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((PaywallViewModel) this.receiver).selectPackage(p0);
    }
}
