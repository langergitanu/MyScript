package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.AnalyticsExportDestination;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.StorageClassAnalysisDataExportDocumentSerializerKt$serializeStorageClassAnalysisDataExportDocument$1$1$1 */
/* JADX INFO: compiled from: StorageClassAnalysisDataExportDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3614xf32f7182 extends FunctionReferenceImpl implements Function2<Serializer, AnalyticsExportDestination, Unit> {
    public static final C3614xf32f7182 INSTANCE = new C3614xf32f7182();

    C3614xf32f7182() {
        super(2, AnalyticsExportDestinationDocumentSerializerKt.class, "serializeAnalyticsExportDestinationDocument", "serializeAnalyticsExportDestinationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/AnalyticsExportDestination;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, AnalyticsExportDestination analyticsExportDestination) {
        invoke2(serializer, analyticsExportDestination);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, AnalyticsExportDestination p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        AnalyticsExportDestinationDocumentSerializerKt.serializeAnalyticsExportDestinationDocument(p0, p1);
    }
}
