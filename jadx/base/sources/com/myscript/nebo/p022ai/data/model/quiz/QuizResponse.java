package com.myscript.nebo.p022ai.data.model.quiz;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuizResponse.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009f\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u000204HÖ\u0081\u0004J\n\u00105\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00066"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/model/quiz/QuizResponse;", "", "type", "", "lang", "noteId", "noteLang", "pageId", "stem", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "c", "options", "", "correctAnswer", "explanation", "contentRef", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getLang", "getNoteId", "getNoteLang", "getPageId", "getStem", "getA", "getB", "getC", "getOptions", "()Ljava/util/List;", "getCorrectAnswer", "getExplanation", "getContentRef", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class QuizResponse {
    public static final int $stable = 8;

    @SerializedName(CmcdData.OBJECT_TYPE_AUDIO_ONLY)
    private final String a;

    @SerializedName("b")
    private final String b;

    @SerializedName("c")
    private final String c;

    @SerializedName("content_ref")
    private final String contentRef;

    @SerializedName("correct_answer")
    private final String correctAnswer;

    @SerializedName("explanation")
    private final String explanation;

    @SerializedName("lang")
    private final String lang;

    @SerializedName("noted_id")
    private final String noteId;

    @SerializedName("note_lang")
    private final String noteLang;

    @SerializedName("options")
    private final List<String> options;

    @SerializedName("page_id")
    private final String pageId;

    @SerializedName("stem")
    private final String stem;

    @SerializedName("type")
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuizResponse copy$default(QuizResponse quizResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, String str10, String str11, String str12, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quizResponse.type;
        }
        return quizResponse.copy(str, (i & 2) != 0 ? quizResponse.lang : str2, (i & 4) != 0 ? quizResponse.noteId : str3, (i & 8) != 0 ? quizResponse.noteLang : str4, (i & 16) != 0 ? quizResponse.pageId : str5, (i & 32) != 0 ? quizResponse.stem : str6, (i & 64) != 0 ? quizResponse.a : str7, (i & 128) != 0 ? quizResponse.b : str8, (i & 256) != 0 ? quizResponse.c : str9, (i & 512) != 0 ? quizResponse.options : list, (i & 1024) != 0 ? quizResponse.correctAnswer : str10, (i & 2048) != 0 ? quizResponse.explanation : str11, (i & 4096) != 0 ? quizResponse.contentRef : str12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<String> component10() {
        return this.options;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getCorrectAnswer() {
        return this.correctAnswer;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getExplanation() {
        return this.explanation;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getContentRef() {
        return this.contentRef;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNoteId() {
        return this.noteId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNoteLang() {
        return this.noteLang;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPageId() {
        return this.pageId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStem() {
        return this.stem;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getA() {
        return this.a;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getB() {
        return this.b;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getC() {
        return this.c;
    }

    public final QuizResponse copy(String type, String lang, String noteId, String noteLang, String pageId, String stem, String a2, String b, String c, List<String> options, String correctAnswer, String explanation, String contentRef) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(noteId, "noteId");
        Intrinsics.checkNotNullParameter(noteLang, "noteLang");
        Intrinsics.checkNotNullParameter(stem, "stem");
        Intrinsics.checkNotNullParameter(correctAnswer, "correctAnswer");
        return new QuizResponse(type, lang, noteId, noteLang, pageId, stem, a2, b, c, options, correctAnswer, explanation, contentRef);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizResponse)) {
            return false;
        }
        QuizResponse quizResponse = (QuizResponse) other;
        return Intrinsics.areEqual(this.type, quizResponse.type) && Intrinsics.areEqual(this.lang, quizResponse.lang) && Intrinsics.areEqual(this.noteId, quizResponse.noteId) && Intrinsics.areEqual(this.noteLang, quizResponse.noteLang) && Intrinsics.areEqual(this.pageId, quizResponse.pageId) && Intrinsics.areEqual(this.stem, quizResponse.stem) && Intrinsics.areEqual(this.a, quizResponse.a) && Intrinsics.areEqual(this.b, quizResponse.b) && Intrinsics.areEqual(this.c, quizResponse.c) && Intrinsics.areEqual(this.options, quizResponse.options) && Intrinsics.areEqual(this.correctAnswer, quizResponse.correctAnswer) && Intrinsics.areEqual(this.explanation, quizResponse.explanation) && Intrinsics.areEqual(this.contentRef, quizResponse.contentRef);
    }

    public int hashCode() {
        int iHashCode = ((((((this.type.hashCode() * 31) + this.lang.hashCode()) * 31) + this.noteId.hashCode()) * 31) + this.noteLang.hashCode()) * 31;
        String str = this.pageId;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.stem.hashCode()) * 31;
        String str2 = this.a;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.b;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.c;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<String> list = this.options;
        int iHashCode6 = (((iHashCode5 + (list == null ? 0 : list.hashCode())) * 31) + this.correctAnswer.hashCode()) * 31;
        String str5 = this.explanation;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.contentRef;
        return iHashCode7 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "QuizResponse(type=" + this.type + ", lang=" + this.lang + ", noteId=" + this.noteId + ", noteLang=" + this.noteLang + ", pageId=" + this.pageId + ", stem=" + this.stem + ", a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", options=" + this.options + ", correctAnswer=" + this.correctAnswer + ", explanation=" + this.explanation + ", contentRef=" + this.contentRef + ")";
    }

    public QuizResponse(String type, String lang, String noteId, String noteLang, String str, String stem, String str2, String str3, String str4, List<String> list, String correctAnswer, String str5, String str6) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(noteId, "noteId");
        Intrinsics.checkNotNullParameter(noteLang, "noteLang");
        Intrinsics.checkNotNullParameter(stem, "stem");
        Intrinsics.checkNotNullParameter(correctAnswer, "correctAnswer");
        this.type = type;
        this.lang = lang;
        this.noteId = noteId;
        this.noteLang = noteLang;
        this.pageId = str;
        this.stem = stem;
        this.a = str2;
        this.b = str3;
        this.c = str4;
        this.options = list;
        this.correctAnswer = correctAnswer;
        this.explanation = str5;
        this.contentRef = str6;
    }

    public final String getType() {
        return this.type;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getNoteId() {
        return this.noteId;
    }

    public final String getNoteLang() {
        return this.noteLang;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getStem() {
        return this.stem;
    }

    public final String getA() {
        return this.a;
    }

    public final String getB() {
        return this.b;
    }

    public final String getC() {
        return this.c;
    }

    public final List<String> getOptions() {
        return this.options;
    }

    public final String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public final String getExplanation() {
        return this.explanation;
    }

    public final String getContentRef() {
        return this.contentRef;
    }
}
