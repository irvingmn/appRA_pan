/*
 * Created on Feb 11, 2011
 *
 * Title:  QCChart2DAndroid - Quinn-Curtis Charting Software for Android
 * Description:  Example program for QCChart2D for Android  charting software
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Quinn-Curtis, Inc. </p>
 * @author Quinn-Curtis staff
 * @version 2.1
*/
package com.quinncurtis.chart2dandroid.examples.bargraphs;

import android.content.Context;
import android.util.AttributeSet;


import com.quinncurtis.chart2dandroid.*;

public class SimpleHorizontalDatasetViewer1 extends DatasetViewer {

	static final long serialVersionUID = -2694727824980681981L;

	public SimpleHorizontalDatasetViewer1(Context context)
  {
	    super(context);
	    setFocusable(true);

	}
	
	  public SimpleHorizontalDatasetViewer1(Context context, AttributeSet attrs) {
		   super(context, attrs);
		      setFocusable(true);
	 }
	 
	 public SimpleHorizontalDatasetViewer1(Context context, AttributeSet attrs, int defStyle) {
	   super(context, attrs, defStyle);
	     setFocusable(true);

	 }	

	void InitializeDatasetViewer(SimpleBarPlotChart chartVu)
	{	
        ChartRectangle2D posrect = new ChartRectangle2D(0.05, 0.67, 0.9, 0.26);
        int rows = 2, columns = 7, start=0;

        initDatasetViewer(chartVu, chartVu.pTransform1, posrect, chartVu.Dataset1, rows, columns, start);

      //  datasetViewer1.enableEdit(true);
        getDatasetTable().setTableBackgroundMode(ChartGeneralizedTableDisplay.TABLE_SINGLE_COLOR_BACKGROUND_GRIDCELL);
        setUseStripedGridBackground(true);
        setRowHeaderFont( new ChartFont("SansSerif", ChartFont.BOLD, 14));
        setColumnHeaderFont (new ChartFont("SansSerif", ChartFont.BOLD, 14));
        setGridCellFont( new ChartFont("SansSerif", ChartFont.PLAIN, 14));
        setSyncChart( true);
        setSyncTableRange(true);
	}

	
}
