package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.MetricsAndOperator;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.MetricsFilterDocumentSerializerKt$serializeMetricsFilterDocument$1$1 */
/* JADX INFO: compiled from: MetricsFilterDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3562xfa3f77c3 extends FunctionReferenceImpl implements Function2<Serializer, MetricsAndOperator, Unit> {
    public static final C3562xfa3f77c3 INSTANCE = new C3562xfa3f77c3();

    C3562xfa3f77c3() {
        super(2, MetricsAndOperatorDocumentSerializerKt.class, "serializeMetricsAndOperatorDocument", "serializeMetricsAndOperatorDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/MetricsAndOperator;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, MetricsAndOperator metricsAndOperator) {
        invoke2(serializer, metricsAndOperator);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, MetricsAndOperator p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        MetricsAndOperatorDocumentSerializerKt.serializeMetricsAndOperatorDocument(p0, p1);
    }
}
