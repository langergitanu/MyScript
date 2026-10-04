package aws.smithy.kotlin.runtime.text;

import aws.smithy.kotlin.runtime.InternalApi;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Scanner.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0012\u0010\u0011J5\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\"\u00020\u00022\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0013¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\t2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J3\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\t2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0013H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ5\u0010\u001d\u001a\u00020\u000e2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\"\u00020\u00022\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0013¢\u0006\u0004\b\u001d\u0010\u0015J\u0011\u0010\u001e\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020 2\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J5\u0010#\u001a\u00020\u000e2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\"\u00020\u00022\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0013¢\u0006\u0004\b#\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u001fR\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006("}, m1599d2 = {"Laws/smithy/kotlin/runtime/text/Scanner;", "", "", "text", "<init>", "(Ljava/lang/String;)V", "", "literals", "Lkotlin/Pair;", "", "findAnyOf", "([Ljava/lang/String;)Lkotlin/Pair;", "prefix", "Lkotlin/Function0;", "", "handler", "ifStartsWith", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "ifStartsWithSkip", "Lkotlin/Function1;", "optionalAndSkip", "([Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "untilIndex", "process", "(ILkotlin/jvm/functions/Function1;)V", "literal", "startIndex", "processAndSkip", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "requireAndSkip", "toString", "()Ljava/lang/String;", "", "startsWith", "(Ljava/lang/String;)Z", "upToOrEnd", "Ljava/lang/String;", "getText", "currentIndex", "I", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Scanner {
    private int currentIndex;
    private final String text;

    public Scanner(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }

    public final String getText() {
        return this.text;
    }

    public final void ifStartsWith(String prefix, Function0<Unit> handler) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (startsWith(prefix)) {
            handler.invoke();
        }
    }

    public final void ifStartsWithSkip(String prefix, Function0<Unit> handler) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (startsWith(prefix)) {
            this.currentIndex += prefix.length();
            handler.invoke();
        }
    }

    public final void optionalAndSkip(String[] literals, Function1<? super String, Unit> handler) {
        Intrinsics.checkNotNullParameter(literals, "literals");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Pair<String, Integer> pairFindAnyOf = findAnyOf(literals);
        if (pairFindAnyOf != null) {
            processAndSkip(pairFindAnyOf.component1(), pairFindAnyOf.component2().intValue(), handler);
        }
    }

    private final void process(int untilIndex, Function1<? super String, Unit> handler) {
        String strSubstring = this.text.substring(this.currentIndex, untilIndex);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        this.currentIndex = untilIndex;
        handler.invoke(strSubstring);
    }

    private final void processAndSkip(String literal, int startIndex, Function1<? super String, Unit> handler) {
        process(startIndex, handler);
        this.currentIndex += literal.length();
    }

    public final void requireAndSkip(String[] literals, Function1<? super String, Unit> handler) {
        Intrinsics.checkNotNullParameter(literals, "literals");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Pair<String, Integer> pairFindAnyOf = findAnyOf(literals);
        if (pairFindAnyOf == null) {
            throw new IllegalArgumentException(("Cannot find any of " + ArraysKt.toList(literals)).toString());
        }
        processAndSkip(pairFindAnyOf.component1(), pairFindAnyOf.component2().intValue(), handler);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Scanner(remainingText='");
        String strSubstring = this.text.substring(this.currentIndex);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sb.append(strSubstring).append("')").toString();
    }

    public final boolean startsWith(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return StringsKt.regionMatches$default(this.text, this.currentIndex, prefix, 0, prefix.length(), false, 16, (Object) null);
    }

    public final void upToOrEnd(String[] literals, Function1<? super String, Unit> handler) {
        Intrinsics.checkNotNullParameter(literals, "literals");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Pair<String, Integer> pairFindAnyOf = findAnyOf(literals);
        process(pairFindAnyOf != null ? pairFindAnyOf.getSecond().intValue() : this.text.length(), handler);
    }

    private final Pair<String, Integer> findAnyOf(String[] literals) {
        Object obj;
        ArrayList arrayList = new ArrayList(literals.length);
        for (String str : literals) {
            arrayList.add(TuplesKt.m1606to(str, Integer.valueOf(StringsKt.indexOf$default((CharSequence) this.text, str, this.currentIndex, false, 4, (Object) null))));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((Number) ((Pair) obj2).component2()).intValue() != -1) {
                arrayList2.add(obj2);
            }
        }
        Iterator it = arrayList2.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int iIntValue = ((Number) ((Pair) next).component2()).intValue();
                do {
                    Object next2 = it.next();
                    int iIntValue2 = ((Number) ((Pair) next2).component2()).intValue();
                    if (iIntValue > iIntValue2) {
                        next = next2;
                        iIntValue = iIntValue2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (Pair) obj;
    }
}
