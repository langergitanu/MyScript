package aws.smithy.kotlin.runtime.awsprotocol;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.ServiceException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsQueryCompatibleErrorDetails.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u0015\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/AwsQueryCompatibleErrorDetails;", "", "", "code", "Laws/smithy/kotlin/runtime/ServiceException$ErrorType;", "type", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/ServiceException$ErrorType;)V", "component1", "()Ljava/lang/String;", "component2", "()Laws/smithy/kotlin/runtime/ServiceException$ErrorType;", "copy", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/ServiceException$ErrorType;)Laws/smithy/kotlin/runtime/awsprotocol/AwsQueryCompatibleErrorDetails;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCode", "Laws/smithy/kotlin/runtime/ServiceException$ErrorType;", "getType", "Companion", "aws-protocol-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class AwsQueryCompatibleErrorDetails {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String code;
    private final ServiceException.ErrorType type;

    public static /* synthetic */ AwsQueryCompatibleErrorDetails copy$default(AwsQueryCompatibleErrorDetails awsQueryCompatibleErrorDetails, String str, ServiceException.ErrorType errorType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = awsQueryCompatibleErrorDetails.code;
        }
        if ((i & 2) != 0) {
            errorType = awsQueryCompatibleErrorDetails.type;
        }
        return awsQueryCompatibleErrorDetails.copy(str, errorType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ServiceException.ErrorType getType() {
        return this.type;
    }

    public final AwsQueryCompatibleErrorDetails copy(String code, ServiceException.ErrorType type) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(type, "type");
        return new AwsQueryCompatibleErrorDetails(code, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AwsQueryCompatibleErrorDetails)) {
            return false;
        }
        AwsQueryCompatibleErrorDetails awsQueryCompatibleErrorDetails = (AwsQueryCompatibleErrorDetails) other;
        return Intrinsics.areEqual(this.code, awsQueryCompatibleErrorDetails.code) && this.type == awsQueryCompatibleErrorDetails.type;
    }

    public int hashCode() {
        return (this.code.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "AwsQueryCompatibleErrorDetails(code=" + this.code + ", type=" + this.type + ')';
    }

    public AwsQueryCompatibleErrorDetails(String code, ServiceException.ErrorType type) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(type, "type");
        this.code = code;
        this.type = type;
    }

    public final String getCode() {
        return this.code;
    }

    public final ServiceException.ErrorType getType() {
        return this.type;
    }

    /* JADX INFO: compiled from: AwsQueryCompatibleErrorDetails.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/AwsQueryCompatibleErrorDetails$Companion;", "", "<init>", "()V", "", "value", "Laws/smithy/kotlin/runtime/awsprotocol/AwsQueryCompatibleErrorDetails;", "parse", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/awsprotocol/AwsQueryCompatibleErrorDetails;", "aws-protocol-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AwsQueryCompatibleErrorDetails parse(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return AwsQueryCompatibleErrorDetailsKt.parseImpl(value);
        }
    }
}
