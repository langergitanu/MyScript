package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.JsonInput;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.InputSerializationDocumentSerializerKt$serializeInputSerializationDocument$1$3$1 */
/* JADX INFO: compiled from: InputSerializationDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3517xb170c362 extends FunctionReferenceImpl implements Function2<Serializer, JsonInput, Unit> {
    public static final C3517xb170c362 INSTANCE = new C3517xb170c362();

    C3517xb170c362() {
        super(2, JsonInputDocumentSerializerKt.class, "serializeJsonInputDocument", "serializeJsonInputDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/JsonInput;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, JsonInput jsonInput) {
        invoke2(serializer, jsonInput);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, JsonInput p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        JsonInputDocumentSerializerKt.serializeJsonInputDocument(p0, p1);
    }
}
