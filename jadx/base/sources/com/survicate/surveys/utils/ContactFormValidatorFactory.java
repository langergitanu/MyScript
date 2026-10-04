package com.survicate.surveys.utils;

import android.content.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.entities.survey.questions.form.SurveyFormField;
import com.survicate.surveys.entities.views.InputValidationResult;
import com.survicate.surveys.entities.views.InputValidator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactFormValidators.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, m1599d2 = {"Lcom/survicate/surveys/utils/ContactFormValidatorFactory;", "", "<init>", "()V", "createValidator", "Lcom/survicate/surveys/entities/views/InputValidator;", "", "formField", "Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormField;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ContactFormValidatorFactory {
    public static final ContactFormValidatorFactory INSTANCE = new ContactFormValidatorFactory();

    private ContactFormValidatorFactory() {
    }

    public final InputValidator<String> createValidator(SurveyFormField formField, Context context) {
        Intrinsics.checkNotNullParameter(formField, "formField");
        Intrinsics.checkNotNullParameter(context, "context");
        if (formField.getRequired()) {
            return Intrinsics.areEqual(formField.getFieldType(), "email") ? new EmailValidator(context) : new IsFilledInValidator(context);
        }
        return new InputValidator() { // from class: com.survicate.surveys.utils.ContactFormValidatorFactory$$ExternalSyntheticLambda0
            @Override // com.survicate.surveys.entities.views.InputValidator
            public final InputValidationResult validate(Object obj) {
                return ContactFormValidatorFactory.createValidator$lambda$0((String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InputValidationResult createValidator$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new InputValidationResult(true, null, 2, null);
    }
}
