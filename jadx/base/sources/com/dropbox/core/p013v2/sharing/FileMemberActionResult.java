package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.FileMemberActionIndividualResult;
import com.dropbox.core.p013v2.sharing.MemberSelector;
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

/* JADX INFO: loaded from: classes4.dex */
public class FileMemberActionResult {

    @Nullable
    protected final List<String> invitationSignature;

    @Nonnull
    protected final MemberSelector member;

    @Nonnull
    protected final FileMemberActionIndividualResult result;

    @Nullable
    protected final String sckeySha1;

    public FileMemberActionResult(@Nonnull MemberSelector memberSelector, @Nonnull FileMemberActionIndividualResult fileMemberActionIndividualResult, @Nullable String str, @Nullable List<String> list) {
        if (memberSelector == null) {
            throw new IllegalArgumentException("Required value for 'member' is null");
        }
        this.member = memberSelector;
        if (fileMemberActionIndividualResult == null) {
            throw new IllegalArgumentException("Required value for 'result' is null");
        }
        this.result = fileMemberActionIndividualResult;
        this.sckeySha1 = str;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'invitationSignature' is null");
                }
            }
        }
        this.invitationSignature = list;
    }

    public FileMemberActionResult(@Nonnull MemberSelector memberSelector, @Nonnull FileMemberActionIndividualResult fileMemberActionIndividualResult) {
        this(memberSelector, fileMemberActionIndividualResult, null, null);
    }

    @Nonnull
    public MemberSelector getMember() {
        return this.member;
    }

    @Nonnull
    public FileMemberActionIndividualResult getResult() {
        return this.result;
    }

    @Nullable
    public String getSckeySha1() {
        return this.sckeySha1;
    }

    @Nullable
    public List<String> getInvitationSignature() {
        return this.invitationSignature;
    }

    public static Builder newBuilder(MemberSelector memberSelector, FileMemberActionIndividualResult fileMemberActionIndividualResult) {
        return new Builder(memberSelector, fileMemberActionIndividualResult);
    }

    public static class Builder {
        protected List<String> invitationSignature;
        protected final MemberSelector member;
        protected final FileMemberActionIndividualResult result;
        protected String sckeySha1;

        protected Builder(MemberSelector memberSelector, FileMemberActionIndividualResult fileMemberActionIndividualResult) {
            if (memberSelector == null) {
                throw new IllegalArgumentException("Required value for 'member' is null");
            }
            this.member = memberSelector;
            if (fileMemberActionIndividualResult == null) {
                throw new IllegalArgumentException("Required value for 'result' is null");
            }
            this.result = fileMemberActionIndividualResult;
            this.sckeySha1 = null;
            this.invitationSignature = null;
        }

        public Builder withSckeySha1(String str) {
            this.sckeySha1 = str;
            return this;
        }

        public Builder withInvitationSignature(List<String> list) {
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'invitationSignature' is null");
                    }
                }
            }
            this.invitationSignature = list;
            return this;
        }

        public FileMemberActionResult build() {
            return new FileMemberActionResult(this.member, this.result, this.sckeySha1, this.invitationSignature);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.member, this.result, this.sckeySha1, this.invitationSignature});
    }

    public boolean equals(Object obj) {
        FileMemberActionIndividualResult fileMemberActionIndividualResult;
        FileMemberActionIndividualResult fileMemberActionIndividualResult2;
        String str;
        String str2;
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileMemberActionResult fileMemberActionResult = (FileMemberActionResult) obj;
        MemberSelector memberSelector = this.member;
        MemberSelector memberSelector2 = fileMemberActionResult.member;
        return (memberSelector == memberSelector2 || memberSelector.equals(memberSelector2)) && ((fileMemberActionIndividualResult = this.result) == (fileMemberActionIndividualResult2 = fileMemberActionResult.result) || fileMemberActionIndividualResult.equals(fileMemberActionIndividualResult2)) && (((str = this.sckeySha1) == (str2 = fileMemberActionResult.sckeySha1) || (str != null && str.equals(str2))) && ((list = this.invitationSignature) == (list2 = fileMemberActionResult.invitationSignature) || (list != null && list.equals(list2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileMemberActionResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileMemberActionResult fileMemberActionResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("member");
            MemberSelector.Serializer.INSTANCE.serialize(fileMemberActionResult.member, jsonGenerator);
            jsonGenerator.writeFieldName("result");
            FileMemberActionIndividualResult.Serializer.INSTANCE.serialize(fileMemberActionResult.result, jsonGenerator);
            if (fileMemberActionResult.sckeySha1 != null) {
                jsonGenerator.writeFieldName("sckey_sha1");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileMemberActionResult.sckeySha1, jsonGenerator);
            }
            if (fileMemberActionResult.invitationSignature != null) {
                jsonGenerator.writeFieldName("invitation_signature");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(fileMemberActionResult.invitationSignature, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileMemberActionResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            MemberSelector memberSelectorDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                FileMemberActionIndividualResult fileMemberActionIndividualResultDeserialize = null;
                String str = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("member".equals(currentName)) {
                        memberSelectorDeserialize = MemberSelector.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("result".equals(currentName)) {
                        fileMemberActionIndividualResultDeserialize = FileMemberActionIndividualResult.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("sckey_sha1".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("invitation_signature".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (memberSelectorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"member\" missing.");
                }
                if (fileMemberActionIndividualResultDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"result\" missing.");
                }
                FileMemberActionResult fileMemberActionResult = new FileMemberActionResult(memberSelectorDeserialize, fileMemberActionIndividualResultDeserialize, str, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileMemberActionResult, fileMemberActionResult.toStringMultiline());
                return fileMemberActionResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
