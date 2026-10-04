package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.Redirect;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.RoutingRuleDocumentSerializerKt$serializeRoutingRuleDocument$1$2$1 */
/* JADX INFO: compiled from: RoutingRuleDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3596x4e9bff1 extends FunctionReferenceImpl implements Function2<Serializer, Redirect, Unit> {
    public static final C3596x4e9bff1 INSTANCE = new C3596x4e9bff1();

    C3596x4e9bff1() {
        super(2, RedirectDocumentSerializerKt.class, "serializeRedirectDocument", "serializeRedirectDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/Redirect;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, Redirect redirect) {
        invoke2(serializer, redirect);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, Redirect p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        RedirectDocumentSerializerKt.serializeRedirectDocument(p0, p1);
    }
}
