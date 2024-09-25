package b6.trasua.service;

import b6.trasua.entity.TraSua;

import java.util.ArrayList;
import java.util.List;

public class TraSuaService {
    private List<TraSua> listTS= new ArrayList<>();

    public TraSuaService() {
        listTS.add(new TraSua("TS01","Matcha",35000,'M',"Tocotoco"));
        listTS.add(new TraSua("TS02","Hồng trà",32000,'M',"DingTea"));
        listTS.add(new TraSua("TS03","Nhài",39000,'L',"Highland"));
        listTS.add(new TraSua("TS04","Hoa Cúc",40000,'L',"Highland"));
        listTS.add(new TraSua("TS05","Socola",32000,'M',"The Coffee House"));
        listTS.add(new TraSua("TS06","Vani",30000,'M',"Mixue"));
        listTS.add(new TraSua("TS07","Dâu tằm",38000,'L',"Tocotoco"));
        listTS.add(new TraSua("TS08","Dừa",30000,'M',"DingTea"));
        listTS.add(new TraSua("TS09","Ô long",35000,'M',"Highland"));
        listTS.add(new TraSua("TS10","Bạc hà",39000,'L',"The Coffee House"));
    }

    public List<TraSua> getAll() {
        return listTS;
    }

    public void addTraSua(TraSua ts) {
        listTS.add(ts);
    }
    public TraSua searchTSByMa(String ma) {
        for (TraSua traSua : listTS) {
            if(traSua.getMa().equalsIgnoreCase(ma)){
                return traSua;
            }
        }
        return null;
    }

}
