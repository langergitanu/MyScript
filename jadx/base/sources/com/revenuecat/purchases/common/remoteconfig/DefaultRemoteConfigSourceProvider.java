package com.revenuecat.purchases.common.remoteconfig;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigSourceHandle;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfiguration;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: RemoteConfigSourceProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0002J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/DefaultRemoteConfigSourceProvider;", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceProvider;", "topicStore", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigTopicStore;", "random", "Lkotlin/random/Random;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigTopicStore;Lkotlin/random/Random;Lcom/revenuecat/purchases/common/DateProvider;)V", DefaultRemoteConfigSourceProvider.API_ITEM, "Lcom/revenuecat/purchases/common/remoteconfig/SourceFailover;", "apiFailoverStartedAtMs", "", "Ljava/lang/Long;", DefaultRemoteConfigSourceProvider.BLOB_ITEM, "builtHash", "", "lock", "", "clear", "", "failoverFor", "purpose", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle$Purpose;", "getCurrent", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle;", "rebuild", "topic", "Lcom/revenuecat/purchases/common/remoteconfig/ConfigTopic;", "rebuildIfChanged", "", "reportUnhealthy", "handle", "restart", "restartAPIIfExpired", "restartIfExhausted", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class DefaultRemoteConfigSourceProvider implements RemoteConfigSourceProvider {
    private static final long API_FAILOVER_RESTART_INTERVAL;
    private static final String API_ITEM = "api";
    private static final String BLOB_ITEM = "blob";
    private static final Companion Companion = new Companion(null);
    private static final List<RemoteConfigSource> DEFAULT_API_SOURCES;
    private static final String PRIORITY_KEY = "priority";
    private static final String SOURCES_KEY = "sources";
    private static final String URL_FORMAT_KEY = "url_format";
    private static final String URL_KEY = "url";
    private static final String WEIGHT_KEY = "weight";
    private SourceFailover api;
    private Long apiFailoverStartedAtMs;
    private SourceFailover blob;
    private String builtHash;
    private final DateProvider dateProvider;
    private final Object lock;
    private final Random random;
    private final RemoteConfigTopicStore topicStore;

    /* JADX INFO: compiled from: RemoteConfigSourceProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RemoteConfigSourceHandle.Purpose.values().length];
            try {
                iArr[RemoteConfigSourceHandle.Purpose.API.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RemoteConfigSourceHandle.Purpose.BLOB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DefaultRemoteConfigSourceProvider(RemoteConfigTopicStore topicStore, Random random, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(topicStore, "topicStore");
        Intrinsics.checkNotNullParameter(random, "random");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.topicStore = topicStore;
        this.random = random;
        this.dateProvider = dateProvider;
        this.lock = new Object();
        RemoteConfigSourceHandle.Purpose purpose = RemoteConfigSourceHandle.Purpose.API;
        Companion companion = Companion;
        this.api = new SourceFailover(purpose, companion.dedupe(companion.sourcesFor(null, RemoteConfigSourceHandle.Purpose.API)), random, 0, 8, null);
        this.blob = new SourceFailover(RemoteConfigSourceHandle.Purpose.BLOB, companion.dedupe(companion.sourcesFor(null, RemoteConfigSourceHandle.Purpose.BLOB)), random, 0, 8, null);
    }

    public /* synthetic */ DefaultRemoteConfigSourceProvider(RemoteConfigTopicStore remoteConfigTopicStore, Random.Companion companion, DefaultDateProvider defaultDateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(remoteConfigTopicStore, (i & 2) != 0 ? Random.INSTANCE : companion, (i & 4) != 0 ? new DefaultDateProvider() : defaultDateProvider);
    }

    @Override // com.revenuecat.purchases.common.remoteconfig.RemoteConfigSourceProvider
    public RemoteConfigSourceHandle getCurrent(RemoteConfigSourceHandle.Purpose purpose) {
        RemoteConfigSourceHandle current;
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        synchronized (this.lock) {
            rebuildIfChanged();
            restartAPIIfExpired();
            current = failoverFor(purpose).getCurrent();
        }
        return current;
    }

    @Override // com.revenuecat.purchases.common.remoteconfig.RemoteConfigSourceProvider
    public void reportUnhealthy(RemoteConfigSourceHandle handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        synchronized (this.lock) {
            if (rebuildIfChanged()) {
                return;
            }
            restartAPIIfExpired();
            if (failoverFor(handle.getPurpose()).reportUnhealthy(handle) && handle.getPurpose() == RemoteConfigSourceHandle.Purpose.API && this.apiFailoverStartedAtMs == null) {
                this.apiFailoverStartedAtMs = Long.valueOf(this.dateProvider.getNow().getTime());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.revenuecat.purchases.common.remoteconfig.RemoteConfigSourceProvider
    public void restart(RemoteConfigSourceHandle.Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        synchronized (this.lock) {
            if (!rebuildIfChanged()) {
                failoverFor(purpose).restart();
                if (purpose == RemoteConfigSourceHandle.Purpose.API) {
                    this.apiFailoverStartedAtMs = null;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.revenuecat.purchases.common.remoteconfig.RemoteConfigSourceProvider
    public boolean restartIfExhausted(RemoteConfigSourceHandle.Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        synchronized (this.lock) {
            boolean z = true;
            if (rebuildIfChanged()) {
                return true;
            }
            restartAPIIfExpired();
            SourceFailover sourceFailoverFailoverFor = failoverFor(purpose);
            if (sourceFailoverFailoverFor.getCurrent() == null) {
                sourceFailoverFailoverFor.restart();
                if (purpose == RemoteConfigSourceHandle.Purpose.API) {
                    this.apiFailoverStartedAtMs = null;
                }
            } else {
                z = false;
            }
            return z;
        }
    }

    @Override // com.revenuecat.purchases.common.remoteconfig.RemoteConfigSourceProvider
    public void clear() {
        synchronized (this.lock) {
            rebuild(null);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final SourceFailover failoverFor(RemoteConfigSourceHandle.Purpose purpose) {
        int i = WhenMappings.$EnumSwitchMapping$0[purpose.ordinal()];
        if (i == 1) {
            return this.api;
        }
        if (i == 2) {
            return this.blob;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void restartAPIIfExpired() {
        Long l = this.apiFailoverStartedAtMs;
        if (l != null) {
            if (this.dateProvider.getNow().getTime() - l.longValue() >= Duration.m15867getInWholeMillisecondsimpl(API_FAILOVER_RESTART_INTERVAL)) {
                this.api.restart();
                this.apiFailoverStartedAtMs = null;
            }
        }
    }

    private final boolean rebuildIfChanged() {
        ConfigTopic configTopic = this.topicStore.topic(RemoteConfigTopic.Sources);
        if (Intrinsics.areEqual(configTopic != null ? configTopic.getContentHash() : null, this.builtHash)) {
            return false;
        }
        rebuild(configTopic);
        return true;
    }

    private final void rebuild(ConfigTopic topic) {
        int iMax = Math.max(this.api.getToken(), this.blob.getToken()) + 1;
        RemoteConfigSourceHandle.Purpose purpose = RemoteConfigSourceHandle.Purpose.API;
        Companion companion = Companion;
        this.api = new SourceFailover(purpose, companion.dedupe(companion.sourcesFor(topic, RemoteConfigSourceHandle.Purpose.API)), this.random, iMax);
        this.blob = new SourceFailover(RemoteConfigSourceHandle.Purpose.BLOB, companion.dedupe(companion.sourcesFor(topic, RemoteConfigSourceHandle.Purpose.BLOB)), this.random, iMax);
        this.builtHash = topic != null ? topic.getContentHash() : null;
        this.apiFailoverStartedAtMs = null;
    }

    /* JADX INFO: compiled from: RemoteConfigSourceProvider.kt */
    @Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u001aJ\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u0004\u0018\u00010\u0007*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/DefaultRemoteConfigSourceProvider$Companion;", "", "()V", "API_FAILOVER_RESTART_INTERVAL", "Lkotlin/time/Duration;", "J", "API_ITEM", "", "BLOB_ITEM", "DEFAULT_API_SOURCES", "", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSource;", "PRIORITY_KEY", "SOURCES_KEY", "URL_FORMAT_KEY", "URL_KEY", "WEIGHT_KEY", "dedupe", DefaultRemoteConfigSourceProvider.SOURCES_KEY, "parseSources", "topic", "Lcom/revenuecat/purchases/common/remoteconfig/ConfigTopic;", "itemKey", "urlKey", "sourcesFor", "purpose", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle$Purpose;", "int", "", "Lkotlinx/serialization/json/JsonObject;", SubscriberAttributeKt.JSON_NAME_KEY, "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", TypedValues.Custom.S_STRING, "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Companion {

        /* JADX INFO: compiled from: RemoteConfigSourceProvider.kt */
        @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[RemoteConfigSourceHandle.Purpose.values().length];
                try {
                    iArr[RemoteConfigSourceHandle.Purpose.API.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RemoteConfigSourceHandle.Purpose.BLOB.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<RemoteConfigSource> sourcesFor(ConfigTopic topic, RemoteConfigSourceHandle.Purpose purpose) {
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            int i = WhenMappings.$EnumSwitchMapping$0[purpose.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return parseSources(topic, DefaultRemoteConfigSourceProvider.BLOB_ITEM, DefaultRemoteConfigSourceProvider.URL_FORMAT_KEY);
                }
                throw new NoWhenBranchMatchedException();
            }
            List<RemoteConfigSource> sources = parseSources(topic, DefaultRemoteConfigSourceProvider.API_ITEM, "url");
            if (sources.isEmpty()) {
                sources = DefaultRemoteConfigSourceProvider.DEFAULT_API_SOURCES;
            }
            return sources;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final List<RemoteConfigSource> parseSources(ConfigTopic topic, String itemKey, String urlKey) {
            String strString;
            Integer numM13740int;
            RemoteConfigSource remoteConfigSource;
            RemoteConfiguration.ConfigItem configItem;
            JsonObject metadata;
            Intrinsics.checkNotNullParameter(itemKey, "itemKey");
            Intrinsics.checkNotNullParameter(urlKey, "urlKey");
            JsonElement jsonElement = (topic == null || (configItem = (RemoteConfiguration.ConfigItem) topic.get((Object) itemKey)) == null || (metadata = configItem.getMetadata()) == null) ? null : (JsonElement) metadata.get((Object) DefaultRemoteConfigSourceProvider.SOURCES_KEY);
            JsonArray jsonArray = jsonElement instanceof JsonArray ? (JsonArray) jsonElement : null;
            if (jsonArray == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (JsonElement jsonElement2 : jsonArray) {
                JsonObject jsonObject = jsonElement2 instanceof JsonObject ? (JsonObject) jsonElement2 : null;
                if (jsonObject != null && (strString = DefaultRemoteConfigSourceProvider.Companion.string(jsonObject, urlKey)) != null && (numM13740int = DefaultRemoteConfigSourceProvider.Companion.m13740int(jsonObject, "priority")) != null) {
                    int iIntValue = numM13740int.intValue();
                    Integer numM13740int2 = DefaultRemoteConfigSourceProvider.Companion.m13740int(jsonObject, DefaultRemoteConfigSourceProvider.WEIGHT_KEY);
                    remoteConfigSource = numM13740int2 != null ? new RemoteConfigSource(strString, iIntValue, numM13740int2.intValue()) : null;
                }
                if (remoteConfigSource != null) {
                    arrayList.add(remoteConfigSource);
                }
            }
            return arrayList;
        }

        private final String string(JsonObject jsonObject, String str) {
            Object obj = jsonObject.get((Object) str);
            JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
            if (jsonPrimitive != null) {
                if (!jsonPrimitive.getIsString()) {
                    jsonPrimitive = null;
                }
                if (jsonPrimitive != null) {
                    return jsonPrimitive.getContent();
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: int, reason: not valid java name */
        private final Integer m13740int(JsonObject jsonObject, String str) {
            Object obj = jsonObject.get((Object) str);
            JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
            if (jsonPrimitive != null) {
                return JsonElementKt.getIntOrNull(jsonPrimitive);
            }
            return null;
        }

        public final List<RemoteConfigSource> dedupe(List<RemoteConfigSource> sources) {
            Intrinsics.checkNotNullParameter(sources, "sources");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (RemoteConfigSource remoteConfigSource : sources) {
                RemoteConfigSource remoteConfigSource2 = (RemoteConfigSource) linkedHashMap.get(remoteConfigSource.getUrl());
                if (remoteConfigSource2 == null) {
                    linkedHashMap.put(remoteConfigSource.getUrl(), remoteConfigSource);
                } else {
                    if (remoteConfigSource.getPriority() != remoteConfigSource2.getPriority() || remoteConfigSource.getWeight() != remoteConfigSource2.getWeight()) {
                        LogLevel logLevel = LogLevel.WARN;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Found remote config sources sharing the same URL with conflicting priority/weight (" + remoteConfigSource.getUrl() + "). Keeping the highest-priority one (lowest priority number), tie-broken by weight.");
                        }
                    }
                    if (remoteConfigSource.getPriority() < remoteConfigSource2.getPriority() || (remoteConfigSource.getPriority() == remoteConfigSource2.getPriority() && remoteConfigSource.getWeight() > remoteConfigSource2.getWeight())) {
                        linkedHashMap.put(remoteConfigSource.getUrl(), remoteConfigSource);
                    }
                }
            }
            Collection collectionValues = linkedHashMap.values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "bestByUrl.values");
            return CollectionsKt.toList(collectionValues);
        }
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        API_FAILOVER_RESTART_INTERVAL = DurationKt.toDuration(2, DurationUnit.HOURS);
        DEFAULT_API_SOURCES = CollectionsKt.listOf((Object[]) new RemoteConfigSource[]{new RemoteConfigSource(AppConfig.baseUrlString, 100000, 1), new RemoteConfigSource("https://api.rc-backup.com/", 100001, 1)});
    }
}
