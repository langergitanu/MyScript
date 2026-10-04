package com.survicate.surveys.presentation.cta;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.survey.questions.cta.ButtonCloseCtaSettings;
import com.survicate.surveys.entities.survey.questions.cta.ButtonLinkCtaSettings;
import com.survicate.surveys.entities.survey.questions.cta.ButtonNextCtaSettings;
import com.survicate.surveys.entities.survey.questions.cta.CtaSettings;
import com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CallToActionUtil.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1599d2 = {"Lcom/survicate/surveys/presentation/cta/CallToActionUtil;", "", "<init>", "()V", "OPEN_LINK_EXTRA_DELAY_MS", "", "resolveCtaButtonText", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "ctaSurveyPoint", "Lcom/survicate/surveys/entities/survey/questions/cta/SurveyCtaSurveyPoint;", "nextMessage", "openCtaLink", "", "linkSettings", "Lcom/survicate/surveys/entities/survey/questions/cta/ButtonLinkCtaSettings;", "startActivityDelayed", "intent", "Landroid/content/Intent;", "startActivity", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class CallToActionUtil {
    public static final CallToActionUtil INSTANCE = new CallToActionUtil();
    private static final int OPEN_LINK_EXTRA_DELAY_MS = 100;

    private CallToActionUtil() {
    }

    public final String resolveCtaButtonText(Context context, SurveyCtaSurveyPoint ctaSurveyPoint, String nextMessage) {
        String string;
        CtaSettings ctaSettings;
        Intrinsics.checkNotNullParameter(context, "context");
        String buttonText = null;
        CtaSettings ctaSettings2 = ctaSurveyPoint != null ? ctaSurveyPoint.getCtaSettings() : null;
        if (ctaSettings2 instanceof ButtonNextCtaSettings) {
            string = context.getString(C8369R.string.survicate_cta_button_next);
        } else {
            string = ctaSettings2 instanceof ButtonCloseCtaSettings ? context.getString(C8369R.string.survicate_cta_button_close) : context.getString(C8369R.string.survicate_cta_button_link);
        }
        Intrinsics.checkNotNull(string);
        if (ctaSurveyPoint != null && (ctaSettings = ctaSurveyPoint.getCtaSettings()) != null) {
            buttonText = ctaSettings.getButtonText();
        }
        return (buttonText == null || !(StringsKt.isBlank(buttonText) ^ true)) ? (nextMessage == null || !(StringsKt.isBlank(nextMessage) ^ true)) ? string : nextMessage : buttonText;
    }

    @JvmStatic
    public static final void openCtaLink(ButtonLinkCtaSettings linkSettings, Context context) {
        Intrinsics.checkNotNullParameter(linkSettings, "linkSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        String link = linkSettings.getLink();
        String str = link;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        INSTANCE.startActivityDelayed(context, new Intent("android.intent.action.VIEW", Uri.parse(link)));
    }

    private final void startActivityDelayed(final Context context, final Intent intent) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.survicate.surveys.presentation.cta.CallToActionUtil$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CallToActionUtil.startActivityDelayed$lambda$0(context, intent);
            }
        }, context.getResources().getInteger(C8369R.integer.survicate_fragment_anim_duration) + 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startActivityDelayed$lambda$0(Context context, Intent intent) {
        INSTANCE.startActivity(context, intent);
    }

    private final void startActivity(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }
}
