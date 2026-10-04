package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class EmailIngestReceiveFileDetails {

    @Nonnull
    protected final List<String> attachmentNames;

    @Nullable
    protected final String fromEmail;

    @Nullable
    protected final String fromName;

    @Nonnull
    protected final String inboxName;

    @Nullable
    protected final String subject;

    public EmailIngestReceiveFileDetails(@Nonnull String str, @Nonnull List<String> list, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'inboxName' is null");
        }
        this.inboxName = str;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'attachmentNames' is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'attachmentNames' is null");
            }
        }
        this.attachmentNames = list;
        this.subject = str2;
        this.fromName = str3;
        if (str4 != null && str4.length() > 255) {
            throw new IllegalArgumentException("String 'fromEmail' is longer than 255");
        }
        this.fromEmail = str4;
    }

    public EmailIngestReceiveFileDetails(@Nonnull String str, @Nonnull List<String> list) {
        this(str, list, null, null, null);
    }

    @Nonnull
    public String getInboxName() {
        return this.inboxName;
    }

    @Nonnull
    public List<String> getAttachmentNames() {
        return this.attachmentNames;
    }

    @Nullable
    public String getSubject() {
        return this.subject;
    }

    @Nullable
    public String getFromName() {
        return this.fromName;
    }

    @Nullable
    public String getFromEmail() {
        return this.fromEmail;
    }

    public static Builder newBuilder(String str, List<String> list) {
        return new Builder(str, list);
    }

    public static class Builder {
        protected final List<String> attachmentNames;
        protected String fromEmail;
        protected String fromName;
        protected final String inboxName;
        protected String subject;

        protected Builder(String str, List<String> list) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'inboxName' is null");
            }
            this.inboxName = str;
            if (list == null) {
                throw new IllegalArgumentException("Required value for 'attachmentNames' is null");
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'attachmentNames' is null");
                }
            }
            this.attachmentNames = list;
            this.subject = null;
            this.fromName = null;
            this.fromEmail = null;
        }

        public Builder withSubject(String str) {
            this.subject = str;
            return this;
        }

        public Builder withFromName(String str) {
            this.fromName = str;
            return this;
        }

        public Builder withFromEmail(String str) {
            if (str != null && str.length() > 255) {
                throw new IllegalArgumentException("String 'fromEmail' is longer than 255");
            }
            this.fromEmail = str;
            return this;
        }

        public EmailIngestReceiveFileDetails build() {
            return new EmailIngestReceiveFileDetails(this.inboxName, this.attachmentNames, this.subject, this.fromName, this.fromEmail);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.inboxName, this.attachmentNames, this.subject, this.fromName, this.fromEmail});
    }

    public boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        EmailIngestReceiveFileDetails emailIngestReceiveFileDetails = (EmailIngestReceiveFileDetails) obj;
        String str7 = this.inboxName;
        String str8 = emailIngestReceiveFileDetails.inboxName;
        return (str7 == str8 || str7.equals(str8)) && ((list = this.attachmentNames) == (list2 = emailIngestReceiveFileDetails.attachmentNames) || list.equals(list2)) && (((str = this.subject) == (str2 = emailIngestReceiveFileDetails.subject) || (str != null && str.equals(str2))) && (((str3 = this.fromName) == (str4 = emailIngestReceiveFileDetails.fromName) || (str3 != null && str3.equals(str4))) && ((str5 = this.fromEmail) == (str6 = emailIngestReceiveFileDetails.fromEmail) || (str5 != null && str5.equals(str6)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<EmailIngestReceiveFileDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(EmailIngestReceiveFileDetails emailIngestReceiveFileDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("inbox_name");
            StoneSerializers.string().serialize(emailIngestReceiveFileDetails.inboxName, jsonGenerator);
            jsonGenerator.writeFieldName("attachment_names");
            StoneSerializers.list(StoneSerializers.string()).serialize(emailIngestReceiveFileDetails.attachmentNames, jsonGenerator);
            if (emailIngestReceiveFileDetails.subject != null) {
                jsonGenerator.writeFieldName("subject");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(emailIngestReceiveFileDetails.subject, jsonGenerator);
            }
            if (emailIngestReceiveFileDetails.fromName != null) {
                jsonGenerator.writeFieldName("from_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(emailIngestReceiveFileDetails.fromName, jsonGenerator);
            }
            if (emailIngestReceiveFileDetails.fromEmail != null) {
                jsonGenerator.writeFieldName("from_email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(emailIngestReceiveFileDetails.fromEmail, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public EmailIngestReceiveFileDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                List list = null;
                String str = null;
                String str2 = null;
                String str3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("inbox_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("attachment_names".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("subject".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("from_name".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("from_email".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"inbox_name\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"attachment_names\" missing.");
                }
                EmailIngestReceiveFileDetails emailIngestReceiveFileDetails = new EmailIngestReceiveFileDetails(strDeserialize, list, str, str2, str3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(emailIngestReceiveFileDetails, emailIngestReceiveFileDetails.toStringMultiline());
                return emailIngestReceiveFileDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
