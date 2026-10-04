package kotlinx.datetime.internal.format.parser;

import androidx.exifinterface.media.ExifInterface;
import com.survicate.surveys.TextRecallingManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0003H\u0000\u001a\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0002¨\u0006\b"}, m1599d2 = {"concat", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", ExifInterface.GPS_DIRECTION_TRUE, "", "formatError", "", "errors", "Lkotlinx/datetime/internal/format/parser/ParseError;", "kotlinx-datetime"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ParserKt {
    private static final <T> ParserStructure<T> concat$append(ParserStructure<? super T> parserStructure, ParserStructure<? super T> parserStructure2) {
        if (parserStructure.getFollowedBy().isEmpty()) {
            return new ParserStructure<>(CollectionsKt.plus((Collection) parserStructure.getOperations(), (Iterable) parserStructure2.getOperations()), parserStructure2.getFollowedBy());
        }
        List<ParserOperation<? super T>> operations = parserStructure.getOperations();
        List<ParserStructure<? super T>> followedBy = parserStructure.getFollowedBy();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(followedBy, 10));
        Iterator<T> it = followedBy.iterator();
        while (it.hasNext()) {
            arrayList.add(concat$append((ParserStructure) it.next(), parserStructure2));
        }
        return new ParserStructure<>(operations, arrayList);
    }

    private static final <T> ParserStructure<T> concat$simplify(ParserStructure<? super T> parserStructure, List<UnconditionalModification<T>> list) {
        ParserStructure parserStructure2;
        List listListOf;
        ArrayList arrayList = new ArrayList();
        List mutableList = CollectionsKt.toMutableList((Collection) list);
        List mutableList2 = null;
        for (ParserOperation<? super T> parserOperation : parserStructure.getOperations()) {
            if (parserOperation instanceof NumberSpanParserOperation) {
                if (mutableList2 != null) {
                    mutableList2.addAll(((NumberSpanParserOperation) parserOperation).getConsumers());
                } else {
                    mutableList2 = CollectionsKt.toMutableList((Collection) ((NumberSpanParserOperation) parserOperation).getConsumers());
                }
            } else if (parserOperation instanceof UnconditionalModification) {
                mutableList.add(parserOperation);
            } else {
                if (mutableList2 != null) {
                    arrayList.add(new NumberSpanParserOperation(mutableList2));
                    mutableList2 = null;
                }
                arrayList.add(parserOperation);
            }
        }
        List<ParserStructure<? super T>> followedBy = parserStructure.getFollowedBy();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = followedBy.iterator();
        while (it.hasNext()) {
            ParserStructure parserStructureConcat$simplify = concat$simplify((ParserStructure) it.next(), mutableList);
            if (parserStructureConcat$simplify.getOperations().isEmpty()) {
                List followedBy2 = parserStructureConcat$simplify.getFollowedBy();
                if (followedBy2.isEmpty()) {
                    followedBy2 = CollectionsKt.listOf(parserStructureConcat$simplify);
                }
                listListOf = followedBy2;
            } else {
                listListOf = CollectionsKt.listOf(parserStructureConcat$simplify);
            }
            CollectionsKt.addAll(arrayList2, listListOf);
        }
        ArrayList arrayListListOf = arrayList2;
        if (arrayListListOf.isEmpty()) {
            arrayListListOf = CollectionsKt.listOf(new ParserStructure(mutableList, CollectionsKt.emptyList()));
        }
        List list2 = arrayListListOf;
        if (mutableList2 == null) {
            return new ParserStructure<>(arrayList, list2);
        }
        List<ParserStructure> list3 = list2;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                ParserOperation parserOperation2 = (ParserOperation) CollectionsKt.firstOrNull(((ParserStructure) it2.next()).getOperations());
                if (parserOperation2 != null && (parserOperation2 instanceof NumberSpanParserOperation)) {
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    for (ParserStructure parserStructure3 : list3) {
                        ParserOperation parserOperation3 = (ParserOperation) CollectionsKt.firstOrNull(parserStructure3.getOperations());
                        if (parserOperation3 instanceof NumberSpanParserOperation) {
                            parserStructure2 = new ParserStructure(CollectionsKt.plus((Collection) CollectionsKt.listOf(new NumberSpanParserOperation(CollectionsKt.plus((Collection) mutableList2, (Iterable) ((NumberSpanParserOperation) parserOperation3).getConsumers()))), (Iterable) CollectionsKt.drop(parserStructure3.getOperations(), 1)), parserStructure3.getFollowedBy());
                        } else if (parserOperation3 == null) {
                            parserStructure2 = new ParserStructure(CollectionsKt.listOf(new NumberSpanParserOperation(mutableList2)), parserStructure3.getFollowedBy());
                        } else {
                            parserStructure2 = new ParserStructure(CollectionsKt.plus((Collection) CollectionsKt.listOf(new NumberSpanParserOperation(mutableList2)), (Iterable) parserStructure3.getOperations()), parserStructure3.getFollowedBy());
                        }
                        arrayList3.add(parserStructure2);
                    }
                    return new ParserStructure<>(arrayList, arrayList3);
                }
            }
        }
        arrayList.add(new NumberSpanParserOperation(mutableList2));
        return new ParserStructure<>(arrayList, list2);
    }

    public static final <T> ParserStructure<T> concat(List<? extends ParserStructure<? super T>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ParserStructure parserStructure = new ParserStructure(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        if (!list.isEmpty()) {
            ListIterator<? extends ParserStructure<? super T>> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                parserStructure = concat$append(listIterator.previous(), parserStructure);
            }
        }
        return concat$simplify(parserStructure, CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatError(List<ParseError> list) {
        if (list.size() == 1) {
            return "Position " + list.get(0).getPosition() + ": " + list.get(0).getMessage().invoke();
        }
        String string = ((StringBuilder) CollectionsKt.joinTo(list, new StringBuilder(list.size() * 33), (60 & 2) != 0 ? TextRecallingManager.ANSWER_SEPARATOR : TextRecallingManager.ANSWER_SEPARATOR, (60 & 4) != 0 ? "" : "Errors: ", (60 & 8) != 0 ? "" : null, (60 & 16) != 0 ? -1 : 0, (60 & 32) != 0 ? "..." : null, (60 & 64) != 0 ? null : new Function1() { // from class: kotlinx.datetime.internal.format.parser.ParserKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ParserKt.formatError$lambda$8((ParseError) obj);
            }
        })).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence formatError$lambda$8(ParseError it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "position " + it.getPosition() + ": '" + it.getMessage().invoke() + '\'';
    }
}
