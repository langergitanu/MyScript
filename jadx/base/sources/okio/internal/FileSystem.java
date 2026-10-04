package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.Okio;
import okio.Path;
import okio.Source;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: renamed from: okio.internal.-FileSystem, reason: invalid class name */
/* JADX INFO: compiled from: FileSystem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u000b\u001a\u00020\b*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u000e\u001a\u00020\b*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0000\u001a\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0000\u001aF\u0010\u0014\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u0016\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0080@¢\u0006\u0002\u0010\u001a\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u001c"}, m1599d2 = {"commonMetadata", "Lokio/FileMetadata;", "Lokio/FileSystem;", ClientCookie.PATH_ATTR, "Lokio/Path;", "commonExists", "", "commonCreateDirectories", "", "dir", "mustCreate", "commonCopy", FirebaseAnalytics.Param.SOURCE, TypedValues.AttributesType.S_TARGET, "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonListRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "collectRecursively", "Lkotlin/sequences/SequenceScope;", "fileSystem", "stack", "Lkotlin/collections/ArrayDeque;", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "symlinkTarget", "okio"}, m1600k = 2, m1601mv = {2, 2, 0}, m1603xi = 48)
public final class FileSystem {

    /* JADX INFO: renamed from: okio.internal.-FileSystem$collectRecursively$1 */
    /* JADX INFO: compiled from: FileSystem.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 2, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "okio.internal.-FileSystem", m1609f = "FileSystem.kt", m1610i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, m1611l = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID, 135, 145}, m1612m = "collectRecursively", m1613n = {"$this$collectRecursively", "fileSystem", "stack", ClientCookie.PATH_ATTR, "followSymlinks", "postorder", "$this$collectRecursively", "fileSystem", "stack", ClientCookie.PATH_ATTR, "children", "symlinkPath", "child", "followSymlinks", "postorder", "symlinkCount", "$this$collectRecursively", "fileSystem", "stack", ClientCookie.PATH_ATTR, "children", "followSymlinks", "postorder"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "Z$0", "Z$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1"}, m1616v = 1)
    static final class C89451 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C89451(Continuation<? super C89451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileSystem.collectRecursively(null, null, null, null, false, false, this);
        }
    }

    public static final FileMetadata commonMetadata(okio.FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata fileMetadataMetadataOrNull = fileSystem.metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            return fileMetadataMetadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public static final boolean commonExists(okio.FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }

    public static final void commonCreateDirectories(okio.FileSystem fileSystem, Path dir, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Path pathParent = dir; pathParent != null && !fileSystem.exists(pathParent); pathParent = pathParent.parent()) {
            arrayDeque.addFirst(pathParent);
        }
        if (z && arrayDeque.isEmpty()) {
            throw new IOException(dir + " already exists.");
        }
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            okio.FileSystem.createDirectory$default(fileSystem, (Path) it.next(), false, 2, null);
        }
    }

    public static final void commonDeleteRecursively(okio.FileSystem fileSystem, Path fileOrDirectory, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        Iterator it = SequencesKt.sequence(new FileSystem$commonDeleteRecursively$sequence$1(fileSystem, fileOrDirectory, null)).iterator();
        while (it.hasNext()) {
            fileSystem.delete((Path) it.next(), z && !it.hasNext());
        }
    }

    /* JADX INFO: renamed from: okio.internal.-FileSystem$commonListRecursively$1 */
    /* JADX INFO: compiled from: FileSystem.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;"}, m1600k = 3, m1601mv = {2, 2, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "okio.internal.-FileSystem$commonListRecursively$1", m1609f = "FileSystem.kt", m1610i = {0, 0, 0}, m1611l = {96}, m1612m = "invokeSuspend", m1613n = {"$this$sequence", "stack", "child"}, m1615s = {"L$0", "L$1", "L$3"}, m1616v = 1)
    static final class C89461 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Path $dir;
        final /* synthetic */ boolean $followSymlinks;
        final /* synthetic */ okio.FileSystem $this_commonListRecursively;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C89461(Path path, okio.FileSystem fileSystem, boolean z, Continuation<? super C89461> continuation) {
            super(2, continuation);
            this.$dir = path;
            this.$this_commonListRecursively = fileSystem;
            this.$followSymlinks = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C89461 c89461 = new C89461(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, continuation);
            c89461.L$0 = obj;
            return c89461;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C89461) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterator<Path> it;
            ArrayDeque arrayDeque;
            SequenceScope sequenceScope = (SequenceScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ArrayDeque arrayDeque2 = new ArrayDeque();
                arrayDeque2.addLast(this.$dir);
                it = this.$this_commonListRecursively.list(this.$dir).iterator();
                arrayDeque = arrayDeque2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$2;
                arrayDeque = (ArrayDeque) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            Iterator<Path> it2 = it;
            while (it2.hasNext()) {
                Path next = it2.next();
                this.L$0 = sequenceScope;
                this.L$1 = arrayDeque;
                this.L$2 = it2;
                this.L$3 = SpillingKt.nullOutSpilledVariable(next);
                this.label = 1;
                if (FileSystem.collectRecursively(sequenceScope, this.$this_commonListRecursively, arrayDeque, next, this.$followSymlinks, false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final Sequence<Path> commonListRecursively(okio.FileSystem fileSystem, Path dir, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        return SequencesKt.sequence(new C89461(dir, fileSystem, z, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00cc, code lost:
    
        if (r17.yield(r1, r4) == r5) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0114, code lost:
    
        if (r0 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0116, code lost:
    
        if (r11 != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0118, code lost:
    
        r6.addLast(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011f, code lost:
    
        r13 = r1;
        r1 = r6;
        r6 = r3.iterator();
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0193, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0194, code lost:
    
        r12 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01cf, code lost:
    
        if (r10.yield(r1, r4) == r5) goto L72;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012b A[Catch: all -> 0x018f, TRY_LEAVE, TryCatch #3 {all -> 0x018f, blocks: (B:49:0x0125, B:51:0x012b), top: B:83:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Object, kotlin.sequences.SequenceScope] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.Object, kotlin.sequences.SequenceScope, kotlin.sequences.SequenceScope<? super okio.Path>] */
    /* JADX WARN: Type inference failed for: r17v1, types: [kotlin.sequences.SequenceScope] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0177 -> B:19:0x008b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object collectRecursively(SequenceScope<? super Path> sequenceScope, okio.FileSystem fileSystem, ArrayDeque<Path> arrayDeque, Path path, boolean z, boolean z2, Continuation<? super Unit> continuation) throws Throwable {
        C89451 c89451;
        okio.FileSystem fileSystem2;
        ArrayDeque<Path> arrayDeque2;
        boolean z3;
        ?? r10;
        boolean z4;
        okio.FileSystem fileSystem3;
        List<Path> listListOrNull;
        int i;
        Path path2;
        ArrayDeque<Path> arrayDeque3;
        boolean z5;
        ArrayDeque<Path> arrayDeque4;
        boolean z6;
        C89451 c894512;
        okio.FileSystem fileSystem4;
        ?? r17;
        Path path3 = path;
        boolean z7 = z2;
        if (continuation instanceof C89451) {
            c89451 = (C89451) continuation;
            if ((c89451.label & Integer.MIN_VALUE) != 0) {
                c89451.label -= Integer.MIN_VALUE;
            } else {
                c89451 = new C89451(continuation);
            }
        }
        Object obj = c89451.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c89451.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (z7) {
                fileSystem2 = fileSystem;
                arrayDeque2 = arrayDeque;
                z3 = z;
            } else {
                c89451.L$0 = sequenceScope;
                fileSystem2 = fileSystem;
                c89451.L$1 = fileSystem2;
                arrayDeque2 = arrayDeque;
                c89451.L$2 = arrayDeque2;
                c89451.L$3 = path3;
                z3 = z;
                c89451.Z$0 = z3;
                c89451.Z$1 = z7;
                c89451.label = 1;
            }
            boolean z8 = z3;
            r10 = sequenceScope;
            z4 = z8;
            fileSystem3 = fileSystem2;
        } else if (i2 == 1) {
            boolean z9 = c89451.Z$1;
            boolean z10 = c89451.Z$0;
            Path path4 = (Path) c89451.L$3;
            arrayDeque2 = (ArrayDeque) c89451.L$2;
            fileSystem3 = (okio.FileSystem) c89451.L$1;
            SequenceScope sequenceScope2 = (SequenceScope) c89451.L$0;
            ResultKt.throwOnFailure(obj);
            z7 = z9;
            z4 = z10;
            path3 = path4;
            r10 = sequenceScope2;
        } else {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z11 = c89451.Z$1;
                boolean z12 = c89451.Z$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            int i3 = c89451.I$0;
            boolean z13 = c89451.Z$1;
            boolean z14 = c89451.Z$0;
            Iterator<Path> it = (Iterator) c89451.L$6;
            Path path5 = (Path) c89451.L$5;
            List<Path> list = (List) c89451.L$4;
            Path path6 = (Path) c89451.L$3;
            ArrayDeque<Path> arrayDeque5 = (ArrayDeque) c89451.L$2;
            okio.FileSystem fileSystem5 = (okio.FileSystem) c89451.L$1;
            SequenceScope sequenceScope3 = (SequenceScope) c89451.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                i = i3;
                z4 = z14;
                z7 = z13;
                ArrayDeque<Path> arrayDeque6 = arrayDeque5;
                path2 = path5;
                fileSystem3 = fileSystem5;
                Path path7 = path6;
                listListOrNull = list;
                ?? r14 = sequenceScope3;
                ?? r102 = r14;
                try {
                    if (!it.hasNext()) {
                        try {
                            Path next = it.next();
                            c89451.L$0 = r102;
                            c89451.L$1 = fileSystem3;
                            c89451.L$2 = arrayDeque6;
                            c89451.L$3 = path7;
                            c89451.L$4 = SpillingKt.nullOutSpilledVariable(listListOrNull);
                            c89451.L$5 = SpillingKt.nullOutSpilledVariable(path2);
                            c89451.L$6 = it;
                            c89451.L$7 = SpillingKt.nullOutSpilledVariable(next);
                            c89451.Z$0 = z4;
                            c89451.Z$1 = z7;
                            c89451.I$0 = i;
                            c89451.label = 2;
                            Object objCollectRecursively = collectRecursively(r17, fileSystem4, arrayDeque4, next, z5, z6, c894512);
                            r14 = r17;
                            c89451 = c894512;
                            if (objCollectRecursively != coroutine_suspended) {
                                z4 = z5;
                                z7 = z6;
                                arrayDeque6 = arrayDeque4;
                                fileSystem3 = fileSystem4;
                                ?? r1022 = r14;
                                if (!it.hasNext()) {
                                    ?? r142 = r1022;
                                    okio.FileSystem fileSystem6 = fileSystem3;
                                    ArrayDeque<Path> arrayDeque7 = arrayDeque6;
                                    arrayDeque7.removeLast();
                                    arrayDeque2 = arrayDeque7;
                                    fileSystem3 = fileSystem6;
                                    r10 = r142;
                                    z7 = z7;
                                    path3 = path7;
                                    if (z7) {
                                        return Unit.INSTANCE;
                                    }
                                    c89451.L$0 = SpillingKt.nullOutSpilledVariable(r10);
                                    c89451.L$1 = SpillingKt.nullOutSpilledVariable(fileSystem3);
                                    c89451.L$2 = SpillingKt.nullOutSpilledVariable(arrayDeque2);
                                    c89451.L$3 = SpillingKt.nullOutSpilledVariable(path3);
                                    c89451.L$4 = SpillingKt.nullOutSpilledVariable(listListOrNull);
                                    c89451.L$5 = null;
                                    c89451.L$6 = null;
                                    c89451.L$7 = null;
                                    c89451.Z$0 = z4;
                                    c89451.Z$1 = z7;
                                    c89451.label = 3;
                                }
                            }
                            return coroutine_suspended;
                        } catch (Throwable th) {
                            th = th;
                            arrayDeque3 = arrayDeque4;
                            arrayDeque5 = arrayDeque3;
                            arrayDeque5.removeLast();
                            throw th;
                        }
                        z5 = z4;
                        arrayDeque4 = arrayDeque6;
                        z6 = z7;
                        c894512 = c89451;
                        fileSystem4 = fileSystem3;
                        r17 = r1022;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    arrayDeque3 = arrayDeque6;
                }
            } catch (Throwable th3) {
                th = th3;
                arrayDeque5.removeLast();
                throw th;
            }
        }
        listListOrNull = fileSystem3.listOrNull(path3);
        if (listListOrNull == null) {
            listListOrNull = CollectionsKt.emptyList();
        }
        if (!listListOrNull.isEmpty()) {
            i = 0;
            path2 = path3;
            while (true) {
                if (z4 && arrayDeque2.contains(path2)) {
                    throw new IOException("symlink cycle at " + path3);
                }
                Path pathSymlinkTarget = symlinkTarget(fileSystem3, path2);
                if (pathSymlinkTarget == null) {
                    break;
                }
                i++;
                path2 = pathSymlinkTarget;
            }
        }
        if (z7) {
        }
    }

    public static final Path symlinkTarget(okio.FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path pathParent = path.parent();
        Intrinsics.checkNotNull(pathParent);
        return pathParent.resolve(symlinkTarget);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b A[Catch: all -> 0x0063, TRY_LEAVE, TryCatch #1 {all -> 0x0063, blocks: (B:3:0x0018, B:19:0x004b, B:25:0x0062, B:16:0x0044, B:13:0x003f, B:4:0x0027), top: B:38:0x0018, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062 A[Catch: all -> 0x0063, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0063, blocks: (B:3:0x0018, B:19:0x004b, B:25:0x0062, B:16:0x0044, B:13:0x003f, B:4:0x0027), top: B:38:0x0018, inners: #0, #4 }] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void commonCopy(okio.FileSystem fileSystem, Path source, Path target) throws IOException {
        Throwable th;
        Long lValueOf;
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Source source2 = fileSystem.source(source);
        Long th2 = null;
        try {
            Source source3 = source2;
            BufferedSink bufferedSinkBuffer = Okio.buffer(okio.FileSystem.sink$default(fileSystem, target, false, 2, null));
            try {
                lValueOf = Long.valueOf(bufferedSinkBuffer.writeAll(source3));
            } catch (Throwable th3) {
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th3, th4);
                    }
                }
                th = th3;
                lValueOf = null;
            }
            if (bufferedSinkBuffer != null) {
                try {
                    bufferedSinkBuffer.close();
                    th = null;
                } catch (Throwable th5) {
                    th = th5;
                }
                if (th != null) {
                    Long lValueOf2 = Long.valueOf(lValueOf.longValue());
                    if (source2 != null) {
                        try {
                            source2.close();
                        } catch (Throwable th6) {
                            th2 = th6;
                        }
                    }
                    Long l = th2;
                    th2 = lValueOf2;
                    th = l;
                } else {
                    throw th;
                }
            } else {
                th = null;
                if (th != null) {
                }
            }
        } catch (Throwable th7) {
            th = th7;
            if (source2 != null) {
                try {
                    source2.close();
                } catch (Throwable th8) {
                    ExceptionsKt.addSuppressed(th, th8);
                }
            }
        }
        if (th != 0) {
            throw th;
        }
    }
}
