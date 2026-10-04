package aws.smithy.kotlin.runtime.retries.policy;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Acceptors.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0001\u0014B/\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u001e\u0010\t\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00028\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R/\u0010\t\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/InputOutputAcceptor;", "I", "O", "Laws/smithy/kotlin/runtime/retries/policy/Acceptor;", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "state", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/policy/InputOutputAcceptor$InputOutput;", "", "matcher", "<init>", "(Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;Lkotlin/jvm/functions/Function1;)V", "request", "Lkotlin/Result;", "result", "matches", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlin/jvm/functions/Function1;", "getMatcher", "()Lkotlin/jvm/functions/Function1;", "InputOutput", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InputOutputAcceptor<I, O> extends Acceptor<I, O> {
    private final Function1<InputOutput<I, O>, Boolean> matcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InputOutputAcceptor(RetryDirective state, Function1<? super InputOutput<I, O>, Boolean> matcher) {
        super(state);
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        this.matcher = matcher;
    }

    public final Function1<InputOutput<I, O>, Boolean> getMatcher() {
        return this.matcher;
    }

    /* JADX INFO: compiled from: Acceptors.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00028\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ0\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00022\b\b\u0002\u0010\u0005\u001a\u00028\u0003HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0003HÖ\u0083\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0011HÖ\u0081\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u00020\u0014HÖ\u0081\u0004¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00028\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u0017\u0010\u0005\u001a\u00028\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0019\u0010\t¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/InputOutputAcceptor$InputOutput;", "I", "O", "", "input", "output", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "component1", "()Ljava/lang/Object;", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Laws/smithy/kotlin/runtime/retries/policy/InputOutputAcceptor$InputOutput;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getInput", "getOutput", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class InputOutput<I, O> {
        private final I input;
        private final O output;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InputOutput copy$default(InputOutput inputOutput, Object obj, Object obj2, int i, Object obj3) {
            if ((i & 1) != 0) {
                obj = inputOutput.input;
            }
            if ((i & 2) != 0) {
                obj2 = inputOutput.output;
            }
            return inputOutput.copy(obj, obj2);
        }

        public final I component1() {
            return this.input;
        }

        public final O component2() {
            return this.output;
        }

        public final InputOutput<I, O> copy(I input, O output) {
            return new InputOutput<>(input, output);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InputOutput)) {
                return false;
            }
            InputOutput inputOutput = (InputOutput) other;
            return Intrinsics.areEqual(this.input, inputOutput.input) && Intrinsics.areEqual(this.output, inputOutput.output);
        }

        public int hashCode() {
            I i = this.input;
            int iHashCode = (i == null ? 0 : i.hashCode()) * 31;
            O o = this.output;
            return iHashCode + (o != null ? o.hashCode() : 0);
        }

        public String toString() {
            return "InputOutput(input=" + this.input + ", output=" + this.output + ')';
        }

        public InputOutput(I i, O o) {
            this.input = i;
            this.output = o;
        }

        public final I getInput() {
            return this.input;
        }

        public final O getOutput() {
            return this.output;
        }
    }

    @Override // aws.smithy.kotlin.runtime.retries.policy.Acceptor
    protected boolean matches(I request, Object result) {
        if (Result.m14505isFailureimpl(result)) {
            result = null;
        }
        if (result != null) {
            return this.matcher.invoke(new InputOutput<>(request, result)).booleanValue();
        }
        return false;
    }
}
