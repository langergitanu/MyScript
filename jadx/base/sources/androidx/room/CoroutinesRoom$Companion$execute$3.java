package androidx.room;

import androidx.room.CoroutinesRoom;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: CoroutinesRoom.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.room.CoroutinesRoom$Companion", m1609f = "CoroutinesRoom.android.kt", m1610i = {0, 0, 0, 1, 1, 1, 1}, m1611l = {64, PDFACompliance.e_PDFA9_4}, m1612m = "execute", m1613n = {"db", "cancellationSignal", "callable", "db", "cancellationSignal", "callable", WebViewMessageType.CONTEXT}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
final class CoroutinesRoom$Companion$execute$3<R> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutinesRoom.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$execute$3(CoroutinesRoom.Companion companion, Continuation<? super CoroutinesRoom$Companion$execute$3> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, false, null, null, this);
    }
}
