/**
 * Compare two version numbers version1 and version1.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of
 * the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * More cases:
 * (1, 1.0) => 0
 * (1.0.1, 1) => 1
 * (01, 1) => 0
 * (1, 1.1) => -1
 * 
 * @author joshluo
 * 
 */
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            return 0;
        }
        String[] version1Parts = version1.split("\\.");
        String[] version2Parts = version2.split("\\.");
        int compareLevel = Math.min(version1Parts.length, version2Parts.length);
        for (int i = 0; i < compareLevel; i++) {
            int version1Revision = Integer.parseInt(version1Parts[i]);
            int version2Revision = Integer.parseInt(version2Parts[i]);
            if (version1Revision != version2Revision) {
                return (version1Revision > version2Revision) ? 1 : -1;
            }
        }
        if (version1Parts.length > compareLevel) {
            // example 1.0.1 > 1
            for (int i = compareLevel; i < version1Parts.length; i++) {
                if (Integer.parseInt(version1Parts[i]) > 0) {
                    return 1;
                }
            }
            return 0;
        }
        if (version2Parts.length > compareLevel) {
            // example 1 < 1.0.1
            for (int i = compareLevel; i < version2Parts.length; i++) {
                if (Integer.parseInt(version2Parts[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        }
        return 0;
    }

    public static void main(String args[]) {
        final CompareVersionNumbers solution = new CompareVersionNumbers();
        System.out.println(solution.compareVersion("1.0.1", "1"));
    }

}
