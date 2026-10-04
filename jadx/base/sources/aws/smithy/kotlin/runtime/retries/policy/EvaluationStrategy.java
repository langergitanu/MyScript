package aws.smithy.kotlin.runtime.retries.policy;

import androidx.exifinterface.media.ExifInterface;
import java.lang.Throwable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;

/* JADX INFO: compiled from: StandardRetryPolicy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u0000 \u0012*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0012B+\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/EvaluationStrategy;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/KClass;", "clazz", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "evaluator", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "ex", "evaluate", "(Ljava/lang/Throwable;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "Lkotlin/reflect/KClass;", "getClazz", "()Lkotlin/reflect/KClass;", "Lkotlin/jvm/functions/Function1;", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class EvaluationStrategy<T extends Throwable> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final KClass<T> clazz;
    private final Function1<T, RetryDirective> evaluator;

    /* JADX INFO: compiled from: StandardRetryPolicy.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t\"\n\b\u0001\u0010\u0005\u0018\u0001*\u00020\u00042\u0016\b\b\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/EvaluationStrategy$Companion;", "", "<init>", "()V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "evaluator", "Laws/smithy/kotlin/runtime/retries/policy/EvaluationStrategy;", "invoke", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/retries/policy/EvaluationStrategy;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ <T extends Throwable> EvaluationStrategy<T> invoke(Function1<? super T, ? extends RetryDirective> evaluator) {
            Intrinsics.checkNotNullParameter(evaluator, "evaluator");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return new EvaluationStrategy<>(Reflection.getOrCreateKotlinClass(Throwable.class), evaluator);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EvaluationStrategy(KClass<T> clazz, Function1<? super T, ? extends RetryDirective> evaluator) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(evaluator, "evaluator");
        this.clazz = clazz;
        this.evaluator = evaluator;
    }

    public final KClass<T> getClazz() {
        return this.clazz;
    }

    public final RetryDirective evaluate(Throwable ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        Throwable th = (Throwable) KClasses.safeCast(this.clazz, ex);
        if (th != null) {
            return this.evaluator.invoke((T) th);
        }
        return null;
    }
}
