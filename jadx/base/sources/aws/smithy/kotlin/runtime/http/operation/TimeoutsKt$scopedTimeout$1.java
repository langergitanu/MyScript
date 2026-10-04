package aws.smithy.kotlin.runtime.http.operation;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.p007ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Timeouts.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 176)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.operation.TimeoutsKt", m1609f = "Timeouts.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1}, m1611l = {53, 56}, m1612m = "scopedTimeout-hhJSO8g", m1613n = {"scope", TypedValues.TransitionType.S_DURATION, "block", "$i$f$scopedTimeout-hhJSO8g", "scope", TypedValues.TransitionType.S_DURATION, "block", "$i$f$scopedTimeout-hhJSO8g"}, m1614nl = {TsExtractor.TS_SYNC_BYTE, 57}, m1615s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, m1616v = 2)
final class TimeoutsKt$scopedTimeout$1<T> extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    TimeoutsKt$scopedTimeout$1(Continuation<? super TimeoutsKt$scopedTimeout$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TimeoutsKt.m12221scopedTimeouthhJSO8g(null, null, null, this);
    }
}
