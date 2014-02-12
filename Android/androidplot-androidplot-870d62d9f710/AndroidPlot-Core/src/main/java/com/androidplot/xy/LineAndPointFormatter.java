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
import android.graphics.Color;
import android.graphics.Paint;
import com.androidplot.ui.SeriesRenderer;
import com.androidplot.util.Configurator;
import com.androidplot.util.PixelUtils;

/**
 * Defines the visual aesthetics of an XYSeries; outline color and width, fill style,
 * vertex size and color, shadowing, etc.
 */
public class LineAndPointFormatter extends XYSeriesFormatter<XYRegionFormatter> {

    private static final float DEFAULT_LINE_STROKE_WIDTH_DP   = 1.5f;
    private static final float DEFAULT_VERTEX_STROKE_WIDTH_DP = 4.5f;

    public FillDirection getFillDirection() {
        return fillDirection;
    }

    /**
     * Sets which edge to use to close the line's path for filling purposes.
     * See {@link FillDirection}.
     * @param fillDirection
     */
    public void setFillDirection(FillDirection fillDirection) {
        this.fillDirection = fillDirection;
    }

    protected FillDirection fillDirection = FillDirection.BOTTOM;
    protected Paint linePaint;
    protected Paint vertexPaint;
    protected Paint fillPaint;
    private PointLabelFormatter pointLabelFormatter;

    {
        initLinePaint(Color.BLACK);
    }

    protected LineAndPointFormatter() {
        this(Color.RED, Color.GREEN, Color.BLUE);
    }

    /**
     * Provided as a convenience to users; allows instantiation and xml configuration
     * to take place in a single line
     *
     * @param ctx
     * @param xmlCfgId Id of the xml config file within /res/xml
     */
    public LineAndPointFormatter(Context ctx, int xmlCfgId) {
        // prevent configuration of classes derived from this one:
        if (getClass().equals(LineAndPointFormatter.class)) {
            Configurator.configure(ctx, this, xmlCfgId);
        }
    }

    /**
     * Set corresponding parameter to null to disable the drawing of lines, vertexes or fill.
     * Uses a default of FillDirection.BOTTOM.
     * @param lineColor
     * @param vertexColor
     * @param fillColor
     * @deprecated As of 0.5.1: Use {@link #LineAndPointFormatter(Integer, Integer, Integer, PointLabelFormatter)} instead.
     */
    @Deprecated
    public LineAndPointFormatter(Integer lineColor, Integer vertexColor, Integer fillColor) {
         this(lineColor, vertexColor, fillColor, (PointLabelFormatter) null);
    }

    public LineAndPointFormatter(Integer lineColor, Integer vertexColor, Integer fillColor, PointLabelFormatter plf) {
        this(lineColor, vertexColor, fillColor, plf, FillDirection.BOTTOM);
    }

    /**
     *
     * @param lineColor
     * @param vertexColor
     * @param fillColor
     * @param fillDir Determines which edge or origin of the plot is used to close the path for filling.
     * @deprecated As of 0.5.1: Use
     *             {@link #LineAndPointFormatter(Integer, Integer, Integer, PointLabelFormatter, FillDirection)} instead.
     */
    @Deprecated
    public LineAndPointFormatter(Integer lineColor, Integer vertexColor, Integer fillColor, FillDirection fillDir) {
        this(lineColor, vertexColor, fillColor, null, fillDir);
    }

    public LineAndPointFormatter(Integer lineColor, Integer vertexColor, Integer fillColor, PointLabelFormatter plf, FillDirection fillDir) {
        initLinePaint(lineColor);
        initVertexPaint(vertexColor);
        initFillPaint(fillColor);
        setFillDirection(fillDir);
        this.setPointLabelFormatter(plf);
    }

    @Override
    public Class<? extends SeriesRenderer> getRendererClass() {
        return LineAndPointRenderer.class;
    }

    @Override
    public SeriesRenderer getRendererInstance(XYPlot plot) {
        return new LineAndPointRenderer(plot);
    }

    protected void initLinePaint(Integer lineColor) {
        if (lineColor == null) {
            linePaint = null;
        } else {
            linePaint = new Paint();
            linePaint.setAntiAlias(true);
            linePaint.setStrokeWidth(PixelUtils.dpToPix(DEFAULT_LINE_STROKE_WIDTH_DP));
            linePaint.setColor(lineColor);
            linePaint.setStyle(Paint.Style.STROKE);
        }
    }

    protected void initVertexPaint(Integer vertexColor) {
        if (vertexColor == null) {
            vertexPaint = null;
        } else {
            vertexPaint = new Paint();
            vertexPaint.setAntiAlias(true);
            vertexPaint.setStrokeWidth(PixelUtils.dpToPix(DEFAULT_VERTEX_STROKE_WIDTH_DP));
            vertexPaint.setColor(vertexColor);
            vertexPaint.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    protected void initFillPaint(Integer fillColor) {
        if (fillColor == null) {
            fillPaint = null;
        } else {
            fillPaint = new Paint();
            fillPaint.setAntiAlias(true);
            fillPaint.setColor(fillColor);
        }
    }

    /**
     * Enables the shadow layer on linePaint and shadowPaint by calling
     * setShadowLayer() with preset values.
     */
    public void enableShadows() {
        linePaint.setShadowLayer(1, 3, 3, Color.BLACK);
        vertexPaint.setShadowLayer(1, 3, 3, Color.BLACK);
    }

    public void disableShadows() {
        linePaint.setShadowLayer(0, 0, 0, Color.BLACK);
        vertexPaint.setShadowLayer(0, 0, 0, Color.BLACK);
    }

    public Paint getLinePaint() {
        return linePaint;
    }

    public void setLinePaint(Paint linePaint) {
        this.linePaint = linePaint;
    }

    public Paint getVertexPaint() {
        return vertexPaint;
    }

    public void setVertexPaint(Paint vertexPaint) {
        this.vertexPaint = vertexPaint;
    }

    public Paint getFillPaint() {
        return fillPaint;
    }

    public void setFillPaint(Paint fillPaint) {
        this.fillPaint = fillPaint;
    }

    public PointLabelFormatter getPointLabelFormatter() {
        return pointLabelFormatter;
    }

    public void setPointLabelFormatter(PointLabelFormatter pointLabelFormatter) {
        this.pointLabelFormatter = pointLabelFormatter;
    }
}
