package com.survicate.surveys;

import com.survicate.surveys.infrastructure.storage.interfaces.QuestionAnswerItem;
import com.survicate.surveys.infrastructure.storage.interfaces.SurveyAnswersStore;
import com.survicate.surveys.traits.UserTrait;
import com.survicate.surveys.utils.DateUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TextRecallingManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"Lcom/survicate/surveys/TextRecallingManager;", "", "persistenceManager", "Lcom/survicate/surveys/PersistenceManager;", "answersStore", "Lcom/survicate/surveys/infrastructure/storage/interfaces/SurveyAnswersStore;", "<init>", "(Lcom/survicate/surveys/PersistenceManager;Lcom/survicate/surveys/infrastructure/storage/interfaces/SurveyAnswersStore;)V", "replaceTags", "", "input", "replaceTag", "result", "Lkotlin/text/MatchResult;", "recallingTag", "Lcom/survicate/surveys/RecallingTag;", "getFormattedTraitValue", "traitValue", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TextRecallingManager {

    @Deprecated
    public static final String ANSWER_SEPARATOR = ", ";

    @Deprecated
    public static final int ATTRIBUTE_GROUP = 1;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int FALLBACK_GROUP = 2;
    private final SurveyAnswersStore answersStore;
    private final PersistenceManager persistenceManager;

    /* JADX INFO: compiled from: TextRecallingManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecallingTag.values().length];
            try {
                iArr[RecallingTag.VISITOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecallingTag.ANSWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TextRecallingManager(PersistenceManager persistenceManager, SurveyAnswersStore answersStore) {
        Intrinsics.checkNotNullParameter(persistenceManager, "persistenceManager");
        Intrinsics.checkNotNullParameter(answersStore, "answersStore");
        this.persistenceManager = persistenceManager;
        this.answersStore = answersStore;
    }

    public final String replaceTags(String input) {
        String str = input;
        if (str != null && !StringsKt.isBlank(str)) {
            for (final RecallingTag recallingTag : RecallingTag.values()) {
                input = recallingTag.getRegex().replace(input, new Function1() { // from class: com.survicate.surveys.TextRecallingManager$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextRecallingManager.replaceTags$lambda$1$lambda$0(this.f$0, recallingTag, (MatchResult) obj);
                    }
                });
            }
        }
        return input;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence replaceTags$lambda$1$lambda$0(TextRecallingManager textRecallingManager, RecallingTag recallingTag, MatchResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return textRecallingManager.replaceTag(result, recallingTag);
    }

    private final String replaceTag(MatchResult result, RecallingTag recallingTag) {
        String value;
        String value2;
        String str;
        List<String> answerTextValue;
        MatchGroup matchGroup = result.getGroups().get(2);
        if (matchGroup == null || (value = matchGroup.getValue()) == null) {
            value = "";
        }
        MatchGroup matchGroup2 = result.getGroups().get(1);
        if (matchGroup2 != null && (value2 = matchGroup2.getValue()) != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[recallingTag.ordinal()];
            if (i == 1) {
                UserTrait userTraitFindUserTrait = this.persistenceManager.findUserTrait(value2);
                if (userTraitFindUserTrait != null && (str = userTraitFindUserTrait.value) != null && !StringsKt.isBlank(str)) {
                    str = str;
                }
                if (str != null) {
                    return getFormattedTraitValue(str);
                }
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                QuestionAnswerItem questionAnswerItemFindAnswerBy = this.answersStore.findAnswerBy(Long.parseLong(value2));
                String strJoinToString$default = (questionAnswerItemFindAnswerBy == null || (answerTextValue = questionAnswerItemFindAnswerBy.getAnswerTextValue()) == null) ? null : CollectionsKt.joinToString$default(answerTextValue, ANSWER_SEPARATOR, null, null, 0, null, null, 62, null);
                if (strJoinToString$default != null) {
                    str = StringsKt.isBlank(strJoinToString$default) ? null : strJoinToString$default;
                    if (str != null) {
                        return str;
                    }
                }
            }
        }
        return value;
    }

    private final String getFormattedTraitValue(String traitValue) {
        String dateOnlyPart$survicate_sdk_release;
        return (!DateUtils.INSTANCE.isZonedDateTimeIsoString$survicate_sdk_release(traitValue) || (dateOnlyPart$survicate_sdk_release = DateUtils.INSTANCE.getDateOnlyPart$survicate_sdk_release(traitValue)) == null) ? traitValue : dateOnlyPart$survicate_sdk_release;
    }

    /* JADX INFO: compiled from: TextRecallingManager.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/TextRecallingManager$Companion;", "", "<init>", "()V", "ATTRIBUTE_GROUP", "", "FALLBACK_GROUP", "ANSWER_SEPARATOR", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
