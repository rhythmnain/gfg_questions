class Solution {
    public static String caseSort(String s) {
        // code here
          char[] chars = s.toCharArray();

        // Separate lowercase and uppercase characters
        List<Character> lower = new ArrayList<>();
        List<Character> upper = new ArrayList<>();

        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                upper.add(c);
            } else {
                lower.add(c);
            }
        }

        // Sort both lists
        Collections.sort(lower);
        Collections.sort(upper);

        // Pointers to track position in sorted lower and upper lists
        int li = 0, ui = 0;

        // Reconstruct the string with sorted characters in original case positions
        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                chars[i] = upper.get(ui++);
            } else {
                chars[i] = lower.get(li++);
            }
        }

        // Convert the array back to string and return
        return new String(chars);
    }
}