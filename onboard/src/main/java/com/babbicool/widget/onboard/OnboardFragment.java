package com.babbicool.widget.onboard;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class OnboardFragment extends Fragment
{

	private static final String ONBOARDER_PAGE_TITLE                 		= "onboarder_page_title";
	private static final String ONBOARDER_PAGE_TITLE_RES_ID          		= "onboarder_page_title_res_id";
	private static final String ONBOARDER_PAGE_TITLE_COLOR           		= "onboarder_page_title_color";
	private static final String ONBOARDER_PAGE_TITLE_TEXT_SIZE       		= "onboarder_page_title_text_size";
	private static final String ONBOARDER_PAGE_DESCRIPTION           		= "onboarder_page_description";
	private static final String ONBOARDER_PAGE_DESCRIPTION_RES_ID    		= "onboarder_page_description_res_id";
	private static final String ONBOARDER_PAGE_DESCRIPTION_COLOR     		= "onborader_page_description_color";
	private static final String ONBOARDER_PAGE_DESCRIPTION_TEXT_SIZE 		= "onboarder_page_description_text_size";
	private static final String ONBOARDER_PAGE_DESCRIPTION_CENTERED 		= "onboarder_page_description_centered";
	private static final String ONBOARDER_PAGE_IMAGE_RES_ID          		= "onboarder_page_iamge_res_id";
	private static final String ONBOARDER_PAGE_BACKGROUND_RES_ID          	= "onboarder_page_background_res_id";

	private              String 	onboarderTitle;
	private              String 	onboarderDescription;
	@StringRes private   int    	onboarderTitleResId;
	@ColorRes private    int    	onboarderTitleColor;
	@StringRes private   int    	onboarderDescriptionResId;
	@ColorRes private    int    	onboarderDescriptionColor;
	@DrawableRes private int    	onboarderImageResId;
	@DrawableRes private int    	onboarderImageBackgroundId;
	private              float  	onboarderTitleTextSize;
	private              float  	onboarderDescriptionTextSize;
	private				 boolean	onboarderDescriptionTextCentered;

	private View      onboarderView;
	private ImageView ivOnboarderImage;
	private TextView  tvOnboarderTitle;
	private TextView  tvOnboarderDescription;
	private RelativeLayout mainContainer;


	public OnboardFragment() {}


	public static OnboardFragment newInstance(OnboardPage page) {
		Bundle args = new Bundle();
		args.putString(ONBOARDER_PAGE_TITLE, page.getTitle());
		args.putString(ONBOARDER_PAGE_DESCRIPTION, page.getDescription());
		args.putInt(ONBOARDER_PAGE_TITLE_RES_ID, page.getTitleResourceId());
		args.putInt(ONBOARDER_PAGE_DESCRIPTION_RES_ID, page.getDescriptionResourceId());
		args.putInt(ONBOARDER_PAGE_TITLE_COLOR, page.getTitleColor());
		args.putInt(ONBOARDER_PAGE_DESCRIPTION_COLOR, page.getDescriptionColor());
		args.putInt(ONBOARDER_PAGE_IMAGE_RES_ID, page.getImageResourceId());
		args.putFloat(ONBOARDER_PAGE_TITLE_TEXT_SIZE, page.getTitleTextSize());
		args.putFloat(ONBOARDER_PAGE_DESCRIPTION_TEXT_SIZE, page.getDescriptionTextSize());
		args.putBoolean(ONBOARDER_PAGE_DESCRIPTION_CENTERED, page.isMultilineDescriptionCentered());
		args.putInt(ONBOARDER_PAGE_BACKGROUND_RES_ID, page.getImageBackgroundResourceId());

		OnboardFragment fragment = new OnboardFragment();
		fragment.setArguments(args);
		return fragment;
	}


	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		Bundle bundle = getArguments();

		onboarderTitle = bundle.getString(ONBOARDER_PAGE_TITLE, null);
		onboarderTitleResId = bundle.getInt(ONBOARDER_PAGE_TITLE_RES_ID, 0);
		onboarderTitleColor = bundle.getInt(ONBOARDER_PAGE_TITLE_COLOR, 0);
		onboarderTitleTextSize = bundle.getFloat(ONBOARDER_PAGE_TITLE_TEXT_SIZE, 0f);
		onboarderDescription = bundle.getString(ONBOARDER_PAGE_DESCRIPTION, null);
		onboarderDescriptionResId = bundle.getInt(ONBOARDER_PAGE_DESCRIPTION_RES_ID, 0);
		onboarderDescriptionColor = bundle.getInt(ONBOARDER_PAGE_DESCRIPTION_COLOR, 0);
		onboarderDescriptionTextSize = bundle.getFloat(ONBOARDER_PAGE_DESCRIPTION_TEXT_SIZE, 0f);
		onboarderDescriptionTextCentered = bundle.getBoolean(ONBOARDER_PAGE_DESCRIPTION_CENTERED, false);
		onboarderImageResId = bundle.getInt(ONBOARDER_PAGE_IMAGE_RES_ID, 0);
		onboarderImageBackgroundId = bundle.getInt(ONBOARDER_PAGE_BACKGROUND_RES_ID, 0);


		onboarderView = inflater.inflate(R.layout.fragment_onboard, container, false);
		ivOnboarderImage = (ImageView) onboarderView.findViewById(R.id.iv_onboarder_image);
		tvOnboarderTitle = (TextView) onboarderView.findViewById(R.id.tv_onboarder_title);
		tvOnboarderDescription = (TextView) onboarderView.findViewById(R.id.tv_onboarder_description);
		mainContainer = (RelativeLayout) onboarderView.findViewById(R.id.mainContainer);

		if(onboarderImageBackgroundId != 0){
			mainContainer.setBackgroundResource(onboarderImageBackgroundId);
		}

		if (onboarderTitle != null) {
			tvOnboarderTitle.setText(onboarderTitle);
		}

		if (onboarderTitleResId != 0) {
			tvOnboarderTitle.setText(getResources().getString(onboarderTitleResId));
		}

		if (onboarderDescription != null) {
			tvOnboarderDescription.setText(onboarderDescription);
		}

		if (onboarderDescriptionResId != 0) {
			tvOnboarderDescription.setText(getResources().getString(onboarderDescriptionResId));
		}

		if (onboarderTitleColor != 0) {
			tvOnboarderTitle.setTextColor(ContextCompat.getColor(getActivity(), onboarderTitleColor));
		}

		if (onboarderDescriptionColor != 0) {
			tvOnboarderDescription.setTextColor(ContextCompat.getColor(getActivity(), onboarderDescriptionColor));
		}

		if (onboarderImageResId != 0) {
			ivOnboarderImage.setImageDrawable(AppCompatResources.getDrawable(getActivity(), onboarderImageResId));
		}

		if (onboarderTitleTextSize != 0f) {
			tvOnboarderTitle.setTextSize(onboarderTitleTextSize);
		}

		if (onboarderDescriptionTextSize != 0f) {
			tvOnboarderDescription.setTextSize(onboarderDescriptionTextSize);
		}

		return onboarderView;
	}


	@Override
	public void onResume() {
		super.onResume();

		tvOnboarderDescription.post(new Runnable()
		{
			@Override
			public void run() {
				if (onboarderDescriptionTextCentered) {
					tvOnboarderDescription.setGravity(Gravity.CENTER);
				} else {
					tvOnboarderDescription.setGravity(tvOnboarderDescription.getLineCount() > 1 ? Gravity.START : Gravity.CENTER);
				}
			}
		});

	}


	@Override
	public void onDetach() {
		super.onDetach();
	}
}
