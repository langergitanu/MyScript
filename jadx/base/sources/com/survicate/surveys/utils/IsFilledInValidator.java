package com.survicate.surveys.utils;

import android.content.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.views.InputValidationResult;
import com.survicate.surveys.entities.views.InputValidator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ContactFormValidators.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/utils/IsFilledInValidator;", "Lcom/survicate/surveys/entities/views/InputValidator;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "validate", "Lcom/survicate/surveys/entities/views/InputValidationResult;", "input", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class IsFilledInValidator implements InputValidator<String> {
    private final Context context;

    public IsFilledInValidator(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.survicate.surveys.entities.views.InputValidator
    public InputValidationResult validate(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (!StringsKt.isBlank(input)) {
            return new InputValidationResult(true, null, 2, null);
        }
        return new InputValidationResult(false, this.context.getString(C8369R.string.survicate_micro_error_empty_field));
    }
}
