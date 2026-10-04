package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.p013v2.filerequests.GracePeriod;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class FileRequestDeadline {

    @Nullable
    protected final GracePeriod allowLateUploads;

    @Nonnull
    protected final Date deadline;

    public FileRequestDeadline(@Nonnull Date date, @Nullable GracePeriod gracePeriod) {
        if (date == null) {
            throw new IllegalArgumentException("Required value for 'deadline' is null");
        }
        this.deadline = LangUtil.truncateMillis(date);
        this.allowLateUploads = gracePeriod;
    }

    public FileRequestDeadline(@Nonnull Date date) {
        this(date, null);
    }

    @Nonnull
    public Date getDeadline() {
        return this.deadline;
    }

    @Nullable
    public GracePeriod getAllowLateUploads() {
        return this.allowLateUploads;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.deadline, this.allowLateUploads});
    }

    public boolean equals(Object obj) {
        GracePeriod gracePeriod;
        GracePeriod gracePeriod2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileRequestDeadline fileRequestDeadline = (FileRequestDeadline) obj;
        Date date = this.deadline;
        Date date2 = fileRequestDeadline.deadline;
        return (date == date2 || date.equals(date2)) && ((gracePeriod = this.allowLateUploads) == (gracePeriod2 = fileRequestDeadline.allowLateUploads) || (gracePeriod != null && gracePeriod.equals(gracePeriod2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileRequestDeadline> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileRequestDeadline fileRequestDeadline, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("deadline");
            StoneSerializers.timestamp().serialize(fileRequestDeadline.deadline, jsonGenerator);
            if (fileRequestDeadline.allowLateUploads != null) {
                jsonGenerator.writeFieldName("allow_late_uploads");
                StoneSerializers.nullable(GracePeriod.Serializer.INSTANCE).serialize(fileRequestDeadline.allowLateUploads, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileRequestDeadline deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Date dateDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                GracePeriod gracePeriod = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("deadline".equals(currentName)) {
                        dateDeserialize = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else if ("allow_late_uploads".equals(currentName)) {
                        gracePeriod = (GracePeriod) StoneSerializers.nullable(GracePeriod.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (dateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"deadline\" missing.");
                }
                FileRequestDeadline fileRequestDeadline = new FileRequestDeadline(dateDeserialize, gracePeriod);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileRequestDeadline, fileRequestDeadline.toStringMultiline());
                return fileRequestDeadline;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
