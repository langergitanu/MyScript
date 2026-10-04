package aws.sdk.kotlin.runtime.http;

import aws.sdk.kotlin.runtime.http.operation.ConfigMetadata;
import aws.sdk.kotlin.runtime.http.operation.CustomUserAgentMetadata;
import aws.sdk.kotlin.runtime.http.operation.FeatureMetadata;
import aws.sdk.kotlin.runtime.http.operation.TypedUserAgentMetadata;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.myscript.nebo.LaunchActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsUserAgentMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 72\u00020\u0001:\u00017BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0011HÆ\u0003Ja\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0014\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00104\u001a\u000205HÖ\u0081\u0004J\n\u00106\u001a\u00020\u000fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b%\u0010!R\u0011\u0010&\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b'\u0010!¨\u00068"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/AwsUserAgentMetadata;", "", "sdkMetadata", "Laws/sdk/kotlin/runtime/http/SdkMetadata;", "apiMetadata", "Laws/sdk/kotlin/runtime/http/ApiMetadata;", "osMetadata", "Laws/sdk/kotlin/runtime/http/OsMetadata;", "languageMetadata", "Laws/sdk/kotlin/runtime/http/LanguageMetadata;", "execEnvMetadata", "Laws/sdk/kotlin/runtime/http/ExecutionEnvMetadata;", "frameworkMetadata", "Laws/sdk/kotlin/runtime/http/FrameworkMetadata;", RemoteConfigConstants.RequestFieldKey.APP_ID, "", "customMetadata", "Laws/sdk/kotlin/runtime/http/operation/CustomUserAgentMetadata;", "<init>", "(Laws/sdk/kotlin/runtime/http/SdkMetadata;Laws/sdk/kotlin/runtime/http/ApiMetadata;Laws/sdk/kotlin/runtime/http/OsMetadata;Laws/sdk/kotlin/runtime/http/LanguageMetadata;Laws/sdk/kotlin/runtime/http/ExecutionEnvMetadata;Laws/sdk/kotlin/runtime/http/FrameworkMetadata;Ljava/lang/String;Laws/sdk/kotlin/runtime/http/operation/CustomUserAgentMetadata;)V", "getSdkMetadata", "()Laws/sdk/kotlin/runtime/http/SdkMetadata;", "getApiMetadata", "()Laws/sdk/kotlin/runtime/http/ApiMetadata;", "getOsMetadata", "()Laws/sdk/kotlin/runtime/http/OsMetadata;", "getLanguageMetadata", "()Laws/sdk/kotlin/runtime/http/LanguageMetadata;", "getExecEnvMetadata", "()Laws/sdk/kotlin/runtime/http/ExecutionEnvMetadata;", "getFrameworkMetadata", "()Laws/sdk/kotlin/runtime/http/FrameworkMetadata;", "getAppId", "()Ljava/lang/String;", "getCustomMetadata", "()Laws/sdk/kotlin/runtime/http/operation/CustomUserAgentMetadata;", "xAmzUserAgent", "getXAmzUserAgent", "userAgent", "getUserAgent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class AwsUserAgentMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ApiMetadata apiMetadata;
    private final String appId;
    private final CustomUserAgentMetadata customMetadata;
    private final ExecutionEnvMetadata execEnvMetadata;
    private final FrameworkMetadata frameworkMetadata;
    private final LanguageMetadata languageMetadata;
    private final OsMetadata osMetadata;
    private final SdkMetadata sdkMetadata;

    public static /* synthetic */ AwsUserAgentMetadata copy$default(AwsUserAgentMetadata awsUserAgentMetadata, SdkMetadata sdkMetadata, ApiMetadata apiMetadata, OsMetadata osMetadata, LanguageMetadata languageMetadata, ExecutionEnvMetadata executionEnvMetadata, FrameworkMetadata frameworkMetadata, String str, CustomUserAgentMetadata customUserAgentMetadata, int i, Object obj) {
        if ((i & 1) != 0) {
            sdkMetadata = awsUserAgentMetadata.sdkMetadata;
        }
        if ((i & 2) != 0) {
            apiMetadata = awsUserAgentMetadata.apiMetadata;
        }
        if ((i & 4) != 0) {
            osMetadata = awsUserAgentMetadata.osMetadata;
        }
        if ((i & 8) != 0) {
            languageMetadata = awsUserAgentMetadata.languageMetadata;
        }
        if ((i & 16) != 0) {
            executionEnvMetadata = awsUserAgentMetadata.execEnvMetadata;
        }
        if ((i & 32) != 0) {
            frameworkMetadata = awsUserAgentMetadata.frameworkMetadata;
        }
        if ((i & 64) != 0) {
            str = awsUserAgentMetadata.appId;
        }
        if ((i & 128) != 0) {
            customUserAgentMetadata = awsUserAgentMetadata.customMetadata;
        }
        String str2 = str;
        CustomUserAgentMetadata customUserAgentMetadata2 = customUserAgentMetadata;
        ExecutionEnvMetadata executionEnvMetadata2 = executionEnvMetadata;
        FrameworkMetadata frameworkMetadata2 = frameworkMetadata;
        return awsUserAgentMetadata.copy(sdkMetadata, apiMetadata, osMetadata, languageMetadata, executionEnvMetadata2, frameworkMetadata2, str2, customUserAgentMetadata2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SdkMetadata getSdkMetadata() {
        return this.sdkMetadata;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ApiMetadata getApiMetadata() {
        return this.apiMetadata;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final OsMetadata getOsMetadata() {
        return this.osMetadata;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final LanguageMetadata getLanguageMetadata() {
        return this.languageMetadata;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ExecutionEnvMetadata getExecEnvMetadata() {
        return this.execEnvMetadata;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final FrameworkMetadata getFrameworkMetadata() {
        return this.frameworkMetadata;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final CustomUserAgentMetadata getCustomMetadata() {
        return this.customMetadata;
    }

    public final AwsUserAgentMetadata copy(SdkMetadata sdkMetadata, ApiMetadata apiMetadata, OsMetadata osMetadata, LanguageMetadata languageMetadata, ExecutionEnvMetadata execEnvMetadata, FrameworkMetadata frameworkMetadata, String appId, CustomUserAgentMetadata customMetadata) {
        Intrinsics.checkNotNullParameter(sdkMetadata, "sdkMetadata");
        Intrinsics.checkNotNullParameter(apiMetadata, "apiMetadata");
        Intrinsics.checkNotNullParameter(osMetadata, "osMetadata");
        Intrinsics.checkNotNullParameter(languageMetadata, "languageMetadata");
        return new AwsUserAgentMetadata(sdkMetadata, apiMetadata, osMetadata, languageMetadata, execEnvMetadata, frameworkMetadata, appId, customMetadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AwsUserAgentMetadata)) {
            return false;
        }
        AwsUserAgentMetadata awsUserAgentMetadata = (AwsUserAgentMetadata) other;
        return Intrinsics.areEqual(this.sdkMetadata, awsUserAgentMetadata.sdkMetadata) && Intrinsics.areEqual(this.apiMetadata, awsUserAgentMetadata.apiMetadata) && Intrinsics.areEqual(this.osMetadata, awsUserAgentMetadata.osMetadata) && Intrinsics.areEqual(this.languageMetadata, awsUserAgentMetadata.languageMetadata) && Intrinsics.areEqual(this.execEnvMetadata, awsUserAgentMetadata.execEnvMetadata) && Intrinsics.areEqual(this.frameworkMetadata, awsUserAgentMetadata.frameworkMetadata) && Intrinsics.areEqual(this.appId, awsUserAgentMetadata.appId) && Intrinsics.areEqual(this.customMetadata, awsUserAgentMetadata.customMetadata);
    }

    public int hashCode() {
        int iHashCode = ((((((this.sdkMetadata.hashCode() * 31) + this.apiMetadata.hashCode()) * 31) + this.osMetadata.hashCode()) * 31) + this.languageMetadata.hashCode()) * 31;
        ExecutionEnvMetadata executionEnvMetadata = this.execEnvMetadata;
        int iHashCode2 = (iHashCode + (executionEnvMetadata == null ? 0 : executionEnvMetadata.hashCode())) * 31;
        FrameworkMetadata frameworkMetadata = this.frameworkMetadata;
        int iHashCode3 = (iHashCode2 + (frameworkMetadata == null ? 0 : frameworkMetadata.hashCode())) * 31;
        String str = this.appId;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        CustomUserAgentMetadata customUserAgentMetadata = this.customMetadata;
        return iHashCode4 + (customUserAgentMetadata != null ? customUserAgentMetadata.hashCode() : 0);
    }

    public String toString() {
        return "AwsUserAgentMetadata(sdkMetadata=" + this.sdkMetadata + ", apiMetadata=" + this.apiMetadata + ", osMetadata=" + this.osMetadata + ", languageMetadata=" + this.languageMetadata + ", execEnvMetadata=" + this.execEnvMetadata + ", frameworkMetadata=" + this.frameworkMetadata + ", appId=" + this.appId + ", customMetadata=" + this.customMetadata + ')';
    }

    public AwsUserAgentMetadata(SdkMetadata sdkMetadata, ApiMetadata apiMetadata, OsMetadata osMetadata, LanguageMetadata languageMetadata, ExecutionEnvMetadata executionEnvMetadata, FrameworkMetadata frameworkMetadata, String str, CustomUserAgentMetadata customUserAgentMetadata) {
        Intrinsics.checkNotNullParameter(sdkMetadata, "sdkMetadata");
        Intrinsics.checkNotNullParameter(apiMetadata, "apiMetadata");
        Intrinsics.checkNotNullParameter(osMetadata, "osMetadata");
        Intrinsics.checkNotNullParameter(languageMetadata, "languageMetadata");
        this.sdkMetadata = sdkMetadata;
        this.apiMetadata = apiMetadata;
        this.osMetadata = osMetadata;
        this.languageMetadata = languageMetadata;
        this.execEnvMetadata = executionEnvMetadata;
        this.frameworkMetadata = frameworkMetadata;
        this.appId = str;
        this.customMetadata = customUserAgentMetadata;
    }

    public /* synthetic */ AwsUserAgentMetadata(SdkMetadata sdkMetadata, ApiMetadata apiMetadata, OsMetadata osMetadata, LanguageMetadata languageMetadata, ExecutionEnvMetadata executionEnvMetadata, FrameworkMetadata frameworkMetadata, String str, CustomUserAgentMetadata customUserAgentMetadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sdkMetadata, apiMetadata, osMetadata, languageMetadata, (i & 16) != 0 ? null : executionEnvMetadata, (i & 32) != 0 ? null : frameworkMetadata, (i & 64) != 0 ? null : str, (i & 128) != 0 ? null : customUserAgentMetadata);
    }

    public final SdkMetadata getSdkMetadata() {
        return this.sdkMetadata;
    }

    public final ApiMetadata getApiMetadata() {
        return this.apiMetadata;
    }

    public final OsMetadata getOsMetadata() {
        return this.osMetadata;
    }

    public final LanguageMetadata getLanguageMetadata() {
        return this.languageMetadata;
    }

    public final ExecutionEnvMetadata getExecEnvMetadata() {
        return this.execEnvMetadata;
    }

    public final FrameworkMetadata getFrameworkMetadata() {
        return this.frameworkMetadata;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final CustomUserAgentMetadata getCustomMetadata() {
        return this.customMetadata;
    }

    /* JADX INFO: compiled from: AwsUserAgentMetadata.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/AwsUserAgentMetadata$Companion;", "", "<init>", "()V", "fromEnvironment", "Laws/sdk/kotlin/runtime/http/AwsUserAgentMetadata;", "apiMeta", "Laws/sdk/kotlin/runtime/http/ApiMetadata;", RemoteConfigConstants.RequestFieldKey.APP_ID, "", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ AwsUserAgentMetadata fromEnvironment$default(Companion companion, ApiMetadata apiMetadata, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.fromEnvironment(apiMetadata, str);
        }

        public final AwsUserAgentMetadata fromEnvironment(ApiMetadata apiMeta, String appId) {
            Intrinsics.checkNotNullParameter(apiMeta, "apiMeta");
            return AwsUserAgentMetadataKt.loadAwsUserAgentMetadataFromEnvironment(PlatformProvider.INSTANCE.getSystem(), apiMeta, appId);
        }
    }

    public final String getXAmzUserAgent() {
        Map<String, String> extras$aws_http;
        List<TypedUserAgentMetadata> typedExtras$aws_http;
        List<TypedUserAgentMetadata> typedExtras$aws_http2;
        Map<String, String> extras$aws_http2;
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add(this.sdkMetadata);
        CustomUserAgentMetadata customUserAgentMetadata = this.customMetadata;
        if (customUserAgentMetadata != null && (extras$aws_http2 = customUserAgentMetadata.getExtras$aws_http()) != null) {
            if (!extras$aws_http2.containsKey("internal")) {
                extras$aws_http2 = null;
            }
            if (extras$aws_http2 != null) {
                listCreateListBuilder.add("md/internal");
            }
        }
        listCreateListBuilder.add(AwsUserAgentMetadataKt.uaPair$default("ua", "2.1", null, 4, null));
        listCreateListBuilder.add(this.apiMetadata);
        listCreateListBuilder.add(this.osMetadata);
        listCreateListBuilder.add(this.languageMetadata);
        ExecutionEnvMetadata executionEnvMetadata = this.execEnvMetadata;
        if (executionEnvMetadata != null) {
            listCreateListBuilder.add(executionEnvMetadata);
        }
        CustomUserAgentMetadata customUserAgentMetadata2 = this.customMetadata;
        if (customUserAgentMetadata2 != null && (typedExtras$aws_http2 = customUserAgentMetadata2.getTypedExtras$aws_http()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : typedExtras$aws_http2) {
                if (obj instanceof ConfigMetadata) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                listCreateListBuilder.add(it.next());
            }
        }
        String str = this.appId;
        if (str != null) {
            listCreateListBuilder.add(AwsUserAgentMetadataKt.uaPair$default(LaunchActivity.LaunchRoute.App, null, str, 2, null));
        }
        CustomUserAgentMetadata customUserAgentMetadata3 = this.customMetadata;
        if (customUserAgentMetadata3 != null && (typedExtras$aws_http = customUserAgentMetadata3.getTypedExtras$aws_http()) != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : typedExtras$aws_http) {
                if (obj2 instanceof FeatureMetadata) {
                    arrayList2.add(obj2);
                }
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                listCreateListBuilder.add(it2.next());
            }
        }
        FrameworkMetadata frameworkMetadata = this.frameworkMetadata;
        if (frameworkMetadata != null) {
            listCreateListBuilder.add(frameworkMetadata);
        }
        CustomUserAgentMetadata customUserAgentMetadata4 = this.customMetadata;
        if (customUserAgentMetadata4 != null && (extras$aws_http = customUserAgentMetadata4.getExtras$aws_http()) != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, String> entry : extras$aws_http.entrySet()) {
                if (!Intrinsics.areEqual(entry.getKey(), "internal")) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            listCreateListBuilder.add(AdditionalMetadata.m12065toStringimpl(AdditionalMetadata.m12061constructorimpl(linkedHashMap)));
        }
        return CollectionsKt.joinToString$default(CollectionsKt.build(listCreateListBuilder), " ", null, null, 0, null, null, 62, null);
    }

    public final String getUserAgent() {
        return String.valueOf(this.sdkMetadata);
    }
}
