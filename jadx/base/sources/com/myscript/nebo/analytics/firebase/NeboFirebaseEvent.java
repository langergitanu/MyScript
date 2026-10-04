package com.myscript.nebo.analytics.firebase;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.analytics.AnalyticsController;
import com.myscript.nebo.analytics.AnalyticsEvent;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NeboFirebaseEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J!\u0010!\u001a\u00020\"2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b'H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006("}, m1599d2 = {"Lcom/myscript/nebo/analytics/firebase/NeboFirebaseEvent;", "Lcom/myscript/nebo/analytics/AnalyticsEvent;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "PaymentComplete", "TutorialLanguageScreen", "TutorialEnd", "Login", "PreRatingDisplay", "PreRatingChoice", "ShareFeedbackModal", "CrossSellDisplay", "CrossSellChoice", "FreemiumModalDisplay", "premiumModal", "PaywallModalDisplay", "PaywallModalDismissed", "PurchaseConfirmation", "aiExplain", "aiSummarize", "aiQuizStart", "aiQuizHide", "aiQuizCompleted", "CropImage", "PdfOptimization", "SpenQuickToolOpen", "SpenQuickToolAction", "syncFailed", "log", "", "extra", "Landroid/os/Bundle;", "extraDelegate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "analytics_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboFirebaseEvent implements AnalyticsEvent {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NeboFirebaseEvent[] $VALUES;
    private final String key;
    public static final NeboFirebaseEvent PaymentComplete = new NeboFirebaseEvent("PaymentComplete", 0, "payment_complete");
    public static final NeboFirebaseEvent TutorialLanguageScreen = new NeboFirebaseEvent("TutorialLanguageScreen", 1, "tutorial_language_screen");
    public static final NeboFirebaseEvent TutorialEnd = new NeboFirebaseEvent("TutorialEnd", 2, FirebaseAnalytics.Event.TUTORIAL_COMPLETE);
    public static final NeboFirebaseEvent Login = new NeboFirebaseEvent("Login", 3, "login");
    public static final NeboFirebaseEvent PreRatingDisplay = new NeboFirebaseEvent("PreRatingDisplay", 4, "pre_rating_display");
    public static final NeboFirebaseEvent PreRatingChoice = new NeboFirebaseEvent("PreRatingChoice", 5, "pre_rating_choice");
    public static final NeboFirebaseEvent ShareFeedbackModal = new NeboFirebaseEvent("ShareFeedbackModal", 6, "share_feedback_modal");
    public static final NeboFirebaseEvent CrossSellDisplay = new NeboFirebaseEvent("CrossSellDisplay", 7, "cross_sell_display");
    public static final NeboFirebaseEvent CrossSellChoice = new NeboFirebaseEvent("CrossSellChoice", 8, "cross_sell_choice");
    public static final NeboFirebaseEvent FreemiumModalDisplay = new NeboFirebaseEvent("FreemiumModalDisplay", 9, "premium_modal");
    public static final NeboFirebaseEvent premiumModal = new NeboFirebaseEvent("premiumModal", 10, "premium_modal");
    public static final NeboFirebaseEvent PaywallModalDisplay = new NeboFirebaseEvent("PaywallModalDisplay", 11, "pay_modal");
    public static final NeboFirebaseEvent PaywallModalDismissed = new NeboFirebaseEvent("PaywallModalDismissed", 12, "pay_modal_dismissed");
    public static final NeboFirebaseEvent PurchaseConfirmation = new NeboFirebaseEvent("PurchaseConfirmation", 13, "purchase_confirmation");
    public static final NeboFirebaseEvent aiExplain = new NeboFirebaseEvent("aiExplain", 14, "ai_explain");
    public static final NeboFirebaseEvent aiSummarize = new NeboFirebaseEvent("aiSummarize", 15, "ai_summarize");
    public static final NeboFirebaseEvent aiQuizStart = new NeboFirebaseEvent("aiQuizStart", 16, "ai_quiz_start");
    public static final NeboFirebaseEvent aiQuizHide = new NeboFirebaseEvent("aiQuizHide", 17, "ai_quiz_hide");
    public static final NeboFirebaseEvent aiQuizCompleted = new NeboFirebaseEvent("aiQuizCompleted", 18, "ai_quiz_completed");
    public static final NeboFirebaseEvent CropImage = new NeboFirebaseEvent("CropImage", 19, "crop_image");
    public static final NeboFirebaseEvent PdfOptimization = new NeboFirebaseEvent("PdfOptimization", 20, "pdf_optimisation");
    public static final NeboFirebaseEvent SpenQuickToolOpen = new NeboFirebaseEvent("SpenQuickToolOpen", 21, "spen_quick_tool_open");
    public static final NeboFirebaseEvent SpenQuickToolAction = new NeboFirebaseEvent("SpenQuickToolAction", 22, "spen_quick_tool_action");
    public static final NeboFirebaseEvent syncFailed = new NeboFirebaseEvent("syncFailed", 23, "sync_failed");

    private static final /* synthetic */ NeboFirebaseEvent[] $values() {
        return new NeboFirebaseEvent[]{PaymentComplete, TutorialLanguageScreen, TutorialEnd, Login, PreRatingDisplay, PreRatingChoice, ShareFeedbackModal, CrossSellDisplay, CrossSellChoice, FreemiumModalDisplay, premiumModal, PaywallModalDisplay, PaywallModalDismissed, PurchaseConfirmation, aiExplain, aiSummarize, aiQuizStart, aiQuizHide, aiQuizCompleted, CropImage, PdfOptimization, SpenQuickToolOpen, SpenQuickToolAction, syncFailed};
    }

    public static EnumEntries<NeboFirebaseEvent> getEntries() {
        return $ENTRIES;
    }

    public static NeboFirebaseEvent valueOf(String str) {
        return (NeboFirebaseEvent) Enum.valueOf(NeboFirebaseEvent.class, str);
    }

    public static NeboFirebaseEvent[] values() {
        return (NeboFirebaseEvent[]) $VALUES.clone();
    }

    private NeboFirebaseEvent(String str, int i, String str2) {
        this.key = str2;
    }

    @Override // com.myscript.nebo.analytics.AnalyticsEvent
    public String getKey() {
        return this.key;
    }

    static {
        NeboFirebaseEvent[] neboFirebaseEventArr$values = $values();
        $VALUES = neboFirebaseEventArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(neboFirebaseEventArr$values);
    }

    @Override // com.myscript.nebo.analytics.AnalyticsEvent
    public void log(Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        AnalyticsController.logAnalytics(getKey(), extra);
    }

    @Override // com.myscript.nebo.analytics.AnalyticsEvent
    public void log(Function1<? super Bundle, Unit> extraDelegate) {
        Intrinsics.checkNotNullParameter(extraDelegate, "extraDelegate");
        Bundle bundle = new Bundle();
        extraDelegate.invoke(bundle);
        log(bundle);
    }
}
