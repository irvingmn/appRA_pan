package com.plot;

import java.util.Arrays;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.androidplot.series.XYSeries;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import com.androidplot.Plot;
import com.androidplot.xy.*;

import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

public class AndroidPlot extends Activity {
    private XYPlot mySimpleXYPlot;    
    private int peopleCount =(60);
    private SeekBar seekbar;
    private TextView value;
    
    // http://androidplot.com/docs/a-dynamic-xy-plot/   
    // http://android-helper.blogspot.com/search/label/SeekBar
    // title: Probability of Coincidental Birthdays
    // y: Probability of a Match (0, 0.1, 0.2, ... 1)
    // x: Number of People in Class (5, 10, ... 60) 
    
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//
//        // android boilerplate stuff
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//        // get handles to our View defined in layout.xml:
//        dynamicPlot = (XYPlot) findViewById(R.id.dynamicPlot);
//
//        plotUpdater = new MyPlotUpdater(dynamicPlot);
//
//        // only display whole numbers in domain labels
//        dynamicPlot.getGraphWidget().setDomainValueFormat(new DecimalFormat("0"));
//
//        // getInstance and position datasets:
//        SampleDynamicXYDatasource data = new SampleDynamicXYDatasource();
//        SampleDynamicSeries sine1Series = new SampleDynamicSeries(data, 0, "Sine 1");
//        SampleDynamicSeries sine2Series = new SampleDynamicSeries(data, 1, "Sine 2");
//
//        dynamicPlot.addSeries(sine1Series, new LineAndPointFormatter(Color.rgb(0, 0, 0), null, Color.rgb(0, 80, 0)));
//
//        // create a series using a formatter with some transparency applied:
//        LineAndPointFormatter f1 = new LineAndPointFormatter(Color.rgb(0, 0, 200), null, Color.rgb(0, 0, 80));
//        f1.getFillPaint().setAlpha(220);
//        dynamicPlot.addSeries(sine2Series, f1);
//        dynamicPlot.setGridPadding(5, 0, 5, 0);
//
//        // hook up the plotUpdater to the data model:
//        data.addObserver(plotUpdater);
//
//        dynamicPlot.setDomainStepMode(XYStepMode.SUBDIVIDE);
//        dynamicPlot.setDomainStepValue(sine1Series.size());
//
//        // thin out domain/range tick labels so they dont overlap each other:
//        dynamicPlot.setTicksPerDomainLabel(5);
//        dynamicPlot.setTicksPerRangeLabel(3);
//        dynamicPlot.disableAllMarkup();
//
//        // freeze the range boundaries:
//        dynamicPlot.setRangeBoundaries(-100, 100, BoundaryMode.FIXED);
//
//        // kick off the data generating thread:
//        new Thread(data).start();
//    }

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Initialize our XYPlot reference:
        mySimpleXYPlot = (XYPlot) findViewById(R.id.dynamicPlot);
        // only display whole numbers in domain labels
        mySimpleXYPlot.getGraphWidget().setDomainValueFormat(new DecimalFormat("0"));
        // freeze the range boundaries:
        mySimpleXYPlot.setRangeBoundaries(0, 1, BoundaryMode.FIXED);
        
        value = (TextView) findViewById(R.id.textview);
        seekbar = (SeekBar) findViewById(R.id.seekBar1);
        
		seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				value.setText("Numero de Alumnos en Clase "+ progress);
				
				// update plot
				mySimpleXYPlot.clear();
				updateProbabilityPlot(progress);
				mySimpleXYPlot.redraw();
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

		});
        
		// do plot
		updateProbabilityPlot(peopleCount);
    
    }
    
    private void updateProbabilityPlot(int numOfPeople) {
        
        // Create two arrays of y-values to plot:
        Number[] series1Numbers = new Number[numOfPeople];
 
        for (int i = 0; i < numOfPeople; i++) {
        	series1Numbers[i] = calculateProbability(i);
        }
        
        // Turn the above arrays into XYSeries:
        XYSeries series1 = new SimpleXYSeries(
        		// SimpleXYSeries takes a List so turn our array into a List
                Arrays.asList(series1Numbers),          
                // Y_VALS_ONLY means use the element index as the x value
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, 
        		// Set the display title of the series
        		"Numero de Alumnos en Clase ["+numOfPeople+"]");                             
  
        // Create a formatter to use for drawing a series using LineAndPointRenderer:
        LineAndPointFormatter series1Format = new LineAndPointFormatter(
                Color.rgb(112,155, 247),                   // line color
                Color.rgb(255,250,231),                   // point color
                Color.rgb(112,155, 247));              // fill color (optional)
 
        // Add series1 to the xyplot:
        mySimpleXYPlot.addSeries(series1, series1Format);
 
        // Reduce the number of domain/range labels
        //mySimpleXYPlot.setDomainStepMode(XYStepMode.SUBDIVIDE);
        //mySimpleXYPlot.setDomainStepValue(peopleCount);
        mySimpleXYPlot.setTicksPerDomainLabel(1);
        mySimpleXYPlot.setTicksPerRangeLabel(1);
 
        // By default, AndroidPlot displays developer guides to aid in laying out your plot.
        // To get rid of them call disableAllMarkup():
        mySimpleXYPlot.disableAllMarkup();
        
        mySimpleXYPlot.getBackgroundPaint().setAlpha(0);
        mySimpleXYPlot.getGraphWidget().getBackgroundPaint().setAlpha(0);
        mySimpleXYPlot.getGraphWidget().getGridBackgroundPaint().setAlpha(0);   
        
    }
    
    private double calculateProbability(int peopleCount) {
    	// match is 1-(365)*(364)*(363)/365^3...
    	double numerator = 1.0;
    	double denominator = 1.0; 
    	
    	for (int i = 0; i < peopleCount; i++) {
    		numerator *= 365 - i;
    		denominator *= 365;
    	}
    	
    	return 1 - numerator / denominator;
    }
    
    // redraws a plot whenever an update is received:
    private class MyPlotUpdater implements Observer {
        Plot plot;
        public MyPlotUpdater(Plot plot) {
            this.plot = plot;
        }
        @Override
        public void update(Observable o, Object arg) {
            try {
                plot.postRedraw();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    private XYPlot dynamicPlot;
    private XYPlot staticPlot;
    private MyPlotUpdater plotUpdater;

}