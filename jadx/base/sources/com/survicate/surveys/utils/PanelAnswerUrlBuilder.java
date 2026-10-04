package com.survicate.surveys.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PanelAnswerUrlBuilder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/survicate/surveys/utils/PanelAnswerUrlBuilder;", "", "<init>", "()V", "SURVEY_ID_PLACEHOLDER", "", "RESPONSE_UUID_PLACEHOLDER", "build", "templateUrl", "surveyId", "responseUuid", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class PanelAnswerUrlBuilder {
    public static final PanelAnswerUrlBuilder INSTANCE = new PanelAnswerUrlBuilder();
    private static final String RESPONSE_UUID_PLACEHOLDER = "{response_uuid}";
    private static final String SURVEY_ID_PLACEHOLDER = "{survey_id}";

    private PanelAnswerUrlBuilder() {
    }

    public final String build(String templateUrl, String surveyId, String responseUuid) {
        Intrinsics.checkNotNullParameter(templateUrl, "templateUrl");
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(responseUuid, "responseUuid");
        return StringsKt.replace$default(StringsKt.replace$default(templateUrl, SURVEY_ID_PLACEHOLDER, surveyId, false, 4, (Object) null), RESPONSE_UUID_PLACEHOLDER, responseUuid, false, 4, (Object) null);
    }
}
