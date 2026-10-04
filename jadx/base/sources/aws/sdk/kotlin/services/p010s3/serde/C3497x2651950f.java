package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.LocationInfo;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.CreateBucketConfigurationPayloadSerializerKt$serializeCreateBucketConfigurationPayloadWithXmlNameCreateBucketConfiguration$1$2$1 */
/* JADX INFO: compiled from: CreateBucketConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3497x2651950f extends FunctionReferenceImpl implements Function2<Serializer, LocationInfo, Unit> {
    public static final C3497x2651950f INSTANCE = new C3497x2651950f();

    C3497x2651950f() {
        super(2, LocationInfoDocumentSerializerKt.class, "serializeLocationInfoDocument", "serializeLocationInfoDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/LocationInfo;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, LocationInfo locationInfo) {
        invoke2(serializer, locationInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, LocationInfo p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        LocationInfoDocumentSerializerKt.serializeLocationInfoDocument(p0, p1);
    }
}
