package aws.smithy.kotlin.runtime.retries;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.retries.Outcome;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Outcome.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, m1599d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/retries/Outcome;", "getOrThrow", "(Laws/smithy/kotlin/runtime/retries/Outcome;)Ljava/lang/Object;", "Lkotlin/Result;", "toResult", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OutcomeKt {
    public static final <T> T getOrThrow(Outcome<? extends T> outcome) throws Throwable {
        Intrinsics.checkNotNullParameter(outcome, "<this>");
        if (outcome instanceof Outcome.Response) {
            return (T) ((Outcome.Response) outcome).getResponse();
        }
        if (outcome instanceof Outcome.Exception) {
            throw ((Outcome.Exception) outcome).getException();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> Object toResult(Outcome<? extends T> outcome) {
        Intrinsics.checkNotNullParameter(outcome, "<this>");
        if (outcome instanceof Outcome.Response) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(((Outcome.Response) outcome).getResponse());
        }
        if (!(outcome instanceof Outcome.Exception)) {
            throw new NoWhenBranchMatchedException();
        }
        Result.Companion companion2 = Result.INSTANCE;
        return Result.m14499constructorimpl(ResultKt.createFailure(((Outcome.Exception) outcome).getException()));
    }
}
