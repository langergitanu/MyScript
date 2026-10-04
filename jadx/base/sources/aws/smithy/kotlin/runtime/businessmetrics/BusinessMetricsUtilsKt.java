package aws.smithy.kotlin.runtime.businessmetrics;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BusinessMetricsUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u001b\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\b\u0010\u0005\u001a\u001b\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\n\u0010\u000b\",\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r0\f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\"&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u0012\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0016\u0010\u0011\"&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "Laws/smithy/kotlin/runtime/businessmetrics/BusinessMetric;", "metric", "", "emitBusinessMetric", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/businessmetrics/BusinessMetric;)V", "Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "(Laws/smithy/kotlin/runtime/collections/MutableAttributes;Laws/smithy/kotlin/runtime/businessmetrics/BusinessMetric;)V", "removeBusinessMetric", "", "containsBusinessMetric", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/businessmetrics/BusinessMetric;)Z", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "", "BusinessMetrics", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "getBusinessMetrics", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "getBusinessMetrics$annotations", "()V", "", "AccountIdBasedEndpointAccountId", "getAccountIdBasedEndpointAccountId", "getAccountIdBasedEndpointAccountId$annotations", "ServiceEndpointOverride", "getServiceEndpointOverride", "getServiceEndpointOverride$annotations", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BusinessMetricsUtilsKt {
    private static final AttributeKey<Set<BusinessMetric>> BusinessMetrics = new AttributeKey<>("aws.smithy.kotlin#BusinessMetrics");
    private static final AttributeKey<String> AccountIdBasedEndpointAccountId = new AttributeKey<>("aws.smithy.kotlin#AccountIdBasedEndpointAccountId");
    private static final AttributeKey<Boolean> ServiceEndpointOverride = new AttributeKey<>("aws.smithy.kotlin#ServiceEndpointOverride");

    @InternalApi
    public static /* synthetic */ void getAccountIdBasedEndpointAccountId$annotations() {
    }

    @InternalApi
    public static /* synthetic */ void getBusinessMetrics$annotations() {
    }

    @InternalApi
    public static /* synthetic */ void getServiceEndpointOverride$annotations() {
    }

    public static final AttributeKey<Set<BusinessMetric>> getBusinessMetrics() {
        return BusinessMetrics;
    }

    public static final AttributeKey<String> getAccountIdBasedEndpointAccountId() {
        return AccountIdBasedEndpointAccountId;
    }

    public static final AttributeKey<Boolean> getServiceEndpointOverride() {
        return ServiceEndpointOverride;
    }

    @InternalApi
    public static final void emitBusinessMetric(ExecutionContext executionContext, BusinessMetric metric) {
        Intrinsics.checkNotNullParameter(executionContext, "<this>");
        Intrinsics.checkNotNullParameter(metric, "metric");
        MutableAttributes attributes = executionContext.getAttributes();
        AttributeKey<Set<BusinessMetric>> attributeKey = BusinessMetrics;
        if (attributes.contains(attributeKey)) {
            ((Set) AttributesKt.get(executionContext.getAttributes(), attributeKey)).add(metric);
        } else {
            executionContext.getAttributes().set(attributeKey, SetsKt.mutableSetOf(metric));
        }
    }

    @InternalApi
    public static final void emitBusinessMetric(MutableAttributes mutableAttributes, BusinessMetric metric) {
        Intrinsics.checkNotNullParameter(mutableAttributes, "<this>");
        Intrinsics.checkNotNullParameter(metric, "metric");
        AttributeKey<Set<BusinessMetric>> attributeKey = BusinessMetrics;
        if (mutableAttributes.contains(attributeKey)) {
            ((Set) AttributesKt.get(mutableAttributes, attributeKey)).add(metric);
        } else {
            mutableAttributes.set(attributeKey, SetsKt.mutableSetOf(metric));
        }
    }

    @InternalApi
    public static final void removeBusinessMetric(ExecutionContext executionContext, BusinessMetric metric) {
        Intrinsics.checkNotNullParameter(executionContext, "<this>");
        Intrinsics.checkNotNullParameter(metric, "metric");
        MutableAttributes attributes = executionContext.getAttributes();
        AttributeKey<Set<BusinessMetric>> attributeKey = BusinessMetrics;
        if (attributes.contains(attributeKey)) {
            ((Set) AttributesKt.get(executionContext.getAttributes(), attributeKey)).remove(metric);
        }
    }

    @InternalApi
    public static final boolean containsBusinessMetric(ExecutionContext executionContext, BusinessMetric metric) {
        Intrinsics.checkNotNullParameter(executionContext, "<this>");
        Intrinsics.checkNotNullParameter(metric, "metric");
        MutableAttributes attributes = executionContext.getAttributes();
        AttributeKey<Set<BusinessMetric>> attributeKey = BusinessMetrics;
        return attributes.contains(attributeKey) && ((Set) AttributesKt.get(executionContext.getAttributes(), attributeKey)).contains(metric);
    }
}
