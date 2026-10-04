package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.LoggingEnabled;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.BucketLoggingStatusPayloadSerializerKt$serializeBucketLoggingStatusPayloadWithXmlNameBucketLoggingStatus$1$1$1 */
/* JADX INFO: compiled from: BucketLoggingStatusPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3491x94af0477 extends FunctionReferenceImpl implements Function2<Serializer, LoggingEnabled, Unit> {
    public static final C3491x94af0477 INSTANCE = new C3491x94af0477();

    C3491x94af0477() {
        super(2, LoggingEnabledDocumentSerializerKt.class, "serializeLoggingEnabledDocument", "serializeLoggingEnabledDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/LoggingEnabled;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, LoggingEnabled loggingEnabled) {
        invoke2(serializer, loggingEnabled);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, LoggingEnabled p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        LoggingEnabledDocumentSerializerKt.serializeLoggingEnabledDocument(p0, p1);
    }
}
