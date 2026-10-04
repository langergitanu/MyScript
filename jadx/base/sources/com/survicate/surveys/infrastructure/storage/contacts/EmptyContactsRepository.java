package com.survicate.surveys.infrastructure.storage.contacts;

import androidx.core.app.NotificationCompat;
import com.survicate.surveys.entities.models.ContactAction;
import com.survicate.surveys.infrastructure.network.contacts.BackendTargetingResult;
import com.survicate.surveys.targeting.ActiveEvent;
import com.survicate.surveys.traits.UserTrait;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmptyContactsRepository.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J*\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00172\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0017H\u0096@¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006("}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/contacts/EmptyContactsRepository;", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactsRepository;", "<init>", "()V", "isBackendTargetingAllowed", "", "()Z", "authenticationEnforcement", "Lcom/survicate/surveys/infrastructure/storage/contacts/AuthenticationEnforcement;", "getAuthenticationEnforcement", "()Lcom/survicate/surveys/infrastructure/storage/contacts/AuthenticationEnforcement;", "setAuthenticationEnforcement", "(Lcom/survicate/surveys/infrastructure/storage/contacts/AuthenticationEnforcement;)V", "backendTargetingState", "Lcom/survicate/surveys/infrastructure/storage/contacts/BackendTargetingState;", "getBackendTargetingState", "()Lcom/survicate/surveys/infrastructure/storage/contacts/BackendTargetingState;", "setBackendTargetingState", "(Lcom/survicate/surveys/infrastructure/storage/contacts/BackendTargetingState;)V", "init", "", "updateUserTraits", "updatedTraits", "", "Lcom/survicate/surveys/traits/UserTrait;", "savedTraits", "addEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/survicate/surveys/targeting/ActiveEvent;", "addSurveyInteraction", "interaction", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction$Interaction;", "checkBackendTargeting", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingResult;", "surveyIds", "", "audienceIds", "", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EmptyContactsRepository implements ContactsRepository {
    private AuthenticationEnforcement authenticationEnforcement = AuthenticationEnforcement.UNKNOWN;
    private BackendTargetingState backendTargetingState = BackendTargetingState.UNKNOWN;
    private final boolean isBackendTargetingAllowed;

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public void addEvent(ActiveEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public void addSurveyInteraction(ContactAction.SurveyInteraction.Interaction interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public void clear() {
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public void init() {
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public void updateUserTraits(List<? extends UserTrait> updatedTraits, List<? extends UserTrait> savedTraits) {
        Intrinsics.checkNotNullParameter(updatedTraits, "updatedTraits");
        Intrinsics.checkNotNullParameter(savedTraits, "savedTraits");
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    /* JADX INFO: renamed from: isBackendTargetingAllowed, reason: from getter */
    public boolean getIsBackendTargetingAllowed() {
        return this.isBackendTargetingAllowed;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public AuthenticationEnforcement getAuthenticationEnforcement() {
        return this.authenticationEnforcement;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public void setAuthenticationEnforcement(AuthenticationEnforcement authenticationEnforcement) {
        Intrinsics.checkNotNullParameter(authenticationEnforcement, "<set-?>");
        this.authenticationEnforcement = authenticationEnforcement;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public BackendTargetingState getBackendTargetingState() {
        return this.backendTargetingState;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public void setBackendTargetingState(BackendTargetingState backendTargetingState) {
        Intrinsics.checkNotNullParameter(backendTargetingState, "<set-?>");
        this.backendTargetingState = backendTargetingState;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public Object checkBackendTargeting(List<String> list, List<Long> list2, Continuation<? super BackendTargetingResult> continuation) {
        throw new UnsupportedOperationException();
    }
}
