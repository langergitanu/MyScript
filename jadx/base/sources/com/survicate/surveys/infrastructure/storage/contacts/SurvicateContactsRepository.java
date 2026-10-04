package com.survicate.surveys.infrastructure.storage.contacts;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.core.queue.QueueTask;
import com.survicate.surveys.core.queue.TaskScheduler;
import com.survicate.surveys.core.targeting.backend.BackendTargetingResultStore;
import com.survicate.surveys.entities.models.ContactAction;
import com.survicate.surveys.entities.models.Respondent;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.helpers.Observable;
import com.survicate.surveys.helpers.UserTraitUtilsKt;
import com.survicate.surveys.infrastructure.network.HttpException;
import com.survicate.surveys.infrastructure.network.HttpExceptionKt;
import com.survicate.surveys.infrastructure.network.contacts.BackendTargetingRequestBody;
import com.survicate.surveys.infrastructure.network.contacts.BackendTargetingResult;
import com.survicate.surveys.infrastructure.network.contacts.ContactsApi;
import com.survicate.surveys.infrastructure.network.contacts.ContactsApiModels;
import com.survicate.surveys.infrastructure.network.contacts.SurveyInteractionsRequestBodyKt;
import com.survicate.surveys.infrastructure.network.contacts.UserAttributesRequestBodyKt;
import com.survicate.surveys.infrastructure.network.contacts.UserEventsRequestBodyKt;
import com.survicate.surveys.infrastructure.network.contacts.UserVerificationRequestBodyKt;
import com.survicate.surveys.infrastructure.storage.interfaces.RespondentProvider;
import com.survicate.surveys.targeting.ActiveEvent;
import com.survicate.surveys.targeting.provider.UserTraitsProvider;
import com.survicate.surveys.traits.UserTrait;
import com.survicate.surveys.utils.AppState;
import com.survicate.surveys.utils.AppStateProvider;
import com.survicate.surveys.utils.TimestampProvider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.apache.http.HttpStatus;

/* JADX INFO: compiled from: SurvicateContactsRepository.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001vB_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020-H\u0002J\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\u001b2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00104\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0002J\u001c\u00105\u001a\u00020\u001b2\u0006\u00101\u001a\u0002022\n\u00106\u001a\u000607j\u0002`8H\u0002J\u000e\u00109\u001a\b\u0012\u0004\u0012\u0002020:H\u0002J\u0010\u0010;\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0002J\u0010\u0010<\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0002J\u0010\u0010=\u001a\u00020-2\u0006\u00101\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020-2\u0006\u00101\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020-2\u0006\u00101\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020-2\u0006\u00101\u001a\u00020DH\u0002J\u0014\u0010E\u001a\u00020\u001b2\n\u00106\u001a\u000607j\u0002`8H\u0002J\u0014\u0010F\u001a\u00020\u001b2\n\u00106\u001a\u000607j\u0002`8H\u0002J$\u0010G\u001a\u00020-2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0:2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020I0:H\u0016J\u001e\u0010K\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020M2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0:H\u0002J\u0010\u0010N\u001a\u00020-2\u0006\u0010O\u001a\u00020PH\u0016J\u0018\u0010Q\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020S2\u0006\u0010L\u001a\u00020MH\u0002J\b\u0010T\u001a\u00020\u001bH\u0002J\u0010\u0010U\u001a\u00020-2\u0006\u0010V\u001a\u00020WH\u0016J\u0018\u0010X\u001a\u00020-2\u0006\u0010R\u001a\u00020S2\u0006\u0010L\u001a\u00020MH\u0002J&\u0010Y\u001a\u00020-2\u0006\u0010R\u001a\u00020S2\u0006\u0010L\u001a\u00020M2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020I0:H\u0002J&\u0010[\u001a\u00020@2\u0006\u0010R\u001a\u00020S2\u0006\u0010L\u001a\u00020M2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020I0:H\u0002J\u0010\u0010\\\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0002J \u0010]\u001a\u00020-2\u0006\u0010R\u001a\u00020S2\u0006\u0010L\u001a\u00020M2\u0006\u0010O\u001a\u00020PH\u0002J \u0010^\u001a\u00020-2\u0006\u0010R\u001a\u00020S2\u0006\u0010L\u001a\u00020M2\u0006\u0010V\u001a\u00020WH\u0002J*\u0010_\u001a\u00020`2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020b0:2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020d0:H\u0096@¢\u0006\u0002\u0010eJ\u0010\u0010f\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020MH\u0002J\u000e\u0010g\u001a\u00020-H\u0082@¢\u0006\u0002\u0010hJ\u0016\u0010i\u001a\u00020M2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020I0:H\u0002J\u0016\u0010k\u001a\u00020\u001b2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020I0:H\u0002J\b\u0010l\u001a\u00020-H\u0016J\b\u0010m\u001a\u00020-H\u0002J\b\u0010n\u001a\u00020-H\u0002J\f\u0010o\u001a\u00020p*\u000202H\u0002J\"\u0010q\u001a\u0002Hr\"\u0004\b\u0000\u0010r2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002Hr0tH\u0082\b¢\u0006\u0002\u0010uR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020$@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006w"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/contacts/SurvicateContactsRepository;", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactsRepository;", "contactsApi", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApi;", "contactStore", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactStore;", "targetingResultStore", "Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultStore;", "taskScheduler", "Lcom/survicate/surveys/core/queue/TaskScheduler;", "eventsThrottle", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactEventsThrottle;", "respondentProvider", "Lcom/survicate/surveys/infrastructure/storage/interfaces/RespondentProvider;", "userTraitsProvider", "Lcom/survicate/surveys/targeting/provider/UserTraitsProvider;", "appStateProvider", "Lcom/survicate/surveys/utils/AppStateProvider;", "timestampProvider", "Lcom/survicate/surveys/utils/TimestampProvider;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApi;Lcom/survicate/surveys/infrastructure/storage/contacts/ContactStore;Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultStore;Lcom/survicate/surveys/core/queue/TaskScheduler;Lcom/survicate/surveys/infrastructure/storage/contacts/ContactEventsThrottle;Lcom/survicate/surveys/infrastructure/storage/interfaces/RespondentProvider;Lcom/survicate/surveys/targeting/provider/UserTraitsProvider;Lcom/survicate/surveys/utils/AppStateProvider;Lcom/survicate/surveys/utils/TimestampProvider;Lcom/survicate/surveys/core/logging/SdkLogger;Lkotlinx/coroutines/CoroutineDispatcher;)V", "isBackendTargetingAllowed", "", "()Z", "value", "Lcom/survicate/surveys/infrastructure/storage/contacts/BackendTargetingState;", "backendTargetingState", "getBackendTargetingState", "()Lcom/survicate/surveys/infrastructure/storage/contacts/BackendTargetingState;", "setBackendTargetingState", "(Lcom/survicate/surveys/infrastructure/storage/contacts/BackendTargetingState;)V", "Lcom/survicate/surveys/infrastructure/storage/contacts/AuthenticationEnforcement;", "authenticationEnforcement", "getAuthenticationEnforcement", "()Lcom/survicate/surveys/infrastructure/storage/contacts/AuthenticationEnforcement;", "setAuthenticationEnforcement", "(Lcom/survicate/surveys/infrastructure/storage/contacts/AuthenticationEnforcement;)V", "lastVerificationSuccessful", "hasUserIdTrait", "init", "", "canSynchronizeActions", "syncCachedActions", "sendAction", "action", "Lcom/survicate/surveys/entities/models/ContactAction;", "canSendAction", "onSendSuccess", "onSendFailure", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "loadContactActions", "", "saveContactAction", "removeContactAction", "verifyUser", "Lcom/survicate/surveys/entities/models/ContactAction$VerifyUser;", "sendAttributes", "Lcom/survicate/surveys/entities/models/ContactAction$SetAttributes;", "sendEvents", "Lcom/survicate/surveys/entities/models/ContactAction$InvokeEvent;", "sendSurveyInteraction", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction;", "shouldNeverTryAgain", "isHttpConflict", "updateUserTraits", "updatedTraits", "Lcom/survicate/surveys/traits/UserTrait;", "savedTraits", "canEnqueueVerificationFor", "credentials", "Lcom/survicate/surveys/infrastructure/storage/contacts/SurvicateContactsRepository$Credentials;", "addEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/survicate/surveys/targeting/ActiveEvent;", "canEnqueueActionFor", "respondent", "Lcom/survicate/surveys/entities/models/Respondent;", "hasPendingVerification", "addSurveyInteraction", "interaction", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction$Interaction;", "enqueueUserVerification", "enqueueUserAttributes", "traits", "createAttributesAction", "addContactAction", "enqueueUserEvent", "enqueueSurveyInteraction", "checkBackendTargeting", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingResult;", "surveyIds", "", "audienceIds", "", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateCredentialsForTargeting", "awaitPendingActions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCredentialsFrom", "userTraits", "anyCredentialProvided", "clear", "logoutUser", "clearUserData", "toTask", "Lcom/survicate/surveys/core/queue/QueueTask;", "withStoreLock", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Credentials", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateContactsRepository implements ContactsRepository {
    private final AppStateProvider appStateProvider;
    private volatile AuthenticationEnforcement authenticationEnforcement;
    private volatile BackendTargetingState backendTargetingState;
    private final ContactStore contactStore;
    private final ContactsApi contactsApi;
    private final ContactEventsThrottle eventsThrottle;
    private final CoroutineDispatcher ioDispatcher;
    private volatile boolean lastVerificationSuccessful;
    private final SdkLogger logger;
    private final RespondentProvider respondentProvider;
    private final BackendTargetingResultStore targetingResultStore;
    private final TaskScheduler taskScheduler;
    private final TimestampProvider timestampProvider;
    private final UserTraitsProvider userTraitsProvider;

    /* JADX INFO: renamed from: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactsRepository$awaitPendingActions$1 */
    /* JADX INFO: compiled from: SurvicateContactsRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactsRepository", m1609f = "SurvicateContactsRepository.kt", m1610i = {}, m1611l = {450, 457}, m1612m = "awaitPendingActions", m1613n = {}, m1615s = {})
    static final class C84171 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C84171(Continuation<? super C84171> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SurvicateContactsRepository.this.awaitPendingActions(this);
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactsRepository$checkBackendTargeting$1 */
    /* JADX INFO: compiled from: SurvicateContactsRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactsRepository", m1609f = "SurvicateContactsRepository.kt", m1610i = {0, 0, 0}, m1611l = {HttpStatus.SC_EXPECTATION_FAILED, 429}, m1612m = "checkBackendTargeting", m1613n = {"surveyIds", "audienceIds", "credentials"}, m1615s = {"L$0", "L$1", "L$2"})
    static final class C84191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C84191(Continuation<? super C84191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SurvicateContactsRepository.this.checkBackendTargeting(null, null, this);
        }
    }

    public SurvicateContactsRepository(ContactsApi contactsApi, ContactStore contactStore, BackendTargetingResultStore targetingResultStore, TaskScheduler taskScheduler, ContactEventsThrottle eventsThrottle, RespondentProvider respondentProvider, UserTraitsProvider userTraitsProvider, AppStateProvider appStateProvider, TimestampProvider timestampProvider, SdkLogger logger, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(contactsApi, "contactsApi");
        Intrinsics.checkNotNullParameter(contactStore, "contactStore");
        Intrinsics.checkNotNullParameter(targetingResultStore, "targetingResultStore");
        Intrinsics.checkNotNullParameter(taskScheduler, "taskScheduler");
        Intrinsics.checkNotNullParameter(eventsThrottle, "eventsThrottle");
        Intrinsics.checkNotNullParameter(respondentProvider, "respondentProvider");
        Intrinsics.checkNotNullParameter(userTraitsProvider, "userTraitsProvider");
        Intrinsics.checkNotNullParameter(appStateProvider, "appStateProvider");
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.contactsApi = contactsApi;
        this.contactStore = contactStore;
        this.targetingResultStore = targetingResultStore;
        this.taskScheduler = taskScheduler;
        this.eventsThrottle = eventsThrottle;
        this.respondentProvider = respondentProvider;
        this.userTraitsProvider = userTraitsProvider;
        this.appStateProvider = appStateProvider;
        this.timestampProvider = timestampProvider;
        this.logger = logger;
        this.ioDispatcher = ioDispatcher;
        this.backendTargetingState = BackendTargetingState.UNKNOWN;
        this.authenticationEnforcement = AuthenticationEnforcement.UNKNOWN;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    /* JADX INFO: renamed from: isBackendTargetingAllowed */
    public boolean getIsBackendTargetingAllowed() {
        return (getBackendTargetingState() == BackendTargetingState.ENABLED) && (this.respondentProvider.provideRespondent().isVerified() || (getAuthenticationEnforcement() == AuthenticationEnforcement.OPTIONAL && hasUserIdTrait()));
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public BackendTargetingState getBackendTargetingState() {
        return this.backendTargetingState;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public void setBackendTargetingState(BackendTargetingState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.backendTargetingState = value;
        this.taskScheduler.setEnabled(canSynchronizeActions());
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public AuthenticationEnforcement getAuthenticationEnforcement() {
        return this.authenticationEnforcement;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public void setAuthenticationEnforcement(AuthenticationEnforcement value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.authenticationEnforcement = value;
        this.taskScheduler.setEnabled(canSynchronizeActions());
    }

    private final boolean hasUserIdTrait() {
        return getCredentialsFrom(this.userTraitsProvider.provideUserTraits()).getUserId().length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$0(SurvicateContactsRepository survicateContactsRepository, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        survicateContactsRepository.logger.info(LogTags.CONTACTS, message);
        return Unit.INSTANCE;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public void init() {
        this.taskScheduler.setOnLogMessage(new Function1() { // from class: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactsRepository$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurvicateContactsRepository.init$lambda$0(this.f$0, (String) obj);
            }
        });
        this.taskScheduler.setEnabled(canSynchronizeActions());
        Observable<AppState> observableObserveAppStateChanges = this.appStateProvider.observeAppStateChanges();
        final Function1 function1 = new Function1() { // from class: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactsRepository$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurvicateContactsRepository.init$lambda$1(this.f$0, (AppState) obj);
            }
        };
        observableObserveAppStateChanges.addObserver(new Observable.Observer() { // from class: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactsRepository$$ExternalSyntheticLambda3
            @Override // com.survicate.surveys.helpers.Observable.Observer
            public final void update(Object obj) {
                function1.invoke(obj);
            }
        });
        this.eventsThrottle.setOnEventThrottled(new Function1() { // from class: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactsRepository$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurvicateContactsRepository.init$lambda$3(this.f$0, (ContactAction.InvokeEvent) obj);
            }
        });
        this.lastVerificationSuccessful = this.respondentProvider.provideRespondent().isVerified();
        syncCachedActions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$1(SurvicateContactsRepository survicateContactsRepository, AppState appState) {
        survicateContactsRepository.taskScheduler.setEnabled(survicateContactsRepository.canSynchronizeActions());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$3(SurvicateContactsRepository survicateContactsRepository, ContactAction.InvokeEvent eventAction) {
        Intrinsics.checkNotNullParameter(eventAction, "eventAction");
        survicateContactsRepository.taskScheduler.schedule(survicateContactsRepository.toTask(eventAction));
        return Unit.INSTANCE;
    }

    private final boolean canSynchronizeActions() {
        AppState currentState = this.appStateProvider.getCurrentState();
        return currentState.isNetworkAvailable() && currentState.isInForeground() && getBackendTargetingState() != BackendTargetingState.UNKNOWN && getAuthenticationEnforcement() != AuthenticationEnforcement.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean sendAction(ContactAction action) {
        if (getBackendTargetingState() == BackendTargetingState.UNKNOWN || getAuthenticationEnforcement() == AuthenticationEnforcement.UNKNOWN) {
            return false;
        }
        if (!canSendAction(action)) {
            removeContactAction(action);
            return true;
        }
        try {
            if (action instanceof ContactAction.VerifyUser) {
                verifyUser((ContactAction.VerifyUser) action);
            } else if (action instanceof ContactAction.SetAttributes) {
                sendAttributes((ContactAction.SetAttributes) action);
            } else if (action instanceof ContactAction.InvokeEvent) {
                sendEvents((ContactAction.InvokeEvent) action);
            } else {
                if (!(action instanceof ContactAction.SurveyInteraction)) {
                    throw new NoWhenBranchMatchedException();
                }
                sendSurveyInteraction((ContactAction.SurveyInteraction) action);
            }
            onSendSuccess(action);
            return true;
        } catch (Exception e) {
            return onSendFailure(action, e);
        }
    }

    private final boolean canSendAction(ContactAction action) {
        if (getBackendTargetingState() != BackendTargetingState.ENABLED) {
            return false;
        }
        return getAuthenticationEnforcement() == AuthenticationEnforcement.OPTIONAL || (action instanceof ContactAction.VerifyUser) || this.respondentProvider.provideRespondent().isVerified() || this.lastVerificationSuccessful;
    }

    private final void onSendSuccess(ContactAction action) {
        removeContactAction(action);
    }

    private final boolean onSendFailure(ContactAction action, Exception exception) {
        this.logger.error(LogTags.CONTACTS, "Failed to process " + action.getClass().getSimpleName() + " action", exception);
        if (isHttpConflict(exception)) {
            this.logger.info(LogTags.CONTACTS, "Received HTTP 409 Conflict, logging out user");
            logoutUser();
        }
        if (!shouldNeverTryAgain(exception)) {
            return false;
        }
        removeContactAction(action);
        if (!(action instanceof ContactAction.VerifyUser)) {
            return true;
        }
        this.lastVerificationSuccessful = false;
        return true;
    }

    private final void verifyUser(ContactAction.VerifyUser action) throws IOException {
        this.logger.info(LogTags.CONTACTS, "User verification started");
        this.contactsApi.verifyUser(UserVerificationRequestBodyKt.toRequestBody(action));
        synchronized (this.contactStore) {
            this.contactStore.saveRespondentVerificationTime(this.timestampProvider.currentTimeMillis());
            Unit unit = Unit.INSTANCE;
        }
        this.lastVerificationSuccessful = true;
        this.logger.info(LogTags.CONTACTS, "User verification success");
    }

    private final void sendAttributes(ContactAction.SetAttributes action) throws IOException {
        this.logger.info(LogTags.CONTACTS, "Sending attributes");
        this.contactsApi.sendUserAttributes(UserAttributesRequestBodyKt.toRequestBody(action));
        this.logger.info(LogTags.CONTACTS, "Attributes sent successfully");
    }

    private final void sendEvents(ContactAction.InvokeEvent action) throws IOException {
        this.logger.info(LogTags.CONTACTS, "Sending events");
        this.contactsApi.sendUserEvents(UserEventsRequestBodyKt.toRequestBody(action));
        this.logger.info(LogTags.CONTACTS, "Events sent successfully");
    }

    private final void sendSurveyInteraction(ContactAction.SurveyInteraction action) throws IOException {
        this.logger.info(LogTags.CONTACTS, "Sending survey interaction");
        this.contactsApi.sendSurveyInteractions(SurveyInteractionsRequestBodyKt.toRequestBody(action));
        this.logger.info(LogTags.CONTACTS, "Survey interaction sent successfully");
    }

    private final boolean shouldNeverTryAgain(Exception exception) {
        return (exception instanceof HttpException) && !HttpExceptionKt.canRetry((HttpException) exception);
    }

    private final boolean isHttpConflict(Exception exception) {
        return (exception instanceof HttpException) && ((HttpException) exception).getResponseCode() == 409;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public void updateUserTraits(List<? extends UserTrait> updatedTraits, List<? extends UserTrait> savedTraits) {
        Intrinsics.checkNotNullParameter(updatedTraits, "updatedTraits");
        Intrinsics.checkNotNullParameter(savedTraits, "savedTraits");
        if (LogoutUtils.INSTANCE.shouldLogout(updatedTraits, savedTraits)) {
            logoutUser();
        }
        if (LogoutUtils.INSTANCE.shouldClearUserData(updatedTraits, savedTraits)) {
            clearUserData();
            savedTraits = CollectionsKt.emptyList();
        }
        Credentials credentialsFrom = getCredentialsFrom(UserTraitUtilsKt.updatedWith(savedTraits, updatedTraits));
        if (canEnqueueVerificationFor(credentialsFrom, updatedTraits)) {
            enqueueUserVerification(this.respondentProvider.provideRespondent(), credentialsFrom);
        }
        Respondent respondentProvideRespondent = this.respondentProvider.provideRespondent();
        List<UserTrait> listWithoutCredentials = UserTraitUtilsKt.withoutCredentials(updatedTraits);
        if (listWithoutCredentials.isEmpty() || !canEnqueueActionFor(respondentProvideRespondent, credentialsFrom)) {
            return;
        }
        enqueueUserAttributes(respondentProvideRespondent, credentialsFrom, listWithoutCredentials);
    }

    private final boolean canEnqueueVerificationFor(Credentials credentials, List<? extends UserTrait> updatedTraits) {
        return getBackendTargetingState() != BackendTargetingState.DISABLED && anyCredentialProvided(updatedTraits) && credentials.getUserId().length() > 0 && credentials.getUserKey().length() > 0;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public void addEvent(ActiveEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Respondent respondentProvideRespondent = this.respondentProvider.provideRespondent();
        Credentials credentialsFrom = getCredentialsFrom(this.userTraitsProvider.provideUserTraits());
        if (canEnqueueActionFor(respondentProvideRespondent, credentialsFrom)) {
            enqueueUserEvent(respondentProvideRespondent, credentialsFrom, event);
        }
    }

    private final boolean canEnqueueActionFor(Respondent respondent, Credentials credentials) {
        if (getBackendTargetingState() == BackendTargetingState.DISABLED) {
            return false;
        }
        return getAuthenticationEnforcement() == AuthenticationEnforcement.REQUIRED ? credentials.getUserId().length() > 0 && credentials.getUserKey().length() > 0 && (respondent.isVerified() || hasPendingVerification()) : credentials.getUserId().length() > 0;
    }

    private final boolean hasPendingVerification() {
        List<ContactAction> listLoadContactActions = loadContactActions();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listLoadContactActions) {
            if (obj instanceof ContactAction.VerifyUser) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.any(arrayList);
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public void addSurveyInteraction(ContactAction.SurveyInteraction.Interaction interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Respondent respondentProvideRespondent = this.respondentProvider.provideRespondent();
        Credentials credentialsFrom = getCredentialsFrom(this.userTraitsProvider.provideUserTraits());
        if (canEnqueueActionFor(respondentProvideRespondent, credentialsFrom)) {
            enqueueSurveyInteraction(respondentProvideRespondent, credentialsFrom, interaction);
        }
    }

    private final void enqueueUserVerification(Respondent respondent, Credentials credentials) {
        addContactAction(new ContactAction.VerifyUser(credentials.getUserId(), credentials.getUserKey(), respondent.getUuid()));
    }

    private final void enqueueUserAttributes(final Respondent respondent, final Credentials credentials, List<? extends UserTrait> traits) {
        if (traits.size() <= 100) {
            addContactAction(createAttributesAction(respondent, credentials, traits));
            return;
        }
        Iterator it = SequencesKt.map(SequencesKt.chunked(CollectionsKt.asSequence(traits), 100), new Function1() { // from class: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactsRepository$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurvicateContactsRepository.enqueueUserAttributes$lambda$10(this.f$0, respondent, credentials, (List) obj);
            }
        }).iterator();
        while (it.hasNext()) {
            addContactAction((ContactAction) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContactAction.SetAttributes enqueueUserAttributes$lambda$10(SurvicateContactsRepository survicateContactsRepository, Respondent respondent, Credentials credentials, List traitsChunk) {
        Intrinsics.checkNotNullParameter(traitsChunk, "traitsChunk");
        return survicateContactsRepository.createAttributesAction(respondent, credentials, traitsChunk);
    }

    private final ContactAction.SetAttributes createAttributesAction(Respondent respondent, Credentials credentials, List<? extends UserTrait> traits) {
        String userId = credentials.getUserId();
        String userKey = credentials.getUserKey();
        String uuid = respondent.getUuid();
        List<? extends UserTrait> list = traits;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (UserTrait userTrait : list) {
            arrayList.add(new ContactAction.SetAttributes.Attribute(userTrait.key, userTrait.value, userTrait.getTimestampMs()));
        }
        return new ContactAction.SetAttributes(userId, userKey, uuid, arrayList);
    }

    private final void addContactAction(ContactAction action) {
        saveContactAction(action);
        this.taskScheduler.schedule(toTask(action));
    }

    private final void enqueueUserEvent(Respondent respondent, Credentials credentials, ActiveEvent event) {
        this.eventsThrottle.enqueue(new ContactAction.InvokeEvent(credentials.getUserId(), credentials.getUserKey(), respondent.getUuid(), CollectionsKt.listOf(new ContactAction.InvokeEvent.Event(event.getName(), event.getInvokeTimeMs())), false));
    }

    private final void enqueueSurveyInteraction(Respondent respondent, Credentials credentials, ContactAction.SurveyInteraction.Interaction interaction) {
        addContactAction(new ContactAction.SurveyInteraction(credentials.getUserId(), credentials.getUserKey(), respondent.getUuid(), CollectionsKt.listOf(interaction)));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object checkBackendTargeting(List<String> list, List<Long> list2, Continuation<? super BackendTargetingResult> continuation) {
        C84191 c84191;
        Credentials credentialsFrom;
        if (continuation instanceof C84191) {
            c84191 = (C84191) continuation;
            if ((c84191.label & Integer.MIN_VALUE) != 0) {
                c84191.label -= Integer.MIN_VALUE;
            } else {
                c84191 = new C84191(continuation);
            }
        }
        Object obj = c84191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c84191.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            credentialsFrom = getCredentialsFrom(this.userTraitsProvider.provideUserTraits());
            if (!validateCredentialsForTargeting(credentialsFrom)) {
                throw new IllegalStateException("Invalid credentials".toString());
            }
            if (!loadContactActions().isEmpty()) {
                c84191.L$0 = list;
                c84191.L$1 = list2;
                c84191.L$2 = credentialsFrom;
                c84191.label = 1;
                if (awaitPendingActions(c84191) != coroutine_suspended) {
                }
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        Credentials credentials = (Credentials) c84191.L$2;
        list2 = (List) c84191.L$1;
        List<String> list3 = (List) c84191.L$0;
        ResultKt.throwOnFailure(obj);
        credentialsFrom = credentials;
        list = list3;
        BackendTargetingRequestBody backendTargetingRequestBody = new BackendTargetingRequestBody(new ContactsApiModels.User(credentialsFrom.getUserId(), credentialsFrom.getUserKey()), new ContactsApiModels.Respondent(this.respondentProvider.provideRespondent().getUuid()), list, list2);
        CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
        C84203 c84203 = new C84203(backendTargetingRequestBody, null);
        c84191.L$0 = null;
        c84191.L$1 = null;
        c84191.L$2 = null;
        c84191.label = 2;
        Object objWithContext = BuildersKt.withContext(coroutineDispatcher, c84203, c84191);
        return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
    }

    /* JADX INFO: renamed from: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactsRepository$checkBackendTargeting$3 */
    /* JADX INFO: compiled from: SurvicateContactsRepository.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactsRepository$checkBackendTargeting$3", m1609f = "SurvicateContactsRepository.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84203 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BackendTargetingResult>, Object> {
        final /* synthetic */ BackendTargetingRequestBody $requestBody;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C84203(BackendTargetingRequestBody backendTargetingRequestBody, Continuation<? super C84203> continuation) {
            super(2, continuation);
            this.$requestBody = backendTargetingRequestBody;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SurvicateContactsRepository.this.new C84203(this.$requestBody, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BackendTargetingResult> continuation) {
            return ((C84203) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return SurvicateContactsRepository.this.contactsApi.checkBackendTargeting(this.$requestBody);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final boolean validateCredentialsForTargeting(Credentials credentials) {
        return getAuthenticationEnforcement() == AuthenticationEnforcement.REQUIRED ? credentials.getUserId().length() > 0 && credentials.getUserKey().length() > 0 : credentials.getUserId().length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
    
        if (r7.await(r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitPendingActions(Continuation<? super Unit> continuation) {
        C84171 c84171;
        if (continuation instanceof C84171) {
            c84171 = (C84171) continuation;
            if ((c84171.label & Integer.MIN_VALUE) != 0) {
                c84171.label -= Integer.MIN_VALUE;
            } else {
                c84171 = new C84171(continuation);
            }
        }
        Object obj = c84171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c84171.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.logger.info(LogTags.CONTACTS, "Delaying backend targeting until pending actions are sent");
            ContactEventsThrottle contactEventsThrottle = this.eventsThrottle;
            c84171.label = 1;
            if (contactEventsThrottle.awaitNextFlush(c84171) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.taskScheduler.schedule(new QueueTask() { // from class: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactsRepository.awaitPendingActions.2
            @Override // com.survicate.surveys.core.queue.QueueTask
            public final Object run(Continuation<? super Boolean> continuation2) {
                return Boxing.boxBoolean(completableDeferredCompletableDeferred$default.complete(Unit.INSTANCE));
            }
        });
        c84171.label = 2;
    }

    private final Credentials getCredentialsFrom(List<? extends UserTrait> userTraits) {
        UserTrait userTraitFindUserIdTrait = UserTraitUtilsKt.findUserIdTrait(userTraits);
        String str = userTraitFindUserIdTrait != null ? userTraitFindUserIdTrait.value : null;
        if (str == null) {
            str = "";
        }
        UserTrait userTraitFindUserKeyTrait = UserTraitUtilsKt.findUserKeyTrait(userTraits);
        String str2 = userTraitFindUserKeyTrait != null ? userTraitFindUserKeyTrait.value : null;
        return new Credentials(str, str2 != null ? str2 : "");
    }

    private final boolean anyCredentialProvided(List<? extends UserTrait> traits) {
        Credentials credentialsFrom = getCredentialsFrom(traits);
        return credentialsFrom.getUserId().length() > 0 || credentialsFrom.getUserKey().length() > 0;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository
    public void clear() {
        this.taskScheduler.clear();
        logoutUser();
        clearUserData();
    }

    private final QueueTask toTask(final ContactAction contactAction) {
        return new QueueTask() { // from class: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactsRepository.toTask.1
            @Override // com.survicate.surveys.core.queue.QueueTask
            public final Object run(Continuation<? super Boolean> continuation) {
                return Boxing.boxBoolean(SurvicateContactsRepository.this.sendAction(contactAction));
            }
        };
    }

    private final <T> T withStoreLock(Function0<? extends T> block) {
        T tInvoke;
        synchronized (this.contactStore) {
            tInvoke = block.invoke();
        }
        return tInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SurvicateContactsRepository.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/contacts/SurvicateContactsRepository$Credentials;", "", "userId", "", "userKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getUserKey", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    static final /* data */ class Credentials {
        private final String userId;
        private final String userKey;

        public static /* synthetic */ Credentials copy$default(Credentials credentials, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = credentials.userId;
            }
            if ((i & 2) != 0) {
                str2 = credentials.userKey;
            }
            return credentials.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUserKey() {
            return this.userKey;
        }

        public final Credentials copy(String userId, String userKey) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(userKey, "userKey");
            return new Credentials(userId, userKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Credentials)) {
                return false;
            }
            Credentials credentials = (Credentials) other;
            return Intrinsics.areEqual(this.userId, credentials.userId) && Intrinsics.areEqual(this.userKey, credentials.userKey);
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.userKey.hashCode();
        }

        public String toString() {
            return "Credentials(userId=" + this.userId + ", userKey=" + this.userKey + ')';
        }

        public Credentials(String userId, String userKey) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(userKey, "userKey");
            this.userId = userId;
            this.userKey = userKey;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final String getUserKey() {
            return this.userKey;
        }
    }

    private final void syncCachedActions() {
        List<ContactAction> listLoadContactActions;
        synchronized (this.contactStore) {
            ContactEventsThrottleKt.markEventsAsScheduled(this.contactStore);
            listLoadContactActions = this.contactStore.loadContactActions();
        }
        List<ContactAction> list = listLoadContactActions;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toTask((ContactAction) it.next()));
        }
        this.taskScheduler.schedule(arrayList);
    }

    private final List<ContactAction> loadContactActions() {
        List<ContactAction> listLoadContactActions;
        synchronized (this.contactStore) {
            listLoadContactActions = this.contactStore.loadContactActions();
        }
        return listLoadContactActions;
    }

    private final void saveContactAction(ContactAction action) {
        synchronized (this.contactStore) {
            this.contactStore.saveContactAction(action);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void removeContactAction(ContactAction action) {
        synchronized (this.contactStore) {
            this.contactStore.removeContactAction(action);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void logoutUser() {
        synchronized (this.contactStore) {
            this.contactStore.clearRespondentVerificationTime();
            Unit unit = Unit.INSTANCE;
        }
        this.logger.info(LogTags.CONTACTS, "User logged out");
    }

    private final void clearUserData() {
        synchronized (this.contactStore) {
            this.contactStore.clearUserData();
            this.targetingResultStore.clear();
            Unit unit = Unit.INSTANCE;
        }
        this.logger.info(LogTags.CONTACTS, "User data cleared");
    }
}
