package com.myscript.nebo.dms.sharepage.api.entity;

import com.google.gson.annotations.SerializedName;
import com.myscript.nebo.dms.sharepage.api.entity.PagePayload;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OptionsPayload.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/entity/OptionsPayload;", "", "visibility", "Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Visibility;", "<init>", "(Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Visibility;)V", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class OptionsPayload {

    @SerializedName("visibility")
    public final PagePayload.Visibility visibility;

    public static /* synthetic */ OptionsPayload copy$default(OptionsPayload optionsPayload, PagePayload.Visibility visibility, int i, Object obj) {
        if ((i & 1) != 0) {
            visibility = optionsPayload.visibility;
        }
        return optionsPayload.copy(visibility);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PagePayload.Visibility getVisibility() {
        return this.visibility;
    }

    public final OptionsPayload copy(PagePayload.Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        return new OptionsPayload(visibility);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OptionsPayload) && this.visibility == ((OptionsPayload) other).visibility;
    }

    public int hashCode() {
        return this.visibility.hashCode();
    }

    public String toString() {
        return "OptionsPayload(visibility=" + this.visibility + ")";
    }

    public OptionsPayload(PagePayload.Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        this.visibility = visibility;
    }
}
