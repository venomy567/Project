import java.util.TreeMap;

class RimConvert {
    TreeMap<Integer, String> rimKeyMap = new TreeMap<>();
    public RimConvert () {

        rimKeyMap.put (100, "C");
        rimKeyMap.put (90, "XC");
        rimKeyMap.put (50, "L");
        rimKeyMap.put (40, "XL");
        rimKeyMap.put (10, "X");
        rimKeyMap.put (9, "IX");
        rimKeyMap.put (5, "V");
        rimKeyMap.put (4, "IV");
        rimKeyMap.put (1, "I");
    }
    public String converToRim (int arabNum){
        StringBuilder result= new StringBuilder();
        int i;

        while (arabNum>0){
            i = rimKeyMap.floorKey(arabNum);
            StringBuilder append = result.append(rimKeyMap.get(i));
            arabNum = arabNum - i;
        }
        return result.toString();
    }
}
