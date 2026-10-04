package com.revenuecat.purchases.common.security;

import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SecureItemStorage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H&J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u0004H&J\"\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&¨\u0006\u0011À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/security/SecureItemStorage;", "", "allItemIdentifiers", "", "", "containsItem", "", Keys.IDENTIFIER, "deleteItem", "", "modifyItem", "contents", "", "attributes", "Lcom/revenuecat/purchases/common/security/SecureItemAttributes;", "readItem", "saveItem", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface SecureItemStorage {
    List<String> allItemIdentifiers() throws SecureStorageException;

    void deleteItem(String identifier) throws SecureStorageException;

    byte[] readItem(String identifier) throws SecureStorageException;

    void saveItem(String identifier, byte[] contents, SecureItemAttributes attributes) throws SecureStorageException;

    /* JADX INFO: compiled from: SecureItemStorage.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean containsItem(SecureItemStorage secureItemStorage, String identifier) throws SecureStorageException {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return SecureItemStorage.super.containsItem(identifier);
        }

        @Deprecated
        public static void modifyItem(SecureItemStorage secureItemStorage, String identifier, byte[] bArr, SecureItemAttributes attributes) throws SecureStorageException {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            SecureItemStorage.super.modifyItem(identifier, bArr, attributes);
        }
    }

    default boolean containsItem(String identifier) throws SecureStorageException {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return allItemIdentifiers().contains(identifier);
    }

    static /* synthetic */ void modifyItem$default(SecureItemStorage secureItemStorage, String str, byte[] bArr, SecureItemAttributes secureItemAttributes, int i, Object obj) throws SecureStorageException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modifyItem");
        }
        if ((i & 4) != 0) {
            secureItemAttributes = new SecureItemAttributes(false, 1, null);
        }
        secureItemStorage.modifyItem(str, bArr, secureItemAttributes);
    }

    default void modifyItem(String identifier, byte[] contents, SecureItemAttributes attributes) throws SecureStorageException {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        if (contents != null) {
            saveItem(identifier, contents, attributes);
        } else {
            deleteItem(identifier);
        }
    }

    static /* synthetic */ void saveItem$default(SecureItemStorage secureItemStorage, String str, byte[] bArr, SecureItemAttributes secureItemAttributes, int i, Object obj) throws SecureStorageException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveItem");
        }
        if ((i & 4) != 0) {
            secureItemAttributes = new SecureItemAttributes(false, 1, null);
        }
        secureItemStorage.saveItem(str, bArr, secureItemAttributes);
    }
}
