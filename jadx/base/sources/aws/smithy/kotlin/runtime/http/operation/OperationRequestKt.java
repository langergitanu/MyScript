package aws.smithy.kotlin.runtime.http.operation;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.util.CanDeepCopy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OperationRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/CanDeepCopy;", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "deepCopy", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;)Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OperationRequestKt {
    public static final <T extends CanDeepCopy<? extends T>> OperationRequest<T> deepCopy(OperationRequest<T> operationRequest) {
        Intrinsics.checkNotNullParameter(operationRequest, "<this>");
        return new OperationRequest<>(operationRequest.getContext(), operationRequest.getSubject().deepCopy());
    }
}
