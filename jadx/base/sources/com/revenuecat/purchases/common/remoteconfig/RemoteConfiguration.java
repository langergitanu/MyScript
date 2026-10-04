package com.revenuecat.purchases.common.remoteconfig;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.revenuecat.purchases.common.JsonProvider;
import java.nio.ByteBuffer;
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
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonObject;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: RemoteConfiguration.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 ;2\u00020\u0001:\u0003:;<B\u008f\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012Bs\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u0015\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J{\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001J&\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208HÁ\u0001¢\u0006\u0002\b9R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u001aR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006="}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfiguration;", "", "seen1", "", ClientCookie.DOMAIN_ATTR, "", "subdomains", "", "appUuid", "manifest", "activeTopics", "prefetchBlobs", "topics", "", "Lcom/revenuecat/purchases/common/remoteconfig/ConfigTopic;", "stateHash", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "getActiveTopics$annotations", "()V", "getActiveTopics", "()Ljava/util/List;", "getAppUuid$annotations", "getAppUuid", "()Ljava/lang/String;", "getDomain", "getManifest", "getPrefetchBlobs$annotations", "getPrefetchBlobs", "getStateHash$annotations", "getStateHash", "getSubdomains", "getTopics", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "ConfigItem", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
public final /* data */ class RemoteConfiguration {
    private final List<String> activeTopics;
    private final String appUuid;
    private final String domain;
    private final String manifest;
    private final List<String> prefetchBlobs;
    private final String stateHash;
    private final List<String> subdomains;
    private final Map<String, ConfigTopic> topics;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(StringSerializer.INSTANCE), null, null, new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE), new LinkedHashMapSerializer(StringSerializer.INSTANCE, ConfigTopicSerializer.INSTANCE), null};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RemoteConfiguration copy$default(RemoteConfiguration remoteConfiguration, String str, List list, String str2, String str3, List list2, List list3, Map map, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = remoteConfiguration.domain;
        }
        if ((i & 2) != 0) {
            list = remoteConfiguration.subdomains;
        }
        if ((i & 4) != 0) {
            str2 = remoteConfiguration.appUuid;
        }
        if ((i & 8) != 0) {
            str3 = remoteConfiguration.manifest;
        }
        if ((i & 16) != 0) {
            list2 = remoteConfiguration.activeTopics;
        }
        if ((i & 32) != 0) {
            list3 = remoteConfiguration.prefetchBlobs;
        }
        if ((i & 64) != 0) {
            map = remoteConfiguration.topics;
        }
        if ((i & 128) != 0) {
            str4 = remoteConfiguration.stateHash;
        }
        Map map2 = map;
        String str5 = str4;
        List list4 = list2;
        List list5 = list3;
        return remoteConfiguration.copy(str, list, str2, str3, list4, list5, map2, str5);
    }

    @SerialName("active_topics")
    public static /* synthetic */ void getActiveTopics$annotations() {
    }

    @SerialName("app_uuid")
    public static /* synthetic */ void getAppUuid$annotations() {
    }

    @SerialName("prefetch_blobs")
    public static /* synthetic */ void getPrefetchBlobs$annotations() {
    }

    @SerialName("state_hash")
    public static /* synthetic */ void getStateHash$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    public final List<String> component2() {
        return this.subdomains;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAppUuid() {
        return this.appUuid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getManifest() {
        return this.manifest;
    }

    public final List<String> component5() {
        return this.activeTopics;
    }

    public final List<String> component6() {
        return this.prefetchBlobs;
    }

    public final Map<String, ConfigTopic> component7() {
        return this.topics;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getStateHash() {
        return this.stateHash;
    }

    public final RemoteConfiguration copy(String domain, List<String> subdomains, String appUuid, String manifest, List<String> activeTopics, List<String> prefetchBlobs, Map<String, ConfigTopic> topics, String stateHash) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(subdomains, "subdomains");
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        Intrinsics.checkNotNullParameter(activeTopics, "activeTopics");
        Intrinsics.checkNotNullParameter(prefetchBlobs, "prefetchBlobs");
        Intrinsics.checkNotNullParameter(topics, "topics");
        return new RemoteConfiguration(domain, subdomains, appUuid, manifest, activeTopics, prefetchBlobs, topics, stateHash);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteConfiguration)) {
            return false;
        }
        RemoteConfiguration remoteConfiguration = (RemoteConfiguration) other;
        return Intrinsics.areEqual(this.domain, remoteConfiguration.domain) && Intrinsics.areEqual(this.subdomains, remoteConfiguration.subdomains) && Intrinsics.areEqual(this.appUuid, remoteConfiguration.appUuid) && Intrinsics.areEqual(this.manifest, remoteConfiguration.manifest) && Intrinsics.areEqual(this.activeTopics, remoteConfiguration.activeTopics) && Intrinsics.areEqual(this.prefetchBlobs, remoteConfiguration.prefetchBlobs) && Intrinsics.areEqual(this.topics, remoteConfiguration.topics) && Intrinsics.areEqual(this.stateHash, remoteConfiguration.stateHash);
    }

    public int hashCode() {
        int iHashCode = ((this.domain.hashCode() * 31) + this.subdomains.hashCode()) * 31;
        String str = this.appUuid;
        int iHashCode2 = (((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.manifest.hashCode()) * 31) + this.activeTopics.hashCode()) * 31) + this.prefetchBlobs.hashCode()) * 31) + this.topics.hashCode()) * 31;
        String str2 = this.stateHash;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "RemoteConfiguration(domain=" + this.domain + ", subdomains=" + this.subdomains + ", appUuid=" + this.appUuid + ", manifest=" + this.manifest + ", activeTopics=" + this.activeTopics + ", prefetchBlobs=" + this.prefetchBlobs + ", topics=" + this.topics + ", stateHash=" + this.stateHash + ')';
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ RemoteConfiguration(int i, String str, List list, @SerialName("app_uuid") String str2, String str3, @SerialName("active_topics") List list2, @SerialName("prefetch_blobs") List list3, Map map, @SerialName("state_hash") String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (9 != (i & 9)) {
            PluginExceptionsKt.throwMissingFieldException(i, 9, RemoteConfiguration$$serializer.INSTANCE.getDescriptor());
        }
        this.domain = str;
        if ((i & 2) == 0) {
            this.subdomains = CollectionsKt.emptyList();
        } else {
            this.subdomains = list;
        }
        if ((i & 4) == 0) {
            this.appUuid = null;
        } else {
            this.appUuid = str2;
        }
        this.manifest = str3;
        if ((i & 16) == 0) {
            this.activeTopics = CollectionsKt.emptyList();
        } else {
            this.activeTopics = list2;
        }
        if ((i & 32) == 0) {
            this.prefetchBlobs = CollectionsKt.emptyList();
        } else {
            this.prefetchBlobs = list3;
        }
        if ((i & 64) == 0) {
            this.topics = MapsKt.emptyMap();
        } else {
            this.topics = map;
        }
        if ((i & 128) == 0) {
            this.stateHash = null;
        } else {
            this.stateHash = str4;
        }
    }

    public RemoteConfiguration(String domain, List<String> subdomains, String str, String manifest, List<String> activeTopics, List<String> prefetchBlobs, Map<String, ConfigTopic> topics, String str2) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(subdomains, "subdomains");
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        Intrinsics.checkNotNullParameter(activeTopics, "activeTopics");
        Intrinsics.checkNotNullParameter(prefetchBlobs, "prefetchBlobs");
        Intrinsics.checkNotNullParameter(topics, "topics");
        this.domain = domain;
        this.subdomains = subdomains;
        this.appUuid = str;
        this.manifest = manifest;
        this.activeTopics = activeTopics;
        this.prefetchBlobs = prefetchBlobs;
        this.topics = topics;
        this.stateHash = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(RemoteConfiguration self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.domain);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.subdomains, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.subdomains);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.appUuid != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.appUuid);
        }
        output.encodeStringElement(serialDesc, 3, self.manifest);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.activeTopics, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.activeTopics);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.prefetchBlobs, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.prefetchBlobs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.topics, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 6, kSerializerArr[6], self.topics);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.stateHash == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.stateHash);
    }

    public final String getDomain() {
        return this.domain;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ RemoteConfiguration(java.lang.String r10, java.util.List r11, java.lang.String r12, java.lang.String r13, java.util.List r14, java.util.List r15, java.util.Map r16, java.lang.String r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 2
            if (r1 == 0) goto La
            java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
        La:
            r2 = r11
            r11 = r0 & 4
            r1 = 0
            if (r11 == 0) goto L12
            r3 = r1
            goto L13
        L12:
            r3 = r12
        L13:
            r11 = r0 & 16
            if (r11 == 0) goto L1d
            java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
            r5 = r11
            goto L1e
        L1d:
            r5 = r14
        L1e:
            r11 = r0 & 32
            if (r11 == 0) goto L28
            java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
            r6 = r11
            goto L29
        L28:
            r6 = r15
        L29:
            r11 = r0 & 64
            if (r11 == 0) goto L33
            java.util.Map r11 = kotlin.collections.MapsKt.emptyMap()
            r7 = r11
            goto L35
        L33:
            r7 = r16
        L35:
            r11 = r0 & 128(0x80, float:1.8E-43)
            if (r11 == 0) goto L3e
            r8 = r1
            r0 = r9
            r4 = r13
            r1 = r10
            goto L43
        L3e:
            r8 = r17
            r0 = r9
            r1 = r10
            r4 = r13
        L43:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.remoteconfig.RemoteConfiguration.<init>(java.lang.String, java.util.List, java.lang.String, java.lang.String, java.util.List, java.util.List, java.util.Map, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<String> getSubdomains() {
        return this.subdomains;
    }

    public final String getAppUuid() {
        return this.appUuid;
    }

    public final String getManifest() {
        return this.manifest;
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

    public final String getStateHash() {
        return this.stateHash;
    }

    /* JADX INFO: compiled from: RemoteConfiguration.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\b\u0081\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfiguration$ConfigItem;", "", "blobRef", "", "prefetch", "", TtmlNode.TAG_METADATA, "Lkotlinx/serialization/json/JsonObject;", "(Ljava/lang/String;ZLkotlinx/serialization/json/JsonObject;)V", "getBlobRef", "()Ljava/lang/String;", "getMetadata", "()Lkotlinx/serialization/json/JsonObject;", "getPrefetch", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable(with = ConfigItemSerializer.class)
    public static final /* data */ class ConfigItem {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String blobRef;
        private final JsonObject metadata;
        private final boolean prefetch;

        public ConfigItem() {
            this(null, false, null, 7, null);
        }

        public static /* synthetic */ ConfigItem copy$default(ConfigItem configItem, String str, boolean z, JsonObject jsonObject, int i, Object obj) {
            if ((i & 1) != 0) {
                str = configItem.blobRef;
            }
            if ((i & 2) != 0) {
                z = configItem.prefetch;
            }
            if ((i & 4) != 0) {
                jsonObject = configItem.metadata;
            }
            return configItem.copy(str, z, jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getBlobRef() {
            return this.blobRef;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getPrefetch() {
            return this.prefetch;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final JsonObject getMetadata() {
            return this.metadata;
        }

        public final ConfigItem copy(String blobRef, boolean prefetch, JsonObject metadata) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            return new ConfigItem(blobRef, prefetch, metadata);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConfigItem)) {
                return false;
            }
            ConfigItem configItem = (ConfigItem) other;
            return Intrinsics.areEqual(this.blobRef, configItem.blobRef) && this.prefetch == configItem.prefetch && Intrinsics.areEqual(this.metadata, configItem.metadata);
        }

        public int hashCode() {
            String str = this.blobRef;
            return ((((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.prefetch)) * 31) + this.metadata.hashCode();
        }

        public String toString() {
            return "ConfigItem(blobRef=" + this.blobRef + ", prefetch=" + this.prefetch + ", metadata=" + this.metadata + ')';
        }

        /* JADX INFO: compiled from: RemoteConfiguration.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfiguration$ConfigItem$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfiguration$ConfigItem;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ConfigItem> serializer() {
                return ConfigItemSerializer.INSTANCE;
            }
        }

        public ConfigItem(String str, boolean z, JsonObject metadata) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            this.blobRef = str;
            this.prefetch = z;
            this.metadata = metadata;
        }

        public final String getBlobRef() {
            return this.blobRef;
        }

        public final boolean getPrefetch() {
            return this.prefetch;
        }

        public /* synthetic */ ConfigItem(String str, boolean z, JsonObject jsonObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? new JsonObject(MapsKt.emptyMap()) : jsonObject);
        }

        public final JsonObject getMetadata() {
            return this.metadata;
        }
    }

    /* JADX INFO: compiled from: RemoteConfiguration.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0001¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfiguration$Companion;", "", "()V", "parse", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfiguration;", "buffer", "Ljava/nio/ByteBuffer;", "bytes", "", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RemoteConfiguration> serializer() {
            return RemoteConfiguration$$serializer.INSTANCE;
        }

        public final RemoteConfiguration parse(byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            return (RemoteConfiguration) JsonProvider.INSTANCE.getDefaultJson().decodeFromString(serializer(), StringsKt.decodeToString(bytes));
        }

        public final RemoteConfiguration parse(ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            ByteBuffer byteBufferDuplicate = buffer.duplicate();
            byte[] bArr = new byte[byteBufferDuplicate.remaining()];
            byteBufferDuplicate.get(bArr);
            return parse(bArr);
        }
    }
}
