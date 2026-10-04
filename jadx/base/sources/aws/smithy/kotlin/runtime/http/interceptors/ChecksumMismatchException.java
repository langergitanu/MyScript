package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.ClientException;
import kotlin.Metadata;

/* JADX INFO: compiled from: FlexibleChecksumsResponseInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/ChecksumMismatchException;", "Laws/smithy/kotlin/runtime/ClientException;", "", "message", "<init>", "(Ljava/lang/String;)V", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ChecksumMismatchException extends ClientException {
    public ChecksumMismatchException(String str) {
        super(str);
    }
}
