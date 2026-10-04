package com.revenuecat.purchases.common.uiconfig;

import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.uiconfig.UiConfigResolution;
import com.yalantis.ucrop.UCrop;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: UiConfigProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution;", "generation", ""}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.common.uiconfig.UiConfigProvider$resolveUiConfig$resolution$2", m1609f = "UiConfigProvider.kt", m1610i = {0}, m1611l = {68, UCrop.REQUEST_CROP}, m1612m = "invokeSuspend", m1613n = {"generation"}, m1615s = {"I$0"})
final class UiConfigProvider$resolveUiConfig$resolution$2 extends SuspendLambda implements Function2<Integer, Continuation<? super UiConfigResolution>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ UiConfigProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UiConfigProvider$resolveUiConfig$resolution$2(UiConfigProvider uiConfigProvider, Continuation<? super UiConfigProvider$resolveUiConfig$resolution$2> continuation) {
        super(2, continuation);
        this.this$0 = uiConfigProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UiConfigProvider$resolveUiConfig$resolution$2 uiConfigProvider$resolveUiConfig$resolution$2 = new UiConfigProvider$resolveUiConfig$resolution$2(this.this$0, continuation);
        uiConfigProvider$resolveUiConfig$resolution$2.I$0 = ((Number) obj).intValue();
        return uiConfigProvider$resolveUiConfig$resolution$2;
    }

    public final Object invoke(int i, Continuation<? super UiConfigResolution> continuation) {
        return ((UiConfigProvider$resolveUiConfig$resolution$2) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super UiConfigResolution> continuation) {
        return invoke(num.intValue(), continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
    
        if (r6 == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            i = this.I$0;
            this.I$0 = i;
            this.label = 1;
            obj = this.this$0.resolve(this);
            if (obj != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return (UiConfigResolution) obj;
        }
        i = this.I$0;
        ResultKt.throwOnFailure(obj);
        UiConfig uiConfig = (UiConfig) obj;
        if (uiConfig == null) {
            this.label = 2;
            obj = this.this$0.classifyUnresolved(this);
        } else {
            if (this.this$0.manager.getConfigGeneration() == i) {
                this.this$0.cache.store(i, uiConfig);
            }
            return new UiConfigResolution.Found(uiConfig);
        }
    }
}
