package com.myscript.nebo.p022ai.presentation.compose;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AIContainerPane.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final class AIContainerPaneKt$AIContainerPane$3$1 implements PointerInputEventHandler {
    public static final AIContainerPaneKt$AIContainerPane$3$1 INSTANCE = new AIContainerPaneKt$AIContainerPane$3$1();

    AIContainerPaneKt$AIContainerPane$3$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(Offset offset) {
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p004ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$AIContainerPane$3$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AIContainerPaneKt$AIContainerPane$3$1.invoke$lambda$0((Offset) obj);
            }
        }, continuation, 7, null);
        return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
    }
}
