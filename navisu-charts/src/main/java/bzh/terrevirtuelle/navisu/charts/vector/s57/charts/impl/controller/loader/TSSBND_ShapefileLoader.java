/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.terrevirtuelle.navisu.charts.vector.s57.charts.impl.controller.loader;

import gov.nasa.worldwind.formats.shapefile.ShapefileRecord;
import gov.nasa.worldwind.render.BasicShapeAttributes;
import gov.nasa.worldwind.render.Material;
import gov.nasa.worldwind.render.ShapeAttributes;
import java.awt.Color;

/**
 *
 * @author Serge Morvan
 * @date 4 juin 2014 NaVisu project
 */
public class TSSBND_ShapefileLoader
        extends LayerShapefileLoader
        implements S57ShapeFileLoader {

    ShapefileRecord record;

    public TSSBND_ShapefileLoader() {
    }

    @Override
    protected ShapeAttributes createPolylineAttributes(ShapefileRecord record) {
        this.record = record;
        ShapeAttributes normalAttributes = new BasicShapeAttributes();
        normalAttributes.setDrawInterior(true);
        normalAttributes.setDrawOutline(true);
        normalAttributes.setOutlineMaterial(new Material(new Color(47,91,42)));
        normalAttributes.setInteriorMaterial(new Material(new Color(9,33,17)));
         normalAttributes.setInteriorOpacity(.8);
      //  normalAttributes.setOutlineMaterial(new Material(new Color(198,77,187)));
      //  normalAttributes.setOutlineStipplePattern((short) 0xAAAA);
       // normalAttributes.setOutlineStippleFactor(8);
       // normalAttributes.setOutlineWidth(3.0);
        return normalAttributes;
    }

    @SuppressWarnings({"UnusedDeclaration"})
    @Override
    protected ShapeAttributes createPolygonAttributes(ShapefileRecord record) {
        Color color = Color.BLACK;

        ShapeAttributes normalAttributes = new BasicShapeAttributes();
        normalAttributes.setInteriorMaterial(new Material(color));
        return normalAttributes;
    }

    @Override
    public ShapefileRecord getRecord() {
        return record;
    }
}
