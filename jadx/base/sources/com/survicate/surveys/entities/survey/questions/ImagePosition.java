package com.survicate.surveys.entities.survey.questions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SurveyPointImage.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/ImagePosition;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ImagePosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ImagePosition[] $VALUES;

    @SerialName("top")
    public static final ImagePosition TOP = new ImagePosition("TOP", 0);

    @SerialName("bottom")
    public static final ImagePosition BOTTOM = new ImagePosition("BOTTOM", 1);

    private static final /* synthetic */ ImagePosition[] $values() {
        return new ImagePosition[]{TOP, BOTTOM};
    }

    public static EnumEntries<ImagePosition> getEntries() {
        return $ENTRIES;
    }

    private ImagePosition(String str, int i) {
    }

    static {
        ImagePosition[] imagePositionArr$values = $values();
        $VALUES = imagePositionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(imagePositionArr$values);
    }

    public static ImagePosition valueOf(String str) {
        return (ImagePosition) Enum.valueOf(ImagePosition.class, str);
    }

    public static ImagePosition[] values() {
        return (ImagePosition[]) $VALUES.clone();
    }
}
