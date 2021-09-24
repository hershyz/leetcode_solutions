class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int diff = 0; diff < s.length(); diff++) {
            for (int l = 0; l < s.length() - diff; l++) {
                int r = l + diff;
                String sub = getSub(s, l, r);
                if (sub.length() > max) {
                    if (isUnique(sub)) {
                        max = sub.length();
                    }
                }
            }
        }
        return max;
    }
    
    public String getSub(String s, int l, int r) {
        String result = "";
        for (int i = l; i <= r; i++) {
            result += s.charAt(i);
        }
        return result; 
    }
    
    public boolean isUnique(String s) {
        List<String> found = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (found.contains(c)) {
                return false;
            }
            found.add(c);
        }
        return true;
    }
}
