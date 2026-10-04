package com.myscript.nebo.analytics.firebase;

import android.os.Bundle;
import com.myscript.nebo.analytics.AnalyticsController;
import com.myscript.nebo.analytics.AnalyticsProperty;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NeboFirebaseProperty.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u000fB\u0013\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J!\u0010\b\u001a\u00020\t2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0001\u0010¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/analytics/firebase/NeboFirebaseProperty;", "Lcom/myscript/nebo/analytics/AnalyticsProperty;", "propertyName", "", "<init>", "(Ljava/lang/String;)V", "getPropertyName", "()Ljava/lang/String;", "log", "", "extra", "Landroid/os/Bundle;", "extraDelegate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "CloudSyncProviderProperty", "Lcom/myscript/nebo/analytics/firebase/NeboFirebaseProperty$CloudSyncProviderProperty;", "analytics_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class NeboFirebaseProperty implements AnalyticsProperty {
    private final String propertyName;

    public /* synthetic */ NeboFirebaseProperty(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private NeboFirebaseProperty(String str) {
        this.propertyName = str;
    }

    @Override // com.myscript.nebo.analytics.AnalyticsProperty
    public String getPropertyName() {
        return this.propertyName;
    }

    /* JADX INFO: compiled from: NeboFirebaseProperty.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/analytics/firebase/NeboFirebaseProperty$CloudSyncProviderProperty;", "Lcom/myscript/nebo/analytics/firebase/NeboFirebaseProperty;", "propertyValue", "", "<init>", "(Ljava/lang/String;)V", "getPropertyValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "analytics_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class CloudSyncProviderProperty extends NeboFirebaseProperty {
        private final String propertyValue;

        public static /* synthetic */ CloudSyncProviderProperty copy$default(CloudSyncProviderProperty cloudSyncProviderProperty, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cloudSyncProviderProperty.propertyValue;
            }
            return cloudSyncProviderProperty.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPropertyValue() {
            return this.propertyValue;
        }

        public final CloudSyncProviderProperty copy(String propertyValue) {
            Intrinsics.checkNotNullParameter(propertyValue, "propertyValue");
            return new CloudSyncProviderProperty(propertyValue);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CloudSyncProviderProperty) && Intrinsics.areEqual(this.propertyValue, ((CloudSyncProviderProperty) other).propertyValue);
        }

        public int hashCode() {
            return this.propertyValue.hashCode();
        }

        public String toString() {
            return "CloudSyncProviderProperty(propertyValue=" + this.propertyValue + ")";
        }

        @Override // com.myscript.nebo.analytics.AnalyticsProperty
        public String getPropertyValue() {
            return this.propertyValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CloudSyncProviderProperty(String propertyValue) {
            super("cloudsync_provider", null);
            Intrinsics.checkNotNullParameter(propertyValue, "propertyValue");
            this.propertyValue = propertyValue;
        }
    }

    @Override // com.myscript.nebo.analytics.AnalyticsProperty
    public void log(Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        AnalyticsController.setUserProperty(getPropertyName(), getPropertyValue());
    }

    @Override // com.myscript.nebo.analytics.AnalyticsProperty
    public void log(Function1<? super Bundle, Unit> extraDelegate) {
        Intrinsics.checkNotNullParameter(extraDelegate, "extraDelegate");
        Bundle bundle = new Bundle();
        extraDelegate.invoke(bundle);
        log(bundle);
    }
}
