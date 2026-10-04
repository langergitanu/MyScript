package aws.sdk.kotlin.services.p010s3.express;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.auth.AuthOption;
import aws.smithy.kotlin.runtime.auth.AuthOptionKt;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.http.auth.SigV4AuthSchemeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SigV4S3ExpressAuthScheme.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001aG\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u000e\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000f"}, m1599d2 = {"AwsSigV4S3Express", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId$Companion;", "getAwsSigV4S3Express", "(Laws/smithy/kotlin/runtime/auth/AuthSchemeId$Companion;)Ljava/lang/String;", "sigV4S3Express", "Laws/smithy/kotlin/runtime/auth/AuthOption;", "unsignedPayload", "", "serviceName", "", "signingRegion", "disableDoubleUriEncode", "normalizeUriPath", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Laws/smithy/kotlin/runtime/auth/AuthOption;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SigV4S3ExpressAuthSchemeKt {
    public static final String getAwsSigV4S3Express(AuthSchemeId.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return AuthSchemeId.m12117constructorimpl("aws.auth#sigv4s3express");
    }

    public static /* synthetic */ AuthOption sigV4S3Express$default(boolean z, String str, String str2, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            bool2 = null;
        }
        return sigV4S3Express(z, str, str2, bool, bool2);
    }

    @InternalApi
    public static final AuthOption sigV4S3Express(boolean z, String str, String str2, Boolean bool, Boolean bool2) {
        return AuthOptionKt.m12114AuthOptionJh0Pmzk(getAwsSigV4S3Express(AuthSchemeId.INSTANCE), SigV4AuthSchemeKt.sigV4(z, str, str2, bool, bool2).getAttributes());
    }
}
