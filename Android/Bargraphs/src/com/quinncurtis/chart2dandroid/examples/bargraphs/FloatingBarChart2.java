package com.quinncurtis.chart2dandroid.examples.bargraphs;

import java.util.*;

import android.content.Context;

import com.quinncurtis.chart2dandroid.*;

/**
 * Title:  BigChartDemo example program
 * Description:  Example program for QCChart2D for Android  charting software
 * Copyright:  Copyright (c) 2011
 * Company:  Quinn-Curtis, Inc.
 * @author:  Staff
 * @version 2.1
 */

public class FloatingBarChart2 extends ChartView {
    static final long serialVersionUID = -1022418702933193622L;
	ChartView gWG = this;
    ChartFont theFont;
    int nnumpnts = 18;
    int numgroups = 2;
    double x1[]= new double[nnumpnts];
    GregorianCalendar y1[][] = new GregorianCalendar[numgroups][nnumpnts];

  public FloatingBarChart2(Context context)
	{
      super(context);
      setFocusable(true);
	  InitializeChart();

   }

  
  void InitializeChart()
  {


      
    x1[0] = 6;
    y1[0][0] = new GregorianCalendar(2002,0,1);
    y1[1][0] = new GregorianCalendar(2003,0,1);

    x1[1] = 5;
    y1[0][1] = new GregorianCalendar(2002,0,1);
    y1[1][1] = new GregorianCalendar(2002,4,1);

    x1[2] = 5;
    y1[0][2] = new GregorianCalendar(2002,7,1);
    y1[1][2] = new GregorianCalendar(2002,10,1);

    x1[3] = 4;
    y1[0][3] = new GregorianCalendar(2002,0,1);
    y1[1][3] = new GregorianCalendar(2002,2,1);

    x1[4] = 4;
    y1[0][4] = new GregorianCalendar(2002,3,1);
    y1[1][4] = new GregorianCalendar(2002,5,1);

    x1[5] = 4;
    y1[0][5] = new GregorianCalendar(2002,6,1);
    y1[1][5] = new GregorianCalendar(2002,8,1);

    x1[6] = 4;
    y1[0][6] = new GregorianCalendar(2002,9,1);
    y1[1][6] =new GregorianCalendar(2002,11,1);

    x1[7] = 3;
    y1[0][7] = new GregorianCalendar(2002,1,15);
    y1[1][7] = new GregorianCalendar(2002,3,15);

    x1[8] = 3;
    y1[0][8] = new GregorianCalendar(2002,4,15);
    y1[1][8] = new GregorianCalendar(2002,6,15);

    x1[9] = 3;
    y1[0][9] = new GregorianCalendar(2002,7,15);
    y1[1][9] = new GregorianCalendar(2002,9,15);

    x1[10] = 3;
    y1[0][10] = new GregorianCalendar(2002,10,15);
    y1[1][10] = new GregorianCalendar(2003,0,1);

    x1[11] = 2;
    y1[0][11] = new GregorianCalendar(2002,1,1);
    y1[1][11] = new GregorianCalendar(2002,2,1);

    x1[12] = 2;
    y1[0][12] = new GregorianCalendar(2002,3,1);
    y1[1][12] = new GregorianCalendar(2002,4,1);

    x1[13] = 2;
    y1[0][13] =new GregorianCalendar(2002,5,1);
    y1[1][13] = new GregorianCalendar(2002,6,1);

    x1[14] = 2;
    y1[0][14] =new GregorianCalendar(2002,7,1);
    y1[1][14] = new GregorianCalendar(2002,8,1);

    x1[15] = 2;
    y1[0][15] = new GregorianCalendar(2002,9,1);
    y1[1][15] = new GregorianCalendar(2002,10,1);

    x1[16] = 2;
    y1[0][16] = new GregorianCalendar(2002,11,1);
    y1[1][16] = new GregorianCalendar(2003,0,1);

    x1[17] = 1;
    y1[0][17] = new GregorianCalendar(2002,6,1);
    y1[1][17] = new GregorianCalendar(2002,9,1);

    theFont = new ChartFont("SansSerif", ChartFont.BOLD,12);

    TimeGroupDataset Dataset1 = new TimeGroupDataset("Actual Sales",x1,y1);
    TimeCoordinates pTransform1 = new TimeCoordinates();
    pTransform1.autoScale(Dataset1,ChartConstants.AUTOAXES_FAR,  ChartConstants.AUTOAXES_NEAR);

    pTransform1.swapScaleOrientation();
    pTransform1.setScaleStartY(0);
    pTransform1.setGraphBorderDiagonal(0.22, .1, .95, 0.9) ;
    Background graphbackground = new Background( pTransform1, ChartConstants.GRAPH_BACKGROUND,
           new ChartColor(30,70,70), new ChartColor(90,20,155), ChartConstants.Y_AXIS);
    gWG.addChartObject(graphbackground);

    Background plotbackground = new Background( pTransform1, ChartConstants.PLOT_BACKGROUND,
           ChartColor.BLACK);
    gWG.addChartObject(plotbackground);

    TimeAxis xAxis = new TimeAxis(pTransform1);
    xAxis.setColor(ChartColor.WHITE);
    gWG.addChartObject(xAxis);

    LinearAxis yAxis = new LinearAxis(pTransform1, ChartConstants.Y_AXIS);
    yAxis.setAxisTickSpace(1);
    yAxis.setAxisMinorTicksPerMajor(1);
    yAxis.setColor(ChartColor.WHITE);
    gWG.addChartObject(yAxis);

    TimeAxisLabels xAxisLab = new TimeAxisLabels(xAxis);
    xAxisLab.setColor(ChartColor.WHITE);
    gWG.addChartObject(xAxisLab);

    String yAxisStrings[] = {"","Info Age","Comp Week","PC Mag","EDN","DSP Journ","WSJ"};
    StringAxisLabels yAxisLab = new StringAxisLabels(yAxis);
    yAxisLab.setAxisLabels(theFont, 0, ChartConstants.AXIS_MIN, ChartConstants.LABEL_ALL,
            ChartColor.WHITE, yAxisStrings, 7);
    gWG.addChartObject(yAxisLab);

    AxisTitle yaxistitle = new AxisTitle( yAxis, theFont, "Magazine");
    yaxistitle.setColor(ChartColor.WHITE);
    gWG.addChartObject(yaxistitle);

    AxisTitle xaxistitle = new AxisTitle( xAxis, theFont, "Year of 2003");
    xaxistitle.setColor(ChartColor.WHITE);
    gWG.addChartObject(xaxistitle);

    Grid ygrid = new Grid(xAxis, yAxis,ChartConstants.Y_AXIS, ChartConstants.GRID_MAJOR);
    ygrid.setColor(ChartColor.WHITE);
    ygrid.setLineWidth(1);
    gWG.addChartObject(ygrid);

    Grid xgrid = new Grid(xAxis, yAxis,ChartConstants.X_AXIS, ChartConstants.GRID_MAJOR);
    xgrid.setColor(ChartColor.WHITE);
    xgrid.setLineWidth(1);
    gWG.addChartObject(xgrid);

     
    FloatingBarPlot thePlot1 = new FloatingBarPlot(pTransform1);
    ChartAttribute attrib1 = new ChartAttribute (ChartColor.BLACK, 1,ChartConstants.LS_SOLID, ChartColor.GREEN);
    attrib1.setFillFlag(true);
    thePlot1.initFloatingBarPlot(Dataset1, 0.75, attrib1, ChartConstants.JUSTIFY_CENTER);
    thePlot1.setBarOrient(ChartConstants.HORIZ_DIR);

    thePlot1.setSegmentAttributesMode(true);
    thePlot1.setSegmentFillColor(0,ChartColor.RED);
    thePlot1.setSegmentFillColor(1, ChartColor.MAGENTA);
    thePlot1.setSegmentFillColor(2, ChartColor.MAGENTA);
    thePlot1.setSegmentFillColor(3, ChartColor.YELLOW);
    thePlot1.setSegmentFillColor(4, ChartColor.YELLOW);
    thePlot1.setSegmentFillColor(5, ChartColor.YELLOW);
    thePlot1.setSegmentFillColor(6, ChartColor.YELLOW);
    thePlot1.setSegmentFillColor(7, ChartColor.LIGHTPINK);
    thePlot1.setSegmentFillColor(8, ChartColor.LIGHTPINK);
    thePlot1.setSegmentFillColor(9, ChartColor.LIGHTPINK);
    thePlot1.setSegmentFillColor(10, ChartColor.LIGHTPINK);
    thePlot1.setSegmentFillColor(11, ChartColor.BLUE);
    thePlot1.setSegmentFillColor(12, ChartColor.BLUE);
    thePlot1.setSegmentFillColor(13, ChartColor.BLUE);
    thePlot1.setSegmentFillColor(14, ChartColor.BLUE);
    thePlot1.setSegmentFillColor(15, ChartColor.BLUE);
    thePlot1.setSegmentFillColor(16, ChartColor.BLUE);
    thePlot1.setSegmentFillColor(17, ChartColor.GREEN);
    gWG.addChartObject(thePlot1);

    ChartFont theTitleFont = new ChartFont("SansSerif", ChartFont.BOLD,24);
    ChartTitle mainTitle = new ChartTitle(pTransform1, theTitleFont, "Media Schedule");
    mainTitle.setTitleType(ChartConstants.CHART_HEADER);
    mainTitle.setTitlePosition( ChartConstants.CENTER_GRAPH);
    mainTitle.setColor(ChartColor.WHITE);
    gWG.addChartObject(mainTitle);

    ChartFont theFooterFont = new ChartFont("SansSerif", ChartFont.BOLD,14);
    ChartTitle footer = new ChartTitle(pTransform1, theFooterFont, "Floating bars are useful for creating scheduling charts.");
    footer.setTitleType(ChartConstants.CHART_FOOTER);
    footer.setTitlePosition( ChartConstants.CENTER_GRAPH);
    footer.setTitleOffset(8);
    footer.setColor(ChartColor.WHITE);
    gWG.addChartObject(footer);
    
  DataToolTip datatooltip = new DataToolTip(gWG);
  TimeLabel xValueTemplate = new TimeLabel( ChartConstants.TIMEDATEFORMAT_MDY);
  datatooltip.setXValueTemplate(xValueTemplate);
  datatooltip.setDataToolTipFormat(ChartConstants.DATA_TOOLTIP_X);
  datatooltip.getToolTipSymbol().setColor(ChartColor.GREEN);
  
  datatooltip.addDataToolTipListener();

    
  }


}