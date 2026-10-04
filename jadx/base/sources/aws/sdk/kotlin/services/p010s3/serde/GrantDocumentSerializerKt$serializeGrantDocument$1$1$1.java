package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.Grantee;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GrantDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class GrantDocumentSerializerKt$serializeGrantDocument$1$1$1 extends FunctionReferenceImpl implements Function2<Serializer, Grantee, Unit> {
    public static final GrantDocumentSerializerKt$serializeGrantDocument$1$1$1 INSTANCE = new GrantDocumentSerializerKt$serializeGrantDocument$1$1$1();

    GrantDocumentSerializerKt$serializeGrantDocument$1$1$1() {
        super(2, GranteeDocumentSerializerKt.class, "serializeGranteeDocument", "serializeGranteeDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/Grantee;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, Grantee grantee) {
        invoke2(serializer, grantee);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, Grantee p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        GranteeDocumentSerializerKt.serializeGranteeDocument(p0, p1);
    }
}
