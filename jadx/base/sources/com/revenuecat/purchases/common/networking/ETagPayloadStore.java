package com.revenuecat.purchases.common.networking;

import android.content.Context;
import androidx.collection.SieveCacheKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.CloseableKt;
import kotlin.p039io.FilesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ETagPayloadStore.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J'\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0082\bJ\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u000bJ\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/ETagPayloadStore;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "directory", "Ljava/io/File;", "(Ljava/io/File;)V", "clear", "", "crc32Of", "", "bytes", "", "deleteTrash", "drainInto", "out", "Ljava/io/OutputStream;", "byteBuffer", "Ljava/nio/ByteBuffer;", "step", "Lkotlin/Function0;", "Ljava/nio/charset/CoderResult;", "encodeTo", "rawOut", "payload", "", "fileFor", "urlString", "read", "expectedChecksum", "write", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ETagPayloadStore {

    @Deprecated
    public static final int CHUNK_CHARS = 65536;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String DIRECTORY_NAME = "etag_payloads";

    @Deprecated
    public static final String TEMP_SUFFIX = ".tmp";

    @Deprecated
    public static final String TRASH_SUFFIX = ".trash";

    @Deprecated
    public static final String VENDOR_DIRECTORY = "RevenueCat";

    @Deprecated
    public static final int WRITE_BUFFER_BYTES = 262144;
    private final File directory;

    public ETagPayloadStore(File directory) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.directory = directory;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ETagPayloadStore(Context context) {
        this(new File(new File(context.getCacheDir(), VENDOR_DIRECTORY), DIRECTORY_NAME));
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final Long write(String urlString, String payload) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (!this.directory.exists()) {
            deleteTrash();
            if (!this.directory.mkdirs()) {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to create ETag payload directory: " + this.directory, null);
                return null;
            }
        }
        File fileFileFor = fileFor(urlString);
        File file = new File(this.directory, fileFileFor.getName() + TEMP_SUFFIX);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                long jEncodeTo = encodeTo(fileOutputStream, payload);
                CloseableKt.closeFinally(fileOutputStream, null);
                if (file.renameTo(fileFileFor)) {
                    return Long.valueOf(jEncodeTo);
                }
                return null;
            } finally {
            }
        } catch (IOException e) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to persist ETag payload to disk.", e);
            return null;
        }
    }

    public final String read(String urlString, long expectedChecksum) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        try {
            FileInputStream fileInputStream = new FileInputStream(fileFor(urlString));
            try {
                FileInputStream fileInputStream2 = fileInputStream;
                long size = fileInputStream2.getChannel().size();
                if (size > SieveCacheKt.NodeLinkMask) {
                    CloseableKt.closeFinally(fileInputStream, null);
                    return null;
                }
                byte[] bArr = new byte[(int) size];
                new DataInputStream(fileInputStream2).readFully(bArr);
                if (crc32Of(bArr) != expectedChecksum) {
                    CloseableKt.closeFinally(fileInputStream, null);
                    return null;
                }
                String str = new String(bArr, Charsets.UTF_8);
                CloseableKt.closeFinally(fileInputStream, null);
                return str;
            } finally {
            }
        } catch (FileNotFoundException unused) {
            return null;
        } catch (IOException e) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to read ETag payload from disk.", e);
            return null;
        }
    }

    public final void clear() {
        if (this.directory.exists()) {
            if (this.directory.renameTo(new File(this.directory.getParentFile(), this.directory.getName() + TRASH_SUFFIX + System.nanoTime()))) {
                return;
            }
            FilesKt.deleteRecursively(this.directory);
        }
    }

    private final void deleteTrash() {
        File[] fileArrListFiles;
        File parentFile = this.directory.getParentFile();
        if (parentFile == null || (fileArrListFiles = parentFile.listFiles(new FileFilter() { // from class: com.revenuecat.purchases.common.networking.ETagPayloadStore$$ExternalSyntheticLambda0
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return ETagPayloadStore.deleteTrash$lambda$5(this.f$0, file);
            }
        })) == null) {
            return;
        }
        for (File it : fileArrListFiles) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            FilesKt.deleteRecursively(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteTrash$lambda$5(ETagPayloadStore eTagPayloadStore, File file) {
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        return StringsKt.startsWith$default(name, eTagPayloadStore.directory.getName() + TRASH_SUFFIX, false, 2, (Object) null);
    }

    private final File fileFor(String urlString) {
        File file = this.directory;
        Checksum.Companion companion = Checksum.INSTANCE;
        byte[] bytes = urlString.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return new File(file, companion.generate(bytes, Checksum.Algorithm.SHA256).getValue());
    }

    private final long crc32Of(byte[] bytes) {
        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        return crc32.getValue();
    }

    private final long encodeTo(OutputStream rawOut, String payload) throws IOException {
        CoderResult coderResultEncode;
        CheckedOutputStream checkedOutputStream;
        CoderResult coderResultFlush;
        CharsetEncoder charsetEncoderOnUnmappableCharacter = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
        CRC32 crc32 = new CRC32();
        CheckedOutputStream checkedOutputStream2 = new CheckedOutputStream(rawOut, crc32);
        char[] cArr = new char[65536];
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr);
        ByteBuffer byteBuffer = ByteBuffer.allocate(262144);
        int iRemaining = 0;
        int i = 0;
        while (true) {
            int iMin = Math.min(65536 - iRemaining, payload.length() - i);
            int i2 = i + iMin;
            payload.getChars(i, i2, cArr, iRemaining);
            boolean z = i2 == payload.length();
            charBufferWrap.position(0);
            charBufferWrap.limit(iRemaining + iMin);
            Intrinsics.checkNotNullExpressionValue(byteBuffer, "byteBuffer");
            do {
                coderResultEncode = charsetEncoderOnUnmappableCharacter.encode(charBufferWrap, byteBuffer, z);
                Intrinsics.checkNotNullExpressionValue(coderResultEncode, "encoder.encode(charBuffe… byteBuffer, isLastChunk)");
                if (coderResultEncode.isError()) {
                    coderResultEncode.throwException();
                }
                checkedOutputStream = checkedOutputStream2;
                checkedOutputStream.write(byteBuffer.array(), 0, byteBuffer.position());
                byteBuffer.clear();
            } while (!coderResultEncode.isUnderflow());
            iRemaining = charBufferWrap.remaining();
            if (iRemaining > 0) {
                System.arraycopy(cArr, charBufferWrap.position(), cArr, 0, iRemaining);
            }
            if (i2 >= payload.length()) {
                break;
            }
            i = i2;
        }
        do {
            coderResultFlush = charsetEncoderOnUnmappableCharacter.flush(byteBuffer);
            Intrinsics.checkNotNullExpressionValue(coderResultFlush, "encoder.flush(byteBuffer)");
            if (coderResultFlush.isError()) {
                coderResultFlush.throwException();
            }
            checkedOutputStream.write(byteBuffer.array(), 0, byteBuffer.position());
            byteBuffer.clear();
        } while (!coderResultFlush.isUnderflow());
        return crc32.getValue();
    }

    private final void drainInto(OutputStream out, ByteBuffer byteBuffer, Function0<? extends CoderResult> step) throws IOException {
        CoderResult coderResultInvoke;
        do {
            coderResultInvoke = step.invoke();
            if (coderResultInvoke.isError()) {
                coderResultInvoke.throwException();
            }
            out.write(byteBuffer.array(), 0, byteBuffer.position());
            byteBuffer.clear();
        } while (!coderResultInvoke.isUnderflow());
    }

    /* JADX INFO: compiled from: ETagPayloadStore.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/ETagPayloadStore$Companion;", "", "()V", "CHUNK_CHARS", "", "DIRECTORY_NAME", "", "TEMP_SUFFIX", "TRASH_SUFFIX", "VENDOR_DIRECTORY", "WRITE_BUFFER_BYTES", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
