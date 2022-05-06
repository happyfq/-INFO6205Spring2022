package INFO6205Spring2022.FinalTerm;

public class question1 {
    public String compressString(String str) {
        if (str.length() == 0 || str == null) {
            return "";
        }
        int l = 0;
        int r = 0;
        StringBuffer sb = new StringBuffer();
        while (r < str.length()) {
            if (str.charAt(r) != str.charAt(l)) {
                sb.append(str.charAt(l));
                sb.append(r - l);
                l = r;
            }
            r++;
        }
        sb.append(str.charAt(l));
        sb.append(r - l);
        if (sb.length() >= str.length()) return str;
        return sb.toString();
    }
}

