package aws.smithy.kotlin.runtime.http.response;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.ProtocolResponse;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import kotlin.Metadata;

/* JADX INFO: compiled from: HttpResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/ProtocolResponse;", NotificationCompat.CATEGORY_STATUS, "Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "getStatus", "()Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "headers", "Laws/smithy/kotlin/runtime/http/Headers;", "getHeaders", "()Laws/smithy/kotlin/runtime/http/Headers;", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/http/HttpBody;", "getBody", "()Laws/smithy/kotlin/runtime/http/HttpBody;", "Laws/smithy/kotlin/runtime/http/response/DefaultHttpResponse;", "Laws/smithy/kotlin/runtime/http/response/HttpResponseBuilderView;", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface HttpResponse extends ProtocolResponse {
    HttpBody getBody();

    Headers getHeaders();

    HttpStatusCode getStatus();
}
