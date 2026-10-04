package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ServerSideEncryptionByDefault;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.ServerSideEncryptionRuleDocumentSerializerKt$serializeServerSideEncryptionRuleDocument$1$1$1 */
/* JADX INFO: compiled from: ServerSideEncryptionRuleDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3610xa6c8d086 extends FunctionReferenceImpl implements Function2<Serializer, ServerSideEncryptionByDefault, Unit> {
    public static final C3610xa6c8d086 INSTANCE = new C3610xa6c8d086();

    C3610xa6c8d086() {
        super(2, ServerSideEncryptionByDefaultDocumentSerializerKt.class, "serializeServerSideEncryptionByDefaultDocument", "serializeServerSideEncryptionByDefaultDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionByDefault;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, ServerSideEncryptionByDefault serverSideEncryptionByDefault) {
        invoke2(serializer, serverSideEncryptionByDefault);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, ServerSideEncryptionByDefault p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ServerSideEncryptionByDefaultDocumentSerializerKt.serializeServerSideEncryptionByDefaultDocument(p0, p1);
    }
}
