package aws.smithy.kotlin.runtime.http.operation;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OperationRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u00020\u0013HÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u00020\u0016HÖ\u0081\u0004¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u0005\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\f¨\u0006\u001d"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", ExifInterface.GPS_DIRECTION_TRUE, "", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", WebViewMessageType.CONTEXT, "subject", "<init>", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Ljava/lang/Object;)V", "(Ljava/lang/Object;)V", "component1", "()Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "component2", "()Ljava/lang/Object;", "copy", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Ljava/lang/Object;)Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "getContext", "Ljava/lang/Object;", "getSubject", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class OperationRequest<T> {
    private final ExecutionContext context;
    private final T subject;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OperationRequest copy$default(OperationRequest operationRequest, ExecutionContext executionContext, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            executionContext = operationRequest.context;
        }
        if ((i & 2) != 0) {
            obj = operationRequest.subject;
        }
        return operationRequest.copy(executionContext, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ExecutionContext getContext() {
        return this.context;
    }

    public final T component2() {
        return this.subject;
    }

    public final OperationRequest<T> copy(ExecutionContext context, T subject) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new OperationRequest<>(context, subject);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperationRequest)) {
            return false;
        }
        OperationRequest operationRequest = (OperationRequest) other;
        return Intrinsics.areEqual(this.context, operationRequest.context) && Intrinsics.areEqual(this.subject, operationRequest.subject);
    }

    public int hashCode() {
        int iHashCode = this.context.hashCode() * 31;
        T t = this.subject;
        return iHashCode + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "OperationRequest(context=" + this.context + ", subject=" + this.subject + ')';
    }

    public OperationRequest(ExecutionContext context, T t) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.subject = t;
    }

    public final ExecutionContext getContext() {
        return this.context;
    }

    public final T getSubject() {
        return this.subject;
    }

    public OperationRequest(T t) {
        this(new ExecutionContext(), t);
    }
}
