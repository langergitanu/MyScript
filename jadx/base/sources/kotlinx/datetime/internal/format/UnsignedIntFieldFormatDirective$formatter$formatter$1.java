package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [Target] */
/* JADX INFO: compiled from: FieldFormatDirective.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
/* synthetic */ class UnsignedIntFieldFormatDirective$formatter$formatter$1<Target> extends FunctionReferenceImpl implements Function1<Target, Integer> {
    UnsignedIntFieldFormatDirective$formatter$formatter$1(Object obj) {
        super(1, obj, Accessor.class, "getterNotNull", "getterNotNull(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Integer invoke(Target target) {
        return (Integer) ((Accessor) this.receiver).getterNotNull(target);
    }
}
