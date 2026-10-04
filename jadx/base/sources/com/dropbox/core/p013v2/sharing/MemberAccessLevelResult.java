package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.sharing.ParentFolderAccessInfo;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class MemberAccessLevelResult {

    @Nullable
    protected final List<ParentFolderAccessInfo> accessDetails;

    @Nullable
    protected final AccessLevel accessLevel;

    @Nullable
    protected final String warning;

    public MemberAccessLevelResult(@Nullable AccessLevel accessLevel, @Nullable String str, @Nullable List<ParentFolderAccessInfo> list) {
        this.accessLevel = accessLevel;
        this.warning = str;
        if (list != null) {
            Iterator<ParentFolderAccessInfo> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'accessDetails' is null");
                }
            }
        }
        this.accessDetails = list;
    }

    public MemberAccessLevelResult() {
        this(null, null, null);
    }

    @Nullable
    public AccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    @Nullable
    public String getWarning() {
        return this.warning;
    }

    @Nullable
    public List<ParentFolderAccessInfo> getAccessDetails() {
        return this.accessDetails;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected AccessLevel accessLevel = null;
        protected String warning = null;
        protected List<ParentFolderAccessInfo> accessDetails = null;

        protected Builder() {
        }

        public Builder withAccessLevel(AccessLevel accessLevel) {
            this.accessLevel = accessLevel;
            return this;
        }

        public Builder withWarning(String str) {
            this.warning = str;
            return this;
        }

        public Builder withAccessDetails(List<ParentFolderAccessInfo> list) {
            if (list != null) {
                Iterator<ParentFolderAccessInfo> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'accessDetails' is null");
                    }
                }
            }
            this.accessDetails = list;
            return this;
        }

        public MemberAccessLevelResult build() {
            return new MemberAccessLevelResult(this.accessLevel, this.warning, this.accessDetails);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.accessLevel, this.warning, this.accessDetails});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        List<ParentFolderAccessInfo> list;
        List<ParentFolderAccessInfo> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MemberAccessLevelResult memberAccessLevelResult = (MemberAccessLevelResult) obj;
        AccessLevel accessLevel = this.accessLevel;
        AccessLevel accessLevel2 = memberAccessLevelResult.accessLevel;
        return (accessLevel == accessLevel2 || (accessLevel != null && accessLevel.equals(accessLevel2))) && ((str = this.warning) == (str2 = memberAccessLevelResult.warning) || (str != null && str.equals(str2))) && ((list = this.accessDetails) == (list2 = memberAccessLevelResult.accessDetails) || (list != null && list.equals(list2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberAccessLevelResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberAccessLevelResult memberAccessLevelResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (memberAccessLevelResult.accessLevel != null) {
                jsonGenerator.writeFieldName("access_level");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(memberAccessLevelResult.accessLevel, jsonGenerator);
            }
            if (memberAccessLevelResult.warning != null) {
                jsonGenerator.writeFieldName("warning");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberAccessLevelResult.warning, jsonGenerator);
            }
            if (memberAccessLevelResult.accessDetails != null) {
                jsonGenerator.writeFieldName("access_details");
                StoneSerializers.nullable(StoneSerializers.list(ParentFolderAccessInfo.Serializer.INSTANCE)).serialize(memberAccessLevelResult.accessDetails, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberAccessLevelResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AccessLevel accessLevel = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("access_level".equals(currentName)) {
                        accessLevel = (AccessLevel) StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("warning".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("access_details".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(ParentFolderAccessInfo.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                MemberAccessLevelResult memberAccessLevelResult = new MemberAccessLevelResult(accessLevel, str, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberAccessLevelResult, memberAccessLevelResult.toStringMultiline());
                return memberAccessLevelResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
