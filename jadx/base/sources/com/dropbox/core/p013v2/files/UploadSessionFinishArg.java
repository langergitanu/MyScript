package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.CommitInfo;
import com.dropbox.core.p013v2.files.UploadSessionCursor;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class UploadSessionFinishArg {

    @Nonnull
    protected final CommitInfo commit;

    @Nullable
    protected final String contentHash;

    @Nonnull
    protected final UploadSessionCursor cursor;

    public UploadSessionFinishArg(@Nonnull UploadSessionCursor uploadSessionCursor, @Nonnull CommitInfo commitInfo, @Nullable String str) {
        if (uploadSessionCursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = uploadSessionCursor;
        if (commitInfo == null) {
            throw new IllegalArgumentException("Required value for 'commit' is null");
        }
        this.commit = commitInfo;
        if (str != null) {
            if (str.length() < 64) {
                throw new IllegalArgumentException("String 'contentHash' is shorter than 64");
            }
            if (str.length() > 64) {
                throw new IllegalArgumentException("String 'contentHash' is longer than 64");
            }
        }
        this.contentHash = str;
    }

    public UploadSessionFinishArg(@Nonnull UploadSessionCursor uploadSessionCursor, @Nonnull CommitInfo commitInfo) {
        this(uploadSessionCursor, commitInfo, null);
    }

    @Nonnull
    public UploadSessionCursor getCursor() {
        return this.cursor;
    }

    @Nonnull
    public CommitInfo getCommit() {
        return this.commit;
    }

    @Nullable
    public String getContentHash() {
        return this.contentHash;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.cursor, this.commit, this.contentHash});
    }

    public boolean equals(Object obj) {
        CommitInfo commitInfo;
        CommitInfo commitInfo2;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UploadSessionFinishArg uploadSessionFinishArg = (UploadSessionFinishArg) obj;
        UploadSessionCursor uploadSessionCursor = this.cursor;
        UploadSessionCursor uploadSessionCursor2 = uploadSessionFinishArg.cursor;
        return (uploadSessionCursor == uploadSessionCursor2 || uploadSessionCursor.equals(uploadSessionCursor2)) && ((commitInfo = this.commit) == (commitInfo2 = uploadSessionFinishArg.commit) || commitInfo.equals(commitInfo2)) && ((str = this.contentHash) == (str2 = uploadSessionFinishArg.contentHash) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UploadSessionFinishArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UploadSessionFinishArg uploadSessionFinishArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("cursor");
            UploadSessionCursor.Serializer.INSTANCE.serialize(uploadSessionFinishArg.cursor, jsonGenerator);
            jsonGenerator.writeFieldName("commit");
            CommitInfo.Serializer.INSTANCE.serialize(uploadSessionFinishArg.commit, jsonGenerator);
            if (uploadSessionFinishArg.contentHash != null) {
                jsonGenerator.writeFieldName("content_hash");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(uploadSessionFinishArg.contentHash, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UploadSessionFinishArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UploadSessionCursor uploadSessionCursorDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                CommitInfo commitInfoDeserialize = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("cursor".equals(currentName)) {
                        uploadSessionCursorDeserialize = UploadSessionCursor.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("commit".equals(currentName)) {
                        commitInfoDeserialize = CommitInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("content_hash".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (uploadSessionCursorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"cursor\" missing.");
                }
                if (commitInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"commit\" missing.");
                }
                UploadSessionFinishArg uploadSessionFinishArg = new UploadSessionFinishArg(uploadSessionCursorDeserialize, commitInfoDeserialize, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(uploadSessionFinishArg, uploadSessionFinishArg.toStringMultiline());
                return uploadSessionFinishArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
