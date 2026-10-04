package com.android.billingclient.api;

import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class UserChoiceDetails {
    private final String mOriginalJson;
    private final JSONObject mParsedJson;
    private final List<Product> mProducts;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
    public static class Product {

        /* JADX INFO: renamed from: id */
        private final String f549id;
        private final String offerToken;
        private final String type;

        Product(String str, String str2, String str3) {
            this.f549id = str;
            this.type = str2;
            this.offerToken = str3;
        }

        private Product(JSONObject jSONObject) {
            this.f549id = jSONObject.optString("productId");
            this.type = jSONObject.optString("productType");
            String strOptString = jSONObject.optString("offerToken");
            this.offerToken = true == strOptString.isEmpty() ? null : strOptString;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Product)) {
                return false;
            }
            Product product = (Product) obj;
            return this.f549id.equals(product.getId()) && this.type.equals(product.getType()) && Objects.equals(this.offerToken, product.getOfferToken());
        }

        public String getId() {
            return this.f549id;
        }

        public String getOfferToken() {
            return this.offerToken;
        }

        public String getType() {
            return this.type;
        }

        public int hashCode() {
            return Objects.hash(this.f549id, this.type, this.offerToken);
        }

        public String toString() {
            return String.format("{id: %s, type: %s, offer token: %s}", this.f549id, this.type, this.offerToken);
        }
    }

    UserChoiceDetails(String str) throws JSONException {
        this.mOriginalJson = str;
        JSONObject jSONObject = new JSONObject(str);
        this.mParsedJson = jSONObject;
        this.mProducts = toProductList(jSONObject.optJSONArray(Keys.PRODUCTS));
    }

    private static List<Product> toProductList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new Product(jSONObjectOptJSONObject));
                }
            }
        }
        return arrayList;
    }

    public String getExternalTransactionToken() {
        return this.mParsedJson.optString("externalTransactionToken");
    }

    public String getOriginalExternalTransactionId() {
        String strOptString = this.mParsedJson.optString("originalExternalTransactionId");
        if (strOptString.isEmpty()) {
            return null;
        }
        return strOptString;
    }

    public List<Product> getProducts() {
        return this.mProducts;
    }
}
