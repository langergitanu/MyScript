package com.survicate.surveys.helpers.url;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UrlBuilderImpl.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/helpers/url/UrlBuilderImpl;", "Lcom/survicate/surveys/helpers/url/UrlBuilder;", "<init>", "()V", "buildPoweredBySurvicateUrl", "", "surveyId", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class UrlBuilderImpl implements UrlBuilder {
    @Override // com.survicate.surveys.helpers.url.UrlBuilder
    public String buildPoweredBySurvicateUrl(String surveyId) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        StringBuilder sb = new StringBuilder("https://survicate.com/create-your-mobile-survey/?utm_source=Survey+branding&utm_medium=MobileSurvey&utm_content=respondent.survicate.com");
        sb.append("&utm_term=" + surveyId);
        return sb.toString();
    }
}
