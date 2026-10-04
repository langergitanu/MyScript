package com.myscript.nebo.languagemanager.presentation.model;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageManagerItem.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem;", "", "<init>", "()V", "type", "", "getType", "()I", "Companion", "Lang", "Explanation", "Section", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem$Explanation;", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem$Lang;", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem$Section;", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class LanguageManagerItem {
    public static final int ITEM_VIEW_TYPE_HEADER = 0;
    public static final int ITEM_VIEW_TYPE_LANGUAGE = 2;
    public static final int ITEM_VIEW_TYPE_SECTION = 1;

    public /* synthetic */ LanguageManagerItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getType();

    private LanguageManagerItem() {
    }

    /* JADX INFO: compiled from: LanguageManagerItem.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003Jm\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001J\u0014\u00106\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u000108HÖ\u0083\u0004J\n\u00109\u001a\u00020\nHÖ\u0081\u0004J\n\u0010:\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0015\"\u0004\b\u0018\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0015\"\u0004\b$\u0010\u0017R\u0014\u0010%\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0011\u0010'\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b'\u0010\u0015R\u0011\u0010(\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b(\u0010\u0015R\u0011\u0010)\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b)\u0010\u0015R\u0011\u0010*\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b*\u0010\u0015¨\u0006;"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem$Lang;", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem;", SubscriberAttributeKt.JSON_NAME_KEY, "", "label", "installed", "", "isUpToDate", "isDownloadable", "progress", "", "max", "pending", "suggested", "isSelected", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZZIIZZZ)V", "getKey", "()Ljava/lang/String;", "getLabel", "getInstalled", "()Z", "setInstalled", "(Z)V", "setUpToDate", "setDownloadable", "getProgress", "()I", "setProgress", "(I)V", "getMax", "setMax", "getPending", "setPending", "getSuggested", "setSuggested", "setSelected", "type", "getType", "isDownloadOnGoing", "isRemovable", "isRemoveVisible", "isDownloadVisible", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "", "hashCode", "toString", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Lang extends LanguageManagerItem {
        private boolean installed;
        private boolean isDownloadable;
        private boolean isSelected;
        private boolean isUpToDate;
        private final String key;
        private final String label;
        private int max;
        private boolean pending;
        private int progress;
        private boolean suggested;
        private final int type;

        public static /* synthetic */ Lang copy$default(Lang lang, String str, String str2, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, boolean z6, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = lang.key;
            }
            if ((i3 & 2) != 0) {
                str2 = lang.label;
            }
            if ((i3 & 4) != 0) {
                z = lang.installed;
            }
            if ((i3 & 8) != 0) {
                z2 = lang.isUpToDate;
            }
            if ((i3 & 16) != 0) {
                z3 = lang.isDownloadable;
            }
            if ((i3 & 32) != 0) {
                i = lang.progress;
            }
            if ((i3 & 64) != 0) {
                i2 = lang.max;
            }
            if ((i3 & 128) != 0) {
                z4 = lang.pending;
            }
            if ((i3 & 256) != 0) {
                z5 = lang.suggested;
            }
            if ((i3 & 512) != 0) {
                z6 = lang.isSelected;
            }
            boolean z7 = z5;
            boolean z8 = z6;
            int i4 = i2;
            boolean z9 = z4;
            boolean z10 = z3;
            int i5 = i;
            return lang.copy(str, str2, z, z2, z10, i5, i4, z9, z7, z8);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getInstalled() {
            return this.installed;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsUpToDate() {
            return this.isUpToDate;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsDownloadable() {
            return this.isDownloadable;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getProgress() {
            return this.progress;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getMax() {
            return this.max;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getPending() {
            return this.pending;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getSuggested() {
            return this.suggested;
        }

        public final Lang copy(String key, String label, boolean installed, boolean isUpToDate, boolean isDownloadable, int progress, int max, boolean pending, boolean suggested, boolean isSelected) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(label, "label");
            return new Lang(key, label, installed, isUpToDate, isDownloadable, progress, max, pending, suggested, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Lang)) {
                return false;
            }
            Lang lang = (Lang) other;
            return Intrinsics.areEqual(this.key, lang.key) && Intrinsics.areEqual(this.label, lang.label) && this.installed == lang.installed && this.isUpToDate == lang.isUpToDate && this.isDownloadable == lang.isDownloadable && this.progress == lang.progress && this.max == lang.max && this.pending == lang.pending && this.suggested == lang.suggested && this.isSelected == lang.isSelected;
        }

        public int hashCode() {
            return (((((((((((((((((this.key.hashCode() * 31) + this.label.hashCode()) * 31) + Boolean.hashCode(this.installed)) * 31) + Boolean.hashCode(this.isUpToDate)) * 31) + Boolean.hashCode(this.isDownloadable)) * 31) + Integer.hashCode(this.progress)) * 31) + Integer.hashCode(this.max)) * 31) + Boolean.hashCode(this.pending)) * 31) + Boolean.hashCode(this.suggested)) * 31) + Boolean.hashCode(this.isSelected);
        }

        public String toString() {
            return "Lang(key=" + this.key + ", label=" + this.label + ", installed=" + this.installed + ", isUpToDate=" + this.isUpToDate + ", isDownloadable=" + this.isDownloadable + ", progress=" + this.progress + ", max=" + this.max + ", pending=" + this.pending + ", suggested=" + this.suggested + ", isSelected=" + this.isSelected + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Lang(String key, String label, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, boolean z6) {
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(label, "label");
            this.key = key;
            this.label = label;
            this.installed = z;
            this.isUpToDate = z2;
            this.isDownloadable = z3;
            this.progress = i;
            this.max = i2;
            this.pending = z4;
            this.suggested = z5;
            this.isSelected = z6;
            this.type = 2;
        }

        public /* synthetic */ Lang(String str, String str2, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, boolean z6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, z, z2, z3, (i3 & 32) != 0 ? 0 : i, (i3 & 64) != 0 ? 0 : i2, (i3 & 128) != 0 ? false : z4, (i3 & 256) != 0 ? false : z5, (i3 & 512) != 0 ? false : z6);
        }

        public final String getKey() {
            return this.key;
        }

        public final String getLabel() {
            return this.label;
        }

        public final boolean getInstalled() {
            return this.installed;
        }

        public final void setInstalled(boolean z) {
            this.installed = z;
        }

        public final boolean isUpToDate() {
            return this.isUpToDate;
        }

        public final void setUpToDate(boolean z) {
            this.isUpToDate = z;
        }

        public final boolean isDownloadable() {
            return this.isDownloadable;
        }

        public final void setDownloadable(boolean z) {
            this.isDownloadable = z;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final void setProgress(int i) {
            this.progress = i;
        }

        public final int getMax() {
            return this.max;
        }

        public final void setMax(int i) {
            this.max = i;
        }

        public final boolean getPending() {
            return this.pending;
        }

        public final void setPending(boolean z) {
            this.pending = z;
        }

        public final boolean getSuggested() {
            return this.suggested;
        }

        public final void setSuggested(boolean z) {
            this.suggested = z;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public final void setSelected(boolean z) {
            this.isSelected = z;
        }

        @Override // com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem
        public int getType() {
            return this.type;
        }

        public final boolean isDownloadOnGoing() {
            return this.progress > 1;
        }

        public final boolean isRemovable() {
            return this.installed && !Intrinsics.areEqual(this.key, "en_US");
        }

        public final boolean isRemoveVisible() {
            return this.installed && !this.isSelected;
        }

        public final boolean isDownloadVisible() {
            return (this.installed || isDownloadOnGoing()) ? false : true;
        }
    }

    /* JADX INFO: compiled from: LanguageManagerItem.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem$Explanation;", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem;", "<init>", "()V", "type", "", "getType", "()I", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Explanation extends LanguageManagerItem {
        public static final Explanation INSTANCE = new Explanation();
        private static final int type = 0;

        private Explanation() {
            super(null);
        }

        @Override // com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem
        public int getType() {
            return type;
        }
    }

    /* JADX INFO: compiled from: LanguageManagerItem.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem$Section;", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem;", "sectionType", "Lcom/myscript/nebo/languagemanager/presentation/model/SectionType;", "number", "", "<init>", "(Lcom/myscript/nebo/languagemanager/presentation/model/SectionType;I)V", "getSectionType", "()Lcom/myscript/nebo/languagemanager/presentation/model/SectionType;", "getNumber", "()I", "type", "getType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Section extends LanguageManagerItem {
        private final int number;
        private final SectionType sectionType;
        private final int type;

        public static /* synthetic */ Section copy$default(Section section, SectionType sectionType, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                sectionType = section.sectionType;
            }
            if ((i2 & 2) != 0) {
                i = section.number;
            }
            return section.copy(sectionType, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SectionType getSectionType() {
            return this.sectionType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getNumber() {
            return this.number;
        }

        public final Section copy(SectionType sectionType, int number) {
            Intrinsics.checkNotNullParameter(sectionType, "sectionType");
            return new Section(sectionType, number);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Section)) {
                return false;
            }
            Section section = (Section) other;
            return this.sectionType == section.sectionType && this.number == section.number;
        }

        public int hashCode() {
            return (this.sectionType.hashCode() * 31) + Integer.hashCode(this.number);
        }

        public String toString() {
            return "Section(sectionType=" + this.sectionType + ", number=" + this.number + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Section(SectionType sectionType, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(sectionType, "sectionType");
            this.sectionType = sectionType;
            this.number = i;
            this.type = 1;
        }

        public final int getNumber() {
            return this.number;
        }

        public final SectionType getSectionType() {
            return this.sectionType;
        }

        @Override // com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem
        public int getType() {
            return this.type;
        }
    }
}
