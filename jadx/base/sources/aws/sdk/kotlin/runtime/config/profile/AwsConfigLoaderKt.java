package aws.sdk.kotlin.runtime.config.profile;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContext;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContextKt;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import aws.smithy.kotlin.runtime.telemetry.context.ContextManager;
import aws.smithy.kotlin.runtime.telemetry.context.TelemetryContextElement;
import aws.smithy.kotlin.runtime.telemetry.context.TelemetryContextElementKt;
import aws.smithy.kotlin.runtime.telemetry.trace.SpanKind;
import aws.smithy.kotlin.runtime.telemetry.trace.SpanStatus;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpanContext;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpanExtKt;
import aws.smithy.kotlin.runtime.telemetry.trace.Tracer;
import aws.smithy.kotlin.runtime.util.OsFamily;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: AwsConfigLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0087@¢\u0006\u0002\u0010\b\u001a\u0081\u0001\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\nj\u0002`\u000e2R\u0010\u000f\u001a*\u0012&\b\u0001\u0012\"\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\nj\u0002`\u000e0\u0010\"\"\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\nj\u0002`\u000eH\u0000¢\u0006\u0002\u0010\u0011\u001a6\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\nj\u0002`\r2\u001c\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\u0013H\u0002\u001a\u001c\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0005*\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0019H\u0002¨\u0006\u001a"}, m1599d2 = {"loadAwsSharedConfig", "Laws/sdk/kotlin/runtime/config/profile/AwsSharedConfig;", DeviceDimensionProvider.KEY_PLATFORM, "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "profileNameOverride", "", "configurationSource", "Laws/sdk/kotlin/runtime/config/profile/AwsConfigurationSource;", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Ljava/lang/String;Laws/sdk/kotlin/runtime/config/profile/AwsConfigurationSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mergeFiles", "", "Laws/sdk/kotlin/runtime/config/profile/ConfigSectionType;", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/SectionMap;", "Laws/sdk/kotlin/runtime/config/profile/TypedSectionMap;", "maps", "", "([Ljava/util/Map;)Ljava/util/Map;", "mergeSectionMaps", "", "resolveConfigSource", "normalizePath", ClientCookie.PATH_ATTR, "resolveHomeDir", "concatOrNull", "Lkotlin/Pair;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsConfigLoaderKt {

    /* JADX INFO: compiled from: AwsConfigLoader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OsFamily.values().length];
            try {
                iArr[OsFamily.Unknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OsFamily.Windows.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt$loadAwsSharedConfig$1 */
    /* JADX INFO: compiled from: AwsConfigLoader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt", m1609f = "AwsConfigLoader.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {158}, m1612m = "loadAwsSharedConfig", m1613n = {DeviceDimensionProvider.KEY_PLATFORM, "profileNameOverride", "configurationSource", "sourceComponent$iv", "name$iv", "initialAttributes$iv", "spanKind$iv", "context$iv", "tracer$iv", "$this$withSpan$iv$iv", "name$iv$iv", "initialAttributes$iv$iv", "spanKind$iv$iv", "context$iv$iv", "parent$iv$iv", "span$iv$iv", "span$iv$iv$iv", "context$iv$iv$iv", "telemetryCtxElement$iv$iv$iv", "updatedCtx$iv$iv$iv", "$i$f$withSpan", "$i$f$withSpan", "$i$f$withSpan"}, m1614nl = {159}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "I$0", "I$1", "I$2"}, m1616v = 2)
    static final class C31151 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C31151(Continuation<? super C31151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwsConfigLoaderKt.loadAwsSharedConfig(null, null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01bf A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:12:0x007e, B:46:0x01bb, B:48:0x01bf, B:50:0x01d4, B:49:0x01c9), top: B:53:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c9 A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:12:0x007e, B:46:0x01bb, B:48:0x01bf, B:50:0x01d4, B:49:0x01c9), top: B:53:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan] */
    /* JADX WARN: Type inference failed for: r2v2 */
    @InternalSdkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object loadAwsSharedConfig(PlatformProvider platformProvider, String str, AwsConfigurationSource awsConfigurationSource, Continuation<? super AwsSharedConfig> continuation) throws Throwable {
        C31151 c31151;
        TraceSpan traceSpan;
        CoroutineContext telemetryContextElement;
        TelemetryProvider provider;
        ContextManager contextManager;
        if (continuation instanceof C31151) {
            c31151 = (C31151) continuation;
            if ((c31151.label & Integer.MIN_VALUE) != 0) {
                c31151.label -= Integer.MIN_VALUE;
            } else {
                c31151 = new C31151(continuation);
            }
        }
        Object objWithContext = c31151.result;
        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31151.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c31151.I$2;
                int i3 = c31151.I$1;
                int i4 = c31151.I$0;
                traceSpan = (TraceSpan) c31151.L$16;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    traceSpan.close();
                    return objWithContext;
                } catch (Exception e) {
                    e = e;
                    if (e instanceof CancellationException) {
                        traceSpan.setStatus(SpanStatus.ERROR);
                        TraceSpanExtKt.recordException(traceSpan, e, true);
                    } else {
                        TraceSpanExtKt.setAttribute(traceSpan, "cancelled", Boxing.boxBoolean(true));
                    }
                    throw e;
                }
            }
            ResultKt.throwOnFailure(objWithContext);
            Attributes attributesEmptyAttributes = AttributesKt.emptyAttributes();
            SpanKind spanKind = SpanKind.INTERNAL;
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
            Tracer orCreateTracer = TelemetryProviderContextKt.getTelemetryProvider(c31151.getContext()).getTracerProvider().getOrCreateTracer("AwsSharedConfig");
            Context telemetryContext = TelemetryContextElementKt.getTelemetryContext(c31151.getContext());
            TraceSpan traceSpanCreateSpan = orCreateTracer.createSpan("loadAwsSharedConfig", attributesEmptyAttributes, spanKind, telemetryContext);
            try {
                TelemetryProviderContext telemetryProviderContext = (TelemetryProviderContext) c31151.getContext().get(TelemetryProviderContext.INSTANCE);
                Context contextCurrent = (telemetryProviderContext == null || (provider = telemetryProviderContext.getProvider()) == null || (contextManager = provider.getContextManager()) == null) ? null : contextManager.current();
                if (contextCurrent != null) {
                    telemetryContextElement = new TelemetryContextElement(contextCurrent);
                } else {
                    telemetryContextElement = (TelemetryContextElement) c31151.getContext().get(TelemetryContextElement.INSTANCE);
                    if (telemetryContextElement == null) {
                        telemetryContextElement = EmptyCoroutineContext.INSTANCE;
                    }
                }
                CoroutineContext coroutineContext = telemetryContextElement;
                CoroutineContext coroutineContextPlus = emptyCoroutineContext.plus(new TraceSpanContext(traceSpanCreateSpan)).plus(coroutineContext).plus(traceSpanCreateSpan.asContextElement());
                Context context = contextCurrent;
                C3114x64acf9a8 c3114x64acf9a8 = new C3114x64acf9a8(traceSpanCreateSpan, null, awsConfigurationSource, platformProvider, str);
                c31151.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider);
                c31151.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c31151.L$2 = SpillingKt.nullOutSpilledVariable(awsConfigurationSource);
                c31151.L$3 = SpillingKt.nullOutSpilledVariable("AwsSharedConfig");
                c31151.L$4 = SpillingKt.nullOutSpilledVariable("loadAwsSharedConfig");
                c31151.L$5 = SpillingKt.nullOutSpilledVariable(attributesEmptyAttributes);
                c31151.L$6 = SpillingKt.nullOutSpilledVariable(spanKind);
                c31151.L$7 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
                c31151.L$8 = SpillingKt.nullOutSpilledVariable(orCreateTracer);
                c31151.L$9 = SpillingKt.nullOutSpilledVariable(orCreateTracer);
                c31151.L$10 = SpillingKt.nullOutSpilledVariable("loadAwsSharedConfig");
                c31151.L$11 = SpillingKt.nullOutSpilledVariable(attributesEmptyAttributes);
                c31151.L$12 = SpillingKt.nullOutSpilledVariable(spanKind);
                c31151.L$13 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
                c31151.L$14 = SpillingKt.nullOutSpilledVariable(telemetryContext);
                c31151.L$15 = SpillingKt.nullOutSpilledVariable(traceSpanCreateSpan);
                c31151.L$16 = traceSpanCreateSpan;
                c31151.L$17 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
                c31151.L$18 = SpillingKt.nullOutSpilledVariable(coroutineContext);
                c31151.L$19 = SpillingKt.nullOutSpilledVariable(context);
                c31151.I$0 = 0;
                c31151.I$1 = 0;
                c31151.I$2 = 0;
                c31151.label = 1;
                objWithContext = BuildersKt.withContext(coroutineContextPlus, c3114x64acf9a8, c31151);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                traceSpan = traceSpanCreateSpan;
                traceSpan.close();
                return objWithContext;
            } catch (Exception e2) {
                e = e2;
                traceSpan = traceSpanCreateSpan;
                if (e instanceof CancellationException) {
                }
                throw e;
            } catch (Throwable th) {
                th = th;
                coroutine_suspended = traceSpanCreateSpan;
                coroutine_suspended.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static /* synthetic */ Object loadAwsSharedConfig$default(PlatformProvider platformProvider, String str, AwsConfigurationSource awsConfigurationSource, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            awsConfigurationSource = null;
        }
        return loadAwsSharedConfig(platformProvider, str, awsConfigurationSource, continuation);
    }

    public static final Map<ConfigSectionType, Map<String, ConfigSection>> mergeFiles(Map<ConfigSectionType, ? extends Map<String, ConfigSection>>... maps) {
        Intrinsics.checkNotNullParameter(maps, "maps");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (ConfigSectionType configSectionType : ConfigSectionType.values()) {
            ArrayList arrayList = new ArrayList();
            for (Map<ConfigSectionType, ? extends Map<String, ConfigSection>> map : maps) {
                Map<String, ConfigSection> map2 = map.get(configSectionType);
                if (map2 != null) {
                    arrayList.add(map2);
                }
            }
            mapCreateMapBuilder.put(configSectionType, mergeSectionMaps(arrayList));
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    private static final Map<String, ConfigSection> mergeSectionMaps(List<? extends Map<String, ConfigSection>> list) {
        Map<String, AwsConfigValue> mapEmptyMap;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            for (Map.Entry entry : ((Map) it.next()).entrySet()) {
                ConfigSection configSection = (ConfigSection) mapCreateMapBuilder.get(entry.getKey());
                if (configSection == null || (mapEmptyMap = configSection.getProperties$aws_config()) == null) {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                ConfigSection configSection2 = new ConfigSection((String) entry.getKey(), MapsKt.plus(mapEmptyMap, ((ConfigSection) entry.getValue()).getProperties$aws_config()), ((ConfigSection) entry.getValue()).getSectionType$aws_config());
                mapCreateMapBuilder.put(configSection2.getName(), configSection2);
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    public static /* synthetic */ AwsConfigurationSource resolveConfigSource$default(PlatformProvider platformProvider, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return resolveConfigSource(platformProvider, str);
    }

    public static final AwsConfigurationSource resolveConfigSource(PlatformProvider platform, String str) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        if (str == null && (str = (String) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsProfile(), platform)) == null) {
            str = "default";
        }
        return new AwsConfigurationSource(str, normalizePath(FileType.CONFIGURATION.path(platform), platform), normalizePath(FileType.CREDENTIAL.path(platform), platform));
    }

    public static final String normalizePath(String path, PlatformProvider platform) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(platform, "platform");
        if (!StringsKt.startsWith$default((CharSequence) StringsKt.trim((CharSequence) path).toString(), '~', false, 2, (Object) null)) {
            return path;
        }
        String strResolveHomeDir = resolveHomeDir(platform);
        if (strResolveHomeDir == null) {
            throw new IllegalStateException("Unable to determine user home directory".toString());
        }
        StringBuilder sbAppend = new StringBuilder().append(strResolveHomeDir);
        String strSubstring = path.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sbAppend.append(strSubstring).toString();
    }

    private static final String resolveHomeDir(PlatformProvider platformProvider) {
        int i = WhenMappings.$EnumSwitchMapping$0[platformProvider.getOs().getFamily().ordinal()];
        if (i == 1 || i == 2) {
            String strConcatOrNull = platformProvider.getenv("HOME");
            return (strConcatOrNull == null && (strConcatOrNull = platformProvider.getenv("USERPROFILE")) == null && (strConcatOrNull = concatOrNull(TuplesKt.m1606to(platformProvider.getenv("HOMEDRIVE"), platformProvider.getenv("HOMEPATH")))) == null) ? platformProvider.getProperty("user.home") : strConcatOrNull;
        }
        String str = platformProvider.getenv("HOME");
        return str == null ? platformProvider.getProperty("user.home") : str;
    }

    private static final String concatOrNull(Pair<String, String> pair) {
        if (pair.getFirst() == null || pair.getSecond() == null) {
            return null;
        }
        return pair.getFirst() + pair.getSecond();
    }
}
