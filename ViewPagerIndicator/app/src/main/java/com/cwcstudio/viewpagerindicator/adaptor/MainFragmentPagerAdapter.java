package com.cwcstudio.viewpagerindicator.adaptor;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.cwcstudio.viewpagerindicator.fragment.ExpenseButtonFragment;
import java.util.ArrayList;
import java.util.List;

public class MainFragmentPagerAdapter
        extends FragmentPagerAdapter
{
    private List<ExpenseButtonFragment> fragmentList;
    //private int m_theme_choice;

    public MainFragmentPagerAdapter(FragmentManager paramFragmentManager, String[] paramArrayOfString,  boolean paramBoolean)
    {
        super(paramFragmentManager);
        this.fragmentList = genFragmentList(paramArrayOfString, paramBoolean);
    }

    private List<ExpenseButtonFragment> genFragmentList(String[] paramArrayOfString, boolean paramBoolean)
    {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        int i = 0;
        for (int j = 0;; j++)
        {
            if (j >= paramArrayOfString.length)
            {
                localArrayList1.add(ExpenseButtonFragment.init(localArrayList2, i, paramBoolean));
                return makeSureAtLeastTwoFragments(localArrayList1, paramBoolean);
            }
            localArrayList2.add(paramArrayOfString[j]);
            if (localArrayList2.size() >= 9)
            {
                ExpenseButtonFragment localExpenseButtonFragment = ExpenseButtonFragment.init(localArrayList2, i, paramBoolean);
                i++;
                localArrayList1.add(localExpenseButtonFragment);
                localArrayList2 = new ArrayList();
            }
        }
    }

    private List<ExpenseButtonFragment> makeSureAtLeastTwoFragments(List<ExpenseButtonFragment> paramList, boolean paramBoolean)
    {
        if (paramList.size() == 1) {
            paramList.add(ExpenseButtonFragment.init(null, 1, paramBoolean));
        }
        return paramList;
    }

    public int getCount()
    {
        return this.fragmentList.size();
    }

    public Fragment getItem(int paramInt)
    {
        return (Fragment)this.fragmentList.get(paramInt);
    }
}
