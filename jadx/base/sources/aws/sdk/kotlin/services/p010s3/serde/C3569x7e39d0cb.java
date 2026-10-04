package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.SsekmsEncryption;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.ObjectEncryptionDocumentSerializerKt$serializeObjectEncryptionDocument$1$1 */
/* JADX INFO: compiled from: ObjectEncryptionDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3569x7e39d0cb extends FunctionReferenceImpl implements Function2<Serializer, SsekmsEncryption, Unit> {
    public static final C3569x7e39d0cb INSTANCE = new C3569x7e39d0cb();

    C3569x7e39d0cb() {
        super(2, SsekmsEncryptionDocumentSerializerKt.class, "serializeSsekmsEncryptionDocument", "serializeSsekmsEncryptionDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/SsekmsEncryption;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, SsekmsEncryption ssekmsEncryption) {
        invoke2(serializer, ssekmsEncryption);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, SsekmsEncryption p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        SsekmsEncryptionDocumentSerializerKt.serializeSsekmsEncryptionDocument(p0, p1);
    }
}
