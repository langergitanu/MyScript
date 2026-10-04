package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.LinkComposer;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.linkbuffer.GroupHandleKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableAddressSpace;
import androidx.compose.runtime.composer.linkbuffer.SlotTableReader;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LinkComposer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0001*\u00060\u0002j\u0002`\u0001H\u0002\u001a\u0015\u0010\b\u001a\u00060\u0002j\u0002`\u0001*\u00060\u0002j\u0002`\u0005H\u0082\b\u001a\u0015\u0010\b\u001a\u00060\u0002j\u0002`\u0001*\u00060\tj\u0002`\nH\u0082\b\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0000\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0000\u001a\f\u0010\u000e\u001a\u00020\u0011*\u00020\u0012H\u0000\u001a\u001b\u0010\u0013\u001a\u0004\u0018\u00010\t*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\u0010\u0017\u001aE\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a0\u0019*\u00020\u001d2\n\u0010\u001e\u001a\u00060\tj\u0002`\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0 H\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001a\u0010#\u001a\u0004\u0018\u00010\u001b*\u00020\u001d2\n\u0010\u001e\u001a\u00060\tj\u0002`\nH\u0000\u001a4\u0010$\u001a\b\u0012\u0004\u0012\u0002H&0%\"\u0004\b\u0000\u0010&2\u001d\u0010'\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H&0)\u0012\u0004\u0012\u00020*0(¢\u0006\u0002\b+H\u0082\b\u001a5\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H/0-\"\b\b\u0000\u0010.*\u00020\u001c\"\b\b\u0001\u0010/*\u00020\u001c2\u0006\u00100\u001a\u00020\tH\u0002¢\u0006\u0002\u00101\u001a(\u00102\u001a\u0004\u0018\u00010\u001c2\b\u00103\u001a\u0004\u0018\u00010\u001c2\b\u00104\u001a\u0004\u0018\u00010\u001c2\b\u00105\u001a\u0004\u0018\u00010\u001cH\u0002\u001a\f\u00106\u001a\u00020\t*\u00020\u0004H\u0002\u001a\f\u00107\u001a\u00020\u0004*\u00020\tH\u0002\u001a(\u00108\u001a\u00060\u0002j\u0002`\u0001*\u00020\u00142\n\u00109\u001a\u00060\u0002j\u0002`\u00012\n\u0010:\u001a\u00060\u0002j\u0002`\u0001H\u0002\u001a4\u0010;\u001a\u00060\tj\u0002`\n*\u00020<2\n\u0010=\u001a\u00060\tj\u0002`\n2\n\u00109\u001a\u00060\tj\u0002`\n2\n\u0010:\u001a\u00060\tj\u0002`\nH\u0002\u001a%\u0010>\u001a\u00020\u0004*\u00020<2\n\u0010=\u001a\u00060\tj\u0002`\n2\n\u0010?\u001a\u00060\tj\u0002`\nH\u0082\b\u001a \u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019*\u00020\u00142\n\u0010\u001e\u001a\u00060\tj\u0002`\nH\u0002\"\u001c\u0010\u0003\u001a\u00020\u0004*\u00060\u0002j\u0002`\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006*\u0010\b\u0002\u0010\u0000\"\u0002`\u00012\u00060\u0002j\u0002`\u0001¨\u0006A"}, m1599d2 = {"VirtualGroupHandle", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "", "isInsertHandle", "", "Landroidx/compose/runtime/VirtualGroupHandle;", "(J)Z", "toInsertAddress", "toGroupHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "asLinkComposer", "Landroidx/compose/runtime/LinkComposer;", "Landroidx/compose/runtime/Composer;", "asLinkRememberObserverHolder", "Landroidx/compose/runtime/LinkRememberObserverHolder;", "Landroidx/compose/runtime/RememberObserverHolder;", "Landroidx/compose/runtime/ReusableLinkRememberObserverHolder;", "Landroidx/compose/runtime/ReusableRememberObserverHolder;", "findSubcompositionContextGroup", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", WebViewMessageType.CONTEXT, "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;Landroidx/compose/runtime/CompositionContext;)Ljava/lang/Integer;", "findInvalidations", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "group", "invalidations", "Landroidx/compose/runtime/collection/ScopeMap;", "findInvalidations-Vpaz1Sg", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;ILandroidx/collection/MutableScatterMap;)Ljava/util/List;", "getRecomposeScopeOrNull", "buildScatterSet", "Landroidx/collection/ScatterSet;", ExifInterface.GPS_DIRECTION_TRUE, "builderAction", "Lkotlin/Function1;", "Landroidx/collection/MutableScatterSet;", "", "Lkotlin/ExtensionFunctionType;", "multiMap", "Landroidx/compose/runtime/collection/MultiValueMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "initialCapacity", "(I)Landroidx/collection/MutableScatterMap;", "getKey", "value", TtmlNode.LEFT, TtmlNode.RIGHT, "asInt", "asBool", "firstGroupInTopologicalOrder", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "findFirstSibling", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "parent", "childOf", "child", "collectNodesFrom", "runtime"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LinkComposerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean asBool(int i) {
        return i != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int asInt(boolean z) {
        return z ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isInsertHandle(long j) {
        return GroupHandleKt.getGroup(j) < -8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long toInsertAddress(long j) {
        int context = GroupHandleKt.getContext(j);
        return (((long) UInt.m14594constructorimpl((-10) - GroupHandleKt.getGroup(j))) & 4294967295L) | (((long) context) << 32);
    }

    private static final long toGroupHandle(long j) {
        isInsertHandle(j);
        return j;
    }

    public static final LinkComposer asLinkComposer(Composer composer) {
        LinkComposer linkComposer = composer instanceof LinkComposer ? (LinkComposer) composer : null;
        if (linkComposer != null) {
            return linkComposer;
        }
        ComposerKt.composeRuntimeError("Inconsistent composition");
        throw new KotlinNothingValueException();
    }

    public static final LinkRememberObserverHolder asLinkRememberObserverHolder(RememberObserverHolder rememberObserverHolder) {
        LinkRememberObserverHolder linkRememberObserverHolder = rememberObserverHolder instanceof LinkRememberObserverHolder ? (LinkRememberObserverHolder) rememberObserverHolder : null;
        if (linkRememberObserverHolder != null) {
            return linkRememberObserverHolder;
        }
        ComposerKt.composeRuntimeError("Inconsistent composition");
        throw new KotlinNothingValueException();
    }

    public static final ReusableLinkRememberObserverHolder asLinkRememberObserverHolder(ReusableRememberObserverHolder reusableRememberObserverHolder) {
        ReusableLinkRememberObserverHolder reusableLinkRememberObserverHolder = reusableRememberObserverHolder instanceof ReusableLinkRememberObserverHolder ? (ReusableLinkRememberObserverHolder) reusableRememberObserverHolder : null;
        if (reusableLinkRememberObserverHolder != null) {
            return reusableLinkRememberObserverHolder;
        }
        ComposerKt.composeRuntimeError("Inconsistent composition");
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX INFO: renamed from: findInvalidations-Vpaz1Sg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<Pair<RecomposeScopeImpl, Object>> m7204findInvalidationsVpaz1Sg(SlotTableReader slotTableReader, int i, MutableScatterMap<Object, Object> mutableScatterMap) {
        int i2;
        if (ScopeMap.m7298isEmptyimpl(mutableScatterMap)) {
            return CollectionsKt.emptyList();
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        MutableScatterSet mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
        SlotTableAddressSpace addressSpace = slotTableReader.getTable().getAddressSpace();
        if (i >= 0) {
            IntStack intStack = new IntStack();
            int[] groups = addressSpace.getGroups();
            int iPop = i;
            while (true) {
                RecomposeScopeImpl recomposeScopeOrNull = getRecomposeScopeOrNull(slotTableReader, iPop);
                if (recomposeScopeOrNull != null) {
                    mutableScatterSetMutableScatterSetOf.add(recomposeScopeOrNull);
                }
                if (iPop != i && (i2 = groups[iPop + 1]) >= 0) {
                    intStack.push(i2);
                }
                iPop = groups[iPop + 3];
                if (iPop < 0) {
                    if (intStack.tos == 0) {
                        break;
                    }
                    iPop = intStack.pop();
                }
            }
        }
        MutableScatterSet mutableScatterSet = mutableScatterSetMutableScatterSetOf;
        MutableScatterMap<Object, Object> mutableScatterMap2 = mutableScatterMap;
        Object[] objArr = mutableScatterMap2.keys;
        Object[] objArr2 = mutableScatterMap2.values;
        long[] jArr = mutableScatterMap2.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                long j = jArr[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = (i3 << 3) + i5;
                            Object obj = objArr[i6];
                            Object obj2 = objArr2[i6];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                            if (mutableScatterSet.contains(recomposeScopeImpl)) {
                                listCreateListBuilder.add(TuplesKt.m1606to(recomposeScopeImpl, obj2));
                            }
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        break;
                    }
                    if (i3 == length) {
                        break;
                    }
                    i3++;
                }
            }
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    public static final RecomposeScopeImpl getRecomposeScopeOrNull(SlotTableReader slotTableReader, int i) {
        Object orNull = slotTableReader.getOrNull(i, 0);
        if (orNull instanceof RecomposeScopeImpl) {
            return (RecomposeScopeImpl) orNull;
        }
        return null;
    }

    private static final <T> ScatterSet<T> buildScatterSet(Function1<? super MutableScatterSet<T>, Unit> function1) {
        MutableScatterSet mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
        function1.invoke(mutableScatterSetMutableScatterSetOf);
        return mutableScatterSetMutableScatterSetOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> MutableScatterMap<Object, Object> multiMap(int i) {
        return MultiValueMap.m7264constructorimpl(new MutableScatterMap(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getKey(Object obj, Object obj2, Object obj3) {
        JoinedKey joinedKey = obj instanceof JoinedKey ? (JoinedKey) obj : null;
        if (joinedKey == null) {
            return null;
        }
        if (Intrinsics.areEqual(joinedKey.getLeft(), obj2) && Intrinsics.areEqual(joinedKey.getRight(), obj3)) {
            return obj;
        }
        Object key = getKey(joinedKey.getLeft(), obj2, obj3);
        return key == null ? getKey(joinedKey.getRight(), obj2, obj3) : key;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e0, code lost:
    
        if (r2 == r3) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f1, code lost:
    
        if (r3 == r2) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long firstGroupInTopologicalOrder(SlotTable slotTable, long j, long j2) {
        int group;
        int group2;
        if (j != j2) {
            SlotTableAddressSpace addressSpace = slotTable.getAddressSpace();
            int[] groups = addressSpace.getGroups();
            if (GroupHandleKt.getGroup(j) == -1) {
                if (GroupHandleKt.getGroup(j2) == -1) {
                    group = GroupHandleKt.getContext(j);
                } else {
                    int context = GroupHandleKt.getContext(j);
                    int group3 = GroupHandleKt.getGroup(j2);
                    int[] groups2 = addressSpace.getGroups();
                    int i = group3;
                    while (i > 0) {
                        if (i == context) {
                            return j2;
                        }
                        i = groups2[i + 2];
                    }
                    if (!(i != 0)) {
                        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + group3);
                    }
                    group = GroupHandleKt.getContext(j);
                }
            } else {
                group = GroupHandleKt.getGroup(j);
            }
            if (GroupHandleKt.getGroup(j2) == -1) {
                if (GroupHandleKt.getGroup(j) == -1) {
                    group2 = GroupHandleKt.getContext(j2);
                } else {
                    int context2 = GroupHandleKt.getContext(j2);
                    int group4 = GroupHandleKt.getGroup(j);
                    int[] groups3 = addressSpace.getGroups();
                    int i2 = group4;
                    while (i2 > 0) {
                        if (i2 == context2) {
                            return j;
                        }
                        i2 = groups3[i2 + 2];
                    }
                    if (!(i2 != 0)) {
                        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + group4);
                    }
                    group2 = GroupHandleKt.getContext(j2);
                }
            } else {
                group2 = GroupHandleKt.getGroup(j2);
            }
            if (group != group2) {
                int i3 = group == -1 ? -1 : groups[group + 2];
                int i4 = group2 != -1 ? groups[group2 + 2] : -1;
                if (i3 != group2) {
                    if (i4 != group) {
                        if (i3 != i4) {
                            int iDistanceFrom$runtime = addressSpace.distanceFrom$runtime(group, slotTable.getRoot());
                            int iDistanceFrom$runtime2 = addressSpace.distanceFrom$runtime(group2, slotTable.getRoot());
                            if (iDistanceFrom$runtime > iDistanceFrom$runtime2) {
                                int i5 = iDistanceFrom$runtime - iDistanceFrom$runtime2;
                                int i6 = 0;
                                while (i6 < i5) {
                                    i6++;
                                    int i7 = i3;
                                    i3 = groups[i3 + 2];
                                    group = i7;
                                }
                            } else {
                                int i8 = iDistanceFrom$runtime2 - iDistanceFrom$runtime;
                                int i9 = 0;
                                while (i9 < i8) {
                                    i9++;
                                    int i10 = i4;
                                    i4 = groups[i4 + 2];
                                    group2 = i10;
                                }
                            }
                            while (i3 != i4) {
                                int i11 = groups[i3 + 2];
                                group2 = i4;
                                i4 = groups[i4 + 2];
                                group = i3;
                                i3 = i11;
                            }
                        }
                        if (!(group != group2)) {
                            ComposerKt.composeImmediateRuntimeError("Unexpected slot table structure");
                        }
                        int iFindFirstSibling = findFirstSibling(addressSpace, i3, group, group2);
                        if (iFindFirstSibling != group) {
                            if (iFindFirstSibling != group2) {
                                ComposerKt.composeRuntimeError("Unexpected slot table structure");
                                throw new KotlinNothingValueException();
                            }
                        }
                    }
                }
                return j2;
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Object> collectNodesFrom(SlotTable slotTable, int i) {
        boolean z;
        int i2;
        ArrayList arrayList = new ArrayList();
        SlotTableReader slotTableReaderOpenReader = slotTable.openReader();
        try {
            SlotTableAddressSpace slotTableAddressSpace = slotTableReaderOpenReader.addressSpace;
            if (i >= 0) {
                IntStack intStack = new IntStack();
                int[] groups = slotTableAddressSpace.getGroups();
                int iPop = i;
                while (true) {
                    if (slotTableReaderOpenReader.isNode(iPop)) {
                        arrayList.add(slotTableReaderOpenReader.node(iPop));
                        z = false;
                    } else {
                        z = true;
                    }
                    if (iPop != i && (i2 = groups[iPop + 1]) >= 0) {
                        intStack.push(i2);
                    }
                    iPop = groups[iPop + 3];
                    if (!z || iPop < 0) {
                        if (intStack.tos == 0) {
                            break;
                        }
                        iPop = intStack.pop();
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            return arrayList;
        } finally {
            slotTableReaderOpenReader.close();
        }
    }

    private static final long toGroupHandle(int i) {
        return (((long) 0) << 32) | (((long) UInt.m14594constructorimpl(i)) & 4294967295L);
    }

    public static final Integer findSubcompositionContextGroup(SlotTable slotTable, CompositionContext compositionContext) {
        int i;
        SlotTableReader slotTableReaderOpenReader = slotTable.openReader();
        try {
            int root = slotTable.getRoot();
            int iFirstChildOf = slotTableReaderOpenReader.firstChildOf(root);
            loop0: while (iFirstChildOf != -1) {
                if ((slotTable.groupFlags$runtime(iFirstChildOf) & 1073741824) == 1073741824 && (i = slotTable.getGroups()[iFirstChildOf + 5]) != -1) {
                    SlotTableAddressSpace addressSpace = slotTable.getAddressSpace();
                    int i2 = (i & 15) + 1;
                    int i3 = i >> 4;
                    if (i2 > 15) {
                        i2 = addressSpace.getLargeSizes().get(i3);
                    }
                    for (int i4 = 0; i4 < i2; i4++) {
                        Object obj = slotTable.getSlots()[i3 + i4];
                        if (Intrinsics.areEqual(obj, Composer.INSTANCE.getEmpty())) {
                            break;
                        }
                        RememberObserverHolder rememberObserverHolder = obj instanceof RememberObserverHolder ? (RememberObserverHolder) obj : null;
                        RememberObserver wrapped = rememberObserverHolder != null ? rememberObserverHolder.getWrapped() : null;
                        LinkComposer.CompositionContextHolder compositionContextHolder = wrapped instanceof LinkComposer.CompositionContextHolder ? (LinkComposer.CompositionContextHolder) wrapped : null;
                        if (compositionContextHolder != null && Intrinsics.areEqual(compositionContextHolder.getRef(), compositionContext)) {
                            return Integer.valueOf(iFirstChildOf);
                        }
                    }
                }
                int iFirstChildOf2 = slotTableReaderOpenReader.firstChildOf(iFirstChildOf);
                if (iFirstChildOf2 == -1 || (slotTable.groupFlags$runtime(iFirstChildOf) & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
                    int iParentOf = iFirstChildOf;
                    iFirstChildOf = slotTableReaderOpenReader.nextSiblingOf(iFirstChildOf);
                    while (iFirstChildOf == -1) {
                        iParentOf = slotTableReaderOpenReader.parentOf(iParentOf);
                        if (iParentOf == -1 || iParentOf == root) {
                            break loop0;
                        }
                        iFirstChildOf = slotTableReaderOpenReader.nextSiblingOf(iParentOf);
                    }
                } else {
                    iFirstChildOf = iFirstChildOf2;
                }
            }
            Unit unit = Unit.INSTANCE;
            return null;
        } finally {
            slotTableReaderOpenReader.close();
        }
    }

    private static final int findFirstSibling(SlotTableAddressSpace slotTableAddressSpace, int i, int i2, int i3) {
        if (i2 != -1) {
            if (i3 != -1) {
                int[] groups = slotTableAddressSpace.getGroups();
                for (int i4 = groups[i + 3]; i4 > 0; i4 = groups[i4 + 1]) {
                    if (i4 != i2) {
                        if (i4 != i3) {
                        }
                    }
                }
                ComposerKt.composeRuntimeError("Unexpected slot table structure");
                throw new KotlinNothingValueException();
            }
            return i2;
        }
        return i3;
    }

    private static final boolean childOf(SlotTableAddressSpace slotTableAddressSpace, int i, int i2) {
        int[] groups = slotTableAddressSpace.getGroups();
        int i3 = i2;
        while (true) {
            if (i3 <= 0) {
                if (!(i3 != 0)) {
                    ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i2);
                }
                return false;
            }
            if (i3 == i) {
                return true;
            }
            i3 = groups[i3 + 2];
        }
    }
}
