package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: renamed from: androidx.compose.runtime.RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1 */
/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, m1599d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", WebViewMessageType.CONTEXT, "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class C1245x4c2ade6a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ CompositionErrorContextImpl $traceContext$inlined;
    final /* synthetic */ RememberedCoroutineScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1245x4c2ade6a(CoroutineExceptionHandler.Companion companion, CompositionErrorContextImpl compositionErrorContextImpl, RememberedCoroutineScope rememberedCoroutineScope) {
        super(companion);
        this.$traceContext$inlined = compositionErrorContextImpl;
        this.this$0 = rememberedCoroutineScope;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext context, Throwable exception) throws Throwable {
        this.$traceContext$inlined.attachComposeStackTrace(exception, this.this$0);
        CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) this.this$0.overlayContext.get(CoroutineExceptionHandler.INSTANCE);
        if (coroutineExceptionHandler != null) {
            coroutineExceptionHandler.handleException(context, exception);
            return;
        }
        CoroutineExceptionHandler coroutineExceptionHandler2 = (CoroutineExceptionHandler) this.this$0.parentContext.get(CoroutineExceptionHandler.INSTANCE);
        if (coroutineExceptionHandler2 == null) {
            throw exception;
        }
        coroutineExceptionHandler2.handleException(context, exception);
    }
}
