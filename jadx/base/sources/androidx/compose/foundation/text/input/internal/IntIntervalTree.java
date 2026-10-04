package androidx.compose.foundation.text.input.internal;

import androidx.collection.MutableIntList;
import androidx.collection.MutableLongList;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntIntervalTree.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b-\b\u0001\u0018\u0000 }*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001}B\u0019\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010'\u001a\u00020\n*\u00020\n¢\u0006\u0004\b(\u0010\fJ\u0011\u0010)\u001a\u00020\n*\u00020\n¢\u0006\u0004\b*\u0010\fJ!\u0010+\u001a\u00020,*\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b-\u0010.J3\u0010/\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b0\u00101Jc\u0010G\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072K\u0010I\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020H0JJS\u0010M\u001a\u00020H2K\u0010I\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020H0JJ\u0006\u0010N\u001a\u00020HJ\b\u0010O\u001a\u00020HH\u0002J/\u0010P\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020H0QH\u0082\bJ/\u0010R\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020H0QH\u0082\bJ-\u0010S\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070QH\u0086\bJ#\u0010U\u001a\u00020,2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0002\u0010VJ#\u0010W\u001a\u00020,2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0002\u0010VJ'\u0010X\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\bY\u0010ZJ!\u0010[\u001a\u00020H2\u0006\u0010\\\u001a\u00020\n2\b\b\u0002\u0010]\u001a\u00020,H\u0002¢\u0006\u0004\b^\u0010_J\u001f\u0010`\u001a\u00020H2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010a\u001a\u00020\nH\u0002¢\u0006\u0004\bb\u0010\u000eJ\u001f\u0010c\u001a\u00020H2\u0006\u0010d\u001a\u00020\n2\u0006\u0010]\u001a\u00020,H\u0002¢\u0006\u0004\be\u0010_J\b\u0010f\u001a\u00020HH\u0002J\u001f\u0010g\u001a\u00020H2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010h\u001a\u00020\nH\u0002¢\u0006\u0004\bi\u0010\u000eJ\u0017\u0010j\u001a\u00020H2\u0006\u0010\\\u001a\u00020\nH\u0002¢\u0006\u0004\bk\u0010=J\u0017\u0010l\u001a\u00020H2\u0006\u0010d\u001a\u00020\nH\u0002¢\u0006\u0004\bm\u0010=J\u0017\u0010n\u001a\u00020H2\u0006\u0010d\u001a\u00020\nH\u0002¢\u0006\u0004\bo\u0010=J\u0017\u0010p\u001a\u00020H2\u0006\u0010d\u001a\u00020\nH\u0002¢\u0006\u0004\bq\u0010=J\u0013\u0010r\u001a\u00020,2\b\u0010s\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010t\u001a\u00020\u0007H\u0016J\f\u0010u\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0006\u0010v\u001a\u00020,J\u001d\u0010w\u001a\u00020H*\u00060Bj\u0002`C2\u0006\u0010d\u001a\u00020\n¢\u0006\u0004\bx\u0010yJ\u0015\u0010z\u001a\u00020\n*\u00060Bj\u0002`C¢\u0006\u0004\b{\u0010|R0\u0010\t\u001a\u00060\u0007j\u0002`\b*\u00020\n2\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u00020\n*\u00020\n2\u0006\u0010\u0006\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR(\u0010\u0012\u001a\u00020\n*\u00020\n2\u0006\u0010\u0006\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR(\u0010\u0015\u001a\u00020\n*\u00020\n2\u0006\u0010\u0006\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR(\u0010\u0018\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR(\u0010\u001b\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR(\u0010\u001e\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR(\u0010!\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u0004\u0018\u00018\u0000*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u000003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u00020\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b;\u00108\"\u0004\b<\u0010=R\u0013\u0010?\u001a\u00020\n¢\u0006\n\n\u0002\u0010>\u001a\u0004\b@\u00108R\u0016\u0010A\u001a\n\u0018\u00010Bj\u0004\u0018\u0001`CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010D\u001a\u00060Bj\u0002`C8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006~"}, m1599d2 = {"Landroidx/compose/foundation/text/input/internal/IntIntervalTree;", ExifInterface.GPS_DIRECTION_TRUE, "", FirebaseAnalytics.Param.SOURCE, "<init>", "(Landroidx/compose/foundation/text/input/internal/IntIntervalTree;)V", "value", "", "Landroidx/compose/foundation/text/input/internal/TreeColor;", "color", "Landroidx/compose/foundation/text/input/internal/Node;", "getColor-330cO7A", "(I)I", "setColor-9hnwElY", "(II)V", "parent", "getParent-bLpG9ms", "setParent-cfX_BQo", TtmlNode.LEFT, "getLeft-bLpG9ms", "setLeft-cfX_BQo", TtmlNode.RIGHT, "getRight-bLpG9ms", "setRight-cfX_BQo", TtmlNode.START, "getStart-330cO7A", "setStart-9hnwElY", TtmlNode.END, "getEnd-330cO7A", "setEnd-9hnwElY", "min", "getMin-330cO7A", "setMin-9hnwElY", "max", "getMax-330cO7A", "setMax-9hnwElY", "item", "getItem-330cO7A", "(I)Ljava/lang/Object;", "lowestNode", "lowestNode-bLpG9ms", "next", "next-bLpG9ms", "overlaps", "", "overlaps-XzpGiIY", "(III)Z", "Node", "Node-l-p996k", "(IILjava/lang/Object;I)I", FirebaseAnalytics.Param.ITEMS, "", "nodeInfo", "Landroidx/collection/MutableLongList;", "totalNodeCount", "getTotalNodeCount", "()I", "deletedNodeCount", "root", "getRoot-27flxzM", "setRoot-330cO7A", "(I)V", "I", "terminator", "getTerminator-27flxzM", "_tempArray", "Landroidx/collection/MutableIntList;", "Landroidx/compose/foundation/text/input/internal/NodeList;", "tempArray", "getTempArray", "()Landroidx/collection/MutableIntList;", "forEachIntervalInRange", "", "block", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "forAllIntervals", "clear", "cleanDeletedNodes", "forEachNodeInRange", "Lkotlin/Function1;", "forEachNodeMinMaxInRange", "mapIntervals", "mapper", "addInterval", "(Ljava/lang/Object;II)Z", "removeInterval", "findNode", "findNode-cKdZwxc", "(Ljava/lang/Object;II)I", "removeNode", TypedValues.AttributesType.S_TARGET, "cleanUp", "removeNode-9hnwElY", "(IZ)V", "transplant", "replacement", "transplant-cfX_BQo", "deleteNode", "node", "deleteNode-9hnwElY", "cleanDeletedNodesIfNeeded", "rebalanceAfterDeletion", "targetParent", "rebalanceAfterDeletion-cfX_BQo", "rebalanceAfterInsertion", "rebalanceAfterInsertion-330cO7A", "rotateLeft", "rotateLeft-330cO7A", "rotateRight", "rotateRight-330cO7A", "updateNodeMinMax", "updateNodeMinMax-330cO7A", "equals", "other", "hashCode", "copy", "isEmpty", "add", "add-ZlWbn38", "(Landroidx/collection/MutableIntList;I)V", "pop", "pop-2SV_EgM", "(Landroidx/collection/MutableIntList;)I", "Companion", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class IntIntervalTree<T> {
    private static final int COLOR_PARENT = 0;
    private static final int LEFT_RIGHT = 1;
    private static final int MIN_MAX = 3;
    private static final int NODE_CLEANUP_SIZE_THRESHOLD = 64;
    private static final int START_END = 2;
    private static final int STRIDE = 4;
    private MutableIntList _tempArray;
    private int deletedNodeCount;
    private final List<T> items;
    private final MutableLongList nodeInfo;
    private int root;
    private final int terminator;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public IntIntervalTree() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public IntIntervalTree(IntIntervalTree<T> intIntervalTree) {
        if (intIntervalTree != null) {
            this.items = CollectionsKt.toMutableList((Collection) intIntervalTree.items);
            MutableLongList mutableLongList = new MutableLongList(intIntervalTree.nodeInfo._size);
            mutableLongList.addAll(mutableLongList._size, intIntervalTree.nodeInfo);
            this.nodeInfo = mutableLongList;
            this.terminator = intIntervalTree.terminator;
            this.root = intIntervalTree.root;
            this.deletedNodeCount = intIntervalTree.deletedNodeCount;
            return;
        }
        this.items = new ArrayList();
        this.nodeInfo = new MutableLongList(0, 1, null);
        int iM3711Nodelp996k = m3711Nodelp996k(Integer.MAX_VALUE, Integer.MIN_VALUE, null, 1);
        this.terminator = iM3711Nodelp996k;
        this.root = iM3711Nodelp996k;
        this.deletedNodeCount = 0;
    }

    public /* synthetic */ IntIntervalTree(IntIntervalTree intIntervalTree, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : intIntervalTree);
    }

    /* JADX INFO: renamed from: getColor-330cO7A, reason: not valid java name */
    public final int m3726getColor330cO7A(int i) {
        return (int) (this.nodeInfo.get(i) >> 32);
    }

    /* JADX INFO: renamed from: setColor-9hnwElY, reason: not valid java name */
    public final void m3740setColor9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        mutableLongList.set(i, (((long) ((int) (mutableLongList.get(i) & 4294967295L))) & 4294967295L) | (((long) i2) << 32));
    }

    /* JADX INFO: renamed from: getParent-bLpG9ms, reason: not valid java name */
    public final int m3731getParentbLpG9ms(int i) {
        return Node.m3753constructorimpl((int) (this.nodeInfo.get(i) & 4294967295L));
    }

    /* JADX INFO: renamed from: setParent-cfX_BQo, reason: not valid java name */
    public final void m3745setParentcfX_BQo(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        mutableLongList.set(i, (((long) ((int) (mutableLongList.get(i) >> 32))) << 32) | (((long) i2) & 4294967295L));
    }

    /* JADX INFO: renamed from: getLeft-bLpG9ms, reason: not valid java name */
    public final int m3728getLeftbLpG9ms(int i) {
        return Node.m3753constructorimpl((int) (this.nodeInfo.get(i + 1) >> 32));
    }

    /* JADX INFO: renamed from: setLeft-cfX_BQo, reason: not valid java name */
    public final void m3742setLeftcfX_BQo(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 1;
        mutableLongList.set(i3, (((long) ((int) (mutableLongList.get(i3) & 4294967295L))) & 4294967295L) | (((long) i2) << 32));
    }

    /* JADX INFO: renamed from: getRight-bLpG9ms, reason: not valid java name */
    public final int m3732getRightbLpG9ms(int i) {
        return Node.m3753constructorimpl((int) (this.nodeInfo.get(i + 1) & 4294967295L));
    }

    /* JADX INFO: renamed from: setRight-cfX_BQo, reason: not valid java name */
    public final void m3746setRightcfX_BQo(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 1;
        mutableLongList.set(i3, (((long) ((int) (mutableLongList.get(i3) >> 32))) << 32) | (((long) i2) & 4294967295L));
    }

    /* JADX INFO: renamed from: getStart-330cO7A, reason: not valid java name */
    public final int m3734getStart330cO7A(int i) {
        return (int) (this.nodeInfo.get(i + 2) >> 32);
    }

    /* JADX INFO: renamed from: setStart-9hnwElY, reason: not valid java name */
    public final void m3748setStart9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 2;
        mutableLongList.set(i3, (((long) ((int) (mutableLongList.get(i3) & 4294967295L))) & 4294967295L) | (((long) i2) << 32));
    }

    /* JADX INFO: renamed from: getEnd-330cO7A, reason: not valid java name */
    public final int m3727getEnd330cO7A(int i) {
        return (int) (this.nodeInfo.get(i + 2) & 4294967295L);
    }

    /* JADX INFO: renamed from: setEnd-9hnwElY, reason: not valid java name */
    public final void m3741setEnd9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 2;
        mutableLongList.set(i3, (((long) ((int) (mutableLongList.get(i3) >> 32))) << 32) | (((long) i2) & 4294967295L));
    }

    /* JADX INFO: renamed from: getMin-330cO7A, reason: not valid java name */
    public final int m3730getMin330cO7A(int i) {
        return (int) (this.nodeInfo.get(i + 3) >> 32);
    }

    /* JADX INFO: renamed from: setMin-9hnwElY, reason: not valid java name */
    public final void m3744setMin9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 3;
        mutableLongList.set(i3, (((long) ((int) (mutableLongList.get(i3) & 4294967295L))) & 4294967295L) | (((long) i2) << 32));
    }

    /* JADX INFO: renamed from: getMax-330cO7A, reason: not valid java name */
    public final int m3729getMax330cO7A(int i) {
        return (int) (this.nodeInfo.get(i + 3) & 4294967295L);
    }

    /* JADX INFO: renamed from: setMax-9hnwElY, reason: not valid java name */
    public final void m3743setMax9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 3;
        mutableLongList.set(i3, (((long) ((int) (mutableLongList.get(i3) >> 32))) << 32) | (((long) i2) & 4294967295L));
    }

    /* JADX INFO: renamed from: getItem-330cO7A, reason: not valid java name */
    private final T m3716getItem330cO7A(int i) {
        return this.items.get(i / 4);
    }

    /* JADX INFO: renamed from: lowestNode-bLpG9ms, reason: not valid java name */
    public final int m3736lowestNodebLpG9ms(int i) {
        while (!Node.m3755equalsimpl0(m3728getLeftbLpG9ms(i), this.terminator)) {
            i = m3728getLeftbLpG9ms(i);
        }
        return i;
    }

    /* JADX INFO: renamed from: next-bLpG9ms, reason: not valid java name */
    public final int m3737nextbLpG9ms(int i) {
        if (!Node.m3755equalsimpl0(m3732getRightbLpG9ms(i), this.terminator)) {
            return m3736lowestNodebLpG9ms(m3732getRightbLpG9ms(i));
        }
        int iM3731getParentbLpG9ms = m3731getParentbLpG9ms(i);
        while (true) {
            int i2 = iM3731getParentbLpG9ms;
            int i3 = i;
            i = i2;
            if (Node.m3755equalsimpl0(i, this.terminator) || !Node.m3755equalsimpl0(i3, m3732getRightbLpG9ms(i))) {
                break;
            }
            iM3731getParentbLpG9ms = m3731getParentbLpG9ms(i);
        }
        return i;
    }

    /* JADX INFO: renamed from: overlaps-XzpGiIY, reason: not valid java name */
    public final boolean m3738overlapsXzpGiIY(int i, int i2, int i3) {
        return IntIntervalTreeKt.intersect(i2, i3, m3734getStart330cO7A(i), m3727getEnd330cO7A(i));
    }

    /* JADX INFO: renamed from: Node-l-p996k$default, reason: not valid java name */
    static /* synthetic */ int m3712Nodelp996k$default(IntIntervalTree intIntervalTree, int i, int i2, Object obj, int i3, int i4, Object obj2) {
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return intIntervalTree.m3711Nodelp996k(i, i2, obj, i3);
    }

    /* JADX INFO: renamed from: Node-l-p996k, reason: not valid java name */
    private final int m3711Nodelp996k(int start, int end, T item, int color) {
        int i = this.nodeInfo._size;
        this.nodeInfo.add((((long) color) << 32) | (((long) 0) & 4294967295L));
        this.nodeInfo.add(0L);
        long j = (((long) end) & 4294967295L) | (((long) start) << 32);
        this.nodeInfo.add(j);
        this.nodeInfo.add(j);
        this.items.add(item);
        return Node.m3753constructorimpl(i);
    }

    private final int getTotalNodeCount() {
        return this.nodeInfo._size / 4;
    }

    /* JADX INFO: renamed from: getRoot-27flxzM, reason: not valid java name and from getter */
    public final int getRoot() {
        return this.root;
    }

    /* JADX INFO: renamed from: setRoot-330cO7A, reason: not valid java name */
    public final void m3747setRoot330cO7A(int i) {
        this.root = i;
    }

    /* JADX INFO: renamed from: getTerminator-27flxzM, reason: not valid java name and from getter */
    public final int getTerminator() {
        return this.terminator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableIntList getTempArray() {
        MutableIntList mutableIntList = this._tempArray;
        if (mutableIntList != null) {
            return mutableIntList;
        }
        MutableIntList mutableIntList2 = new MutableIntList(0, 1, null);
        this._tempArray = mutableIntList2;
        return mutableIntList2;
    }

    public final void forEachIntervalInRange(int start, int end, Function3<? super T, ? super Integer, ? super Integer, Unit> block) {
        MutableIntList tempArray = getTempArray();
        if (!Node.m3755equalsimpl0(getRoot(), getTerminator()) && m3729getMax330cO7A(getRoot()) >= start && m3730getMin330cO7A(getRoot()) <= end) {
            int root = getRoot();
            loop0: while (true) {
                char c = 0;
                while (!Node.m3755equalsimpl0(root, getTerminator())) {
                    if (c != 0) {
                        if (c == 1) {
                            int iM3753constructorimpl = Node.m3753constructorimpl(root);
                            if (m3738overlapsXzpGiIY(iM3753constructorimpl, start, end)) {
                                tempArray.add(iM3753constructorimpl);
                            }
                            if (Node.m3755equalsimpl0(m3732getRightbLpG9ms(root), getTerminator()) || m3729getMax330cO7A(m3732getRightbLpG9ms(root)) < start || m3730getMin330cO7A(m3732getRightbLpG9ms(root)) > end) {
                                c = 2;
                            } else {
                                root = m3732getRightbLpG9ms(root);
                            }
                        } else if (c == 2) {
                            if (!Node.m3755equalsimpl0(m3731getParentbLpG9ms(root), getTerminator())) {
                                c = Node.m3755equalsimpl0(root, m3728getLeftbLpG9ms(m3731getParentbLpG9ms(root))) ? (char) 1 : (char) 2;
                            }
                            root = m3731getParentbLpG9ms(root);
                        }
                    } else if (Node.m3755equalsimpl0(m3728getLeftbLpG9ms(root), getTerminator()) || m3729getMax330cO7A(m3728getLeftbLpG9ms(root)) < start) {
                        c = 1;
                    } else {
                        root = m3728getLeftbLpG9ms(root);
                    }
                }
                break loop0;
            }
        }
        tempArray.sort();
        MutableIntList mutableIntList = tempArray;
        int[] iArr = mutableIntList.content;
        int i = mutableIntList._size;
        for (int i2 = 0; i2 < i; i2++) {
            int iM3753constructorimpl2 = Node.m3753constructorimpl(iArr[i2]);
            T tM3716getItem330cO7A = m3716getItem330cO7A(iM3753constructorimpl2);
            if (tM3716getItem330cO7A != null) {
                block.invoke(tM3716getItem330cO7A, Integer.valueOf(m3734getStart330cO7A(iM3753constructorimpl2)), Integer.valueOf(m3727getEnd330cO7A(iM3753constructorimpl2)));
            }
        }
        tempArray.clear();
    }

    public final void forAllIntervals(Function3<? super T, ? super Integer, ? super Integer, Unit> block) {
        if (Node.m3755equalsimpl0(this.root, this.terminator)) {
            return;
        }
        for (int i = 4; i < this.nodeInfo._size; i += 4) {
            int iM3753constructorimpl = Node.m3753constructorimpl(i);
            if (m3726getColor330cO7A(iM3753constructorimpl) != 2) {
                int iM3734getStart330cO7A = m3734getStart330cO7A(iM3753constructorimpl);
                int iM3727getEnd330cO7A = m3727getEnd330cO7A(iM3753constructorimpl);
                T tM3716getItem330cO7A = m3716getItem330cO7A(iM3753constructorimpl);
                if (tM3716getItem330cO7A != null) {
                    block.invoke(tM3716getItem330cO7A, Integer.valueOf(iM3734getStart330cO7A), Integer.valueOf(iM3727getEnd330cO7A));
                }
            }
        }
    }

    public final void clear() {
        this.root = this.terminator;
        MutableLongList mutableLongList = this.nodeInfo;
        mutableLongList.removeRange(4, mutableLongList._size);
        List<T> list = this.items;
        list.subList(1, list.size()).clear();
        this.deletedNodeCount = 0;
    }

    private final void cleanDeletedNodes() {
        int i;
        if (this.deletedNodeCount == 0) {
            return;
        }
        MutableIntList tempArray = getTempArray();
        tempArray.ensureCapacity(getTotalNodeCount());
        int totalNodeCount = getTotalNodeCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = 4;
            if (i2 >= totalNodeCount) {
                break;
            }
            if (((int) (this.nodeInfo.get(i2 * 4) >> 32)) == 2) {
                i3++;
            }
            tempArray.add((i2 - i3) * 4);
            i2++;
        }
        this.root = Node.m3753constructorimpl(cleanDeletedNodes$map(tempArray, this.root));
        int i4 = 4;
        while (i < this.nodeInfo._size) {
            if (((int) (this.nodeInfo.get(i) >> 32)) == 2) {
                i += 4;
            } else {
                if (i4 != i) {
                    long j = this.nodeInfo.get(i);
                    this.nodeInfo.set(i4, (((long) ((int) (j >> 32))) << 32) | (((long) cleanDeletedNodes$map(tempArray, (int) (j & 4294967295L))) & 4294967295L));
                    long j2 = this.nodeInfo.get(i + 1);
                    this.nodeInfo.set(i4 + 1, (((long) cleanDeletedNodes$map(tempArray, (int) (j2 & 4294967295L))) & 4294967295L) | (((long) cleanDeletedNodes$map(tempArray, (int) (j2 >> 32))) << 32));
                    MutableLongList mutableLongList = this.nodeInfo;
                    mutableLongList.set(i4 + 2, mutableLongList.get(i + 2));
                    MutableLongList mutableLongList2 = this.nodeInfo;
                    mutableLongList2.set(i4 + 3, mutableLongList2.get(i + 3));
                    List<T> list = this.items;
                    list.set(i4 / 4, list.get(i / 4));
                } else {
                    long j3 = this.nodeInfo.get(i);
                    this.nodeInfo.set(i4, (((long) ((int) (j3 >> 32))) << 32) | (((long) cleanDeletedNodes$map(tempArray, (int) (j3 & 4294967295L))) & 4294967295L));
                    long j4 = this.nodeInfo.get(i + 1);
                    this.nodeInfo.set(i4 + 1, (((long) cleanDeletedNodes$map(tempArray, (int) (j4 >> 32))) << 32) | (((long) cleanDeletedNodes$map(tempArray, (int) (j4 & 4294967295L))) & 4294967295L));
                }
                i += 4;
                i4 += 4;
            }
        }
        MutableLongList mutableLongList3 = this.nodeInfo;
        mutableLongList3.removeRange(i4, mutableLongList3._size);
        List<T> list2 = this.items;
        list2.subList(list2.size() - this.deletedNodeCount, this.items.size()).clear();
        this.deletedNodeCount = 0;
        tempArray.clear();
    }

    private static final int cleanDeletedNodes$map(MutableIntList mutableIntList, int i) {
        return mutableIntList.get(i / 4);
    }

    private final void forEachNodeMinMaxInRange(int start, int end, Function1<? super Integer, Unit> block) {
        if (Node.m3755equalsimpl0(getRoot(), getTerminator()) || m3729getMax330cO7A(getRoot()) < start || m3730getMin330cO7A(getRoot()) > end) {
            return;
        }
        int root = getRoot();
        while (true) {
            char c = 0;
            while (!Node.m3755equalsimpl0(root, getTerminator())) {
                if (c != 0) {
                    if (c == 1) {
                        block.invoke(Integer.valueOf(root));
                        if (Node.m3755equalsimpl0(m3732getRightbLpG9ms(root), getTerminator()) || m3729getMax330cO7A(m3732getRightbLpG9ms(root)) < start || m3730getMin330cO7A(m3732getRightbLpG9ms(root)) > end) {
                            c = 2;
                        } else {
                            root = m3732getRightbLpG9ms(root);
                        }
                    } else if (c == 2) {
                        if (!Node.m3755equalsimpl0(m3731getParentbLpG9ms(root), getTerminator())) {
                            c = Node.m3755equalsimpl0(root, m3728getLeftbLpG9ms(m3731getParentbLpG9ms(root))) ? (char) 1 : (char) 2;
                        }
                        root = m3731getParentbLpG9ms(root);
                    }
                } else if (Node.m3755equalsimpl0(m3728getLeftbLpG9ms(root), getTerminator()) || m3729getMax330cO7A(m3728getLeftbLpG9ms(root)) < start) {
                    c = 1;
                } else {
                    root = m3728getLeftbLpG9ms(root);
                }
            }
            return;
        }
    }

    static /* synthetic */ void forEachNodeMinMaxInRange$default(IntIntervalTree intIntervalTree, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i;
        }
        if (Node.m3755equalsimpl0(intIntervalTree.getRoot(), intIntervalTree.getTerminator()) || intIntervalTree.m3729getMax330cO7A(intIntervalTree.getRoot()) < i || intIntervalTree.m3730getMin330cO7A(intIntervalTree.getRoot()) > i2) {
            return;
        }
        int root = intIntervalTree.getRoot();
        while (true) {
            char c = 0;
            while (!Node.m3755equalsimpl0(root, intIntervalTree.getTerminator())) {
                if (c != 0) {
                    if (c == 1) {
                        function1.invoke(Integer.valueOf(root));
                        if (Node.m3755equalsimpl0(intIntervalTree.m3732getRightbLpG9ms(root), intIntervalTree.getTerminator()) || intIntervalTree.m3729getMax330cO7A(intIntervalTree.m3732getRightbLpG9ms(root)) < i || intIntervalTree.m3730getMin330cO7A(intIntervalTree.m3732getRightbLpG9ms(root)) > i2) {
                            c = 2;
                        } else {
                            root = intIntervalTree.m3732getRightbLpG9ms(root);
                        }
                    } else if (c == 2) {
                        if (!Node.m3755equalsimpl0(intIntervalTree.m3731getParentbLpG9ms(root), intIntervalTree.getTerminator())) {
                            c = Node.m3755equalsimpl0(root, intIntervalTree.m3728getLeftbLpG9ms(intIntervalTree.m3731getParentbLpG9ms(root))) ? (char) 1 : (char) 2;
                        }
                        root = intIntervalTree.m3731getParentbLpG9ms(root);
                    }
                } else if (Node.m3755equalsimpl0(intIntervalTree.m3728getLeftbLpG9ms(root), intIntervalTree.getTerminator()) || intIntervalTree.m3729getMax330cO7A(intIntervalTree.m3728getLeftbLpG9ms(root)) < i) {
                    c = 1;
                } else {
                    root = intIntervalTree.m3728getLeftbLpG9ms(root);
                }
            }
            return;
        }
    }

    public final void mapIntervals(int start, int end, Function1<? super Integer, Integer> mapper) {
        MutableIntList tempArray = getTempArray();
        if (!Node.m3755equalsimpl0(getRoot(), getTerminator()) && m3729getMax330cO7A(getRoot()) >= start && m3730getMin330cO7A(getRoot()) <= end) {
            int root = getRoot();
            loop0: while (true) {
                char c = 0;
                while (!Node.m3755equalsimpl0(root, getTerminator())) {
                    if (c != 0) {
                        if (c == 1) {
                            int iM3753constructorimpl = Node.m3753constructorimpl(root);
                            m3748setStart9hnwElY(iM3753constructorimpl, mapper.invoke(Integer.valueOf(m3734getStart330cO7A(iM3753constructorimpl))).intValue());
                            m3741setEnd9hnwElY(iM3753constructorimpl, mapper.invoke(Integer.valueOf(m3727getEnd330cO7A(iM3753constructorimpl))).intValue());
                            m3744setMin9hnwElY(iM3753constructorimpl, mapper.invoke(Integer.valueOf(m3730getMin330cO7A(iM3753constructorimpl))).intValue());
                            m3743setMax9hnwElY(iM3753constructorimpl, mapper.invoke(Integer.valueOf(m3729getMax330cO7A(iM3753constructorimpl))).intValue());
                            if (m3727getEnd330cO7A(iM3753constructorimpl) <= m3734getStart330cO7A(iM3753constructorimpl)) {
                                m3725addZlWbn38(tempArray, iM3753constructorimpl);
                            }
                            if (Node.m3755equalsimpl0(m3732getRightbLpG9ms(root), getTerminator()) || m3729getMax330cO7A(m3732getRightbLpG9ms(root)) < start || m3730getMin330cO7A(m3732getRightbLpG9ms(root)) > end) {
                                c = 2;
                            } else {
                                root = m3732getRightbLpG9ms(root);
                            }
                        } else if (c == 2) {
                            if (!Node.m3755equalsimpl0(m3731getParentbLpG9ms(root), getTerminator())) {
                                c = Node.m3755equalsimpl0(root, m3728getLeftbLpG9ms(m3731getParentbLpG9ms(root))) ? (char) 1 : (char) 2;
                            }
                            root = m3731getParentbLpG9ms(root);
                        }
                    } else if (Node.m3755equalsimpl0(m3728getLeftbLpG9ms(root), getTerminator()) || m3729getMax330cO7A(m3728getLeftbLpG9ms(root)) < start) {
                        c = 1;
                    } else {
                        root = m3728getLeftbLpG9ms(root);
                    }
                }
                break loop0;
            }
        }
        MutableIntList mutableIntList = tempArray;
        int[] iArr = mutableIntList.content;
        int i = mutableIntList._size;
        for (int i2 = 0; i2 < i; i2++) {
            m3719removeNode9hnwElY(Node.m3753constructorimpl(iArr[i2]), false);
        }
        tempArray.clear();
        cleanDeletedNodesIfNeeded();
    }

    public final boolean addInterval(T item, int start, int end) {
        int iM3732getRightbLpG9ms;
        if (start >= end || !Node.m3755equalsimpl0(m3715findNodecKdZwxc(item, start, end), this.terminator)) {
            return false;
        }
        int iM3711Nodelp996k = m3711Nodelp996k(start, end, item, 0);
        int i = this.root;
        int i2 = this.terminator;
        while (!Node.m3755equalsimpl0(i, this.terminator)) {
            if (m3734getStart330cO7A(iM3711Nodelp996k) <= m3734getStart330cO7A(i)) {
                iM3732getRightbLpG9ms = m3728getLeftbLpG9ms(i);
            } else {
                iM3732getRightbLpG9ms = m3732getRightbLpG9ms(i);
            }
            int i3 = iM3732getRightbLpG9ms;
            i2 = i;
            i = i3;
        }
        m3745setParentcfX_BQo(iM3711Nodelp996k, i2);
        if (Node.m3755equalsimpl0(i2, this.terminator)) {
            this.root = iM3711Nodelp996k;
        } else if (m3734getStart330cO7A(iM3711Nodelp996k) <= m3734getStart330cO7A(i2)) {
            m3742setLeftcfX_BQo(i2, iM3711Nodelp996k);
        } else {
            m3746setRightcfX_BQo(i2, iM3711Nodelp996k);
        }
        m3724updateNodeMinMax330cO7A(i2);
        m3718rebalanceAfterInsertion330cO7A(iM3711Nodelp996k);
        return true;
    }

    public final boolean removeInterval(T item, int start, int end) {
        if (start >= end) {
            return false;
        }
        int iM3715findNodecKdZwxc = m3715findNodecKdZwxc(item, start, end);
        if (Node.m3755equalsimpl0(iM3715findNodecKdZwxc, this.terminator)) {
            return false;
        }
        m3720removeNode9hnwElY$default(this, iM3715findNodecKdZwxc, false, 2, null);
        return true;
    }

    /* JADX INFO: renamed from: findNode-cKdZwxc, reason: not valid java name */
    private final int m3715findNodecKdZwxc(T item, int start, int end) {
        if (Node.m3755equalsimpl0(this.root, this.terminator) || m3729getMax330cO7A(this.root) < end || m3730getMin330cO7A(this.root) > start) {
            return this.terminator;
        }
        MutableIntList tempArray = getTempArray();
        m3725addZlWbn38(tempArray, this.root);
        while (tempArray._size != 0) {
            int iM3739pop2SV_EgM = m3739pop2SV_EgM(tempArray);
            if (m3734getStart330cO7A(iM3739pop2SV_EgM) == start && m3727getEnd330cO7A(iM3739pop2SV_EgM) == end && Intrinsics.areEqual(m3716getItem330cO7A(iM3739pop2SV_EgM), item)) {
                tempArray.clear();
                return iM3739pop2SV_EgM;
            }
            if (m3734getStart330cO7A(iM3739pop2SV_EgM) >= start) {
                int iM3728getLeftbLpG9ms = m3728getLeftbLpG9ms(iM3739pop2SV_EgM);
                if (!Node.m3755equalsimpl0(iM3728getLeftbLpG9ms, this.terminator) && m3729getMax330cO7A(iM3728getLeftbLpG9ms) >= end) {
                    m3725addZlWbn38(tempArray, iM3728getLeftbLpG9ms);
                }
            }
            if (m3734getStart330cO7A(iM3739pop2SV_EgM) <= start) {
                int iM3732getRightbLpG9ms = m3732getRightbLpG9ms(iM3739pop2SV_EgM);
                if (!Node.m3755equalsimpl0(iM3732getRightbLpG9ms, this.terminator) && m3730getMin330cO7A(iM3732getRightbLpG9ms) <= start && m3729getMax330cO7A(iM3732getRightbLpG9ms) >= end) {
                    m3725addZlWbn38(tempArray, iM3732getRightbLpG9ms);
                }
            }
        }
        return this.terminator;
    }

    /* JADX INFO: renamed from: removeNode-9hnwElY$default, reason: not valid java name */
    static /* synthetic */ void m3720removeNode9hnwElY$default(IntIntervalTree intIntervalTree, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        intIntervalTree.m3719removeNode9hnwElY(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: removeNode-9hnwElY, reason: not valid java name */
    public final void m3719removeNode9hnwElY(int target, boolean cleanUp) {
        int iM3731getParentbLpG9ms;
        int iM3728getLeftbLpG9ms;
        int iM3731getParentbLpG9ms2;
        int iM3726getColor330cO7A = m3726getColor330cO7A(target);
        if (Node.m3755equalsimpl0(m3728getLeftbLpG9ms(target), this.terminator)) {
            iM3728getLeftbLpG9ms = m3732getRightbLpG9ms(target);
            iM3731getParentbLpG9ms2 = m3731getParentbLpG9ms(target);
            m3723transplantcfX_BQo(target, m3732getRightbLpG9ms(target));
        } else if (Node.m3755equalsimpl0(m3732getRightbLpG9ms(target), this.terminator)) {
            iM3728getLeftbLpG9ms = m3728getLeftbLpG9ms(target);
            iM3731getParentbLpG9ms2 = m3731getParentbLpG9ms(target);
            m3723transplantcfX_BQo(target, m3728getLeftbLpG9ms(target));
        } else {
            int iM3736lowestNodebLpG9ms = m3736lowestNodebLpG9ms(m3732getRightbLpG9ms(target));
            int iM3726getColor330cO7A2 = m3726getColor330cO7A(iM3736lowestNodebLpG9ms);
            int iM3732getRightbLpG9ms = m3732getRightbLpG9ms(iM3736lowestNodebLpG9ms);
            if (Node.m3755equalsimpl0(m3731getParentbLpG9ms(iM3736lowestNodebLpG9ms), target)) {
                iM3731getParentbLpG9ms = iM3736lowestNodebLpG9ms;
            } else {
                iM3731getParentbLpG9ms = m3731getParentbLpG9ms(iM3736lowestNodebLpG9ms);
                m3723transplantcfX_BQo(iM3736lowestNodebLpG9ms, m3732getRightbLpG9ms(iM3736lowestNodebLpG9ms));
                m3746setRightcfX_BQo(iM3736lowestNodebLpG9ms, m3732getRightbLpG9ms(target));
                m3745setParentcfX_BQo(m3732getRightbLpG9ms(iM3736lowestNodebLpG9ms), iM3736lowestNodebLpG9ms);
            }
            m3723transplantcfX_BQo(target, iM3736lowestNodebLpG9ms);
            m3742setLeftcfX_BQo(iM3736lowestNodebLpG9ms, m3728getLeftbLpG9ms(target));
            m3745setParentcfX_BQo(m3728getLeftbLpG9ms(iM3736lowestNodebLpG9ms), iM3736lowestNodebLpG9ms);
            m3740setColor9hnwElY(iM3736lowestNodebLpG9ms, m3726getColor330cO7A(target));
            m3744setMin9hnwElY(iM3736lowestNodebLpG9ms, m3730getMin330cO7A(target));
            m3743setMax9hnwElY(iM3736lowestNodebLpG9ms, m3729getMax330cO7A(target));
            iM3726getColor330cO7A = iM3726getColor330cO7A2;
            iM3728getLeftbLpG9ms = iM3732getRightbLpG9ms;
            iM3731getParentbLpG9ms2 = iM3731getParentbLpG9ms;
        }
        m3724updateNodeMinMax330cO7A(iM3731getParentbLpG9ms2);
        if (iM3726getColor330cO7A == 1) {
            m3717rebalanceAfterDeletioncfX_BQo(iM3728getLeftbLpG9ms, iM3731getParentbLpG9ms2);
        }
        m3714deleteNode9hnwElY(target, cleanUp);
    }

    /* JADX INFO: renamed from: transplant-cfX_BQo, reason: not valid java name */
    private final void m3723transplantcfX_BQo(int target, int replacement) {
        if (Node.m3755equalsimpl0(target, replacement)) {
            return;
        }
        if (Node.m3755equalsimpl0(m3731getParentbLpG9ms(target), this.terminator)) {
            this.root = replacement;
        } else if (Node.m3755equalsimpl0(target, m3728getLeftbLpG9ms(m3731getParentbLpG9ms(target)))) {
            m3742setLeftcfX_BQo(m3731getParentbLpG9ms(target), replacement);
        } else {
            m3746setRightcfX_BQo(m3731getParentbLpG9ms(target), replacement);
        }
        if (Node.m3755equalsimpl0(replacement, this.terminator)) {
            return;
        }
        m3745setParentcfX_BQo(replacement, m3731getParentbLpG9ms(target));
    }

    /* JADX INFO: renamed from: deleteNode-9hnwElY, reason: not valid java name */
    private final void m3714deleteNode9hnwElY(int node, boolean cleanUp) {
        m3740setColor9hnwElY(node, 2);
        this.deletedNodeCount++;
        if (cleanUp) {
            cleanDeletedNodesIfNeeded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanDeletedNodesIfNeeded() {
        if (getTotalNodeCount() <= 64 || this.deletedNodeCount < getTotalNodeCount() / 2) {
            return;
        }
        cleanDeletedNodes();
    }

    /* JADX INFO: renamed from: rebalanceAfterDeletion-cfX_BQo, reason: not valid java name */
    private final void m3717rebalanceAfterDeletioncfX_BQo(int target, int targetParent) {
        int iM3731getParentbLpG9ms;
        while (!Node.m3755equalsimpl0(target, this.root) && m3726getColor330cO7A(target) == 1) {
            if (Node.m3755equalsimpl0(target, m3728getLeftbLpG9ms(targetParent))) {
                int iM3732getRightbLpG9ms = m3732getRightbLpG9ms(targetParent);
                if (m3726getColor330cO7A(iM3732getRightbLpG9ms) == 0) {
                    m3740setColor9hnwElY(iM3732getRightbLpG9ms, 1);
                    m3740setColor9hnwElY(targetParent, 0);
                    m3721rotateLeft330cO7A(targetParent);
                    iM3732getRightbLpG9ms = m3732getRightbLpG9ms(targetParent);
                }
                if (m3726getColor330cO7A(m3728getLeftbLpG9ms(iM3732getRightbLpG9ms)) == 1 && m3726getColor330cO7A(m3732getRightbLpG9ms(iM3732getRightbLpG9ms)) == 1) {
                    m3740setColor9hnwElY(iM3732getRightbLpG9ms, 0);
                    iM3731getParentbLpG9ms = m3731getParentbLpG9ms(targetParent);
                    int i = targetParent;
                    targetParent = iM3731getParentbLpG9ms;
                    target = i;
                } else {
                    if (m3726getColor330cO7A(m3732getRightbLpG9ms(iM3732getRightbLpG9ms)) == 1) {
                        m3740setColor9hnwElY(m3728getLeftbLpG9ms(iM3732getRightbLpG9ms), 1);
                        m3740setColor9hnwElY(iM3732getRightbLpG9ms, 0);
                        m3722rotateRight330cO7A(iM3732getRightbLpG9ms);
                        iM3732getRightbLpG9ms = m3732getRightbLpG9ms(targetParent);
                    }
                    m3740setColor9hnwElY(iM3732getRightbLpG9ms, m3726getColor330cO7A(targetParent));
                    m3740setColor9hnwElY(targetParent, 1);
                    m3740setColor9hnwElY(m3732getRightbLpG9ms(iM3732getRightbLpG9ms), 1);
                    m3721rotateLeft330cO7A(targetParent);
                    target = this.root;
                }
            } else {
                int iM3728getLeftbLpG9ms = m3728getLeftbLpG9ms(targetParent);
                if (m3726getColor330cO7A(iM3728getLeftbLpG9ms) == 0) {
                    m3740setColor9hnwElY(iM3728getLeftbLpG9ms, 1);
                    m3740setColor9hnwElY(targetParent, 0);
                    m3722rotateRight330cO7A(targetParent);
                    iM3728getLeftbLpG9ms = m3728getLeftbLpG9ms(targetParent);
                }
                if (m3726getColor330cO7A(m3732getRightbLpG9ms(iM3728getLeftbLpG9ms)) == 1 && m3726getColor330cO7A(m3728getLeftbLpG9ms(iM3728getLeftbLpG9ms)) == 1) {
                    m3740setColor9hnwElY(iM3728getLeftbLpG9ms, 0);
                    iM3731getParentbLpG9ms = m3731getParentbLpG9ms(targetParent);
                    int i2 = targetParent;
                    targetParent = iM3731getParentbLpG9ms;
                    target = i2;
                } else {
                    if (m3726getColor330cO7A(m3728getLeftbLpG9ms(iM3728getLeftbLpG9ms)) == 1) {
                        m3740setColor9hnwElY(m3732getRightbLpG9ms(iM3728getLeftbLpG9ms), 1);
                        m3740setColor9hnwElY(iM3728getLeftbLpG9ms, 0);
                        m3721rotateLeft330cO7A(iM3728getLeftbLpG9ms);
                        iM3728getLeftbLpG9ms = m3728getLeftbLpG9ms(targetParent);
                    }
                    m3740setColor9hnwElY(iM3728getLeftbLpG9ms, m3726getColor330cO7A(targetParent));
                    m3740setColor9hnwElY(targetParent, 1);
                    m3740setColor9hnwElY(m3728getLeftbLpG9ms(iM3728getLeftbLpG9ms), 1);
                    m3722rotateRight330cO7A(targetParent);
                    target = this.root;
                }
            }
        }
        m3740setColor9hnwElY(target, 1);
    }

    /* JADX INFO: renamed from: rebalanceAfterInsertion-330cO7A, reason: not valid java name */
    private final void m3718rebalanceAfterInsertion330cO7A(int target) {
        while (!Node.m3755equalsimpl0(target, this.root) && m3726getColor330cO7A(m3731getParentbLpG9ms(target)) == 0) {
            int iM3731getParentbLpG9ms = m3731getParentbLpG9ms(m3731getParentbLpG9ms(target));
            if (Node.m3755equalsimpl0(m3731getParentbLpG9ms(target), m3728getLeftbLpG9ms(iM3731getParentbLpG9ms))) {
                int iM3732getRightbLpG9ms = m3732getRightbLpG9ms(iM3731getParentbLpG9ms);
                if (m3726getColor330cO7A(iM3732getRightbLpG9ms) == 0) {
                    m3740setColor9hnwElY(iM3732getRightbLpG9ms, 1);
                    m3740setColor9hnwElY(m3731getParentbLpG9ms(target), 1);
                    m3740setColor9hnwElY(iM3731getParentbLpG9ms, 0);
                    target = iM3731getParentbLpG9ms;
                } else {
                    if (Node.m3755equalsimpl0(target, m3732getRightbLpG9ms(m3731getParentbLpG9ms(target)))) {
                        target = m3731getParentbLpG9ms(target);
                        m3721rotateLeft330cO7A(target);
                    }
                    m3740setColor9hnwElY(m3731getParentbLpG9ms(target), 1);
                    m3740setColor9hnwElY(iM3731getParentbLpG9ms, 0);
                    m3722rotateRight330cO7A(iM3731getParentbLpG9ms);
                }
            } else {
                int iM3728getLeftbLpG9ms = m3728getLeftbLpG9ms(iM3731getParentbLpG9ms);
                if (m3726getColor330cO7A(iM3728getLeftbLpG9ms) == 0) {
                    m3740setColor9hnwElY(iM3728getLeftbLpG9ms, 1);
                    m3740setColor9hnwElY(m3731getParentbLpG9ms(target), 1);
                    m3740setColor9hnwElY(iM3731getParentbLpG9ms, 0);
                    target = iM3731getParentbLpG9ms;
                } else {
                    if (Node.m3755equalsimpl0(target, m3728getLeftbLpG9ms(m3731getParentbLpG9ms(target)))) {
                        target = m3731getParentbLpG9ms(target);
                        m3722rotateRight330cO7A(target);
                    }
                    m3740setColor9hnwElY(m3731getParentbLpG9ms(target), 1);
                    m3740setColor9hnwElY(iM3731getParentbLpG9ms, 0);
                    m3721rotateLeft330cO7A(iM3731getParentbLpG9ms);
                }
            }
        }
        m3740setColor9hnwElY(this.root, 1);
    }

    /* JADX INFO: renamed from: rotateLeft-330cO7A, reason: not valid java name */
    private final void m3721rotateLeft330cO7A(int node) {
        int iM3732getRightbLpG9ms = m3732getRightbLpG9ms(node);
        m3746setRightcfX_BQo(node, m3728getLeftbLpG9ms(iM3732getRightbLpG9ms));
        if (!Node.m3755equalsimpl0(m3728getLeftbLpG9ms(iM3732getRightbLpG9ms), this.terminator)) {
            m3745setParentcfX_BQo(m3728getLeftbLpG9ms(iM3732getRightbLpG9ms), node);
        }
        m3745setParentcfX_BQo(iM3732getRightbLpG9ms, m3731getParentbLpG9ms(node));
        if (Node.m3755equalsimpl0(m3731getParentbLpG9ms(node), this.terminator)) {
            this.root = iM3732getRightbLpG9ms;
        } else if (Node.m3755equalsimpl0(m3728getLeftbLpG9ms(m3731getParentbLpG9ms(node)), node)) {
            m3742setLeftcfX_BQo(m3731getParentbLpG9ms(node), iM3732getRightbLpG9ms);
        } else {
            m3746setRightcfX_BQo(m3731getParentbLpG9ms(node), iM3732getRightbLpG9ms);
        }
        m3742setLeftcfX_BQo(iM3732getRightbLpG9ms, node);
        m3745setParentcfX_BQo(node, iM3732getRightbLpG9ms);
        m3724updateNodeMinMax330cO7A(node);
    }

    /* JADX INFO: renamed from: rotateRight-330cO7A, reason: not valid java name */
    private final void m3722rotateRight330cO7A(int node) {
        int iM3728getLeftbLpG9ms = m3728getLeftbLpG9ms(node);
        m3742setLeftcfX_BQo(node, m3732getRightbLpG9ms(iM3728getLeftbLpG9ms));
        if (!Node.m3755equalsimpl0(m3732getRightbLpG9ms(iM3728getLeftbLpG9ms), this.terminator)) {
            m3745setParentcfX_BQo(m3732getRightbLpG9ms(iM3728getLeftbLpG9ms), node);
        }
        m3745setParentcfX_BQo(iM3728getLeftbLpG9ms, m3731getParentbLpG9ms(node));
        if (Node.m3755equalsimpl0(m3731getParentbLpG9ms(node), this.terminator)) {
            this.root = iM3728getLeftbLpG9ms;
        } else if (Node.m3755equalsimpl0(m3732getRightbLpG9ms(m3731getParentbLpG9ms(node)), node)) {
            m3746setRightcfX_BQo(m3731getParentbLpG9ms(node), iM3728getLeftbLpG9ms);
        } else {
            m3742setLeftcfX_BQo(m3731getParentbLpG9ms(node), iM3728getLeftbLpG9ms);
        }
        m3746setRightcfX_BQo(iM3728getLeftbLpG9ms, node);
        m3745setParentcfX_BQo(node, iM3728getLeftbLpG9ms);
        m3724updateNodeMinMax330cO7A(node);
    }

    /* JADX INFO: renamed from: updateNodeMinMax-330cO7A, reason: not valid java name */
    private final void m3724updateNodeMinMax330cO7A(int node) {
        while (!Node.m3755equalsimpl0(node, this.terminator)) {
            m3744setMin9hnwElY(node, Math.min(m3734getStart330cO7A(node), Math.min(m3730getMin330cO7A(m3728getLeftbLpG9ms(node)), m3730getMin330cO7A(m3732getRightbLpG9ms(node)))));
            m3743setMax9hnwElY(node, Math.max(m3727getEnd330cO7A(node), Math.max(m3729getMax330cO7A(m3728getLeftbLpG9ms(node)), m3729getMax330cO7A(m3732getRightbLpG9ms(node)))));
            node = m3731getParentbLpG9ms(node);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntIntervalTree)) {
            return false;
        }
        IntIntervalTree intIntervalTree = (IntIntervalTree) other;
        if (this.nodeInfo.get(this.root + 3) != intIntervalTree.nodeInfo.get(intIntervalTree.root + 3) || getTotalNodeCount() - this.deletedNodeCount != intIntervalTree.getTotalNodeCount() - intIntervalTree.deletedNodeCount) {
            return false;
        }
        int i = 4;
        int i2 = 4;
        while (i < this.nodeInfo._size && i2 < intIntervalTree.nodeInfo._size) {
            if (((int) (this.nodeInfo.get(i) >> 32)) == 2) {
                i += 4;
            } else {
                if (((int) (intIntervalTree.nodeInfo.get(i2) >> 32)) != 2) {
                    if (this.nodeInfo.get(i + 2) != intIntervalTree.nodeInfo.get(i2 + 2) || !Intrinsics.areEqual(this.items.get(i / 4), intIntervalTree.items.get(i2 / 4))) {
                        return false;
                    }
                    i += 4;
                }
                i2 += 4;
            }
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = 0;
        for (int i = 4; i < this.nodeInfo._size; i += 4) {
            int iM3753constructorimpl = Node.m3753constructorimpl(i);
            if (m3726getColor330cO7A(iM3753constructorimpl) != 2) {
                int iM3734getStart330cO7A = ((((iHashCode * 31) + m3734getStart330cO7A(iM3753constructorimpl)) * 31) + m3727getEnd330cO7A(iM3753constructorimpl)) * 31;
                T tM3716getItem330cO7A = m3716getItem330cO7A(iM3753constructorimpl);
                iHashCode = iM3734getStart330cO7A + (tM3716getItem330cO7A != null ? tM3716getItem330cO7A.hashCode() : 0);
            }
        }
        return iHashCode;
    }

    public final IntIntervalTree<T> copy() {
        cleanDeletedNodes();
        return new IntIntervalTree<>(this);
    }

    public final boolean isEmpty() {
        return Node.m3755equalsimpl0(this.root, this.terminator);
    }

    /* JADX INFO: renamed from: add-ZlWbn38, reason: not valid java name */
    public final void m3725addZlWbn38(MutableIntList mutableIntList, int i) {
        mutableIntList.add(i);
    }

    /* JADX INFO: renamed from: pop-2SV_EgM, reason: not valid java name */
    public final int m3739pop2SV_EgM(MutableIntList mutableIntList) {
        return Node.m3753constructorimpl(mutableIntList.removeAt(mutableIntList._size - 1));
    }

    private final void forEachNodeInRange(int start, int end, Function1<? super Integer, Unit> block) {
        if (Node.m3755equalsimpl0(getRoot(), getTerminator()) || m3729getMax330cO7A(getRoot()) < start || m3730getMin330cO7A(getRoot()) > end) {
            return;
        }
        int root = getRoot();
        while (true) {
            char c = 0;
            while (!Node.m3755equalsimpl0(root, getTerminator())) {
                if (c != 0) {
                    if (c == 1) {
                        int iM3753constructorimpl = Node.m3753constructorimpl(root);
                        if (m3738overlapsXzpGiIY(iM3753constructorimpl, start, end)) {
                            block.invoke(Integer.valueOf(iM3753constructorimpl));
                        }
                        if (Node.m3755equalsimpl0(m3732getRightbLpG9ms(root), getTerminator()) || m3729getMax330cO7A(m3732getRightbLpG9ms(root)) < start || m3730getMin330cO7A(m3732getRightbLpG9ms(root)) > end) {
                            c = 2;
                        } else {
                            root = m3732getRightbLpG9ms(root);
                        }
                    } else if (c == 2) {
                        if (!Node.m3755equalsimpl0(m3731getParentbLpG9ms(root), getTerminator())) {
                            c = Node.m3755equalsimpl0(root, m3728getLeftbLpG9ms(m3731getParentbLpG9ms(root))) ? (char) 1 : (char) 2;
                        }
                        root = m3731getParentbLpG9ms(root);
                    }
                } else if (Node.m3755equalsimpl0(m3728getLeftbLpG9ms(root), getTerminator()) || m3729getMax330cO7A(m3728getLeftbLpG9ms(root)) < start) {
                    c = 1;
                } else {
                    root = m3728getLeftbLpG9ms(root);
                }
            }
            return;
        }
    }

    static /* synthetic */ void forEachNodeInRange$default(IntIntervalTree intIntervalTree, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i;
        }
        if (Node.m3755equalsimpl0(intIntervalTree.getRoot(), intIntervalTree.getTerminator()) || intIntervalTree.m3729getMax330cO7A(intIntervalTree.getRoot()) < i || intIntervalTree.m3730getMin330cO7A(intIntervalTree.getRoot()) > i2) {
            return;
        }
        int root = intIntervalTree.getRoot();
        while (true) {
            char c = 0;
            while (!Node.m3755equalsimpl0(root, intIntervalTree.getTerminator())) {
                if (c != 0) {
                    if (c == 1) {
                        int iM3753constructorimpl = Node.m3753constructorimpl(root);
                        if (intIntervalTree.m3738overlapsXzpGiIY(iM3753constructorimpl, i, i2)) {
                            function1.invoke(Integer.valueOf(iM3753constructorimpl));
                        }
                        if (Node.m3755equalsimpl0(intIntervalTree.m3732getRightbLpG9ms(root), intIntervalTree.getTerminator()) || intIntervalTree.m3729getMax330cO7A(intIntervalTree.m3732getRightbLpG9ms(root)) < i || intIntervalTree.m3730getMin330cO7A(intIntervalTree.m3732getRightbLpG9ms(root)) > i2) {
                            c = 2;
                        } else {
                            root = intIntervalTree.m3732getRightbLpG9ms(root);
                        }
                    } else if (c == 2) {
                        if (!Node.m3755equalsimpl0(intIntervalTree.m3731getParentbLpG9ms(root), intIntervalTree.getTerminator())) {
                            c = Node.m3755equalsimpl0(root, intIntervalTree.m3728getLeftbLpG9ms(intIntervalTree.m3731getParentbLpG9ms(root))) ? (char) 1 : (char) 2;
                        }
                        root = intIntervalTree.m3731getParentbLpG9ms(root);
                    }
                } else if (Node.m3755equalsimpl0(intIntervalTree.m3728getLeftbLpG9ms(root), intIntervalTree.getTerminator()) || intIntervalTree.m3729getMax330cO7A(intIntervalTree.m3728getLeftbLpG9ms(root)) < i) {
                    c = 1;
                } else {
                    root = intIntervalTree.m3728getLeftbLpG9ms(root);
                }
            }
            return;
        }
    }
}
