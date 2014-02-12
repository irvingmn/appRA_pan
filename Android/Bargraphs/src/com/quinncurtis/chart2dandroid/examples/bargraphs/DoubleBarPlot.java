package com.quinncurtis.chart2dandroid.examples.bargraphs;

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

public class DoubleBarPlot extends ChartView {
  static final long serialVersionUID = 1660321858232369319L;
ChartView gWG = this;
  int nnumpnts = 5;

  double y1[] = new double[nnumpnts];
  double x1[] = new double[nnumpnts];

// Second graph
  double y2[] = new double[nnumpnts];
  double x2[] = new double[nnumpnts];

  ChartFont theFont;

  public DoubleBarPlot(Context context)
	{
      super(context);
      setFocusable(true);
	  InitializeChart();

   }
  
  void InitializeChart()
  {

  y1[0] = 1; x1[0] = 35;
  y1[1] = 2; x1[1] = 58;
  y1[2] = 3; x1[2] = 80;
  y1[3] = 4; x1[3] = 105;
  y1[4] = 5; x1[4] = 120;

  y2[0] = 1; x2[0] = 11;
  y2[1] = 2; x2[1] = 7;
  y2[2] = 3; x2[2] = 9;
  y2[3] = 4; x2[3] = 12;
  y2[4] = 5; x2[4] = 14;

   theFont = new ChartFont("SansSerif", ChartFont.BOLD,14);


// First Graph
   SimpleDataset Dataset1 = new SimpleDataset("Actual Sales",x1,y1);
   CartesianCoordinates pTransform1 = new CartesianCoordinates();
   pTransform1.autoScale(Dataset1, ChartConstants.AUTOAXES_FAR , ChartConstants.AUTOAXES_FAR);

   pTransform1.setScaleStartX(0);
   pTransform1.setScaleStartY(0);

   pTransform1.setGraphBorderDiagonal(0.6, .1, .95, 0.9) ;
   Background background1 = new Background( pTransform1, ChartConstants.GRAPH_BACKGROUND,
           new ChartColor(5,70,40), new DoubleBarPlot(20,155,55), ChartConstants.Y_AXIS);
   gWG.addChartObject(background1);
   Background background2 = new Background( pTransform1, ChartConstants.PLOT_BACKGROUND,
           ChartColor.BLACK);
  gWG.addChartObject(background2);
  LinearAxis xAxis1 = new LinearAxis(pTransform1, ChartConstants.X_AXIS);
  xAxis1.setColor(ChartColor.WHITE);
  gWG.addChartObject(xAxis1);

  LinearAxis yAxis1 = new LinearAxis(pTransform1, ChartConstants.Y_AXIS);
  yAxis1.setColor(ChartColor.WHITE);
  yAxis1.setAxisTickSpace(1);
  yAxis1.setAxisMinorTicksPerMajor(1);
  gWG.addChartObject(yAxis1);

  NumericAxisLabels xAxisLab1 = new NumericAxisLabels(xAxis1 );
  xAxisLab1.setColor(ChartColor.WHITE);
  gWG.addChartObject(xAxisLab1);

  String yAxisStrings[] = {"","Pourier","Staff","Kafka","Johnson","Noonan"};
  StringAxisLabels yAxisLab1 = new StringAxisLabels(yAxis1);
  yAxisLab1.setAxisLabels(theFont, 0, ChartConstants.AXIS_MIN, ChartConstants.LABEL_ALL,
            ChartColor.WHITE, yAxisStrings, 6);
  gWG.addChartObject(yAxisLab1);

  Grid xgrid1 = new Grid(xAxis1, yAxis1,ChartConstants.X_AXIS, ChartConstants.GRID_MAJOR);
  xgrid1.setColor(ChartColor.WHITE);
  xgrid1.setLineWidth(1);
  gWG.addChartObject(xgrid1);

  AxisTitle xaxistitle1 = new AxisTitle( xAxis1, theFont, "$MM");
  xaxistitle1.setColor(ChartColor.WHITE);
  gWG.addChartObject(xaxistitle1);

  ChartAttribute attrib1 = new ChartAttribute (ChartColor.BLUE, 0,ChartConstants.LS_SOLID, ChartColor.BLUE);
  attrib1.setFillFlag(true);
  SimpleBarPlot thePlot1 = new SimpleBarPlot(pTransform1, Dataset1,  0.75, 0.0,
                  attrib1, ChartConstants.JUSTIFY_CENTER);
  thePlot1.setBarOrient(ChartConstants.HORIZ_DIR);
  NumericLabel bardatavalue1 = thePlot1.getPlotLabelTemplate();
  bardatavalue1.setTextFont(theFont);
  bardatavalue1.setNumericFormat(ChartConstants.CURRENCYFORMAT);
  bardatavalue1.setDecimalPos(0);
  bardatavalue1.setColor(ChartColor.WHITE);
  thePlot1.setPlotLabelTemplate(bardatavalue1);
  thePlot1.setBarDatapointLabelPosition(ChartConstants.INSIDE_BAR);
  thePlot1.setShowDatapointValue(true);
  gWG.addChartObject(thePlot1);

  ChartFont theLocalTitleFont = new ChartFont("SansSerif", ChartFont.BOLD,18);
  ChartTitle localTitle1 = new ChartTitle(pTransform1, theLocalTitleFont, "Sales");
  localTitle1.setTitleType(ChartConstants.CHART_SUBHEAD);
  localTitle1.setTitlePosition( ChartConstants.CENTER_PLOT);
  localTitle1.setColor(ChartColor.WHITE);
  gWG.addChartObject(localTitle1);

// Second Graph
   SimpleDataset Dataset2 = new SimpleDataset("Actual Sales",x2,y2);
   CartesianCoordinates pTransform2 = new CartesianCoordinates();
   pTransform2.autoScale(Dataset2, ChartConstants.AUTOAXES_FAR , ChartConstants.AUTOAXES_FAR);
   pTransform2.setScaleStartX(0);
   pTransform2.setScaleStartY(0);

   pTransform2.invertScaleX();
   
   
   pTransform2.setGraphBorderDiagonal(0.05, .1, .4, 0.9) ;
   Background background3 = new Background( pTransform2, ChartConstants.PLOT_BACKGROUND,
           ChartColor.BLACK);
  gWG.addChartObject(background3);
  LinearAxis xAxis2 = new LinearAxis(pTransform2, ChartConstants.X_AXIS);
  xAxis2.setColor(ChartColor.WHITE);
  gWG.addChartObject(xAxis2);

  LinearAxis yAxis2 = new LinearAxis(pTransform2, ChartConstants.Y_AXIS);
  yAxis2.setColor(ChartColor.WHITE);
  yAxis2.setAxisTickSpace(1);
  yAxis2.setAxisMinorTicksPerMajor(1);
  yAxis2.setAxisIntercept(0);
  yAxis2.setAxisTickDir(ChartConstants.AXIS_MAX);
  gWG.addChartObject(yAxis2);

  NumericAxisLabels xAxisLab2 = new NumericAxisLabels(xAxis2 );
  xAxisLab2.setColor(ChartColor.WHITE);
  gWG.addChartObject(xAxisLab2);

  Grid xgrid2 = new Grid(xAxis2, yAxis2,ChartConstants.X_AXIS, ChartConstants.GRID_MAJOR);
  xgrid2.setColor(ChartColor.WHITE);
  xgrid2.setLineWidth(1);
  gWG.addChartObject(xgrid2);

  AxisTitle xaxistitle2 = new AxisTitle( xAxis2, theFont, "Years");
  xaxistitle2.setColor(ChartColor.WHITE);
  gWG.addChartObject(xaxistitle2);

  ChartAttribute attrib2 = new ChartAttribute (ChartColor.BLUE, 0,ChartConstants.LS_SOLID, ChartColor.BLUE);
  attrib2.setFillFlag(true);
  SimpleBarPlot thePlot2 = new SimpleBarPlot(pTransform2, Dataset2,  0.75, 0.0,
                  attrib2, ChartConstants.JUSTIFY_CENTER);
  thePlot2.setBarOrient(ChartConstants.HORIZ_DIR);
  NumericLabel bardatavalue2 = thePlot2.getPlotLabelTemplate();
  bardatavalue2.setTextFont(theFont);
  bardatavalue2.setDecimalPos(0);
  bardatavalue2.setColor(ChartColor.WHITE);
  thePlot2.setPlotLabelTemplate(bardatavalue2);
  thePlot2.setBarDatapointLabelPosition(ChartConstants.INSIDE_BAR);
  thePlot2.setShowDatapointValue(true);

  gWG.addChartObject(thePlot2);

  ChartFont theTitleFont = new ChartFont("SansSerif", ChartFont.BOLD,24);
  ChartTitle mainTitle = new ChartTitle(pTransform1, theTitleFont, "Experience vs. Sales");
  mainTitle.setTitleType(ChartConstants.CHART_HEADER);
  mainTitle.setTitlePosition( ChartConstants.CENTER_GRAPH);
  mainTitle.setColor(ChartColor.WHITE);
  gWG.addChartObject(mainTitle);

  ChartTitle localTitle2 = new ChartTitle(pTransform2, theLocalTitleFont, "Experience");
  localTitle2.setTitleType(ChartConstants.CHART_SUBHEAD);
  localTitle2.setTitlePosition( ChartConstants.CENTER_PLOT);
  localTitle2.setColor(ChartColor.WHITE);
  gWG.addChartObject(localTitle2);

  ChartFont theFooterFont = new ChartFont("SansSerif", ChartFont.BOLD,14);
  ChartTitle footer = new ChartTitle(pTransform1, theFooterFont, "More than one graph can be displayed in a window.");
  footer.setTitleType(ChartConstants.CHART_FOOTER);
  footer.setTitlePosition( ChartConstants.CENTER_GRAPH);
  footer.setTitleOffset(8);
  footer.setColor(ChartColor.WHITE);
  gWG.addChartObject(footer);

  
  // Uses mostly defaults for data tooltip
  DataToolTip datatooltip = new DataToolTip(gWG);
  datatooltip.setDataToolTipFormat(ChartConstants.DATA_TOOLTIP_X);
  datatooltip.getToolTipSymbol().setColor(ChartColor.GREEN);
  datatooltip.addDataToolTipListener();    
  }

 
}