package com.cwcstudio.viewpagerindicator.fragment;

        import android.app.Activity;
        import android.content.Intent;
        import android.content.res.Resources;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

        import com.cwcstudio.viewpagerindicator.R;

        import java.util.List;

public class ExpenseButtonFragment
        extends Fragment
{
    private boolean isPro;
    private View layoutView;
    private Activity mActivity;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Button mButtonChoice5;
    private Button mButtonChoice6;
    private Button mButtonChoice7;
    private Button mButtonChoice8;
    private Button mButtonChoice9;
    private RelativeLayout mButtonsBox;
    private RelativeLayout mBuyProBox;
    private Button mBuyProButton;
    private TextView mBuyProLabel;
    private int mFragmentIndex;
    private RelativeLayout mFundationLayout;
    private int mThemeChoice;
    private List<String> m_category_name_list;


    /*
    private void changeTheme(int paramInt)
    {
        int i = 0;
        int j = 0;
        if (paramInt == 900)
        {
            j = 2130837572;
            i = getResources().getColor(2131034143);
            this.mFundationLayout.setBackgroundColor(getResources().getColor(2131034144));
        }
        if (paramInt == 901)
        {
            j = 2130837568;
            i = Color.parseColor("#FFFFFF");
            this.mFundationLayout.setBackgroundColor(getResources().getColor(2131034145));
        }
        this.mBuyProButton.setBackgroundResource(j);
        this.mBuyProButton.setTextColor(i);
        this.mBuyProLabel.setTextColor(i);
        this.mButtonChoice1.setBackgroundResource(j);
        this.mButtonChoice2.setBackgroundResource(j);
        this.mButtonChoice3.setBackgroundResource(j);
        this.mButtonChoice4.setBackgroundResource(j);
        this.mButtonChoice5.setBackgroundResource(j);
        this.mButtonChoice6.setBackgroundResource(j);
        this.mButtonChoice7.setBackgroundResource(j);
        this.mButtonChoice8.setBackgroundResource(j);
        this.mButtonChoice9.setBackgroundResource(j);
        this.mButtonChoice1.setTextColor(i);
        this.mButtonChoice2.setTextColor(i);
        this.mButtonChoice3.setTextColor(i);
        this.mButtonChoice4.setTextColor(i);
        this.mButtonChoice5.setTextColor(i);
        this.mButtonChoice6.setTextColor(i);
        this.mButtonChoice7.setTextColor(i);
        this.mButtonChoice8.setTextColor(i);
        this.mButtonChoice9.setTextColor(i);
    }
    */

    private void connectLayoutWithObjects(View paramView)
    {
        this.mFundationLayout = ((RelativeLayout)paramView.findViewById(R.id.fundation_layout));
        this.mButtonChoice1 = ((Button)paramView.findViewById(R.id.button_choice_1));
        this.mButtonChoice2 = ((Button)paramView.findViewById(R.id.button_choice_2));
        this.mButtonChoice3 = ((Button)paramView.findViewById(R.id.button_choice_3));
        this.mButtonChoice4 = ((Button)paramView.findViewById(R.id.button_choice_4));
        this.mButtonChoice5 = ((Button)paramView.findViewById(R.id.button_choice_5));
        this.mButtonChoice6 = ((Button)paramView.findViewById(R.id.button_choice_6));
        this.mButtonChoice7 = ((Button)paramView.findViewById(R.id.button_choice_7));
        this.mButtonChoice8 = ((Button)paramView.findViewById(R.id.button_choice_8));
        this.mButtonChoice9 = ((Button)paramView.findViewById(R.id.button_choice_9));
        //OnButtonClickListener localOnButtonClickListener = new OnButtonClickListener(null);
        /*
         this.mBuyProButton.setOnClickListener(localOnButtonClickListener);
        this.mButtonChoice1.setOnClickListener(localOnButtonClickListener);
        this.mButtonChoice2.setOnClickListener(localOnButtonClickListener);
        this.mButtonChoice3.setOnClickListener(localOnButtonClickListener);
        this.mButtonChoice4.setOnClickListener(localOnButtonClickListener);
        this.mButtonChoice5.setOnClickListener(localOnButtonClickListener);
        this.mButtonChoice6.setOnClickListener(localOnButtonClickListener);
        this.mButtonChoice7.setOnClickListener(localOnButtonClickListener);
        this.mButtonChoice8.setOnClickListener(localOnButtonClickListener);
        this.mButtonChoice9.setOnClickListener(localOnButtonClickListener);
        */
    }

    public static ExpenseButtonFragment init(List<String> paramList, int paramInt1, boolean paramBoolean)
    {
        ExpenseButtonFragment localExpenseButtonFragment = new ExpenseButtonFragment();
        localExpenseButtonFragment.m_category_name_list = paramList;
        localExpenseButtonFragment.mFragmentIndex = paramInt1;
        localExpenseButtonFragment.isPro = paramBoolean;
        return localExpenseButtonFragment;
    }

    private int showCategoryButtons()
    {
        int tmp = 2 ;
        this.mButtonChoice1.setVisibility(View.GONE);
        this.mButtonChoice2.setVisibility(View.GONE);
        this.mButtonChoice3.setVisibility(View.GONE);
        this.mButtonChoice4.setVisibility(View.GONE);
        this.mButtonChoice5.setVisibility(View.GONE);
        this.mButtonChoice6.setVisibility(View.GONE);
        this.mButtonChoice7.setVisibility(View.GONE);
        this.mButtonChoice8.setVisibility(View.GONE);
        this.mButtonChoice9.setVisibility(View.GONE);
        if (this.m_category_name_list == null) {
            tmp = 0 ;
            return 0;
        }
        int i = 0;
        if (i >= this.m_category_name_list.size()) {
            tmp =1 ;
            return 1;
        }


            this.mButtonChoice1.setText((CharSequence)this.m_category_name_list.get(i));
            this.mButtonChoice1.setVisibility(View.VISIBLE);

            this.mButtonChoice2.setText((CharSequence)this.m_category_name_list.get(i));
            this.mButtonChoice2.setVisibility(View.VISIBLE);

            this.mButtonChoice3.setText((CharSequence)this.m_category_name_list.get(i));
            this.mButtonChoice3.setVisibility(View.VISIBLE);

            this.mButtonChoice4.setText((CharSequence)this.m_category_name_list.get(i));
            this.mButtonChoice4.setVisibility(View.VISIBLE);

            this.mButtonChoice5.setText((CharSequence)this.m_category_name_list.get(i));
            this.mButtonChoice5.setVisibility(View.VISIBLE);

            this.mButtonChoice6.setText((CharSequence)this.m_category_name_list.get(i));
            this.mButtonChoice6.setVisibility(View.VISIBLE);

            this.mButtonChoice7.setText((CharSequence)this.m_category_name_list.get(i));
            this.mButtonChoice7.setVisibility(View.VISIBLE);

            this.mButtonChoice8.setText((CharSequence)this.m_category_name_list.get(i));
            this.mButtonChoice8.setVisibility(View.VISIBLE);

            this.mButtonChoice9.setText((CharSequence)this.m_category_name_list.get(i));
            this.mButtonChoice9.setVisibility(View.VISIBLE);

        return tmp ;
    }

    public void onActivityCreated(Bundle paramBundle)
    {
        super.onActivityCreated(paramBundle);
    }

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        this.mActivity = getActivity();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        this.layoutView = paramLayoutInflater.inflate(R.layout.fragment_expense_buttons, paramViewGroup, false);
        connectLayoutWithObjects(this.layoutView);
        /*
        if ((this.isPro) || (this.mFragmentIndex == 0))
        {
            this.mBuyProBox.setVisibility(View.GONE);
            this.mButtonsBox.setVisibility(View.VISIBLE);
        }
        for (;;)
        {
            return this.layoutView;
            this.mBuyProBox.setVisibility(View.VISIBLE);
            this.mButtonsBox.setVisibility(View.GONE);
        }
        */
        this.mButtonsBox.setVisibility(View.VISIBLE);
        return this.layoutView;
    }

    public void onResume()
    {
        super.onResume();
    }

    public void onStart()
    {
        super.onStart();
        showCategoryButtons();
    }

    public void onStop()
    {
        super.onStop();
    }


    /*
    private class OnButtonClickListener
            implements View.OnClickListener
    {
        private OnButtonClickListener() {}

        public void onClick(View paramView)
        {
            String str = (String)((Button)paramView).getText();
            if (paramView.equals(ExpenseButtonFragment.this.mBuyProButton))
            {
                localIntent1 = new Intent(ExpenseButtonFragment.this.mActivity, BuyProActivity.class);
                ExpenseButtonFragment.this.startActivity(localIntent1);
            }
            while (str.length() <= 0)
            {
                Intent localIntent1;
                return;
            }
            Intent localIntent2 = new Intent(ExpenseButtonFragment.this.mActivity, InputRecordActivity.class);
            localIntent2.putExtra("category_type", str);
            localIntent2.putExtra("entry_type", "expense");
            ExpenseButtonFragment.this.startActivity(localIntent2);
        }
    }
    */

}
