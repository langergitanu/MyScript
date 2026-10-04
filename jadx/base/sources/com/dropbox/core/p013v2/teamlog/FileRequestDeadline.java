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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class FileRequestDeadline {

    @Nullable
    protected final String allowLateUploads;

    @Nullable
    protected final Date deadline;

    public FileRequestDeadline(@Nullable Date date, @Nullable String str) {
        this.deadline = LangUtil.truncateMillis(date);
        this.allowLateUploads = str;
    }

    public FileRequestDeadline() {
        this(null, null);
    }

    @Nullable
    public Date getDeadline() {
        return this.deadline;
    }

    @Nullable
    public String getAllowLateUploads() {
        return this.allowLateUploads;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected Date deadline = null;
        protected String allowLateUploads = null;

        protected Builder() {
        }

        public Builder withDeadline(Date date) {
            this.deadline = LangUtil.truncateMillis(date);
            return this;
        }

        public Builder withAllowLateUploads(String str) {
            this.allowLateUploads = str;
            return this;
        }

        public FileRequestDeadline build() {
            return new FileRequestDeadline(this.deadline, this.allowLateUploads);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.deadline, this.allowLateUploads});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileRequestDeadline fileRequestDeadline = (FileRequestDeadline) obj;
        Date date = this.deadline;
        Date date2 = fileRequestDeadline.deadline;
        return (date == date2 || (date != null && date.equals(date2))) && ((str = this.allowLateUploads) == (str2 = fileRequestDeadline.allowLateUploads) || (str != null && str.equals(str2)));
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
            if (fileRequestDeadline.deadline != null) {
                jsonGenerator.writeFieldName("deadline");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(fileRequestDeadline.deadline, jsonGenerator);
            }
            if (fileRequestDeadline.allowLateUploads != null) {
                jsonGenerator.writeFieldName("allow_late_uploads");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileRequestDeadline.allowLateUploads, jsonGenerator);
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
            Date date = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("deadline".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("allow_late_uploads".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                FileRequestDeadline fileRequestDeadline = new FileRequestDeadline(date, str);
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
