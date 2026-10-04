package com.google.common.net;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class HostAndPort implements Serializable {
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    private static boolean isValidPort(int port) {
        return port >= 0 && port <= 65535;
    }

    private HostAndPort(String host, int port, boolean hasBracketlessColons) {
        this.host = host;
        this.port = port;
        this.hasBracketlessColons = hasBracketlessColons;
    }

    public String getHost() {
        return this.host;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int getPort() {
        Preconditions.checkState(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int defaultPort) {
        return hasPort() ? this.port : defaultPort;
    }

    public static HostAndPort fromParts(String host, int port) {
        Preconditions.checkArgument(isValidPort(port), "Port out of range: %s", port);
        HostAndPort hostAndPortFromString = fromString(host);
        Preconditions.checkArgument(!hostAndPortFromString.hasPort(), "Host has a port: %s", host);
        return new HostAndPort(hostAndPortFromString.host, port, hostAndPortFromString.hasBracketlessColons);
    }

    public static HostAndPort fromHost(String host) {
        HostAndPort hostAndPortFromString = fromString(host);
        Preconditions.checkArgument(!hostAndPortFromString.hasPort(), "Host has a port: %s", host);
        return hostAndPortFromString;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HostAndPort fromString(String hostPortString) {
        boolean z;
        String strSubstring;
        String str;
        String strSubstring2;
        Integer num;
        Preconditions.checkNotNull(hostPortString);
        if (hostPortString.startsWith("[")) {
            String[] hostAndPortFromBracketedHost = getHostAndPortFromBracketedHost(hostPortString);
            strSubstring2 = hostAndPortFromBracketedHost[0];
            strSubstring = hostAndPortFromBracketedHost[1];
        } else {
            int iIndexOf = hostPortString.indexOf(58);
            if (iIndexOf >= 0) {
                int i = iIndexOf + 1;
                if (hostPortString.indexOf(58, i) == -1) {
                    strSubstring2 = hostPortString.substring(0, iIndexOf);
                    strSubstring = hostPortString.substring(i);
                }
            }
            z = iIndexOf >= 0;
            strSubstring = null;
            str = hostPortString;
            if (!Strings.isNullOrEmpty(strSubstring)) {
                num = -1;
            } else {
                Integer numTryParse = Ints.tryParse(strSubstring);
                Preconditions.checkArgument(numTryParse != null, "Unparseable port number: %s", hostPortString);
                Preconditions.checkArgument(isValidPort(numTryParse.intValue()), "Port number out of range: %s", hostPortString);
                num = numTryParse;
            }
            return new HostAndPort(str, num.intValue(), z);
        }
        str = strSubstring2;
        z = false;
        if (!Strings.isNullOrEmpty(strSubstring)) {
        }
        return new HostAndPort(str, num.intValue(), z);
    }

    private static String[] getHostAndPortFromBracketedHost(String hostPortString) {
        Preconditions.checkArgument(hostPortString.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", hostPortString);
        int iIndexOf = hostPortString.indexOf(58);
        int iLastIndexOf = hostPortString.lastIndexOf(93);
        Preconditions.checkArgument(iIndexOf > -1 && iLastIndexOf > iIndexOf, "Invalid bracketed host/port: %s", hostPortString);
        String strSubstring = hostPortString.substring(1, iLastIndexOf);
        int i = iLastIndexOf + 1;
        if (i == hostPortString.length()) {
            return new String[]{strSubstring, ""};
        }
        Preconditions.checkArgument(hostPortString.charAt(i) == ':', "Only a colon may follow a close bracket: %s", hostPortString);
        int i2 = iLastIndexOf + 2;
        for (int i3 = i2; i3 < hostPortString.length(); i3++) {
            Preconditions.checkArgument(Character.isDigit(hostPortString.charAt(i3)), "Port must be numeric: %s", hostPortString);
        }
        return new String[]{strSubstring, hostPortString.substring(i2)};
    }

    public HostAndPort withDefaultPort(int defaultPort) {
        Preconditions.checkArgument(isValidPort(defaultPort));
        return hasPort() ? this : new HostAndPort(this.host, defaultPort, this.hasBracketlessColons);
    }

    public HostAndPort requireBracketsForIPv6() {
        Preconditions.checkArgument(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HostAndPort) {
            HostAndPort hostAndPort = (HostAndPort) other;
            if (Objects.equal(this.host, hostAndPort.host) && this.port == hostAndPort.port) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.host, Integer.valueOf(this.port));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) >= 0) {
            sb.append('[').append(this.host).append(']');
        } else {
            sb.append(this.host);
        }
        if (hasPort()) {
            sb.append(AbstractJsonLexerKt.COLON).append(this.port);
        }
        return sb.toString();
    }
}
