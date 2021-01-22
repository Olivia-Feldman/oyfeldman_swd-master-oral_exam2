import java.util.ArrayList;
import java.util.HashMap;

public class Drug {
    private String drugName;
    private String description;
    private HashMap<String, String> drugInteractions;
    private ArrayList<String> associatedConditions;

    public void setDrugName(String name) {
        drugName = name;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDescription(String text) {
        description = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDrugInteractions(HashMap<String, String> interactions) {
        drugInteractions = interactions;
    }

    public HashMap<String, String> getDrugInteractions() {
        return drugInteractions;
    }

    public void setAssociatedCondition(ArrayList<String> conditions) { associatedConditions = conditions; }

    public ArrayList<String> getAssociatedConditions() {
        return associatedConditions;
    }
}