package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.StorageClassAnalysis;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.AnalyticsConfigurationPayloadSerializerKt$serializeAnalyticsConfigurationPayloadWithXmlNameAnalyticsConfiguration$1$2$1 */
/* JADX INFO: compiled from: AnalyticsConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3485xb7ca3dcb extends FunctionReferenceImpl implements Function2<Serializer, StorageClassAnalysis, Unit> {
    public static final C3485xb7ca3dcb INSTANCE = new C3485xb7ca3dcb();

    C3485xb7ca3dcb() {
        super(2, StorageClassAnalysisDocumentSerializerKt.class, "serializeStorageClassAnalysisDocument", "serializeStorageClassAnalysisDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/StorageClassAnalysis;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, StorageClassAnalysis storageClassAnalysis) {
        invoke2(serializer, storageClassAnalysis);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, StorageClassAnalysis p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        StorageClassAnalysisDocumentSerializerKt.serializeStorageClassAnalysisDocument(p0, p1);
    }
}
