package com.revenuecat.purchases.p036ui.revenuecatui.checkpoints;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CheckpointWorkflowActivity.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
/* synthetic */ class CheckpointWorkflowActivity$onCreate$options$1 extends FunctionReferenceImpl implements Function0<Unit> {
    CheckpointWorkflowActivity$onCreate$options$1(Object obj) {
        super(0, obj, CheckpointWorkflowActivity.class, "finish", "finish()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((CheckpointWorkflowActivity) this.receiver).finish();
    }
}
