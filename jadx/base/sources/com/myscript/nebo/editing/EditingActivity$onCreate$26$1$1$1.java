package com.myscript.nebo.editing;

import com.myscript.nebo.p022ai.domain.AIContainerEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EditingActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class EditingActivity$onCreate$26$1$1$1 extends FunctionReferenceImpl implements Function1<AIContainerEvent, Unit> {
    EditingActivity$onCreate$26$1$1$1(Object obj) {
        super(1, obj, EditingActivity.class, "handleAIEvent", "handleAIEvent(Lcom/myscript/nebo/ai/domain/AIContainerEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AIContainerEvent aIContainerEvent) {
        invoke2(aIContainerEvent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AIContainerEvent p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((EditingActivity) this.receiver).handleAIEvent(p0);
    }
}
