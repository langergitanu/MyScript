package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.Headers;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OkHttpHeadersAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010&\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0016J \u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00110\u000fH\u0016J\u0011\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpHeadersAdapter;", "Laws/smithy/kotlin/runtime/http/Headers;", "headers", "Lokhttp3/Headers;", "<init>", "(Lokhttp3/Headers;)V", "caseInsensitiveName", "", "getCaseInsensitiveName", "()Z", "getAll", "", "", "name", "names", "", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "contains", "isEmpty", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OkHttpHeadersAdapter implements Headers {
    private final boolean caseInsensitiveName;
    private final okhttp3.Headers headers;

    public OkHttpHeadersAdapter(okhttp3.Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.headers = headers;
        this.caseInsensitiveName = true;
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public /* bridge */ boolean contains(String str, String str2) {
        return super.contains(str, str2);
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public /* bridge */ void forEach(Function2<? super String, ? super List<? extends String>, Unit> function2) {
        super.forEach(function2);
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public /* bridge */ String get(String str) {
        return (String) super.get(str);
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public List<String> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<String> listValues = this.headers.values(name);
        if (listValues.isEmpty()) {
            listValues = null;
        }
        return listValues;
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public Set<String> names() {
        return this.headers.names();
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public Set<Map.Entry<String, List<String>>> entries() {
        return this.headers.toMultimap().entrySet();
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public boolean contains(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.headers.get(name) != null;
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public boolean isEmpty() {
        return this.headers.size() == 0;
    }
}
