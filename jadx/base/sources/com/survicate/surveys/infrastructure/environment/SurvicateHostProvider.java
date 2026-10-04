package com.survicate.surveys.infrastructure.environment;

import android.content.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.BuildConfig;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.helpers.ManifestMetaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/environment/SurvicateHostProvider;", "Lcom/survicate/surveys/infrastructure/environment/HostProvider;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "<init>", "(Landroid/content/Context;Lcom/survicate/surveys/core/logging/SdkLogger;)V", "obtainSurveyHost", "", "obtainRespondentHost", "obtainContactsHost", "obtainHost", "manifestKey", "buildConfigUrl", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateHostProvider implements HostProvider {
    private final Context context;
    private final SdkLogger logger;

    public SurvicateHostProvider(Context context, SdkLogger logger) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.context = context;
        this.logger = logger;
    }

    @Override // com.survicate.surveys.infrastructure.environment.HostProvider
    public String obtainSurveyHost() {
        return obtainHost("com.survicate.surveys.surveyBaseUrl", BuildConfig.BASE_SURVEY_URL);
    }

    @Override // com.survicate.surveys.infrastructure.environment.HostProvider
    public String obtainRespondentHost() {
        return obtainHost("com.survicate.surveys.respondentBaseUrl", BuildConfig.BASE_RESPONDENT_URL);
    }

    @Override // com.survicate.surveys.infrastructure.environment.HostProvider
    public String obtainContactsHost() {
        return obtainHost("com.survicate.surveys.contactsBaseUrl", BuildConfig.BASE_CONTACTS_URL);
    }

    private final String obtainHost(String manifestKey, String buildConfigUrl) {
        String strObtainOrNull = ManifestMetaData.obtainOrNull(manifestKey, this.context);
        if (strObtainOrNull == null) {
            return buildConfigUrl;
        }
        this.logger.info(LogTags.WORKSPACE, "Url overridden: " + strObtainOrNull + " / " + manifestKey);
        return strObtainOrNull;
    }
}
