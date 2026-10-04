package aws.smithy.kotlin.runtime.util;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.util.Filesystem;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: TestPlatformProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,BS\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u000fJ\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001a\u00020\u0004H\u0096A¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0019H\u0096A¢\u0006\u0004\b\u001e\u0010\u001fR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010 R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010!R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010 R\u0014\u0010$\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020\u00168\u0016X\u0096D¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'R\u001a\u0010(\u001a\u00020\u00168\u0016X\u0096D¢\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b(\u0010'R\u001a\u0010)\u001a\u00020\u00168\u0016X\u0096D¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b)\u0010'R\u001a\u0010*\u001a\u00020\u00168\u0016X\u0096D¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b*\u0010'R\u001a\u0010+\u001a\u00020\u00168\u0016X\u0096D¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b+\u0010'¨\u0006-"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/TestPlatformProvider;", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "Laws/smithy/kotlin/runtime/util/Filesystem;", "", "", "env", "props", "fs", "Laws/smithy/kotlin/runtime/util/OperatingSystem;", "os", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Laws/smithy/kotlin/runtime/util/OperatingSystem;)V", "osInfo", "()Laws/smithy/kotlin/runtime/util/OperatingSystem;", "getAllProperties", "()Ljava/util/Map;", SubscriberAttributeKt.JSON_NAME_KEY, "getProperty", "(Ljava/lang/String;)Ljava/lang/String;", "getAllEnvVars", "getenv", ClientCookie.PATH_ATTR, "", "fileExists", "(Ljava/lang/String;)Z", "", "readFileOrNull", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", "", "writeFile", "(Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/Map;", "Laws/smithy/kotlin/runtime/util/OperatingSystem;", "getFilePathSeparator", "()Ljava/lang/String;", "filePathSeparator", "isJvm", "Z", "()Z", "isAndroid", "isBrowser", "isNode", "isNative", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TestPlatformProvider implements PlatformProvider, Filesystem {
    private final /* synthetic */ Filesystem $$delegate_0;
    private final Map<String, String> env;
    private final Map<String, String> fs;
    private final boolean isAndroid;
    private final boolean isBrowser;
    private final boolean isJvm;
    private final boolean isNative;
    private final boolean isNode;
    private final OperatingSystem os;
    private final Map<String, String> props;

    /* JADX INFO: compiled from: TestPlatformProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OsFamily.values().length];
            try {
                iArr[OsFamily.Windows.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TestPlatformProvider() {
        this(null, null, null, null, 15, null);
    }

    @Override // aws.smithy.kotlin.runtime.util.Filesystem
    public boolean fileExists(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.$$delegate_0.fileExists(path);
    }

    @Override // aws.smithy.kotlin.runtime.util.Filesystem
    public Object readFileOrNull(String str, Continuation<? super byte[]> continuation) {
        return this.$$delegate_0.readFileOrNull(str, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.util.Filesystem
    public Object writeFile(String str, byte[] bArr, Continuation<? super Unit> continuation) {
        return this.$$delegate_0.writeFile(str, bArr, continuation);
    }

    public TestPlatformProvider(Map<String, String> env, Map<String, String> props, Map<String, String> fs, OperatingSystem os) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(fs, "fs");
        Intrinsics.checkNotNullParameter(os, "os");
        Filesystem.Companion companion = Filesystem.INSTANCE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(fs.size()));
        Iterator<T> it = fs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), StringsKt.encodeToByteArray((String) entry.getValue()));
        }
        this.$$delegate_0 = Filesystem.Companion.fromMap$default(companion, linkedHashMap, null, 2, null);
        this.props = props;
        this.fs = fs;
        this.os = os;
        if (!env.containsKey("HOME")) {
            env = MapsKt.toMutableMap(env);
            env.put("HOME", "/users/test");
        }
        this.env = env;
        this.isJvm = true;
    }

    public /* synthetic */ TestPlatformProvider(Map map, Map map2, Map map3, OperatingSystem operatingSystem, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? MapsKt.emptyMap() : map2, (i & 4) != 0 ? MapsKt.emptyMap() : map3, (i & 8) != 0 ? new OperatingSystem(OsFamily.Linux, "test") : operatingSystem);
    }

    @Override // aws.smithy.kotlin.runtime.util.Filesystem
    public String getFilePathSeparator() {
        if (WhenMappings.$EnumSwitchMapping$0[this.os.getFamily().ordinal()] == 1) {
            return "\\";
        }
        return DomExceptionUtils.SEPARATOR;
    }

    @Override // aws.smithy.kotlin.runtime.util.PlatformProvider
    /* JADX INFO: renamed from: isJvm, reason: from getter */
    public boolean getIsJvm() {
        return this.isJvm;
    }

    @Override // aws.smithy.kotlin.runtime.util.PlatformProvider
    /* JADX INFO: renamed from: isAndroid, reason: from getter */
    public boolean getIsAndroid() {
        return this.isAndroid;
    }

    @Override // aws.smithy.kotlin.runtime.util.PlatformProvider
    /* JADX INFO: renamed from: isBrowser, reason: from getter */
    public boolean getIsBrowser() {
        return this.isBrowser;
    }

    @Override // aws.smithy.kotlin.runtime.util.PlatformProvider
    /* JADX INFO: renamed from: isNode, reason: from getter */
    public boolean getIsNode() {
        return this.isNode;
    }

    @Override // aws.smithy.kotlin.runtime.util.PlatformProvider
    /* JADX INFO: renamed from: isNative, reason: from getter */
    public boolean getIsNative() {
        return this.isNative;
    }

    @Override // aws.smithy.kotlin.runtime.util.PlatformProvider
    /* JADX INFO: renamed from: osInfo, reason: from getter */
    public OperatingSystem getOs() {
        return this.os;
    }

    @Override // aws.smithy.kotlin.runtime.util.PropertyProvider
    public Map<String, String> getAllProperties() {
        return this.props;
    }

    @Override // aws.smithy.kotlin.runtime.util.PropertyProvider
    public String getProperty(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.props.get(key);
    }

    @Override // aws.smithy.kotlin.runtime.util.EnvironmentProvider
    public Map<String, String> getAllEnvVars() {
        return this.env;
    }

    @Override // aws.smithy.kotlin.runtime.util.EnvironmentProvider
    public String getenv(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.env.get(key);
    }
}
