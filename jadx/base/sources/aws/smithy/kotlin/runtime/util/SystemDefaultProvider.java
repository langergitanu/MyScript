package aws.smithy.kotlin.runtime.util;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.FilesKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: PlatformJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b\u0010\u0010\u001aJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0086@¢\u0006\u0004\b\u0010\u0010\u001dJ\u001b\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u0007J\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\nR\u001a\u0010 \u001a\u00020\u00168\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"R\u001b\u0010%\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u00168\u0016X\u0096D¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b&\u0010\"R\u001a\u0010'\u001a\u00020\u00168\u0016X\u0096D¢\u0006\f\n\u0004\b'\u0010!\u001a\u0004\b'\u0010\"R\u001a\u0010(\u001a\u00020\u00168\u0016X\u0096D¢\u0006\f\n\u0004\b(\u0010!\u001a\u0004\b(\u0010\"R\u001b\u0010,\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+¨\u0006-"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/SystemDefaultProvider;", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "<init>", "()V", "", "", "getAllEnvVars", "()Ljava/util/Map;", SubscriberAttributeKt.JSON_NAME_KEY, "getenv", "(Ljava/lang/String;)Ljava/lang/String;", "Laws/smithy/kotlin/runtime/util/OperatingSystem;", "osInfo", "()Laws/smithy/kotlin/runtime/util/OperatingSystem;", ClientCookie.PATH_ATTR, "", "readFileOrNull", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", "", "writeFile", "(Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "fileExists", "(Ljava/lang/String;)Z", "Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/File;", "file", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllProperties", "getProperty", "isJvm", "Z", "()Z", "isAndroid$delegate", "Lkotlin/Lazy;", "isAndroid", "isBrowser", "isNode", "isNative", "filePathSeparator$delegate", "getFilePathSeparator", "()Ljava/lang/String;", "filePathSeparator", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SystemDefaultProvider implements PlatformProvider {
    private static final boolean isBrowser = false;
    private static final boolean isNative = false;
    private static final boolean isNode = false;
    public static final SystemDefaultProvider INSTANCE = new SystemDefaultProvider();
    private static final boolean isJvm = true;

    /* JADX INFO: renamed from: isAndroid$delegate, reason: from kotlin metadata */
    private static final Lazy isAndroid = LazyKt.lazy(new Function0() { // from class: aws.smithy.kotlin.runtime.util.SystemDefaultProvider$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(PlatformJVMKt.access$isAndroid());
        }
    });

    /* JADX INFO: renamed from: filePathSeparator$delegate, reason: from kotlin metadata */
    private static final Lazy filePathSeparator = LazyKt.lazy(new Function0() { // from class: aws.smithy.kotlin.runtime.util.SystemDefaultProvider$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return File.separator;
        }
    });

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.util.SystemDefaultProvider$readFileOrNull$1 */
    /* JADX INFO: compiled from: PlatformJVM.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.util.SystemDefaultProvider", m1609f = "PlatformJVM.kt", m1610i = {0}, m1611l = {38}, m1612m = "readFileOrNull", m1613n = {ClientCookie.PATH_ATTR}, m1614nl = {41}, m1615s = {"L$0"}, m1616v = 2)
    static final class C38001 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C38001(Continuation<? super C38001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SystemDefaultProvider.this.readFileOrNull((String) null, this);
        }
    }

    private SystemDefaultProvider() {
    }

    @Override // aws.smithy.kotlin.runtime.util.EnvironmentProvider
    public Map<String, String> getAllEnvVars() {
        Map<String, String> map = System.getenv();
        Intrinsics.checkNotNullExpressionValue(map, "getenv(...)");
        return map;
    }

    @Override // aws.smithy.kotlin.runtime.util.EnvironmentProvider
    public String getenv(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return System.getenv().get(key);
    }

    @Override // aws.smithy.kotlin.runtime.util.PlatformProvider
    /* JADX INFO: renamed from: isJvm */
    public boolean getIsJvm() {
        return isJvm;
    }

    @Override // aws.smithy.kotlin.runtime.util.PlatformProvider
    /* JADX INFO: renamed from: isAndroid */
    public boolean getIsAndroid() {
        return ((Boolean) isAndroid.getValue()).booleanValue();
    }

    @Override // aws.smithy.kotlin.runtime.util.PlatformProvider
    /* JADX INFO: renamed from: isBrowser */
    public boolean getIsBrowser() {
        return isBrowser;
    }

    @Override // aws.smithy.kotlin.runtime.util.PlatformProvider
    /* JADX INFO: renamed from: isNode */
    public boolean getIsNode() {
        return isNode;
    }

    @Override // aws.smithy.kotlin.runtime.util.PlatformProvider
    /* JADX INFO: renamed from: isNative */
    public boolean getIsNative() {
        return isNative;
    }

    @Override // aws.smithy.kotlin.runtime.util.PlatformProvider
    /* JADX INFO: renamed from: osInfo */
    public OperatingSystem getOs() {
        return PlatformJVMKt.getOsInfo();
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.util.SystemDefaultProvider$readFileOrNull$2 */
    /* JADX INFO: compiled from: PlatformJVM.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.util.SystemDefaultProvider$readFileOrNull$2", m1609f = "PlatformJVM.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C38012 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
        final /* synthetic */ String $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C38012(String str, Continuation<? super C38012> continuation) {
            super(2, continuation);
            this.$path = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C38012(this.$path, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
            return ((C38012) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return FilesKt.readBytes(new File(this.$path));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.util.Filesystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object readFileOrNull(String str, Continuation<? super byte[]> continuation) {
        C38001 c38001;
        if (continuation instanceof C38001) {
            c38001 = (C38001) continuation;
            if ((c38001.label & Integer.MIN_VALUE) != 0) {
                c38001.label -= Integer.MIN_VALUE;
            } else {
                c38001 = new C38001(continuation);
            }
        }
        Object objWithContext = c38001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c38001.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objWithContext);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                C38012 c38012 = new C38012(str, null);
                c38001.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c38001.label = 1;
                objWithContext = BuildersKt.withContext(io2, c38012, c38001);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objWithContext);
            }
            return (byte[]) objWithContext;
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.util.SystemDefaultProvider$writeFile$2 */
    /* JADX INFO: compiled from: PlatformJVM.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.util.SystemDefaultProvider$writeFile$2", m1609f = "PlatformJVM.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C38022 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $data;
        final /* synthetic */ String $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C38022(String str, byte[] bArr, Continuation<? super C38022> continuation) {
            super(2, continuation);
            this.$path = str;
            this.$data = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C38022(this.$path, this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C38022) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FilesKt.writeBytes(new File(this.$path), this.$data);
            return Unit.INSTANCE;
        }
    }

    @Override // aws.smithy.kotlin.runtime.util.Filesystem
    public Object writeFile(String str, byte[] bArr, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C38022(str, bArr, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.util.Filesystem
    public boolean fileExists(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new File(path).exists();
    }

    public final Object readFileOrNull(Path path, Continuation<? super byte[]> continuation) {
        return readFileOrNull(path.toAbsolutePath().toString(), continuation);
    }

    public final Object readFileOrNull(File file, Continuation<? super byte[]> continuation) {
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return readFileOrNull(absolutePath, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.util.PropertyProvider
    public Map<String, String> getAllProperties() {
        Set setEntrySet = System.getProperties().entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
        Set<Map.Entry> set = setEntrySet;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set, 10)), 16));
        for (Map.Entry entry : set) {
            Intrinsics.checkNotNull(entry);
            Pair pairM1606to = TuplesKt.m1606to(entry.getKey().toString(), entry.getValue().toString());
            linkedHashMap.put(pairM1606to.getFirst(), pairM1606to.getSecond());
        }
        return linkedHashMap;
    }

    @Override // aws.smithy.kotlin.runtime.util.PropertyProvider
    public String getProperty(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return System.getProperty(key);
    }

    @Override // aws.smithy.kotlin.runtime.util.Filesystem
    public String getFilePathSeparator() {
        Object value = filePathSeparator.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (String) value;
    }
}
