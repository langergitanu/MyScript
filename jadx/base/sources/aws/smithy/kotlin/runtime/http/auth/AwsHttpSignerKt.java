package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.text.encoding.Encodable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsHttpSigner.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, m1599d2 = {"update", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "signedRequest", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "http-auth-aws"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsHttpSignerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void update(final HttpRequestBuilder httpRequestBuilder, HttpRequest httpRequest) {
        httpRequest.getHeaders().forEach(new Function2() { // from class: aws.smithy.kotlin.runtime.http.auth.AwsHttpSignerKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AwsHttpSignerKt.update$lambda$0(httpRequestBuilder, (String) obj, (List) obj2);
            }
        });
        Iterator it = httpRequest.getUrl().getParameters().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Encodable encodable = (Encodable) entry.getKey();
            List list = (List) entry.getValue();
            if (!httpRequestBuilder.getUrl().getParameters().containsKey((Object) encodable)) {
                httpRequestBuilder.getUrl().getParameters().addAll2(encodable, (Collection<Encodable>) list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit update$lambda$0(HttpRequestBuilder httpRequestBuilder, String key, List values) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(values, "values");
        httpRequestBuilder.getHeaders().appendMissing(key, values);
        return Unit.INSTANCE;
    }
}
