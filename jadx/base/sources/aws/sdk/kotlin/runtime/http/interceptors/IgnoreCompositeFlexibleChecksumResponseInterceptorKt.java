package aws.sdk.kotlin.runtime.http.interceptors;

import kotlin.Metadata;
import kotlin.text.Regex;

/* JADX INFO: compiled from: IgnoreCompositeFlexibleChecksumResponseInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m1599d2 = {"isCompositeChecksum", "", "", "aws-http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class IgnoreCompositeFlexibleChecksumResponseInterceptorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isCompositeChecksum(String str) {
        return new Regex("-(\\d)+$").containsMatchIn(str);
    }
}
