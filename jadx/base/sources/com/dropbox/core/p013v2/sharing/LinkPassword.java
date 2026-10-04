package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class LinkPassword {
    private Tag _tag;
    private String setPasswordValue;
    public static final LinkPassword REMOVE_PASSWORD = new LinkPassword().withTag(Tag.REMOVE_PASSWORD);
    public static final LinkPassword OTHER = new LinkPassword().withTag(Tag.OTHER);

    public enum Tag {
        REMOVE_PASSWORD,
        SET_PASSWORD,
        OTHER
    }

    private LinkPassword() {
    }

    private LinkPassword withTag(Tag tag) {
        LinkPassword linkPassword = new LinkPassword();
        linkPassword._tag = tag;
        return linkPassword;
    }

    private LinkPassword withTagAndSetPassword(Tag tag, String str) {
        LinkPassword linkPassword = new LinkPassword();
        linkPassword._tag = tag;
        linkPassword.setPasswordValue = str;
        return linkPassword;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isRemovePassword() {
        return this._tag == Tag.REMOVE_PASSWORD;
    }

    public boolean isSetPassword() {
        return this._tag == Tag.SET_PASSWORD;
    }

    public static LinkPassword setPassword(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LinkPassword().withTagAndSetPassword(Tag.SET_PASSWORD, str);
    }

    public String getSetPasswordValue() {
        if (this._tag != Tag.SET_PASSWORD) {
            throw new IllegalStateException("Invalid tag: required Tag.SET_PASSWORD, but was Tag." + this._tag.name());
        }
        return this.setPasswordValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.setPasswordValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof LinkPassword)) {
            return false;
        }
        LinkPassword linkPassword = (LinkPassword) obj;
        if (this._tag != linkPassword._tag) {
            return false;
        }
        int i = C42721.$SwitchMap$com$dropbox$core$v2$sharing$LinkPassword$Tag[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return i == 3;
            }
            String str = this.setPasswordValue;
            String str2 = linkPassword.setPasswordValue;
            if (str != str2 && !str.equals(str2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.LinkPassword$1 */
    static /* synthetic */ class C42721 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$LinkPassword$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$LinkPassword$Tag = iArr;
            try {
                iArr[Tag.REMOVE_PASSWORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$LinkPassword$Tag[Tag.SET_PASSWORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$LinkPassword$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<LinkPassword> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LinkPassword linkPassword, JsonGenerator jsonGenerator) throws IOException {
            int i = C42721.$SwitchMap$com$dropbox$core$v2$sharing$LinkPassword$Tag[linkPassword.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("remove_password");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("set_password", jsonGenerator);
                jsonGenerator.writeFieldName("set_password");
                StoneSerializers.string().serialize(linkPassword.setPasswordValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LinkPassword deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LinkPassword password;
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
            if ("remove_password".equals(tag)) {
                password = LinkPassword.REMOVE_PASSWORD;
            } else if ("set_password".equals(tag)) {
                expectField("set_password", jsonParser);
                password = LinkPassword.setPassword(StoneSerializers.string().deserialize(jsonParser));
            } else {
                password = LinkPassword.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return password;
        }
    }
}
