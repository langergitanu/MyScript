package aws.smithy.kotlin.runtime.net.url;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.collections.MultiMap;
import aws.smithy.kotlin.runtime.collections.MutableMultiMap;
import aws.smithy.kotlin.runtime.collections.MutableMultiMapKt;
import aws.smithy.kotlin.runtime.collections.views.ConvertersKt;
import aws.smithy.kotlin.runtime.net.url.QueryParameters;
import aws.smithy.kotlin.runtime.net.url.UrlEncoding;
import aws.smithy.kotlin.runtime.text.encoding.Encodable;
import aws.smithy.kotlin.runtime.text.encoding.Encoding;
import aws.smithy.kotlin.runtime.text.encoding.PercentEncoding;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: QueryParameters.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0006\u0018\u0000 >2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0002>?B%\b\u0002\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0082\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u000fH\u0096\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u00020\u0012H\u0096\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002H\u0096\u0081\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0096\u0081\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b2\u0006\u0010\u0015\u001a\u00020\u0002H\u0096\u0083\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010 \u001a\u00020\u0004H\u0096\u0081\u0004¢\u0006\u0004\b \u0010!J\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\"H\u0096\u0001¢\u0006\u0004\b#\u0010$R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010!R\u001d\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00018F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001d\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00018F¢\u0006\u0006\u001a\u0004\b+\u0010)R-\u00101\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001b0.0-8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b/\u00100R&\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020.028\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b3\u00104R\u001b\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020-8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b6\u00100R\u0015\u00109\u001a\u00020\u000f8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b8\u0010\u0011R!\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001b0:8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006@"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/QueryParameters;", "Laws/smithy/kotlin/runtime/collections/MultiMap;", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "delegate", "", "forceQuerySeparator", "<init>", "(Laws/smithy/kotlin/runtime/collections/MultiMap;Z)V", "Laws/smithy/kotlin/runtime/net/url/QueryParameters$Builder;", "toBuilder", "()Laws/smithy/kotlin/runtime/net/url/QueryParameters$Builder;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", SubscriberAttributeKt.JSON_NAME_KEY, "value", "contains", "(Laws/smithy/kotlin/runtime/text/encoding/Encodable;Laws/smithy/kotlin/runtime/text/encoding/Encodable;)Z", "containsKey", "(Laws/smithy/kotlin/runtime/text/encoding/Encodable;)Z", "", "containsValue", "(Ljava/util/List;)Z", "get", "(Laws/smithy/kotlin/runtime/text/encoding/Encodable;)Ljava/util/List;", "isEmpty", "()Z", "Laws/smithy/kotlin/runtime/collections/MutableMultiMap;", "toMutableMultiMap", "()Laws/smithy/kotlin/runtime/collections/MutableMultiMap;", "Laws/smithy/kotlin/runtime/collections/MultiMap;", "Z", "getForceQuerySeparator", "getDecodedParameters", "()Laws/smithy/kotlin/runtime/collections/MultiMap;", "decodedParameters", "getEncodedParameters", "encodedParameters", "", "", "getEntries", "()Ljava/util/Set;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "Lkotlin/sequences/Sequence;", "getEntryValues", "()Lkotlin/sequences/Sequence;", "entryValues", "getKeys", UserMetadata.KEYDATA_FILENAME, "getSize", "size", "", "getValues", "()Ljava/util/Collection;", "values", "Companion", "Builder", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class QueryParameters implements MultiMap<Encodable, Encodable> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final QueryParameters Empty = new Builder().build();
    private final MultiMap<Encodable, Encodable> delegate;
    private final boolean forceQuerySeparator;

    public /* synthetic */ QueryParameters(MultiMap multiMap, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiMap, z);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<Encodable> compute(Encodable encodable, BiFunction<? super Encodable, ? super List<Encodable>, ? extends List<Encodable>> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<Encodable> computeIfAbsent(Encodable encodable, Function<? super Encodable, ? extends List<Encodable>> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<Encodable> computeIfPresent(Encodable encodable, BiFunction<? super Encodable, ? super List<Encodable>, ? extends List<Encodable>> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // aws.smithy.kotlin.runtime.collections.MultiMap
    public boolean contains(Encodable key, Encodable value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.delegate.contains(key, value);
    }

    public boolean containsKey(Encodable key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.delegate.containsKey(key);
    }

    public boolean containsValue(List<Encodable> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.delegate.containsValue(value);
    }

    public List<Encodable> get(Encodable key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (List) this.delegate.get(key);
    }

    public Set<Map.Entry<Encodable, List<Encodable>>> getEntries() {
        return this.delegate.entrySet();
    }

    @Override // aws.smithy.kotlin.runtime.collections.MultiMap
    public Sequence<Map.Entry<Encodable, Encodable>> getEntryValues() {
        return this.delegate.getEntryValues();
    }

    public Set<Encodable> getKeys() {
        return this.delegate.keySet();
    }

    public int getSize() {
        return this.delegate.size();
    }

    public Collection<List<Encodable>> getValues() {
        return this.delegate.values();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<Encodable> merge(Encodable encodable, List<Encodable> list, BiFunction<? super List<Encodable>, ? super List<Encodable>, ? extends List<Encodable>> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<Encodable> put(Encodable encodable, List<Encodable> list) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Encodable, ? extends List<? extends Encodable>> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<Encodable> putIfAbsent(Encodable encodable, List<Encodable> list) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public List<Encodable> remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<Encodable> replace(Encodable encodable, List<Encodable> list) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean replace(Encodable encodable, List<Encodable> list, List<Encodable> list2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super Encodable, ? super List<Encodable>, ? extends List<Encodable>> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // aws.smithy.kotlin.runtime.collections.MultiMap
    public MutableMultiMap<Encodable, Encodable> toMutableMultiMap() {
        return this.delegate.toMutableMultiMap();
    }

    private QueryParameters(MultiMap<Encodable, Encodable> multiMap, boolean z) {
        this.delegate = multiMap;
        this.forceQuerySeparator = z;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof Encodable) {
            return containsKey((Encodable) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof List) {
            return containsValue((List<Encodable>) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<Encodable, List<Encodable>>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof Encodable) {
            return get((Encodable) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ List<Encodable> get(Object obj) {
        if (obj instanceof Encodable) {
            return get((Encodable) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Encodable> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<List<Encodable>> values() {
        return getValues();
    }

    public final boolean getForceQuerySeparator() {
        return this.forceQuerySeparator;
    }

    /* JADX INFO: compiled from: QueryParameters.kt */
    @Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\n\u001a\u00020\t2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\nø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0013\u001a\u00020\u00122\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0015\u001a\u00020\u00122\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0014JE\u0010\u0017\u001a\u00020\u00122\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/QueryParameters$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/net/url/QueryParameters$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Laws/smithy/kotlin/runtime/net/url/QueryParameters;", "invoke", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/net/url/QueryParameters;", "Lkotlin/sequences/Sequence;", "", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "values", "", "forceQuerySeparator", "", "asDecoded", "(Lkotlin/sequences/Sequence;Z)Ljava/lang/String;", "asEncoded", "encodableForm", "asString", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)Ljava/lang/String;", "decoded", "parseDecoded", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/net/url/QueryParameters;", "encoded", "parseEncoded", "Empty", "Laws/smithy/kotlin/runtime/net/url/QueryParameters;", "getEmpty", "()Laws/smithy/kotlin/runtime/net/url/QueryParameters;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final QueryParameters getEmpty() {
            return QueryParameters.Empty;
        }

        public final QueryParameters invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String asDecoded(Sequence<? extends Map.Entry<Encodable, Encodable>> values, boolean forceQuerySeparator) {
            return asString(values, forceQuerySeparator, new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.QueryParameters$Companion$asDecoded$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((Encodable) obj).getDecoded();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String asEncoded(Sequence<? extends Map.Entry<Encodable, Encodable>> values, boolean forceQuerySeparator) {
            return asString(values, forceQuerySeparator, new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.QueryParameters$Companion$asEncoded$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((Encodable) obj).getEncoded();
                }
            });
        }

        private final String asString(Sequence<? extends Map.Entry<Encodable, Encodable>> values, boolean forceQuerySeparator, final Function1<? super Encodable, String> encodableForm) {
            return SequencesKt.joinToString$default(values, "&", (forceQuerySeparator || SequencesKt.any(values)) ? "?" : "", null, 0, null, new Function1() { // from class: aws.smithy.kotlin.runtime.net.url.QueryParameters$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return QueryParameters.Companion.asString$lambda$0(encodableForm, (Map.Entry) obj);
                }
            }, 28, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence asString$lambda$0(Function1 function1, Map.Entry entry) {
            Intrinsics.checkNotNullParameter(entry, "<destruct>");
            return ((String) function1.invoke((Encodable) entry.getKey())) + Literals.PROPERTY_SPLITTER + ((String) function1.invoke((Encodable) entry.getValue()));
        }

        public final QueryParameters parseDecoded(String decoded) {
            Intrinsics.checkNotNullParameter(decoded, "decoded");
            Companion companion = QueryParameters.INSTANCE;
            Builder builder = new Builder();
            builder.parseDecoded$runtime_core(decoded);
            return builder.build();
        }

        public final QueryParameters parseEncoded(String encoded) {
            Intrinsics.checkNotNullParameter(encoded, "encoded");
            Companion companion = QueryParameters.INSTANCE;
            Builder builder = new Builder();
            builder.parseEncoded$runtime_core(encoded);
            return builder.build();
        }
    }

    public final Builder toBuilder() {
        return new Builder(this.delegate.toMutableMultiMap(), this.forceQuerySeparator);
    }

    public final MultiMap<String, String> getDecodedParameters() {
        return ConvertersKt.asView((MultiMap) this, (Function1) new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.QueryParameters$decodedParameters$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((Encodable) obj).getDecoded();
            }
        }, (Function1) new QueryParameters$decodedParameters$2(PercentEncoding.INSTANCE.getQuery()), (Function1) new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.QueryParameters$decodedParameters$3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((Encodable) obj).getDecoded();
            }
        }, (Function1) new QueryParameters$decodedParameters$4(PercentEncoding.INSTANCE.getQuery()));
    }

    public final MultiMap<String, String> getEncodedParameters() {
        return ConvertersKt.asView((MultiMap) this, (Function1) new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.QueryParameters$encodedParameters$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((Encodable) obj).getEncoded();
            }
        }, (Function1) new QueryParameters$encodedParameters$2(PercentEncoding.INSTANCE.getQuery()), (Function1) new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.QueryParameters$encodedParameters$3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((Encodable) obj).getEncoded();
            }
        }, (Function1) new QueryParameters$encodedParameters$4(PercentEncoding.INSTANCE.getQuery()));
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        QueryParameters queryParameters = (QueryParameters) other;
        return Intrinsics.areEqual(this.delegate, queryParameters.delegate) && this.forceQuerySeparator == queryParameters.forceQuerySeparator;
    }

    @Override // java.util.Map
    public int hashCode() {
        return (this.delegate.hashCode() * 31) + Boolean.hashCode(this.forceQuerySeparator);
    }

    public String toString() {
        return INSTANCE.asEncoded(this.delegate.getEntryValues(), this.forceQuerySeparator);
    }

    /* JADX INFO: compiled from: QueryParameters.kt */
    @Metadata(m1598d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u001f\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0000\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\u001f\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0016\u0010\u0013J+\u0010\u001a\u001a\u00020\r2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00012\u0006\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ8\u0010\u001f\u001a\u00020\r2#\u0010\u001e\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0004\u0012\u00020\r0\u001c¢\u0006\u0002\b\u001dH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J<\u0010\u001f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020!2#\u0010\u001e\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0004\u0012\u00020\r0\u001c¢\u0006\u0002\b\u001dH\u0007¢\u0006\u0004\b\u001f\u0010\"J8\u0010#\u001a\u00020\r2#\u0010\u001e\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0004\u0012\u00020\r0\u001c¢\u0006\u0002\b\u001dH\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010 J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b(\u0010)J\u0015\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0000¢\u0006\u0004\b(\u0010*J \u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b,\u0010-J(\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.2\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b,\u00100J&\u00103\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00022\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000201H\u0096\u0001¢\u0006\u0004\b3\u00104J.\u00103\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000201H\u0096\u0001¢\u0006\u0004\b3\u00105J*\u00103\u001a\u00020\r2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020706H\u0096\u0001¢\u0006\u0004\b3\u00108J\u0011\u00109\u001a\u00020\rH\u0096\u0081\u0004¢\u0006\u0004\b9\u0010\bJ \u0010:\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b:\u0010-J\u0019\u0010;\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0096\u0081\u0004¢\u0006\u0004\b;\u0010<J\u001f\u0010>\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020=H\u0096\u0081\u0004¢\u0006\u0004\b>\u0010?J!\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010=2\u0006\u0010+\u001a\u00020\u0002H\u0096\u0083\u0004¢\u0006\u0004\b@\u0010AJ\u0011\u0010B\u001a\u00020\u0004H\u0096\u0081\u0004¢\u0006\u0004\bB\u0010CJ(\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010=2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\bD\u0010EJ/\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010=2\u0006\u0010+\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020=H\u0097\u0081\b¢\u0006\u0004\bD\u0010FJ-\u0010H\u001a\u00020\r2\u001a\u0010G\u001a\u0016\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020=06H\u0096\u0081\u0004¢\u0006\u0004\bH\u00108J \u0010J\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0097\u0001¢\u0006\u0004\bI\u0010-J!\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010=2\u0006\u0010+\u001a\u00020\u0002H\u0097\u0081\b¢\u0006\u0004\bJ\u0010AJ(\u0010K\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020\u00022\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000201H\u0096\u0001¢\u0006\u0004\bK\u0010LJ\"\u0010M\u001a\u0004\u0018\u00010\u00022\u0006\u0010+\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0096\u0001¢\u0006\u0004\bM\u0010NJ(\u0010O\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020\u00022\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000201H\u0096\u0001¢\u0006\u0004\bO\u0010LJ\u001c\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020PH\u0096\u0001¢\u0006\u0004\bQ\u0010RR \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010SR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010T\u001a\u0004\bU\u0010C\"\u0004\bV\u0010WR$\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010\u0013R$\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010Y\"\u0004\b\\\u0010\u0013R#\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00018\u0006¢\u0006\f\n\u0004\b\u001f\u0010S\u001a\u0004\b]\u0010^R#\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00018\u0006¢\u0006\f\n\u0004\b#\u0010S\u001a\u0004\b_\u0010^R-\u0010d\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020=0a0`8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\bb\u0010cR&\u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020f0e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bg\u0010hR\u001b\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00020`8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\bj\u0010cR\u0015\u0010n\u001a\u00020.8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\bl\u0010mR!\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020=0o8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\bp\u0010q\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006r"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/QueryParameters$Builder;", "Laws/smithy/kotlin/runtime/collections/MutableMultiMap;", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "delegate", "", "forceQuerySeparator", "<init>", "(Laws/smithy/kotlin/runtime/collections/MutableMultiMap;Z)V", "()V", "", "value", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding;", "encoding", "", "parse$runtime_core", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/net/url/UrlEncoding;)V", "parse", "decoded", "parseDecoded$runtime_core", "(Ljava/lang/String;)V", "parseDecoded", "encoded", "parseEncoded$runtime_core", "parseEncoded", "map", "text", "parseInto", "(Laws/smithy/kotlin/runtime/collections/MutableMultiMap;Ljava/lang/String;)V", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "decodedParameters", "(Lkotlin/jvm/functions/Function1;)V", "Laws/smithy/kotlin/runtime/text/encoding/Encoding;", "(Laws/smithy/kotlin/runtime/text/encoding/Encoding;Lkotlin/jvm/functions/Function1;)V", "encodedParameters", "Laws/smithy/kotlin/runtime/net/url/QueryParameters;", "build", "()Laws/smithy/kotlin/runtime/net/url/QueryParameters;", "other", "copyFrom", "(Laws/smithy/kotlin/runtime/net/url/QueryParameters;)V", "(Laws/smithy/kotlin/runtime/net/url/QueryParameters$Builder;)V", SubscriberAttributeKt.JSON_NAME_KEY, "add", "(Laws/smithy/kotlin/runtime/text/encoding/Encodable;Laws/smithy/kotlin/runtime/text/encoding/Encodable;)Z", "", FirebaseAnalytics.Param.INDEX, "(Laws/smithy/kotlin/runtime/text/encoding/Encodable;ILaws/smithy/kotlin/runtime/text/encoding/Encodable;)V", "", "values", "addAll", "(Laws/smithy/kotlin/runtime/text/encoding/Encodable;Ljava/util/Collection;)Z", "(Laws/smithy/kotlin/runtime/text/encoding/Encodable;ILjava/util/Collection;)Z", "", "", "(Ljava/util/Map;)V", "clear", "contains", "containsKey", "(Laws/smithy/kotlin/runtime/text/encoding/Encodable;)Z", "", "containsValue", "(Ljava/util/List;)Z", "get", "(Laws/smithy/kotlin/runtime/text/encoding/Encodable;)Ljava/util/List;", "isEmpty", "()Z", "put", "(Laws/smithy/kotlin/runtime/text/encoding/Encodable;Laws/smithy/kotlin/runtime/text/encoding/Encodable;)Ljava/util/List;", "(Laws/smithy/kotlin/runtime/text/encoding/Encodable;Ljava/util/List;)Ljava/util/List;", TypedValues.TransitionType.S_FROM, "putAll", "removeElement", "remove", "removeAll", "(Laws/smithy/kotlin/runtime/text/encoding/Encodable;Ljava/util/Collection;)Ljava/lang/Boolean;", "removeAt", "(Laws/smithy/kotlin/runtime/text/encoding/Encodable;I)Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "retainAll", "Laws/smithy/kotlin/runtime/collections/MultiMap;", "toMultiMap", "()Laws/smithy/kotlin/runtime/collections/MultiMap;", "Laws/smithy/kotlin/runtime/collections/MutableMultiMap;", "Z", "getForceQuerySeparator", "setForceQuerySeparator", "(Z)V", "getDecoded", "()Ljava/lang/String;", "setDecoded", "getEncoded", "setEncoded", "getDecodedParameters", "()Laws/smithy/kotlin/runtime/collections/MutableMultiMap;", "getEncodedParameters", "", "", "getEntries", "()Ljava/util/Set;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "Lkotlin/sequences/Sequence;", "", "getEntryValues", "()Lkotlin/sequences/Sequence;", "entryValues", "getKeys", UserMetadata.KEYDATA_FILENAME, "getSize", "()I", "size", "", "getValues", "()Ljava/util/Collection;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder implements MutableMultiMap<Encodable, Encodable> {
        private final MutableMultiMap<String, String> decodedParameters;
        private final MutableMultiMap<Encodable, Encodable> delegate;
        private final MutableMultiMap<String, String> encodedParameters;
        private boolean forceQuerySeparator;

        @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
        public void add(Encodable key, int index, Encodable value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.delegate.add(key, index, value);
        }

        @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
        public boolean add(Encodable key, Encodable value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return this.delegate.add(key, value);
        }

        @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
        public void addAll(Map<Encodable, ? extends List<? extends Encodable>> other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.delegate.addAll(other);
        }

        /* JADX INFO: renamed from: addAll, reason: avoid collision after fix types in other method */
        public boolean addAll2(Encodable key, int index, Collection<Encodable> values) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(values, "values");
            return this.delegate.addAll(key, index, values);
        }

        /* JADX INFO: renamed from: addAll, reason: avoid collision after fix types in other method */
        public boolean addAll2(Encodable key, Collection<Encodable> values) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(values, "values");
            return this.delegate.addAll(key, values);
        }

        @Override // java.util.Map
        public void clear() {
            this.delegate.clear();
        }

        @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
        public boolean contains(Encodable key, Encodable value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return this.delegate.contains(key, value);
        }

        public boolean containsKey(Encodable key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this.delegate.containsKey(key);
        }

        public boolean containsValue(List<Encodable> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return this.delegate.containsValue(value);
        }

        public List<Encodable> get(Encodable key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return (List) this.delegate.get(key);
        }

        public Set<Map.Entry<Encodable, List<Encodable>>> getEntries() {
            return this.delegate.entrySet();
        }

        @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
        public Sequence<Map.Entry<Encodable, Encodable>> getEntryValues() {
            return this.delegate.getEntryValues();
        }

        public Set<Encodable> getKeys() {
            return this.delegate.keySet();
        }

        public int getSize() {
            return this.delegate.size();
        }

        public Collection<List<Encodable>> getValues() {
            return this.delegate.values();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.delegate.isEmpty();
        }

        @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap, java.util.Map
        public List<Encodable> put(Encodable key, Encodable value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return this.delegate.put(key, value);
        }

        @Override // java.util.Map
        @IgnorableReturnValue
        public List<Encodable> put(Encodable key, List<Encodable> value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return this.delegate.put(key, value);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Encodable, ? extends List<Encodable>> from) {
            Intrinsics.checkNotNullParameter(from, "from");
            this.delegate.putAll(from);
        }

        @IgnorableReturnValue
        public List<Encodable> remove(Encodable key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return (List) this.delegate.remove(key);
        }

        /* JADX INFO: renamed from: removeAll, reason: avoid collision after fix types in other method */
        public Boolean removeAll2(Encodable key, Collection<Encodable> values) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(values, "values");
            return this.delegate.removeAll(key, values);
        }

        @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
        public Encodable removeAt(Encodable key, int index) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this.delegate.removeAt(key, index);
        }

        @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
        public boolean removeElement(Encodable key, Encodable value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return this.delegate.removeElement(key, value);
        }

        /* JADX INFO: renamed from: retainAll, reason: avoid collision after fix types in other method */
        public Boolean retainAll2(Encodable key, Collection<Encodable> values) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(values, "values");
            return this.delegate.retainAll(key, values);
        }

        @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
        public MultiMap<Encodable, Encodable> toMultiMap() {
            return this.delegate.toMultiMap();
        }

        public Builder(MutableMultiMap<Encodable, Encodable> delegate, boolean z) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.delegate = delegate;
            this.forceQuerySeparator = z;
            Builder builder = this;
            this.decodedParameters = ConvertersKt.asView((MutableMultiMap) builder, (Function1) new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.QueryParameters$Builder$decodedParameters$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((Encodable) obj).getDecoded();
                }
            }, (Function1) new QueryParameters$Builder$decodedParameters$2(PercentEncoding.INSTANCE.getQuery()), (Function1) new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.QueryParameters$Builder$decodedParameters$3
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((Encodable) obj).getDecoded();
                }
            }, (Function1) new QueryParameters$Builder$decodedParameters$4(PercentEncoding.INSTANCE.getQuery()));
            this.encodedParameters = ConvertersKt.asView((MutableMultiMap) builder, (Function1) new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.QueryParameters$Builder$encodedParameters$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((Encodable) obj).getEncoded();
                }
            }, (Function1) new QueryParameters$Builder$encodedParameters$2(PercentEncoding.INSTANCE.getQuery()), (Function1) new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.QueryParameters$Builder$encodedParameters$3
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((Encodable) obj).getEncoded();
                }
            }, (Function1) new QueryParameters$Builder$encodedParameters$4(PercentEncoding.INSTANCE.getQuery()));
        }

        public /* synthetic */ Builder(MutableMultiMap mutableMultiMap, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(mutableMultiMap, (i & 2) != 0 ? false : z);
        }

        @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
        public /* bridge */ /* synthetic */ boolean addAll(Encodable encodable, int i, Collection<? extends Encodable> collection) {
            return addAll2(encodable, i, (Collection<Encodable>) collection);
        }

        @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
        public /* bridge */ /* synthetic */ boolean addAll(Encodable encodable, Collection<? extends Encodable> collection) {
            return addAll2(encodable, (Collection<Encodable>) collection);
        }

        @Override // java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof Encodable) {
                return containsKey((Encodable) obj);
            }
            return false;
        }

        @Override // java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (TypeIntrinsics.isMutableList(obj)) {
                return containsValue((List<Encodable>) obj);
            }
            return false;
        }

        @Override // java.util.Map
        public final /* bridge */ Set<Map.Entry<Encodable, List<Encodable>>> entrySet() {
            return getEntries();
        }

        @Override // java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof Encodable) {
                return get((Encodable) obj);
            }
            return null;
        }

        @Override // java.util.Map
        public final /* bridge */ List<Encodable> get(Object obj) {
            if (obj instanceof Encodable) {
                return get((Encodable) obj);
            }
            return null;
        }

        @Override // java.util.Map
        public final /* bridge */ Set<Encodable> keySet() {
            return getKeys();
        }

        @Override // java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof Encodable) {
                return remove((Encodable) obj);
            }
            return null;
        }

        @Override // java.util.Map
        public final /* bridge */ List<Encodable> remove(Object obj) {
            if (obj instanceof Encodable) {
                return remove((Encodable) obj);
            }
            return null;
        }

        @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
        public /* bridge */ /* synthetic */ Boolean removeAll(Encodable encodable, Collection<? extends Encodable> collection) {
            return removeAll2(encodable, (Collection<Encodable>) collection);
        }

        @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
        public /* bridge */ /* synthetic */ Boolean retainAll(Encodable encodable, Collection<? extends Encodable> collection) {
            return retainAll2(encodable, (Collection<Encodable>) collection);
        }

        @Override // java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.Map
        public final /* bridge */ Collection<List<Encodable>> values() {
            return getValues();
        }

        public final boolean getForceQuerySeparator() {
            return this.forceQuerySeparator;
        }

        public final void setForceQuerySeparator(boolean z) {
            this.forceQuerySeparator = z;
        }

        public Builder() {
            this(MutableMultiMapKt.mutableMultiMapOf(new Pair[0]), false, 2, null);
        }

        public final String getDecoded() {
            return QueryParameters.INSTANCE.asDecoded(this.delegate.getEntryValues(), this.forceQuerySeparator);
        }

        public final void setDecoded(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            parseDecoded$runtime_core(value);
        }

        public final String getEncoded() {
            return QueryParameters.INSTANCE.asEncoded(this.delegate.getEntryValues(), this.forceQuerySeparator);
        }

        public final void setEncoded(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            parseEncoded$runtime_core(value);
        }

        public final void parse$runtime_core(String value, UrlEncoding encoding) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            if (encoding.contains(UrlEncoding.QueryParameters.INSTANCE)) {
                parseEncoded$runtime_core(value);
            } else {
                parseDecoded$runtime_core(value);
            }
        }

        public final void parseDecoded$runtime_core(String decoded) {
            Intrinsics.checkNotNullParameter(decoded, "decoded");
            parseInto(this.decodedParameters, decoded);
        }

        public final void parseEncoded$runtime_core(String encoded) {
            Intrinsics.checkNotNullParameter(encoded, "encoded");
            parseInto(this.encodedParameters, encoded);
        }

        private final void parseInto(MutableMultiMap<String, String> map, String text) {
            String str;
            clear();
            this.forceQuerySeparator = Intrinsics.areEqual(text, "?");
            String strRemovePrefix = StringsKt.removePrefix(text, (CharSequence) "?");
            if (strRemovePrefix.length() > 0) {
                List<String> listSplit$default = StringsKt.split$default((CharSequence) strRemovePrefix, new String[]{"&"}, false, 0, 6, (Object) null);
                ArrayList<Pair> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
                for (String str2 : listSplit$default) {
                    List listSplit$default2 = StringsKt.split$default((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null);
                    String str3 = (String) listSplit$default2.get(0);
                    int size = listSplit$default2.size();
                    if (size == 1) {
                        str = "";
                    } else if (size == 2) {
                        str = (String) listSplit$default2.get(1);
                    } else {
                        throw new IllegalArgumentException("invalid query string segment " + str2);
                    }
                    arrayList.add(TuplesKt.m1606to(str3, str));
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Pair pair : arrayList) {
                    String str4 = (String) pair.getFirst();
                    Object obj = linkedHashMap.get(str4);
                    if (obj == null) {
                        obj = (List) new ArrayList();
                        linkedHashMap.put(str4, obj);
                    }
                    ((List) obj).add((String) pair.getSecond());
                }
                map.addAll(linkedHashMap);
            }
        }

        public final MutableMultiMap<String, String> getDecodedParameters() {
            return this.decodedParameters;
        }

        public final void decodedParameters(Function1<? super MutableMultiMap<String, String>, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke(getDecodedParameters());
        }

        @InternalApi
        public final void decodedParameters(Encoding encoding, Function1<? super MutableMultiMap<String, String>, Unit> block) {
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke(Intrinsics.areEqual(encoding, PercentEncoding.INSTANCE.getQuery()) ? this.decodedParameters : ConvertersKt.asView((MutableMultiMap) this, (Function1) new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.QueryParameters$Builder$decodedParameters$params$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((Encodable) obj).getDecoded();
                }
            }, (Function1) new QueryParameters$Builder$decodedParameters$params$2(encoding), (Function1) new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.QueryParameters$Builder$decodedParameters$params$3
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((Encodable) obj).getDecoded();
                }
            }, (Function1) new QueryParameters$Builder$decodedParameters$params$4(encoding)));
        }

        public final MutableMultiMap<String, String> getEncodedParameters() {
            return this.encodedParameters;
        }

        public final void encodedParameters(Function1<? super MutableMultiMap<String, String>, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke(getEncodedParameters());
        }

        public final QueryParameters build() {
            return new QueryParameters(this.delegate.toMultiMap(), this.forceQuerySeparator, null);
        }

        public final void copyFrom(QueryParameters other) {
            Intrinsics.checkNotNullParameter(other, "other");
            clear();
            Builder builder = this;
            for (Map.Entry entry : other.entrySet()) {
                builder.put(entry.getKey(), CollectionsKt.toMutableList((Collection) entry.getValue()));
            }
            this.forceQuerySeparator = other.getForceQuerySeparator();
        }

        public final void copyFrom(Builder other) {
            Intrinsics.checkNotNullParameter(other, "other");
            clear();
            Builder builder = this;
            for (Map.Entry entry : other.entrySet()) {
                builder.put(entry.getKey(), CollectionsKt.toMutableList((Collection) entry.getValue()));
            }
            this.forceQuerySeparator = other.forceQuerySeparator;
        }
    }
}
