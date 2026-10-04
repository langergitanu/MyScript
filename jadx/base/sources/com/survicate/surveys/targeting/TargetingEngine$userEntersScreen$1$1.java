package com.survicate.surveys.targeting;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TargetingEngine.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
/* synthetic */ class TargetingEngine$userEntersScreen$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    TargetingEngine$userEntersScreen$1$1(Object obj) {
        super(0, obj, TargetingEngine.class, "challengeSurveys", "challengeSurveys()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((TargetingEngine) this.receiver).challengeSurveys();
    }
}
