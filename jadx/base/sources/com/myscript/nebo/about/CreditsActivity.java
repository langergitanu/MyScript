package com.myscript.nebo.about;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes5.dex */
public class CreditsActivity extends AppCompatActivity implements OnCreditClickListener {
    private View mDetailPane;

    public static Intent newIntent(Context context) {
        return new Intent(context, (Class<?>) CreditsActivity.class);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(8);
        setTitle(C6079R.string.about_credits);
        setContentView(C6079R.layout.credits_activity);
        this.mDetailPane = findViewById(C6079R.id.credit_detail_container);
        RecyclerView recyclerView = (RecyclerView) findViewById(C6079R.id.credits_list);
        recyclerView.setAdapter(new CreditsAdapter(this, this.mDetailPane != null));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.myscript.nebo.about.OnCreditClickListener
    public void onCreditClicked(CreditData creditData) {
        if (this.mDetailPane != null) {
            getSupportFragmentManager().beginTransaction().replace(C6079R.id.credit_detail_container, CreditDetailFragment.newInstance(creditData.title, creditData.content)).commit();
        } else {
            startActivity(CreditDetailActivity.newIntent(this, creditData));
        }
    }

    static class CreditData {
        public final int content;
        public final int title;

        CreditData(int i, int i2) {
            this.title = i;
            this.content = i2;
        }
    }

    static class CreditsAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final CreditData[] CREDITS = {new CreditData(C6079R.string.credits_kotlin_title, C6079R.string.credits_kotlin_content), new CreditData(C6079R.string.credits_asl_title, C6079R.string.credits_asl_content), new CreditData(C6079R.string.credits_mdc_title, C6079R.string.credits_mdc_content), new CreditData(C6079R.string.credits_play_auth_title, C6079R.string.credits_play_auth_content), new CreditData(C6079R.string.credits_firebase_title, C6079R.string.credits_firebase_content), new CreditData(C6079R.string.credits_crashlytics_title, C6079R.string.credits_crashlytics_content), new CreditData(C6079R.string.credits_otto_title, C6079R.string.credits_otto_content), new CreditData(C6079R.string.credits_okhttp3_title, C6079R.string.credits_okhttp3_content), new CreditData(C6079R.string.credits_retrofit_title, C6079R.string.credits_retrofit_content), new CreditData(C6079R.string.credits_leakcanary_title, C6079R.string.credits_leakcanary_content), new CreditData(C6079R.string.credits_icu_title, C6079R.string.credits_icu_content), new CreditData(C6079R.string.credits_ttf_title, C6079R.string.credits_ttf_content), new CreditData(C6079R.string.credits_dropbox_title, C6079R.string.credits_dropbox_content), new CreditData(C6079R.string.credits_ejml_title, C6079R.string.credits_ejml_content), new CreditData(C6079R.string.credits_jodatime_title, C6079R.string.credits_jodatime_content), new CreditData(C6079R.string.credits_aws_title, C6079R.string.credits_aws_content), new CreditData(C6079R.string.credits_glide_title, C6079R.string.credits_glide_content), new CreditData(C6079R.string.credits_gson_title, C6079R.string.credits_gson_content), new CreditData(C6079R.string.credits_ellipsize_textview_title, C6079R.string.credits_ellipsize_textview_content), new CreditData(C6079R.string.credits_libffi_title, C6079R.string.credits_libffi_content), new CreditData(C6079R.string.credits_dtoa_title, C6079R.string.credits_dtoa_content), new CreditData(C6079R.string.credits_miniz_title, C6079R.string.credits_miniz_content), new CreditData(C6079R.string.credits_xxhash_title, C6079R.string.credits_xxhash_content), new CreditData(C6079R.string.credits_libc_title, C6079R.string.credits_libc_content), new CreditData(C6079R.string.pdfnet_title, C6079R.string.pdfnet_content), new CreditData(C6079R.string.credits_jhead_title, C6079R.string.credits_jhead_content), new CreditData(C6079R.string.credits_fastlog_title, C6079R.string.credits_fastlog_content), new CreditData(C6079R.string.credits_box2D_title, C6079R.string.credits_box2D_content), new CreditData(C6079R.string.credits_ucrop_title, C6079R.string.credits_ucrop_content), new CreditData(C6079R.string.credits_stix_title, C6079R.string.credits_stix_content), new CreditData(C6079R.string.credits_inter_font_title, C6079R.string.credits_inter_font_content)};
        private final OnCreditClickListener mClickListener;
        private View mCurrentSelectedView;
        private final boolean mDisplaySelected;

        public CreditsAdapter(OnCreditClickListener onCreditClickListener, boolean z) {
            this.mClickListener = onCreditClickListener;
            this.mDisplaySelected = z;
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            public final TextView credit_label;

            public ViewHolder(View view) {
                super(view);
                this.credit_label = (TextView) view.findViewById(C6079R.id.credit_item);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C6079R.layout.credits_button, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            final CreditData creditData = CREDITS[i];
            viewHolder.credit_label.setText(creditData.title);
            viewHolder.credit_label.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.about.CreditsActivity$CreditsAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(creditData, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(CreditData creditData, View view) {
            if (this.mDisplaySelected) {
                View view2 = this.mCurrentSelectedView;
                if (view2 != null) {
                    view2.setSelected(false);
                }
                view.setSelected(true);
                this.mCurrentSelectedView = view;
            }
            OnCreditClickListener onCreditClickListener = this.mClickListener;
            if (onCreditClickListener != null) {
                onCreditClickListener.onCreditClicked(creditData);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CREDITS.length;
        }
    }
}
