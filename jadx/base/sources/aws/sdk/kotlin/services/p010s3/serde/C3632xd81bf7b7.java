package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.RedirectAllRequestsTo;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.WebsiteConfigurationPayloadSerializerKt$serializeWebsiteConfigurationPayloadWithXmlNameWebsiteConfiguration$1$3$1 */
/* JADX INFO: compiled from: WebsiteConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3632xd81bf7b7 extends FunctionReferenceImpl implements Function2<Serializer, RedirectAllRequestsTo, Unit> {
    public static final C3632xd81bf7b7 INSTANCE = new C3632xd81bf7b7();

    C3632xd81bf7b7() {
        super(2, RedirectAllRequestsToDocumentSerializerKt.class, "serializeRedirectAllRequestsToDocument", "serializeRedirectAllRequestsToDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/RedirectAllRequestsTo;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, RedirectAllRequestsTo redirectAllRequestsTo) {
        invoke2(serializer, redirectAllRequestsTo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, RedirectAllRequestsTo p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        RedirectAllRequestsToDocumentSerializerKt.serializeRedirectAllRequestsToDocument(p0, p1);
    }
}
