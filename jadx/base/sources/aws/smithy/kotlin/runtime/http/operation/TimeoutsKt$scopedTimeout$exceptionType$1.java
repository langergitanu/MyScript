package aws.smithy.kotlin.runtime.http.operation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Timeouts.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 176)
public final /* synthetic */ class TimeoutsKt$scopedTimeout$exceptionType$1 extends FunctionReferenceImpl implements Function2<String, Throwable, AttemptTimeoutException> {
    public static final TimeoutsKt$scopedTimeout$exceptionType$1 INSTANCE = new TimeoutsKt$scopedTimeout$exceptionType$1();

    public TimeoutsKt$scopedTimeout$exceptionType$1() {
        super(2, AttemptTimeoutException.class, "<init>", "<init>(Ljava/lang/String;Ljava/lang/Throwable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final AttemptTimeoutException invoke(String p0, Throwable p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return new AttemptTimeoutException(p0, p1);
    }
}
