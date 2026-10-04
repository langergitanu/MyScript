package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.collections.ValuesMap;
import aws.smithy.kotlin.runtime.collections.ValuesMapBuilder;
import aws.smithy.kotlin.runtime.collections.ValuesMapKt;
import aws.smithy.kotlin.runtime.util.CanDeepCopy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: DeferredHeaders.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0000H\u0016J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/DeferredHeadersBuilder;", "Laws/smithy/kotlin/runtime/collections/ValuesMapBuilder;", "Lkotlinx/coroutines/Deferred;", "", "Laws/smithy/kotlin/runtime/util/CanDeepCopy;", "<init>", "()V", "build", "Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "deepCopy", "add", "", "name", "value", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DeferredHeadersBuilder extends ValuesMapBuilder<Deferred<? extends String>> implements CanDeepCopy<DeferredHeadersBuilder> {
    public DeferredHeadersBuilder() {
        super(true, 8);
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMapBuilder
    public ValuesMap<Deferred<? extends String>> build() {
        return new DeferredHeadersImpl(getValues());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // aws.smithy.kotlin.runtime.util.CanDeepCopy
    public DeferredHeadersBuilder deepCopy() {
        Map<? extends String, ? extends List<Deferred<? extends String>>> mapDeepCopy = ValuesMapKt.deepCopy(getValues());
        DeferredHeadersBuilder deferredHeadersBuilder = new DeferredHeadersBuilder();
        deferredHeadersBuilder.getValues().putAll(mapDeepCopy);
        return deferredHeadersBuilder;
    }

    public final void add(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        append(name, CompletableDeferredKt.CompletableDeferred(value));
    }
}
