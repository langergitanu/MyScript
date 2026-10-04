package aws.sdk.kotlin.runtime.http;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsUserAgentMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/ExecutionEnvMetadata;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "hashCode", "", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final /* data */ class ExecutionEnvMetadata {
    private final String name;

    public static /* synthetic */ ExecutionEnvMetadata copy$default(ExecutionEnvMetadata executionEnvMetadata, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = executionEnvMetadata.name;
        }
        return executionEnvMetadata.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ExecutionEnvMetadata copy(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ExecutionEnvMetadata(name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ExecutionEnvMetadata) && Intrinsics.areEqual(this.name, ((ExecutionEnvMetadata) other).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public ExecutionEnvMetadata(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public String toString() {
        return AwsUserAgentMetadataKt.uaPair$default("exec-env", null, this.name, 2, null);
    }
}
