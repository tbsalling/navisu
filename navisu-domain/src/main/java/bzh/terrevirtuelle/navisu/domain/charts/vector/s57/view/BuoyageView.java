/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.terrevirtuelle.navisu.domain.charts.vector.s57.view;

import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.BeaconCardinal;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.BeaconIsolatedDanger;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.BeaconLateral;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.BeaconSafeWater;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.BeaconSpecialPurpose;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.BuoyCardinal;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.BuoyInstallation;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.BuoyIsolatedDanger;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.BuoyLateral;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.BuoySafeWater;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.BuoySpecialPurpose;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.Landmark;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.MooringWarpingFacility;
import bzh.terrevirtuelle.navisu.domain.navigation.NavigationData;
import bzh.terrevirtuelle.navisu.domain.navigation.NavigationView;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

/**
 *
 * @author serge
 * @date Jan 24, 2016
 *
 */
public class BuoyageView
        implements NavigationView {

    @XmlElements({
        @XmlElement(name = "bcncar", type = BeaconCardinal.class),
        @XmlElement(name = "bcnisd", type = BeaconIsolatedDanger.class),
        @XmlElement(name = "bcnlat", type = BeaconLateral.class),
        @XmlElement(name = "bcnsaw", type = BeaconSafeWater.class),
        @XmlElement(name = "bcnspp", type = BeaconSpecialPurpose.class),
        @XmlElement(name = "buoycar", type = BuoyCardinal.class),
        @XmlElement(name = "buoyinb", type = BuoyInstallation.class),
        @XmlElement(name = "buoyisd", type = BuoyIsolatedDanger.class),
        @XmlElement(name = "buoylat", type = BuoyLateral.class),
        @XmlElement(name = "buoysaw", type = BuoySafeWater.class),
        @XmlElement(name = "buoyssp", type = BuoySpecialPurpose.class),
        @XmlElement(name = "morfac", type = MooringWarpingFacility.class),
        @XmlElement(name = "lndmrk", type = Landmark.class),
    })
    private NavigationData data;
    private double x;
    private double y;

    public BuoyageView() {
    }

    public BuoyageView(NavigationData data, double x, double y) {
        this.data = data;
        this.x = x;
        this.y = y;
    }

    /**
     * Get the value of y
     *
     * @return the value of y
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * Set the value of y
     *
     * @param y new value of y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Get the value of x
     *
     * @return the value of x
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Set the value of x
     *
     * @param x new value of x
     */
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public NavigationData getData() {
        return data;
    }


    @Override
    public double getLatitude() {
        if (data != null) {
            return data.getLatitude();
        } else {
            return 0.0;
        }
    }

    @Override
    public double getLongitude() {
        if (data != null) {
            return data.getLongitude();
        } else {
            return 0.0;
        }
    }

    @Override
    public String getGeometry() {
        if (data != null) {
            return data.getGeometry();
        } else {
            return "";
        }
    }

    @Override
    public String toString() {
        return "BuoyageView{" + "data=" + data + ", x=" + x + ", y=" + y + '}';
    }

}
