package com.myscript.nebo.userdict;

import com.myscript.nebo.userdict.p035ui.InputStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: UserDictionaryInputChecker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\"\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"WORD_CHARACTER_LIMIT", "", "MAX_ALLOWED_SPACE", "INVALID_CHARACTERS_REGEX", "Lkotlin/text/Regex;", "getForbiddenChars", "Lkotlin/sequences/Sequence;", "", "input", "", "checkInput", "Lcom/myscript/nebo/userdict/ui/InputStatus;", "words", "", "user-dictionary_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserDictionaryInputChecker {
    private static final Regex INVALID_CHARACTERS_REGEX = new Regex("[^\\p{L}\\p{Digit}₸'＇\\-－՚!！\"＂#＃$＄%％&＆(（)）*＊,，、.．。/／:：;;；?？@＠\\[［\\\\＼\\]］^＾_＿{｛|｜}｝~～¡¿˙՛՜՝՞„⁊〈〉《¢￠£￡》¥￥₱「」₩￦₮〔€〕〖〗₴₫჻+＋<＜=＝>＞±«»×÷∴△○→↳⇒←⇐§°··・…〒☆✓•※⍻]");
    private static final int MAX_ALLOWED_SPACE = 0;
    private static final int WORD_CHARACTER_LIMIT = 50;

    public static final InputStatus checkInput(CharSequence charSequence) {
        return checkInput$default(charSequence, null, 2, null);
    }

    private static final Sequence<String> getForbiddenChars(CharSequence charSequence) {
        return SequencesKt.map(Regex.findAll$default(INVALID_CHARACTERS_REGEX, charSequence, 0, 2, null), new Function1() { // from class: com.myscript.nebo.userdict.UserDictionaryInputChecker$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDictionaryInputChecker.getForbiddenChars$lambda$0((MatchResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getForbiddenChars$lambda$0(MatchResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getValue();
    }

    public static /* synthetic */ InputStatus checkInput$default(CharSequence charSequence, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return checkInput(charSequence, list);
    }

    public static final InputStatus checkInput(CharSequence charSequence, List<String> words) {
        CharSequence charSequenceTrim;
        Intrinsics.checkNotNullParameter(words, "words");
        if (charSequence == null || (charSequenceTrim = StringsKt.trim(charSequence)) == null) {
            return InputStatus.Invalid.IsEmpty.INSTANCE;
        }
        List list = SequencesKt.toList(getForbiddenChars(charSequenceTrim));
        if (StringsKt.isBlank(charSequenceTrim)) {
            return InputStatus.Invalid.IsEmpty.INSTANCE;
        }
        if (charSequenceTrim.length() > 50) {
            return new InputStatus.Invalid.TooLong(charSequenceTrim);
        }
        int i = 0;
        for (int i2 = 0; i2 < charSequenceTrim.length(); i2++) {
            if (CharsKt.isWhitespace(charSequenceTrim.charAt(i2))) {
                i++;
            }
        }
        if (i > 0) {
            return new InputStatus.Invalid.ContainsWhiteSpace(charSequenceTrim);
        }
        if (list.isEmpty()) {
            List<String> list2 = words;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual((String) it.next(), charSequenceTrim.toString())) {
                        return new InputStatus.Invalid.Exists(charSequenceTrim);
                    }
                }
            }
            return InputStatus.Valid.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!new Regex("\\p{C}").matches((String) obj)) {
                arrayList.add(obj);
            }
        }
        List listDistinct = CollectionsKt.distinct(arrayList);
        return new InputStatus.Invalid.ForbiddenChar(listDistinct.size(), CollectionsKt.joinToString$default(listDistinct, "", null, null, 0, null, null, 62, null));
    }
}
