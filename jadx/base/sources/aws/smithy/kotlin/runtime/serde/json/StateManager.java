package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.collections.StackKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonLexer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BE\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012(\b\u0002\u0010\u0006\u001a\"\u0012\u001e\u0012\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t0\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0013\u001a\u00020\bJ(\u0010\u0014\u001a\u00020\b2 \u0010\u0015\u001a\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tJ\u0013\u0010\u0016\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005HÂ\u0003J)\u0010\u0017\u001a\"\u0012\u001e\u0012\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t0\u0003HÂ\u0003JG\u0010\u0018\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052(\b\u0002\u0010\u0006\u001a\"\u0012\u001e\u0012\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t0\u0003HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\rHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004R\u0018\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0006\u001a\"\u0012\u001e\u0012\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/StateManager;", "", "state", "", "Laws/smithy/kotlin/runtime/serde/json/LexerState;", "Laws/smithy/kotlin/runtime/serde/json/StateStack;", "pendingMutations", "Lkotlin/Function1;", "", "Laws/smithy/kotlin/runtime/serde/json/StateMutation;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "size", "", "getSize", "()I", "current", "getCurrent", "()Laws/smithy/kotlin/runtime/serde/json/LexerState;", "update", "mutate", "mutation", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* data */ class StateManager {
    private final List<Function1<List<LexerState>, Unit>> pendingMutations;
    private final List<LexerState> state;

    /* JADX WARN: Multi-variable type inference failed */
    public StateManager() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final List<LexerState> component1() {
        return this.state;
    }

    private final List<Function1<List<LexerState>, Unit>> component2() {
        return this.pendingMutations;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StateManager copy$default(StateManager stateManager, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = stateManager.state;
        }
        if ((i & 2) != 0) {
            list2 = stateManager.pendingMutations;
        }
        return stateManager.copy(list, list2);
    }

    public final StateManager copy(List<LexerState> state, List<Function1<List<LexerState>, Unit>> pendingMutations) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(pendingMutations, "pendingMutations");
        return new StateManager(state, pendingMutations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StateManager)) {
            return false;
        }
        StateManager stateManager = (StateManager) other;
        return Intrinsics.areEqual(this.state, stateManager.state) && Intrinsics.areEqual(this.pendingMutations, stateManager.pendingMutations);
    }

    public int hashCode() {
        return (this.state.hashCode() * 31) + this.pendingMutations.hashCode();
    }

    public String toString() {
        return "StateManager(state=" + this.state + ", pendingMutations=" + this.pendingMutations + ')';
    }

    public StateManager(List<LexerState> state, List<Function1<List<LexerState>, Unit>> pendingMutations) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(pendingMutations, "pendingMutations");
        this.state = state;
        this.pendingMutations = pendingMutations;
    }

    public /* synthetic */ StateManager(List list, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.mutableListOf(LexerState.Initial) : list, (i & 2) != 0 ? new ArrayList() : arrayList);
    }

    public final int getSize() {
        return this.state.size();
    }

    public final LexerState getCurrent() {
        return (LexerState) StackKt.top(this.state);
    }

    public final void update() {
        Iterator<T> it = this.pendingMutations.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(this.state);
        }
        this.pendingMutations.clear();
    }

    public final void mutate(Function1<? super List<LexerState>, Unit> mutation) {
        Intrinsics.checkNotNullParameter(mutation, "mutation");
        this.pendingMutations.add(mutation);
    }
}
