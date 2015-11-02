package com.linkonworks.df.busi.comment;

import java.util.Comparator;

import com.linkonworks.df.vo.DiseaseItemTemplate;
import com.linkonworks.df.vo.FlupItemResponse;

public class ComparaDiseaseItem implements Comparator<DiseaseItemTemplate>{

	@Override
	public int compare(DiseaseItemTemplate arg0, DiseaseItemTemplate arg1) {
		// TODO Auto-generated method stub
		return Integer.parseInt(arg0.getShowNo()) - Integer.parseInt(arg1.getShowNo()) ;
	}

	/*@Override
	public int compare(FlupItemResponse o1, FlupItemResponse o2) {
		// TODO Auto-generated method stub
		return Integer.parseInt(o1.getShowNo())-Integer.parseInt(o2.getShowNo());
	}*/

}
