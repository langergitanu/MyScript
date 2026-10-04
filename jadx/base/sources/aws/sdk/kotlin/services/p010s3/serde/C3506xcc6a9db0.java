package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.AccessControlTranslation;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.DestinationDocumentSerializerKt$serializeDestinationDocument$1$1$1 */
/* JADX INFO: compiled from: DestinationDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3506xcc6a9db0 extends FunctionReferenceImpl implements Function2<Serializer, AccessControlTranslation, Unit> {
    public static final C3506xcc6a9db0 INSTANCE = new C3506xcc6a9db0();

    C3506xcc6a9db0() {
        super(2, AccessControlTranslationDocumentSerializerKt.class, "serializeAccessControlTranslationDocument", "serializeAccessControlTranslationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/AccessControlTranslation;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, AccessControlTranslation accessControlTranslation) {
        invoke2(serializer, accessControlTranslation);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, AccessControlTranslation p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        AccessControlTranslationDocumentSerializerKt.serializeAccessControlTranslationDocument(p0, p1);
    }
}
