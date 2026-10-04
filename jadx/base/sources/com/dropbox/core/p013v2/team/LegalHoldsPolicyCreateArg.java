package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
class LegalHoldsPolicyCreateArg {

    @Nullable
    protected final String description;

    @Nullable
    protected final Date endDate;

    @Nonnull
    protected final List<String> members;

    @Nonnull
    protected final String name;

    @Nullable
    protected final Date startDate;

    public LegalHoldsPolicyCreateArg(@Nonnull String str, @Nonnull List<String> list, @Nullable String str2, @Nullable Date date, @Nullable Date date2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        if (str.length() > 140) {
            throw new IllegalArgumentException("String 'name' is longer than 140");
        }
        this.name = str;
        if (str2 != null && str2.length() > 501) {
            throw new IllegalArgumentException("String 'description' is longer than 501");
        }
        this.description = str2;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = list;
        this.startDate = LangUtil.truncateMillis(date);
        this.endDate = LangUtil.truncateMillis(date2);
    }

    public LegalHoldsPolicyCreateArg(@Nonnull String str, @Nonnull List<String> list) {
        this(str, list, null, null, null);
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public List<String> getMembers() {
        return this.members;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    @Nullable
    public Date getStartDate() {
        return this.startDate;
    }

    @Nullable
    public Date getEndDate() {
        return this.endDate;
    }

    public static Builder newBuilder(String str, List<String> list) {
        return new Builder(str, list);
    }

    public static class Builder {
        protected String description;
        protected Date endDate;
        protected final List<String> members;
        protected final String name;
        protected Date startDate;

        protected Builder(String str, List<String> list) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            if (str.length() > 140) {
                throw new IllegalArgumentException("String 'name' is longer than 140");
            }
            this.name = str;
            if (list == null) {
                throw new IllegalArgumentException("Required value for 'members' is null");
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'members' is null");
                }
            }
            this.members = list;
            this.description = null;
            this.startDate = null;
            this.endDate = null;
        }

        public Builder withDescription(String str) {
            if (str != null && str.length() > 501) {
                throw new IllegalArgumentException("String 'description' is longer than 501");
            }
            this.description = str;
            return this;
        }

        public Builder withStartDate(Date date) {
            this.startDate = LangUtil.truncateMillis(date);
            return this;
        }

        public Builder withEndDate(Date date) {
            this.endDate = LangUtil.truncateMillis(date);
            return this;
        }

        public LegalHoldsPolicyCreateArg build() {
            return new LegalHoldsPolicyCreateArg(this.name, this.members, this.description, this.startDate, this.endDate);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.name, this.description, this.members, this.startDate, this.endDate});
    }

    public boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        String str;
        String str2;
        Date date;
        Date date2;
        Date date3;
        Date date4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LegalHoldsPolicyCreateArg legalHoldsPolicyCreateArg = (LegalHoldsPolicyCreateArg) obj;
        String str3 = this.name;
        String str4 = legalHoldsPolicyCreateArg.name;
        return (str3 == str4 || str3.equals(str4)) && ((list = this.members) == (list2 = legalHoldsPolicyCreateArg.members) || list.equals(list2)) && (((str = this.description) == (str2 = legalHoldsPolicyCreateArg.description) || (str != null && str.equals(str2))) && (((date = this.startDate) == (date2 = legalHoldsPolicyCreateArg.startDate) || (date != null && date.equals(date2))) && ((date3 = this.endDate) == (date4 = legalHoldsPolicyCreateArg.endDate) || (date3 != null && date3.equals(date4)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LegalHoldsPolicyCreateArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LegalHoldsPolicyCreateArg legalHoldsPolicyCreateArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(legalHoldsPolicyCreateArg.name, jsonGenerator);
            jsonGenerator.writeFieldName("members");
            StoneSerializers.list(StoneSerializers.string()).serialize(legalHoldsPolicyCreateArg.members, jsonGenerator);
            if (legalHoldsPolicyCreateArg.description != null) {
                jsonGenerator.writeFieldName("description");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legalHoldsPolicyCreateArg.description, jsonGenerator);
            }
            if (legalHoldsPolicyCreateArg.startDate != null) {
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.START_DATE);
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(legalHoldsPolicyCreateArg.startDate, jsonGenerator);
            }
            if (legalHoldsPolicyCreateArg.endDate != null) {
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.END_DATE);
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(legalHoldsPolicyCreateArg.endDate, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LegalHoldsPolicyCreateArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                Date date = null;
                Date date2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("members".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("description".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.START_DATE.equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.END_DATE.equals(currentName)) {
                        date2 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"members\" missing.");
                }
                LegalHoldsPolicyCreateArg legalHoldsPolicyCreateArg = new LegalHoldsPolicyCreateArg(strDeserialize, list, str, date, date2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legalHoldsPolicyCreateArg, legalHoldsPolicyCreateArg.toStringMultiline());
                return legalHoldsPolicyCreateArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
