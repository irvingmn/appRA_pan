/**
 * Title:  bargraphs example program
 * Description:  Example program for QCChart2D for Android  charting software
 * Copyright:  Copyright (c) 2011
 * Company:  Quinn-Curtis, Inc.
 * @author:  Staff
 * @version 2.1
 */
package com.quinncurtis.chart2dandroid.examples.bargraphs;

 
import java.util.*;

import android.content.Context;

import com.quinncurtis.chart2dandroid.*;

/**
 * @author Quinn-Curtis Staff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class NasaSpending extends ChartView {

	static final long serialVersionUID = 6478407941407680812L;

	public NasaSpending(Context context)
	{
	      super(context);
	      setFocusable(true);
		  InitializeChart();

	   }

	  
	  void InitializeChart()
	  {
		InitializeChart1();
		InitializeChart2();
	}

	public void InitializeChart1()
	{
		ChartView chartVu  = this;
		ChartFont theFont;
		// Initialize y-values
		int nnumpnts = 46;
		// Space spending values for bar graph
		double []SpaceSpending ={0.5,1.0,1.5,2.5,4.0,5.0,5.9,5.6,4.8,4.2,3.8,
			3.4,3.4,3.4,3.4,3.4,3.8,4.0,4.1,4.3,4.9,5.5,6.0,6.5,7.3,7.5,7.8,
			8.0,9.0,10.1,12.5,14,14.1,14.3, 14.1,13.8,14.2,14.3,14.2,14.1,
			13.8,14.2,14.5,14.8,15.3,16.0};
			// Initialize x-values
		GregorianCalendar currentdate = new GregorianCalendar(1960,ChartCalendar.JULY,31);
		GregorianCalendar []x1= new GregorianCalendar[nnumpnts];
		int i;
		// Make ChartCalendar array, a new GregorianCalendar object representing
		// a year assigned for each element
		for (i=0; i < nnumpnts; i++)
		{
			x1[i] = (GregorianCalendar) currentdate.clone();
			currentdate.add(ChartConstants.YEAR,1);
		}
		// Create a default font
		theFont = new ChartFont("SansSerif",  ChartFont.BOLD, 12);
		// Create datasets using previously defined data arrays.
		TimeSimpleDataset Dataset1 = new TimeSimpleDataset("Space Spending",x1,SpaceSpending);
		TimeCoordinates pTransform1 = new TimeCoordinates();
		// Autoscale the coordinate system
		pTransform1.autoScale(Dataset1, ChartConstants.AUTOAXES_FAR , ChartConstants.AUTOAXES_FAR);
		// Position plotting area in window
		pTransform1.setGraphBorderDiagonal(0.2, .1, .95, 0.55) ;

		// Simple white background
		Background graphbackground1 = new Background( pTransform1, 
			ChartConstants.GRAPH_BACKGROUND, ChartColor.WHITE);
		chartVu.addChartObject(graphbackground1);

		// Simple black background for plot area
		Background plotbackground = new Background( pTransform1, ChartConstants.PLOT_BACKGROUND,
			ChartColor.BLACK);
		chartVu.addChartObject(plotbackground);

		// Create x-axis as a time axis
		TimeAxis xAxis = new TimeAxis(pTransform1);
		xAxis.setLineColor(ChartColor.BLACK);
		// Place a major/minot tick marks for every 5/1 years
		xAxis.setAxisTickMarkTimeBase( ChartConstants.TIMEAXIS_5YEARYEAR);
		chartVu.addChartObject(xAxis);

		// Create y-axis as a linear axis
		LinearAxis yAxis = new LinearAxis(pTransform1, ChartConstants.Y_AXIS);
		yAxis.setLineColor(ChartColor.BLACK);
		chartVu.addChartObject(yAxis);

		// Create the x-axis labels
		TimeAxisLabels xAxisLab = new TimeAxisLabels(xAxis );
		// Use 4 digit time/date format, ie. 1960
		xAxisLab.setAxisLabelsFormat(ChartConstants.TIMEDATEFORMAT_Y2000);
		xAxisLab.setLineColor(ChartColor.BLACK);
		chartVu.addChartObject(xAxisLab);

		// Create the y-axis labels
		NumericAxisLabels yAxisLab = new NumericAxisLabels(yAxis);
		yAxisLab.setLineColor(ChartColor.BLACK);
		yAxisLab.setAxisLabelsDecimalPos( 0);
		chartVu.addChartObject(yAxisLab);

		// Create the y-axis title
		AxisTitle yAxisTitle = new AxisTitle(yAxis, theFont,"$Billions USD");
		yAxisTitle.setLineColor(ChartColor.BLACK);
		chartVu.addChartObject(yAxisTitle);

		// Create a grid for the y-axis
		Grid ygrid = new Grid(xAxis, yAxis,ChartConstants.Y_AXIS, ChartConstants.GRID_MAJOR);
		ygrid.setLineColor(ChartColor.WHITE);
		ygrid.setLineStyle(ChartConstants.LS_SOLID);
		chartVu.addChartObject(ygrid);


		// Define unique attributes for each president, used to color bars
		ChartAttribute defaultAttrib = 
				new ChartAttribute (ChartColor.YELLOW, 0,ChartConstants.LS_SOLID, ChartColor.GOLDENROD);
		// Create a simple bar plot using Dataset1. Each bar is 9 months wide.
		SimpleBarPlot thePlot1 = new SimpleBarPlot(pTransform1, Dataset1,
			ChartCalendar.getCalendarWidthValue(ChartConstants.MONTH,9), 0.0,
			defaultAttrib, ChartConstants.JUSTIFY_CENTER);
		chartVu.addChartObject(thePlot1);

		// Add a title to the graph
		ChartFont theTitleFont = new ChartFont("SansSerif", ChartFont.BOLD, 24);
		ChartTitle mainTitle = new ChartTitle(pTransform1, theTitleFont, 
			"46 Years of Space Spending");
		mainTitle.setTitleType(ChartConstants.CHART_HEADER);
		mainTitle.setTitlePosition(ChartConstants.CENTER_GRAPH);
		mainTitle.setLineColor(ChartColor.BLACK);
		chartVu.addChartObject(mainTitle);

		// Add a subhead to the graph
		ChartFont theSubheadFont = new ChartFont("SansSerif", ChartFont.BOLD, 11);
		ChartTitle subhead = new ChartTitle(pTransform1, theSubheadFont, 
			"NASA budget and major manned space flight programs");
		subhead.setTitleType(ChartConstants.CHART_SUBHEAD);
		subhead.setTitlePosition(ChartConstants.CENTER_GRAPH);
		subhead.setLineColor(ChartColor.BLACK);
		chartVu.addChartObject(subhead);

		// Add a footer to the graph.
		ChartFont theFooterFont = new ChartFont("SansSerif",  ChartFont.BOLD, 10);
		ChartTitle footer = new ChartTitle(pTransform1, theFooterFont, 
"Chart format courtesty of the Boston Globe, January 15, 2004, page A2. Chart data is approximate.");
		footer.setTitleType(ChartConstants.CHART_FOOTER);
		footer.setTitlePosition(ChartConstants.CENTER_GRAPH);
		footer.setTitleOffset(4);
		footer.setLineColor(ChartColor.BLACK);
		chartVu.addChartObject(footer);

	}

	private void InitializeChart2()
	{
		ChartView chartVu  = this;
		ChartFont theFont;
		int nnumpnts = 6;
		int numgroups = 2;
		double []x1= new double[nnumpnts]; // x-values to hold position
		// Calendar data to hold start/stop of floating bars
		GregorianCalendar [][]y1 = new GregorianCalendar[numgroups][nnumpnts];

		// Mercury
		x1[0] = 6;
		y1[0][0] = new GregorianCalendar(1960, ChartConstants.JANUARY,1);
		y1[1][0] = new GregorianCalendar(1963, ChartConstants.JANUARY,1);

		// Gemini
		x1[1] = 5;
		y1[0][1] = new GregorianCalendar(1962, ChartConstants.JANUARY,1);
		y1[1][1] = new GregorianCalendar(1967, ChartConstants.JANUARY,1);

		// Apollo
		x1[2] = 4;
		y1[0][2] = new GregorianCalendar(1963, ChartConstants.JANUARY,1);
		y1[1][2] = new GregorianCalendar(1973, ChartConstants.JANUARY,1);

		// Skylab
		x1[3] = 3;
		y1[0][3] = new GregorianCalendar(1972, ChartConstants.JANUARY,1);
		y1[1][3] = new GregorianCalendar(1974, ChartConstants.JANUARY,1);

		// Space Shuttle
		x1[4] = 2;
		y1[0][4] = new GregorianCalendar(1977, ChartConstants.JANUARY,1);
		y1[1][4] = new GregorianCalendar(2005, ChartConstants.DECEMBER,31);

		// International Space Station
		x1[5] = 1;
		y1[0][5] = new GregorianCalendar(1998, ChartConstants.JANUARY,1);
		y1[1][5] = new GregorianCalendar(2005, ChartConstants.DECEMBER,31);

		theFont = new ChartFont("SansSerif",  ChartFont.PLAIN, 10);

		// Time group dataset for floating bars
		TimeGroupDataset Dataset1 = new TimeGroupDataset("Space programs",x1,y1);
		TimeCoordinates pTransform1 = new TimeCoordinates();
		pTransform1.autoScale(Dataset1,ChartConstants.AUTOAXES_FAR,  ChartConstants.AUTOAXES_NEAR);

		// Y values (ChartCalendar values) of dataset will actually 
		// be plotted against x-coordinates
		// so need toswapScaleOrientation();
		pTransform1.swapScaleOrientation();
		pTransform1.setScaleStartY(0);
		pTransform1.setGraphBorderDiagonal(0.2, .6, .95, 0.95) ;

		Background plotbackground = new Background( pTransform1, 
					ChartConstants.PLOT_BACKGROUND, ChartColor.BLACK);
		chartVu.addChartObject(plotbackground);

		// Create time x-axis
		TimeAxis xAxis = new TimeAxis(pTransform1);
		xAxis.setLineColor(ChartColor.BLACK);
		// Place x-axis at top of plot area
		xAxis.setAxisIntercept(pTransform1.getScaleStopY());
		xAxis.setAxisTickDir(ChartConstants.AXIS_MAX);
		chartVu.addChartObject(xAxis);

		// No need for x-axis labels because already have those in first graph

		// Create linear y-axis
		LinearAxis yAxis = new LinearAxis(pTransform1, ChartConstants.Y_AXIS);
		// Major tick marks every 1 unit
		yAxis.setAxisTickSpace(1);
		// No minor tick marks
		yAxis.setAxisMinorTicksPerMajor(1);
		yAxis.setLineColor(ChartColor.BLACK);
		yAxis.setAxisMajorTickLength( 2);
		chartVu.addChartObject(yAxis);

		// Create y-axis tick mark strings. First element is "" as
		// place holder for the 0.0 label that is not needed.
		String []yAxisStrings = {"","Sp. Station","Sp. Shuttle","Skylab",
				"Apollo","Gemini","Mercury"};
		StringAxisLabels yAxisLab = new StringAxisLabels(yAxis);
		yAxisLab.setAxisLabels(theFont, 0, ChartConstants.AXIS_MIN, ChartConstants.LABEL_ALL,
			ChartColor.WHITE, yAxisStrings, 7);
		yAxisLab.setLineColor(ChartColor.BLACK);
		// Labels too close together, force the draw of all labels regardless of overlap
		yAxisLab.setOverlapLabelMode(ChartConstants.OVERLAP_LABEL_DRAW);
		chartVu.addChartObject(yAxisLab);

		// Create x-axis grid
		Grid xgrid = new Grid(xAxis, yAxis,ChartConstants.X_AXIS, ChartConstants.GRID_ALL);
		xgrid.setLineColor(ChartColor.WHITE);
		xgrid.setLineWidth(1);
		chartVu.addChartObject(xgrid);

		// Create y=axis grid
		Grid ygrid = new Grid(xAxis, yAxis,ChartConstants.Y_AXIS, ChartConstants.GRID_ALL);
		ygrid.setLineColor(ChartColor.WHITE);
		ygrid.setLineWidth(1);
		chartVu.addChartObject(ygrid);

		// Create floating bar plot
		FloatingBarPlot thePlot1 = new FloatingBarPlot(pTransform1);
		ChartAttribute attrib1 = new ChartAttribute (ChartColor.BLACK, 1,ChartConstants.LS_SOLID, ChartColor.GREEN);
		attrib1.setFillFlag(true);
		thePlot1.initFloatingBarPlot(Dataset1, 0.75, attrib1, ChartConstants.JUSTIFY_CENTER);
		// Use horizontal floating bars, this plots the y-values of group dataset 
		// with respect to the x-scale.
		thePlot1.setBarOrient(ChartConstants.HORIZ_DIR);


		// Define unique fill and outline color of each floating bar
		thePlot1.setSegmentAttributesMode(true);
		thePlot1.setSegmentFillColor(0,ChartColor.RED);
		thePlot1.setSegmentFillColor(1, ChartColor.MAGENTA);
		thePlot1.setSegmentFillColor(2, ChartColor.YELLOW);
		thePlot1.setSegmentFillColor(3, ChartColor.LIGHTPINK);
		thePlot1.setSegmentFillColor(4, ChartColor.BLUE);
		thePlot1.setSegmentFillColor(5, ChartColor.GREEN);

		thePlot1.setSegmentLineColor(0,ChartColor.RED);
		thePlot1.setSegmentLineColor(1, ChartColor.MAGENTA);
		thePlot1.setSegmentLineColor(2, ChartColor.YELLOW);
		thePlot1.setSegmentLineColor(3, ChartColor.LIGHTPINK);
		thePlot1.setSegmentLineColor(4, ChartColor.BLUE);
		thePlot1.setSegmentLineColor(5, ChartColor.GREEN);			
		
		chartVu.addChartObject(thePlot1);


	}
}
