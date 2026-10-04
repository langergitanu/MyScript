package com.survicate.surveys.infrastructure.network.contacts;

import com.survicate.surveys.entities.models.ContactAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserAttributesRequestBody.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m1599d2 = {"PAYLOAD_VERSION", "", "toRequestBody", "Lcom/survicate/surveys/infrastructure/network/contacts/UserAttributesRequestBody;", "Lcom/survicate/surveys/entities/models/ContactAction$SetAttributes;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class UserAttributesRequestBodyKt {
    private static final String PAYLOAD_VERSION = "1.0.0";

    public static final UserAttributesRequestBody toRequestBody(ContactAction.SetAttributes setAttributes) {
        Intrinsics.checkNotNullParameter(setAttributes, "<this>");
        return new UserAttributesRequestBody(setAttributes);
    }
}
