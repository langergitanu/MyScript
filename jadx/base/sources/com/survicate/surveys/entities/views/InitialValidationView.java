package com.survicate.surveys.entities.views;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: InitialValidationView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006H&J\b\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/entities/views/InitialValidationView;", ExifInterface.GPS_DIRECTION_TRUE, "", "bindInitialValidator", "", "validator", "Lkotlin/Function1;", "", "isInitiallyValid", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface InitialValidationView<T> {
    void bindInitialValidator(Function1<? super T, Boolean> validator);

    boolean isInitiallyValid();
}
