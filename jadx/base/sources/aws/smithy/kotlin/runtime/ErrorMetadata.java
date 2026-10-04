package aws.smithy.kotlin.runtime;

import aws.smithy.kotlin.runtime.collections.AttributeKey;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/ErrorMetadata;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "attributes", "Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "getAttributes", "()Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "getAttributes$annotations", "", "isRetryable", "()Z", "isThrottling", "", "Laws/smithy/kotlin/runtime/ClientErrorContext;", "getClientContext", "()Ljava/util/List;", "clientContext", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class ErrorMetadata {
    private final MutableAttributes attributes = AttributesKt.mutableAttributes();

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AttributeKey<List<ClientErrorContext>> ClientContext = new AttributeKey<>("aws.smithy.kotlin#ClientContext");
    private static final AttributeKey<Boolean> Retryable = new AttributeKey<>("aws.smithy.kotlin#Retryable");
    private static final AttributeKey<Boolean> ThrottlingError = new AttributeKey<>("aws.smithy.kotlin#ThrottlingError");

    @InternalApi
    public static /* synthetic */ void getAttributes$annotations() {
    }

    public final MutableAttributes getAttributes() {
        return this.attributes;
    }

    /* JADX INFO: compiled from: Exceptions.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/ErrorMetadata$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "", "Laws/smithy/kotlin/runtime/ClientErrorContext;", "ClientContext", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "getClientContext", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "", "Retryable", "getRetryable", "ThrottlingError", "getThrottlingError", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AttributeKey<List<ClientErrorContext>> getClientContext() {
            return ErrorMetadata.ClientContext;
        }

        public final AttributeKey<Boolean> getRetryable() {
            return ErrorMetadata.Retryable;
        }

        public final AttributeKey<Boolean> getThrottlingError() {
            return ErrorMetadata.ThrottlingError;
        }
    }

    public final boolean isRetryable() {
        Boolean bool = (Boolean) this.attributes.getOrNull(Retryable);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean isThrottling() {
        Boolean bool = (Boolean) this.attributes.getOrNull(ThrottlingError);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final List<ClientErrorContext> getClientContext() {
        List<ClientErrorContext> list = (List) this.attributes.getOrNull(ClientContext);
        return list == null ? CollectionsKt.emptyList() : list;
    }
}
