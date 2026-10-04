package aws.smithy.kotlin.runtime.net.url;

import aws.smithy.kotlin.runtime.text.encoding.Encodable;
import aws.smithy.kotlin.runtime.text.encoding.Encoding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QueryParameters.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class QueryParameters$encodedParameters$4 extends FunctionReferenceImpl implements Function1<String, Encodable> {
    QueryParameters$encodedParameters$4(Object obj) {
        super(1, obj, Encoding.class, "encodableFromEncoded", "encodableFromEncoded(Ljava/lang/String;)Laws/smithy/kotlin/runtime/text/encoding/Encodable;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Encodable invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((Encoding) this.receiver).encodableFromEncoded(p0);
    }
}
