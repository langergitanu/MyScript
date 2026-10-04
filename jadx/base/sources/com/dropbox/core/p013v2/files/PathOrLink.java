package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.SharedLinkFileInfo;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class PathOrLink {
    public static final PathOrLink OTHER = new PathOrLink().withTag(Tag.OTHER);
    private Tag _tag;
    private SharedLinkFileInfo linkValue;
    private String pathValue;

    public enum Tag {
        PATH,
        LINK,
        OTHER
    }

    private PathOrLink() {
    }

    private PathOrLink withTag(Tag tag) {
        PathOrLink pathOrLink = new PathOrLink();
        pathOrLink._tag = tag;
        return pathOrLink;
    }

    private PathOrLink withTagAndPath(Tag tag, String str) {
        PathOrLink pathOrLink = new PathOrLink();
        pathOrLink._tag = tag;
        pathOrLink.pathValue = str;
        return pathOrLink;
    }

    private PathOrLink withTagAndLink(Tag tag, SharedLinkFileInfo sharedLinkFileInfo) {
        PathOrLink pathOrLink = new PathOrLink();
        pathOrLink._tag = tag;
        pathOrLink.linkValue = sharedLinkFileInfo;
        return pathOrLink;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static PathOrLink path(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new PathOrLink().withTagAndPath(Tag.PATH, str);
    }

    public String getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isLink() {
        return this._tag == Tag.LINK;
    }

    public static PathOrLink link(SharedLinkFileInfo sharedLinkFileInfo) {
        if (sharedLinkFileInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PathOrLink().withTagAndLink(Tag.LINK, sharedLinkFileInfo);
    }

    public SharedLinkFileInfo getLinkValue() {
        if (this._tag != Tag.LINK) {
            throw new IllegalStateException("Invalid tag: required Tag.LINK, but was Tag." + this._tag.name());
        }
        return this.linkValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue, this.linkValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof PathOrLink)) {
            return false;
        }
        PathOrLink pathOrLink = (PathOrLink) obj;
        if (this._tag != pathOrLink._tag) {
            return false;
        }
        int i = C41821.$SwitchMap$com$dropbox$core$v2$files$PathOrLink$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.pathValue;
            String str2 = pathOrLink.pathValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return i == 3;
        }
        SharedLinkFileInfo sharedLinkFileInfo = this.linkValue;
        SharedLinkFileInfo sharedLinkFileInfo2 = pathOrLink.linkValue;
        return sharedLinkFileInfo == sharedLinkFileInfo2 || sharedLinkFileInfo.equals(sharedLinkFileInfo2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.PathOrLink$1 */
    static /* synthetic */ class C41821 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$PathOrLink$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$PathOrLink$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PathOrLink$Tag[Tag.LINK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PathOrLink$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<PathOrLink> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PathOrLink pathOrLink, JsonGenerator jsonGenerator) throws IOException {
            int i = C41821.$SwitchMap$com$dropbox$core$v2$files$PathOrLink$Tag[pathOrLink.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                StoneSerializers.string().serialize(pathOrLink.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("link", jsonGenerator);
                SharedLinkFileInfo.Serializer.INSTANCE.serialize(pathOrLink.linkValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PathOrLink deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PathOrLink pathOrLinkLink;
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
            if (ClientCookie.PATH_ATTR.equals(tag)) {
                expectField(ClientCookie.PATH_ATTR, jsonParser);
                pathOrLinkLink = PathOrLink.path(StoneSerializers.string().deserialize(jsonParser));
            } else if ("link".equals(tag)) {
                pathOrLinkLink = PathOrLink.link(SharedLinkFileInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                pathOrLinkLink = PathOrLink.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return pathOrLinkLink;
        }
    }
}
