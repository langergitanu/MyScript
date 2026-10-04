package com.myscript.atk.resourcemanager;

import com.myscript.atk.resourcemanager.internal.Constants;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Language.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000H\u0096\u0082\u0004J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u001aHÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0007\u0010\u000e¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/atk/resourcemanager/Language;", "", "languageKey", "", "displayName", "isAvailable", "", "isUpToDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)V", "getLanguageKey", "()Ljava/lang/String;", "getDisplayName", "()Z", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "compareTo", "", "other", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)Lcom/myscript/atk/resourcemanager/Language;", "equals", "", "hashCode", "toString", "Companion", "resourcemanager-lib_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class Language implements Comparable<Language> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<List<String>> specialResources$delegate = LazyKt.lazy(new Function0() { // from class: com.myscript.atk.resourcemanager.Language$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Language.specialResources_delegate$lambda$0();
        }
    });
    private final String displayName;
    private final boolean isAvailable;
    private final Boolean isUpToDate;
    private final String languageKey;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Language(String languageKey) {
        this(languageKey, null, false, null, 14, null);
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Language(String languageKey, String displayName) {
        this(languageKey, displayName, false, null, 12, null);
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Language(String languageKey, String displayName, boolean z) {
        this(languageKey, displayName, z, null, 8, null);
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
    }

    public static /* synthetic */ Language copy$default(Language language, String str, String str2, boolean z, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = language.languageKey;
        }
        if ((i & 2) != 0) {
            str2 = language.displayName;
        }
        if ((i & 4) != 0) {
            z = language.isAvailable;
        }
        if ((i & 8) != 0) {
            bool = language.isUpToDate;
        }
        return language.copy(str, str2, z, bool);
    }

    public static final List<String> getSpecialResources() {
        return INSTANCE.getSpecialResources();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLanguageKey() {
        return this.languageKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsAvailable() {
        return this.isAvailable;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getIsUpToDate() {
        return this.isUpToDate;
    }

    public final Language copy(String languageKey, String displayName, boolean isAvailable, Boolean isUpToDate) {
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        return new Language(languageKey, displayName, isAvailable, isUpToDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Language)) {
            return false;
        }
        Language language = (Language) other;
        return Intrinsics.areEqual(this.languageKey, language.languageKey) && Intrinsics.areEqual(this.displayName, language.displayName) && this.isAvailable == language.isAvailable && Intrinsics.areEqual(this.isUpToDate, language.isUpToDate);
    }

    public int hashCode() {
        int iHashCode = ((((this.languageKey.hashCode() * 31) + this.displayName.hashCode()) * 31) + Boolean.hashCode(this.isAvailable)) * 31;
        Boolean bool = this.isUpToDate;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "Language(languageKey=" + this.languageKey + ", displayName=" + this.displayName + ", isAvailable=" + this.isAvailable + ", isUpToDate=" + this.isUpToDate + ")";
    }

    public Language(String languageKey, String displayName, boolean z, Boolean bool) {
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.languageKey = languageKey;
        this.displayName = displayName;
        this.isAvailable = z;
        this.isUpToDate = bool;
    }

    public final String getLanguageKey() {
        return this.languageKey;
    }

    public /* synthetic */ Language(String str, String str2, boolean z, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : bool);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final boolean isAvailable() {
        return this.isAvailable;
    }

    public final Boolean isUpToDate() {
        return this.isUpToDate;
    }

    @Override // java.lang.Comparable
    public int compareTo(Language other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.displayName.length() == 0 || other.displayName.length() == 0) {
            return this.languageKey.compareTo(other.languageKey);
        }
        return this.displayName.compareTo(other.displayName);
    }

    /* JADX INFO: compiled from: Language.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/atk/resourcemanager/Language$Companion;", "", "<init>", "()V", "isSpecialResources", "", "langKey", "", "specialResources", "", "getSpecialResources$annotations", "getSpecialResources", "()Ljava/util/List;", "specialResources$delegate", "Lkotlin/Lazy;", "resourcemanager-lib_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSpecialResources$annotations() {
        }

        private Companion() {
        }

        public final boolean isSpecialResources(String langKey) {
            Intrinsics.checkNotNullParameter(langKey, "langKey");
            return getSpecialResources().contains(langKey);
        }

        public final List<String> getSpecialResources() {
            return (List) Language.specialResources$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List specialResources_delegate$lambda$0() {
        return CollectionsKt.listOf((Object[]) new String[]{Constants.MUL, Constants.CYRILLIC, Constants.LATIN});
    }
}
