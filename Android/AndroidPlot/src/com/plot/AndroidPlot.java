package com.plot;

import java.util.Arrays;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;

public class AndroidPlot extends Activity {
    private XYPlot mySimpleXYPlot;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // Initialize our XYPlot reference:
        mySimpleXYPlot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
 
        // Create two arrays of y-values to plot:
        Number[] series1Numbers = {1, 8, 5, 2, 7, 4};
        Number[] series2Numbers = {4, 6, 3, 8, 2, 10};
 
        // Turn the above arrays into XYSeries:
        SimpleXYSeries series1 = new SimpleXYSeries( Arrays.asList(series1Numbers),SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,"Series1");                             
 
        // Same as above, for series2
        SimpleXYSeries series2 = new SimpleXYSeries(Arrays.asList(series2Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, 
                "Series2");
 
        // Create a formatter to use for drawing a series using LineAndPointRenderer:
        LineAndPointFormatter series1Format = new LineAndPointFormatter(
                Color.rgb(0, 200, 0),                   // line color
                Color.rgb(0, 100, 0),                   // point color
                Color.rgb(150, 190, 150), null);              // fill color (optional)
 
     
        mySimpleXYPlot.addSeries(series1, series1Format);
 
        // Same as above, with series2:
        mySimpleXYPlot.addSeries(series2, new LineAndPointFormatter(Color.rgb(0, 0, 200), Color.rgb(0, 0, 100),
                Color.rgb(150, 150, 190), null));
 
 
        // Reduce the number of range labels
        mySimpleXYPlot.setTicksPerRangeLabel(3);
 
        // By default, AndroidPlot displays developer guides to aid in laying out your plot.
        // To get rid of them call disableAllMarkup():
        mySimpleXYPlot.dispatchKeyEvent(null);
        
        mySimpleXYPlot.getBackgroundPaint().setAlpha(0);
        mySimpleXYPlot.getGraphWidget().getBackgroundPaint().setAlpha(0);
        mySimpleXYPlot.getGraphWidget().getGridBackgroundPaint().setAlpha(0);   
    
    }
}