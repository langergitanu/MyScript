package com.revenuecat.purchases.p036ui.revenuecatui;

import android.app.Activity;
import android.content.Intent;
import com.revenuecat.purchases.CoroutinesExtensionsCommonKt;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PurchasesPaywallPreviewExtensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m1599d2 = {"presentPaywall", "", "Lcom/revenuecat/purchases/Purchases;", "intent", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PurchasesPaywallPreviewExtensionsKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.PurchasesPaywallPreviewExtensionsKt$presentPaywall$1 */
    /* JADX INFO: compiled from: PurchasesPaywallPreviewExtensions.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/Offering;", "offeringId", ""}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.PurchasesPaywallPreviewExtensionsKt$presentPaywall$1", m1609f = "PurchasesPaywallPreviewExtensions.kt", m1610i = {0}, m1611l = {35}, m1612m = "invokeSuspend", m1613n = {"offeringId"}, m1615s = {"L$0"})
    static final class C74941 extends SuspendLambda implements Function2<String, Continuation<? super Offering>, Object> {
        final /* synthetic */ Purchases $this_presentPaywall;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C74941(Purchases purchases, Continuation<? super C74941> continuation) {
            super(2, continuation);
            this.$this_presentPaywall = purchases;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C74941 c74941 = new C74941(this.$this_presentPaywall, continuation);
            c74941.L$0 = obj;
            return c74941;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Offering> continuation) {
            return ((C74941) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws PurchasesException {
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str2 = (String) this.L$0;
                this.L$0 = str2;
                this.label = 1;
                Object objAwaitOfferings = CoroutinesExtensionsCommonKt.awaitOfferings(this.$this_presentPaywall, this);
                if (objAwaitOfferings == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = str2;
                obj = objAwaitOfferings;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return ((Offerings) obj).getOffering(str);
        }
    }

    public static final boolean presentPaywall(Purchases purchases, Intent intent, Activity activity) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new PaywallPreviewPresenter(null, 1, null).handle(new C74941(purchases, null), intent, activity);
    }
}
