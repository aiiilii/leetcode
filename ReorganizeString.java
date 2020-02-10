public class ReorganizeString {

    /**
     * Consider this example: "aaabbbcdd", we will construct the string in this way:
     * a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
     * a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
     * a b a c a _ b _ b // fill in "c" at position 3
     * a b a c a d b d b // fill in "d" at position 5, 7
     * 
     * Time - O(n), fill hash[], find the letter, white results into char array
     * Space - O(N + 26), result + hash[]
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) { // Count letter appearance and store into hash[i];
            hash[S.charAt(i) - 'a'] ++;
        }

        int max = 0;
        int letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i; // find the letter with largest occurence;
            }
        }

        if (max > (S.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[S.length()];
        int index = 0;

        while (hash[letter] > 0) {
            res[index] = (char) (letter + 'a'); // put the letter into even index numbe (0, 2, 4 ...) char array;
            index += 2;
            hash[letter] --;
        }

        for (int i = 0; i < hash.length; i++) { // put the rest into the array;
            while (hash[i] > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
                hash[i] --;
            }
        }
        return String.valueOf(res);
    }
}