package com.myscript.nebo.p022ai;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.snt.core.PageController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: analyticsParameters.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0000\u001a\u0004\u0018\u00010\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\b\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u000b\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u001a\u0012\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0010¨\u0006\u0011"}, m1599d2 = {"origin", "", "Landroid/os/Bundle;", "Lcom/myscript/nebo/ai/AIAnalyticsOrigin;", "triggerInternal", "trigger", "", "Lcom/myscript/nebo/ai/AIExplainTrigger;", "Lcom/myscript/nebo/ai/AISummarizeTrigger;", "selected", "selectionType", "Lcom/myscript/nebo/ai/AIQuizTrigger;", "aiQuizSelected", FirebaseAnalytics.Param.SOURCE, "type", "getAiAnalyticsOrigin", "Lcom/myscript/snt/core/PageController;", "nebo-ai_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AnalyticsParametersKt {
    public static final void getAiAnalyticsOrigin(PageController pageController) {
        Intrinsics.checkNotNullParameter(pageController, "<this>");
    }

    public static final void origin(Bundle bundle, AIAnalyticsOrigin aIAnalyticsOrigin) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        if (aIAnalyticsOrigin != null) {
            bundle.putString("origin", aIAnalyticsOrigin.getValue());
        }
    }

    public static final void triggerInternal(Bundle bundle, String trigger) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        bundle.putString("trigger", trigger);
    }

    public static final void trigger(Bundle bundle, AIExplainTrigger aIExplainTrigger) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        if (aIExplainTrigger != null) {
            triggerInternal(bundle, aIExplainTrigger.getValue());
        }
    }

    public static final void trigger(Bundle bundle, AISummarizeTrigger aISummarizeTrigger) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        if (aISummarizeTrigger != null) {
            triggerInternal(bundle, aISummarizeTrigger.getValue());
        }
    }

    public static final void selected(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        bundle.putString("selected", str);
    }

    public static final void trigger(Bundle bundle, AIQuizTrigger aIQuizTrigger) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        if (aIQuizTrigger != null) {
            triggerInternal(bundle, aIQuizTrigger.getValue());
        }
    }

    public static final void aiQuizSelected(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        if (str != null) {
            bundle.putString("selected", str);
        }
    }

    public static final void type(Bundle bundle, String type) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        bundle.putString("type", type);
    }
}
