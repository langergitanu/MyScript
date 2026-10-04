package androidx.compose.foundation.layout;

import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection", m1609f = "WindowInsetsConnection.android.kt", m1610i = {0, 0, 1, 1, 2}, m1611l = {301, PDFACompliance.e_PDFA3_2_7, PDFACompliance.e_PDFA3_5_2}, m1612m = "fling-huYlsQE", m1613n = {"available", "flingAmount", "endVelocity", "available", "available"}, m1615s = {"J$0", "F$0", "L$0", "J$0", "J$0"}, m1616v = 1)
final class WindowInsetsNestedScrollConnection$fling$1 extends ContinuationImpl {
    float F$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowInsetsNestedScrollConnection$fling$1(WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, Continuation<? super WindowInsetsNestedScrollConnection$fling$1> continuation) {
        super(continuation);
        this.this$0 = windowInsetsNestedScrollConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m2955flinghuYlsQE(0L, 0.0f, false, this);
    }
}
