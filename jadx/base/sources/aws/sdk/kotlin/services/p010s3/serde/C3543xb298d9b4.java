package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.NoncurrentVersionExpiration;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.LifecycleRuleDocumentSerializerKt$serializeLifecycleRuleDocument$1$5$1 */
/* JADX INFO: compiled from: LifecycleRuleDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3543xb298d9b4 extends FunctionReferenceImpl implements Function2<Serializer, NoncurrentVersionExpiration, Unit> {
    public static final C3543xb298d9b4 INSTANCE = new C3543xb298d9b4();

    C3543xb298d9b4() {
        super(2, NoncurrentVersionExpirationDocumentSerializerKt.class, "serializeNoncurrentVersionExpirationDocument", "serializeNoncurrentVersionExpirationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/NoncurrentVersionExpiration;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, NoncurrentVersionExpiration noncurrentVersionExpiration) {
        invoke2(serializer, noncurrentVersionExpiration);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, NoncurrentVersionExpiration p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        NoncurrentVersionExpirationDocumentSerializerKt.serializeNoncurrentVersionExpirationDocument(p0, p1);
    }
}
