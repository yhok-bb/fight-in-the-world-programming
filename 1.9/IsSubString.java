public class IsSubString {
  public static void main(String[] args) {
    System.out.println(isSubString("abcdef", "efabcd"));
  }

  public static boolean isSubString(String a, String b) {
    if(a.length() != b.length()) return false;

    String concatA = a + a;
    return concatA.contains(b);
  }
}