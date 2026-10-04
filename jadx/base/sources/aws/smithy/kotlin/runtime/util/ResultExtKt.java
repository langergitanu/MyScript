package aws.smithy.kotlin.runtime.util;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResultExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a=\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, m1599d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Result;", "Lkotlin/Function1;", "", "onFailure", "mapErr", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ResultExtKt {
    @InternalApi
    public static final <T> Object mapErr(Object obj, Function1<? super Throwable, ? extends Throwable> onFailure) {
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(obj);
        if (thM14502exceptionOrNullimpl == null) {
            return obj;
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.m14499constructorimpl(ResultKt.createFailure(onFailure.invoke(thM14502exceptionOrNullimpl)));
    }
}
