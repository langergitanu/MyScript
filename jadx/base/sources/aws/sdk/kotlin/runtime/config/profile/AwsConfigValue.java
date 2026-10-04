package aws.sdk.kotlin.runtime.config.profile;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: AwsConfigValue.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/AwsConfigValue;", "", "<init>", "()V", "String", "Map", "Laws/sdk/kotlin/runtime/config/profile/AwsConfigValue$Map;", "Laws/sdk/kotlin/runtime/config/profile/AwsConfigValue$String;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public abstract class AwsConfigValue {
    public /* synthetic */ AwsConfigValue(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AwsConfigValue() {
    }

    /* JADX INFO: compiled from: AwsConfigValue.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/AwsConfigValue$String;", "Laws/sdk/kotlin/runtime/config/profile/AwsConfigValue;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    @InternalSdkApi
    public static final /* data */ class String extends AwsConfigValue {
        private final java.lang.String value;

        public static /* synthetic */ String copy$default(String string, java.lang.String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = string.value;
            }
            return string.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final java.lang.String getValue() {
            return this.value;
        }

        public final String copy(java.lang.String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new String(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof String) && Intrinsics.areEqual(this.value, ((String) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public String(java.lang.String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final java.lang.String getValue() {
            return this.value;
        }

        public java.lang.String toString() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: AwsConfigValue.kt */
    @Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001a\u00020\u0003H\u0096\u0080\u0004J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001J\u0012\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096\u0081\u0004J\u0012\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0081\u0004J\u0014\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0096\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\rH\u0096\u0081\u0004R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR%\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00190\u0018X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u001e\u001a\u00020\u0015X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0019\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\"X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006%"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/AwsConfigValue$Map;", "Laws/sdk/kotlin/runtime/config/profile/AwsConfigValue;", "", "", "value", "<init>", "(Ljava/util/Map;)V", "getValue", "()Ljava/util/Map;", "toString", "component1", "copy", "containsKey", "", SubscriberAttributeKt.JSON_NAME_KEY, "containsValue", "equals", "other", "", "get", "hashCode", "", "isEmpty", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "", "getEntries", "()Ljava/util/Set;", UserMetadata.KEYDATA_FILENAME, "getKeys", "size", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    @InternalSdkApi
    public static final /* data */ class Map extends AwsConfigValue implements java.util.Map<java.lang.String, java.lang.String>, KMappedMarker {
        private final java.util.Map<java.lang.String, java.lang.String> value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Map copy$default(Map map, java.util.Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                map2 = map.value;
            }
            return map.copy(map2);
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final java.util.Map<java.lang.String, java.lang.String> component1() {
            return this.value;
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ java.lang.String compute(java.lang.String str, BiFunction<? super java.lang.String, ? super java.lang.String, ? extends java.lang.String> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: compute, reason: avoid collision after fix types in other method */
        public java.lang.String compute2(java.lang.String str, BiFunction<? super java.lang.String, ? super java.lang.String, ? extends java.lang.String> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ java.lang.String computeIfAbsent(java.lang.String str, Function<? super java.lang.String, ? extends java.lang.String> function) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: computeIfAbsent, reason: avoid collision after fix types in other method */
        public java.lang.String computeIfAbsent2(java.lang.String str, Function<? super java.lang.String, ? extends java.lang.String> function) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ java.lang.String computeIfPresent(java.lang.String str, BiFunction<? super java.lang.String, ? super java.lang.String, ? extends java.lang.String> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: computeIfPresent, reason: avoid collision after fix types in other method */
        public java.lang.String computeIfPresent2(java.lang.String str, BiFunction<? super java.lang.String, ? super java.lang.String, ? extends java.lang.String> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean containsKey(java.lang.String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this.value.containsKey(key);
        }

        public boolean containsValue(java.lang.String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return this.value.containsValue(value);
        }

        public final Map copy(java.util.Map<java.lang.String, java.lang.String> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Map(value);
        }

        @Override // java.util.Map
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Map) && Intrinsics.areEqual(this.value, ((Map) other).value);
        }

        public java.lang.String get(java.lang.String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this.value.get(key);
        }

        public Set<Map.Entry<java.lang.String, java.lang.String>> getEntries() {
            return this.value.entrySet();
        }

        public Set<java.lang.String> getKeys() {
            return this.value.keySet();
        }

        public int getSize() {
            return this.value.size();
        }

        public Collection<java.lang.String> getValues() {
            return this.value.values();
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.value.hashCode();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.value.isEmpty();
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ java.lang.String merge(java.lang.String str, java.lang.String str2, BiFunction<? super java.lang.String, ? super java.lang.String, ? extends java.lang.String> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
        public java.lang.String merge2(java.lang.String str, java.lang.String str2, BiFunction<? super java.lang.String, ? super java.lang.String, ? extends java.lang.String> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ java.lang.String put(java.lang.String str, java.lang.String str2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: put, reason: avoid collision after fix types in other method */
        public java.lang.String put2(java.lang.String str, java.lang.String str2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void putAll(java.util.Map<? extends java.lang.String, ? extends java.lang.String> map) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ java.lang.String putIfAbsent(java.lang.String str, java.lang.String str2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: putIfAbsent, reason: avoid collision after fix types in other method */
        public java.lang.String putIfAbsent2(java.lang.String str, java.lang.String str2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public java.lang.String remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ java.lang.String replace(java.lang.String str, java.lang.String str2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: replace, reason: avoid collision after fix types in other method */
        public java.lang.String replace2(java.lang.String str, java.lang.String str2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ boolean replace(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: replace, reason: avoid collision after fix types in other method */
        public boolean replace2(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super java.lang.String, ? super java.lang.String, ? extends java.lang.String> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Map(java.util.Map<java.lang.String, java.lang.String> value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @Override // java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof java.lang.String) {
                return containsKey((java.lang.String) obj);
            }
            return false;
        }

        @Override // java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof java.lang.String) {
                return containsValue((java.lang.String) obj);
            }
            return false;
        }

        @Override // java.util.Map
        public final /* bridge */ Set<Map.Entry<java.lang.String, java.lang.String>> entrySet() {
            return getEntries();
        }

        @Override // java.util.Map
        public final /* bridge */ /* synthetic */ java.lang.String get(Object obj) {
            if (obj instanceof java.lang.String) {
                return get((java.lang.String) obj);
            }
            return null;
        }

        @Override // java.util.Map
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public final /* bridge */ java.lang.String get2(Object obj) {
            if (obj instanceof java.lang.String) {
                return get((java.lang.String) obj);
            }
            return null;
        }

        @Override // java.util.Map
        public final /* bridge */ Set<java.lang.String> keySet() {
            return getKeys();
        }

        @Override // java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.Map
        public final /* bridge */ Collection<java.lang.String> values() {
            return getValues();
        }

        public final java.util.Map<java.lang.String, java.lang.String> getValue() {
            return this.value;
        }

        public java.lang.String toString() {
            return this.value.toString();
        }
    }
}
