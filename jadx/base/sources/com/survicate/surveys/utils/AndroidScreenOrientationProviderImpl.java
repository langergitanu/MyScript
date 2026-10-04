package com.survicate.surveys.utils;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.core.models.ScreenOrientation;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.helpers.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenOrientationProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"Lcom/survicate/surveys/utils/AndroidScreenOrientationProviderImpl;", "Lcom/survicate/surveys/utils/AndroidScreenOrientationProvider;", "appContext", "Landroid/content/Context;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "<init>", "(Landroid/content/Context;Lcom/survicate/surveys/core/logging/SdkLogger;)V", "currentOrientation", "Lcom/survicate/surveys/core/models/ScreenOrientation;", "getCurrentOrientation", "()Lcom/survicate/surveys/core/models/ScreenOrientation;", "orientationObservable", "Lcom/survicate/surveys/helpers/Observable;", "lastOrientation", "observeOrientationChanges", "resolveOrientation", "configOrientation", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndroidScreenOrientationProviderImpl implements AndroidScreenOrientationProvider {
    private final Context appContext;
    private ScreenOrientation lastOrientation;
    private final SdkLogger logger;
    private final Observable<ScreenOrientation> orientationObservable;

    public AndroidScreenOrientationProviderImpl(Context appContext, SdkLogger logger) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.appContext = appContext;
        this.logger = logger;
        this.orientationObservable = new Observable<>();
        this.lastOrientation = getCurrentOrientation();
        appContext.registerComponentCallbacks(new ComponentCallbacks() { // from class: com.survicate.surveys.utils.AndroidScreenOrientationProviderImpl.1
            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration newConfig) {
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                ScreenOrientation screenOrientationResolveOrientation = AndroidScreenOrientationProviderImpl.this.resolveOrientation(newConfig.orientation);
                if (screenOrientationResolveOrientation == AndroidScreenOrientationProviderImpl.this.lastOrientation) {
                    return;
                }
                AndroidScreenOrientationProviderImpl.this.logger.info(LogTags.PRESENTATION, "screen orientation changed to: " + screenOrientationResolveOrientation);
                AndroidScreenOrientationProviderImpl.this.orientationObservable.notifyObservers(screenOrientationResolveOrientation);
                AndroidScreenOrientationProviderImpl.this.lastOrientation = screenOrientationResolveOrientation;
            }
        });
    }

    @Override // com.survicate.surveys.core.providers.ScreenOrientationProvider
    public ScreenOrientation getCurrentOrientation() {
        return resolveOrientation(this.appContext.getResources().getConfiguration().orientation);
    }

    @Override // com.survicate.surveys.utils.AndroidScreenOrientationProvider
    public Observable<ScreenOrientation> observeOrientationChanges() {
        return this.orientationObservable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScreenOrientation resolveOrientation(int configOrientation) {
        if (configOrientation == 2) {
            return ScreenOrientation.LANDSCAPE;
        }
        return ScreenOrientation.PORTRAIT;
    }
}
