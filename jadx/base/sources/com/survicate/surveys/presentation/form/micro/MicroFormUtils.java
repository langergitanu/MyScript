package com.survicate.surveys.presentation.form.micro;

import androidx.autofill.HintConstants;
import com.survicate.surveys.surveys.FormSurveyFieldType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroFormUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/presentation/form/micro/MicroFormUtils;", "", "<init>", "()V", "getInputType", "", "fieldType", "", "getAutofillHint", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroFormUtils {
    public static final MicroFormUtils INSTANCE = new MicroFormUtils();

    private MicroFormUtils() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int getInputType(String fieldType) {
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        switch (fieldType.hashCode()) {
            case -160985414:
                return !fieldType.equals(FormSurveyFieldType.FIRST_NAME) ? 1 : 8192;
            case 96619420:
                return !fieldType.equals("email") ? 1 : 32;
            case 106642798:
                return !fieldType.equals("phone") ? 1 : 3;
            case 1224335515:
                return !fieldType.equals(FormSurveyFieldType.WEBSITE) ? 1 : 16;
            case 2013122196:
                return !fieldType.equals(FormSurveyFieldType.LAST_NAME) ? 1 : 8192;
            default:
                return 1;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String getAutofillHint(String fieldType) {
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        switch (fieldType.hashCode()) {
            case -1376952421:
                if (fieldType.equals(FormSurveyFieldType.ADDRESS_ONE)) {
                    return HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_STREET_ADDRESS;
                }
                return null;
            case -1376947327:
                if (fieldType.equals(FormSurveyFieldType.ADDRESS_TWO)) {
                    return HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_ADDRESS;
                }
                return null;
            case -160985414:
                if (fieldType.equals(FormSurveyFieldType.FIRST_NAME)) {
                    return HintConstants.AUTOFILL_HINT_PERSON_NAME_GIVEN;
                }
                return null;
            case 120609:
                if (fieldType.equals(FormSurveyFieldType.ZIP)) {
                    return HintConstants.AUTOFILL_HINT_POSTAL_CODE;
                }
                return null;
            case 3053931:
                if (fieldType.equals(FormSurveyFieldType.CITY)) {
                    return HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_LOCALITY;
                }
                return null;
            case 96619420:
                if (fieldType.equals("email")) {
                    return HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS;
                }
                return null;
            case 106642798:
                if (fieldType.equals("phone")) {
                    return HintConstants.AUTOFILL_HINT_PHONE_NUMBER;
                }
                return null;
            case 109757585:
                if (fieldType.equals("state")) {
                    return HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_REGION;
                }
                return null;
            case 957831062:
                if (fieldType.equals("country")) {
                    return HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_COUNTRY;
                }
                return null;
            case 2013122196:
                if (fieldType.equals(FormSurveyFieldType.LAST_NAME)) {
                    return HintConstants.AUTOFILL_HINT_PERSON_NAME_FAMILY;
                }
                return null;
            default:
                return null;
        }
    }
}
