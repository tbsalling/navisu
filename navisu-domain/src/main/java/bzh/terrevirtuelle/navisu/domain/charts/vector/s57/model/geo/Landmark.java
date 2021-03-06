package bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lndmrk")
public class Landmark extends Buoyage
        implements Serializable {

    public Landmark(Long id) {
        this.id = id;
    }

    public Landmark() {
    }

    public String getCategoryOfLandMark() {
        return categoryOfMark;
    }

    public void setCategoryOfLandMark(String value) {
        this.categoryOfMark = value;
    }

    private String function;

    public String getFunction() {
        return function;
    }

    public void setFunction(String value) {
        this.function = value;
    }

}
