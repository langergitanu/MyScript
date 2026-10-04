package com.survicate.surveys.infrastructure.network.contacts;

import com.survicate.surveys.entities.models.ContactAction;
import com.survicate.surveys.infrastructure.network.contacts.ContactsApiModels;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactsApiModels.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0000¨\u0006\u0005"}, m1599d2 = {"toApiModel", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$SurveyInteractionType;", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteractionType;", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$SurveyInteraction;", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction$Interaction;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ContactsApiModelsKt {

    /* JADX INFO: compiled from: ContactsApiModels.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ContactAction.SurveyInteractionType.values().length];
            try {
                iArr[ContactAction.SurveyInteractionType.SEEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContactAction.SurveyInteractionType.ANSWERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ContactAction.SurveyInteractionType.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ContactAction.SurveyInteractionType.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContactsApiModels.SurveyInteractionType toApiModel(ContactAction.SurveyInteractionType surveyInteractionType) {
        int i = WhenMappings.$EnumSwitchMapping$0[surveyInteractionType.ordinal()];
        if (i == 1) {
            return ContactsApiModels.SurveyInteractionType.SEEN;
        }
        if (i == 2) {
            return ContactsApiModels.SurveyInteractionType.ANSWERED;
        }
        if (i == 3) {
            return ContactsApiModels.SurveyInteractionType.COMPLETED;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return ContactsApiModels.SurveyInteractionType.CLOSED;
    }

    public static final ContactsApiModels.SurveyInteraction toApiModel(ContactAction.SurveyInteraction.Interaction interaction) {
        Intrinsics.checkNotNullParameter(interaction, "<this>");
        return new ContactsApiModels.SurveyInteraction(interaction);
    }
}
