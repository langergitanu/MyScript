package com.survicate.surveys.presentation.base;

import android.content.Context;
import android.content.Intent;
import com.survicate.surveys.SurveyActivity;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.helpers.LogTags;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurvicateActivityLauncher.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/presentation/base/SurvicateActivityLauncher;", "", "applicationContext", "Landroid/content/Context;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "<init>", "(Landroid/content/Context;Lcom/survicate/surveys/core/logging/SdkLogger;)V", "show", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateActivityLauncher {
    private final Context applicationContext;
    private final SdkLogger logger;

    public SurvicateActivityLauncher(Context applicationContext, SdkLogger logger) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.applicationContext = applicationContext;
        this.logger = logger;
    }

    public final void show() {
        try {
            Intent intentAddFlags = new Intent(this.applicationContext, (Class<?>) SurveyActivity.class).addFlags(268435456);
            Intrinsics.checkNotNullExpressionValue(intentAddFlags, "addFlags(...)");
            this.applicationContext.startActivity(intentAddFlags);
        } catch (Exception e) {
            this.logger.error(LogTags.PRESENTATION, "Failed to launch survey activity", e);
        }
    }
}
