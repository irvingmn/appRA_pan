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
import java.util.*;

/**
 * @author Quinn-Curtis Staff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BostonClimate extends ChartView {
	static final long serialVersionUID = -854726419986726137L;
	// Datasets used to organize and store data for charts
	TimeGroupDataset RecordHighAndLow = null;
	TimeGroupDataset NormalHighAndLow = null;
	TimeGroupDataset TodaysHighAndLow = null;
	TimeSimpleDataset RainfallData = null;

	public BostonClimate(Context context)
	{
	      super(context);
	      setFocusable(true);
		  InitializeChart();

	}

	// Create simulated climate data for Boston
	void InitializeData()
	{   int daysInMonth = 30;
		int i;
		GregorianCalendar [] xTemperatureData = new GregorianCalendar[daysInMonth];
		// A floating bar plot using y-data in 2-dimensions
		double [][] recordHLData = new double [2][daysInMonth];
		double [][] normalHLData = new double [2][daysInMonth];
		double [][] todaysHLData = new double [2][daysInMonth];
		// Start on November 1, 2003. Starting at 12:00 PM will make centering bars easier.
		GregorianCalendar startdate = new GregorianCalendar(2003, ChartConstants.NOVEMBER, 1,12,0,0);

		// Create simulated temperature data for November
		for (i=0; i < daysInMonth; i++)
		{
			// Create a new GregorianCalendar object for each data
			xTemperatureData[i] = (GregorianCalendar) startdate.clone(); 
			// Increment day counter one day
			startdate.add(ChartConstants.DAY_OF_MONTH,1); 
			recordHLData[0][i] = 78 - (double)i * 0.3 + 3.0 * (0.5-ChartSupport.getRandomDouble());
			recordHLData[1][i] = 33 - (double)i + 5.0 * (0.5-ChartSupport.getRandomDouble());

			normalHLData[0][i] = 58 - (double)i * 0.4 + 3.0 * (0.5-ChartSupport.getRandomDouble());
			normalHLData[1][i] = 42 - (double)i * 0.3 + 2.0 * (0.5-ChartSupport.getRandomDouble());
			// todays high value
			todaysHLData[0][i] = 60 - (double)i * 0.4 + 8.0 * (0.5-ChartSupport.getRandomDouble()); 
			// todays low value
			todaysHLData[1][i] = todaysHLData[0][i] - 8.0 - 12.0 * ChartSupport.getRandomDouble();

		}
		// Create temperature datasets based on simulated data
		RecordHighAndLow = new TimeGroupDataset("RecordHighAndLow",xTemperatureData,recordHLData);
		NormalHighAndLow = new TimeGroupDataset("NormalHighAndLow",xTemperatureData,normalHLData);
		TodaysHighAndLow = new TimeGroupDataset("TodaysHighAndLow",xTemperatureData,todaysHLData);	

		
		// Precipitation data for days that had rain. 
		// The days in November that had rain
		int [] rainfallDays = {1,2,3,4,5,11,13,17,20,21,25,28,29,30};
		// The rainfall for each of of the days above
		double [] rainfallData = {0.01,0.03,0.30,0.01,0.69,0.14,0.17,0.03,
										0.49,0.07,0.15,0.43,0.12,0.01};
		// A GregorianCalendar array is used to convert rainfall days into GregorianCalendar objects
		GregorianCalendar [] xRainfallCalendarDays = new GregorianCalendar[rainfallDays.length];
		for (i=0; i < rainfallDays.length; i++)
		{
			xRainfallCalendarDays[i] = 
					new GregorianCalendar(2003, ChartConstants.NOVEMBER, rainfallDays[i],12,0,0);
		}
		// Create rainfall dataset based on simulated data
        RainfallData = new TimeSimpleDataset("RainfallData",xRainfallCalendarDays,rainfallData);
	}


	// Initialize the Chart
	public void InitializeChart()
	{
		ChartView chartVu  = this;


		// Create simulated November climatic data, store in datasets
		InitializeData();

		ChartFont defaultFont = new ChartFont("SansSerif", ChartFont.PLAIN, 14);

//Create Temperature Chart
		// Create a time scale
		TimeCoordinates pTransform1 = 
			new TimeCoordinates(ChartConstants.TIME_SCALE, ChartConstants.LINEAR_SCALE );

		// Create an array of the temperature datasets to pass to transform auto-scale method
		TimeGroupDataset [] datasetarray = {RecordHighAndLow,NormalHighAndLow,TodaysHighAndLow};	

		// Auto-scale time scale based on the the three datasets in the dataset array
		pTransform1.autoScale(datasetarray,ChartConstants.AUTOAXES_NEAR, ChartConstants.AUTOAXES_FAR);

		// Position in top half of window
		pTransform1.setGraphBorderDiagonal(0.16, .1, .95, 0.60) ;

		// Gradient white to gray background for overall chart
		Background graphbackground1 = new Background( pTransform1, 
			ChartConstants.GRAPH_BACKGROUND, ChartColor.WHITE, ChartColor.LIGHTGRAY,  ChartConstants.VERT_DIR);
		chartVu.addChartObject(graphbackground1);

		// Simple white background for plot area
		Background graphbackground2 = new Background( pTransform1, 
			ChartConstants.PLOT_BACKGROUND, ChartColor.WHITE);
		chartVu.addChartObject(graphbackground2);

		// Create a time axis for the x-axis
		TimeAxis xAxis1 = new TimeAxis(pTransform1);
		chartVu.addChartObject(xAxis1);

		// Create a simple linear axis and place it on the right side of graph
		LinearAxis yAxis1 = new LinearAxis(pTransform1, ChartConstants.Y_AXIS);
		chartVu.addChartObject(yAxis1);

		// Create time axis labels for the x-axis
		TimeAxisLabels xAxisLab1 = new TimeAxisLabels(xAxis1);
		chartVu.addChartObject(xAxisLab1);

		// Create simple numeric labels for right y-axis
		NumericAxisLabels yAxisLab1 = new NumericAxisLabels(yAxis1);
		chartVu.addChartObject(yAxisLab1);

		// Create simple title right y-axis
		AxisTitle yAxisTitle1 = new AxisTitle(yAxis1, defaultFont,"Deg. Fahrenheit");
		chartVu.addChartObject(yAxisTitle1);
		
		// Create grid lines for x-axis
		Grid xgrid1 = new Grid(xAxis1, yAxis1,ChartConstants.X_AXIS, ChartConstants.GRID_MAJOR);
		chartVu.addChartObject(xgrid1);

		// Create grid lines for y-axis
		Grid ygrid1 = new Grid(xAxis1, yAxis1,ChartConstants.Y_AXIS, ChartConstants.GRID_MAJOR);
		// Make sure top grid line is not clipped out
		ygrid1.setChartObjClipping(ChartConstants.GRAPH_AREA_CLIPPING);
		chartVu.addChartObject(ygrid1);

		// Define transparent colors for floating bars
		ChartColor transparentRed = new ChartColor(255,0,0,128);
		ChartColor transparentGreen = new ChartColor(0,255,0, 128);
		ChartColor transparentBlue = new ChartColor(0,0,255, 128);

		// Define attributes of Record High-Low floating bar plot
		ChartAttribute RecordHLAttrib =	
			new ChartAttribute(transparentRed, 1,ChartConstants.LS_SOLID, transparentRed);
		// Create floating bar plot
		FloatingBarPlot thePlot1 = new FloatingBarPlot(pTransform1, RecordHighAndLow, 
					ChartCalendar.getCalendarWidthValue(ChartConstants.DAY_OF_MONTH,0.75), 
			        RecordHLAttrib, ChartConstants.JUSTIFY_CENTER);
		chartVu.addChartObject(thePlot1);

		// Define attributes of Normal High-Low floating bar plot
		ChartAttribute NormalHLAttrib =	
			new ChartAttribute(transparentGreen, 1,ChartConstants.LS_SOLID, transparentGreen);
		// Create floating bar plot
		FloatingBarPlot thePlot2 = new FloatingBarPlot(pTransform1, NormalHighAndLow, 
			ChartCalendar.getCalendarWidthValue(ChartConstants.DAY_OF_MONTH,0.75), 
			NormalHLAttrib, ChartConstants.JUSTIFY_CENTER);
		chartVu.addChartObject(thePlot2);	

		// Define attributes of Todsyas High-Low floating bar plot
		ChartAttribute TodaysHLAttrib =	
			new ChartAttribute(transparentBlue, 2,ChartConstants.LS_SOLID, transparentBlue);
		// Create floating bar plot
		FloatingBarPlot thePlot3 = new FloatingBarPlot(pTransform1, TodaysHighAndLow, 
			ChartCalendar.getCalendarWidthValue(ChartConstants.DAY_OF_MONTH,0.33), 
			TodaysHLAttrib, ChartConstants.JUSTIFY_CENTER);
		chartVu.addChartObject(thePlot3);	

		// Create a legend 
		ChartFont legendFont = new ChartFont("SansSerif", ChartFont.BOLD, 10);
		ChartAttribute legendAttributes = 
			new ChartAttribute(ChartColor.BLACK, 1,ChartConstants.LS_SOLID, ChartColor.WHITE);
		// Don't draw legend box
		legendAttributes.setLineFlag(false);
		// Don't fill legend box
		legendAttributes.setFillFlag(false);
		StandardLegend legend1 = new StandardLegend(0.16, 0.53, 0.7, 0.1, legendAttributes,  
			StandardLegend.HORIZ_DIR);
		// Add one legend item for each of the floating bar plots in the chart
		legend1.addLegendItem("Record High-Low", ChartConstants.VBAR, RecordHLAttrib, legendFont);
		legend1.addLegendItem("Normal High-Low", ChartConstants.VBAR, NormalHLAttrib, legendFont);
		legend1.addLegendItem("Todays High-Low", ChartConstants.VBAR, TodaysHLAttrib, legendFont);
		chartVu.addChartObject(legend1);

//Create Rainfall Chart
		// Create a time scale
		TimeCoordinates pTransform2 = 
			new TimeCoordinates(ChartConstants.TIME_SCALE, ChartConstants.LINEAR_SCALE );
		
		// Auto-scale time scale based on the values in the RainfallData dataset
		pTransform2.autoScale(RainfallData,ChartConstants.AUTOAXES_NEAR, ChartConstants.AUTOAXES_FAR);

		// Position in bottom half of window
		pTransform2.setGraphBorderDiagonal(0.16, .675, .95, 0.925) ;

		// Simple white background for plot area
		Background graphbackground3 = new Background( pTransform2, 
			ChartConstants.PLOT_BACKGROUND, ChartColor.WHITE);
		chartVu.addChartObject(graphbackground3);

		// Create a time axis for the x-axis
		TimeAxis xAxis2 = new TimeAxis(pTransform2);
		chartVu.addChartObject(xAxis2);

		// Create a simple linear axis and place it on the right side of graph
		LinearAxis yAxis2 = new LinearAxis(pTransform2, ChartConstants.Y_AXIS);
		chartVu.addChartObject(yAxis2);

		// Create time axis labels for the x-axis
		TimeAxisLabels xAxisLab2 = new TimeAxisLabels(xAxis2);
		chartVu.addChartObject(xAxisLab2);

		// Create simple numeric labels for right y-axis
		NumericAxisLabels yAxisLab2 = new NumericAxisLabels(yAxis2);
		chartVu.addChartObject(yAxisLab2);

		// Create simple title for y-axis
		AxisTitle yAxisTitle2 = new AxisTitle(yAxis2, defaultFont,"Inches");
		chartVu.addChartObject(yAxisTitle2);
		
		// Create grid lines for x-axis
		Grid xgrid2 = new Grid(xAxis2, yAxis2,ChartConstants.X_AXIS, ChartConstants.GRID_MAJOR);
		chartVu.addChartObject(xgrid2);

		// Create grid lines for y-axis
		Grid ygrid2 = new Grid(xAxis2, yAxis2,ChartConstants.Y_AXIS, ChartConstants.GRID_MAJOR);
		// Make sure top grid line is not clipped out
		ygrid2.setChartObjClipping(ChartConstants.GRAPH_AREA_CLIPPING);
		chartVu.addChartObject(ygrid2);

		// Define attributes of rainfall bar plot
		ChartAttribute RainfallAttrib =	
			new ChartAttribute(transparentBlue, 1,ChartConstants.LS_SOLID, transparentBlue);
		// Create  a simple bar plot for rainfall
		SimpleBarPlot thePlot4 = new SimpleBarPlot(pTransform2, RainfallData, 
			ChartCalendar.getCalendarWidthValue(ChartConstants.DAY_OF_MONTH,0.75), 0.0,
			RainfallAttrib, ChartConstants.JUSTIFY_CENTER);
		// Get data point numeric label template
		NumericLabel bardatavalue = thePlot4.getPlotLabelTemplate();
		// Set font for bar data values to a small font
		ChartFont smallFont = new ChartFont("SansSerif", ChartFont.PLAIN, 10);
		bardatavalue.setTextFont(smallFont);
		// Set numeric format to decimal, 2 digits to the right of the decimal
		bardatavalue.setNumericFormat(ChartConstants.DECIMALFORMAT);
		bardatavalue.setDecimalPos(2);
		// Set data point template
		thePlot4.setPlotLabelTemplate(bardatavalue);
		// Show data values
		thePlot4.setShowDatapointValue(true);
		chartVu.addChartObject(thePlot4);

		// These items apply to the whole graph
		// Define the main title of the chart
		ChartFont theTitleFont = new ChartFont("SansSerif",  ChartFont.BOLD, 24);
		String GraphTitle = "Boston's Recent Climate";
		ChartTitle mainTitle = new ChartTitle(pTransform1, theTitleFont, GraphTitle);
		mainTitle.setTitleType(ChartConstants.CHART_HEADER);
		mainTitle.setTitlePosition(ChartConstants.CENTER_GRAPH);
		mainTitle.setLineColor(ChartColor.BLACK);
		chartVu.addChartObject(mainTitle);

		// Define the footer of the chart
		ChartFont theFooterFont = new ChartFont("SansSerif",  ChartFont.PLAIN, 10);
		ChartTitle footer = new ChartTitle(pTransform1, theFooterFont,
		   "Chart format courtesy of the Boston Globe. Climatic data for the month of November is simulated.");
		footer.setTitleType(ChartConstants.CHART_FOOTER);
		footer.setTitlePosition(ChartConstants.CENTER_GRAPH);
		footer.setTitleOffset(2);
		footer.setLineColor(ChartColor.BLACK);
		chartVu.addChartObject(footer);

		// Define the subhead of the chart
		String GraphSubTitle = 	"Temperature and Precipitation";
		ChartTitle subTitle = new ChartTitle(pTransform1, theFooterFont, GraphSubTitle);
		subTitle.setTitleType(ChartConstants.CHART_SUBHEAD);
		subTitle.setTitlePosition(ChartConstants.CENTER_GRAPH);
		subTitle.setLineColor(ChartColor.BLACK);
		chartVu.addChartObject(subTitle);
	
	}
}
