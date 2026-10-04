package com.survicate.surveys.presentation.nps.micro;

import kotlin.Metadata;

/* JADX INFO: compiled from: NpsAnswerStyle.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, m1599d2 = {"Lcom/survicate/surveys/presentation/nps/micro/NpsAnswerItemTemplate;", "", "layoutRes", "", "labelId", "useContentDescriptionForLabel", "", "<init>", "(IIZ)V", "getLayoutRes", "()I", "getLabelId", "getUseContentDescriptionForLabel", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class NpsAnswerItemTemplate {
    private final int labelId;
    private final int layoutRes;
    private final boolean useContentDescriptionForLabel;

    public static /* synthetic */ NpsAnswerItemTemplate copy$default(NpsAnswerItemTemplate npsAnswerItemTemplate, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = npsAnswerItemTemplate.layoutRes;
        }
        if ((i3 & 2) != 0) {
            i2 = npsAnswerItemTemplate.labelId;
        }
        if ((i3 & 4) != 0) {
            z = npsAnswerItemTemplate.useContentDescriptionForLabel;
        }
        return npsAnswerItemTemplate.copy(i, i2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLayoutRes() {
        return this.layoutRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLabelId() {
        return this.labelId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getUseContentDescriptionForLabel() {
        return this.useContentDescriptionForLabel;
    }

    public final NpsAnswerItemTemplate copy(int layoutRes, int labelId, boolean useContentDescriptionForLabel) {
        return new NpsAnswerItemTemplate(layoutRes, labelId, useContentDescriptionForLabel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NpsAnswerItemTemplate)) {
            return false;
        }
        NpsAnswerItemTemplate npsAnswerItemTemplate = (NpsAnswerItemTemplate) other;
        return this.layoutRes == npsAnswerItemTemplate.layoutRes && this.labelId == npsAnswerItemTemplate.labelId && this.useContentDescriptionForLabel == npsAnswerItemTemplate.useContentDescriptionForLabel;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.layoutRes) * 31) + Integer.hashCode(this.labelId)) * 31) + Boolean.hashCode(this.useContentDescriptionForLabel);
    }

    public String toString() {
        return "NpsAnswerItemTemplate(layoutRes=" + this.layoutRes + ", labelId=" + this.labelId + ", useContentDescriptionForLabel=" + this.useContentDescriptionForLabel + ')';
    }

    public NpsAnswerItemTemplate(int i, int i2, boolean z) {
        this.layoutRes = i;
        this.labelId = i2;
        this.useContentDescriptionForLabel = z;
    }

    public final int getLayoutRes() {
        return this.layoutRes;
    }

    public final int getLabelId() {
        return this.labelId;
    }

    public final boolean getUseContentDescriptionForLabel() {
        return this.useContentDescriptionForLabel;
    }
}
