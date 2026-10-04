package com.revenuecat.purchases.common.remoteconfig;

import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: RemoteConfigDiskCache.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 42\u00020\u0001:\u000234Bm\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011BW\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0018Jd\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001J&\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201HÁ\u0001¢\u0006\u0002\b2R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00065"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/PersistedRemoteConfigurationState;", "", "seen1", "", ClientCookie.DOMAIN_ATTR, "", "manifest", "activeTopics", "", "prefetchBlobs", "topics", "", "Lcom/revenuecat/purchases/common/remoteconfig/ConfigTopic;", "lastRefreshTime", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/Long;)V", "getActiveTopics", "()Ljava/util/List;", "getDomain", "()Ljava/lang/String;", "getLastRefreshTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getManifest", "getPrefetchBlobs", "getTopics", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/Long;)Lcom/revenuecat/purchases/common/remoteconfig/PersistedRemoteConfigurationState;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
public final /* data */ class PersistedRemoteConfigurationState {
    private final List<String> activeTopics;
    private final String domain;
    private final Long lastRefreshTime;
    private final String manifest;
    private final List<String> prefetchBlobs;
    private final Map<String, ConfigTopic> topics;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE), new LinkedHashMapSerializer(StringSerializer.INSTANCE, ConfigTopicSerializer.INSTANCE), null};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PersistedRemoteConfigurationState copy$default(PersistedRemoteConfigurationState persistedRemoteConfigurationState, String str, String str2, List list, List list2, Map map, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = persistedRemoteConfigurationState.domain;
        }
        if ((i & 2) != 0) {
            str2 = persistedRemoteConfigurationState.manifest;
        }
        if ((i & 4) != 0) {
            list = persistedRemoteConfigurationState.activeTopics;
        }
        if ((i & 8) != 0) {
            list2 = persistedRemoteConfigurationState.prefetchBlobs;
        }
        if ((i & 16) != 0) {
            map = persistedRemoteConfigurationState.topics;
        }
        if ((i & 32) != 0) {
            l = persistedRemoteConfigurationState.lastRefreshTime;
        }
        Map map2 = map;
        Long l2 = l;
        return persistedRemoteConfigurationState.copy(str, str2, list, list2, map2, l2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getManifest() {
        return this.manifest;
    }

    public final List<String> component3() {
        return this.activeTopics;
    }

    public final List<String> component4() {
        return this.prefetchBlobs;
    }

    public final Map<String, ConfigTopic> component5() {
        return this.topics;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getLastRefreshTime() {
        return this.lastRefreshTime;
    }

    public final PersistedRemoteConfigurationState copy(String domain, String manifest, List<String> activeTopics, List<String> prefetchBlobs, Map<String, ConfigTopic> topics, Long lastRefreshTime) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        Intrinsics.checkNotNullParameter(activeTopics, "activeTopics");
        Intrinsics.checkNotNullParameter(prefetchBlobs, "prefetchBlobs");
        Intrinsics.checkNotNullParameter(topics, "topics");
        return new PersistedRemoteConfigurationState(domain, manifest, activeTopics, prefetchBlobs, topics, lastRefreshTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersistedRemoteConfigurationState)) {
            return false;
        }
        PersistedRemoteConfigurationState persistedRemoteConfigurationState = (PersistedRemoteConfigurationState) other;
        return Intrinsics.areEqual(this.domain, persistedRemoteConfigurationState.domain) && Intrinsics.areEqual(this.manifest, persistedRemoteConfigurationState.manifest) && Intrinsics.areEqual(this.activeTopics, persistedRemoteConfigurationState.activeTopics) && Intrinsics.areEqual(this.prefetchBlobs, persistedRemoteConfigurationState.prefetchBlobs) && Intrinsics.areEqual(this.topics, persistedRemoteConfigurationState.topics) && Intrinsics.areEqual(this.lastRefreshTime, persistedRemoteConfigurationState.lastRefreshTime);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.domain.hashCode() * 31) + this.manifest.hashCode()) * 31) + this.activeTopics.hashCode()) * 31) + this.prefetchBlobs.hashCode()) * 31) + this.topics.hashCode()) * 31;
        Long l = this.lastRefreshTime;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "PersistedRemoteConfigurationState(domain=" + this.domain + ", manifest=" + this.manifest + ", activeTopics=" + this.activeTopics + ", prefetchBlobs=" + this.prefetchBlobs + ", topics=" + this.topics + ", lastRefreshTime=" + this.lastRefreshTime + ')';
    }

    /* JADX INFO: compiled from: RemoteConfigDiskCache.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/PersistedRemoteConfigurationState$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/remoteconfig/PersistedRemoteConfigurationState;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PersistedRemoteConfigurationState> serializer() {
            return PersistedRemoteConfigurationState$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PersistedRemoteConfigurationState(int i, String str, String str2, List list, List list2, Map map, Long l, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, PersistedRemoteConfigurationState$$serializer.INSTANCE.getDescriptor());
        }
        this.domain = str;
        this.manifest = str2;
        if ((i & 4) == 0) {
            this.activeTopics = CollectionsKt.emptyList();
        } else {
            this.activeTopics = list;
        }
        if ((i & 8) == 0) {
            this.prefetchBlobs = CollectionsKt.emptyList();
        } else {
            this.prefetchBlobs = list2;
        }
        if ((i & 16) == 0) {
            this.topics = MapsKt.emptyMap();
        } else {
            this.topics = map;
        }
        if ((i & 32) == 0) {
            this.lastRefreshTime = null;
        } else {
            this.lastRefreshTime = l;
        }
    }

    public PersistedRemoteConfigurationState(String domain, String manifest, List<String> activeTopics, List<String> prefetchBlobs, Map<String, ConfigTopic> topics, Long l) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        Intrinsics.checkNotNullParameter(activeTopics, "activeTopics");
        Intrinsics.checkNotNullParameter(prefetchBlobs, "prefetchBlobs");
        Intrinsics.checkNotNullParameter(topics, "topics");
        this.domain = domain;
        this.manifest = manifest;
        this.activeTopics = activeTopics;
        this.prefetchBlobs = prefetchBlobs;
        this.topics = topics;
        this.lastRefreshTime = l;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(PersistedRemoteConfigurationState self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.domain);
        output.encodeStringElement(serialDesc, 1, self.manifest);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.activeTopics, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.activeTopics);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.prefetchBlobs, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.prefetchBlobs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.topics, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.topics);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.lastRefreshTime == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, LongSerializer.INSTANCE, self.lastRefreshTime);
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getManifest() {
        return this.manifest;
    }

    public /* synthetic */ PersistedRemoteConfigurationState(String str, String str2, List list, List list2, Map map, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? CollectionsKt.emptyList() : list2, (i & 16) != 0 ? MapsKt.emptyMap() : map, (i & 32) != 0 ? null : l);
    }

    public final List<String> getActiveTopics() {
        return this.activeTopics;
    }

    public final List<String> getPrefetchBlobs() {
        return this.prefetchBlobs;
    }

    public final Map<String, ConfigTopic> getTopics() {
        return this.topics;
    }

    public final Long getLastRefreshTime() {
        return this.lastRefreshTime;
    }
}
