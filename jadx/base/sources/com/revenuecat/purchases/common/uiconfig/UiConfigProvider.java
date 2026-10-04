package com.revenuecat.purchases.common.uiconfig;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.myscript.nebo.LaunchActivity;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.JsonTools;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.remoteconfig.ConfigTopic;
import com.revenuecat.purchases.common.remoteconfig.GenerationGuardedCache;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigCommitListener;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigConsistentReadKt;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigTopic;
import com.revenuecat.purchases.common.uiconfig.UiConfigResolution;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: UiConfigProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0086@¢\u0006\u0002\u0010\fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0002\u0010\fJ\u000e\u0010\u0017\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u0018\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\fJ\u0016\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1599d2 = {"Lcom/revenuecat/purchases/common/uiconfig/UiConfigProvider;", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigCommitListener;", "manager", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigManager;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigManager;Lkotlinx/coroutines/CoroutineScope;)V", "cache", "Lcom/revenuecat/purchases/common/remoteconfig/GenerationGuardedCache;", "Lcom/revenuecat/purchases/UiConfig;", "classifyUnresolved", "Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "getUiConfig", "isWarm", "", "onConfigCommitted", "generation", "", "onConfigInvalidated", "resolve", "resolveUiConfig", "warm", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "warmAsync", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class UiConfigProvider implements RemoteConfigCommitListener {
    private static final Companion Companion = new Companion(null);
    private static final List<String> ITEM_KEYS = CollectionsKt.listOf((Object[]) new String[]{LaunchActivity.LaunchRoute.App, "localizations", "variable_config", "custom_variables"});
    private final GenerationGuardedCache<UiConfig> cache;
    private final RemoteConfigManager manager;
    private final CoroutineScope scope;

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.uiconfig.UiConfigProvider$classifyUnresolved$1 */
    /* JADX INFO: compiled from: UiConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.uiconfig.UiConfigProvider", m1609f = "UiConfigProvider.kt", m1610i = {}, m1611l = {154}, m1612m = "classifyUnresolved", m1613n = {}, m1615s = {})
    static final class C72451 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C72451(Continuation<? super C72451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UiConfigProvider.this.classifyUnresolved(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.uiconfig.UiConfigProvider$getUiConfig$1 */
    /* JADX INFO: compiled from: UiConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.uiconfig.UiConfigProvider", m1609f = "UiConfigProvider.kt", m1610i = {}, m1611l = {58}, m1612m = "getUiConfig", m1613n = {}, m1615s = {})
    static final class C72461 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C72461(Continuation<? super C72461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UiConfigProvider.this.getUiConfig(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.uiconfig.UiConfigProvider$resolve$1 */
    /* JADX INFO: compiled from: UiConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.uiconfig.UiConfigProvider", m1609f = "UiConfigProvider.kt", m1610i = {0, 1}, m1611l = {TsExtractor.TS_STREAM_TYPE_AC3, PDFACompliance.e_PDFA1_3_1, PDFACompliance.e_PDFA1_8_2}, m1612m = "resolve", m1613n = {"this", "this"}, m1615s = {"L$0", "L$0"})
    static final class C72481 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C72481(Continuation<? super C72481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UiConfigProvider.this.resolve(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.uiconfig.UiConfigProvider$resolveUiConfig$1 */
    /* JADX INFO: compiled from: UiConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.uiconfig.UiConfigProvider", m1609f = "UiConfigProvider.kt", m1610i = {}, m1611l = {67}, m1612m = "resolveUiConfig", m1613n = {}, m1615s = {})
    static final class C72491 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C72491(Continuation<? super C72491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UiConfigProvider.this.resolveUiConfig(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.uiconfig.UiConfigProvider$warm$1 */
    /* JADX INFO: compiled from: UiConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.uiconfig.UiConfigProvider", m1609f = "UiConfigProvider.kt", m1610i = {0, 0, 1, 1}, m1611l = {97, 98}, m1612m = "warm", m1613n = {"this", "generation", "this", "generation"}, m1615s = {"L$0", "I$0", "L$0", "I$0"})
    static final class C72501 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C72501(Continuation<? super C72501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UiConfigProvider.this.warm(0, this);
        }
    }

    public UiConfigProvider(RemoteConfigManager manager, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.manager = manager;
        this.scope = scope;
        this.cache = new GenerationGuardedCache<>();
    }

    public /* synthetic */ UiConfigProvider(RemoteConfigManager remoteConfigManager, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(remoteConfigManager, (i & 2) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())) : coroutineScope);
    }

    public final boolean isWarm() {
        return this.cache.isWarm();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getUiConfig(Continuation<? super UiConfig> continuation) {
        C72461 c72461;
        if (continuation instanceof C72461) {
            c72461 = (C72461) continuation;
            if ((c72461.label & Integer.MIN_VALUE) != 0) {
                c72461.label -= Integer.MIN_VALUE;
            } else {
                c72461 = new C72461(continuation);
            }
        }
        Object objResolveUiConfig = c72461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72461.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objResolveUiConfig);
            c72461.label = 1;
            objResolveUiConfig = resolveUiConfig(c72461);
            if (objResolveUiConfig == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objResolveUiConfig);
        }
        UiConfigResolution.Found found = objResolveUiConfig instanceof UiConfigResolution.Found ? (UiConfigResolution.Found) objResolveUiConfig : null;
        if (found != null) {
            return found.getUiConfig();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveUiConfig(Continuation<? super UiConfigResolution> continuation) {
        C72491 c72491;
        if (continuation instanceof C72491) {
            c72491 = (C72491) continuation;
            if ((c72491.label & Integer.MIN_VALUE) != 0) {
                c72491.label -= Integer.MIN_VALUE;
            } else {
                c72491 = new C72491(continuation);
            }
        }
        Object consistent = c72491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72491.label;
        if (i == 0) {
            ResultKt.throwOnFailure(consistent);
            UiConfig cached = this.cache.getCached();
            if (cached != null) {
                return new UiConfigResolution.Found(cached);
            }
            RemoteConfigManager remoteConfigManager = this.manager;
            UiConfigProvider$resolveUiConfig$resolution$1 uiConfigProvider$resolveUiConfig$resolution$1 = new Function0<String>() { // from class: com.revenuecat.purchases.common.uiconfig.UiConfigProvider$resolveUiConfig$resolution$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "ui_config";
                }
            };
            UiConfigProvider$resolveUiConfig$resolution$2 uiConfigProvider$resolveUiConfig$resolution$2 = new UiConfigProvider$resolveUiConfig$resolution$2(this, null);
            c72491.label = 1;
            consistent = RemoteConfigConsistentReadKt.readConsistent(remoteConfigManager, uiConfigProvider$resolveUiConfig$resolution$1, uiConfigProvider$resolveUiConfig$resolution$2, c72491);
            if (consistent == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(consistent);
        }
        UiConfigResolution uiConfigResolution = (UiConfigResolution) consistent;
        return uiConfigResolution == null ? UiConfigResolution.Superseded.INSTANCE : uiConfigResolution;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object warm(int i, Continuation<? super Unit> continuation) {
        C72501 c72501;
        UiConfigProvider uiConfigProvider;
        UiConfigProvider uiConfigProvider2;
        UiConfig uiConfig;
        if (continuation instanceof C72501) {
            c72501 = (C72501) continuation;
            if ((c72501.label & Integer.MIN_VALUE) != 0) {
                c72501.label -= Integer.MIN_VALUE;
            } else {
                c72501 = new C72501(continuation);
            }
        }
        Object objCommittedTopicOrNull = c72501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c72501.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCommittedTopicOrNull);
            if (this.cache.isWarmAtOrAbove(i)) {
                return Unit.INSTANCE;
            }
            RemoteConfigManager remoteConfigManager = this.manager;
            RemoteConfigTopic remoteConfigTopic = RemoteConfigTopic.UiConfig;
            c72501.L$0 = this;
            c72501.I$0 = i;
            c72501.label = 1;
            objCommittedTopicOrNull = remoteConfigManager.committedTopicOrNull(remoteConfigTopic, c72501);
            if (objCommittedTopicOrNull != coroutine_suspended) {
                uiConfigProvider = this;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c72501.I$0;
            uiConfigProvider2 = (UiConfigProvider) c72501.L$0;
            ResultKt.throwOnFailure(objCommittedTopicOrNull);
            uiConfig = (UiConfig) objCommittedTopicOrNull;
            if (uiConfig != null) {
                uiConfigProvider2.cache.invalidate(i);
            } else {
                uiConfigProvider2.cache.store(i, uiConfig);
            }
            return Unit.INSTANCE;
        }
        i = c72501.I$0;
        uiConfigProvider = (UiConfigProvider) c72501.L$0;
        ResultKt.throwOnFailure(objCommittedTopicOrNull);
        if (objCommittedTopicOrNull == null) {
            return Unit.INSTANCE;
        }
        c72501.L$0 = uiConfigProvider;
        c72501.I$0 = i;
        c72501.label = 2;
        objCommittedTopicOrNull = uiConfigProvider.resolve(c72501);
        if (objCommittedTopicOrNull != coroutine_suspended) {
            uiConfigProvider2 = uiConfigProvider;
            uiConfig = (UiConfig) objCommittedTopicOrNull;
            if (uiConfig != null) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    public final Object warm(Continuation<? super Unit> continuation) {
        Object objWarm = warm(this.manager.getConfigGeneration(), continuation);
        return objWarm == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWarm : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.uiconfig.UiConfigProvider$warmAsync$1 */
    /* JADX INFO: compiled from: UiConfigProvider.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.uiconfig.UiConfigProvider$warmAsync$1", m1609f = "UiConfigProvider.kt", m1610i = {}, m1611l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $generation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72511(int i, Continuation<? super C72511> continuation) {
            super(2, continuation);
            this.$generation = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UiConfigProvider.this.new C72511(this.$generation, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C72511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (UiConfigProvider.this.warm(this.$generation, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void warmAsync(int generation) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C72511(generation, null), 3, null);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.uiconfig.UiConfigProvider$onConfigCommitted$1 */
    /* JADX INFO: compiled from: UiConfigProvider.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.uiconfig.UiConfigProvider$onConfigCommitted$1", m1609f = "UiConfigProvider.kt", m1610i = {}, m1611l = {113}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $generation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72471(int i, Continuation<? super C72471> continuation) {
            super(2, continuation);
            this.$generation = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UiConfigProvider.this.new C72471(this.$generation, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C72471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (UiConfigProvider.this.warm(this.$generation, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.revenuecat.purchases.common.remoteconfig.RemoteConfigCommitListener
    public void onConfigCommitted(int generation) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C72471(generation, null), 3, null);
    }

    @Override // com.revenuecat.purchases.common.remoteconfig.RemoteConfigCommitListener
    public void onConfigInvalidated(int generation) {
        this.cache.invalidate(generation);
    }

    public final void close() {
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009f, code lost:
    
        if (r9 == r1) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolve(Continuation<? super UiConfig> continuation) {
        C72481 c72481;
        UiConfigProvider uiConfigProvider;
        ConfigTopic configTopic;
        if (continuation instanceof C72481) {
            c72481 = (C72481) continuation;
            if ((c72481.label & Integer.MIN_VALUE) != 0) {
                c72481.label -= Integer.MIN_VALUE;
            } else {
                c72481 = new C72481(continuation);
            }
        }
        Object objCommittedTopicAfterInFlightRefresh = c72481.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72481.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCommittedTopicAfterInFlightRefresh);
            if (this.manager.isDisabled()) {
                return null;
            }
            RemoteConfigManager remoteConfigManager = this.manager;
            RemoteConfigTopic remoteConfigTopic = RemoteConfigTopic.UiConfig;
            c72481.L$0 = this;
            c72481.label = 1;
            objCommittedTopicAfterInFlightRefresh = remoteConfigManager.topic(remoteConfigTopic, c72481);
            if (objCommittedTopicAfterInFlightRefresh != coroutine_suspended) {
                uiConfigProvider = this;
            }
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objCommittedTopicAfterInFlightRefresh);
                return objCommittedTopicAfterInFlightRefresh;
            }
            uiConfigProvider = (UiConfigProvider) c72481.L$0;
            ResultKt.throwOnFailure(objCommittedTopicAfterInFlightRefresh);
            configTopic = (ConfigTopic) objCommittedTopicAfterInFlightRefresh;
            if (configTopic != null) {
                List<String> list = ITEM_KEYS;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (configTopic.containsKey(it.next())) {
                            RemoteConfigManager remoteConfigManager2 = uiConfigProvider.manager;
                            final RemoteConfigTopic remoteConfigTopic2 = RemoteConfigTopic.UiConfig;
                            List<String> list2 = ITEM_KEYS;
                            Function1<JsonObject, UiConfig> function1 = new Function1<JsonObject, UiConfig>() { // from class: com.revenuecat.purchases.common.uiconfig.UiConfigProvider$resolve$$inlined$mergeItemsBlobData$1
                                {
                                    super(1);
                                }

                                /* JADX WARN: Type inference failed for: r5v5, types: [com.revenuecat.purchases.UiConfig, java.lang.Object] */
                                @Override // kotlin.jvm.functions.Function1
                                public final UiConfig invoke(JsonObject merged) {
                                    Intrinsics.checkNotNullParameter(merged, "merged");
                                    try {
                                        Json json = JsonTools.INSTANCE.getJson();
                                        json.getSerializersModule();
                                        return json.decodeFromJsonElement(UiConfig.INSTANCE.serializer(), merged);
                                    } catch (SerializationException e) {
                                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to decode merged remote config blobs from topic '" + remoteConfigTopic2.getWireName() + "' as JSON.", e);
                                        return null;
                                    }
                                }
                            };
                            c72481.L$0 = null;
                            c72481.label = 3;
                            Object objMergeItemsBlobData = remoteConfigManager2.mergeItemsBlobData(remoteConfigTopic2, list2, function1, c72481);
                            return objMergeItemsBlobData == coroutine_suspended ? coroutine_suspended : objMergeItemsBlobData;
                        }
                    }
                }
            }
            return null;
        }
        uiConfigProvider = (UiConfigProvider) c72481.L$0;
        ResultKt.throwOnFailure(objCommittedTopicAfterInFlightRefresh);
        configTopic = (ConfigTopic) objCommittedTopicAfterInFlightRefresh;
        if (configTopic == null) {
            if (configTopic != null) {
            }
            return null;
        }
        List<String> list3 = ITEM_KEYS;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                if (configTopic.containsKey(it2.next())) {
                    break;
                }
            }
        }
        RemoteConfigManager remoteConfigManager3 = uiConfigProvider.manager;
        RemoteConfigTopic remoteConfigTopic3 = RemoteConfigTopic.UiConfig;
        c72481.L$0 = uiConfigProvider;
        c72481.label = 2;
        objCommittedTopicAfterInFlightRefresh = remoteConfigManager3.committedTopicAfterInFlightRefresh(remoteConfigTopic3, c72481);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object classifyUnresolved(Continuation<? super UiConfigResolution> continuation) {
        C72451 c72451;
        if (continuation instanceof C72451) {
            c72451 = (C72451) continuation;
            if ((c72451.label & Integer.MIN_VALUE) != 0) {
                c72451.label -= Integer.MIN_VALUE;
            } else {
                c72451 = new C72451(continuation);
            }
        }
        Object objCommittedTopicOrNull = c72451.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72451.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCommittedTopicOrNull);
            if (!this.manager.isDisabled()) {
                RemoteConfigManager remoteConfigManager = this.manager;
                RemoteConfigTopic remoteConfigTopic = RemoteConfigTopic.UiConfig;
                c72451.label = 1;
                objCommittedTopicOrNull = remoteConfigManager.committedTopicOrNull(remoteConfigTopic, c72451);
                if (objCommittedTopicOrNull == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "ui_config is unavailable: remote config is disabled for this SDK configuration.", null);
                return UiConfigResolution.Unavailable.INSTANCE;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objCommittedTopicOrNull);
        }
        ConfigTopic configTopic = (ConfigTopic) objCommittedTopicOrNull;
        List<String> list = ITEM_KEYS;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            String str = (String) obj;
            if (configTopic != null && configTopic.containsKey((Object) str)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "The ui_config topic " + (configTopic == null ? "is absent" : "carries no ui_config part") + "; nothing to resolve.");
            }
            return UiConfigResolution.NotConfigured.INSTANCE;
        }
        LogLevel logLevel2 = LogLevel.VERBOSE;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
            currentLogHandler2.mo1544v("[Purchases] - " + logLevel2.name(), "The ui_config topic carries " + arrayList2.size() + " of " + ITEM_KEYS.size() + " part(s) " + arrayList2 + ", but they could not be resolved into a UiConfig.");
        }
        return UiConfigResolution.Unavailable.INSTANCE;
    }

    /* JADX INFO: compiled from: UiConfigProvider.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/uiconfig/UiConfigProvider$Companion;", "", "()V", "ITEM_KEYS", "", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
