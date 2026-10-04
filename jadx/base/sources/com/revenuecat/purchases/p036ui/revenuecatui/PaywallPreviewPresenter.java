package com.revenuecat.purchases.p036ui.revenuecatui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.p036ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.p036ui.revenuecatui.activity.PaywallActivityArgs;
import com.revenuecat.purchases.p036ui.revenuecatui.activity.PaywallContract;
import com.revenuecat.purchases.p036ui.revenuecatui.fonts.ParcelizableFontProvider;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.paywalls.PaywallData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: PaywallPreviewPresenter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B?\u00128\b\u0002\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\u0010\u000bJP\u0010\f\u001a\u00020\r23\u0010\u000e\u001a/\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R>\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPreviewPresenter;", "", "launchPaywall", "Lkotlin/Function2;", "Landroid/app/Activity;", "Lkotlin/ParameterName;", "name", "activity", "", "offeringId", "", "(Lkotlin/jvm/functions/Function2;)V", "handle", "", "locateOffering", "Lkotlin/coroutines/Continuation;", "Lcom/revenuecat/purchases/Offering;", "intent", "Landroid/content/Intent;", "(Lkotlin/jvm/functions/Function2;Landroid/content/Intent;Landroid/app/Activity;)Z", "parseLink", "Lcom/revenuecat/purchases/ui/revenuecatui/PreviewLinkParams;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallPreviewPresenter {
    public static final int $stable = 0;
    private final Function2<Activity, String, Unit> launchPaywall;

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallPreviewPresenter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallPreviewPresenter(Function2<? super Activity, ? super String, Unit> launchPaywall) {
        Intrinsics.checkNotNullParameter(launchPaywall, "launchPaywall");
        this.launchPaywall = launchPaywall;
    }

    public /* synthetic */ PaywallPreviewPresenter(C74921 c74921, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function2<Activity, String, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallPreviewPresenter.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Activity activity, String str) {
                invoke2(activity, str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Activity activity, String offeringId) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(offeringId, "offeringId");
                activity.startActivity(new PaywallContract().createIntent((Context) activity, new PaywallActivityArgs((String) null, new OfferingSelection.IdAndPresentedOfferingContext(offeringId, new PresentedOfferingContext(offeringId)), (ParcelizableFontProvider) null, true, false, false, (Map) null, (Integer) null, PDFACompliance.e_PDFA2_4_1, (DefaultConstructorMarker) null)));
            }
        } : c74921);
    }

    public final boolean handle(Function2<? super String, ? super Continuation<? super Offering>, ? extends Object> locateOffering, Intent intent, Activity activity) {
        Intrinsics.checkNotNullParameter(locateOffering, "locateOffering");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(activity, "activity");
        PreviewLinkParams link = parseLink(intent);
        if (link == null) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new C74931(locateOffering, link, activity, this, null), 3, null);
        return true;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.PaywallPreviewPresenter$handle$1 */
    /* JADX INFO: compiled from: PaywallPreviewPresenter.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.PaywallPreviewPresenter$handle$1", m1609f = "PaywallPreviewPresenter.kt", m1610i = {}, m1611l = {65}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C74931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Function2<String, Continuation<? super Offering>, Object> $locateOffering;
        final /* synthetic */ PreviewLinkParams $params;
        int label;
        final /* synthetic */ PaywallPreviewPresenter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C74931(Function2<? super String, ? super Continuation<? super Offering>, ? extends Object> function2, PreviewLinkParams previewLinkParams, Activity activity, PaywallPreviewPresenter paywallPreviewPresenter, Continuation<? super C74931> continuation) {
            super(2, continuation);
            this.$locateOffering = function2;
            this.$params = previewLinkParams;
            this.$activity = activity;
            this.this$0 = paywallPreviewPresenter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C74931(this.$locateOffering, this.$params, this.$activity, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C74931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2<String, Continuation<? super Offering>, Object> function2 = this.$locateOffering;
                    String offeringId = this.$params.getOfferingId();
                    this.label = 1;
                    obj = function2.invoke(offeringId, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Offering offering = (Offering) obj;
                if (offering == null) {
                    Logger.INSTANCE.m1587w("Attempting to show paywall for offering " + this.$params.getOfferingId() + ", but cannot locate a published offering with that id");
                    return Unit.INSTANCE;
                }
                PaywallData paywall = offering.getPaywall();
                if (!Intrinsics.areEqual(paywall != null ? paywall.getId() : null, this.$params.getPaywallId())) {
                    Logger.INSTANCE.m1587w("Attempting to show paywall " + this.$params.getPaywallId() + ", but it does not match the paywall associated with " + this.$params.getOfferingId());
                    return Unit.INSTANCE;
                }
                if (!this.$activity.isFinishing() && !this.$activity.isDestroyed()) {
                    this.this$0.launchPaywall.invoke(this.$activity, this.$params.getOfferingId());
                    return Unit.INSTANCE;
                }
                Logger.INSTANCE.m1587w("Activity is no longer usable; skipping paywall presentation");
                return Unit.INSTANCE;
            } catch (Exception e) {
                Logger.INSTANCE.m1587w("Error fetching offerings for paywall preview: " + e.getMessage());
                return Unit.INSTANCE;
            }
        }
    }

    private final PreviewLinkParams parseLink(Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            return null;
        }
        if (!Intrinsics.areEqual(data.getHost(), PaywallPreviewPresenterKt.PAYWALL_PREVIEW_HOST)) {
            data = null;
        }
        if (data == null) {
            return null;
        }
        String queryParameter = data.getQueryParameter("offering_id");
        if (queryParameter == null || StringsKt.isBlank(queryParameter)) {
            queryParameter = null;
        }
        String queryParameter2 = data.getQueryParameter("paywall_id");
        if (queryParameter2 == null || StringsKt.isBlank(queryParameter2)) {
            queryParameter2 = null;
        }
        if (queryParameter == null) {
            Logger.INSTANCE.m1587w("Invalid rc-paywall-preview link: Bad offering_id parameter");
            return null;
        }
        if (queryParameter2 == null) {
            Logger.INSTANCE.m1587w("Invalid rc-paywall-preview link: Bad paywall_id parameter");
            return null;
        }
        return new PreviewLinkParams(queryParameter, queryParameter2);
    }
}
