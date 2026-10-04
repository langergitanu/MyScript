package com.revenuecat.purchases.common;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: CancellableContinuationExtensions.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0000¢\u0006\u0002\u0010\u0005\u001a \u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\t"}, m1599d2 = {"safeResume", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CancellableContinuation;", "value", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;)V", "safeResumeWithException", "exception", "", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CancellableContinuationExtensionsKt {
    public static final <T> void safeResume(CancellableContinuation<? super T> cancellableContinuation, T t) {
        Intrinsics.checkNotNullParameter(cancellableContinuation, "<this>");
        if (cancellableContinuation.isActive()) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m14499constructorimpl(t));
        }
    }

    public static final <T> void safeResumeWithException(CancellableContinuation<? super T> cancellableContinuation, Throwable exception) {
        Intrinsics.checkNotNullParameter(cancellableContinuation, "<this>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (cancellableContinuation.isActive()) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m14499constructorimpl(ResultKt.createFailure(exception)));
        }
    }
}
