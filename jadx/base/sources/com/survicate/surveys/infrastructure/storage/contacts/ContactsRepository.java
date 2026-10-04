package com.survicate.surveys.infrastructure.storage.contacts;

import androidx.core.app.NotificationCompat;
import com.survicate.surveys.entities.models.ContactAction;
import com.survicate.surveys.infrastructure.network.contacts.BackendTargetingResult;
import com.survicate.surveys.targeting.ActiveEvent;
import com.survicate.surveys.traits.UserTrait;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ContactsRepository.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0011\u001a\u00020\u0012H&J$\u0010\u0013\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H&J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH&J*\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0015H¦@¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0012H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0018\u0010\u0005\u001a\u00020\u0006X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006&"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/contacts/ContactsRepository;", "", "isBackendTargetingAllowed", "", "()Z", "backendTargetingState", "Lcom/survicate/surveys/infrastructure/storage/contacts/BackendTargetingState;", "getBackendTargetingState", "()Lcom/survicate/surveys/infrastructure/storage/contacts/BackendTargetingState;", "setBackendTargetingState", "(Lcom/survicate/surveys/infrastructure/storage/contacts/BackendTargetingState;)V", "authenticationEnforcement", "Lcom/survicate/surveys/infrastructure/storage/contacts/AuthenticationEnforcement;", "getAuthenticationEnforcement", "()Lcom/survicate/surveys/infrastructure/storage/contacts/AuthenticationEnforcement;", "setAuthenticationEnforcement", "(Lcom/survicate/surveys/infrastructure/storage/contacts/AuthenticationEnforcement;)V", "init", "", "updateUserTraits", "updatedTraits", "", "Lcom/survicate/surveys/traits/UserTrait;", "savedTraits", "addEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/survicate/surveys/targeting/ActiveEvent;", "addSurveyInteraction", "interaction", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction$Interaction;", "checkBackendTargeting", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingResult;", "surveyIds", "", "audienceIds", "", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ContactsRepository {
    void addEvent(ActiveEvent event);

    void addSurveyInteraction(ContactAction.SurveyInteraction.Interaction interaction);

    Object checkBackendTargeting(List<String> list, List<Long> list2, Continuation<? super BackendTargetingResult> continuation) throws IOException;

    void clear();

    AuthenticationEnforcement getAuthenticationEnforcement();

    BackendTargetingState getBackendTargetingState();

    void init();

    boolean isBackendTargetingAllowed();

    void setAuthenticationEnforcement(AuthenticationEnforcement authenticationEnforcement);

    void setBackendTargetingState(BackendTargetingState backendTargetingState);

    void updateUserTraits(List<? extends UserTrait> updatedTraits, List<? extends UserTrait> savedTraits);
}
