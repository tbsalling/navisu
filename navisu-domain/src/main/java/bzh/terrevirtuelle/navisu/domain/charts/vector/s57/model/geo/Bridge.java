package bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo;

import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.Geo;
import java.io.Serializable;


public class Bridge extends Geo
implements Serializable
{

	public Bridge(Long id)
	{
		this.id=id;
	}

	public Bridge(){}

	private String categoryOfBridge;

	public String getCategoryOfBridge()
	{
		return categoryOfBridge;
	}

	public void setCategoryOfBridge(String value)
	{
		this.categoryOfBridge= value;
	}

	private String colour;

	public String getColour()
	{
		return colour;
	}

	public void setColour(String value)
	{
		this.colour= value;
	}

	private String colourPattern;

	public String getColourPattern()
	{
		return colourPattern;
	}

	public void setColourPattern(String value)
	{
		this.colourPattern= value;
	}

	private String condition;

	public String getCondition()
	{
		return condition;
	}

	public void setCondition(String value)
	{
		this.condition= value;
	}

	private String conspicuousRadar;

	public String getConspicuousRadar()
	{
		return conspicuousRadar;
	}

	public void setConspicuousRadar(String value)
	{
		this.conspicuousRadar= value;
	}

	private String conspicuousVisually;

	public String getConspicuousVisually()
	{
		return conspicuousVisually;
	}

	public void setConspicuousVisually(String value)
	{
		this.conspicuousVisually= value;
	}

	private String dateEnd;

	public String getDateEnd()
	{
		return dateEnd;
	}

	public void setDateEnd(String value)
	{
		this.dateEnd= value;
	}

	private String dateStart;

	public String getDateStart()
	{
		return dateStart;
	}

	public void setDateStart(String value)
	{
		this.dateStart= value;
	}

	private String horizontalAccuracy;

	public String getHorizontalAccuracy()
	{
		return horizontalAccuracy;
	}

	public void setHorizontalAccuracy(String value)
	{
		this.horizontalAccuracy= value;
	}

	private String horizontalClearance;

	public String getHorizontalClearance()
	{
		return horizontalClearance;
	}

	public void setHorizontalClearance(String value)
	{
		this.horizontalClearance= value;
	}

	private String natureOfConstruction;

	public String getNatureOfConstruction()
	{
		return natureOfConstruction;
	}

	public void setNatureOfConstruction(String value)
	{
		this.natureOfConstruction= value;
	}

	private String objectName;

	public String getObjectName()
	{
		return objectName;
	}

	public void setObjectName(String value)
	{
		this.objectName= value;
	}

	private String pictorialRepresentation;

	public String getPictorialRepresentation()
	{
		return pictorialRepresentation;
	}

	public void setPictorialRepresentation(String value)
	{
		this.pictorialRepresentation= value;
	}

	private String recordIngdate;

	public String getRecordIngdate()
	{
		return recordIngdate;
	}

	public void setRecordIngdate(String value)
	{
		this.recordIngdate= value;
	}

	private String recordingIndication;

	public String getRecordingIndication()
	{
		return recordingIndication;
	}

	public void setRecordingIndication(String value)
	{
		this.recordingIndication= value;
	}

	private String scaleMaximum;

	public String getScaleMaximum()
	{
		return scaleMaximum;
	}

	public void setScaleMaximum(String value)
	{
		this.scaleMaximum= value;
	}

	private String verticalAccuracy;

	public String getVerticalAccuracy()
	{
		return verticalAccuracy;
	}

	public void setVerticalAccuracy(String value)
	{
		this.verticalAccuracy= value;
	}

	private String verticalClearance;

	public String getVerticalClearance()
	{
		return verticalClearance;
	}

	public void setVerticalClearance(String value)
	{
		this.verticalClearance= value;
	}

	private String verticalClearanceClosed;

	public String getVerticalClearanceClosed()
	{
		return verticalClearanceClosed;
	}

	public void setVerticalClearanceClosed(String value)
	{
		this.verticalClearanceClosed= value;
	}

	private String verticalClearanceOpen;

	public String getVerticalClearanceOpen()
	{
		return verticalClearanceOpen;
	}

	public void setVerticalClearanceOpen(String value)
	{
		this.verticalClearanceOpen= value;
	}

	private String verticaldatum;

	public String getVerticaldatum()
	{
		return verticaldatum;
	}

	public void setVerticaldatum(String value)
	{
		this.verticaldatum= value;
	}

	private String objectNameInNationalLanguage;

	public String getObjectNameInNationalLanguage()
	{
		return objectNameInNationalLanguage;
	}

	public void setObjectNameInNationalLanguage(String value)
	{
		this.objectNameInNationalLanguage= value;
	}


}
