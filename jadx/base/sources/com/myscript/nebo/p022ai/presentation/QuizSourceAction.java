package com.myscript.nebo.p022ai.presentation;

import com.myscript.nebo.p022ai.C6091R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AIQuizViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\n\u000b\fB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u0082\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/QuizSourceAction;", "", "drawableResId", "", "labelResId", "<init>", "(II)V", "getDrawableResId", "()I", "getLabelResId", "CurrentPage", "AllPages", "ChoosePages", "Lcom/myscript/nebo/ai/presentation/QuizSourceAction$AllPages;", "Lcom/myscript/nebo/ai/presentation/QuizSourceAction$ChoosePages;", "Lcom/myscript/nebo/ai/presentation/QuizSourceAction$CurrentPage;", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class QuizSourceAction {
    public static final int $stable = 0;
    private final int drawableResId;
    private final int labelResId;

    public /* synthetic */ QuizSourceAction(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    private QuizSourceAction(int i, int i2) {
        this.drawableResId = i;
        this.labelResId = i2;
    }

    public final int getDrawableResId() {
        return this.drawableResId;
    }

    public final int getLabelResId() {
        return this.labelResId;
    }

    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/QuizSourceAction$CurrentPage;", "Lcom/myscript/nebo/ai/presentation/QuizSourceAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class CurrentPage extends QuizSourceAction {
        public static final int $stable = 0;
        public static final CurrentPage INSTANCE = new CurrentPage();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CurrentPage)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1988433966;
        }

        public String toString() {
            return "CurrentPage";
        }

        private CurrentPage() {
            super(C6091R.drawable.ic_page, C6091R.string.ai_select_notes_current_page, null);
        }
    }

    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/QuizSourceAction$AllPages;", "Lcom/myscript/nebo/ai/presentation/QuizSourceAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class AllPages extends QuizSourceAction {
        public static final int $stable = 0;
        public static final AllPages INSTANCE = new AllPages();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AllPages)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -79644707;
        }

        public String toString() {
            return "AllPages";
        }

        private AllPages() {
            super(C6091R.drawable.ic_pages, C6091R.string.ai_select_notes_all_pages, null);
        }
    }

    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/QuizSourceAction$ChoosePages;", "Lcom/myscript/nebo/ai/presentation/QuizSourceAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ChoosePages extends QuizSourceAction {
        public static final int $stable = 0;
        public static final ChoosePages INSTANCE = new ChoosePages();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChoosePages)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -308172685;
        }

        public String toString() {
            return "ChoosePages";
        }

        private ChoosePages() {
            super(C6091R.drawable.ic_grid, C6091R.string.ai_select_notes_select_pages, null);
        }
    }
}
