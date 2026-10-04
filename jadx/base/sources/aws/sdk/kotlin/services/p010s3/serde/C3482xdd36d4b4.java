package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.Owner;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.AccessControlPolicyPayloadSerializerKt$serializeAccessControlPolicyPayloadWithXmlNameAccessControlPolicy$1$2$1 */
/* JADX INFO: compiled from: AccessControlPolicyPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3482xdd36d4b4 extends FunctionReferenceImpl implements Function2<Serializer, Owner, Unit> {
    public static final C3482xdd36d4b4 INSTANCE = new C3482xdd36d4b4();

    C3482xdd36d4b4() {
        super(2, OwnerDocumentSerializerKt.class, "serializeOwnerDocument", "serializeOwnerDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/Owner;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, Owner owner) {
        invoke2(serializer, owner);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, Owner p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        OwnerDocumentSerializerKt.serializeOwnerDocument(p0, p1);
    }
}
