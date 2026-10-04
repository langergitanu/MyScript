package com.survicate.surveys.presentation.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSubmitView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u0000 \t2\u00020\u0001:\u0004\u0006\u0007\b\tR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/SubmitViewState;", "", "forceCenter", "", "getForceCenter", "()Z", "Hidden", "Submit", "Navigation", "Factory", "Lcom/survicate/surveys/presentation/widget/SubmitViewState$Hidden;", "Lcom/survicate/surveys/presentation/widget/SubmitViewState$Navigation;", "Lcom/survicate/surveys/presentation/widget/SubmitViewState$Submit;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SubmitViewState {

    /* JADX INFO: renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    boolean getForceCenter();

    /* JADX INFO: compiled from: MicroSubmitView.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/SubmitViewState$Hidden;", "Lcom/survicate/surveys/presentation/widget/SubmitViewState;", "<init>", "()V", "forceCenter", "", "getForceCenter", "()Z", "equals", "other", "", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Hidden implements SubmitViewState {
        public static final Hidden INSTANCE = new Hidden();
        private static final boolean forceCenter = false;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hidden)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1189814504;
        }

        public String toString() {
            return "Hidden";
        }

        private Hidden() {
        }

        @Override // com.survicate.surveys.presentation.widget.SubmitViewState
        public boolean getForceCenter() {
            return forceCenter;
        }
    }

    /* JADX INFO: compiled from: MicroSubmitView.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/SubmitViewState$Submit;", "Lcom/survicate/surveys/presentation/widget/SubmitViewState;", "submitEnabled", "", "submitText", "", "forceCenter", "<init>", "(ZLjava/lang/String;Z)V", "getSubmitEnabled", "()Z", "getSubmitText", "()Ljava/lang/String;", "getForceCenter", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Submit implements SubmitViewState {
        private final boolean forceCenter;
        private final boolean submitEnabled;
        private final String submitText;

        public static /* synthetic */ Submit copy$default(Submit submit, boolean z, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = submit.submitEnabled;
            }
            if ((i & 2) != 0) {
                str = submit.submitText;
            }
            if ((i & 4) != 0) {
                z2 = submit.forceCenter;
            }
            return submit.copy(z, str, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getSubmitEnabled() {
            return this.submitEnabled;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSubmitText() {
            return this.submitText;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getForceCenter() {
            return this.forceCenter;
        }

        public final Submit copy(boolean submitEnabled, String submitText, boolean forceCenter) {
            Intrinsics.checkNotNullParameter(submitText, "submitText");
            return new Submit(submitEnabled, submitText, forceCenter);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Submit)) {
                return false;
            }
            Submit submit = (Submit) other;
            return this.submitEnabled == submit.submitEnabled && Intrinsics.areEqual(this.submitText, submit.submitText) && this.forceCenter == submit.forceCenter;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.submitEnabled) * 31) + this.submitText.hashCode()) * 31) + Boolean.hashCode(this.forceCenter);
        }

        public String toString() {
            return "Submit(submitEnabled=" + this.submitEnabled + ", submitText=" + this.submitText + ", forceCenter=" + this.forceCenter + ')';
        }

        public Submit(boolean z, String submitText, boolean z2) {
            Intrinsics.checkNotNullParameter(submitText, "submitText");
            this.submitEnabled = z;
            this.submitText = submitText;
            this.forceCenter = z2;
        }

        public final boolean getSubmitEnabled() {
            return this.submitEnabled;
        }

        public final String getSubmitText() {
            return this.submitText;
        }

        @Override // com.survicate.surveys.presentation.widget.SubmitViewState
        public boolean getForceCenter() {
            return this.forceCenter;
        }
    }

    /* JADX INFO: compiled from: MicroSubmitView.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/SubmitViewState$Navigation;", "Lcom/survicate/surveys/presentation/widget/SubmitViewState;", "backEnabled", "", "backText", "", "submitEnabled", "submitText", "forceCenter", "<init>", "(ZLjava/lang/String;ZLjava/lang/String;Z)V", "getBackEnabled", "()Z", "getBackText", "()Ljava/lang/String;", "getSubmitEnabled", "getSubmitText", "getForceCenter", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Navigation implements SubmitViewState {
        private final boolean backEnabled;
        private final String backText;
        private final boolean forceCenter;
        private final boolean submitEnabled;
        private final String submitText;

        public static /* synthetic */ Navigation copy$default(Navigation navigation, boolean z, String str, boolean z2, String str2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = navigation.backEnabled;
            }
            if ((i & 2) != 0) {
                str = navigation.backText;
            }
            if ((i & 4) != 0) {
                z2 = navigation.submitEnabled;
            }
            if ((i & 8) != 0) {
                str2 = navigation.submitText;
            }
            if ((i & 16) != 0) {
                z3 = navigation.forceCenter;
            }
            boolean z4 = z3;
            boolean z5 = z2;
            return navigation.copy(z, str, z5, str2, z4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getBackEnabled() {
            return this.backEnabled;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getBackText() {
            return this.backText;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getSubmitEnabled() {
            return this.submitEnabled;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSubmitText() {
            return this.submitText;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getForceCenter() {
            return this.forceCenter;
        }

        public final Navigation copy(boolean backEnabled, String backText, boolean submitEnabled, String submitText, boolean forceCenter) {
            Intrinsics.checkNotNullParameter(backText, "backText");
            Intrinsics.checkNotNullParameter(submitText, "submitText");
            return new Navigation(backEnabled, backText, submitEnabled, submitText, forceCenter);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Navigation)) {
                return false;
            }
            Navigation navigation = (Navigation) other;
            return this.backEnabled == navigation.backEnabled && Intrinsics.areEqual(this.backText, navigation.backText) && this.submitEnabled == navigation.submitEnabled && Intrinsics.areEqual(this.submitText, navigation.submitText) && this.forceCenter == navigation.forceCenter;
        }

        public int hashCode() {
            return (((((((Boolean.hashCode(this.backEnabled) * 31) + this.backText.hashCode()) * 31) + Boolean.hashCode(this.submitEnabled)) * 31) + this.submitText.hashCode()) * 31) + Boolean.hashCode(this.forceCenter);
        }

        public String toString() {
            return "Navigation(backEnabled=" + this.backEnabled + ", backText=" + this.backText + ", submitEnabled=" + this.submitEnabled + ", submitText=" + this.submitText + ", forceCenter=" + this.forceCenter + ')';
        }

        public Navigation(boolean z, String backText, boolean z2, String submitText, boolean z3) {
            Intrinsics.checkNotNullParameter(backText, "backText");
            Intrinsics.checkNotNullParameter(submitText, "submitText");
            this.backEnabled = z;
            this.backText = backText;
            this.submitEnabled = z2;
            this.submitText = submitText;
            this.forceCenter = z3;
        }

        public final boolean getBackEnabled() {
            return this.backEnabled;
        }

        public final String getBackText() {
            return this.backText;
        }

        public final boolean getSubmitEnabled() {
            return this.submitEnabled;
        }

        public final String getSubmitText() {
            return this.submitText;
        }

        @Override // com.survicate.surveys.presentation.widget.SubmitViewState
        public boolean getForceCenter() {
            return this.forceCenter;
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.widget.SubmitViewState$Factory, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MicroSubmitView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/SubmitViewState$Factory;", "", "<init>", "()V", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
