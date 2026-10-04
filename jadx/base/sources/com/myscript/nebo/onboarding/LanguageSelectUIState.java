package com.myscript.nebo.onboarding;

import com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageSelectionViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/nebo/onboarding/LanguageSelectUIState;", "", "languages", "", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem$Lang;", "isSearchActive", "", "showSpinner", "networkError", "canContinue", "<init>", "(Ljava/util/List;ZZZZ)V", "getLanguages", "()Ljava/util/List;", "()Z", "getShowSpinner", "getNetworkError", "getCanContinue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "onboarding_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class LanguageSelectUIState {
    private final boolean canContinue;
    private final boolean isSearchActive;
    private final List<LanguageManagerItem.Lang> languages;
    private final boolean networkError;
    private final boolean showSpinner;

    public LanguageSelectUIState() {
        this(null, false, false, false, false, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LanguageSelectUIState copy$default(LanguageSelectUIState languageSelectUIState, List list, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = languageSelectUIState.languages;
        }
        if ((i & 2) != 0) {
            z = languageSelectUIState.isSearchActive;
        }
        if ((i & 4) != 0) {
            z2 = languageSelectUIState.showSpinner;
        }
        if ((i & 8) != 0) {
            z3 = languageSelectUIState.networkError;
        }
        if ((i & 16) != 0) {
            z4 = languageSelectUIState.canContinue;
        }
        boolean z5 = z4;
        boolean z6 = z2;
        return languageSelectUIState.copy(list, z, z6, z3, z5);
    }

    public final List<LanguageManagerItem.Lang> component1() {
        return this.languages;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSearchActive() {
        return this.isSearchActive;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowSpinner() {
        return this.showSpinner;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getNetworkError() {
        return this.networkError;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanContinue() {
        return this.canContinue;
    }

    public final LanguageSelectUIState copy(List<LanguageManagerItem.Lang> languages, boolean isSearchActive, boolean showSpinner, boolean networkError, boolean canContinue) {
        Intrinsics.checkNotNullParameter(languages, "languages");
        return new LanguageSelectUIState(languages, isSearchActive, showSpinner, networkError, canContinue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LanguageSelectUIState)) {
            return false;
        }
        LanguageSelectUIState languageSelectUIState = (LanguageSelectUIState) other;
        return Intrinsics.areEqual(this.languages, languageSelectUIState.languages) && this.isSearchActive == languageSelectUIState.isSearchActive && this.showSpinner == languageSelectUIState.showSpinner && this.networkError == languageSelectUIState.networkError && this.canContinue == languageSelectUIState.canContinue;
    }

    public int hashCode() {
        return (((((((this.languages.hashCode() * 31) + Boolean.hashCode(this.isSearchActive)) * 31) + Boolean.hashCode(this.showSpinner)) * 31) + Boolean.hashCode(this.networkError)) * 31) + Boolean.hashCode(this.canContinue);
    }

    public String toString() {
        return "LanguageSelectUIState(languages=" + this.languages + ", isSearchActive=" + this.isSearchActive + ", showSpinner=" + this.showSpinner + ", networkError=" + this.networkError + ", canContinue=" + this.canContinue + ")";
    }

    public LanguageSelectUIState(List<LanguageManagerItem.Lang> languages, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(languages, "languages");
        this.languages = languages;
        this.isSearchActive = z;
        this.showSpinner = z2;
        this.networkError = z3;
        this.canContinue = z4;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ LanguageSelectUIState(java.util.List r2, boolean r3, boolean r4, boolean r5, boolean r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L8
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L8:
            r8 = r7 & 2
            r0 = 0
            if (r8 == 0) goto Le
            r3 = r0
        Le:
            r8 = r7 & 4
            if (r8 == 0) goto L13
            r4 = r0
        L13:
            r8 = r7 & 8
            if (r8 == 0) goto L18
            r5 = r0
        L18:
            r7 = r7 & 16
            if (r7 == 0) goto L23
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L29
        L23:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L29:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.myscript.nebo.onboarding.LanguageSelectUIState.<init>(java.util.List, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<LanguageManagerItem.Lang> getLanguages() {
        return this.languages;
    }

    public final boolean isSearchActive() {
        return this.isSearchActive;
    }

    public final boolean getShowSpinner() {
        return this.showSpinner;
    }

    public final boolean getNetworkError() {
        return this.networkError;
    }

    public final boolean getCanContinue() {
        return this.canContinue;
    }
}
