package androidx.compose.p004ui.input.nestedscroll;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.node.TraversableNode;
import androidx.compose.p004ui.node.TraversableNodeKt;
import androidx.compose.p004ui.unit.Velocity;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: NestedScrollNode.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J'\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0004\b*\u0010+J\u0018\u0010,\u001a\u00020-2\u0006\u0010#\u001a\u00020-H\u0096@¢\u0006\u0004\b.\u0010/J \u00100\u001a\u00020-2\u0006\u0010)\u001a\u00020-2\u0006\u0010#\u001a\u00020-H\u0096@¢\u0006\u0004\b1\u00102J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u00106\u001a\u000204H\u0016J\b\u00107\u001a\u000204H\u0016J\b\u00108\u001a\u000204H\u0002J\b\u00109\u001a\u000204H\u0002J\u001f\u0010:\u001a\u0002042\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b;R\u001a\u0010\u0004\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006<"}, m1599d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/Modifier$Node;", "connection", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "<init>", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "resolvedDispatcher", "lastKnownParentNode", "getLastKnownParentNode$ui", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "setLastKnownParentNode$ui", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;)V", "parentNestedScrollNode", "getParentNestedScrollNode$ui", "parentConnection", "getParentConnection", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope$annotations", "()V", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", FirebaseAnalytics.Param.SOURCE, "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDispatcher", "", "newDispatcher", "onAttach", "onDetach", "updateDispatcherFields", "resetDispatcherFields", "updateNode", "updateNode$ui", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, NestedScrollConnection {
    public static final int $stable = 8;
    private NestedScrollConnection connection;
    private NestedScrollNode lastKnownParentNode;
    private NestedScrollDispatcher resolvedDispatcher;
    private final Object traverseKey;

    private static /* synthetic */ void getNestedCoroutineScope$annotations() {
    }

    public NestedScrollNode(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        this.resolvedDispatcher = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    public final void setConnection(NestedScrollConnection nestedScrollConnection) {
        this.connection = nestedScrollConnection;
    }

    /* JADX INFO: renamed from: getLastKnownParentNode$ui, reason: from getter */
    public final NestedScrollNode getLastKnownParentNode() {
        return this.lastKnownParentNode;
    }

    public final void setLastKnownParentNode$ui(NestedScrollNode nestedScrollNode) {
        this.lastKnownParentNode = nestedScrollNode;
    }

    public final NestedScrollNode getParentNestedScrollNode$ui() {
        if (getIsAttached()) {
            return (NestedScrollNode) TraversableNodeKt.findNearestAncestor(this);
        }
        return null;
    }

    private final NestedScrollConnection getParentConnection() {
        if (getIsAttached()) {
            return getParentNestedScrollNode$ui();
        }
        return null;
    }

    @Override // androidx.compose.p004ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        NestedScrollNode parentNestedScrollNode$ui = getParentNestedScrollNode$ui();
        CoroutineScope nestedCoroutineScope = parentNestedScrollNode$ui != null ? parentNestedScrollNode$ui.getNestedCoroutineScope() : null;
        if (nestedCoroutineScope != null && CoroutineScopeKt.isActive(nestedCoroutineScope)) {
            return nestedCoroutineScope;
        }
        CoroutineScope scope$ui = this.resolvedDispatcher.getScope();
        if (scope$ui != null) {
            return scope$ui;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo2958onPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection parentConnection = getParentConnection();
        long jMo2958onPreScrollOzD1aCk = parentConnection != null ? parentConnection.mo2958onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m7919getZeroF1C5BW0();
        return Offset.m7908plusMKHz9U(jMo2958onPreScrollOzD1aCk, this.connection.mo2958onPreScrollOzD1aCk(Offset.m7907minusMKHz9U(available, jMo2958onPreScrollOzD1aCk), source));
    }

    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo2380onPostScrollDzOQY0M(long consumed, long available, int source) {
        long jM7919getZeroF1C5BW0;
        long jMo2380onPostScrollDzOQY0M = this.connection.mo2380onPostScrollDzOQY0M(consumed, available, source);
        NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            jM7919getZeroF1C5BW0 = parentConnection.mo2380onPostScrollDzOQY0M(Offset.m7908plusMKHz9U(consumed, jMo2380onPostScrollDzOQY0M), Offset.m7907minusMKHz9U(available, jMo2380onPostScrollDzOQY0M), source);
        } else {
            jM7919getZeroF1C5BW0 = Offset.INSTANCE.m7919getZeroF1C5BW0();
        }
        return Offset.m7908plusMKHz9U(jMo2380onPostScrollDzOQY0M, jM7919getZeroF1C5BW0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
    
        if (r11 == r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        if (r11 != r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo2957onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPreFling$1 nestedScrollNode$onPreFling$1;
        long jM11266getZero9UxMQ8M;
        long j2;
        if (continuation instanceof NestedScrollNode$onPreFling$1) {
            nestedScrollNode$onPreFling$1 = (NestedScrollNode$onPreFling$1) continuation;
            if ((nestedScrollNode$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPreFling$1.label -= Integer.MIN_VALUE;
            } else {
                nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, continuation);
            }
        }
        Object objMo2957onPreFlingQWom1Mo = nestedScrollNode$onPreFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = nestedScrollNode$onPreFling$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo2957onPreFlingQWom1Mo);
            NestedScrollConnection parentConnection = getParentConnection();
            if (parentConnection != null) {
                nestedScrollNode$onPreFling$1.J$0 = j;
                nestedScrollNode$onPreFling$1.label = 1;
                objMo2957onPreFlingQWom1Mo = parentConnection.mo2957onPreFlingQWom1Mo(j, nestedScrollNode$onPreFling$1);
            } else {
                jM11266getZero9UxMQ8M = Velocity.INSTANCE.m11266getZero9UxMQ8M();
                long j3 = jM11266getZero9UxMQ8M;
                long j4 = j;
                j2 = j3;
                NestedScrollConnection nestedScrollConnection = this.connection;
                long jM11258minusAH228Gc = Velocity.m11258minusAH228Gc(j4, j2);
                nestedScrollNode$onPreFling$1.J$0 = j2;
                nestedScrollNode$onPreFling$1.label = 2;
                objMo2957onPreFlingQWom1Mo = nestedScrollConnection.mo2957onPreFlingQWom1Mo(jM11258minusAH228Gc, nestedScrollNode$onPreFling$1);
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j2 = nestedScrollNode$onPreFling$1.J$0;
                ResultKt.throwOnFailure(objMo2957onPreFlingQWom1Mo);
                return Velocity.m11246boximpl(Velocity.m11259plusAH228Gc(j2, ((Velocity) objMo2957onPreFlingQWom1Mo).getPackedValue()));
            }
            j = nestedScrollNode$onPreFling$1.J$0;
            ResultKt.throwOnFailure(objMo2957onPreFlingQWom1Mo);
        }
        jM11266getZero9UxMQ8M = ((Velocity) objMo2957onPreFlingQWom1Mo).getPackedValue();
        long j32 = jM11266getZero9UxMQ8M;
        long j42 = j;
        j2 = j32;
        NestedScrollConnection nestedScrollConnection2 = this.connection;
        long jM11258minusAH228Gc2 = Velocity.m11258minusAH228Gc(j42, j2);
        nestedScrollNode$onPreFling$1.J$0 = j2;
        nestedScrollNode$onPreFling$1.label = 2;
        objMo2957onPreFlingQWom1Mo = nestedScrollConnection2.mo2957onPreFlingQWom1Mo(jM11258minusAH228Gc2, nestedScrollNode$onPreFling$1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo2379onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$1;
        long j3;
        long j4;
        long packedValue;
        long jM11266getZero9UxMQ8M;
        long j5;
        if (continuation instanceof NestedScrollNode$onPostFling$1) {
            nestedScrollNode$onPostFling$1 = (NestedScrollNode$onPostFling$1) continuation;
            if ((nestedScrollNode$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPostFling$1.label -= Integer.MIN_VALUE;
            } else {
                nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, continuation);
            }
        }
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$12 = nestedScrollNode$onPostFling$1;
        Object objMo2379onPostFlingRZ2iAVY = nestedScrollNode$onPostFling$12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = nestedScrollNode$onPostFling$12.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo2379onPostFlingRZ2iAVY);
            NestedScrollConnection nestedScrollConnection = this.connection;
            nestedScrollNode$onPostFling$12.J$0 = j;
            nestedScrollNode$onPostFling$12.J$1 = j2;
            nestedScrollNode$onPostFling$12.label = 1;
            objMo2379onPostFlingRZ2iAVY = nestedScrollConnection.mo2379onPostFlingRZ2iAVY(j, j2, nestedScrollNode$onPostFling$12);
            if (objMo2379onPostFlingRZ2iAVY != coroutine_suspended) {
                j3 = j;
                j4 = j2;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j5 = nestedScrollNode$onPostFling$12.J$0;
            ResultKt.throwOnFailure(objMo2379onPostFlingRZ2iAVY);
            jM11266getZero9UxMQ8M = ((Velocity) objMo2379onPostFlingRZ2iAVY).getPackedValue();
            packedValue = j5;
            return Velocity.m11246boximpl(Velocity.m11259plusAH228Gc(packedValue, jM11266getZero9UxMQ8M));
        }
        j4 = nestedScrollNode$onPostFling$12.J$1;
        j3 = nestedScrollNode$onPostFling$12.J$0;
        ResultKt.throwOnFailure(objMo2379onPostFlingRZ2iAVY);
        packedValue = ((Velocity) objMo2379onPostFlingRZ2iAVY).getPackedValue();
        NestedScrollConnection parentConnection = getIsAttached() ? getParentConnection() : this.lastKnownParentNode;
        if (parentConnection != null) {
            long jM11259plusAH228Gc = Velocity.m11259plusAH228Gc(j3, packedValue);
            long jM11258minusAH228Gc = Velocity.m11258minusAH228Gc(j4, packedValue);
            nestedScrollNode$onPostFling$12.J$0 = packedValue;
            nestedScrollNode$onPostFling$12.label = 2;
            objMo2379onPostFlingRZ2iAVY = parentConnection.mo2379onPostFlingRZ2iAVY(jM11259plusAH228Gc, jM11258minusAH228Gc, nestedScrollNode$onPostFling$12);
            if (objMo2379onPostFlingRZ2iAVY != coroutine_suspended) {
                j5 = packedValue;
                jM11266getZero9UxMQ8M = ((Velocity) objMo2379onPostFlingRZ2iAVY).getPackedValue();
                packedValue = j5;
                return Velocity.m11246boximpl(Velocity.m11259plusAH228Gc(packedValue, jM11266getZero9UxMQ8M));
            }
            return coroutine_suspended;
        }
        jM11266getZero9UxMQ8M = Velocity.INSTANCE.m11266getZero9UxMQ8M();
        return Velocity.m11246boximpl(Velocity.m11259plusAH228Gc(packedValue, jM11266getZero9UxMQ8M));
    }

    private final void updateDispatcher(NestedScrollDispatcher newDispatcher) {
        resetDispatcherFields();
        if (newDispatcher == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!Intrinsics.areEqual(newDispatcher, this.resolvedDispatcher)) {
            this.resolvedDispatcher = newDispatcher;
        }
        if (getIsAttached()) {
            updateDispatcherFields();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDispatcherFields();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        NestedScrollNode nestedScrollNode = (NestedScrollNode) NestedScrollNodeKt.findNearestAttachedAncestor(this);
        this.lastKnownParentNode = nestedScrollNode;
        this.resolvedDispatcher.setLastKnownParentNode$ui(nestedScrollNode);
        resetDispatcherFields();
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setNestedScrollNode$ui(this);
        this.resolvedDispatcher.setLastKnownParentNode$ui(null);
        this.lastKnownParentNode = null;
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui(new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNode.updateDispatcherFields.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return NestedScrollNode.this.getNestedCoroutineScope();
            }
        });
        this.resolvedDispatcher.setScope$ui(getCoroutineScope());
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getNestedScrollNode() == this) {
            this.resolvedDispatcher.setNestedScrollNode$ui(null);
        }
    }

    public final void updateNode$ui(NestedScrollConnection connection, NestedScrollDispatcher dispatcher) {
        this.connection = connection;
        updateDispatcher(dispatcher);
    }
}
