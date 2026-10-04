package aws.smithy.kotlin.runtime.http;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: DeferredHeaders.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0016J&\u0010\u000f\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u00100\u000eH\u0016J\u0011\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0014\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0082\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/EmptyDeferredHeaders;", "Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "<init>", "()V", "caseInsensitiveName", "", "getCaseInsensitiveName", "()Z", "getAll", "", "Lkotlinx/coroutines/Deferred;", "", "name", "names", "", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "contains", "isEmpty", "equals", "other", "", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class EmptyDeferredHeaders implements DeferredHeaders {
    public static final EmptyDeferredHeaders INSTANCE = new EmptyDeferredHeaders();
    private static final boolean caseInsensitiveName = true;

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public boolean contains(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public boolean isEmpty() {
        return true;
    }

    private EmptyDeferredHeaders() {
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public /* bridge */ /* synthetic */ boolean contains(String str, Deferred<? extends String> deferred) {
        return contains2(str, (Deferred<String>) deferred);
    }

    /* JADX INFO: renamed from: contains, reason: avoid collision after fix types in other method */
    public /* bridge */ boolean contains2(String str, Deferred<String> deferred) {
        return super.contains(str, deferred);
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public /* bridge */ void forEach(Function2<? super String, ? super List<? extends Deferred<? extends String>>, Unit> function2) {
        super.forEach(function2);
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public /* bridge */ Deferred<? extends String> get(String str) {
        return (Deferred) super.get(str);
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public boolean getCaseInsensitiveName() {
        return caseInsensitiveName;
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public List<Deferred<? extends String>> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return CollectionsKt.emptyList();
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public Set<String> names() {
        return SetsKt.emptySet();
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public Set<Map.Entry<String, List<Deferred<? extends String>>>> entries() {
        return SetsKt.emptySet();
    }

    public boolean equals(Object other) {
        return (other instanceof DeferredHeaders) && ((DeferredHeaders) other).isEmpty();
    }
}
