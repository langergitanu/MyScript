package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.LifecycleExpiration;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.LifecycleRuleDocumentSerializerKt$serializeLifecycleRuleDocument$1$2$1 */
/* JADX INFO: compiled from: LifecycleRuleDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3541xb298ce71 extends FunctionReferenceImpl implements Function2<Serializer, LifecycleExpiration, Unit> {
    public static final C3541xb298ce71 INSTANCE = new C3541xb298ce71();

    C3541xb298ce71() {
        super(2, LifecycleExpirationDocumentSerializerKt.class, "serializeLifecycleExpirationDocument", "serializeLifecycleExpirationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/LifecycleExpiration;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, LifecycleExpiration lifecycleExpiration) {
        invoke2(serializer, lifecycleExpiration);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, LifecycleExpiration p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        LifecycleExpirationDocumentSerializerKt.serializeLifecycleExpirationDocument(p0, p1);
    }
}
