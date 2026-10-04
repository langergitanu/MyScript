package aws.sdk.kotlin.runtime.http.interceptors.businessmetrics;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsKt;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetric;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AwsBusinessMetricsUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007\u001a\u001a\u0010\n\u001a\u00020\b*\u00020\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007¨\u0006\f"}, m1599d2 = {"formatMetrics", "", "metrics", "", "Laws/smithy/kotlin/runtime/businessmetrics/BusinessMetric;", "logger", "Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", "withBusinessMetric", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "metric", "withBusinessMetrics", "", "aws-http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsBusinessMetricsUtilsKt {
    public static final String formatMetrics(Set<BusinessMetric> metrics, Logger logger) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(logger, "logger");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = metrics.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            final BusinessMetric businessMetric = (BusinessMetric) next;
            if (businessMetric.getIdentifier().length() > 2) {
                Logger.warn$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetricsUtilsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AwsBusinessMetricsUtilsKt.formatMetrics$lambda$0$0(businessMetric);
                    }
                }, 1, null);
            } else {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return "";
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList2, ",", "m/", null, 0, null, new Function1() { // from class: aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetricsUtilsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AwsBusinessMetricsUtilsKt.formatMetrics$lambda$1((BusinessMetric) obj);
            }
        }, 28, null);
        byte[] bArrEncodeToByteArray = StringsKt.encodeToByteArray(strJoinToString$default);
        if (bArrEncodeToByteArray.length <= 1024) {
            return strJoinToString$default;
        }
        byte[] bArrSliceArray = ArraysKt.sliceArray(bArrEncodeToByteArray, RangesKt.until(0, 1024));
        int length = bArrSliceArray.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (bArrSliceArray[length] == 44) {
                    break;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
            length = -1;
        } else {
            length = -1;
        }
        Integer numValueOf = Integer.valueOf(length);
        Integer num = numValueOf.intValue() != -1 ? numValueOf : null;
        if (num != null) {
            num.intValue();
            return StringsKt.decodeToString(bArrEncodeToByteArray, 0, num.intValue(), true);
        }
        throw new IllegalStateException("Business metrics are incorrectly formatted: " + strJoinToString$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatMetrics$lambda$0$0(BusinessMetric businessMetric) {
        return "Business metric '" + businessMetric.getIdentifier() + "' will be skipped due to length being > 2. This is likely a bug. Please raise an issue at https://github.com/awslabs/aws-sdk-kotlin/issues/new/choose";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence formatMetrics$lambda$1(BusinessMetric it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getIdentifier();
    }

    @InternalApi
    public static final Credentials withBusinessMetric(Credentials credentials, BusinessMetric metric) {
        Intrinsics.checkNotNullParameter(credentials, "<this>");
        Intrinsics.checkNotNullParameter(metric, "metric");
        Attributes attributes = credentials.getAttributes();
        if (attributes instanceof MutableAttributes) {
            BusinessMetricsUtilsKt.emitBusinessMetric((MutableAttributes) attributes, metric);
            return credentials;
        }
        MutableAttributes mutableAttributes = AttributesKt.toMutableAttributes(attributes);
        BusinessMetricsUtilsKt.emitBusinessMetric(mutableAttributes, metric);
        return CredentialsKt.copy$default(credentials, null, null, null, null, null, mutableAttributes, 31, null);
    }

    @InternalApi
    public static final Credentials withBusinessMetrics(Credentials credentials, Set<? extends BusinessMetric> metrics) {
        Intrinsics.checkNotNullParameter(credentials, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Iterator<T> it = metrics.iterator();
        Credentials credentialsWithBusinessMetric = credentials;
        while (it.hasNext()) {
            credentialsWithBusinessMetric = withBusinessMetric(credentials, (BusinessMetric) it.next());
        }
        return credentialsWithBusinessMetric;
    }
}
