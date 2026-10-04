package com.survicate.surveys.presentation.page;

import com.survicate.surveys.entities.models.QuestionValidationState;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.presentation.widget.SubmitViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageItem.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/PageItem;", "", "Question", "Submit", "Disclaimer", "Footer", "Lcom/survicate/surveys/presentation/page/PageItem$Disclaimer;", "Lcom/survicate/surveys/presentation/page/PageItem$Footer;", "Lcom/survicate/surveys/presentation/page/PageItem$Question;", "Lcom/survicate/surveys/presentation/page/PageItem$Submit;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface PageItem {

    /* JADX INFO: compiled from: PageItem.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/PageItem$Question;", "Lcom/survicate/surveys/presentation/page/PageItem;", "viewModel", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "<init>", "(Lcom/survicate/surveys/presentation/page/QuestionViewModel;)V", "getViewModel", "()Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Question implements PageItem {
        private final QuestionViewModel viewModel;

        public static /* synthetic */ Question copy$default(Question question, QuestionViewModel questionViewModel, int i, Object obj) {
            if ((i & 1) != 0) {
                questionViewModel = question.viewModel;
            }
            return question.copy(questionViewModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final QuestionViewModel getViewModel() {
            return this.viewModel;
        }

        public final Question copy(QuestionViewModel viewModel) {
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
            return new Question(viewModel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Question) && Intrinsics.areEqual(this.viewModel, ((Question) other).viewModel);
        }

        public int hashCode() {
            return this.viewModel.hashCode();
        }

        public String toString() {
            return "Question(viewModel=" + this.viewModel + ')';
        }

        public Question(QuestionViewModel viewModel) {
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
            this.viewModel = viewModel;
        }

        public final QuestionViewModel getViewModel() {
            return this.viewModel;
        }
    }

    /* JADX INFO: compiled from: PageItem.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/PageItem$Submit;", "Lcom/survicate/surveys/presentation/page/PageItem;", "config", "Lcom/survicate/surveys/presentation/widget/SubmitViewConfiguration;", "validationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "<init>", "(Lcom/survicate/surveys/presentation/widget/SubmitViewConfiguration;Lcom/survicate/surveys/entities/models/QuestionValidationState;)V", "getConfig", "()Lcom/survicate/surveys/presentation/widget/SubmitViewConfiguration;", "getValidationState", "()Lcom/survicate/surveys/entities/models/QuestionValidationState;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Submit implements PageItem {
        private final SubmitViewConfiguration config;
        private final QuestionValidationState validationState;

        public static /* synthetic */ Submit copy$default(Submit submit, SubmitViewConfiguration submitViewConfiguration, QuestionValidationState questionValidationState, int i, Object obj) {
            if ((i & 1) != 0) {
                submitViewConfiguration = submit.config;
            }
            if ((i & 2) != 0) {
                questionValidationState = submit.validationState;
            }
            return submit.copy(submitViewConfiguration, questionValidationState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SubmitViewConfiguration getConfig() {
            return this.config;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final QuestionValidationState getValidationState() {
            return this.validationState;
        }

        public final Submit copy(SubmitViewConfiguration config, QuestionValidationState validationState) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(validationState, "validationState");
            return new Submit(config, validationState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Submit)) {
                return false;
            }
            Submit submit = (Submit) other;
            return Intrinsics.areEqual(this.config, submit.config) && Intrinsics.areEqual(this.validationState, submit.validationState);
        }

        public int hashCode() {
            return (this.config.hashCode() * 31) + this.validationState.hashCode();
        }

        public String toString() {
            return "Submit(config=" + this.config + ", validationState=" + this.validationState + ')';
        }

        public Submit(SubmitViewConfiguration config, QuestionValidationState validationState) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(validationState, "validationState");
            this.config = config;
            this.validationState = validationState;
        }

        public final SubmitViewConfiguration getConfig() {
            return this.config;
        }

        public final QuestionValidationState getValidationState() {
            return this.validationState;
        }
    }

    /* JADX INFO: compiled from: PageItem.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/PageItem$Disclaimer;", "Lcom/survicate/surveys/presentation/page/PageItem;", "settings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "accepted", "", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Z)V", "getSettings", "()Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "getAccepted", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Disclaimer implements PageItem {
        private final boolean accepted;
        private final DisclaimerSettings settings;

        public static /* synthetic */ Disclaimer copy$default(Disclaimer disclaimer, DisclaimerSettings disclaimerSettings, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                disclaimerSettings = disclaimer.settings;
            }
            if ((i & 2) != 0) {
                z = disclaimer.accepted;
            }
            return disclaimer.copy(disclaimerSettings, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DisclaimerSettings getSettings() {
            return this.settings;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getAccepted() {
            return this.accepted;
        }

        public final Disclaimer copy(DisclaimerSettings settings, boolean accepted) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            return new Disclaimer(settings, accepted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Disclaimer)) {
                return false;
            }
            Disclaimer disclaimer = (Disclaimer) other;
            return Intrinsics.areEqual(this.settings, disclaimer.settings) && this.accepted == disclaimer.accepted;
        }

        public int hashCode() {
            return (this.settings.hashCode() * 31) + Boolean.hashCode(this.accepted);
        }

        public String toString() {
            return "Disclaimer(settings=" + this.settings + ", accepted=" + this.accepted + ')';
        }

        public Disclaimer(DisclaimerSettings settings, boolean z) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            this.settings = settings;
            this.accepted = z;
        }

        public final DisclaimerSettings getSettings() {
            return this.settings;
        }

        public final boolean getAccepted() {
            return this.accepted;
        }
    }

    /* JADX INFO: compiled from: PageItem.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/PageItem$Footer;", "Lcom/survicate/surveys/presentation/page/PageItem;", "<init>", "()V", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Footer implements PageItem {
        public static final Footer INSTANCE = new Footer();

        private Footer() {
        }
    }
}
