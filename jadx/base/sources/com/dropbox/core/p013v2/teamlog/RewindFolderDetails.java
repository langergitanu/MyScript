package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class RewindFolderDetails {

    @Nonnull
    protected final Date rewindFolderTargetTsMs;

    public RewindFolderDetails(@Nonnull Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Required value for 'rewindFolderTargetTsMs' is null");
        }
        this.rewindFolderTargetTsMs = LangUtil.truncateMillis(date);
    }

    @Nonnull
    public Date getRewindFolderTargetTsMs() {
        return this.rewindFolderTargetTsMs;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.rewindFolderTargetTsMs});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        Date date = this.rewindFolderTargetTsMs;
        Date date2 = ((RewindFolderDetails) obj).rewindFolderTargetTsMs;
        return date == date2 || date.equals(date2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RewindFolderDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RewindFolderDetails rewindFolderDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("rewind_folder_target_ts_ms");
            StoneSerializers.timestamp().serialize(rewindFolderDetails.rewindFolderTargetTsMs, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RewindFolderDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Date dateDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("rewind_folder_target_ts_ms".equals(currentName)) {
                        dateDeserialize = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (dateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"rewind_folder_target_ts_ms\" missing.");
                }
                RewindFolderDetails rewindFolderDetails = new RewindFolderDetails(dateDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(rewindFolderDetails, rewindFolderDetails.toStringMultiline());
                return rewindFolderDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
