package com.survicate.surveys.entities.survey.theme;

import kotlin.Metadata;

/* JADX INFO: compiled from: ColorScheme.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "", "question", "", "answer", "button", "background", "progressBar", "<init>", "(IIIII)V", "getQuestion", "()I", "getAnswer", "getButton", "getBackground", "getProgressBar", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class ColorScheme {
    private final int answer;
    private final int background;
    private final int button;
    private final int progressBar;
    private final int question;

    public static /* synthetic */ ColorScheme copy$default(ColorScheme colorScheme, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = colorScheme.question;
        }
        if ((i6 & 2) != 0) {
            i2 = colorScheme.answer;
        }
        if ((i6 & 4) != 0) {
            i3 = colorScheme.button;
        }
        if ((i6 & 8) != 0) {
            i4 = colorScheme.background;
        }
        if ((i6 & 16) != 0) {
            i5 = colorScheme.progressBar;
        }
        int i7 = i5;
        int i8 = i3;
        return colorScheme.copy(i, i2, i8, i4, i7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getQuestion() {
        return this.question;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAnswer() {
        return this.answer;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getButton() {
        return this.button;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBackground() {
        return this.background;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getProgressBar() {
        return this.progressBar;
    }

    public final ColorScheme copy(int question, int answer, int button, int background, int progressBar) {
        return new ColorScheme(question, answer, button, background, progressBar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorScheme)) {
            return false;
        }
        ColorScheme colorScheme = (ColorScheme) other;
        return this.question == colorScheme.question && this.answer == colorScheme.answer && this.button == colorScheme.button && this.background == colorScheme.background && this.progressBar == colorScheme.progressBar;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.question) * 31) + Integer.hashCode(this.answer)) * 31) + Integer.hashCode(this.button)) * 31) + Integer.hashCode(this.background)) * 31) + Integer.hashCode(this.progressBar);
    }

    public String toString() {
        return "ColorScheme(question=" + this.question + ", answer=" + this.answer + ", button=" + this.button + ", background=" + this.background + ", progressBar=" + this.progressBar + ')';
    }

    public ColorScheme(int i, int i2, int i3, int i4, int i5) {
        this.question = i;
        this.answer = i2;
        this.button = i3;
        this.background = i4;
        this.progressBar = i5;
    }

    public final int getQuestion() {
        return this.question;
    }

    public final int getAnswer() {
        return this.answer;
    }

    public final int getButton() {
        return this.button;
    }

    public final int getBackground() {
        return this.background;
    }

    public final int getProgressBar() {
        return this.progressBar;
    }
}
