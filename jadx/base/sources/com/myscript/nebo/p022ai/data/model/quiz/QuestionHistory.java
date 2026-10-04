package com.myscript.nebo.p022ai.data.model.quiz;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuestionHistory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Ju\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020)HÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006+"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/model/quiz/QuestionHistory;", "", "lang", "", "stem", "pageId", "noteId", "noteLang", "type", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "c", "correctAnswer", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLang", "()Ljava/lang/String;", "getStem", "getPageId", "getNoteId", "getNoteLang", "getType", "getA", "getB", "getC", "getCorrectAnswer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class QuestionHistory {
    public static final int $stable = 0;

    @SerializedName(CmcdData.OBJECT_TYPE_AUDIO_ONLY)
    private final String a;

    @SerializedName("b")
    private final String b;

    @SerializedName("c")
    private final String c;

    @SerializedName("correct_answer")
    private final String correctAnswer;

    @SerializedName("lang")
    private final String lang;

    @SerializedName("note_id")
    private final String noteId;

    @SerializedName("note_lang")
    private final String noteLang;

    @SerializedName("page_id")
    private final String pageId;

    @SerializedName("stem")
    private final String stem;

    @SerializedName("type")
    private final String type;

    public static /* synthetic */ QuestionHistory copy$default(QuestionHistory questionHistory, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, Object obj) {
        if ((i & 1) != 0) {
            str = questionHistory.lang;
        }
        if ((i & 2) != 0) {
            str2 = questionHistory.stem;
        }
        if ((i & 4) != 0) {
            str3 = questionHistory.pageId;
        }
        if ((i & 8) != 0) {
            str4 = questionHistory.noteId;
        }
        if ((i & 16) != 0) {
            str5 = questionHistory.noteLang;
        }
        if ((i & 32) != 0) {
            str6 = questionHistory.type;
        }
        if ((i & 64) != 0) {
            str7 = questionHistory.a;
        }
        if ((i & 128) != 0) {
            str8 = questionHistory.b;
        }
        if ((i & 256) != 0) {
            str9 = questionHistory.c;
        }
        if ((i & 512) != 0) {
            str10 = questionHistory.correctAnswer;
        }
        String str11 = str9;
        String str12 = str10;
        String str13 = str7;
        String str14 = str8;
        String str15 = str5;
        String str16 = str6;
        return questionHistory.copy(str, str2, str3, str4, str15, str16, str13, str14, str11, str12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getCorrectAnswer() {
        return this.correctAnswer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStem() {
        return this.stem;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPageId() {
        return this.pageId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNoteId() {
        return this.noteId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getNoteLang() {
        return this.noteLang;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getType() {
        return this.type;
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

    public final QuestionHistory copy(String lang, String stem, String pageId, String noteId, String noteLang, String type, String a2, String b, String c, String correctAnswer) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(stem, "stem");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(correctAnswer, "correctAnswer");
        return new QuestionHistory(lang, stem, pageId, noteId, noteLang, type, a2, b, c, correctAnswer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuestionHistory)) {
            return false;
        }
        QuestionHistory questionHistory = (QuestionHistory) other;
        return Intrinsics.areEqual(this.lang, questionHistory.lang) && Intrinsics.areEqual(this.stem, questionHistory.stem) && Intrinsics.areEqual(this.pageId, questionHistory.pageId) && Intrinsics.areEqual(this.noteId, questionHistory.noteId) && Intrinsics.areEqual(this.noteLang, questionHistory.noteLang) && Intrinsics.areEqual(this.type, questionHistory.type) && Intrinsics.areEqual(this.a, questionHistory.a) && Intrinsics.areEqual(this.b, questionHistory.b) && Intrinsics.areEqual(this.c, questionHistory.c) && Intrinsics.areEqual(this.correctAnswer, questionHistory.correctAnswer);
    }

    public int hashCode() {
        int iHashCode = ((this.lang.hashCode() * 31) + this.stem.hashCode()) * 31;
        String str = this.pageId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.noteId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.noteLang;
        int iHashCode4 = (((((((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.type.hashCode()) * 31) + this.a.hashCode()) * 31) + this.b.hashCode()) * 31;
        String str4 = this.c;
        return ((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.correctAnswer.hashCode();
    }

    public String toString() {
        return "QuestionHistory(lang=" + this.lang + ", stem=" + this.stem + ", pageId=" + this.pageId + ", noteId=" + this.noteId + ", noteLang=" + this.noteLang + ", type=" + this.type + ", a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", correctAnswer=" + this.correctAnswer + ")";
    }

    public QuestionHistory(String lang, String stem, String str, String str2, String str3, String type, String a2, String b, String str4, String correctAnswer) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(stem, "stem");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(correctAnswer, "correctAnswer");
        this.lang = lang;
        this.stem = stem;
        this.pageId = str;
        this.noteId = str2;
        this.noteLang = str3;
        this.type = type;
        this.a = a2;
        this.b = b;
        this.c = str4;
        this.correctAnswer = correctAnswer;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getStem() {
        return this.stem;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getNoteId() {
        return this.noteId;
    }

    public final String getNoteLang() {
        return this.noteLang;
    }

    public final String getType() {
        return this.type;
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

    public final String getCorrectAnswer() {
        return this.correctAnswer;
    }
}
