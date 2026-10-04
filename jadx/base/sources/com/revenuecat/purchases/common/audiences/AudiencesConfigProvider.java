package com.revenuecat.purchases.common.audiences;

import com.revenuecat.purchases.JsonTools;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.remoteconfig.ConfigTopic;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigConsistentReadKt;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigTopic;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfiguration;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: AudiencesConfigProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/revenuecat/purchases/common/audiences/AudiencesConfigProvider;", "", "manager", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigManager;", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigManager;)V", "getAudience", "Lcom/revenuecat/purchases/common/audiences/Audience;", Keys.IDENTIFIER, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class AudiencesConfigProvider {
    private final RemoteConfigManager manager;

    public AudiencesConfigProvider(RemoteConfigManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.audiences.AudiencesConfigProvider$getAudience$3 */
    /* JADX INFO: compiled from: AudiencesConfigProvider.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/common/audiences/Audience;", "<anonymous parameter 0>", ""}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.audiences.AudiencesConfigProvider$getAudience$3", m1609f = "AudiencesConfigProvider.kt", m1610i = {}, m1611l = {16}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C71583 extends SuspendLambda implements Function2<Integer, Continuation<? super Audience>, Object> {
        final /* synthetic */ String $identifier;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C71583(String str, Continuation<? super C71583> continuation) {
            super(2, continuation);
            this.$identifier = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AudiencesConfigProvider.this.new C71583(this.$identifier, continuation);
        }

        public final Object invoke(int i, Continuation<? super Audience> continuation) {
            return ((C71583) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Audience> continuation) {
            return invoke(num.intValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            RemoteConfiguration.ConfigItem configItem;
            JsonObject metadata;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AudiencesConfigProvider.this.manager.topic(RemoteConfigTopic.Audiences, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ConfigTopic configTopic = (ConfigTopic) obj;
            if (configTopic != null && (configItem = (RemoteConfiguration.ConfigItem) configTopic.get((Object) this.$identifier)) != null && (metadata = configItem.getMetadata()) != null) {
                try {
                    Json json = JsonTools.INSTANCE.getJson();
                    json.getSerializersModule();
                    return (Audience) json.decodeFromJsonElement(Audience.INSTANCE.serializer(), metadata);
                } catch (SerializationException e) {
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to parse remote config metadata for audience '" + this.$identifier + "' as JSON.", e);
                }
            }
            return null;
        }
    }

    public final Object getAudience(final String str, Continuation<? super Audience> continuation) {
        return RemoteConfigConsistentReadKt.readConsistent(this.manager, new Function0<String>() { // from class: com.revenuecat.purchases.common.audiences.AudiencesConfigProvider.getAudience.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "audience '" + str + '\'';
            }
        }, new C71583(str, null), continuation);
    }
}
