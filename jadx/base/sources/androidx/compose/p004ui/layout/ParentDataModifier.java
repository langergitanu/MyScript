package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ParentDataModifier.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/Modifier$Element;", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ParentDataModifier extends Modifier.Element {
    Object modifyParentData(Density density, Object obj);

    /* JADX INFO: compiled from: ParentDataModifier.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(ParentDataModifier parentDataModifier, Function1<? super Modifier.Element, Boolean> function1) {
            return ParentDataModifier.super.all(function1);
        }

        @Deprecated
        public static boolean any(ParentDataModifier parentDataModifier, Function1<? super Modifier.Element, Boolean> function1) {
            return ParentDataModifier.super.any(function1);
        }

        @Deprecated
        public static <R> R foldIn(ParentDataModifier parentDataModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return (R) ParentDataModifier.super.foldIn(r, function2);
        }

        @Deprecated
        public static <R> R foldOut(ParentDataModifier parentDataModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return (R) ParentDataModifier.super.foldOut(r, function2);
        }

        @Deprecated
        public static Modifier then(ParentDataModifier parentDataModifier, Modifier modifier) {
            return ParentDataModifier.super.then(modifier);
        }
    }
}
