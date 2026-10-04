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
public final class MemberSelector {
    public static final MemberSelector OTHER = new MemberSelector().withTag(Tag.OTHER);
    private Tag _tag;
    private String dropboxIdValue;
    private String emailValue;

    public enum Tag {
        DROPBOX_ID,
        EMAIL,
        OTHER
    }

    private MemberSelector() {
    }

    private MemberSelector withTag(Tag tag) {
        MemberSelector memberSelector = new MemberSelector();
        memberSelector._tag = tag;
        return memberSelector;
    }

    private MemberSelector withTagAndDropboxId(Tag tag, String str) {
        MemberSelector memberSelector = new MemberSelector();
        memberSelector._tag = tag;
        memberSelector.dropboxIdValue = str;
        return memberSelector;
    }

    private MemberSelector withTagAndEmail(Tag tag, String str) {
        MemberSelector memberSelector = new MemberSelector();
        memberSelector._tag = tag;
        memberSelector.emailValue = str;
        return memberSelector;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isDropboxId() {
        return this._tag == Tag.DROPBOX_ID;
    }

    public static MemberSelector dropboxId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new MemberSelector().withTagAndDropboxId(Tag.DROPBOX_ID, str);
    }

    public String getDropboxIdValue() {
        if (this._tag != Tag.DROPBOX_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.DROPBOX_ID, but was Tag." + this._tag.name());
        }
        return this.dropboxIdValue;
    }

    public boolean isEmail() {
        return this._tag == Tag.EMAIL;
    }

    public static MemberSelector email(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberSelector().withTagAndEmail(Tag.EMAIL, str);
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
        return Arrays.hashCode(new Object[]{this._tag, this.dropboxIdValue, this.emailValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof MemberSelector)) {
            return false;
        }
        MemberSelector memberSelector = (MemberSelector) obj;
        if (this._tag != memberSelector._tag) {
            return false;
        }
        int i = C42821.$SwitchMap$com$dropbox$core$v2$sharing$MemberSelector$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.dropboxIdValue;
            String str2 = memberSelector.dropboxIdValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return i == 3;
        }
        String str3 = this.emailValue;
        String str4 = memberSelector.emailValue;
        return str3 == str4 || str3.equals(str4);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.MemberSelector$1 */
    static /* synthetic */ class C42821 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$MemberSelector$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$MemberSelector$Tag = iArr;
            try {
                iArr[Tag.DROPBOX_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$MemberSelector$Tag[Tag.EMAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$MemberSelector$Tag[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends UnionSerializer<MemberSelector> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MemberSelector memberSelector, JsonGenerator jsonGenerator) throws IOException {
            int i = C42821.$SwitchMap$com$dropbox$core$v2$sharing$MemberSelector$Tag[memberSelector.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("dropbox_id", jsonGenerator);
                jsonGenerator.writeFieldName("dropbox_id");
                StoneSerializers.string().serialize(memberSelector.dropboxIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("email", jsonGenerator);
                jsonGenerator.writeFieldName("email");
                StoneSerializers.string().serialize(memberSelector.emailValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MemberSelector deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MemberSelector memberSelectorEmail;
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
            if ("dropbox_id".equals(tag)) {
                expectField("dropbox_id", jsonParser);
                memberSelectorEmail = MemberSelector.dropboxId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("email".equals(tag)) {
                expectField("email", jsonParser);
                memberSelectorEmail = MemberSelector.email(StoneSerializers.string().deserialize(jsonParser));
            } else {
                memberSelectorEmail = MemberSelector.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return memberSelectorEmail;
        }
    }
}
