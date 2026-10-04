package com.myscript.nebo.settings;

import androidx.preference.SeekBarPreference;
import com.myscript.nebo.purchase.SubscriptionRepository;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InternalSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.settings.InternalSettingsFragment$setupRenewalOfferOverride$2$1", m1609f = "InternalSettingsFragment.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA2_6_1}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {263}, m1615s = {}, m1616v = 2)
final class InternalSettingsFragment$setupRenewalOfferOverride$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ SeekBarPreference $renewalRemainingSlider;
    final /* synthetic */ SubscriptionRepository $subscriptionRepository;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InternalSettingsFragment$setupRenewalOfferOverride$2$1(boolean z, SubscriptionRepository subscriptionRepository, SeekBarPreference seekBarPreference, Continuation<? super InternalSettingsFragment$setupRenewalOfferOverride$2$1> continuation) {
        super(2, continuation);
        this.$enabled = z;
        this.$subscriptionRepository = subscriptionRepository;
        this.$renewalRemainingSlider = seekBarPreference;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InternalSettingsFragment$setupRenewalOfferOverride$2$1(this.$enabled, this.$subscriptionRepository, this.$renewalRemainingSlider, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InternalSettingsFragment$setupRenewalOfferOverride$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$enabled) {
                SubscriptionRepository subscriptionRepository = this.$subscriptionRepository;
                SeekBarPreference seekBarPreference = this.$renewalRemainingSlider;
                subscriptionRepository.debugOverrideRenewalOffer(seekBarPreference != null ? seekBarPreference.getValue() : 48);
            } else {
                this.label = 1;
                if (this.$subscriptionRepository.debugClearRenewalOfferOverride(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
