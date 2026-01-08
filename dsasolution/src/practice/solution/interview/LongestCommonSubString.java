package practice.solution.interview;

public class LongestCommonSubString {

    public static void main(String[] args) {

        String inputString = "abcddbcdd";
        String searchString = "xybcddacxd";
        String resultString = longestCommonSubString(inputString, searchString);
        System.out.println(resultString);

        resultString = longestCommonSubStringWithOutContains(inputString, searchString);
        System.out.println(resultString);
    }

    private static String longestCommonSubString(String inputString, String searchString) {
        String resultString = "";
        String tempSearchString = "";
        int maxLength = 0;
        for(int i = 0; i < searchString.length(); i++) {
            if(!inputString.contains(String.valueOf(searchString.charAt(i)))) {
                continue;
            }
            tempSearchString = searchString.substring(i);
            for(int j = tempSearchString.length(); j > 0; j--) {
                String possibleResultString = tempSearchString.substring(0, j);
                if(inputString.contains(possibleResultString) && maxLength < possibleResultString.length()) {
                    maxLength = possibleResultString.length();
                    resultString = possibleResultString;
                    break;
                }
            }
        }

        return resultString;
    }

    private static String longestCommonSubStringWithOutContains(String inputString, String searchString) {
        String resultString = "";
        String tempSearchString = "";
        int maxLength = 0;
        int first = 0;
        int second = 0;
        for(int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            first = i;
            for(int j = 0; j < searchString.length(); j++) {
                char searchCh = searchString.charAt(j);
                if(ch == searchCh) {
                    second = j;
                    break;
                }
            }
            String firstTemp = inputString.substring(first);
            String secondTemp = searchString.substring(second);
            int loopItr = Math.min(firstTemp.length(), secondTemp.length());
            int index = 0;
            while(loopItr > 0) {
                if(firstTemp.charAt(index) != secondTemp.charAt(index)) {
                    break;
                }
                index++;
                loopItr--;
            }
            tempSearchString = firstTemp.substring(0, index);
            if(maxLength < tempSearchString.length()) {
                resultString = tempSearchString;
                maxLength = resultString.length();
            }
        }

        return resultString;
    }

}
