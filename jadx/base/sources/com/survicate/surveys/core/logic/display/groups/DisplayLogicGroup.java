package com.survicate.surveys.core.logic.display.groups;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: DisplayLogicGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006\u0082\u0001\u0007\u0007\b\t\n\u000b\f\r¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicGroup;", ExifInterface.GPS_DIRECTION_TRUE, "", "isSatisfiedBy", "", "answer", "(Ljava/lang/Object;)Z", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicDateGroup;", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicFormGroup;", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicMatrixGroup;", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicMultipleChoiceGroup;", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicRangeGroup;", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicSingleChoiceGroup;", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicTextGroup;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface DisplayLogicGroup<T> {
    boolean isSatisfiedBy(T answer);
}
