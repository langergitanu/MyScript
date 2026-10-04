package com.dropbox.core.p013v2.files;

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
public class SingleUserLock {

    @Nonnull
    protected final Date created;

    @Nonnull
    protected final String lockHolderAccountId;

    @Nullable
    protected final String lockHolderTeamId;

    public SingleUserLock(@Nonnull Date date, @Nonnull String str, @Nullable String str2) {
        if (date == null) {
            throw new IllegalArgumentException("Required value for 'created' is null");
        }
        this.created = LangUtil.truncateMillis(date);
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'lockHolderAccountId' is null");
        }
        if (str.length() < 40) {
            throw new IllegalArgumentException("String 'lockHolderAccountId' is shorter than 40");
        }
        if (str.length() > 40) {
            throw new IllegalArgumentException("String 'lockHolderAccountId' is longer than 40");
        }
        this.lockHolderAccountId = str;
        this.lockHolderTeamId = str2;
    }

    public SingleUserLock(@Nonnull Date date, @Nonnull String str) {
        this(date, str, null);
    }

    @Nonnull
    public Date getCreated() {
        return this.created;
    }

    @Nonnull
    public String getLockHolderAccountId() {
        return this.lockHolderAccountId;
    }

    @Nullable
    public String getLockHolderTeamId() {
        return this.lockHolderTeamId;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.created, this.lockHolderAccountId, this.lockHolderTeamId});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SingleUserLock singleUserLock = (SingleUserLock) obj;
        Date date = this.created;
        Date date2 = singleUserLock.created;
        return (date == date2 || date.equals(date2)) && ((str = this.lockHolderAccountId) == (str2 = singleUserLock.lockHolderAccountId) || str.equals(str2)) && ((str3 = this.lockHolderTeamId) == (str4 = singleUserLock.lockHolderTeamId) || (str3 != null && str3.equals(str4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SingleUserLock> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SingleUserLock singleUserLock, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("created");
            StoneSerializers.timestamp().serialize(singleUserLock.created, jsonGenerator);
            jsonGenerator.writeFieldName("lock_holder_account_id");
            StoneSerializers.string().serialize(singleUserLock.lockHolderAccountId, jsonGenerator);
            if (singleUserLock.lockHolderTeamId != null) {
                jsonGenerator.writeFieldName("lock_holder_team_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(singleUserLock.lockHolderTeamId, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SingleUserLock deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Date dateDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("created".equals(currentName)) {
                        dateDeserialize = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else if ("lock_holder_account_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("lock_holder_team_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (dateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"created\" missing.");
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"lock_holder_account_id\" missing.");
                }
                SingleUserLock singleUserLock = new SingleUserLock(dateDeserialize, strDeserialize, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(singleUserLock, singleUserLock.toStringMultiline());
                return singleUserLock;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
