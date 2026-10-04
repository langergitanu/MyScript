package com.myscript.nebo.p022ai.data.model.quiz;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuizContent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001f"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/model/quiz/QuizContent;", "", "type", "", "id", "name", "pages", "", "Lcom/myscript/nebo/ai/data/model/quiz/QuizPage;", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getId", "getName", "getPages", "()Ljava/util/List;", "getText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class QuizContent {
    public static final int $stable = 8;

    @SerializedName("id")
    private final String id;

    @SerializedName("name")
    private final String name;

    @SerializedName("pages")
    private final List<QuizPage> pages;

    @SerializedName("text")
    private final String text;

    @SerializedName("type")
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuizContent copy$default(QuizContent quizContent, String str, String str2, String str3, List list, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quizContent.type;
        }
        if ((i & 2) != 0) {
            str2 = quizContent.id;
        }
        if ((i & 4) != 0) {
            str3 = quizContent.name;
        }
        if ((i & 8) != 0) {
            list = quizContent.pages;
        }
        if ((i & 16) != 0) {
            str4 = quizContent.text;
        }
        String str5 = str4;
        String str6 = str3;
        return quizContent.copy(str, str2, str6, list, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<QuizPage> component4() {
        return this.pages;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final QuizContent copy(String type, String id, String name, List<QuizPage> pages, String text) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new QuizContent(type, id, name, pages, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizContent)) {
            return false;
        }
        QuizContent quizContent = (QuizContent) other;
        return Intrinsics.areEqual(this.type, quizContent.type) && Intrinsics.areEqual(this.id, quizContent.id) && Intrinsics.areEqual(this.name, quizContent.name) && Intrinsics.areEqual(this.pages, quizContent.pages) && Intrinsics.areEqual(this.text, quizContent.text);
    }

    public int hashCode() {
        int iHashCode = ((((this.type.hashCode() * 31) + this.id.hashCode()) * 31) + this.name.hashCode()) * 31;
        List<QuizPage> list = this.pages;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.text;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "QuizContent(type=" + this.type + ", id=" + this.id + ", name=" + this.name + ", pages=" + this.pages + ", text=" + this.text + ")";
    }

    public QuizContent(String type, String id, String name, List<QuizPage> list, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.type = type;
        this.id = id;
        this.name = name;
        this.pages = list;
        this.text = str;
    }

    public /* synthetic */ QuizContent(String str, String str2, String str3, List list, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : str4);
    }

    public final String getType() {
        return this.type;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<QuizPage> getPages() {
        return this.pages;
    }

    public final String getText() {
        return this.text;
    }
}
