package com.dropbox.core.p012v1;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.credentials.provider.CredentialEntry;
import com.dropbox.core.BadRequestException;
import com.dropbox.core.BadResponseException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.DbxStreamWriter;
import com.dropbox.core.NetworkIOException;
import com.dropbox.core.NoThrowOutputStream;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.p012v1.DbxDelta;
import com.dropbox.core.p012v1.DbxDeltaC;
import com.dropbox.core.p012v1.DbxEntry;
import com.dropbox.core.util.Collector;
import com.dropbox.core.util.CountingOutputStream;
import com.dropbox.core.util.DumpWriter;
import com.dropbox.core.util.Dumpable;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.util.Maybe;
import com.dropbox.core.util.StringUtil;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.actions.SearchIntents;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class DbxClientV1 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ChunkedUploadChunkSize = 4194304;
    private static final long ChunkedUploadThreshold = 8388608;
    private static JsonReader<String> LatestCursorReader = new JsonReader<String>() { // from class: com.dropbox.core.v1.DbxClientV1.11
        @Override // com.dropbox.core.json.JsonReader
        public String read(JsonParser jsonParser) throws JsonReadException, IOException {
            JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
            String field = null;
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                try {
                    if (currentName.equals("cursor")) {
                        field = JsonReader.StringReader.readField(jsonParser, currentName, field);
                    } else {
                        JsonReader.skipValue(jsonParser);
                    }
                } catch (JsonReadException e) {
                    throw e.addFieldContext(currentName);
                }
            }
            JsonReader.expectObjectEnd(jsonParser);
            if (field != null) {
                return field;
            }
            throw new JsonReadException("missing field \"cursor\"", jsonLocationExpectObjectStart);
        }
    };
    public static final String USER_AGENT_ID = "Dropbox-Java-SDK";
    private final String accessToken;
    private final DbxHost host;
    private final DbxRequestConfig requestConfig;

    public static abstract class Uploader {
        public abstract void abort();

        public abstract void close();

        public abstract DbxEntry.File finish() throws DbxException;

        public abstract OutputStream getBody();
    }

    public DbxClientV1(DbxRequestConfig dbxRequestConfig, String str) {
        this(dbxRequestConfig, str, DbxHost.DEFAULT);
    }

    public DbxClientV1(DbxRequestConfig dbxRequestConfig, String str, DbxHost dbxHost) {
        if (dbxRequestConfig == null) {
            throw new IllegalArgumentException("'requestConfig' is null");
        }
        if (str == null) {
            throw new IllegalArgumentException("'accessToken' is null");
        }
        if (dbxHost == null) {
            throw new IllegalArgumentException("'host' is null");
        }
        this.requestConfig = dbxRequestConfig;
        this.accessToken = str;
        this.host = dbxHost;
    }

    public DbxRequestConfig getRequestConfig() {
        return this.requestConfig;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public DbxHost getHost() {
        return this.host;
    }

    public DbxEntry getMetadata(String str, boolean z) throws DbxException {
        DbxPathV1.checkArg(ClientCookie.PATH_ATTR, str);
        String api = this.host.getApi();
        String str2 = "1/metadata/auto" + str;
        String[] strArr = new String[4];
        strArr[0] = "list";
        strArr[1] = CredentialEntry.FALSE_STRING;
        strArr[2] = "include_media_info";
        strArr[3] = z ? CredentialEntry.TRUE_STRING : null;
        return (DbxEntry) doGet(api, str2, strArr, null, new DbxRequestUtil.ResponseHandler<DbxEntry>() { // from class: com.dropbox.core.v1.DbxClientV1.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxEntry handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() == 404) {
                    return null;
                }
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return (DbxEntry) DbxRequestUtil.readJsonFromResponse(DbxEntry.ReaderMaybeDeleted, response);
            }
        });
    }

    public DbxEntry getMetadata(String str) throws DbxException {
        return getMetadata(str, false);
    }

    public DbxEntry.WithChildren getMetadataWithChildren(String str, boolean z) throws DbxException {
        return (DbxEntry.WithChildren) getMetadataWithChildrenBase(str, z, DbxEntry.WithChildren.ReaderMaybeDeleted);
    }

    public DbxEntry.WithChildren getMetadataWithChildren(String str) throws DbxException {
        return getMetadataWithChildren(str, false);
    }

    public <C> DbxEntry.WithChildrenC<C> getMetadataWithChildrenC(String str, boolean z, Collector<DbxEntry, ? extends C> collector) throws DbxException {
        return (DbxEntry.WithChildrenC) getMetadataWithChildrenBase(str, z, new DbxEntry.WithChildrenC.ReaderMaybeDeleted(collector));
    }

    public <C> DbxEntry.WithChildrenC<C> getMetadataWithChildrenC(String str, Collector<DbxEntry, ? extends C> collector) throws DbxException {
        return getMetadataWithChildrenC(str, false, collector);
    }

    private <T> T getMetadataWithChildrenBase(String str, boolean z, final JsonReader<? extends T> jsonReader) throws DbxException {
        DbxPathV1.checkArg(ClientCookie.PATH_ATTR, str);
        String api = this.host.getApi();
        String str2 = "1/metadata/auto" + str;
        String[] strArr = new String[6];
        strArr[0] = "list";
        String str3 = CredentialEntry.TRUE_STRING;
        strArr[1] = CredentialEntry.TRUE_STRING;
        strArr[2] = "file_limit";
        strArr[3] = "25000";
        strArr[4] = "include_media_info";
        if (!z) {
            str3 = null;
        }
        strArr[5] = str3;
        return (T) doGet(api, str2, strArr, null, new DbxRequestUtil.ResponseHandler<T>() { // from class: com.dropbox.core.v1.DbxClientV1.2
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public T handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() == 404) {
                    return null;
                }
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return (T) DbxRequestUtil.readJsonFromResponse(jsonReader, response);
            }
        });
    }

    public Maybe<DbxEntry.WithChildren> getMetadataWithChildrenIfChanged(String str, boolean z, String str2) throws DbxException {
        return getMetadataWithChildrenIfChangedBase(str, z, str2, DbxEntry.WithChildren.ReaderMaybeDeleted);
    }

    public Maybe<DbxEntry.WithChildren> getMetadataWithChildrenIfChanged(String str, String str2) throws DbxException {
        return getMetadataWithChildrenIfChanged(str, false, str2);
    }

    public <C> Maybe<DbxEntry.WithChildrenC<C>> getMetadataWithChildrenIfChangedC(String str, boolean z, String str2, Collector<DbxEntry, ? extends C> collector) throws DbxException {
        return getMetadataWithChildrenIfChangedBase(str, z, str2, new DbxEntry.WithChildrenC.ReaderMaybeDeleted(collector));
    }

    public <C> Maybe<DbxEntry.WithChildrenC<C>> getMetadataWithChildrenIfChangedC(String str, String str2, Collector<DbxEntry, ? extends C> collector) throws DbxException {
        return getMetadataWithChildrenIfChangedC(str, false, str2, collector);
    }

    private <T> Maybe<T> getMetadataWithChildrenIfChangedBase(String str, boolean z, String str2, final JsonReader<T> jsonReader) throws DbxException {
        if (str2 == null) {
            throw new IllegalArgumentException("'previousFolderHash' must not be null");
        }
        if (str2.length() == 0) {
            throw new IllegalArgumentException("'previousFolderHash' must not be empty");
        }
        DbxPathV1.checkArg(ClientCookie.PATH_ATTR, str);
        String api = this.host.getApi();
        String str3 = "1/metadata/auto" + str;
        String[] strArr = new String[8];
        strArr[0] = "list";
        String str4 = CredentialEntry.TRUE_STRING;
        strArr[1] = CredentialEntry.TRUE_STRING;
        strArr[2] = "file_limit";
        strArr[3] = "25000";
        strArr[4] = "hash";
        strArr[5] = str2;
        strArr[6] = "include_media_info";
        if (!z) {
            str4 = null;
        }
        strArr[7] = str4;
        return (Maybe) doGet(api, str3, strArr, null, new DbxRequestUtil.ResponseHandler<Maybe<T>>() { // from class: com.dropbox.core.v1.DbxClientV1.3
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public Maybe<T> handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() == 404) {
                    return Maybe.Just(null);
                }
                if (response.getStatusCode() == 304) {
                    return Maybe.Nothing();
                }
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return Maybe.Just(DbxRequestUtil.readJsonFromResponse(jsonReader, response));
            }
        });
    }

    public DbxAccountInfo getAccountInfo() throws DbxException {
        return (DbxAccountInfo) doGet(this.host.getApi(), "1/account/info", null, null, new DbxRequestUtil.ResponseHandler<DbxAccountInfo>() { // from class: com.dropbox.core.v1.DbxClientV1.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxAccountInfo handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return (DbxAccountInfo) DbxRequestUtil.readJsonFromResponse(DbxAccountInfo.Reader, response);
            }
        });
    }

    public void disableAccessToken() throws DbxException {
        doPost(this.host.getApi(), "1/disable_access_token", null, null, new DbxRequestUtil.ResponseHandler<Void>() { // from class: com.dropbox.core.v1.DbxClientV1.5
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public Void handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() == 200) {
                    return null;
                }
                throw new BadResponseException(DbxRequestUtil.getRequestId(response), "unexpected response code: " + response.getStatusCode());
            }
        });
    }

    public DbxEntry.File getFile(String str, String str2, OutputStream outputStream) throws DbxException, IOException {
        Downloader downloaderStartGetFile = startGetFile(str, str2);
        if (downloaderStartGetFile == null) {
            return null;
        }
        return downloaderStartGetFile.copyBodyAndClose(outputStream);
    }

    public Downloader startGetFile(String str, String str2) throws DbxException {
        DbxPathV1.checkArgNonRoot(ClientCookie.PATH_ATTR, str);
        return startGetSomething("1/files/auto" + str, new String[]{"rev", str2});
    }

    private Downloader startGetSomething(final String str, final String[] strArr) throws DbxException {
        final String content = this.host.getContent();
        return (Downloader) DbxRequestUtil.runAndRetry(this.requestConfig.getMaxRetries(), new DbxRequestUtil.RequestMaker<Downloader, DbxException>() { // from class: com.dropbox.core.v1.DbxClientV1.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.RequestMaker
            public Downloader run() throws DbxException {
                HttpRequestor.Response responseStartGet = DbxRequestUtil.startGet(DbxClientV1.this.requestConfig, DbxClientV1.this.accessToken, DbxClientV1.USER_AGENT_ID, content, str, strArr, null);
                try {
                    if (responseStartGet.getStatusCode() == 404) {
                        return null;
                    }
                    if (responseStartGet.getStatusCode() != 200) {
                        throw DbxRequestUtil.unexpectedStatus(responseStartGet);
                    }
                    try {
                        return new Downloader(DbxEntry.File.Reader.readFully(DbxRequestUtil.getFirstHeader(responseStartGet, "x-dropbox-metadata")), responseStartGet.getBody());
                    } catch (JsonReadException e) {
                        throw new BadResponseException(DbxRequestUtil.getRequestId(responseStartGet), "Bad JSON in X-Dropbox-Metadata header: " + e.getMessage(), e);
                    }
                } finally {
                    try {
                        responseStartGet.getBody().close();
                    } catch (IOException unused) {
                    }
                }
            }
        });
    }

    public static final class Downloader {
        public final InputStream body;
        public final DbxEntry.File metadata;

        public Downloader(DbxEntry.File file, InputStream inputStream) {
            this.metadata = file;
            this.body = inputStream;
        }

        DbxEntry.File copyBodyAndClose(OutputStream outputStream) throws DbxException, IOException {
            try {
                try {
                    IOUtil.copyStreamToStream(this.body, outputStream);
                    close();
                    return this.metadata;
                } catch (IOUtil.ReadException e) {
                    throw new NetworkIOException(e.getCause());
                } catch (IOUtil.WriteException e2) {
                    throw e2.getCause();
                }
            } catch (Throwable th) {
                close();
                throw th;
            }
        }

        public void close() {
            IOUtil.closeInput(this.body);
        }
    }

    public DbxEntry.File uploadFile(String str, DbxWriteMode dbxWriteMode, long j, InputStream inputStream) throws DbxException, IOException {
        return uploadFile(str, dbxWriteMode, j, new DbxStreamWriter.InputStreamCopier(inputStream));
    }

    public <E extends Throwable> DbxEntry.File uploadFile(String str, DbxWriteMode dbxWriteMode, long j, DbxStreamWriter<E> dbxStreamWriter) throws Throwable {
        return finishUploadFile(startUploadFile(str, dbxWriteMode, j), dbxStreamWriter);
    }

    public Uploader startUploadFile(String str, DbxWriteMode dbxWriteMode, long j) throws DbxException {
        if (j < 0) {
            if (j != -1) {
                throw new IllegalArgumentException("numBytes must be -1 or greater; given " + j);
            }
            return startUploadFileChunked(str, dbxWriteMode, j);
        }
        if (j > ChunkedUploadThreshold) {
            return startUploadFileChunked(str, dbxWriteMode, j);
        }
        return startUploadFileSingle(str, dbxWriteMode, j);
    }

    public <E extends Throwable> DbxEntry.File finishUploadFile(Uploader uploader, DbxStreamWriter<E> dbxStreamWriter) throws Throwable {
        NoThrowOutputStream noThrowOutputStream = new NoThrowOutputStream(uploader.getBody());
        try {
            try {
                dbxStreamWriter.write(noThrowOutputStream);
                return uploader.finish();
            } catch (NoThrowOutputStream.HiddenException e) {
                if (e.owner == noThrowOutputStream) {
                    throw new NetworkIOException(e.getCause());
                }
                throw e;
            }
        } finally {
            uploader.close();
        }
    }

    public Uploader startUploadFileSingle(String str, DbxWriteMode dbxWriteMode, long j) throws DbxException {
        DbxPathV1.checkArg("targetPath", str);
        if (j < 0) {
            throw new IllegalArgumentException("numBytes must be zero or greater");
        }
        String content = this.host.getContent();
        String str2 = "1/files_put/auto" + str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HttpRequestor.Header("Content-Type", "application/octet-stream"));
        arrayList.add(new HttpRequestor.Header("Content-Length", Long.toString(j)));
        return new SingleUploader(DbxRequestUtil.startPut(this.requestConfig, this.accessToken, USER_AGENT_ID, content, str2, dbxWriteMode.params, arrayList), j);
    }

    public <E extends Throwable> DbxEntry.File uploadFileSingle(String str, DbxWriteMode dbxWriteMode, long j, DbxStreamWriter<E> dbxStreamWriter) throws Throwable {
        return finishUploadFile(startUploadFileSingle(str, dbxWriteMode, j), dbxStreamWriter);
    }

    private static final class SingleUploader extends Uploader {
        private final CountingOutputStream body;
        private final long claimedBytes;
        private HttpRequestor.Uploader httpUploader;

        public SingleUploader(HttpRequestor.Uploader uploader, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("'numBytes' must be greater than or equal to 0");
            }
            this.httpUploader = uploader;
            this.claimedBytes = j;
            this.body = new CountingOutputStream(uploader.getBody());
        }

        @Override // com.dropbox.core.v1.DbxClientV1.Uploader
        public OutputStream getBody() {
            return this.body;
        }

        @Override // com.dropbox.core.v1.DbxClientV1.Uploader
        public void abort() {
            HttpRequestor.Uploader uploader = this.httpUploader;
            if (uploader == null) {
                throw new IllegalStateException("already called 'finish', 'abort', or 'close'");
            }
            this.httpUploader = null;
            uploader.abort();
        }

        @Override // com.dropbox.core.v1.DbxClientV1.Uploader
        public void close() {
            if (this.httpUploader == null) {
                return;
            }
            abort();
        }

        @Override // com.dropbox.core.v1.DbxClientV1.Uploader
        public DbxEntry.File finish() throws DbxException {
            HttpRequestor.Uploader uploader = this.httpUploader;
            if (uploader == null) {
                throw new IllegalStateException("already called 'finish', 'abort', or 'close'");
            }
            this.httpUploader = null;
            try {
                try {
                    final long bytesWritten = this.body.getBytesWritten();
                    if (this.claimedBytes != bytesWritten) {
                        uploader.abort();
                        throw new IllegalStateException("You said you were going to upload " + this.claimedBytes + " bytes, but you wrote " + bytesWritten + " bytes to the Uploader's 'body' stream.");
                    }
                    HttpRequestor.Response responseFinish = uploader.finish();
                    uploader.close();
                    return (DbxEntry.File) DbxRequestUtil.finishResponse(responseFinish, new DbxRequestUtil.ResponseHandler<DbxEntry.File>() { // from class: com.dropbox.core.v1.DbxClientV1.SingleUploader.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
                        public DbxEntry.File handle(HttpRequestor.Response response) throws DbxException {
                            if (response.getStatusCode() != 200) {
                                throw DbxRequestUtil.unexpectedStatus(response);
                            }
                            DbxEntry.File file = (DbxEntry.File) DbxRequestUtil.readJsonFromResponse(DbxEntry.File.Reader, response);
                            if (file.numBytes == bytesWritten) {
                                return file;
                            }
                            throw new BadResponseException(DbxRequestUtil.getRequestId(response), "we uploaded " + bytesWritten + ", but server returned metadata entry with file size " + file.numBytes);
                        }
                    });
                } catch (IOException e) {
                    throw new NetworkIOException(e);
                }
            } catch (Throwable th) {
                uploader.close();
                throw th;
            }
        }
    }

    private static final class ChunkedUploadState extends Dumpable {
        public static final JsonReader<ChunkedUploadState> Reader = new JsonReader<ChunkedUploadState>() { // from class: com.dropbox.core.v1.DbxClientV1.ChunkedUploadState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.json.JsonReader
            public ChunkedUploadState read(JsonParser jsonParser) throws JsonReadException, IOException {
                JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
                String field = null;
                long unsignedLongField = -1;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    try {
                        if (currentName.equals("upload_id")) {
                            field = JsonReader.StringReader.readField(jsonParser, currentName, field);
                        } else if (currentName.equals(TypedValues.CycleType.S_WAVE_OFFSET)) {
                            unsignedLongField = JsonReader.readUnsignedLongField(jsonParser, currentName, unsignedLongField);
                        } else {
                            JsonReader.skipValue(jsonParser);
                        }
                    } catch (JsonReadException e) {
                        throw e.addFieldContext(currentName);
                    }
                }
                JsonReader.expectObjectEnd(jsonParser);
                if (field == null) {
                    throw new JsonReadException("missing field \"upload_id\"", jsonLocationExpectObjectStart);
                }
                if (unsignedLongField == -1) {
                    throw new JsonReadException("missing field \"offset\"", jsonLocationExpectObjectStart);
                }
                return new ChunkedUploadState(field, unsignedLongField);
            }
        };
        public final long offset;
        public final String uploadId;

        public ChunkedUploadState(String str, long j) {
            if (str == null) {
                throw new IllegalArgumentException("'uploadId' can't be null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("'uploadId' can't be empty");
            }
            if (j < 0) {
                throw new IllegalArgumentException("'offset' can't be negative");
            }
            this.uploadId = str;
            this.offset = j;
        }

        @Override // com.dropbox.core.util.Dumpable
        protected void dumpFields(DumpWriter dumpWriter) {
            dumpWriter.mo519f("uploadId").m527v(this.uploadId);
            dumpWriter.mo519f(TypedValues.CycleType.S_WAVE_OFFSET).m523v(this.offset);
        }
    }

    private <E extends Throwable> HttpRequestor.Response chunkedUploadCommon(String[] strArr, long j, DbxStreamWriter<E> dbxStreamWriter) throws Throwable {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HttpRequestor.Header("Content-Type", "application/octet-stream"));
        arrayList.add(new HttpRequestor.Header("Content-Length", Long.toString(j)));
        HttpRequestor.Uploader uploaderStartPut = DbxRequestUtil.startPut(this.requestConfig, this.accessToken, USER_AGENT_ID, this.host.getContent(), "1/chunked_upload", strArr, arrayList);
        try {
            NoThrowOutputStream noThrowOutputStream = new NoThrowOutputStream(uploaderStartPut.getBody());
            try {
                dbxStreamWriter.write(noThrowOutputStream);
                long bytesWritten = noThrowOutputStream.getBytesWritten();
                if (bytesWritten != j) {
                    throw new IllegalStateException("'chunkSize' is " + j + ", but 'writer' only wrote " + bytesWritten + " bytes");
                }
                try {
                    return uploaderStartPut.finish();
                } catch (IOException e) {
                    throw new NetworkIOException(e);
                }
            } catch (NoThrowOutputStream.HiddenException e2) {
                if (e2.owner == noThrowOutputStream) {
                    throw new NetworkIOException(e2.getCause());
                }
                throw e2;
            }
        } finally {
            uploaderStartPut.close();
        }
    }

    private ChunkedUploadState chunkedUploadCheckForOffsetCorrection(HttpRequestor.Response response) throws DbxException {
        if (response.getStatusCode() != 400) {
            return null;
        }
        byte[] bArrLoadErrorBody = DbxRequestUtil.loadErrorBody(response);
        try {
            return ChunkedUploadState.Reader.readFully(bArrLoadErrorBody);
        } catch (JsonReadException unused) {
            String requestId = DbxRequestUtil.getRequestId(response);
            throw new BadRequestException(requestId, DbxRequestUtil.parseErrorBody(requestId, 400, bArrLoadErrorBody));
        }
    }

    private ChunkedUploadState chunkedUploadParse200(HttpRequestor.Response response) throws NetworkIOException, BadResponseException {
        return (ChunkedUploadState) DbxRequestUtil.readJsonFromResponse(ChunkedUploadState.Reader, response);
    }

    public String chunkedUploadFirst(byte[] bArr) throws DbxException {
        return chunkedUploadFirst(bArr, 0, bArr.length);
    }

    public String chunkedUploadFirst(byte[] bArr, int i, int i2) throws DbxException {
        return chunkedUploadFirst(i2, new DbxStreamWriter.ByteArrayCopier(bArr, i, i2));
    }

    public <E extends Throwable> String chunkedUploadFirst(int i, DbxStreamWriter<E> dbxStreamWriter) throws Throwable {
        long j = i;
        HttpRequestor.Response responseChunkedUploadCommon = chunkedUploadCommon(new String[0], j, dbxStreamWriter);
        try {
            if (chunkedUploadCheckForOffsetCorrection(responseChunkedUploadCommon) != null) {
                throw new BadResponseException(DbxRequestUtil.getRequestId(responseChunkedUploadCommon), "Got offset correction response on first chunk.");
            }
            if (responseChunkedUploadCommon.getStatusCode() == 404) {
                throw new BadResponseException(DbxRequestUtil.getRequestId(responseChunkedUploadCommon), "Got a 404, but we didn't send an upload_id");
            }
            if (responseChunkedUploadCommon.getStatusCode() != 200) {
                throw DbxRequestUtil.unexpectedStatus(responseChunkedUploadCommon);
            }
            ChunkedUploadState chunkedUploadStateChunkedUploadParse200 = chunkedUploadParse200(responseChunkedUploadCommon);
            if (chunkedUploadStateChunkedUploadParse200.offset != j) {
                throw new BadResponseException(DbxRequestUtil.getRequestId(responseChunkedUploadCommon), "Sent " + i + " bytes, but returned offset is " + chunkedUploadStateChunkedUploadParse200.offset);
            }
            return chunkedUploadStateChunkedUploadParse200.uploadId;
        } finally {
            IOUtil.closeInput(responseChunkedUploadCommon.getBody());
        }
    }

    public long chunkedUploadAppend(String str, long j, byte[] bArr) throws DbxException {
        return chunkedUploadAppend(str, j, bArr, 0, bArr.length);
    }

    public long chunkedUploadAppend(String str, long j, byte[] bArr, int i, int i2) throws DbxException {
        return chunkedUploadAppend(str, j, i2, new DbxStreamWriter.ByteArrayCopier(bArr, i, i2));
    }

    public <E extends Throwable> long chunkedUploadAppend(String str, long j, long j2, DbxStreamWriter<E> dbxStreamWriter) throws Throwable {
        if (str == null) {
            throw new IllegalArgumentException("'uploadId' can't be null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("'uploadId' can't be empty");
        }
        if (j < 0) {
            throw new IllegalArgumentException("'offset' can't be negative");
        }
        HttpRequestor.Response responseChunkedUploadCommon = chunkedUploadCommon(new String[]{"upload_id", str, TypedValues.CycleType.S_WAVE_OFFSET, Long.toString(j)}, j2, dbxStreamWriter);
        String requestId = DbxRequestUtil.getRequestId(responseChunkedUploadCommon);
        try {
            ChunkedUploadState chunkedUploadStateChunkedUploadCheckForOffsetCorrection = chunkedUploadCheckForOffsetCorrection(responseChunkedUploadCommon);
            long j3 = j2 + j;
            if (chunkedUploadStateChunkedUploadCheckForOffsetCorrection != null) {
                if (!chunkedUploadStateChunkedUploadCheckForOffsetCorrection.uploadId.equals(str)) {
                    throw new BadResponseException(requestId, "uploadId mismatch: us=" + StringUtil.m531jq(str) + ", server=" + StringUtil.m531jq(chunkedUploadStateChunkedUploadCheckForOffsetCorrection.uploadId));
                }
                if (chunkedUploadStateChunkedUploadCheckForOffsetCorrection.offset == j) {
                    throw new BadResponseException(requestId, "Corrected offset is same as given: " + j);
                }
                if (chunkedUploadStateChunkedUploadCheckForOffsetCorrection.offset < j) {
                    throw new BadResponseException(requestId, "we were at offset " + j + ", server said " + chunkedUploadStateChunkedUploadCheckForOffsetCorrection.offset);
                }
                if (chunkedUploadStateChunkedUploadCheckForOffsetCorrection.offset > j3) {
                    throw new BadResponseException(requestId, "we were at offset " + j + ", server said " + chunkedUploadStateChunkedUploadCheckForOffsetCorrection.offset);
                }
                return chunkedUploadStateChunkedUploadCheckForOffsetCorrection.offset;
            }
            if (responseChunkedUploadCommon.getStatusCode() != 200) {
                throw DbxRequestUtil.unexpectedStatus(responseChunkedUploadCommon);
            }
            ChunkedUploadState chunkedUploadStateChunkedUploadParse200 = chunkedUploadParse200(responseChunkedUploadCommon);
            if (chunkedUploadStateChunkedUploadParse200.offset != j3) {
                throw new BadResponseException(requestId, "Expected offset " + j3 + " bytes, but returned offset is " + chunkedUploadStateChunkedUploadParse200.offset);
            }
            IOUtil.closeInput(responseChunkedUploadCommon.getBody());
            return -1L;
        } finally {
            IOUtil.closeInput(responseChunkedUploadCommon.getBody());
        }
    }

    public DbxEntry.File chunkedUploadFinish(String str, DbxWriteMode dbxWriteMode, String str2) throws DbxException {
        DbxPathV1.checkArgNonRoot("targetPath", str);
        return (DbxEntry.File) doPost(this.host.getContent(), "1/commit_chunked_upload/auto" + str, (String[]) LangUtil.arrayConcat(new String[]{"upload_id", str2}, dbxWriteMode.params), null, new DbxRequestUtil.ResponseHandler<DbxEntry.File>() { // from class: com.dropbox.core.v1.DbxClientV1.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxEntry.File handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return (DbxEntry.File) DbxRequestUtil.readJsonFromResponse(DbxEntry.File.Reader, response);
            }
        });
    }

    public Uploader startUploadFileChunked(String str, DbxWriteMode dbxWriteMode, long j) {
        return startUploadFileChunked(4194304, str, dbxWriteMode, j);
    }

    public Uploader startUploadFileChunked(int i, String str, DbxWriteMode dbxWriteMode, long j) {
        DbxPathV1.checkArg("targetPath", str);
        if (dbxWriteMode == null) {
            throw new IllegalArgumentException("'writeMode' can't be null");
        }
        return new ChunkedUploader(str, dbxWriteMode, j, new ChunkedUploadOutputStream(i));
    }

    public <E extends Throwable> DbxEntry.File uploadFileChunked(String str, DbxWriteMode dbxWriteMode, long j, DbxStreamWriter<E> dbxStreamWriter) throws Throwable {
        return finishUploadFile(startUploadFileChunked(str, dbxWriteMode, j), dbxStreamWriter);
    }

    public <E extends Throwable> DbxEntry.File uploadFileChunked(int i, String str, DbxWriteMode dbxWriteMode, long j, DbxStreamWriter<E> dbxStreamWriter) throws Throwable {
        return finishUploadFile(startUploadFileChunked(i, str, dbxWriteMode, j), dbxStreamWriter);
    }

    private final class ChunkedUploader extends Uploader {
        private final ChunkedUploadOutputStream body;
        private final long numBytes;
        private final String targetPath;
        private final DbxWriteMode writeMode;

        @Override // com.dropbox.core.v1.DbxClientV1.Uploader
        public void abort() {
        }

        @Override // com.dropbox.core.v1.DbxClientV1.Uploader
        public void close() {
        }

        private ChunkedUploader(String str, DbxWriteMode dbxWriteMode, long j, ChunkedUploadOutputStream chunkedUploadOutputStream) {
            this.targetPath = str;
            this.writeMode = dbxWriteMode;
            this.numBytes = j;
            this.body = chunkedUploadOutputStream;
        }

        @Override // com.dropbox.core.v1.DbxClientV1.Uploader
        public OutputStream getBody() {
            return this.body;
        }

        @Override // com.dropbox.core.v1.DbxClientV1.Uploader
        public DbxEntry.File finish() throws DbxException {
            if (this.body.uploadId == null) {
                return DbxClientV1.this.uploadFileSingle(this.targetPath, this.writeMode, this.body.chunkPos, new DbxStreamWriter.ByteArrayCopier(this.body.chunk, 0, this.body.chunkPos));
            }
            final String str = this.body.uploadId;
            this.body.finishChunk();
            long j = this.numBytes;
            if (j != -1 && j != this.body.uploadOffset) {
                throw new IllegalStateException("'numBytes' is " + this.numBytes + " but you wrote " + this.body.uploadOffset + " bytes");
            }
            return (DbxEntry.File) DbxRequestUtil.runAndRetry(3, new DbxRequestUtil.RequestMaker<DbxEntry.File, RuntimeException>() { // from class: com.dropbox.core.v1.DbxClientV1.ChunkedUploader.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.dropbox.core.DbxRequestUtil.RequestMaker
                public DbxEntry.File run() throws DbxException {
                    return DbxClientV1.this.chunkedUploadFinish(ChunkedUploader.this.targetPath, ChunkedUploader.this.writeMode, str);
                }
            });
        }
    }

    private final class ChunkedUploadOutputStream extends OutputStream {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final byte[] chunk;
        private int chunkPos;
        private String uploadId;
        private long uploadOffset;

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        private ChunkedUploadOutputStream(int i) {
            this.chunkPos = 0;
            this.chunk = new byte[i];
            this.chunkPos = 0;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            byte[] bArr = this.chunk;
            int i2 = this.chunkPos;
            this.chunkPos = i2 + 1;
            bArr[i2] = (byte) i;
            try {
                finishChunkIfNecessary();
            } catch (DbxException e) {
                throw new IODbxException(e);
            }
        }

        private void finishChunkIfNecessary() throws DbxException {
            if (this.chunkPos == this.chunk.length) {
                finishChunk();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void finishChunk() throws DbxException {
            long j;
            if (this.chunkPos == 0) {
                return;
            }
            final String str = this.uploadId;
            if (str == null) {
                this.uploadId = (String) DbxRequestUtil.runAndRetry(3, new DbxRequestUtil.RequestMaker<String, RuntimeException>() { // from class: com.dropbox.core.v1.DbxClientV1.ChunkedUploadOutputStream.1
                    @Override // com.dropbox.core.DbxRequestUtil.RequestMaker
                    public String run() throws DbxException {
                        return DbxClientV1.this.chunkedUploadFirst(ChunkedUploadOutputStream.this.chunk, 0, ChunkedUploadOutputStream.this.chunkPos);
                    }
                });
                this.uploadOffset = this.chunkPos;
            } else {
                final int i = 0;
                while (true) {
                    long jLongValue = ((Long) DbxRequestUtil.runAndRetry(3, new DbxRequestUtil.RequestMaker<Long, RuntimeException>() { // from class: com.dropbox.core.v1.DbxClientV1.ChunkedUploadOutputStream.2
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.dropbox.core.DbxRequestUtil.RequestMaker
                        public Long run() throws DbxException {
                            return Long.valueOf(DbxClientV1.this.chunkedUploadAppend(str, ChunkedUploadOutputStream.this.uploadOffset, ChunkedUploadOutputStream.this.chunk, i, ChunkedUploadOutputStream.this.chunkPos - i));
                        }
                    })).longValue();
                    long j2 = this.uploadOffset;
                    j = ((long) this.chunkPos) + j2;
                    if (jLongValue == -1) {
                        break;
                    } else {
                        i += (int) (jLongValue - j2);
                    }
                }
                this.uploadOffset = j;
            }
            this.chunkPos = 0;
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            int i3 = i2 + i;
            while (i < i3) {
                int iMin = Math.min(i3 - i, this.chunk.length - this.chunkPos);
                System.arraycopy(bArr, i, this.chunk, this.chunkPos, iMin);
                this.chunkPos += iMin;
                i += iMin;
                try {
                    finishChunkIfNecessary();
                } catch (DbxException e) {
                    throw new IODbxException(e);
                }
            }
        }
    }

    public static final class IODbxException extends IOException {
        private static final long serialVersionUID = 0;
        public final DbxException underlying;

        public IODbxException(DbxException dbxException) {
            super(dbxException);
            this.underlying = dbxException;
        }
    }

    public DbxDelta<DbxEntry> getDelta(String str, boolean z) throws DbxException {
        return _getDelta(str, null, z);
    }

    public DbxDelta<DbxEntry> getDelta(String str) throws DbxException {
        return getDelta(str, false);
    }

    public <C> DbxDeltaC<C> getDeltaC(Collector<DbxDeltaC.Entry<DbxEntry>, C> collector, String str, boolean z) throws DbxException {
        return _getDeltaC(collector, str, null, z);
    }

    public <C> DbxDeltaC<C> getDeltaC(Collector<DbxDeltaC.Entry<DbxEntry>, C> collector, String str) throws DbxException {
        return getDeltaC(collector, str, false);
    }

    public DbxDelta<DbxEntry> getDeltaWithPathPrefix(String str, String str2, boolean z) throws DbxException {
        DbxPathV1.checkArg(ClientCookie.PATH_ATTR, str2);
        return _getDelta(str, str2, z);
    }

    public DbxDelta<DbxEntry> getDeltaWithPathPrefix(String str, String str2) throws DbxException {
        DbxPathV1.checkArg(ClientCookie.PATH_ATTR, str2);
        return _getDelta(str, str2, false);
    }

    public <C> DbxDeltaC<C> getDeltaCWithPathPrefix(Collector<DbxDeltaC.Entry<DbxEntry>, C> collector, String str, String str2, boolean z) throws DbxException {
        DbxPathV1.checkArg(ClientCookie.PATH_ATTR, str2);
        return _getDeltaC(collector, str, str2, z);
    }

    public <C> DbxDeltaC<C> getDeltaCWithPathPrefix(Collector<DbxDeltaC.Entry<DbxEntry>, C> collector, String str, String str2) throws DbxException {
        return getDeltaCWithPathPrefix(collector, str, str2, false);
    }

    private DbxDelta<DbxEntry> _getDelta(String str, String str2, boolean z) throws DbxException {
        String api = this.host.getApi();
        String[] strArr = new String[6];
        strArr[0] = "cursor";
        strArr[1] = str;
        strArr[2] = "path_prefix";
        strArr[3] = str2;
        strArr[4] = "include_media_info";
        strArr[5] = z ? CredentialEntry.TRUE_STRING : null;
        return (DbxDelta) doPost(api, "1/delta", strArr, null, new DbxRequestUtil.ResponseHandler<DbxDelta<DbxEntry>>() { // from class: com.dropbox.core.v1.DbxClientV1.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxDelta<DbxEntry> handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return (DbxDelta) DbxRequestUtil.readJsonFromResponse(new DbxDelta.Reader(DbxEntry.Reader), response);
            }
        });
    }

    private <C> DbxDeltaC<C> _getDeltaC(final Collector<DbxDeltaC.Entry<DbxEntry>, C> collector, String str, String str2, boolean z) throws DbxException {
        String api = this.host.getApi();
        String[] strArr = new String[6];
        strArr[0] = "cursor";
        strArr[1] = str;
        strArr[2] = "path_prefix";
        strArr[3] = str2;
        strArr[4] = "include_media_info";
        strArr[5] = z ? CredentialEntry.TRUE_STRING : null;
        return (DbxDeltaC) doPost(api, "1/delta", strArr, null, new DbxRequestUtil.ResponseHandler<DbxDeltaC<C>>() { // from class: com.dropbox.core.v1.DbxClientV1.9
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxDeltaC<C> handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return (DbxDeltaC) DbxRequestUtil.readJsonFromResponse(new DbxDeltaC.Reader(DbxEntry.Reader, collector), response);
            }
        });
    }

    public String getDeltaLatestCursor(boolean z) throws DbxException {
        return _getDeltaLatestCursor(null, z);
    }

    public String getDeltaLatestCursor() throws DbxException {
        return _getDeltaLatestCursor(null, false);
    }

    public String getDeltaLatestCursorWithPathPrefix(String str, boolean z) throws DbxException {
        DbxPathV1.checkArg(ClientCookie.PATH_ATTR, str);
        return _getDeltaLatestCursor(str, z);
    }

    public String getDeltaLatestCursorWithPathPrefix(String str) throws DbxException {
        return getDeltaLatestCursorWithPathPrefix(str, false);
    }

    private String _getDeltaLatestCursor(String str, boolean z) throws DbxException {
        String api = this.host.getApi();
        String[] strArr = new String[4];
        strArr[0] = "path_prefix";
        strArr[1] = str;
        strArr[2] = "include_media_info";
        strArr[3] = z ? CredentialEntry.TRUE_STRING : null;
        return (String) doPost(api, "1/delta/latest_cursor", strArr, null, new DbxRequestUtil.ResponseHandler<String>() { // from class: com.dropbox.core.v1.DbxClientV1.10
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public String handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() == 200) {
                    return (String) DbxRequestUtil.readJsonFromResponse(DbxClientV1.LatestCursorReader, response);
                }
                throw DbxRequestUtil.unexpectedStatus(response);
            }
        });
    }

    public DbxLongpollDeltaResult getLongpollDelta(String str, int i) throws DbxException {
        if (str == null) {
            throw new IllegalArgumentException("'cursor' can't be null");
        }
        if (i < 30 || i > 480) {
            throw new IllegalArgumentException("'timeout' must be >=30 and <= 480");
        }
        return (DbxLongpollDeltaResult) DbxRequestUtil.doGet(getRequestConfig(), getAccessToken(), USER_AGENT_ID, this.host.getNotify(), "1/longpoll_delta", new String[]{"cursor", str, "timeout", Integer.toString(i)}, null, new DbxRequestUtil.ResponseHandler<DbxLongpollDeltaResult>() { // from class: com.dropbox.core.v1.DbxClientV1.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxLongpollDeltaResult handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return (DbxLongpollDeltaResult) DbxRequestUtil.readJsonFromResponse(DbxLongpollDeltaResult.Reader, response);
            }
        });
    }

    public DbxEntry.File getThumbnail(DbxThumbnailSize dbxThumbnailSize, DbxThumbnailFormat dbxThumbnailFormat, String str, String str2, OutputStream outputStream) throws DbxException, IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("'target' can't be null");
        }
        Downloader downloaderStartGetThumbnail = startGetThumbnail(dbxThumbnailSize, dbxThumbnailFormat, str, str2);
        if (downloaderStartGetThumbnail == null) {
            return null;
        }
        return downloaderStartGetThumbnail.copyBodyAndClose(outputStream);
    }

    public Downloader startGetThumbnail(DbxThumbnailSize dbxThumbnailSize, DbxThumbnailFormat dbxThumbnailFormat, String str, String str2) throws DbxException {
        DbxPathV1.checkArgNonRoot(ClientCookie.PATH_ATTR, str);
        if (dbxThumbnailSize == null) {
            throw new IllegalArgumentException("'size' can't be null");
        }
        if (dbxThumbnailFormat == null) {
            throw new IllegalArgumentException("'format' can't be null");
        }
        return startGetSomething("1/thumbnails/auto" + str, new String[]{"size", dbxThumbnailSize.ident, "format", dbxThumbnailFormat.ident, "rev", str2});
    }

    public List<DbxEntry.File> getRevisions(String str) throws DbxException {
        DbxPathV1.checkArgNonRoot(ClientCookie.PATH_ATTR, str);
        return (List) doGet(this.host.getApi(), "1/revisions/auto" + str, null, null, new DbxRequestUtil.ResponseHandler<List<DbxEntry.File>>() { // from class: com.dropbox.core.v1.DbxClientV1.13
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public List<DbxEntry.File> handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return (List) DbxRequestUtil.readJsonFromResponse(JsonArrayReader.m517mk(DbxEntry.File.ReaderMaybeDeleted, Collector.NullSkipper.m518mk(new Collector.ArrayListCollector())), response);
            }
        });
    }

    public DbxEntry.File restoreFile(String str, String str2) throws DbxException {
        DbxPathV1.checkArgNonRoot(ClientCookie.PATH_ATTR, str);
        if (str2 == null) {
            throw new IllegalArgumentException("'rev' can't be null");
        }
        if (str2.length() == 0) {
            throw new IllegalArgumentException("'rev' can't be empty");
        }
        return (DbxEntry.File) doGet(this.host.getApi(), "1/restore/auto" + str, new String[]{"rev", str2}, null, new DbxRequestUtil.ResponseHandler<DbxEntry.File>() { // from class: com.dropbox.core.v1.DbxClientV1.14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxEntry.File handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() == 404) {
                    return null;
                }
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return (DbxEntry.File) DbxRequestUtil.readJsonFromResponse(DbxEntry.File.Reader, response);
            }
        });
    }

    public List<DbxEntry> searchFileAndFolderNames(String str, String str2) throws DbxException {
        DbxPathV1.checkArg("basePath", str);
        if (str2 == null) {
            throw new IllegalArgumentException("'query' can't be null");
        }
        if (str2.length() == 0) {
            throw new IllegalArgumentException("'query' can't be empty");
        }
        return (List) doPost(this.host.getApi(), "1/search/auto" + str, new String[]{SearchIntents.EXTRA_QUERY, str2}, null, new DbxRequestUtil.ResponseHandler<List<DbxEntry>>() { // from class: com.dropbox.core.v1.DbxClientV1.15
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public List<DbxEntry> handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return (List) DbxRequestUtil.readJsonFromResponse(JsonArrayReader.m516mk(DbxEntry.Reader), response);
            }
        });
    }

    public String createShareableUrl(String str) throws DbxException {
        DbxPathV1.checkArg(ClientCookie.PATH_ATTR, str);
        return (String) doPost(this.host.getApi(), "1/shares/auto" + str, new String[]{"short_url", CredentialEntry.FALSE_STRING}, null, new DbxRequestUtil.ResponseHandler<String>() { // from class: com.dropbox.core.v1.DbxClientV1.16
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public String handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() == 404) {
                    return null;
                }
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return ((DbxUrlWithExpiration) DbxRequestUtil.readJsonFromResponse(DbxUrlWithExpiration.Reader, response)).url;
            }
        });
    }

    public DbxUrlWithExpiration createTemporaryDirectUrl(String str) throws DbxException {
        DbxPathV1.checkArgNonRoot(ClientCookie.PATH_ATTR, str);
        return (DbxUrlWithExpiration) doPost(this.host.getApi(), "1/media/auto" + str, null, null, new DbxRequestUtil.ResponseHandler<DbxUrlWithExpiration>() { // from class: com.dropbox.core.v1.DbxClientV1.17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxUrlWithExpiration handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() == 404) {
                    return null;
                }
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return (DbxUrlWithExpiration) DbxRequestUtil.readJsonFromResponse(DbxUrlWithExpiration.Reader, response);
            }
        });
    }

    public String createCopyRef(String str) throws DbxException {
        DbxPathV1.checkArgNonRoot(ClientCookie.PATH_ATTR, str);
        return (String) doPost(this.host.getApi(), "1/copy_ref/auto" + str, null, null, new DbxRequestUtil.ResponseHandler<String>() { // from class: com.dropbox.core.v1.DbxClientV1.18
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public String handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() == 404) {
                    return null;
                }
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return ((CopyRef) DbxRequestUtil.readJsonFromResponse(CopyRef.Reader, response)).f662id;
            }
        });
    }

    private static final class CopyRef {
        public static final JsonReader<CopyRef> Reader = new JsonReader<CopyRef>() { // from class: com.dropbox.core.v1.DbxClientV1.CopyRef.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.json.JsonReader
            public CopyRef read(JsonParser jsonParser) throws JsonReadException, IOException {
                JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
                String field = null;
                Date field2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    try {
                        if (currentName.equals("copy_ref")) {
                            field = JsonReader.StringReader.readField(jsonParser, currentName, field);
                        } else if (currentName.equals(ClientCookie.EXPIRES_ATTR)) {
                            field2 = JsonDateReader.Dropbox.readField(jsonParser, currentName, field2);
                        } else {
                            JsonReader.skipValue(jsonParser);
                        }
                    } catch (JsonReadException e) {
                        throw e.addFieldContext(currentName);
                    }
                }
                JsonReader.expectObjectEnd(jsonParser);
                if (field == null) {
                    throw new JsonReadException("missing field \"copy_ref\"", jsonLocationExpectObjectStart);
                }
                if (field2 == null) {
                    throw new JsonReadException("missing field \"expires\"", jsonLocationExpectObjectStart);
                }
                return new CopyRef(field, field2);
            }
        };
        public final Date expires;

        /* JADX INFO: renamed from: id */
        public final String f662id;

        private CopyRef(String str, Date date) {
            this.f662id = str;
            this.expires = date;
        }
    }

    public DbxEntry copy(String str, String str2) throws DbxException {
        DbxPathV1.checkArg("fromPath", str);
        DbxPathV1.checkArgNonRoot("toPath", str2);
        return (DbxEntry) doPost(this.host.getApi(), "1/fileops/copy", new String[]{"root", "auto", "from_path", str, "to_path", str2}, null, new DbxRequestUtil.ResponseHandler<DbxEntry>() { // from class: com.dropbox.core.v1.DbxClientV1.19
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxEntry handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() == 403) {
                    return null;
                }
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                DbxEntry.WithChildren withChildren = (DbxEntry.WithChildren) DbxRequestUtil.readJsonFromResponse(DbxEntry.WithChildren.Reader, response);
                if (withChildren == null) {
                    return null;
                }
                return withChildren.entry;
            }
        });
    }

    public DbxEntry copyFromCopyRef(String str, String str2) throws DbxException {
        if (str == null) {
            throw new IllegalArgumentException("'copyRef' can't be null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("'copyRef' can't be empty");
        }
        DbxPathV1.checkArgNonRoot("toPath", str2);
        return (DbxEntry) doPost(this.host.getApi(), "1/fileops/copy", new String[]{"root", "auto", "from_copy_ref", str, "to_path", str2}, null, new DbxRequestUtil.ResponseHandler<DbxEntry>() { // from class: com.dropbox.core.v1.DbxClientV1.20
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxEntry handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                DbxEntry.WithChildren withChildren = (DbxEntry.WithChildren) DbxRequestUtil.readJsonFromResponse(DbxEntry.WithChildren.Reader, response);
                if (withChildren == null) {
                    return null;
                }
                return withChildren.entry;
            }
        });
    }

    public DbxEntry.Folder createFolder(String str) throws DbxException {
        DbxPathV1.checkArgNonRoot(ClientCookie.PATH_ATTR, str);
        return (DbxEntry.Folder) doPost(this.host.getApi(), "1/fileops/create_folder", new String[]{"root", "auto", ClientCookie.PATH_ATTR, str}, null, new DbxRequestUtil.ResponseHandler<DbxEntry.Folder>() { // from class: com.dropbox.core.v1.DbxClientV1.21
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxEntry.Folder handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() == 403) {
                    return null;
                }
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return (DbxEntry.Folder) DbxRequestUtil.readJsonFromResponse(DbxEntry.Folder.Reader, response);
            }
        });
    }

    public void delete(String str) throws DbxException {
        DbxPathV1.checkArgNonRoot(ClientCookie.PATH_ATTR, str);
        doPost(this.host.getApi(), "1/fileops/delete", new String[]{"root", "auto", ClientCookie.PATH_ATTR, str}, null, new DbxRequestUtil.ResponseHandler<Void>() { // from class: com.dropbox.core.v1.DbxClientV1.22
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public Void handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() == 200) {
                    return null;
                }
                throw DbxRequestUtil.unexpectedStatus(response);
            }
        });
    }

    public DbxEntry move(String str, String str2) throws DbxException {
        DbxPathV1.checkArgNonRoot("fromPath", str);
        DbxPathV1.checkArgNonRoot("toPath", str2);
        return (DbxEntry) doPost(this.host.getApi(), "1/fileops/move", new String[]{"root", "auto", "from_path", str, "to_path", str2}, null, new DbxRequestUtil.ResponseHandler<DbxEntry>() { // from class: com.dropbox.core.v1.DbxClientV1.23
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxEntry handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() == 403) {
                    return null;
                }
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                DbxEntry.WithChildren withChildren = (DbxEntry.WithChildren) DbxRequestUtil.readJsonFromResponse(DbxEntry.WithChildren.Reader, response);
                if (withChildren == null) {
                    return null;
                }
                return withChildren.entry;
            }
        });
    }

    private <T> T doGet(String str, String str2, String[] strArr, ArrayList<HttpRequestor.Header> arrayList, DbxRequestUtil.ResponseHandler<T> responseHandler) throws DbxException {
        return (T) DbxRequestUtil.doGet(this.requestConfig, this.accessToken, USER_AGENT_ID, str, str2, strArr, arrayList, responseHandler);
    }

    public <T> T doPost(String str, String str2, String[] strArr, ArrayList<HttpRequestor.Header> arrayList, DbxRequestUtil.ResponseHandler<T> responseHandler) throws DbxException {
        return (T) DbxRequestUtil.doPost(this.requestConfig, this.accessToken, USER_AGENT_ID, str, str2, strArr, arrayList, responseHandler);
    }
}
