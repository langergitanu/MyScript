package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.S3KeyFilter;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.NotificationConfigurationFilterDocumentSerializerKt$serializeNotificationConfigurationFilterDocument$1$1$1 */
/* JADX INFO: compiled from: NotificationConfigurationFilterDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3564x9f123dd0 extends FunctionReferenceImpl implements Function2<Serializer, S3KeyFilter, Unit> {
    public static final C3564x9f123dd0 INSTANCE = new C3564x9f123dd0();

    C3564x9f123dd0() {
        super(2, S3KeyFilterDocumentSerializerKt.class, "serializeS3KeyFilterDocument", "serializeS3KeyFilterDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/S3KeyFilter;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, S3KeyFilter s3KeyFilter) {
        invoke2(serializer, s3KeyFilter);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, S3KeyFilter p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        S3KeyFilterDocumentSerializerKt.serializeS3KeyFilterDocument(p0, p1);
    }
}
