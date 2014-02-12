/*
 * Created on Jan 19, 2011
 *
 * Title:  QCChart2DAndroid - Quinn-Curtis Charting Software for Android
 * Description:  Example program for QCChart2D for Android  charting software
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Quinn-Curtis, Inc. </p>
 * @author Quinn-Curtis staff
 * @version 2.1
*/
package com.quinncurtis.chart2dandroid.examples.bargraphs;
import com.quinncurtis.chart2dandroid.*;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;



public class PlotSelectorActivity extends Activity {
   public static final String TAG = "SimpleLinePlots";

  
   private ChartView currentView1=null;
   
   private SimpleBarPlotChart simplebarplotchart = null;
   private SimpleHorizontalDatasetViewer1 simplehorizontaldatasetviewer1= null;
   @Override
      protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Log.d(TAG, "onCreate");
      int plotid = getIntent().getIntExtra("com.quinncurtis.chart2dandroid.examples.bargraphs.MenuItem",  0);

      switch (plotid)
      {
      case R.id.menuitem1_button:  currentView1 = (ChartView) new SimpleBarPlotChart(this);
      setContentView(currentView1);
      break;
      case R.id.menuitem2_button:  currentView1 = (ChartView) new DoubleBarPlot(this);
      setContentView(currentView1);
      break;
      case R.id.menuitem3_button:  currentView1 = (ChartView) new GroupBarChart(this);
      setContentView(currentView1);
      break;
      case R.id.menuitem4_button:  currentView1 = (ChartView) new FloatingBarChart(this);
      setContentView(currentView1);
      break;       
      case R.id.menuitem5_button:  currentView1 = (ChartView) new Histogram(this);
      setContentView(currentView1);
      break;
      case R.id.menuitem6_button:  currentView1 = (ChartView) new BostonClimate(this);
      setContentView(currentView1);
      break;      
      case R.id.menuitem7_button:  currentView1 = (ChartView) new JapanWorkforce(this);
      setContentView(currentView1);
      break;      
      case R.id.menuitem8_button:  currentView1 = (ChartView) new LandOfTheFry(this);
      setContentView(currentView1);
      break;      
      case R.id.menuitem9_button:  currentView1 = (ChartView) new MedicareDrugCosts(this);
      setContentView(currentView1);
      break;      
      case R.id.menuitem10_button:  currentView1 = (ChartView) new NasaSpending(this);
      setContentView(currentView1);
      break;      
      case R.id.menuitem11_button:  
     	  setContentView(R.layout.simpledatasetviewerchartlayout); 	
     	  simplebarplotchart = (SimpleBarPlotChart) findViewById(R.id.simplebarchart); // new MultiLine(this);
    	  currentView1 = (ChartView) simplebarplotchart;
    	  simplehorizontaldatasetviewer1 = (SimpleHorizontalDatasetViewer1) findViewById(R.id.simpledatasetviewer);
    	  simplehorizontaldatasetviewer1.InitializeDatasetViewer(simplebarplotchart);                                   
           
      break;  
      }
  

   }

   @Override
   protected void onResume() {
      super.onResume();

   }

   @Override
   protected void onPause() {
      super.onPause();

   }
  

}