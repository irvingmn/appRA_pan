/**
 * Title:  bargraphs example program
 * Description:  Example program for QCChart2D for Android  charting software
 * Copyright:  Copyright (c) 2011
 * Company:  Quinn-Curtis, Inc.
 * @author:  Staff
 * @version 2.1
 */
package com.quinncurtis.chart2dandroid.examples.bargraphs;

 
import android.content.Context;

import com.quinncurtis.chart2dandroid.*;

/**
 * @author Quinn-Curtis Staff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class JapanWorkforce extends ChartView {

	static final long serialVersionUID = -2694727924980681981L;

	double [] AgeBins = {1,2, 3,4, 5};
	String [] BinStrings = {"0-19", "20-39", "40-59", "60-79", "80+"};

	double []Male1960 =    {19.5, 15.1,  8.2,  3.1,  0.2};
	double []Female1960 =  {18.5, 15.5,  9.2,  4.1,  0.4};
	double []Male2002 =    {13.1, 17.7, 17.3, 11.5 , 1.5};
	double []Female2002 =  {12.1, 18.1, 18.2, 12.1,  3.4};

	public JapanWorkforce(Context context)
	{
	      super(context);
	      setFocusable(true);
		  InitializeChart();

	   }


	void CreatePlot(double left, double top, double right, double bottom, 
					SimpleDataset dataset, boolean male, ChartColor plotcolor)
	{
		ChartView chartVu  = this;
		ChartFont plotFont = new ChartFont("SansSerif",  ChartFont.PLAIN, 14);

		// Auto-scale 
		CartesianCoordinates pTransform1 = new CartesianCoordinates();
		pTransform1.autoScale(dataset, ChartConstants.AUTOAXES_FAR, ChartConstants.AUTOAXES_FAR);
		if (male)
		  pTransform1.invertScaleX();
		// Want bottom edge of first bar (y-value = 1) at bottom of scale.
		pTransform1.setScaleStartY( 0.75);
		//Auto scale sets y-max to 6, change to 5.5 for smaller gap
		pTransform1.setScaleStopY ( 5.5);

		// Position window
		pTransform1.setGraphBorderDiagonal(left, top, right, bottom) ;


		// Create plot background
		Background plotbackground1 = new Background( pTransform1, 
			ChartConstants.PLOT_BACKGROUND,	ChartColor.CORNSILK);
		chartVu.addChartObject(plotbackground1);

		// Linear x-axis
		LinearAxis xAxis1 = new LinearAxis(pTransform1, ChartConstants.X_AXIS);
		xAxis1.setLineColor(ChartColor.BLACK);
		// Place x-axis at top
		xAxis1.setAxisIntercept(pTransform1.getScaleStopY());
		// Point tick marks up
		xAxis1.setAxisTickDir(ChartConstants.AXIS_MAX);
		// Make major tick mark length 0 to bring tick mark labels down
		xAxis1.setAxisMajorTickLength( 0);
		// Do not draw x-axis, used as reference for axis labels
		xAxis1.setChartObjEnable(ChartConstants.OBJECT_ENABLE_NODRAW);
		chartVu.addChartObject(xAxis1);

		// Create but do not draw the linear y-axis (OBJECT_ENABLE_NODRAW)
		LinearAxis yAxis1 = new LinearAxis(pTransform1, ChartConstants.Y_AXIS);
		// Force major tick mark every unit, no minor tick marks, 
		// to match tick mark string labels
		yAxis1.setAxisTickSpace( 1);
		yAxis1.setAxisMinorTicksPerMajor( 1);
		yAxis1.setAxisIntercept(xAxis1.getAxisMax());
		if (male)
			yAxis1.setAxisTickDir( ChartConstants.AXIS_MIN);
		else
		    yAxis1.setAxisTickDir(ChartConstants.AXIS_MAX);
		// Show or don't show axis
//		yAxis1.setChartObjEnable(ChartConstants.OBJECT_ENABLE_NODRAW);
		chartVu.addChartObject(yAxis1);

		// Simple numeric x-axis labels
		NumericAxisLabels xAxisLab1 = new NumericAxisLabels(xAxis1 );
		xAxisLab1.setLineColor(ChartColor.BLACK);
		xAxisLab1.setAxisLabelsDir( ChartConstants.AXIS_MAX);
		chartVu.addChartObject(xAxisLab1);

		// Y-axis string labels
		// Each string will label a major tick mark
		StringAxisLabels yAxisLab1 = new StringAxisLabels(yAxis1);
		yAxisLab1.setAxisLabels(plotFont,0,
			ChartConstants.AXIS_MIN, ChartConstants.LABEL_ALL,
			ChartColor.BLACK,BinStrings,5);
		yAxisLab1.setLineColor(ChartColor.BLACK);
		if (male)
			yAxisLab1.setAxisLabelsDir(ChartConstants.AXIS_MIN);
		else
			yAxisLab1.setAxisLabelsDir(ChartConstants.AXIS_MAX);			
		chartVu.addChartObject(yAxisLab1);

		// X-Axis grid
		Grid xAxis1Grid = new Grid(xAxis1, yAxis1, 
					ChartConstants.X_AXIS, ChartConstants.GRID_MAJOR);
		xAxis1Grid.setLineColor(ChartColor.BLACK);
		chartVu.addChartObject(xAxis1Grid);

		double barwidth = 0.5;
		double barbase = 0.0;
		// Simple bar graph
		ChartAttribute attrib1 = new ChartAttribute (plotcolor, 1,
			ChartConstants.LS_SOLID, plotcolor);
		SimpleBarPlot thePlot1 = new SimpleBarPlot(pTransform1, dataset, 
			barwidth, barbase, attrib1, ChartConstants.JUSTIFY_MIN);
		thePlot1.setBarOrient(ChartConstants.HORIZ_DIR);
		thePlot1.setBarJust(ChartConstants.JUSTIFY_CENTER);
		chartVu.addChartObject(thePlot1);

		String captionstring = "";
		if (male)
			captionstring = "Male";
		else 
			captionstring = "Female";
		double xpos = (xAxis1.getAxisMax() - xAxis1.getAxisMin()) / 2;
		double ypos =  yAxis1.getAxisMax();
		ChartText caption = new ChartText(pTransform1,plotFont, captionstring,
					xpos, ypos, ChartConstants.PHYS_POS);
		caption.setXJust(ChartConstants.JUSTIFY_CENTER);
		caption.setYJust(ChartConstants.JUSTIFY_MAX);
		chartVu.addChartObject(caption);

	}

	public void InitializeChart()
	{
		ChartView chartVu  = this;

		// Create simple datasets
		SimpleDataset Male1960Dataset = new SimpleDataset("Male1960", Male1960, AgeBins);
		SimpleDataset Female1960Dataset = new SimpleDataset("Female1960", Female1960, AgeBins);
		SimpleDataset Male2002Dataset = new SimpleDataset("Male2002", Male2002, AgeBins);
		SimpleDataset Female2002Dataset = new SimpleDataset("Female2002", Female2002, AgeBins);

		// Upper left
		CreatePlot(0.2, 0.2, 0.5, 0.5, Male1960Dataset, true, ChartColor.RED);
		// Upper right
		CreatePlot(0.5, 0.2, 0.8, 0.5, Female1960Dataset, false, ChartColor.BLUE);
		// Lower left
		CreatePlot(0.2, 0.6, 0.5, 0.9, Male2002Dataset, true, ChartColor.RED);
		// Lower right
		CreatePlot(0.5, 0.6, 0.8, 0.9, Female2002Dataset, false, ChartColor.BLUE);

		// Create a default transform to position titles
		CartesianCoordinates pTransform1 = new CartesianCoordinates();
		// Position window
		pTransform1.setGraphBorderDiagonal(0.1, 0.15, 0.9, 0.9) ;

		// Create overall graph background
		Background background1 = new Background( pTransform1, 
			ChartConstants.GRAPH_BACKGROUND,	ChartColor.AQUA);
		chartVu.addChartObject(background1);

		// Caption font
		ChartFont captionFont = new ChartFont("SansSerif",  ChartFont.BOLD, 14);
		// Create caption for upper plots designating popluation data is for 1960
		String string1960 = "1960";
		double xpos = 0.025; // Graph normalized position
		double ypos =  0.15; // Graph normalized position
		ChartText caption1960 = new ChartText(pTransform1,captionFont,string1960,
							xpos, ypos, ChartConstants.NORM_GRAPH_POS);
		caption1960.setXJust(ChartConstants.JUSTIFY_MIN);
		caption1960.setYJust(ChartConstants.JUSTIFY_MAX);
		chartVu.addChartObject(caption1960);
		
		// Create caption for lower plots designating popluation data is for 2002
		String string2002 = "2002";
		xpos = 0.025; // Graph normalized position
		ypos =  0.55; // Graph normalized position
		ChartText caption2002 = new ChartText(pTransform1,captionFont,string2002,
							xpos, ypos, ChartConstants.NORM_GRAPH_POS);
		caption2002.setXJust(ChartConstants.JUSTIFY_MIN);
		caption2002.setYJust(ChartConstants.JUSTIFY_MAX);
		chartVu.addChartObject(caption2002);

		// Title above plot area
		ChartFont subtitleFont = new ChartFont("SansSerif",  ChartFont.PLAIN, 14);
		ChartTitle subtitle = new ChartTitle(pTransform1, subtitleFont, 
			"Population by age group in millions");
		subtitle.setTitleType(ChartConstants.CHART_SUBHEAD);
		subtitle.setTitlePosition( ChartConstants.CENTER_GRAPH);
		subtitle.setColor(ChartColor.BLACK);
		chartVu.addChartObject(subtitle);


		// Main title for entire window
		ChartFont mainTitleFont = new ChartFont("SansSerif",  ChartFont.BOLD, 24);
		ChartTitle mainTitle = new ChartTitle(pTransform1, mainTitleFont, "Japan's Aging Workforce");
		mainTitle.setTitleType(ChartConstants.CHART_HEADER);
		mainTitle.setTitlePosition( ChartConstants.CENTER_GRAPH);
		chartVu.addChartObject(mainTitle);

		// Footer
		ChartFont footerFont = new ChartFont("SansSerif", ChartFont.PLAIN, 12);
		ChartTitle footer = new ChartTitle(pTransform1, footerFont, 
			"Graph format courtesy of 'The Economist' published January 10, 2004,");
		footer.addNewLineTextString("page 38, 'A shrinking giant'. Chart data is approximate.");
		footer.setTitleType(ChartConstants.CHART_FOOTER);
		footer.setTitlePosition( ChartConstants.CENTER_GRAPH);
		chartVu.addChartObject(footer);

	}
	
}
