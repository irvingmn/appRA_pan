package com.quinncurtis.chart2dandroid.examples.bargraphs;

import java.util.*;

import android.content.Context;

import com.quinncurtis.chart2dandroid.*;

/**
 * Title:  bargraphs example program
 * Description:  Example program for QCChart2D for Android  charting software
 * Copyright:  Copyright (c) 2011
 * Company:  Quinn-Curtis, Inc.
 * @author:  Staff
 * @version 2.1
 */

public class GroupBarChart extends ChartView {
  static final long serialVersionUID = -4421460061911714918L;
  ChartView gWG = this;
  private ChartFont theFont;

  public GroupBarChart(Context context)
	{
      super(context);
      setFocusable(true);
	  InitializeChart();

   }

  
  void InitializeChart()
  {

    int nNumPnts = 5, nNumGroups = 4;
    GregorianCalendar xValues[]=  new GregorianCalendar[nNumPnts];
    double groupBarData[][] = new double[nNumGroups][nNumPnts];

    theFont = new ChartFont("SansSerif", ChartFont.BOLD,12);
    xValues[0] = new GregorianCalendar(1998, 0, 1);
    groupBarData[0][0] = 6.3;  groupBarData[1][0] = 3.1;
    groupBarData[2][0] = 2.2;  groupBarData[3][0] = 1.8;

    xValues[1] = new GregorianCalendar(1999, 0, 1);
    groupBarData[0][1] = 5.8;  groupBarData[1][1] = 4.3;
    groupBarData[2][1] = 2.8;  groupBarData[3][1] = 1.5;

    xValues[2] = new GregorianCalendar(2000, 0, 1);
    groupBarData[0][2] = 5.5;  groupBarData[1][2] = 4.5;
    groupBarData[2][2] = 2.5;  groupBarData[3][2] = 2.1;

    xValues[3] = new GregorianCalendar(2001, 0, 1);
    groupBarData[0][3] = 4.1;  groupBarData[1][3] = 5.4;
    groupBarData[2][3] = 4.1;  groupBarData[3][3] = 3.2;

    xValues[4] = new GregorianCalendar(2002, 0, 1);
    groupBarData[0][4] = 3.8;  groupBarData[1][4] = 5.6;
    groupBarData[2][4] = 4.3;  groupBarData[3][4] = 3.3;

    TimeGroupDataset Dataset1 = new TimeGroupDataset("GroupTimeData",xValues,groupBarData);

// Group Bargraph
    TimeCoordinates pTransform1 = new TimeCoordinates();
    pTransform1.autoScale(Dataset1,ChartConstants.AUTOAXES_NEAR,  ChartConstants.AUTOAXES_NEAR);

    pTransform1.setTimeScaleStart(new GregorianCalendar(1997,0,1));
    pTransform1.setTimeScaleStop(new GregorianCalendar(2003,0,1));

    pTransform1.setGraphBorderDiagonal(0.1, .1, .45, 0.8) ;

    Background background1 = new Background( pTransform1, ChartConstants.GRAPH_BACKGROUND,
           new ChartColor(0,120,70), new ChartColor(0,40,30), ChartConstants.Y_AXIS);
    gWG.addChartObject(background1);

    pTransform1.setScaleStartY(0);
    TimeAxis xAxis1 = new TimeAxis(pTransform1);
    xAxis1.setColor(ChartColor.WHITE);
    gWG.addChartObject(xAxis1);

    LinearAxis yAxis1 = new LinearAxis(pTransform1, ChartConstants.Y_AXIS);
    yAxis1.setColor(ChartColor.WHITE);
    gWG.addChartObject(yAxis1);

    TimeAxisLabels xAxisLab1 = new TimeAxisLabels(xAxis1);
    xAxisLab1.setAxisLabelsFormat(ChartConstants.TIMEDATEFORMAT_Y2000);
    xAxisLab1.setColor(ChartColor.WHITE);
    gWG.addChartObject(xAxisLab1);

    NumericAxisLabels yAxisLab1 = new NumericAxisLabels(yAxis1);
    yAxisLab1.setAxisLabelsFormat(ChartConstants.CURRENCYFORMAT);
    yAxisLab1.setColor(ChartColor.WHITE);
    gWG.addChartObject(yAxisLab1);

    Grid xgrid1 = new Grid(xAxis1, yAxis1,ChartConstants.X_AXIS, ChartConstants.GRID_MAJOR);
    xgrid1.setColor(ChartColor.WHITE);
    gWG.addChartObject(xgrid1);

    Grid ygrid1 = new Grid(xAxis1, yAxis1,ChartConstants.Y_AXIS, ChartConstants.GRID_MAJOR);
    ygrid1.setColor(ChartColor.WHITE);
    gWG.addChartObject(ygrid1);


    ChartAttribute attrib1 = new ChartAttribute(ChartColor.RED, 1,ChartConstants.LS_SOLID, ChartColor.RED);
    ChartAttribute attrib2 = new ChartAttribute(ChartColor.YELLOW, 1,ChartConstants.LS_SOLID, ChartColor.YELLOW);
    ChartAttribute attrib3 = new ChartAttribute(ChartColor.BLUE, 1,ChartConstants.LS_SOLID, ChartColor.BLUE);
    ChartAttribute attrib4 = new ChartAttribute(ChartColor.GREEN, 1,ChartConstants.LS_SOLID, ChartColor.GREEN);
    ChartAttribute attribArray[] = {attrib1, attrib2, attrib3, attrib4};
    GroupBarPlot thePlot1 = new GroupBarPlot(pTransform1, Dataset1, ChartCalendar.getCalendarWidthValue(Calendar.YEAR,0.75), 0.0, attribArray, ChartConstants.JUSTIFY_CENTER);
    thePlot1.setBarOverlap(0.0);
    gWG.addChartObject(thePlot1);

    AxisTitle yaxistitle1 = new AxisTitle( yAxis1, theFont, "Billions $");
    yaxistitle1.setColor(ChartColor.WHITE);
    gWG.addChartObject(yaxistitle1);

    ChartFont theTitleFont = new ChartFont("SansSerif", ChartFont.BOLD,24);
    ChartTitle mainTitle = new ChartTitle(pTransform1, theTitleFont, "Drug Sales");
    mainTitle.setTitleType(ChartConstants.CHART_HEADER);
    mainTitle.setTitlePosition( ChartConstants.CENTER_GRAPH);
    mainTitle.setColor(ChartColor.WHITE);
    gWG.addChartObject(mainTitle);

 // Stacked Bar Graph

    TimeCoordinates pTransform2 = new TimeCoordinates();
   // User same dataset as Group bar plot, set stacked mode flag
    Dataset1.setStackMode(ChartConstants.AUTOAXES_STACKED);
    pTransform2.autoScale(Dataset1,ChartConstants.AUTOAXES_NEAR,  ChartConstants.AUTOAXES_NEAR);

    pTransform2.setTimeScaleStart(new GregorianCalendar(1997,0,1));
    pTransform2.setTimeScaleStop(new GregorianCalendar(2003,0,1));

    pTransform2.setGraphBorderDiagonal(0.55, .1, .95, 0.8) ;

    pTransform2.setScaleStartY(0);
    TimeAxis xAxis2 = new TimeAxis(pTransform2);
    xAxis2.setColor(ChartColor.WHITE);
    gWG.addChartObject(xAxis2);

    LinearAxis yAxis2 = new LinearAxis(pTransform2, ChartConstants.Y_AXIS);
    yAxis2.setColor(ChartColor.WHITE);
    gWG.addChartObject(yAxis2);

    TimeAxisLabels xAxisLab2 = new TimeAxisLabels(xAxis2);
    xAxisLab2.setAxisLabelsFormat(ChartConstants.TIMEDATEFORMAT_Y2000);
    xAxisLab2.setColor(ChartColor.WHITE);
    gWG.addChartObject(xAxisLab2);

    NumericAxisLabels yAxisLab2 = new NumericAxisLabels(yAxis2);
    yAxisLab2.setAxisLabelsFormat(ChartConstants.CURRENCYFORMAT);
    yAxisLab2.setColor(ChartColor.WHITE);
    gWG.addChartObject(yAxisLab2);

    Grid xgrid2 = new Grid(xAxis2, yAxis2,ChartConstants.X_AXIS, ChartConstants.GRID_MAJOR);
    xgrid2.setColor(ChartColor.WHITE);
    gWG.addChartObject(xgrid2);

    Grid ygrid2 = new Grid(xAxis2, yAxis2,ChartConstants.Y_AXIS, ChartConstants.GRID_MAJOR);
    ygrid2.setColor(ChartColor.WHITE);
    gWG.addChartObject(ygrid2);

    StackedBarPlot thePlot2 = new StackedBarPlot(pTransform2, Dataset1, ChartCalendar.getCalendarWidthValue(Calendar.YEAR,0.75), 0.0, attribArray, ChartConstants.JUSTIFY_CENTER);
    NumericLabel bardatavalue = thePlot2.getPlotLabelTemplate();
    bardatavalue.setTextFont(theFont);
    bardatavalue.setNumericFormat(ChartConstants.CURRENCYFORMAT);
    bardatavalue.setDecimalPos(1);
    bardatavalue.setColor(ChartColor.BLACK);
    thePlot2.setPlotLabelTemplate(bardatavalue);
    thePlot2.setBarDatapointLabelPosition(ChartConstants.CENTERED_BAR);
    thePlot2.setShowDatapointValue(true);
    gWG.addChartObject(thePlot2);

    AxisTitle yaxistitle2 = new AxisTitle( yAxis1, theFont, "Billions $");
    yaxistitle2.setColor(ChartColor.WHITE);
    gWG.addChartObject(yaxistitle2);

    ChartFont legendFont = new ChartFont("SansSerif", ChartFont.BOLD,14);
    ChartAttribute legendAttributes = new ChartAttribute(ChartColor.BLACK, 1, ChartConstants.LS_SOLID, ChartColor.WHITE);
    legendAttributes.setLineFlag(true);
    StandardLegend legend = new StandardLegend(0.05, 0.88, 0.9, 0.2, legendAttributes, StandardLegend.HORIZ_DIR);
    legend.addLegendItem("Prozac",ChartConstants.HBAR, attrib1, legendFont);
    legend.addLegendItem("Zoloft", ChartConstants.HBAR, attrib2, legendFont);
    legend.addLegendItem("Paxil", ChartConstants.HBAR, attrib3, legendFont);
    legend.addLegendItem("Celexa", ChartConstants.HBAR, attrib4, legendFont);

    gWG.addChartObject(legend);
    ChartFont theFooterFont = new ChartFont("SansSerif", ChartFont.BOLD,12);
    ChartTitle footer = new ChartTitle(pTransform1, theFooterFont,
     "The Group bar graph and the Stacked bar graph represent" + "\n" + "two different ways of displaying the same data.");
    footer.setTitleType(ChartConstants.CHART_FOOTER);
    footer.setTitlePosition( ChartConstants.CENTER_GRAPH);
    footer.setTitleOffset(8);
    footer.setColor(ChartColor.WHITE);
    gWG.addChartObject(footer);
    
    // Uses mostly defaults for data tooltip
  DataToolTip datatooltip = new DataToolTip(gWG);
 // Don't highlight the data value because the data value is not stacked
  datatooltip.getToolTipSymbol().setSymbolNumber(ChartConstants.NOSYMBOL);
  datatooltip.addDataToolTipListener();    

  
  
  }


}