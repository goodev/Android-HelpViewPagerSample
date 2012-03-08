package org.goodev.hvpsample;

import org.goodev.helpviewpager.HelpFragmentPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

class TestFragmentAdapter extends HelpFragmentPagerAdapter {
	protected static final String[] CONTENT = new String[] { "Help Page 1", "Help Page 2", "Help Page 3", "Help Page 4",    };
	
	private int mCount = CONTENT.length;

	public TestFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getHelpItem(int position) {
		return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
	}

	@Override
	public int getHelpCount() {
		return mCount;
	}
	
	public void setCount(int count) {
		if (count > 0 && count <= 10) {
			mCount = count;
			notifyDataSetChanged();
		}
	}
}