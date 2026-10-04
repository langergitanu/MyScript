package aws.smithy.kotlin.runtime.util;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyAsyncValue.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "initializer", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "asyncLazy", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LazyAsyncValueKt {
    @InternalApi
    public static final <T> LazyAsyncValue<T> asyncLazy(Function1<? super Continuation<? super T>, ? extends Object> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return new LazyAsyncValueImpl(initializer);
    }
}
