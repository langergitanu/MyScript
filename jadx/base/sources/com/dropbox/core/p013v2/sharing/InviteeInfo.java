package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class InviteeInfo {
    public static final InviteeInfo OTHER = new InviteeInfo().withTag(Tag.OTHER);
    private Tag _tag;
    private String emailValue;

    public enum Tag {
        EMAIL,
        OTHER
    }

    private InviteeInfo() {
    }

    private InviteeInfo withTag(Tag tag) {
        InviteeInfo inviteeInfo = new InviteeInfo();
        inviteeInfo._tag = tag;
        return inviteeInfo;
    }

    private InviteeInfo withTagAndEmail(Tag tag, String str) {
        InviteeInfo inviteeInfo = new InviteeInfo();
        inviteeInfo._tag = tag;
        inviteeInfo.emailValue = str;
        return inviteeInfo;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isEmail() {
        return this._tag == Tag.EMAIL;
    }

    public static InviteeInfo email(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new InviteeInfo().withTagAndEmail(Tag.EMAIL, str);
    }

    public String getEmailValue() {
        if (this._tag != Tag.EMAIL) {
            throw new IllegalStateException("Invalid tag: required Tag.EMAIL, but was Tag." + this._tag.name());
        }
        return this.emailValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.emailValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof InviteeInfo)) {
            return false;
        }
        InviteeInfo inviteeInfo = (InviteeInfo) obj;
        if (this._tag != inviteeInfo._tag) {
            return false;
        }
        int i = C42641.$SwitchMap$com$dropbox$core$v2$sharing$InviteeInfo$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        String str = this.emailValue;
        String str2 = inviteeInfo.emailValue;
        return str == str2 || str.equals(str2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.InviteeInfo$1 */
    static /* synthetic */ class C42641 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$InviteeInfo$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$InviteeInfo$Tag = iArr;
            try {
                iArr[Tag.EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$InviteeInfo$Tag[Tag.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends UnionSerializer<InviteeInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(InviteeInfo inviteeInfo, JsonGenerator jsonGenerator) throws IOException {
            if (C42641.$SwitchMap$com$dropbox$core$v2$sharing$InviteeInfo$Tag[inviteeInfo.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag("email", jsonGenerator);
                jsonGenerator.writeFieldName("email");
                StoneSerializers.string().serialize(inviteeInfo.emailValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public InviteeInfo deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            InviteeInfo inviteeInfoEmail;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("email".equals(tag)) {
                expectField("email", jsonParser);
                inviteeInfoEmail = InviteeInfo.email(StoneSerializers.string().deserialize(jsonParser));
            } else {
                inviteeInfoEmail = InviteeInfo.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return inviteeInfoEmail;
        }
    }
}
