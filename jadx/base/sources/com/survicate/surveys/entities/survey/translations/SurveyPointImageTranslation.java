package com.survicate.surveys.entities.survey.translations;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyPointTranslation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/translations/SurveyPointImageTranslation;", "", "image", "Lcom/survicate/surveys/entities/survey/translations/ImageTranslation;", "<init>", "(Lcom/survicate/surveys/entities/survey/translations/ImageTranslation;)V", "getImage", "()Lcom/survicate/surveys/entities/survey/translations/ImageTranslation;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SurveyPointImageTranslation {
    private final ImageTranslation image;

    public static /* synthetic */ SurveyPointImageTranslation copy$default(SurveyPointImageTranslation surveyPointImageTranslation, ImageTranslation imageTranslation, int i, Object obj) {
        if ((i & 1) != 0) {
            imageTranslation = surveyPointImageTranslation.image;
        }
        return surveyPointImageTranslation.copy(imageTranslation);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ImageTranslation getImage() {
        return this.image;
    }

    public final SurveyPointImageTranslation copy(ImageTranslation image) {
        return new SurveyPointImageTranslation(image);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SurveyPointImageTranslation) && Intrinsics.areEqual(this.image, ((SurveyPointImageTranslation) other).image);
    }

    public int hashCode() {
        ImageTranslation imageTranslation = this.image;
        if (imageTranslation == null) {
            return 0;
        }
        return imageTranslation.hashCode();
    }

    public String toString() {
        return "SurveyPointImageTranslation(image=" + this.image + ')';
    }

    public SurveyPointImageTranslation(ImageTranslation imageTranslation) {
        this.image = imageTranslation;
    }

    public final ImageTranslation getImage() {
        return this.image;
    }
}
