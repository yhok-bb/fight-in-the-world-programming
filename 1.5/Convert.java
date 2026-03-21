public class Convert {
  public static void main(String[] args) {
    String a = "palse";
    String b = "plse";

    boolean res = isOneEdit(a, b);
    System.out.println(res);
  }

  public static boolean isOneEdit(String a, String b) {
    int lenA = a.length();
    int lenB = b.length();

    if(Math.abs(lenA - lenB) > 1) return false;

    int i = 0, j = 0;
    boolean diffFound = false;

    while (i < lenA && j < lenB) {
      if(a.charAt(i) == b.charAt(j)) {
        i++;
        j++;
      } else {
        if(diffFound) return false;
        diffFound = true;

        if(lenA == lenB) {
            i++;
            j++;
        } else if(lenA > lenB) {
            i++;
        } else {
            j++;
        }
      }
        
    }
    return true;
  }
}