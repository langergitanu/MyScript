package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [T, E] */
/* JADX INFO: renamed from: kotlinx.datetime.internal.format.OptionalFormatStructure$PropertyWithDefault$isDefaultComparisonPredicate$1 */
/* JADX INFO: compiled from: FormatStructure.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
public /* synthetic */ class C8905x66a7504a<E, T> extends FunctionReferenceImpl implements Function1<T, E> {
    public C8905x66a7504a(Object obj) {
        super(1, obj, Accessor.class, "getter", "getter(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final E invoke(T t) {
        return (E) ((Accessor) this.receiver).getter(t);
    }
}
