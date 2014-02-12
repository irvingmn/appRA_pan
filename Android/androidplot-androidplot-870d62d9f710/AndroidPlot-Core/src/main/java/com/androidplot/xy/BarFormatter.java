/*
 * Copyright 2012 AndroidPlot.com
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.androidplot.xy;

import android.content.Context;
import android.graphics.Paint;
import com.androidplot.ui.SeriesRenderer;
import com.androidplot.util.Configurator;

public class BarFormatter extends XYSeriesFormatter {

    public Paint getFillPaint() {
        return fillPaint;
    }

    public void setFillPaint(Paint fillPaint) {
        this.fillPaint = fillPaint;
    }

    public Paint getBorderPaint() {
        return borderPaint;
    }

    public void setBorderPaint(Paint borderPaint) {
        this.borderPaint = borderPaint;
    }

    private Paint fillPaint;
    private Paint borderPaint;

    {
        fillPaint = new Paint();
        //fillPaint.setColor(Color.RED);
        fillPaint.setStyle(Paint.Style.FILL);
        fillPaint.setAlpha(100);
        borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setAlpha(100);
    }

    /**
     * Provided as a convenience to users; allows instantiation and xml configuration
     * to take place in a single line
     * @param ctx
     * @param xmlCfgId Id of the xml config file within /res/xml
     */
    public BarFormatter(Context ctx, int xmlCfgId) {
        // prevent configuration of classes derived from this one:
        if (getClass().equals(BarFormatter.class)) {
            Configurator.configure(ctx, this, xmlCfgId);
        }
    }

    public BarFormatter(int fillColor, int borderColor) {
        fillPaint.setColor(fillColor);
        borderPaint.setColor(borderColor);
    }

    @Override
    public Class<? extends SeriesRenderer> getRendererClass() {
        return BarRenderer.class;
    }

    @Override
    public SeriesRenderer getRendererInstance(XYPlot plot) {
        return new BarRenderer(plot);
    }
}
