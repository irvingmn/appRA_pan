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
public class MedicareDrugCosts extends ChartView {
	static final long serialVersionUID = 2307553737156964459L;
	// Datasets used to organize and store data for charts
	GroupDataset StandardBenefitOutOfPocket = null;
	SimpleDataset StandardBenefitPaidByPlan = null;


	// Initialize the Chart
	public void InitializeChart()
	{
		ChartView chartVu  = this;

	// Create drug cost datasets
		InitializeData();

		ChartFont defaultFont = new ChartFont("SansSerif", ChartFont.PLAIN, 12);

	// Create Group chart of out-of-pocket costs
		CartesianCoordinates pTransform1 = 
			new CartesianCoordinates(ChartConstants.LINEAR_SCALE, ChartConstants.LINEAR_SCALE );

		// Auto-scale based on StandardBenefitOutOfPocket dataset in stacked mode
		StandardBenefitOutOfPocket.setStackMode(ChartConstants.AUTOAXES_STACKED);
		pTransform1.autoScale(StandardBenefitOutOfPocket,ChartConstants.AUTOAXES_NEAR, 
								ChartConstants.AUTOAXES_NEAR);
		// Force y-scale to start at 0
		pTransform1.setScaleStartY(0);
		// Position in top half of window
		pTransform1.setGraphBorderDiagonal(0.16, .125, .84, 0.525) ;

		// Gradient white to orange background for overall chart
		Background graphbackground1 = new Background( pTransform1, 
			ChartConstants.GRAPH_BACKGROUND, ChartColor.WHITE,ChartColor.ORANGE,  ChartConstants.VERT_DIR);
		chartVu.addChartObject(graphbackground1);

		// Simple white background for plot area
		Background graphbackground2 = new Background( pTransform1, 
			ChartConstants.PLOT_BACKGROUND, ChartColor.WHITE);
		chartVu.addChartObject(graphbackground2);

		// Create a linear x-axis
		LinearAxis xAxis1 = new LinearAxis(pTransform1, ChartConstants.X_AXIS);
		// minor ticks every $100
		xAxis1.setAxisTickSpace(100);
		// major ticks every $1000
		xAxis1.setAxisMinorTicksPerMajor(10);
		// Don't want tick marks
		xAxis1.setAxisMinorTickLength(0);
		xAxis1.setAxisMajorTickLength(0);
		chartVu.addChartObject(xAxis1);

		// Create a simple linear axis for left of graph
		LinearAxis yAxis11 = new LinearAxis(pTransform1, ChartConstants.Y_AXIS);
		chartVu.addChartObject(yAxis11);

		// Create a simple linear axis for right of graph
		LinearAxis yAxis12 = new LinearAxis(pTransform1, ChartConstants.Y_AXIS);
		// Position axis at x-axis maximum value
		yAxis12.setAxisIntercept(xAxis1.getAxisMax());
		yAxis12.setAxisTickDir(ChartConstants.AXIS_MAX);
		chartVu.addChartObject(yAxis12);

		// Create axis labels for the x-axis
		NumericAxisLabels xAxisLab1 = new NumericAxisLabels(xAxis1);
		ChartFont xAxisFont = new ChartFont("SansSerif", ChartFont.BOLD, 12);
		xAxisLab1.setAxisLabelsFormat(ChartConstants.CURRENCYBUSINESSFORMAT);
		// Set background of label to solid white so that is shows well
		// on top of data and grids
		xAxisLab1.setTextBgMode(true);
		xAxisLab1.setTextBgColor(ChartColor.WHITE);
		// Do not display minimum and maximum axis values
		xAxisLab1.setAxisLabelsEnds(0);
		// Set high zorder so that axis labels are on top of everything else
		xAxisLab1.setZOrder(110);
		xAxisLab1.setTextFont(xAxisFont);
		chartVu.addChartObject(xAxisLab1);

		// Create simple numeric labels for the left y-axis
		NumericAxisLabels yAxisLab11 = new NumericAxisLabels(yAxis11);
		yAxisLab11.setAxisLabelsFormat(ChartConstants.CURRENCYBUSINESSFORMAT);
		chartVu.addChartObject(yAxisLab11);

		// Create simple numeric labels for right y-axis
		NumericAxisLabels yAxisLab12 = new NumericAxisLabels(yAxis12);
		yAxisLab12.setAxisLabelsFormat(ChartConstants.CURRENCYBUSINESSFORMAT);
		// Make sure labels are positioned to the right of tick marks
		yAxisLab12.setAxisLabelsDir(ChartConstants.AXIS_MAX);
		chartVu.addChartObject(yAxisLab12);

		// Create simple title for x-axis
		AxisTitle xAxisTitle1 = new AxisTitle(xAxis1, defaultFont,"Annual Drug Spending");
		xAxisTitle1.setTextFont(xAxisFont);
		xAxisTitle1.setTextBgMode(true);
		xAxisTitle1.setTextBgColor(ChartColor.WHITE);
		xAxisTitle1.setTextNudge(0,4);
		chartVu.addChartObject(xAxisTitle1);

		// Create simple title for left y-axis
		AxisTitle yAxisTitle11 = new AxisTitle(yAxis11, defaultFont,"Out of pocket costs");
		chartVu.addChartObject(yAxisTitle11);

		// Create simple title for right y-axis
		AxisTitle yAxisTitle12 = new AxisTitle(yAxis12, defaultFont,"Out of pocket costs");
		// Make sure title justifies properply against axis labels
		yAxisTitle12.setYJust(ChartConstants.JUSTIFY_MIN);
		chartVu.addChartObject(yAxisTitle12);
		
		// Create grid lines for x-axis
		Grid xgrid1 = new Grid(xAxis1, yAxis11,ChartConstants.X_AXIS, ChartConstants.GRID_MAJOR);
		// Force grids on top of bar plots
		xgrid1.setZOrder(60);
		// Make grid lines a width of 2
		ChartAttribute gridattrib = new ChartAttribute(ChartColor.BLACK,2,ChartConstants.LS_SOLID);
		xgrid1.setChartObjAttributes(gridattrib);
		chartVu.addChartObject(xgrid1);

		// Create grid lines for y-axis
		Grid ygrid1 = new Grid(xAxis1, yAxis11,ChartConstants.Y_AXIS, ChartConstants.GRID_ALL);
		// Force grids on top of bar plots
		ygrid1.setZOrder(60);
		chartVu.addChartObject(ygrid1);

		// Define attributes of out of pocket costs stacked bar plot
		ChartAttribute PremiumAttrib =	
			new ChartAttribute(ChartColor.BLACK, 1,ChartConstants.LS_SOLID, ChartColor.YELLOW);
		ChartAttribute DeductibleAttrib =	
			new ChartAttribute(ChartColor.BLACK, 1,ChartConstants.LS_SOLID, ChartColor.GREEN);
		ChartAttribute CopayAttrib =	
			new ChartAttribute(ChartColor.BLACK, 1,ChartConstants.LS_SOLID, ChartColor.SALMON);

		ChartAttribute [] standardBenefitAttribs = {PremiumAttrib, DeductibleAttrib, CopayAttrib};
		double stackedbarwidth = 100.0;
		double stackedbarbase = 0.0;
		// Create a stacked bar plot
		StackedBarPlot thePlot1 = new StackedBarPlot(pTransform1, StandardBenefitOutOfPocket, 
			stackedbarwidth, stackedbarbase,	standardBenefitAttribs, ChartConstants.JUSTIFY_MIN);
		chartVu.addChartObject(thePlot1);


	// The cost paid by Medicare chart
		// Create a linear-linear scale
		CartesianCoordinates pTransform2 = 
			new CartesianCoordinates(ChartConstants.LINEAR_SCALE, ChartConstants.LINEAR_SCALE );

		// Auto-scale based on the StandardBenefitPaidByPlan dataset
		pTransform2.autoScale(StandardBenefitPaidByPlan,ChartConstants.AUTOAXES_NEAR, ChartConstants.AUTOAXES_NEAR);
		// Force y-scale to start at 0
		pTransform2.setScaleStartY(0);

		// Want y-scale to increase going downward, instead of default upward
		pTransform2.invertScaleY();

		// Position in botom half of window, both x-axes will align exactly
		pTransform2.setGraphBorderDiagonal(0.16, .525, .84, 0.925) ;


		// Simple white background for plot area
		Background graphbackground3 = new Background( pTransform2, 
			ChartConstants.PLOT_BACKGROUND, ChartColor.WHITE);
		chartVu.addChartObject(graphbackground3);

		// Create the linear x-axis
		LinearAxis xAxis2 = new LinearAxis(pTransform2, ChartConstants.X_AXIS);
		// Make sure y-intercept of x-axis is at the y-value of 0
		xAxis2.setAxisIntercept(0);
		// Minor tick mark every $100
		xAxis2.setAxisTickSpace(100);
		// Major tick mark every $1000
		xAxis2.setAxisMinorTicksPerMajor(10);
		// Don't want tick marks
		xAxis2.setAxisMinorTickLength(0);
		xAxis2.setAxisMajorNthTick(0);
		chartVu.addChartObject(xAxis2);

		// Create a simple linear y-axis for left
		LinearAxis yAxis21 = new LinearAxis(pTransform2, ChartConstants.Y_AXIS);
		chartVu.addChartObject(yAxis21);

		// Create a simple linear y-axis for right
		LinearAxis yAxis22 = new LinearAxis(pTransform2, ChartConstants.Y_AXIS);
		// Place axis at x-axis maximum
		yAxis22.setAxisIntercept(xAxis2.getAxisMax());
		// Point tick marks towards right
		yAxis22.setAxisTickDir(ChartConstants.AXIS_MAX);
		chartVu.addChartObject(yAxis22);

		// Create simple numeric labels for left y-axis
		NumericAxisLabels yAxisLab21 = new NumericAxisLabels(yAxis21);
		yAxisLab21.setAxisLabelsFormat(ChartConstants.CURRENCYBUSINESSFORMAT);
		chartVu.addChartObject(yAxisLab21);

		// Create simple numeric labels for right y-axis
		NumericAxisLabels yAxisLab22 = new NumericAxisLabels(yAxis22);
		yAxisLab22.setAxisLabelsFormat(ChartConstants.CURRENCYBUSINESSFORMAT);
		// Make sure labels justify to the right
		yAxisLab22.setAxisLabelsDir(ChartConstants.AXIS_MAX);
		chartVu.addChartObject(yAxisLab22);

		// Create simple title for left y-axis
		AxisTitle yAxisTitle21 = new AxisTitle(yAxis21, defaultFont,"Paid by Medicare");
		chartVu.addChartObject(yAxisTitle21);

		// Create simple title for right y-axis
		AxisTitle yAxisTitle22 = new AxisTitle(yAxis22, defaultFont,"Paid by Medicare");
		// Make sure title jusifies to outside of axis labels
		yAxisTitle22.setYJust(ChartConstants.JUSTIFY_MIN);
		chartVu.addChartObject(yAxisTitle22);			

		// Create grid lines for x-axis
		Grid xgrid2 = new Grid(xAxis2, yAxis21,ChartConstants.X_AXIS, ChartConstants.GRID_MAJOR);
		// Force grids on top of bar plot
		xgrid2.setZOrder(60);
		xgrid2.setChartObjAttributes(gridattrib);
		chartVu.addChartObject(xgrid2);

		// Create grid lines for y-axis
		Grid ygrid2 = new Grid(xAxis2, yAxis21,ChartConstants.Y_AXIS, ChartConstants.GRID_ALL);
		// Force grids on top of bar plot
		ygrid2.setZOrder(60);
		chartVu.addChartObject(ygrid2);



		// Define attributes for bar plot
		ChartAttribute CostPaidByPlanAttrib =	
			new ChartAttribute(ChartColor.BLACK, 1,ChartConstants.LS_SOLID, ChartColor.LIGHTBLUE);
		// Create simple barplot
		double barwidth = 100.0;
		double barbase = 0.0;
		SimpleBarPlot thePlot2 = new SimpleBarPlot(pTransform2, StandardBenefitPaidByPlan, 
			barwidth, barbase,	CostPaidByPlanAttrib, ChartConstants.JUSTIFY_MIN);
		chartVu.addChartObject(thePlot2);


			// Create a legend 
		ChartFont legendFont = new ChartFont("SansSerif", ChartFont.BOLD,12);
		ChartAttribute legendAttributes = 
			new ChartAttribute(ChartColor.BLACK, 1,ChartConstants.LS_SOLID, ChartColor.BEIGE);
		// Draw legend box
		legendAttributes.setLineFlag(true);
		// Fill legend box
		legendAttributes.setFillFlag(true);
		StandardLegend legend1 = new StandardLegend(0.16, 0.20, 0.45, 0.35, legendAttributes,  
			ChartConstants.VERT_DIR);
		// Add one legend item for each of the bar plots in the chart
		// Set the size of the symbols used in the legend.
		PremiumAttrib.setSymbolSize(12);
		DeductibleAttrib.setSymbolSize(12);
		CopayAttrib.setSymbolSize(12);
		CostPaidByPlanAttrib.setSymbolSize(12);
		legend1.addLegendItem("Premium", ChartConstants.SQUARE, PremiumAttrib, legendFont);
		legend1.addLegendItem("Deductible", ChartConstants.SQUARE, DeductibleAttrib, legendFont);
		legend1.addLegendItem("Copay", ChartConstants.SQUARE, CopayAttrib, legendFont);
		legend1.addLegendItem("Cost paid by plan", ChartConstants.SQUARE, CostPaidByPlanAttrib, legendFont);
		chartVu.addChartObject(legend1);


		// Define the main title of the chart
		ChartFont theTitleFont = new ChartFont("SansSerif", ChartFont.BOLD, 20);
		String GraphTitle = "Unmuddling Medicare";
		ChartTitle mainTitle = new ChartTitle(pTransform1, theTitleFont, GraphTitle);
		mainTitle.setTitleType(ChartConstants.CHART_HEADER);
		mainTitle.setTitlePosition(ChartConstants.CENTER_GRAPH);
		mainTitle.setLineColor(ChartColor.BLACK);
		chartVu.addChartObject(mainTitle);

		// Define the footer of the chart
		ChartFont theFooterFont = new ChartFont("SansSerif",  ChartFont.PLAIN, 12);
		ChartTitle footer = new ChartTitle(pTransform1, theFooterFont,
			"Chart format courtesy of the Boston Globe, Dec. 9, page C13.");
		footer.setTitleType(ChartConstants.CHART_FOOTER);
		footer.setTitlePosition(ChartConstants.CENTER_GRAPH);
		footer.setTitleOffset(2);
		footer.setLineColor(ChartColor.BLACK);
		chartVu.addChartObject(footer);

		// Define the subhead of the chart
		ChartFont theSubheadFont = new ChartFont("SansSerif", ChartFont.BOLD, 14);
		String GraphSubTitle = 	"Finding your drug costs";
		ChartTitle subTitle = new ChartTitle(pTransform1, theSubheadFont, GraphSubTitle);
		subTitle.setTitleType(ChartConstants.CHART_SUBHEAD);
		subTitle.setTitlePosition(ChartConstants.CENTER_GRAPH);
		subTitle.setLineColor(ChartColor.BLACK);
		chartVu.addChartObject(subTitle);
/*
		ChartRectangle2D borderrect = new ChartRectangle2D(0.0, 0.0, 1.0, 1.0);
		GeneralPath borderpath = new GeneralPath();
		borderpath.append(borderrect, false);
		ChartShape bordershape = new ChartShape(pTransform1, borderpath, ChartConstants.NORM_GRAPH_POS,0.0, 0.0, ChartConstants.NORM_GRAPH_POS,0);
		ChartAttribute borderattrib = new ChartAttribute(ChartColor.BLACK, 2, ChartConstants.LS_SOLID);
		bordershape.setChartObjAttributes(borderattrib);
		chartVu.addChartObject(bordershape);
	*/
	}

	public MedicareDrugCosts(Context context)
	{
	      super(context);
	      setFocusable(true);
		  InitializeChart();

	   }


	// Generate data for drug cost chart
	void InitializeData()
	{
		int numvalues = 80;
		int numgroups = 3;
		double [] xvalues = new double[numvalues];
		double [][] outofpocketvalues = new double[numgroups][numvalues];
		double [] paidbyplanvalues = new double[numvalues];
		double deductible = 250;
		double premium = 420;
		double drugcost=0, copay = 0, planpayment;
		int i;

		// Standard Benefit Rules
		// Copay: 25% of drug price until annual drug spending tops $2250
		// Coverage gap: Patient pays until out of pocket costs (not including premium)
		//               reach $3600, when catastrophic coverage kicks in.
		// Catastrophic coverage: $2 for generics, $5 for brandnames or 5% of drug price.


		// Evaluate drug cost for every $100 of drug cost
		for (i = 0; i < numvalues; i++)
		{
			drugcost  = (double) i * 100.0;
			xvalues[i] = drugcost;
			deductible = 250;
			copay = 0;
			if (drugcost <= deductible)
			{
				deductible = drugcost;
				copay = 0;
				planpayment = 0;
			} 
			else
			if (drugcost <= 2250)
			{
				copay = drugcost * 0.25;
				planpayment = drugcost * 0.75;
			}
			else 
			{
				copay = 2250 * 0.25 + (drugcost - 2250);
				planpayment = 2250 * 0.75;
			}
			if ((copay + deductible) > 3600)
			{
			copay = (3600 - deductible) + (drugcost - 3600 - deductible) * 0.05;
			planpayment = drugcost - copay;
			}
			outofpocketvalues[0][i] = premium;
			outofpocketvalues[1][i] = deductible;
			outofpocketvalues[2][i] = copay;
			paidbyplanvalues[i] = planpayment; 
		}
		StandardBenefitOutOfPocket = new GroupDataset("Out of Pocket",xvalues, outofpocketvalues);
		StandardBenefitPaidByPlan = new SimpleDataset("Paid by plan",xvalues, paidbyplanvalues);

	}
}
