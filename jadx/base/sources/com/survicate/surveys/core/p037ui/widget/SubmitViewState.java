package com.survicate.surveys.core.p037ui.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubmitViewState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u000e2\u00020\u0001:\u0005\n\u000b\f\r\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, m1599d2 = {"Lcom/survicate/surveys/core/ui/widget/SubmitViewState;", "", "forceCenter", "", "getForceCenter", "()Z", "type", "Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Type;", "getType", "()Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Type;", "Type", "Hidden", "Submit", "Navigation", "Factory", "Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Hidden;", "Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Navigation;", "Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Submit;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SubmitViewState {

    /* JADX INFO: renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    boolean getForceCenter();

    Type getType();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SubmitViewState.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Type;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "SUBMIT", "NAVIGATION", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type HIDDEN = new Type("HIDDEN", 0);
        public static final Type SUBMIT = new Type("SUBMIT", 1);
        public static final Type NAVIGATION = new Type("NAVIGATION", 2);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{HIDDEN, SUBMIT, NAVIGATION};
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        private Type(String str, int i) {
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: SubmitViewState.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, m1599d2 = {"Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Hidden;", "Lcom/survicate/surveys/core/ui/widget/SubmitViewState;", "<init>", "()V", "forceCenter", "", "getForceCenter", "()Z", "type", "Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Type;", "getType", "()Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Type;", "equals", "other", "", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Hidden implements SubmitViewState {
        private static final boolean forceCenter = false;
        public static final Hidden INSTANCE = new Hidden();
        private static final Type type = Type.HIDDEN;

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
            return -21740155;
        }

        public String toString() {
            return "Hidden";
        }

        private Hidden() {
        }

        @Override // com.survicate.surveys.core.p037ui.widget.SubmitViewState
        public boolean getForceCenter() {
            return forceCenter;
        }

        @Override // com.survicate.surveys.core.p037ui.widget.SubmitViewState
        public Type getType() {
            return type;
        }
    }

    /* JADX INFO: compiled from: SubmitViewState.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, m1599d2 = {"Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Submit;", "Lcom/survicate/surveys/core/ui/widget/SubmitViewState;", "submitEnabled", "", "submitText", "", "forceCenter", "<init>", "(ZLjava/lang/String;Z)V", "getSubmitEnabled", "()Z", "getSubmitText", "()Ljava/lang/String;", "getForceCenter", "type", "Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Type;", "getType", "()Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Type;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Submit implements SubmitViewState {
        private final boolean forceCenter;
        private final boolean submitEnabled;
        private final String submitText;
        private final Type type;

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
            this.type = Type.SUBMIT;
        }

        public final boolean getSubmitEnabled() {
            return this.submitEnabled;
        }

        public final String getSubmitText() {
            return this.submitText;
        }

        @Override // com.survicate.surveys.core.p037ui.widget.SubmitViewState
        public boolean getForceCenter() {
            return this.forceCenter;
        }

        @Override // com.survicate.surveys.core.p037ui.widget.SubmitViewState
        public Type getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: SubmitViewState.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, m1599d2 = {"Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Navigation;", "Lcom/survicate/surveys/core/ui/widget/SubmitViewState;", "backEnabled", "", "backText", "", "submitEnabled", "submitText", "forceCenter", "<init>", "(ZLjava/lang/String;ZLjava/lang/String;Z)V", "getBackEnabled", "()Z", "getBackText", "()Ljava/lang/String;", "getSubmitEnabled", "getSubmitText", "getForceCenter", "type", "Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Type;", "getType", "()Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Type;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Navigation implements SubmitViewState {
        private final boolean backEnabled;
        private final String backText;
        private final boolean forceCenter;
        private final boolean submitEnabled;
        private final String submitText;
        private final Type type;

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
            this.type = Type.NAVIGATION;
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

        @Override // com.survicate.surveys.core.p037ui.widget.SubmitViewState
        public boolean getForceCenter() {
            return this.forceCenter;
        }

        @Override // com.survicate.surveys.core.p037ui.widget.SubmitViewState
        public Type getType() {
            return this.type;
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.core.ui.widget.SubmitViewState$Factory, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SubmitViewState.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/survicate/surveys/core/ui/widget/SubmitViewState$Factory;", "", "<init>", "()V", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
