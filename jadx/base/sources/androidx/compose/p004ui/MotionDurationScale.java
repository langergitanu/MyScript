package androidx.compose.p004ui;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MotionDurationScale.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, m1599d2 = {"Landroidx/compose/ui/MotionDurationScale;", "Lkotlin/coroutines/CoroutineContext$Element;", "scaleFactor", "", "getScaleFactor", "()F", SubscriberAttributeKt.JSON_NAME_KEY, "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Key", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface MotionDurationScale extends CoroutineContext.Element {

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    float getScaleFactor();

    /* JADX INFO: compiled from: MotionDurationScale.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(MotionDurationScale motionDurationScale, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(motionDurationScale, r, function2);
        }

        public static <E extends CoroutineContext.Element> E get(MotionDurationScale motionDurationScale, CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.DefaultImpls.get(motionDurationScale, key);
        }

        public static CoroutineContext minusKey(MotionDurationScale motionDurationScale, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey(motionDurationScale, key);
        }

        public static CoroutineContext plus(MotionDurationScale motionDurationScale, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.plus(motionDurationScale, coroutineContext);
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    default CoroutineContext.Key<?> getKey() {
        return INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.ui.MotionDurationScale$Key, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MotionDurationScale.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"Landroidx/compose/ui/MotionDurationScale$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/ui/MotionDurationScale;", "<init>", "()V", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion implements CoroutineContext.Key<MotionDurationScale> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
