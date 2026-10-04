package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.AnalyticsS3BucketDestination;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.AnalyticsExportDestinationDocumentSerializerKt$serializeAnalyticsExportDestinationDocument$1$1$1 */
/* JADX INFO: compiled from: AnalyticsExportDestinationDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3486xcef109fc extends FunctionReferenceImpl implements Function2<Serializer, AnalyticsS3BucketDestination, Unit> {
    public static final C3486xcef109fc INSTANCE = new C3486xcef109fc();

    C3486xcef109fc() {
        super(2, AnalyticsS3BucketDestinationDocumentSerializerKt.class, "serializeAnalyticsS3BucketDestinationDocument", "serializeAnalyticsS3BucketDestinationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/AnalyticsS3BucketDestination;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, AnalyticsS3BucketDestination analyticsS3BucketDestination) {
        invoke2(serializer, analyticsS3BucketDestination);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, AnalyticsS3BucketDestination p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        AnalyticsS3BucketDestinationDocumentSerializerKt.serializeAnalyticsS3BucketDestinationDocument(p0, p1);
    }
}
