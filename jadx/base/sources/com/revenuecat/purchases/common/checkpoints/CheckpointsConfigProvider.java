package com.revenuecat.purchases.common.checkpoints;

import com.revenuecat.purchases.JsonTools;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.checkpoints.CheckpointRulesResolution;
import com.revenuecat.purchases.common.remoteconfig.ConfigTopic;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigConsistentReadKt;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigTopic;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: CheckpointsConfigProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"Lcom/revenuecat/purchases/common/checkpoints/CheckpointsConfigProvider;", "", "manager", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigManager;", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigManager;)V", "classifyUnresolved", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointRulesResolution;", Keys.IDENTIFIER, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCurrent", "", "resolution", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointRulesResolution$Found;", "readCheckpoint", "generation", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveCheckpoint", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CheckpointsConfigProvider {
    private final RemoteConfigManager manager;

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.checkpoints.CheckpointsConfigProvider$classifyUnresolved$1 */
    /* JADX INFO: compiled from: CheckpointsConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.checkpoints.CheckpointsConfigProvider", m1609f = "CheckpointsConfigProvider.kt", m1610i = {0}, m1611l = {57}, m1612m = "classifyUnresolved", m1613n = {Keys.IDENTIFIER}, m1615s = {"L$0"})
    static final class C71611 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C71611(Continuation<? super C71611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckpointsConfigProvider.this.classifyUnresolved(null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.checkpoints.CheckpointsConfigProvider$readCheckpoint$1 */
    /* JADX INFO: compiled from: CheckpointsConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.checkpoints.CheckpointsConfigProvider", m1609f = "CheckpointsConfigProvider.kt", m1610i = {0, 0, 0}, m1611l = {77, 37}, m1612m = "readCheckpoint", m1613n = {"this", Keys.IDENTIFIER, "generation"}, m1615s = {"L$0", "L$1", "I$0"})
    static final class C71621 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C71621(Continuation<? super C71621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckpointsConfigProvider.this.readCheckpoint(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.checkpoints.CheckpointsConfigProvider$resolveCheckpoint$1 */
    /* JADX INFO: compiled from: CheckpointsConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.checkpoints.CheckpointsConfigProvider", m1609f = "CheckpointsConfigProvider.kt", m1610i = {}, m1611l = {27}, m1612m = "resolveCheckpoint", m1613n = {}, m1615s = {})
    static final class C71631 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C71631(Continuation<? super C71631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckpointsConfigProvider.this.resolveCheckpoint(null, this);
        }
    }

    public CheckpointsConfigProvider(RemoteConfigManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.checkpoints.CheckpointsConfigProvider$resolveCheckpoint$3 */
    /* JADX INFO: compiled from: CheckpointsConfigProvider.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointRulesResolution;", "generation", ""}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.checkpoints.CheckpointsConfigProvider$resolveCheckpoint$3", m1609f = "CheckpointsConfigProvider.kt", m1610i = {}, m1611l = {28}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C71653 extends SuspendLambda implements Function2<Integer, Continuation<? super CheckpointRulesResolution>, Object> {
        final /* synthetic */ String $identifier;
        /* synthetic */ int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C71653(String str, Continuation<? super C71653> continuation) {
            super(2, continuation);
            this.$identifier = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C71653 c71653 = CheckpointsConfigProvider.this.new C71653(this.$identifier, continuation);
            c71653.I$0 = ((Number) obj).intValue();
            return c71653;
        }

        public final Object invoke(int i, Continuation<? super CheckpointRulesResolution> continuation) {
            return ((C71653) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super CheckpointRulesResolution> continuation) {
            return invoke(num.intValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            int i2 = this.I$0;
            this.label = 1;
            Object checkpoint = CheckpointsConfigProvider.this.readCheckpoint(this.$identifier, i2, this);
            return checkpoint == coroutine_suspended ? coroutine_suspended : checkpoint;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveCheckpoint(final String str, Continuation<? super CheckpointRulesResolution> continuation) {
        C71631 c71631;
        if (continuation instanceof C71631) {
            c71631 = (C71631) continuation;
            if ((c71631.label & Integer.MIN_VALUE) != 0) {
                c71631.label -= Integer.MIN_VALUE;
            } else {
                c71631 = new C71631(continuation);
            }
        }
        Object consistent = c71631.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c71631.label;
        if (i == 0) {
            ResultKt.throwOnFailure(consistent);
            RemoteConfigManager remoteConfigManager = this.manager;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.checkpoints.CheckpointsConfigProvider.resolveCheckpoint.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "checkpoint '" + str + '\'';
                }
            };
            C71653 c71653 = new C71653(str, null);
            c71631.label = 1;
            consistent = RemoteConfigConsistentReadKt.readConsistent(remoteConfigManager, function0, c71653, c71631);
            if (consistent == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(consistent);
        }
        CheckpointRulesResolution checkpointRulesResolution = (CheckpointRulesResolution) consistent;
        return checkpointRulesResolution == null ? CheckpointRulesResolution.Unavailable.INSTANCE : checkpointRulesResolution;
    }

    public final boolean isCurrent(CheckpointRulesResolution.Found resolution) {
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        return this.manager.getConfigGeneration() == resolution.getConfigGeneration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readCheckpoint(final String str, int i, Continuation<? super CheckpointRulesResolution> continuation) {
        C71621 c71621;
        CheckpointsConfigProvider checkpointsConfigProvider;
        if (continuation instanceof C71621) {
            c71621 = (C71621) continuation;
            if ((c71621.label & Integer.MIN_VALUE) != 0) {
                c71621.label -= Integer.MIN_VALUE;
            } else {
                c71621 = new C71621(continuation);
            }
        }
        Object objBlobData = c71621.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c71621.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objBlobData);
            RemoteConfigManager remoteConfigManager = this.manager;
            RemoteConfigTopic remoteConfigTopic = RemoteConfigTopic.CheckpointRules;
            Function1<byte[], CheckpointResponse> function1 = new Function1<byte[], CheckpointResponse>() { // from class: com.revenuecat.purchases.common.checkpoints.CheckpointsConfigProvider$readCheckpoint$$inlined$blobData$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Type inference failed for: r5v5, types: [com.revenuecat.purchases.common.checkpoints.CheckpointResponse, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public final CheckpointResponse invoke(byte[] bytes) {
                    Intrinsics.checkNotNullParameter(bytes, "bytes");
                    try {
                        Json json = JsonTools.INSTANCE.getJson();
                        String strDecodeToString = StringsKt.decodeToString(bytes);
                        json.getSerializersModule();
                        return json.decodeFromString(CheckpointResponse.INSTANCE.serializer(), strDecodeToString);
                    } catch (SerializationException e) {
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to parse remote config blob for item '" + str + "' as JSON.", e);
                        return null;
                    }
                }
            };
            c71621.L$0 = this;
            c71621.L$1 = str;
            c71621.I$0 = i;
            c71621.label = 1;
            objBlobData = remoteConfigManager.blobData(remoteConfigTopic, str, function1, c71621);
            if (objBlobData != coroutine_suspended) {
                checkpointsConfigProvider = this;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objBlobData);
            return objBlobData;
        }
        i = c71621.I$0;
        str = (String) c71621.L$1;
        checkpointsConfigProvider = (CheckpointsConfigProvider) c71621.L$0;
        ResultKt.throwOnFailure(objBlobData);
        CheckpointResponse checkpointResponse = (CheckpointResponse) objBlobData;
        if (checkpointResponse != null) {
            return new CheckpointRulesResolution.Found(checkpointResponse, i);
        }
        c71621.L$0 = null;
        c71621.L$1 = null;
        c71621.label = 2;
        Object objClassifyUnresolved = checkpointsConfigProvider.classifyUnresolved(str, c71621);
        return objClassifyUnresolved == coroutine_suspended ? coroutine_suspended : objClassifyUnresolved;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object classifyUnresolved(String str, Continuation<? super CheckpointRulesResolution> continuation) {
        C71611 c71611;
        if (continuation instanceof C71611) {
            c71611 = (C71611) continuation;
            if ((c71611.label & Integer.MIN_VALUE) != 0) {
                c71611.label -= Integer.MIN_VALUE;
            } else {
                c71611 = new C71611(continuation);
            }
        }
        Object objCommittedTopicOrNull = c71611.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c71611.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCommittedTopicOrNull);
            if (!this.manager.isDisabled()) {
                RemoteConfigManager remoteConfigManager = this.manager;
                RemoteConfigTopic remoteConfigTopic = RemoteConfigTopic.CheckpointRules;
                c71611.L$0 = str;
                c71611.label = 1;
                objCommittedTopicOrNull = remoteConfigManager.committedTopicOrNull(remoteConfigTopic, c71611);
                if (objCommittedTopicOrNull == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Checkpoint '" + str + "' is unavailable: remote config is disabled for this SDK configuration.", null);
                return CheckpointRulesResolution.Unavailable.INSTANCE;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c71611.L$0;
            ResultKt.throwOnFailure(objCommittedTopicOrNull);
        }
        ConfigTopic configTopic = (ConfigTopic) objCommittedTopicOrNull;
        if (configTopic != null) {
            if (configTopic.containsKey((Object) str)) {
                LogLevel logLevel = LogLevel.VERBOSE;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Checkpoint '" + str + "' is published, but its rules could not be read.");
                }
                return CheckpointRulesResolution.Unavailable.INSTANCE;
            }
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.mo1544v("[Purchases] - " + logLevel2.name(), "The checkpoint_rules topic carries no item for '" + str + "'; it is not configured.");
            }
            return CheckpointRulesResolution.NotConfigured.INSTANCE;
        }
        LogLevel logLevel3 = LogLevel.VERBOSE;
        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
            currentLogHandler3.mo1544v("[Purchases] - " + logLevel3.name(), "The checkpoint_rules topic is not committed; checkpoint '" + str + "' is unknown.");
        }
        return CheckpointRulesResolution.Unavailable.INSTANCE;
    }
}
