package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.collections.ValuesMap;
import aws.smithy.kotlin.runtime.collections.ValuesMapBuilder;
import aws.smithy.kotlin.runtime.collections.ValuesMapKt;
import aws.smithy.kotlin.runtime.util.CanDeepCopy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0006\u001a\u00020\u0002H\u0096\u0080\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0000H\u0016¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HeadersBuilder;", "Laws/smithy/kotlin/runtime/collections/ValuesMapBuilder;", "", "Laws/smithy/kotlin/runtime/util/CanDeepCopy;", "<init>", "()V", "toString", "build", "Laws/smithy/kotlin/runtime/http/Headers;", "deepCopy", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HeadersBuilder extends ValuesMapBuilder<String> implements CanDeepCopy<HeadersBuilder> {
    public HeadersBuilder() {
        super(true, 8);
    }

    public String toString() {
        return "HeadersBuilder " + entries() + TokenParser.f2383SP;
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMapBuilder
    public ValuesMap<String> build() {
        return new HeadersImpl(getValues());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // aws.smithy.kotlin.runtime.util.CanDeepCopy
    public HeadersBuilder deepCopy() {
        Map<? extends String, ? extends List<String>> mapDeepCopy = ValuesMapKt.deepCopy(getValues());
        HeadersBuilder headersBuilder = new HeadersBuilder();
        headersBuilder.getValues().putAll(mapDeepCopy);
        return headersBuilder;
    }
}
