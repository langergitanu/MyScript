package com.survicate.surveys.entities.views;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: InputValidationView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0080\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/views/InputValidator;", ExifInterface.GPS_DIRECTION_TRUE, "", "validate", "Lcom/survicate/surveys/entities/views/InputValidationResult;", "input", "(Ljava/lang/Object;)Lcom/survicate/surveys/entities/views/InputValidationResult;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface InputValidator<T> {
    InputValidationResult validate(T input);
}
