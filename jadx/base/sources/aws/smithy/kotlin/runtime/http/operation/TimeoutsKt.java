package aws.smithy.kotlin.runtime.http.operation;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.http.operation.TimeoutScope;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: Timeouts.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001aH\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u001e\b\u0004\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0080H¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, m1599d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/http/operation/TimeoutScope;", "scope", "Lkotlin/time/Duration;", TypedValues.TransitionType.S_DURATION, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "scopedTimeout-hhJSO8g", "(Laws/smithy/kotlin/runtime/http/operation/TimeoutScope;Lkotlin/time/Duration;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scopedTimeout", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TimeoutsKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: scopedTimeout-hhJSO8g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object m12221scopedTimeouthhJSO8g(TimeoutScope timeoutScope, Duration duration, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) throws Throwable {
        TimeoutsKt$scopedTimeout$1 timeoutsKt$scopedTimeout$1;
        TimeoutsKt$scopedTimeout$exceptionType$1 timeoutsKt$scopedTimeout$exceptionType$1;
        if (continuation instanceof TimeoutsKt$scopedTimeout$1) {
            timeoutsKt$scopedTimeout$1 = (TimeoutsKt$scopedTimeout$1) continuation;
            if ((timeoutsKt$scopedTimeout$1.label & Integer.MIN_VALUE) != 0) {
                timeoutsKt$scopedTimeout$1.label -= Integer.MIN_VALUE;
            } else {
                timeoutsKt$scopedTimeout$1 = new TimeoutsKt$scopedTimeout$1(continuation);
            }
        }
        Object obj = timeoutsKt$scopedTimeout$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = timeoutsKt$scopedTimeout$1.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    int i2 = timeoutsKt$scopedTimeout$1.I$0;
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = timeoutsKt$scopedTimeout$1.I$0;
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            if (duration == null) {
                timeoutsKt$scopedTimeout$1.L$0 = SpillingKt.nullOutSpilledVariable(timeoutScope);
                timeoutsKt$scopedTimeout$1.L$1 = SpillingKt.nullOutSpilledVariable(duration);
                timeoutsKt$scopedTimeout$1.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                timeoutsKt$scopedTimeout$1.I$0 = 0;
                timeoutsKt$scopedTimeout$1.label = 1;
                Object objInvoke = function1.invoke(timeoutsKt$scopedTimeout$1);
                if (objInvoke != coroutine_suspended) {
                    return objInvoke;
                }
            } else {
                long rawValue = duration.getRawValue();
                TimeoutsKt$scopedTimeout$2 timeoutsKt$scopedTimeout$2 = new TimeoutsKt$scopedTimeout$2(function1, null);
                timeoutsKt$scopedTimeout$1.L$0 = timeoutScope;
                timeoutsKt$scopedTimeout$1.L$1 = duration;
                timeoutsKt$scopedTimeout$1.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                timeoutsKt$scopedTimeout$1.I$0 = 0;
                timeoutsKt$scopedTimeout$1.label = 2;
                Object objM16018withTimeoutKLykuaI = TimeoutKt.m16018withTimeoutKLykuaI(rawValue, timeoutsKt$scopedTimeout$2, timeoutsKt$scopedTimeout$1);
                if (objM16018withTimeoutKLykuaI != coroutine_suspended) {
                    return objM16018withTimeoutKLykuaI;
                }
            }
            return coroutine_suspended;
        } catch (TimeoutCancellationException e) {
            String str = timeoutScope.getDescription() + " exceeded configured timeout of " + duration;
            if (timeoutScope instanceof TimeoutScope.Attempt) {
                timeoutsKt$scopedTimeout$exceptionType$1 = TimeoutsKt$scopedTimeout$exceptionType$1.INSTANCE;
            } else {
                if (!Intrinsics.areEqual(timeoutScope, TimeoutScope.Call.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                timeoutsKt$scopedTimeout$exceptionType$1 = TimeoutsKt$scopedTimeout$exceptionType$2.INSTANCE;
            }
            throw ((Throwable) timeoutsKt$scopedTimeout$exceptionType$1.invoke(str, e));
        }
    }

    /* JADX INFO: renamed from: scopedTimeout-hhJSO8g$$forInline, reason: not valid java name */
    private static final <T> Object m12222scopedTimeouthhJSO8g$$forInline(TimeoutScope timeoutScope, Duration duration, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) throws Throwable {
        TimeoutsKt$scopedTimeout$exceptionType$1 timeoutsKt$scopedTimeout$exceptionType$1;
        if (duration == null) {
            return function1.invoke(continuation);
        }
        try {
            return TimeoutKt.m16018withTimeoutKLykuaI(duration.getRawValue(), new TimeoutsKt$scopedTimeout$2(function1, null), continuation);
        } catch (TimeoutCancellationException e) {
            Unit unit = Unit.INSTANCE;
            String str = timeoutScope.getDescription() + " exceeded configured timeout of " + duration;
            if (timeoutScope instanceof TimeoutScope.Attempt) {
                timeoutsKt$scopedTimeout$exceptionType$1 = TimeoutsKt$scopedTimeout$exceptionType$1.INSTANCE;
            } else {
                if (!Intrinsics.areEqual(timeoutScope, TimeoutScope.Call.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                timeoutsKt$scopedTimeout$exceptionType$1 = TimeoutsKt$scopedTimeout$exceptionType$2.INSTANCE;
            }
            throw ((Throwable) timeoutsKt$scopedTimeout$exceptionType$1.invoke(str, e));
        }
    }
}
