package androidx.datastore.core;

import androidx.datastore.core.MultiProcessCoordinator;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 */
/* JADX INFO: compiled from: MultiProcessCoordinator.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.datastore.core.MultiProcessCoordinator$Companion", m1609f = "MultiProcessCoordinator.android.kt", m1610i = {0, 0}, m1611l = {PDFACompliance.e_PDFA1_8_4}, m1612m = "getExclusiveFileLockWithRetryIfDeadlock", m1613n = {"lockFileStream", "backoff"}, m1615s = {"L$0", "J$0"}, m1616v = 1)
final class C1877xe413854a extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiProcessCoordinator.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1877xe413854a(MultiProcessCoordinator.Companion companion, Continuation<? super C1877xe413854a> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getExclusiveFileLockWithRetryIfDeadlock(null, this);
    }
}
