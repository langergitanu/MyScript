package com.revenuecat.purchases.common.security;

import android.content.Context;
import android.util.AtomicFile;
import android.util.Base64;
import androidx.autofill.HintConstants;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EncryptedItemStorage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 $2\u00020\u0001:\u0002$%B3\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nB3\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J$\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00032\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110 H\u0002J \u0010!\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m1599d2 = {"Lcom/revenuecat/purchases/common/security/EncryptedItemStorage;", "Lcom/revenuecat/purchases/common/security/SecureItemStorage;", "backupFile", "Ljava/io/File;", "noBackupFile", SubscriberAttributeKt.JSON_NAME_KEY, "Ljavax/crypto/SecretKey;", "computationDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "(Ljava/io/File;Ljava/io/File;Ljavax/crypto/SecretKey;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "backup", "Lcom/revenuecat/purchases/common/security/EncryptedItemStorage$Partition;", "noBackup", "(Lcom/revenuecat/purchases/common/security/EncryptedItemStorage$Partition;Lcom/revenuecat/purchases/common/security/EncryptedItemStorage$Partition;Ljavax/crypto/SecretKey;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "allItemIdentifiers", "", "", "containsItem", "", Keys.IDENTIFIER, "decrypt", "", "data", "deleteItem", "", "encrypt", "plaintext", "readItem", "saveContents", "file", "contents", "", "saveItem", "attributes", "Lcom/revenuecat/purchases/common/security/SecureItemAttributes;", "Companion", "Partition", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class EncryptedItemStorage implements SecureItemStorage {
    private static final String CIPHER_TRANSFORMATION = "AES/GCM/NoPadding";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DEFAULT_SALT = "revenuecat";
    private static final String DEFAULT_STORAGE_NAME = "rc_secure";
    private static final int GCM_IV_LENGTH = 12;
    private static final int GCM_TAG_LENGTH_BITS = 128;
    private static final String KEY_ALGORITHM = "AES";
    private static final int KEY_LENGTH_BITS = 256;
    private static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int PBKDF2_ITERATIONS = 100000;
    private final Partition backup;
    private final CoroutineDispatcher computationDispatcher;
    private final CoroutineDispatcher ioDispatcher;
    private final SecretKey key;
    private final Partition noBackup;

    public /* synthetic */ EncryptedItemStorage(Partition partition, Partition partition2, SecretKey secretKey, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, DefaultConstructorMarker defaultConstructorMarker) {
        this(partition, partition2, secretKey, coroutineDispatcher, coroutineDispatcher2);
    }

    private EncryptedItemStorage(Partition partition, Partition partition2, SecretKey secretKey, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2) {
        this.backup = partition;
        this.noBackup = partition2;
        this.key = secretKey;
        this.computationDispatcher = coroutineDispatcher;
        this.ioDispatcher = coroutineDispatcher2;
    }

    /* synthetic */ EncryptedItemStorage(Partition partition, Partition partition2, SecretKey secretKey, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(partition, partition2, secretKey, (i & 8) != 0 ? Dispatchers.getDefault() : coroutineDispatcher, (i & 16) != 0 ? Dispatchers.getIO() : coroutineDispatcher2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: EncryptedItemStorage.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/common/security/EncryptedItemStorage$Partition;", "", "file", "Ljava/io/File;", "contents", "", "", "(Ljava/io/File;Ljava/util/Map;)V", "getContents", "()Ljava/util/Map;", "getFile", "()Ljava/io/File;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    static final /* data */ class Partition {
        private final Map<String, String> contents;
        private final File file;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Partition copy$default(Partition partition, File file, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                file = partition.file;
            }
            if ((i & 2) != 0) {
                map = partition.contents;
            }
            return partition.copy(file, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final File getFile() {
            return this.file;
        }

        public final Map<String, String> component2() {
            return this.contents;
        }

        public final Partition copy(File file, Map<String, String> contents) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(contents, "contents");
            return new Partition(file, contents);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Partition)) {
                return false;
            }
            Partition partition = (Partition) other;
            return Intrinsics.areEqual(this.file, partition.file) && Intrinsics.areEqual(this.contents, partition.contents);
        }

        public int hashCode() {
            return (this.file.hashCode() * 31) + this.contents.hashCode();
        }

        public String toString() {
            return "Partition(file=" + this.file + ", contents=" + this.contents + ')';
        }

        public Partition(File file, Map<String, String> contents) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(contents, "contents");
            this.file = file;
            this.contents = contents;
        }

        public final Map<String, String> getContents() {
            return this.contents;
        }

        public final File getFile() {
            return this.file;
        }
    }

    /* JADX INFO: compiled from: EncryptedItemStorage.kt */
    @Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0018J!\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m1599d2 = {"Lcom/revenuecat/purchases/common/security/EncryptedItemStorage$Companion;", "", "()V", "CIPHER_TRANSFORMATION", "", "DEFAULT_SALT", "DEFAULT_STORAGE_NAME", "GCM_IV_LENGTH", "", "GCM_TAG_LENGTH_BITS", "KEY_ALGORITHM", "KEY_LENGTH_BITS", "PBKDF2_ALGORITHM", "PBKDF2_ITERATIONS", "create", "Lcom/revenuecat/purchases/common/security/EncryptedItemStorage;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", HintConstants.AUTOFILL_HINT_PASSWORD, "", "salt", "computationDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "(Landroid/content/Context;[CLjava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadStore", "", "file", "Ljava/io/File;", "loadStore$purchases_defaultsRelease", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object create(Context context, char[] cArr, String str, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, Continuation<? super EncryptedItemStorage> continuation) throws GeneralSecurityException {
            EncryptedItemStorage$Companion$create$1 encryptedItemStorage$Companion$create$1;
            SecretKeySpec secretKeySpec;
            CoroutineDispatcher coroutineDispatcher3;
            CoroutineDispatcher coroutineDispatcher4;
            if (continuation instanceof EncryptedItemStorage$Companion$create$1) {
                encryptedItemStorage$Companion$create$1 = (EncryptedItemStorage$Companion$create$1) continuation;
                if ((encryptedItemStorage$Companion$create$1.label & Integer.MIN_VALUE) != 0) {
                    encryptedItemStorage$Companion$create$1.label -= Integer.MIN_VALUE;
                } else {
                    encryptedItemStorage$Companion$create$1 = new EncryptedItemStorage$Companion$create$1(this, continuation);
                }
            }
            Object objWithContext = encryptedItemStorage$Companion$create$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = encryptedItemStorage$Companion$create$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objWithContext);
                EncryptedItemStorage$Companion$create$key$1 encryptedItemStorage$Companion$create$key$1 = new EncryptedItemStorage$Companion$create$key$1(str, cArr, null);
                encryptedItemStorage$Companion$create$1.L$0 = context;
                encryptedItemStorage$Companion$create$1.L$1 = coroutineDispatcher;
                encryptedItemStorage$Companion$create$1.L$2 = coroutineDispatcher2;
                encryptedItemStorage$Companion$create$1.label = 1;
                objWithContext = BuildersKt.withContext(coroutineDispatcher, encryptedItemStorage$Companion$create$key$1, encryptedItemStorage$Companion$create$1);
                if (objWithContext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                secretKeySpec = (SecretKeySpec) encryptedItemStorage$Companion$create$1.L$2;
                CoroutineDispatcher coroutineDispatcher5 = (CoroutineDispatcher) encryptedItemStorage$Companion$create$1.L$1;
                CoroutineDispatcher coroutineDispatcher6 = (CoroutineDispatcher) encryptedItemStorage$Companion$create$1.L$0;
                ResultKt.throwOnFailure(objWithContext);
                coroutineDispatcher4 = coroutineDispatcher5;
                coroutineDispatcher3 = coroutineDispatcher6;
                Pair pair = (Pair) objWithContext;
                return new EncryptedItemStorage((Partition) pair.component1(), (Partition) pair.component2(), secretKeySpec, coroutineDispatcher3, coroutineDispatcher4, null);
            }
            coroutineDispatcher2 = (CoroutineDispatcher) encryptedItemStorage$Companion$create$1.L$2;
            coroutineDispatcher = (CoroutineDispatcher) encryptedItemStorage$Companion$create$1.L$1;
            context = (Context) encryptedItemStorage$Companion$create$1.L$0;
            ResultKt.throwOnFailure(objWithContext);
            SecretKeySpec secretKeySpec2 = (SecretKeySpec) objWithContext;
            EncryptedItemStorage$Companion$create$2 encryptedItemStorage$Companion$create$2 = new EncryptedItemStorage$Companion$create$2(new File(context.getFilesDir(), "rc_secure_backup.json"), new File(context.getNoBackupFilesDir(), "rc_secure_no_backup.json"), null);
            encryptedItemStorage$Companion$create$1.L$0 = coroutineDispatcher;
            encryptedItemStorage$Companion$create$1.L$1 = coroutineDispatcher2;
            encryptedItemStorage$Companion$create$1.L$2 = secretKeySpec2;
            encryptedItemStorage$Companion$create$1.label = 2;
            objWithContext = BuildersKt.withContext(coroutineDispatcher2, encryptedItemStorage$Companion$create$2, encryptedItemStorage$Companion$create$1);
            if (objWithContext != coroutine_suspended) {
                secretKeySpec = secretKeySpec2;
                coroutineDispatcher3 = coroutineDispatcher;
                coroutineDispatcher4 = coroutineDispatcher2;
                Pair pair2 = (Pair) objWithContext;
                return new EncryptedItemStorage((Partition) pair2.component1(), (Partition) pair2.component2(), secretKeySpec, coroutineDispatcher3, coroutineDispatcher4, null);
            }
            return coroutine_suspended;
        }

        public static /* synthetic */ Object create$default(Companion companion, Context context, char[] cArr, String str, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, Continuation continuation, int i, Object obj) throws GeneralSecurityException {
            if ((i & 4) != 0) {
                str = EncryptedItemStorage.DEFAULT_SALT;
            }
            String str2 = str;
            if ((i & 8) != 0) {
                coroutineDispatcher = Dispatchers.getDefault();
            }
            CoroutineDispatcher coroutineDispatcher3 = coroutineDispatcher;
            if ((i & 16) != 0) {
                coroutineDispatcher2 = Dispatchers.getIO();
            }
            return companion.create(context, cArr, str2, coroutineDispatcher3, coroutineDispatcher2, continuation);
        }

        public final Map<String, String> loadStore$purchases_defaultsRelease(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            if (!file.exists()) {
                return new LinkedHashMap();
            }
            try {
                byte[] bytes = new AtomicFile(file).readFully();
                Intrinsics.checkNotNullExpressionValue(bytes, "bytes");
                return MapsKt.toMutableMap(JSONObjectExtensionsKt.toMap$default(new JSONObject(new String(bytes, Charsets.UTF_8)), false, 1, null));
            } catch (Exception e) {
                LogLevel logLevel = LogLevel.WARN;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Failed to load secure store from " + file.getName() + ", starting empty: " + e);
                }
                return new LinkedHashMap();
            }
        }
    }

    public /* synthetic */ EncryptedItemStorage(File file, File file2, SecretKey secretKey, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, file2, secretKey, (i & 8) != 0 ? Dispatchers.getDefault() : coroutineDispatcher, (i & 16) != 0 ? Dispatchers.getIO() : coroutineDispatcher2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public EncryptedItemStorage(File backupFile, File noBackupFile, SecretKey key, CoroutineDispatcher computationDispatcher, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        Intrinsics.checkNotNullParameter(noBackupFile, "noBackupFile");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(computationDispatcher, "computationDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Companion companion = INSTANCE;
        this(new Partition(backupFile, companion.loadStore$purchases_defaultsRelease(backupFile)), new Partition(noBackupFile, companion.loadStore$purchases_defaultsRelease(noBackupFile)), key, computationDispatcher, ioDispatcher);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    @Override // com.revenuecat.purchases.common.security.SecureItemStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean containsItem(String identifier) {
        boolean z;
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        synchronized (this) {
            if (!this.backup.getContents().containsKey(identifier)) {
                z = this.noBackup.getContents().containsKey(identifier);
            }
        }
        return z;
    }

    @Override // com.revenuecat.purchases.common.security.SecureItemStorage
    public List<String> allItemIdentifiers() {
        List<String> list;
        synchronized (this) {
            list = CollectionsKt.toList(SetsKt.plus((Set) this.backup.getContents().keySet(), (Iterable) this.noBackup.getContents().keySet()));
        }
        return list;
    }

    @Override // com.revenuecat.purchases.common.security.SecureItemStorage
    public byte[] readItem(String identifier) throws SecureStorageException {
        String str;
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        synchronized (this) {
            str = this.backup.getContents().get(identifier);
            if (str == null) {
                str = this.noBackup.getContents().get(identifier);
            }
        }
        if (str == null) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 2);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(encoded, Base64.NO_WRAP)");
            return decrypt(bArrDecode, identifier);
        } catch (Exception e) {
            throw new SecureStorageException("Failed to read item '" + identifier + '\'', e);
        }
    }

    @Override // com.revenuecat.purchases.common.security.SecureItemStorage
    public void saveItem(String identifier, byte[] contents, SecureItemAttributes attributes) throws SecureStorageException {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(contents, "contents");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        try {
            String encoded = Base64.encodeToString(encrypt(contents, identifier), 2);
            Partition partition = attributes.getIncludedInBackup() ? this.backup : this.noBackup;
            Partition partition2 = attributes.getIncludedInBackup() ? this.noBackup : this.backup;
            synchronized (this) {
                boolean zContainsKey = partition2.getContents().containsKey(identifier);
                if (zContainsKey) {
                    saveContents(partition2.getFile(), MapsKt.minus(partition2.getContents(), identifier));
                }
                saveContents(partition.getFile(), MapsKt.plus(partition.getContents(), TuplesKt.m1606to(identifier, encoded)));
                if (zContainsKey) {
                    partition2.getContents().remove(identifier);
                }
                Map<String, String> contents2 = partition.getContents();
                Intrinsics.checkNotNullExpressionValue(encoded, "encoded");
                contents2.put(identifier, encoded);
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e) {
            throw new SecureStorageException("Failed to save item '" + identifier + '\'', e);
        }
    }

    @Override // com.revenuecat.purchases.common.security.SecureItemStorage
    public void deleteItem(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        synchronized (this) {
            boolean zContainsKey = this.backup.getContents().containsKey(identifier);
            boolean zContainsKey2 = this.noBackup.getContents().containsKey(identifier);
            if (zContainsKey) {
                saveContents(this.backup.getFile(), MapsKt.minus(this.backup.getContents(), identifier));
            }
            if (zContainsKey2) {
                saveContents(this.noBackup.getFile(), MapsKt.minus(this.noBackup.getContents(), identifier));
            }
            if (zContainsKey) {
                this.backup.getContents().remove(identifier);
            }
            if (zContainsKey2) {
                this.noBackup.getContents().remove(identifier);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final byte[] encrypt(byte[] plaintext, String identifier) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(1, this.key);
        byte[] bytes = identifier.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        cipher.updateAAD(bytes);
        byte[] ciphertext = cipher.doFinal(plaintext);
        byte[] iv = cipher.getIV();
        Intrinsics.checkNotNullExpressionValue(iv, "cipher.iv");
        Intrinsics.checkNotNullExpressionValue(ciphertext, "ciphertext");
        return ArraysKt.plus(iv, ciphertext);
    }

    private final byte[] decrypt(byte[] data, String identifier) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArrCopyOfRange = ArraysKt.copyOfRange(data, 0, 12);
        byte[] bArrCopyOfRange2 = ArraysKt.copyOfRange(data, 12, data.length);
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(2, this.key, new GCMParameterSpec(128, bArrCopyOfRange));
        byte[] bytes = identifier.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        cipher.updateAAD(bytes);
        byte[] bArrDoFinal = cipher.doFinal(bArrCopyOfRange2);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(ciphertext)");
        return bArrDoFinal;
    }

    private final void saveContents(File file, Map<String, String> contents) throws JSONException, SecureStorageException, IOException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : contents.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        AtomicFile atomicFile = new AtomicFile(file);
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "json.toString()");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            fileOutputStreamStartWrite.write(bytes);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } catch (Exception e) {
            atomicFile.failWrite(fileOutputStreamStartWrite);
            throw new SecureStorageException("Failed to write secure store to " + file.getName(), e);
        }
    }
}
