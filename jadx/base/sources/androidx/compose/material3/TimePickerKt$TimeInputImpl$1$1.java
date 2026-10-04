package androidx.compose.material3;

import androidx.compose.p004ui.node.Ref;
import androidx.compose.p004ui.text.input.TextFieldValue;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1", m1609f = "TimePicker.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class TimePickerKt$TimeInputImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<TextFieldValue> $hourValue$delegate;
    final /* synthetic */ MutableState<TextFieldValue> $minuteValue$delegate;
    final /* synthetic */ TimePickerState $state;
    final /* synthetic */ Ref<Boolean> $userOverride;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimeInputImpl$1$1(Ref<Boolean> ref, TimePickerState timePickerState, MutableState<TextFieldValue> mutableState, MutableState<TextFieldValue> mutableState2, Continuation<? super TimePickerKt$TimeInputImpl$1$1> continuation) {
        super(2, continuation);
        this.$userOverride = ref;
        this.$state = timePickerState;
        this.$hourValue$delegate = mutableState;
        this.$minuteValue$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TimePickerKt$TimeInputImpl$1$1(this.$userOverride, this.$state, this.$hourValue$delegate, this.$minuteValue$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TimePickerKt$TimeInputImpl$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (Intrinsics.areEqual(this.$userOverride.getValue(), Boxing.boxBoolean(true))) {
            this.$hourValue$delegate.setValue(TimePickerKt.TimeInputImpl$hourTextValue(this.$state));
            this.$minuteValue$delegate.setValue(TimePickerKt.TimeInputImpl$minuteTextValue(this.$state));
        }
        this.$userOverride.setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
