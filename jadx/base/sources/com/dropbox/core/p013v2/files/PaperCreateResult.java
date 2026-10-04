package com.dropbox.core.p013v2.files;

import androidx.core.provider.FontsContractCompat;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class PaperCreateResult {

    @Nonnull
    protected final String fileId;
    protected final long paperRevision;

    @Nonnull
    protected final String resultPath;

    @Nonnull
    protected final String url;

    public PaperCreateResult(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, long j) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'resultPath' is null");
        }
        this.resultPath = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'fileId' is null");
        }
        if (str3.length() < 4) {
            throw new IllegalArgumentException("String 'fileId' is shorter than 4");
        }
        if (!Pattern.matches("id:.+", str3)) {
            throw new IllegalArgumentException("String 'fileId' does not match pattern");
        }
        this.fileId = str3;
        this.paperRevision = j;
    }

    @Nonnull
    public String getUrl() {
        return this.url;
    }

    @Nonnull
    public String getResultPath() {
        return this.resultPath;
    }

    @Nonnull
    public String getFileId() {
        return this.fileId;
    }

    public long getPaperRevision() {
        return this.paperRevision;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.url, this.resultPath, this.fileId, Long.valueOf(this.paperRevision)});
    }

    public boolean equals(Object obj) {
        PaperCreateResult paperCreateResult;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.url) == (str2 = (paperCreateResult = (PaperCreateResult) obj).url) || str.equals(str2)) && (((str3 = this.resultPath) == (str4 = paperCreateResult.resultPath) || str3.equals(str4)) && (((str5 = this.fileId) == (str6 = paperCreateResult.fileId) || str5.equals(str6)) && this.paperRevision == paperCreateResult.paperRevision));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperCreateResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperCreateResult paperCreateResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ImagesContract.URL);
            StoneSerializers.string().serialize(paperCreateResult.url, jsonGenerator);
            jsonGenerator.writeFieldName("result_path");
            StoneSerializers.string().serialize(paperCreateResult.resultPath, jsonGenerator);
            jsonGenerator.writeFieldName(FontsContractCompat.Columns.FILE_ID);
            StoneSerializers.string().serialize(paperCreateResult.fileId, jsonGenerator);
            jsonGenerator.writeFieldName("paper_revision");
            StoneSerializers.int64().serialize(Long.valueOf(paperCreateResult.paperRevision), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperCreateResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ImagesContract.URL.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("result_path".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if (FontsContractCompat.Columns.FILE_ID.equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("paper_revision".equals(currentName)) {
                        lDeserialize = StoneSerializers.int64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"url\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"result_path\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"file_id\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"paper_revision\" missing.");
                }
                PaperCreateResult paperCreateResult = new PaperCreateResult(strDeserialize, strDeserialize2, strDeserialize3, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperCreateResult, paperCreateResult.toStringMultiline());
                return paperCreateResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
