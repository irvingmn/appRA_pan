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
public class LandOfTheFry extends ChartView {
	
	
	static final long serialVersionUID = 8416077555305595549L;

	public LandOfTheFry(Context context)
	{
	      super(context);
	      setFocusable(true);
		  InitializeChart();

	   }

	  
	  void InitializeChart()
	  {
		ChartView chartVu  = this;
		int NumberOfCountries = 13;
		int NumberOfGroups = 2;
		String [] CountryNames = 
					{"","China", "Japan", "Russia", "Italy", "Sweden",
					 "Denmark", "Mexico", "Brazil", "France",
					 "Australia", "Spain", "USA", "England"};

		// Positions bar
		double []x1 = new double[NumberOfCountries];

		// Overweight data for magnitude of of stacked bars
		double [][]Men = new double[NumberOfGroups][NumberOfCountries];
		double [][]Women = new double[NumberOfGroups][NumberOfCountries];

		ChartFont theFont;

		// Initialize X-values and Men overweight data
		x1[0] = 13; Men[0][0] = 46; Men[1][0] = 22;
		x1[1] = 12; Men[0][1] = 40; Men[1][1] = 27;
		x1[2] = 11; Men[0][2] = 56; Men[1][2] = 10;
		x1[3] = 10; Men[0][3] = 45; Men[1][3] = 19;
		x1[4] = 9; Men[0][4] = 49; Men[1][4] = 12;
		x1[5] = 8; Men[0][5] = 31; Men[1][5] = 24;
		x1[6] = 7; Men[0][6] = 41; Men[1][6] = 15;
		x1[7] = 6; Men[0][7] = 40; Men[1][7] = 15;
		x1[8] = 5; Men[0][8] = 41; Men[1][8] = 10;
		x1[9] = 4; Men[0][9] = 41; Men[1][9] = 9;
		x1[10] = 3; Men[0][10] = 35; Men[1][10] = 10;
		x1[11] = 2; Men[0][11] = 24; Men[1][11] = 2;
		x1[12] = 1; Men[0][12] = 12; Men[1][12] = 3;

		// Women overwieght data
		Women[0][0] = 32; Women[1][0] = 24;
		Women[0][1] = 28; Women[1][1] = 34;
		Women[0][2] = 43; Women[1][2] = 13;
		Women[0][3] = 29; Women[1][3] = 17;
		Women[0][4] = 30; Women[1][4] = 17;
		Women[0][5] = 36; Women[1][5] = 11;
		Women[0][6] = 36; Women[1][6] = 26;
		Women[0][7] = 25; Women[1][7] = 16;
		Women[0][8] = 30; Women[1][8] = 12;
		Women[0][9] = 26; Women[1][9] = 10;
		Women[0][10] = 31; Women[1][10] = 25;
		Women[0][11] = 20; Women[1][11] = 3;
		Women[0][12] = 14; Women[1][12] = 2;

		// Default font
		theFont = new ChartFont("SansSerif",  ChartFont.PLAIN, 14);

		// Create two group datasets
		GroupDataset MenDataset = new GroupDataset("Men",x1,Men);
		GroupDataset WomenDataset = new GroupDataset("Women",x1,Women);

		// Auto-scale using MenDataset in stacked mode
		CartesianCoordinates pTransform1 = new CartesianCoordinates();
		MenDataset.setStackMode(ChartConstants.AUTOAXES_STACKED);
		WomenDataset.setStackMode( ChartConstants.AUTOAXES_STACKED);
		pTransform1.autoScale(MenDataset, ChartConstants.AUTOAXES_FAR , 
							ChartConstants.AUTOAXES_FAR);
	
		// Since stacked group bargraph will be in horizontal mode, swap
		// x and y-scale orientation
		pTransform1.swapScaleOrientation();
		// Force y-scale to stop at 14
		pTransform1.setScaleStopY ( 14);

		// Position window
		pTransform1.setGraphBorderDiagonal(0.25, .1, .925, 0.80) ;


		// Create overall background
		Background background1 = new Background( pTransform1, 
			ChartConstants.GRAPH_BACKGROUND,	ChartColor.TURQUOISE);
		chartVu.addChartObject(background1);

		// Linear x-axis
		LinearAxis xAxis1 = new LinearAxis(pTransform1, ChartConstants.X_AXIS);
		xAxis1.setColor(ChartColor.BLACK);
		chartVu.addChartObject(xAxis1);

		// Create but do not draw the linear y-axis (OBJECT_ENABLE_NODRAW)
		LinearAxis yAxis1 = new LinearAxis(pTransform1, ChartConstants.Y_AXIS);
		// Force major tick mark every unit, no minor tick marks, 
		// to match tick mark string labels
		yAxis1.setAxisTickSpace(1);
		yAxis1.setAxisMinorTicksPerMajor(1);
		yAxis1.setChartObjEnable(ChartConstants.OBJECT_ENABLE_NODRAW);
		chartVu.addChartObject(yAxis1);

		// Simple numeric x-axis labels
		NumericAxisLabels xAxisLab1 = new NumericAxisLabels(xAxis1 );
		xAxisLab1.setColor(ChartColor.BLACK);
		chartVu.addChartObject(xAxisLab1);

		// Y-axis string labels
		// Each string will label a major tick mark
		StringAxisLabels yAxisLab1 = new StringAxisLabels(yAxis1);
		yAxisLab1.setAxisLabels(theFont,0,
					ChartConstants.AXIS_MIN, ChartConstants.LABEL_ALL,
					ChartColor.BLACK,CountryNames,14);
		yAxisLab1.setColor(ChartColor.BLACK);
		chartVu.addChartObject(yAxisLab1);

		// X-Axis grid
		Grid xAxis1Grid = new Grid(xAxis1, yAxis1,ChartConstants.X_AXIS, ChartConstants.GRID_MAJOR);
		xAxis1Grid.setColor(ChartColor.GRAY);
		xAxis1Grid.setLineStyle(ChartConstants.LS_SOLID);
		chartVu.addChartObject(xAxis1Grid);

		double barwidth = 0.33;
		double barbase = 0.0;
		// Stacked bargraphs are separated using the bar justification constants
		// Stacked bar graph for Men
		ChartAttribute attrib11 = new ChartAttribute (ChartColor.BLUE, 1,
									ChartConstants.LS_SOLID, ChartColor.BLUE);
		ChartAttribute attrib12 = new ChartAttribute (ChartColor.RED, 1,
									ChartConstants.LS_SOLID, ChartColor.RED);
		ChartAttribute [] MenAttribs = {attrib11, attrib12};
		StackedBarPlot thePlot1 = new StackedBarPlot(pTransform1, MenDataset, 
					barwidth, barbase, MenAttribs, ChartConstants.JUSTIFY_MIN);
		thePlot1.setBarOrient(ChartConstants.HORIZ_DIR);
		chartVu.addChartObject(thePlot1);

		// Stacked bar graph for Women
		ChartAttribute attrib21 = new ChartAttribute (ChartColor.GREEN, 1,
									ChartConstants.LS_SOLID, ChartColor.GREEN);
		ChartAttribute attrib22 = new ChartAttribute (ChartColor.YELLOW, 1,
            						ChartConstants.LS_SOLID, ChartColor.YELLOW);
		ChartAttribute [] WomenAttribs = {attrib21, attrib22};
		StackedBarPlot thePlot2 = new StackedBarPlot(pTransform1, WomenDataset, 
					barwidth, barbase,  WomenAttribs, ChartConstants.JUSTIFY_MAX);
		thePlot2.setBarOrient(ChartConstants.HORIZ_DIR);
		chartVu.addChartObject(thePlot2);
		
		// Title above plot area
		ChartFont subtitleFont = new ChartFont("SansSerif",  ChartFont.BOLD, 14);
		ChartTitle subtitle = new ChartTitle(pTransform1, subtitleFont, 
			"Overweight and obesity rates, latest %");
		subtitle.setTitleType(ChartConstants.CHART_SUBHEAD);
		subtitle.setTitlePosition( ChartConstants.CENTER_GRAPH);
		subtitle.setColor(ChartColor.BLACK);
		chartVu.addChartObject(subtitle);

		// Legend for Graph
		ChartFont legendFont = new ChartFont("SansSerif", ChartFont.PLAIN,14);
		ChartAttribute legendAttributes1 = 
			new ChartAttribute(ChartColor.WHITE, 1,ChartConstants.LS_SOLID, ChartColor.WHITE);
		legendAttributes1.setFillFlag(false);
		legendAttributes1.setLineFlag(false);
		StandardLegend legend1 = new StandardLegend(0.05, 0.875, 0.9, 0.2, 
							legendAttributes1, 	StandardLegend.HORIZ_DIR);
		legend1.addLegendItem("Overweight Men",ChartConstants.HBAR, attrib11, legendFont);
		legend1.addLegendItem("Obese Men", ChartConstants.HBAR, attrib12, legendFont);
		legend1.addLegendItem("Overweight Women",ChartConstants.HBAR, attrib21, legendFont);
		legend1.addLegendItem("Obese Women", ChartConstants.HBAR, attrib22, legendFont);
		chartVu.addChartObject(legend1);

		// Main title for entire window
		ChartFont mainTitleFont = new ChartFont("SansSerif",  ChartFont.BOLD, 24);
		ChartTitle mainTitle = new ChartTitle(pTransform1, mainTitleFont, "Land of the fry");
		mainTitle.setTitleType(ChartConstants.CHART_HEADER);
		mainTitle.setTitlePosition( ChartConstants.CENTER_GRAPH);
		chartVu.addChartObject(mainTitle);

		// Footer
		ChartFont footerFont = new ChartFont("SansSerif",  ChartFont.PLAIN, 9);
		ChartTitle footer = new ChartTitle(pTransform1, footerFont, 
			"Graph format courtesy of 'The Economist' published Dec. 13, 2003, page 4, 'A Survey of Food'. Chart data is approximate.");
		footer.setTitleType(ChartConstants.CHART_FOOTER);
		footer.setTitlePosition( ChartConstants.CENTER_GRAPH);
		chartVu.addChartObject(footer);

	}
}
