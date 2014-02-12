package com.quinncurtis.chart2dandroid.examples.bargraphs;

import java.util.*;

import android.content.Context;
import android.util.AttributeSet;

import com.quinncurtis.chart2dandroid.*;


/**
 * Title:  bargraphs example program
 * Description:  Example program for QCChart2D for Android  charting software
 * Copyright:  Copyright (c) 2011
 * Company:  Quinn-Curtis, Inc.
 * @author:  Staff
 * @version 2.1
 */

public class SimpleBarPlotChart extends ChartView {
  static final long serialVersionUID = -4693968497606817660L;
  ChartView gWG = this;
   TimeSimpleDataset Dataset1 = null;
   TimeCoordinates pTransform1 = null;
   
  public SimpleBarPlotChart(Context context)
	{
      super(context);
      setFocusable(true);
	  InitializeChart();

   }

		
		  public SimpleBarPlotChart(Context context, AttributeSet attrs) {
			   super(context, attrs);
			      setFocusable(true);
				  InitializeChart();
		 }
		 
		 public SimpleBarPlotChart(Context context, AttributeSet attrs, int defStyle) {
		   super(context, attrs, defStyle);
		     setFocusable(true);
		    InitializeChart();
		 }	

  
  void InitializeChart()
  {
  ChartFont theFont;
  int nnumpnts = 30;
  GregorianCalendar x1[]= new GregorianCalendar[nnumpnts];
  double y1[] = new double[nnumpnts];
  GregorianCalendar currentdate = new GregorianCalendar(1998,0,1);
  int i;
  
  y1[0] = 100;
  x1[0] = (GregorianCalendar) currentdate.clone();
  currentdate.add(Calendar.MONTH,12);
  for (i=1; i < nnumpnts; i++)
  {
     x1[i] = (GregorianCalendar) currentdate.clone();
     y1[i] += y1[i-1] +  (25 * i) * (0.55 - Math.random());
     if (y1[i] <= 0) y1[i] = 100;
     currentdate.add(Calendar.MONTH,12);
   }

   theFont = new ChartFont("SansSerif", ChartFont.BOLD,14);

   Dataset1 = new TimeSimpleDataset("Actual Sales",x1,y1);
   pTransform1 = new TimeCoordinates();
   pTransform1.autoScale(Dataset1, ChartConstants.AUTOAXES_FAR , ChartConstants.AUTOAXES_FAR);
   pTransform1.setScaleStartY(0);
   pTransform1.setTimeScaleStart(new GregorianCalendar(1997,6,1));

   pTransform1.setGraphBorderDiagonal(0.15, .1, .9, 0.9) ;
   Background background = new Background( pTransform1, ChartConstants.GRAPH_BACKGROUND,
           new ChartColor(30,70,70), new ChartColor(90,20,155), ChartConstants.Y_AXIS);
   gWG.addChartObject(background);
   TimeAxis xAxis = new TimeAxis(pTransform1);
   xAxis.setColor(ChartColor.WHITE);
   gWG.addChartObject(xAxis);

   LinearAxis yAxis = new LinearAxis(pTransform1, ChartConstants.Y_AXIS);
   yAxis.setColor(ChartColor.WHITE);
   gWG.addChartObject(yAxis);

   TimeAxisLabels xAxisLab = new TimeAxisLabels(xAxis );
   xAxisLab.setAxisLabelsFormat(ChartConstants.TIMEDATEFORMAT_Y2000);
   xAxisLab.setColor(ChartColor.WHITE);
   gWG.addChartObject(xAxisLab);

   NumericAxisLabels yAxisLab = new NumericAxisLabels(yAxis);
   yAxisLab.setColor(ChartColor.WHITE);
   yAxisLab.setAxisLabelsFormat(ChartConstants.CURRENCYFORMAT);
   gWG.addChartObject(yAxisLab);

   AxisTitle yaxistitle = new AxisTitle( yAxis, theFont, "Millions $");
   yaxistitle.setColor(ChartColor.WHITE);
   gWG.addChartObject(yaxistitle);

   Grid ygrid = new Grid(xAxis, yAxis,ChartConstants.Y_AXIS, ChartConstants.GRID_MAJOR);
   ygrid.setColor(ChartColor.WHITE);
   ygrid.setLineWidth(1);
   gWG.addChartObject(ygrid);

   ChartAttribute attrib1 = new ChartAttribute (ChartColor.GREEN, 0,ChartConstants.LS_SOLID, ChartColor.GREEN);
   attrib1.setFillFlag(true);
   ChartGradient bargrad = new ChartGradient(pTransform1, ChartConstants.GRADIENT_MAPTO_PLOT_NORMALIZED_COORDINATES,
		   			ChartColor.RED, ChartColor.YELLOW, 90);
   attrib1.setGradient(bargrad);
   SimpleBarPlot thePlot1 = new SimpleBarPlot(pTransform1, Dataset1,  ChartCalendar.getCalendarWidthValue(Calendar.MONTH,8), 0.0,
                  attrib1, ChartConstants.JUSTIFY_CENTER);
   NumericLabel bardatavalue = thePlot1.getPlotLabelTemplate();
   bardatavalue.setTextFont(theFont);
   bardatavalue.setNumericFormat(ChartConstants.CURRENCYFORMAT);
   bardatavalue.setDecimalPos(0);
   bardatavalue.setColor(ChartColor.WHITE);
   bardatavalue.setChartObjClipping(ChartObj.PLOT_AREA_CLIPPING);
   thePlot1.setPlotLabelTemplate(bardatavalue);
   thePlot1.setShowDatapointValue(true);
   gWG.addChartObject(thePlot1);

   ChartFont theTitleFont = new ChartFont("SansSerif", ChartFont.BOLD,24);
   ChartTitle mainTitle = new ChartTitle(pTransform1, theTitleFont, "Sales are on fire!");
   mainTitle.setTitleType(ChartConstants.CHART_HEADER);
   mainTitle.setTitlePosition( ChartConstants.CENTER_GRAPH);
   mainTitle.setColor(ChartColor.WHITE);
   gWG.addChartObject(mainTitle);

   ChartFont theFooterFont = new ChartFont("SansSerif", ChartFont.BOLD,14);
   ChartTitle footer = new ChartTitle(pTransform1, theFooterFont, "Bar plots can have the values of the bars displayed above or inside each bar.");
   footer.setTitleType(ChartConstants.CHART_FOOTER);
   footer.setTitlePosition( ChartConstants.CENTER_GRAPH);
   footer.setTitleOffset(8);
   footer.setColor(ChartColor.WHITE);
   gWG.addChartObject(footer);

   
  DataToolTip datatooltip = new DataToolTip(gWG);
  TimeLabel xValueTemplate = new TimeLabel(ChartConstants.TIMEDATEFORMAT_MDY);
  NumericLabel yValueTemplate = new NumericLabel( ChartConstants.CURRENCYFORMAT,0);  
  datatooltip.setXValueTemplate(xValueTemplate);
  datatooltip.setYValueTemplate(yValueTemplate);
  datatooltip.setDataToolTipFormat(ChartConstants.DATA_TOOLTIP_XY_TWOLINE);
  datatooltip.getToolTipSymbol().setColor(ChartColor.RED);
  
  datatooltip.addDataToolTipListener();
  
  
  }


}