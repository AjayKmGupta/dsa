/*
 * Decompiled with CFR 0.152.
 */
package practice.solution.hackerrank;

public class SmallestAndLargest {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        smallest = s.substring(0, k);
        largest = s.substring(0, k);
        int i = 1;
        while (i <= s.length() - k) {
            int j = 0;
            if (smallest.charAt(j) > s.substring(i, i + k).charAt(j)) {
                smallest = s.substring(i, i + k);
            }
            if (largest.charAt(j = 0) < s.substring(i, i + k).charAt(j)) {
                largest = s.substring(i, i + k);
            }
            ++i;
        }
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        String s = "ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs";
        int k = 30;
        System.out.println(SmallestAndLargest.getSmallestAndLargest(s, k));
    }
}
