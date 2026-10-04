package com.survicate.surveys.presentation.base.micro;

import android.content.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.survey.SurveyMessages;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint;
import com.survicate.surveys.presentation.cta.CallToActionUtil;
import com.survicate.surveys.utils.extensions.StringExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonTextResolver.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/presentation/base/micro/ButtonTextResolver;", "", "surveyMessages", "Lcom/survicate/surveys/entities/survey/SurveyMessages;", "<init>", "(Lcom/survicate/surveys/entities/survey/SurveyMessages;)V", "resolveBackButtonText", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "resolveSubmitButtonText", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "resolveGenericSubmitText", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ButtonTextResolver {
    private final SurveyMessages surveyMessages;

    public ButtonTextResolver(SurveyMessages surveyMessages) {
        Intrinsics.checkNotNullParameter(surveyMessages, "surveyMessages");
        this.surveyMessages = surveyMessages;
    }

    public final String resolveBackButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String navigationBackText = this.surveyMessages.getNavigationBackText();
        String string = context.getString(C8369R.string.survicate_navigation_button_back);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return StringExtensionsKt.ifNullOrBlank(navigationBackText, string);
    }

    public final String resolveSubmitButtonText(Context context, SurveyPoint surveyPoint) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        if (surveyPoint instanceof SurveyCtaSurveyPoint) {
            return CallToActionUtil.INSTANCE.resolveCtaButtonText(context, (SurveyCtaSurveyPoint) surveyPoint, this.surveyMessages.getSubmitText());
        }
        return resolveGenericSubmitText(context);
    }

    public final String resolveGenericSubmitText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String submitText = this.surveyMessages.getSubmitText();
        String string = context.getString(C8369R.string.survicate_button_submit);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return StringExtensionsKt.ifNullOrBlank(submitText, string);
    }
}
