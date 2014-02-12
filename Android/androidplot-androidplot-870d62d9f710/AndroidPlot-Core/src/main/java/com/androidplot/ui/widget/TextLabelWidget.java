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

package com.androidplot.ui.widget;

import android.graphics.*;
import com.androidplot.ui.*;
import com.androidplot.util.FontUtils;

public abstract class TextLabelWidget extends Widget {


    //private Plot plot;
    //private String label;
    private Paint labelPaint;

    private TextOrientationType orientation;

    {
        labelPaint = new Paint();
        labelPaint.setColor(Color.WHITE);
        labelPaint.setAntiAlias(true);
        labelPaint.setTextAlign(Paint.Align.CENTER);
    }

    public TextLabelWidget(SizeMetrics sizeMetrics) {
        this(sizeMetrics, TextOrientationType.HORIZONTAL);
    }

    public TextLabelWidget(SizeMetrics sizeMetrics, TextOrientationType orientation) {
        super(new SizeMetrics(0, SizeLayoutType.ABSOLUTE, 0, SizeLayoutType.ABSOLUTE));
        //this.plot = plot;
        //this.setWidth(labelPaint.measureText(plot.getTitle()));
        //this.setHeight(labelPaint.getFontMetrics().top);
        setSize(sizeMetrics);
        this.orientation = orientation;
    }

    protected abstract String getText();

    /**
     * Sets the dimensions of the widget to exactly contain the text contents
     */
    public void pack() {
        Rect size = FontUtils.getStringDimensions(getText(), getLabelPaint());
        if(size == null) {
            return;
        }
        switch(orientation) {
            case HORIZONTAL:
                this.setSize(new SizeMetrics(size.height(), SizeLayoutType.ABSOLUTE, size.width()+2, SizeLayoutType.ABSOLUTE));
                break;
            case VERTICAL_ASCENDING:
            case VERTICAL_DESCENDING:
                this.setSize(new SizeMetrics(size.width(), SizeLayoutType.ABSOLUTE, size.height()+2, SizeLayoutType.ABSOLUTE));
                break;
        }

    }

    /**
     * Do not call this method directly.  It is indirectly invoked every time a plot is
     * redrawn.
     * @param canvas The Canvas to draw onto
     * @param widgetRect the size and coordinates of this widget
     */
    @Override
    public void doOnDraw(Canvas canvas, RectF widgetRect) {
        String label = getText();
        FontUtils.getStringDimensions(label, labelPaint);
        float vOffset = labelPaint.getFontMetrics().descent;
        PointF start = LayoutManager.getAnchorCoordinates(widgetRect, AnchorPosition.CENTER);

        // BEGIN ROTATION CALCULATION
        //int canvasState = canvas.save(Canvas.ALL_SAVE_FLAG);

        try {
            canvas.save(Canvas.ALL_SAVE_FLAG);
            canvas.translate(start.x, start.y);
            switch (orientation) {
                case HORIZONTAL:
                    break;
                case VERTICAL_ASCENDING:
                    canvas.rotate(-90);
                    break;
                case VERTICAL_DESCENDING:
                    canvas.rotate(90);
                    break;
                default:

                    throw new UnsupportedOperationException("Orientation " + orientation + " not yet implemented for TextLabelWidget.");
            }
            canvas.drawText(label, 0, vOffset, labelPaint);
        } finally {
            //canvas.restoreToCount(canvasState);
            canvas.restore();
        }

        // END ROTATION CALCULATION
    }

    public Paint getLabelPaint() {
        return labelPaint;
    }

    public void setLabelPaint(Paint labelPaint) {
        this.labelPaint = labelPaint;
    }

    public TextOrientationType getOrientation() {
        return orientation;
    }

    public void setOrientation(TextOrientationType orientation) {
        this.orientation = orientation;
    }
}
