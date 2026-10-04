package com.myscript.nebo.survicate;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.myscript.nebo.analytics.AnalyticsController;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.survicate.surveys.Survicate;
import com.survicate.surveys.traits.UserTrait;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurvicateController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\nJ\u0017\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0082\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/survicate/SurvicateController;", "", "<init>", "()V", "EVENT_SESSION", "", "ATTRIBUTE_USER_TYPE", "USER_TYPE_FREE", "USER_TYPE_PAYING", "initialized", "", "initSDK", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "workspaceKey", "invokeEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/myscript/nebo/survicate/SurvicateController$SurveyEvent;", "setUserType", "isPaying", "ifInitialized", "block", "Lkotlin/Function0;", "SurveyEvent", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SurvicateController {
    private static final String ATTRIBUTE_USER_TYPE = "user_type";
    private static final String EVENT_SESSION = "session_notes";
    private static final String USER_TYPE_FREE = "free";
    private static final String USER_TYPE_PAYING = "paying";
    private static boolean initialized;
    public static final SurvicateController INSTANCE = new SurvicateController();
    public static final int $stable = 8;

    private SurvicateController() {
    }

    /* JADX INFO: compiled from: SurvicateController.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0001\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/survicate/SurvicateController$SurveyEvent;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "<init>", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "Session", "Lcom/myscript/nebo/survicate/SurvicateController$SurveyEvent$Session;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class SurveyEvent {
        public static final int $stable = 0;
        private final String key;

        public /* synthetic */ SurveyEvent(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        /* JADX INFO: compiled from: SurvicateController.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/survicate/SurvicateController$SurveyEvent$Session;", "Lcom/myscript/nebo/survicate/SurvicateController$SurveyEvent;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Session extends SurveyEvent {
            public static final int $stable = 0;
            public static final Session INSTANCE = new Session();

            private Session() {
                super(SurvicateController.EVENT_SESSION, null);
            }
        }

        private SurveyEvent(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }
    }

    public final void initSDK(Context context, String workspaceKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workspaceKey, "workspaceKey");
        if (initialized || !AnalyticsController.hasUserConsent()) {
            return;
        }
        Survicate.setWorkspaceKey(workspaceKey);
        Survicate.init(context.getApplicationContext());
        initialized = true;
    }

    private final void ifInitialized(Function0<Unit> block) {
        if (initialized) {
            block.invoke();
        }
    }

    public final void invokeEvent(SurveyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (initialized) {
            Survicate.invokeEvent(event.getKey());
        }
    }

    public final void setUserType(boolean isPaying) {
        if (initialized) {
            Survicate.setUserTrait(new UserTrait("user_type", isPaying ? "paying" : "free"));
        }
    }
}
