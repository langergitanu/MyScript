package com.survicate.surveys;

import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.webkit.Profile;
import com.survicate.surveys.FontSource;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurvicateFontSystem.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, m1599d2 = {"Lcom/survicate/surveys/SurvicateFontSystem;", "", "regular", "Lcom/survicate/surveys/FontSource;", "regularItalic", TtmlNode.BOLD, "boldItalic", "<init>", "(Lcom/survicate/surveys/FontSource;Lcom/survicate/surveys/FontSource;Lcom/survicate/surveys/FontSource;Lcom/survicate/surveys/FontSource;)V", "getRegular", "()Lcom/survicate/surveys/FontSource;", "getRegularItalic", "getBold", "getBoldItalic", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SurvicateFontSystem {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final FontSource bold;
    private final FontSource boldItalic;
    private final FontSource regular;
    private final FontSource regularItalic;

    public static /* synthetic */ SurvicateFontSystem copy$default(SurvicateFontSystem survicateFontSystem, FontSource fontSource, FontSource fontSource2, FontSource fontSource3, FontSource fontSource4, int i, Object obj) {
        if ((i & 1) != 0) {
            fontSource = survicateFontSystem.regular;
        }
        if ((i & 2) != 0) {
            fontSource2 = survicateFontSystem.regularItalic;
        }
        if ((i & 4) != 0) {
            fontSource3 = survicateFontSystem.bold;
        }
        if ((i & 8) != 0) {
            fontSource4 = survicateFontSystem.boldItalic;
        }
        return survicateFontSystem.copy(fontSource, fontSource2, fontSource3, fontSource4);
    }

    public static final SurvicateFontSystem getDefault() {
        return INSTANCE.getDefault();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FontSource getRegular() {
        return this.regular;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FontSource getRegularItalic() {
        return this.regularItalic;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FontSource getBold() {
        return this.bold;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final FontSource getBoldItalic() {
        return this.boldItalic;
    }

    public final SurvicateFontSystem copy(FontSource regular, FontSource regularItalic, FontSource bold, FontSource boldItalic) {
        Intrinsics.checkNotNullParameter(regular, "regular");
        Intrinsics.checkNotNullParameter(regularItalic, "regularItalic");
        Intrinsics.checkNotNullParameter(bold, "bold");
        Intrinsics.checkNotNullParameter(boldItalic, "boldItalic");
        return new SurvicateFontSystem(regular, regularItalic, bold, boldItalic);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurvicateFontSystem)) {
            return false;
        }
        SurvicateFontSystem survicateFontSystem = (SurvicateFontSystem) other;
        return Intrinsics.areEqual(this.regular, survicateFontSystem.regular) && Intrinsics.areEqual(this.regularItalic, survicateFontSystem.regularItalic) && Intrinsics.areEqual(this.bold, survicateFontSystem.bold) && Intrinsics.areEqual(this.boldItalic, survicateFontSystem.boldItalic);
    }

    public int hashCode() {
        return (((((this.regular.hashCode() * 31) + this.regularItalic.hashCode()) * 31) + this.bold.hashCode()) * 31) + this.boldItalic.hashCode();
    }

    public String toString() {
        return "SurvicateFontSystem(regular=" + this.regular + ", regularItalic=" + this.regularItalic + ", bold=" + this.bold + ", boldItalic=" + this.boldItalic + ')';
    }

    public SurvicateFontSystem(FontSource regular, FontSource regularItalic, FontSource bold, FontSource boldItalic) {
        Intrinsics.checkNotNullParameter(regular, "regular");
        Intrinsics.checkNotNullParameter(regularItalic, "regularItalic");
        Intrinsics.checkNotNullParameter(bold, "bold");
        Intrinsics.checkNotNullParameter(boldItalic, "boldItalic");
        this.regular = regular;
        this.regularItalic = regularItalic;
        this.bold = bold;
        this.boldItalic = boldItalic;
    }

    public final FontSource getRegular() {
        return this.regular;
    }

    public final FontSource getRegularItalic() {
        return this.regularItalic;
    }

    public final FontSource getBold() {
        return this.bold;
    }

    public final FontSource getBoldItalic() {
        return this.boldItalic;
    }

    /* JADX INFO: compiled from: SurvicateFontSystem.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/SurvicateFontSystem$Companion;", "", "<init>", "()V", Profile.DEFAULT_PROFILE_NAME, "Lcom/survicate/surveys/SurvicateFontSystem;", "getDefault$annotations", "getDefault", "()Lcom/survicate/surveys/SurvicateFontSystem;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getDefault$annotations() {
        }

        private Companion() {
        }

        public final SurvicateFontSystem getDefault() {
            return new SurvicateFontSystem(new FontSource.ResId(C8369R.font.open_sans_regular), new FontSource.ResId(C8369R.font.open_sans_regular_italic), new FontSource.ResId(C8369R.font.open_sans_semibold), new FontSource.ResId(C8369R.font.open_sans_semibold_italic));
        }
    }
}
