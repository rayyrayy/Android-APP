package com.cwcstudio.viewpagerindicator.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import com.cwcstudio.viewpagerindicator.R;
import com.cwcstudio.viewpagerindicator.adaptor.MainFragmentPagerAdapter;
import com.viewpagerindicator.UnderlinePageIndicator;

import java.util.Iterator;
import java.util.List;


public class MainActivity
        extends FragmentActivity
{
    private String TAG = "MainActivity";
    final Context context = this;
    private MainActivity mActivity;
    private ImageButton mButton_add_category;
    private Button mButton_add_income;
    private ImageButton mButton_menu;
    private Button mButton_summary;
    private RelativeLayout mFundationLayout;
    private UnderlinePageIndicator mPageIndicator;
    private TextView mTitleTextTV;
    private ViewPager mViewPager;


    private void connectButtonsWithLayout()
    {
        this.mViewPager = ((ViewPager)findViewById(R.id.view_pager));
        this.mPageIndicator = ((UnderlinePageIndicator)findViewById(R.id.page_indicator));
        this.mFundationLayout = ((RelativeLayout)findViewById(R.id.bottom_layout));
        this.mTitleTextTV = ((TextView)findViewById(R.id.title_text_tv));
    }

    /*
    private View.OnClickListener createOnClickListener()
    {
        new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                ((String)((Button)paramAnonymousView).getText());
                if (paramAnonymousView.equals(MainActivity.this.mButton_summary))
                {
                    localIntent1 = new Intent(MainActivity.this, SummaryActivity.class);
                    MainActivity.this.startActivity(localIntent1);
                }
                while (!paramAnonymousView.equals(MainActivity.this.mButton_add_income))
                {
                    Intent localIntent1;
                    return;
                }
                Intent localIntent2 = new Intent(MainActivity.this, InputRecordActivity.class);
                localIntent2.putExtra("entry_type", "income");
                MainActivity.this.startActivity(localIntent2);
            }
        };
    }
    */

    private void showCategoryButtonFragments()
    {
        //int i = getSharedPreferences("com.cwcstudio.ViewPagerIndicator", 0).getInt("shared_pref_theme_color_choice", 900);

        String[] arrayOfString ={"test","box2"};
        FragmentManager localFragmentManager = getSupportFragmentManager();
        List localList = localFragmentManager.getFragments();
        Iterator localIterator = null;
        if (localList != null) {
            localIterator = localList.iterator();
        }
        for (;;)
        {
            if (!localIterator.hasNext())
            {
                MainFragmentPagerAdapter localMainFragmentPagerAdapter = new MainFragmentPagerAdapter(localFragmentManager, arrayOfString, false);
                this.mViewPager.setAdapter(localMainFragmentPagerAdapter);
                this.mPageIndicator.setViewPager(this.mViewPager);
                this.mPageIndicator.setFadeDelay(1000);
                this.mPageIndicator.setFadeLength(500);
                localMainFragmentPagerAdapter.notifyDataSetChanged();
                return;
            }
            Fragment localFragment = (Fragment)localIterator.next();
            FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
            localFragmentTransaction.remove(localFragment);
            localFragmentTransaction.commit();
        }
    }

    /*
    private void showMenuDialog()
    {

        View localView = this.mActivity.getLayoutInflater().inflate(2130903065, null);
        ((RelativeLayout)localView.findViewById(2130968681)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                Intent localIntent = new Intent(MainActivity.this, CategoryEditorActivity.class);
                MainActivity.this.startActivity(localIntent);
            }
        });
        ((RelativeLayout)localView.findViewById(2130968684)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                SharedPreferences.Editor localEditor = MainActivity.this.mActivity.getSharedPreferences("com.maxsuntw.moneytrack", 0).edit();
                localEditor.putBoolean("s_p_n_f_a_s_331", false);
                localEditor.commit();
                Intent localIntent = new Intent(MainActivity.this, SettingActivity.class);
                MainActivity.this.startActivity(localIntent);
            }
        });
        ((RelativeLayout)localView.findViewById(2130968687)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                Intent localIntent = new Intent();
                localIntent.setAction("android.intent.action.SEND");
                localIntent.putExtra("android.intent.extra.TEXT", "閃電記帳 (Android)\nhttps://play.google.com/store/apps/details?id=com.maxsuntw.moneytrack");
                localIntent.setType("text/plain");
                MainActivity.this.startActivity(Intent.createChooser(localIntent, "分享這個App"));
            }
        });
        ((RelativeLayout)localView.findViewById(2130968688)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.maxsuntw.moneytrack"));
                MainActivity.this.startActivity(localIntent);
            }
        });
        ((RelativeLayout)localView.findViewById(2130968686)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                if (MainActivity.this.isPro)
                {
                    Intent localIntent = new Intent(MainActivity.this, BackupAndRestoreActivity.class);
                    MainActivity.this.startActivity(localIntent);
                    return;
                }
                MainActivity.this.showDialog_buy_pro();
            }
        });
        ImageView localImageView = (ImageView)localView.findViewById(2130968685);
        if (this.mActivity.getSharedPreferences("com.maxsuntw.moneytrack", 0).getBoolean("s_p_n_f_a_s_331", true)) {
            localImageView.setVisibility(0);
        }
        for (;;)
        {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
            localBuilder.setView(localView);
            AlertDialog localAlertDialog = localBuilder.create();
            localAlertDialog.setCanceledOnTouchOutside(true);
            localAlertDialog.show();
            return;
            localImageView.setVisibility(4);
        }
    }

    */
    private void updateTitleTV()
    {
        if (false)
        {
            this.mTitleTextTV.setText("VPI test");
            return;
        }
        this.mTitleTextTV.setText("ViewPagerIndicator test");
    }

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_main);
        this.mActivity = this;
        connectButtonsWithLayout();
        this.mTitleTextTV.setText(getString(R.string.app_name));
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    protected void onResume()
    {
        Log.e(this.TAG, "onResume() is called");
        super.onResume();
    }

    protected void onResumeFragments()
    {
        Log.e(this.TAG, "onResumeFragments() is called");
        super.onResumeFragments();
        showCategoryButtonFragments();
    }

}
