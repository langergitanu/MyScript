package com.revenuecat.purchases.common.remoteconfig;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.common.JsonProvider;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfiguration;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: RemoteConfiguration.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0081\b\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001*B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\u0010\u0005J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001HÆ\u0003J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0003H\u0096\u0001J\u001f\u0010\"\u001a\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001HÆ\u0001J\u0013\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\u0013\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001f\u001a\u00020\u0002H\u0096\u0003J\t\u0010'\u001a\u00020\u0015HÖ\u0001J\t\u0010(\u001a\u00020\u001eH\u0096\u0001J\t\u0010)\u001a\u00020\u0002HÖ\u0001R\u001b\u0010\u0006\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r0\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0012\u0010\u0014\u001a\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/ConfigTopic;", "", "", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfiguration$ConfigItem;", FirebaseAnalytics.Param.ITEMS, "(Ljava/util/Map;)V", "contentHash", "getContentHash", "()Ljava/lang/String;", "contentHash$delegate", "Lkotlin/Lazy;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "", "getEntries", "()Ljava/util/Set;", "getItems", "()Ljava/util/Map;", UserMetadata.KEYDATA_FILENAME, "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "component1", "containsKey", "", SubscriberAttributeKt.JSON_NAME_KEY, "containsValue", "value", "copy", "equals", "other", "", "get", "hashCode", "isEmpty", "toString", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable(with = ConfigTopicSerializer.class)
public final /* data */ class ConfigTopic implements Map<String, RemoteConfiguration.ConfigItem>, KMappedMarker {
    private static final Companion Companion = new Companion(null);
    private static final int HEX_BYTE_MASK = 255;

    /* JADX INFO: renamed from: contentHash$delegate, reason: from kotlin metadata */
    private final Lazy contentHash;
    private final Map<String, RemoteConfiguration.ConfigItem> items;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConfigTopic copy$default(ConfigTopic configTopic, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = configTopic.items;
        }
        return configTopic.copy(map);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Map<String, RemoteConfiguration.ConfigItem> component1() {
        return this.items;
    }

    /* JADX INFO: renamed from: compute, reason: avoid collision after fix types in other method */
    public RemoteConfiguration.ConfigItem compute2(String str, BiFunction<? super String, ? super RemoteConfiguration.ConfigItem, ? extends RemoteConfiguration.ConfigItem> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ RemoteConfiguration.ConfigItem compute(String str, BiFunction<? super String, ? super RemoteConfiguration.ConfigItem, ? extends RemoteConfiguration.ConfigItem> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: computeIfAbsent, reason: avoid collision after fix types in other method */
    public RemoteConfiguration.ConfigItem computeIfAbsent2(String str, Function<? super String, ? extends RemoteConfiguration.ConfigItem> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ RemoteConfiguration.ConfigItem computeIfAbsent(String str, Function<? super String, ? extends RemoteConfiguration.ConfigItem> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: computeIfPresent, reason: avoid collision after fix types in other method */
    public RemoteConfiguration.ConfigItem computeIfPresent2(String str, BiFunction<? super String, ? super RemoteConfiguration.ConfigItem, ? extends RemoteConfiguration.ConfigItem> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ RemoteConfiguration.ConfigItem computeIfPresent(String str, BiFunction<? super String, ? super RemoteConfiguration.ConfigItem, ? extends RemoteConfiguration.ConfigItem> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.items.containsKey(key);
    }

    public boolean containsValue(RemoteConfiguration.ConfigItem value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.items.containsValue(value);
    }

    public final ConfigTopic copy(Map<String, RemoteConfiguration.ConfigItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new ConfigTopic(items);
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ConfigTopic) && Intrinsics.areEqual(this.items, ((ConfigTopic) other).items);
    }

    public RemoteConfiguration.ConfigItem get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.items.get(key);
    }

    public Set<Map.Entry<String, RemoteConfiguration.ConfigItem>> getEntries() {
        return this.items.entrySet();
    }

    public Set<String> getKeys() {
        return this.items.keySet();
    }

    public int getSize() {
        return this.items.size();
    }

    public Collection<RemoteConfiguration.ConfigItem> getValues() {
        return this.items.values();
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.items.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
    public RemoteConfiguration.ConfigItem merge2(String str, RemoteConfiguration.ConfigItem configItem, BiFunction<? super RemoteConfiguration.ConfigItem, ? super RemoteConfiguration.ConfigItem, ? extends RemoteConfiguration.ConfigItem> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ RemoteConfiguration.ConfigItem merge(String str, RemoteConfiguration.ConfigItem configItem, BiFunction<? super RemoteConfiguration.ConfigItem, ? super RemoteConfiguration.ConfigItem, ? extends RemoteConfiguration.ConfigItem> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: put, reason: avoid collision after fix types in other method */
    public RemoteConfiguration.ConfigItem put2(String str, RemoteConfiguration.ConfigItem configItem) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ RemoteConfiguration.ConfigItem put(String str, RemoteConfiguration.ConfigItem configItem) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends RemoteConfiguration.ConfigItem> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: putIfAbsent, reason: avoid collision after fix types in other method */
    public RemoteConfiguration.ConfigItem putIfAbsent2(String str, RemoteConfiguration.ConfigItem configItem) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ RemoteConfiguration.ConfigItem putIfAbsent(String str, RemoteConfiguration.ConfigItem configItem) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public RemoteConfiguration.ConfigItem remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: replace, reason: avoid collision after fix types in other method */
    public RemoteConfiguration.ConfigItem replace2(String str, RemoteConfiguration.ConfigItem configItem) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ RemoteConfiguration.ConfigItem replace(String str, RemoteConfiguration.ConfigItem configItem) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ boolean replace(String str, RemoteConfiguration.ConfigItem configItem, RemoteConfiguration.ConfigItem configItem2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: replace, reason: avoid collision after fix types in other method */
    public boolean replace2(String str, RemoteConfiguration.ConfigItem configItem, RemoteConfiguration.ConfigItem configItem2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super String, ? super RemoteConfiguration.ConfigItem, ? extends RemoteConfiguration.ConfigItem> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public String toString() {
        return "ConfigTopic(items=" + this.items + ')';
    }

    public ConfigTopic(Map<String, RemoteConfiguration.ConfigItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.items = items;
        this.contentHash = LazyKt.lazy(new Function0<String>() { // from class: com.revenuecat.purchases.common.remoteconfig.ConfigTopic$contentHash$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return ConfigTopic.Companion.computeHash(this.this$0.getItems());
            }
        });
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof RemoteConfiguration.ConfigItem) {
            return containsValue((RemoteConfiguration.ConfigItem) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, RemoteConfiguration.ConfigItem>> entrySet() {
        return getEntries();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public final /* bridge */ RemoteConfiguration.ConfigItem get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ RemoteConfiguration.ConfigItem get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<RemoteConfiguration.ConfigItem> values() {
        return getValues();
    }

    public final Map<String, RemoteConfiguration.ConfigItem> getItems() {
        return this.items;
    }

    public final String getContentHash() {
        return (String) this.contentHash.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RemoteConfiguration.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/ConfigTopic$Companion;", "", "()V", "HEX_BYTE_MASK", "", "canonicalize", "Lkotlinx/serialization/json/JsonElement;", "element", "computeHash", "", FirebaseAnalytics.Param.ITEMS, "", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfiguration$ConfigItem;", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/remoteconfig/ConfigTopic;", "sha256Hex", "input", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ConfigTopic> serializer() {
            return ConfigTopicSerializer.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String computeHash(Map<String, RemoteConfiguration.ConfigItem> items) {
            return sha256Hex(canonicalize(JsonProvider.INSTANCE.getDefaultJson().encodeToJsonElement(RemoteConfigurationKt.configItemMapSerializer, items)).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final JsonElement canonicalize(JsonElement element) {
            if (!(element instanceof JsonObject)) {
                if (!(element instanceof JsonArray)) {
                    return element;
                }
                Iterable iterable = (Iterable) element;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(ConfigTopic.Companion.canonicalize((JsonElement) it.next()));
                }
                return new JsonArray(arrayList);
            }
            List<Map.Entry> listSortedWith = CollectionsKt.sortedWith(((JsonObject) element).entrySet(), new Comparator() { // from class: com.revenuecat.purchases.common.remoteconfig.ConfigTopic$Companion$canonicalize$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((String) ((Map.Entry) t).getKey(), (String) ((Map.Entry) t2).getKey());
                }
            });
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10)), 16));
            for (Map.Entry entry : listSortedWith) {
                Pair pairM1606to = TuplesKt.m1606to(entry.getKey(), ConfigTopic.Companion.canonicalize((JsonElement) entry.getValue()));
                linkedHashMap.put(pairM1606to.getFirst(), pairM1606to.getSecond());
            }
            return new JsonObject(linkedHashMap);
        }

        private final String sha256Hex(String input) throws NoSuchAlgorithmException {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            byte[] bytes = input.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bArrDigest = messageDigest.digest(bytes);
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "getInstance(\"SHA-256\")\n …yteArray(Charsets.UTF_8))");
            return ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.revenuecat.purchases.common.remoteconfig.ConfigTopic$Companion$sha256Hex$1
                public final CharSequence invoke(byte b) {
                    String str = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b & 255)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                    return invoke(b.byteValue());
                }
            }, 30, (Object) null);
        }
    }
}
