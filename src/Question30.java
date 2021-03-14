import java.util.*;

public class Question30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<Integer>();
        int wLength=0;
        int idx=-1;
        if(words.length==0)
            return result;
        wLength=words[0].length();
        int arrLength=words.length;
        int sLength=s.length();
        if(wLength*arrLength>sLength){
            return result;
        }
        Set<Integer> allSet = new HashSet<Integer>();// 存储在字符串S所有匹配的下标 去重 排序
        Map<String, Integer> wordMap = new HashMap<>();// 存储 word中各个单词的个数
        Map<Integer, String> idxMap = new HashMap<>();// 存储字符串s各下标对应的单词

        for(String word:words){
            if(wordMap.containsKey(word)){
                wordMap.put(word, wordMap.get(word) + 1);
                continue;
            }
            while((idx=s.indexOf(word,idx+1))!=-1){
                allSet.add(idx);
                idxMap.put(idx,word);
            }
            wordMap.put(word, 1);
        }
        Map<String,Integer> tmpMap = new HashMap<>();// 存储字符串s各下标对应的单词
        for(int i=0;i<sLength;i++){
            int flagNum=0;
            for(int j=i;j<arrLength*wLength+i;j+=wLength){
                if(allSet.contains(j)){
                    String word=s.substring(j,j+wLength);
                    if(!tmpMap.containsKey(word)){
                        tmpMap.put(word,1);
                    }
                    else {
                        tmpMap.put(word, tmpMap.get(word) + 1);
                    }
                    int times2=tmpMap.get(word);
                    String a=idxMap.get(j);
                    int times=wordMap.get(word);
                    if(times2>times){
                        flagNum=0;
                        tmpMap.clear();
                        break;
                    }
                    else{
                        flagNum++;
                    }
                }
                else{
                    flagNum=0;
                    tmpMap.clear();
                }
            }
            if(flagNum==arrLength){
                result.add(i);
                tmpMap.clear();
            }
            tmpMap.clear();
        }
        return result;
    }
}
