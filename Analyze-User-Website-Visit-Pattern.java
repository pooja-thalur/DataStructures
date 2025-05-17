class Pair{
    int time;
    String web;

    Pair(int time, String web){
        this.time = time;
        this.web = web;
    }
}

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> map = new HashMap<>();
        for(int i = 0; i<username.length; i++){
            map.putIfAbsent(username[i], new ArrayList<Pair>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        String res = "";
        HashMap<String, Integer> countMap= new HashMap<>();
        for(String user: map.keySet()){
            Set<String> visited = new HashSet<>();
            List<Pair> pairsList = map.get(user);
            Collections.sort(pairsList, (a,b)->(a.time - b.time));
            for(int i = 0; i<pairsList.size(); i++){
                for(int j = i+1; j<pairsList.size(); j++){
                    for(int k = j+1; k<pairsList.size(); k++){
                        String webstr = pairsList.get(i).web+" "+pairsList.get(j).web+" "+pairsList.get(k).web;
                        if(!visited.contains(webstr)){
                            visited.add(webstr);
                            countMap.put(webstr, countMap.getOrDefault(webstr, 0)+1);
                        }

                        if(res=="" || countMap.get(res)<countMap.get(webstr) || (countMap.get(res) == countMap.get(webstr) && res.compareTo(webstr)>0)){
                            res= webstr;
                        }
                    }
                }
            }
        }

        String[] resList = res.split(" ");
        List<String> result = new ArrayList<String>();
        for(String s: resList){
            result.add(s);
        }

        return result;
    }
}