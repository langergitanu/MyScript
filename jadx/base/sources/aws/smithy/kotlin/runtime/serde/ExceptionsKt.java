package aws.smithy.kotlin.runtime.serde;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, m1599d2 = {"getOrDeserializeErr", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Result;", "errorMessage", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "serde"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ExceptionsKt {
    @InternalApi
    public static final <T> T getOrDeserializeErr(Object obj, Function0<String> errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(obj);
        if (thM14502exceptionOrNullimpl != null) {
            Result.Companion companion = Result.INSTANCE;
            obj = (T) Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException(errorMessage.invoke(), thM14502exceptionOrNullimpl)));
        }
        ResultKt.throwOnFailure(obj);
        return (T) obj;
    }
}
