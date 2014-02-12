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

public class Histogram extends ChartView {
  static final long serialVersionUID = -3263580956502497228L;
ChartView gWG = this;

  public Histogram(Context context)
	{
      super(context);
      setFocusable(true);
	  InitializeChart();

   }

  
  void InitializeChart()
  {
  ChartFont theFont;
  int nnumpnts = 6;
  int numgroups = 2;
  double x1[]= new double[nnumpnts];
  double y1[][] = new double[numgroups][nnumpnts];

//            height           width
  x1[0] = 0;  y1[0][0] = .12; y1[1][0] = 13;
  x1[1] = 13; y1[0][1] = .97; y1[1][1] = 7;
  x1[2] = 20; y1[0][2] = .80; y1[1][2] = 10;
  x1[3] = 30; y1[0][3] = .44; y1[1][3] = 10;
  x1[4] = 40; y1[0][4] = .28; y1[1][4] = 20;
  x1[5] = 60; y1[0][5] = .4; y1[1][5] = 20;

    theFont = new ChartFont("SansSerif", ChartFont.BOLD,14);

    GroupDataset Dataset1 = new GroupDataset("Actual Sales",x1,y1);
    CartesianCoordinates pTransform1 = new CartesianCoordinates();

    pTransform1.setScaleStartY(0);
    pTransform1.setScaleStartX(0);
    pTransform1.setScaleStopX(80);
    pTransform1.setScaleStopY(1.00);

    pTransform1.setGraphBorderDiagonal(0.15, .1, .925, 0.9) ;
    Background graphbackground = new Background( pTransform1, ChartConstants.GRAPH_BACKGROUND,
           new ChartColor(30,70,70), new ChartColor(90,20,155), ChartConstants.Y_AXIS);
    gWG.addChartObject(graphbackground);

    Background plotbackground = new Background( pTransform1, ChartConstants.PLOT_BACKGROUND,
           ChartColor.BLACK);
    gWG.addChartObject(plotbackground);

    LinearAxis xAxis = new LinearAxis(pTransform1, ChartConstants.X_AXIS);
    xAxis.setColor(ChartColor.WHITE);
    gWG.addChartObject(xAxis);

    LinearAxis yAxis = new LinearAxis(pTransform1, ChartConstants.Y_AXIS);
    yAxis.setColor(ChartColor.WHITE);
    gWG.addChartObject(yAxis);

    NumericAxisLabels xAxisLab = new NumericAxisLabels(xAxis );
    xAxisLab.setColor(ChartColor.WHITE);
    gWG.addChartObject(xAxisLab);

    NumericAxisLabels yAxisLab = new NumericAxisLabels(yAxis);
    yAxisLab.setColor(ChartColor.WHITE);
    yAxisLab.setAxisLabelsFormat(ChartConstants.PERCENTFORMAT);
    yAxisLab.setAxisLabelsDecimalPos(0);
    gWG.addChartObject(yAxisLab);

    AxisTitle yaxistitle = new AxisTitle( yAxis, theFont, "Percent of Age Groups Using");
    yaxistitle.setColor(ChartColor.WHITE);
    gWG.addChartObject(yaxistitle);

    AxisTitle xaxistitle = new AxisTitle( xAxis, theFont, "Age Group");
    xaxistitle.setColor(ChartColor.WHITE);
    gWG.addChartObject(xaxistitle);

    Grid ygrid = new Grid(xAxis, yAxis,ChartConstants.Y_AXIS, ChartConstants.GRID_MAJOR);
    ygrid.setColor(ChartColor.WHITE);
    ygrid.setLineWidth(1);
    gWG.addChartObject(ygrid);


    ChartAttribute attrib1 = new ChartAttribute (ChartColor.BLACK, 0,ChartConstants.LS_SOLID, ChartColor.GREEN);
    attrib1.setFillFlag(true);
    HistogramPlot thePlot1 = new HistogramPlot(pTransform1, Dataset1, 0.0, attrib1);

    NumericLabel bardatavalue = thePlot1.getPlotLabelTemplate();
    bardatavalue.setTextFont(theFont);
    bardatavalue.setNumericFormat(ChartConstants.PERCENTFORMAT);
    bardatavalue.setColor(ChartColor.BLACK);
    thePlot1.setBarDatapointLabelPosition(ChartConstants.INSIDE_BAR);
    thePlot1.setPlotLabelTemplate(bardatavalue);
    thePlot1.setShowDatapointValue(true);

    thePlot1.setSegmentAttributesMode(true);
    thePlot1.setSegmentFillColor(0,ChartColor.RED);
    thePlot1.setSegmentFillColor(1, ChartColor.MAGENTA);
    thePlot1.setSegmentFillColor(2, ChartColor.BLUE);
    thePlot1.setSegmentFillColor(3, ChartColor.GREEN);
    thePlot1.setSegmentFillColor(4, ChartColor.YELLOW);
    thePlot1.setSegmentFillColor(5, ChartColor.LIGHTPINK);

    gWG.addChartObject(thePlot1);

    ChartFont theTitleFont = new ChartFont("SansSerif", ChartFont.BOLD,20);
    ChartTitle mainTitle = new ChartTitle(pTransform1, theTitleFont, "Video Game Usage by Age Group");
    mainTitle.setTitleType(ChartConstants.CHART_HEADER);
    mainTitle.setTitlePosition( ChartConstants.CENTER_GRAPH);
    mainTitle.setColor(ChartColor.WHITE);

    gWG.addChartObject(mainTitle);

    ChartFont theFooterFont = new ChartFont("SansSerif", ChartFont.BOLD,12);
    ChartTitle footer = new ChartTitle(pTransform1, theFooterFont, "The height and width of the bars in a Histogram plot carries information.");
    footer.setTitleType(ChartConstants.CHART_FOOTER);
    footer.setTitlePosition( ChartConstants.CENTER_GRAPH);
    footer.setTitleOffset(8);
    footer.setColor(ChartColor.WHITE);
    gWG.addChartObject(footer);
    
  DataToolTip datatooltip = new DataToolTip(gWG);
  // This works because the y value template is by default a NumericLabel
  ((NumericLabel)datatooltip.getYValueTemplate()).setDecimalPos(3);
  // Don't highlight the data value because the data value is at the start of the histogram, not centered on histogram width
 datatooltip.getToolTipSymbol().setSymbolNumber(ChartConstants.NOSYMBOL);
 datatooltip.addDataToolTipListener();    
  }


}