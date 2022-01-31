public class reorganizeString {
}
class Solution767 {
    public String reorganizeString(String S) {
        int evenIndex=0;
        int oddIndex=1;
        int len=S.length();
        int []count=new int[26];
        char[]chars=S.toCharArray();
        char[]c=new char[len];
        for(int i=0;i<len;i++){
            count[chars[i]-'a']++;
            if(count[chars[i]-'a']>(len+1)/2)
                return "";
        }
        for(int i=0;i<26;i++){
            while(count[i]!=0&&(count[i]<=len/2)&&oddIndex<len){
                c[oddIndex]=(char)('a'+i);
                count[i]--;
                oddIndex+=2;
            }
            while(count[i]!=0&&evenIndex<len){
                c[evenIndex]=(char)('a'+i);
                count[i]--;
                evenIndex+=2;
            }
        }
        return new String(c);
    }
}