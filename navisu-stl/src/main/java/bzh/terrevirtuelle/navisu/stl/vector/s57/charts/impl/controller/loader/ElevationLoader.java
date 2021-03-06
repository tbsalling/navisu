/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.terrevirtuelle.navisu.stl.vector.s57.charts.impl.controller.loader;

import bzh.terrevirtuelle.navisu.core.view.geoview.worldwind.impl.GeoWorldWindViewImpl;
import bzh.terrevirtuelle.navisu.domain.util.Point3D;
import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.globes.ElevationModel;
import gov.nasa.worldwind.render.Polygon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serge
 * @date Mar 4, 2017
 */
public class ElevationLoader {

    protected Polygon polygon;
    protected WorldWindow wwd;
    protected ElevationModel model;
    protected String elevationsStr = "";
    protected String bottomStr;
    protected double tileSide;
    protected int ptsCounts;
    protected String BOTTOM_STR;
    protected double bottom;
    protected double magnification;
    protected List<Point3D> bottomPositions;
    protected List<Point3D> topPositions;
    protected double space;
    protected double spaceLat;
    protected double spaceLon;
    protected double scaleLatFactor;
    protected double scaleLonFactor;

    public ElevationLoader(Polygon polygon, double tileSide,
            int ptsCounts, double bottom,
            double magnification,
            double scaleLatFactor,
            double scaleLonFactor) {
        this.polygon = polygon;
        this.tileSide = tileSide;
        this.ptsCounts = ptsCounts;
        this.bottom = bottom;
        this.magnification = magnification;
        this.scaleLatFactor = scaleLatFactor;
        this.scaleLonFactor = scaleLonFactor;
        BOTTOM_STR = Double.toString(bottom);
        //  System.out.println("BOTTOM_STR " + BOTTOM_STR);
        wwd = GeoWorldWindViewImpl.getWW();
        model = this.wwd.getModel().getGlobe().getElevationModel();
        bottomPositions = new ArrayList<>();
        topPositions = new ArrayList<>();
        space = tileSide / (ptsCounts - 1);
    }

    public String compute() {
        String result = "";
        List<? extends Position> positions = polygon.getBoundaries().get(0);

        double latRange = (positions.get(3).getLatitude().getDegrees() - positions.get(0).getLatitude().getDegrees()) / (ptsCounts - 1);
        double lonRange = (positions.get(0).getLongitude().getDegrees() - positions.get(1).getLongitude().getDegrees()) / (ptsCounts - 1);

        latRange = Math.abs(latRange);
        lonRange = Math.abs(lonRange);
        
        double longitude = positions.get(1).getLongitude().getDegrees();
        double latitude;
        for (int i = 0; i < ptsCounts; i++) {
            latitude = positions.get(3).getLatitude().getDegrees();
            for (int j = 0; j < ptsCounts; j++) {
                double el = model.getElevation(Angle.fromDegrees(latitude), Angle.fromDegrees(longitude));
                el /= magnification;
                elevationsStr += el + " ";
                bottomStr += BOTTOM_STR + " ";
                latitude -= latRange;
            }
            longitude -= lonRange;
        }

        result += createDEM(elevationsStr, "<ImageTexture DEF='MYTEXT' url='\"image.jpg\"'/> \n"
                + "<TextureTransform  rotation='-1.57' />\n");

        result += createDEM(bottomStr, "\n");

        /*
          North face
         */
        latitude = positions.get(3).getLatitude().getDegrees();
        longitude = positions.get(1).getLongitude().getDegrees();
        double pos = 0.0;
        topPositions.clear();
        bottomPositions.clear();
        
        for (int i = 0; i < ptsCounts; i++) {
           double el = model.getElevation(Angle.fromDegrees(latitude), Angle.fromDegrees(longitude));
            el /= magnification;
            topPositions.add(new Point3D(pos, el, 0.0));
            bottomPositions.add(new Point3D(pos, bottom, 0.0));
            pos += space; 
            longitude -= lonRange;
        }
        result += createBoundaryFace("", bottomPositions, topPositions);

        /*
          South face
         */
        latitude = positions.get(0).getLatitude().getDegrees();
        longitude = positions.get(1).getLongitude().getDegrees();
        pos = 0.0;
        topPositions.clear();
        bottomPositions.clear();
        for (int i = 0; i < ptsCounts; i++) {
           double el = model.getElevation(Angle.fromDegrees(latitude), Angle.fromDegrees(longitude));
            el /= magnification;
            topPositions.add(new Point3D(pos, el, -tileSide));
            bottomPositions.add(new Point3D(pos, bottom, -tileSide));
            pos += space;
            longitude -= lonRange;
        }
        
        /*
        for (double lon = positions.get(1).getLongitude().getDegrees();
                lon > positions.get(0).getLongitude().getDegrees();
                lon -= lonRange) {
            double el = model.getElevation(Angle.fromDegrees(latitude), Angle.fromDegrees(lon));
            el /= 10;
            topPositions.add(new Point3D(pos, el, -tileSide));
            bottomPositions.add(new Point3D(pos, bottom, -tileSide));
            pos += space;
        }
        */
        result += createBoundaryFace("", bottomPositions, topPositions);

        /*
         East face
         */
        double lon0 = positions.get(1).getLongitude().getDegrees();
        pos = 0.0;
        topPositions.clear();
        bottomPositions.clear();
        for (double lat = positions.get(2).getLatitude().getDegrees();
                lat > positions.get(1).getLatitude().getDegrees();
                lat -= latRange) {
            double el = model.getElevation(Angle.fromDegrees(lat), Angle.fromDegrees(lon0));
            el /= 10;
            topPositions.add(new Point3D(0.0, el, pos));
            bottomPositions.add(new Point3D(0.0, bottom, pos));
            pos += space;
        }
        result += createBoundaryFace("<Transform rotation='0 1 0 3.14116'> \n",
                bottomPositions, topPositions);

        /*
         west face
         */
        lon0 = positions.get(0).getLongitude().getDegrees();
        pos = 0.0;
        topPositions.clear();
        bottomPositions.clear();
        for (double lat = positions.get(2).getLatitude().getDegrees();
                lat > positions.get(1).getLatitude().getDegrees();
                lat -= latRange) {
            double el = model.getElevation(Angle.fromDegrees(lat), Angle.fromDegrees(lon0));
            el /= 10;
            topPositions.add(new Point3D(-tileSide, el, pos));
            bottomPositions.add(new Point3D(-tileSide, bottom, pos));
            pos += space;
        }
        result += createBoundaryFace("<Transform rotation='0 1 0 3.14116'> \n",
                bottomPositions, topPositions);

        return result;
    }

    private String createDEM(String height, String texture) {
        double spaceZ = space * 1.00147910;
        String txt
                = "<Transform rotation='0 1 0 1.57058' translation='0.0 -0.1 0.0'> \n"
                + "<Shape>\n"
                + "<Appearance>\n"
                + texture
                + "<Material diffuseColor='.38 .42 .44'/> \n"
                + "</Appearance>\n"
                + "<ElevationGrid \n"
                + "ccw='true' solid='false'"
                + " xDimension='" + ptsCounts + "'"
                + " xSpacing='" + space + "'"
                + " zDimension='" + ptsCounts + "'"
                + " zSpacing='" + space + "'"
                + " height='" + height + "'/>\n"
                + "</Shape> \n"
                + "</Transform> \n";
        return txt;
    }

    private String createBoundaryFace(String transform, List<Point3D> bottom, List<Point3D> height) {
        String txt = transform + "\n"
                + "<Shape>\n"
                + "<Appearance>\n"
                + "<Material "
                + "diffuseColor='.38 .42 .44' />\n"
                + "<ImageTexture DEF='MYTEXT' url='\"metal.jpg\"'/> \n"
                + "</Appearance>\n"
                + "<IndexedFaceSet colorPerVertex='false' ";

        String coordIndex = "coordIndex='";
        coordIndex += "0 1 2 3 -1,";
        coordIndex += "1 4 5 2 -1,";
        int[] tabCoord = {1, 4, 5, 2};
        int[] buff = new int[4];
        for (int i = 1; i < bottomPositions.size() - 2; i++) {
            buff[0] = tabCoord[1];
            buff[1] = tabCoord[1] + 2;
            buff[2] = tabCoord[2] + 2;
            buff[3] = tabCoord[2];
            coordIndex += Integer.toString(buff[0]) + " "
                    + Integer.toString(buff[1]) + " "
                    + Integer.toString(buff[2]) + " "
                    + Integer.toString(buff[3]) + " -1,";
            tabCoord[0] = buff[0];
            tabCoord[1] = buff[1];
            tabCoord[2] = buff[2];
            tabCoord[3] = buff[3];
        }
        coordIndex += "' solid='false'>\n";
        txt += coordIndex;

        String coord = "<Coordinate point='";
        coord += topPositions.get(0).toString() + " ";
        coord += topPositions.get(1).toString() + " ";
        coord += bottomPositions.get(1).toString() + " ";
        coord += bottomPositions.get(0).toString() + " ";
        for (int i = 2; i < bottomPositions.size(); i++) {
            coord += topPositions.get(i).toString() + " "
                    + bottomPositions.get(i).toString() + " ";
        }
        coord += "' /> \n";
        txt += coord;

        txt += " </IndexedFaceSet> \n"
                + "</Shape> \n";
        if (!transform.equals("")) {
            txt += "</Transform> \n";
        }
        return txt;
    }

}
