package com.revenuecat.purchases.p036ui.revenuecatui.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: URLOpener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
/* synthetic */ class URLOpener$openURL$1 extends FunctionReferenceImpl implements Function1<Exception, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.BooleanRef $opened;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    URLOpener$openURL$1(Ref.BooleanRef booleanRef, Context context) {
        super(1, Intrinsics.Kotlin.class, "handleException", "openURL$handleException(Lkotlin/jvm/internal/Ref$BooleanRef;Landroid/content/Context;Ljava/lang/Exception;)V", 0);
        this.$opened = booleanRef;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
        invoke2(exc);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Exception p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        URLOpener.openURL$handleException(this.$opened, this.$context, p0);
    }
}
