package com.survicate.surveys.entities.views;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: InputValidationView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/entities/views/InputValidationView;", ExifInterface.GPS_DIRECTION_TRUE, "", "bindValidator", "", "validator", "Lcom/survicate/surveys/entities/views/InputValidator;", "validate", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface InputValidationView<T> {
    void bindValidator(InputValidator<T> validator);

    boolean validate();
}
