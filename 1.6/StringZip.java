public class StringZip {
  public static void main(String[] args) {
    String res0 = stringZip("");
    System.out.println(res0);
    String res1 = stringZip("aabbcc");
    System.out.println(res1);
    String res2 = stringZip("abcde");
    System.out.println(res2);
    String res3 = stringZip("aaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccccc");
    System.out.println(res3);
    String res4 = stringZip("abcdefghijklmn");
    System.out.println(res4);
    String res5 = stringZip("aaabbcaaaa");
    System.out.println(res5);
  }

  public static String stringZip(String str) {
    int len = str.length();
    if(len == 0) return str;

    StringBuilder sb = new StringBuilder(len * 2);

    char prev = str.charAt(0);
    int same = 1;

    for(int i = 0; i < len - 1; i++) {
      char curr = str.charAt(i);
      if(prev == curr) {
        same++;
      } else {
        sb.append(str.charAt(i)).append(same);
        prev = curr;
        same = 1;
      }
    }
    sb.append(str.charAt(len - 1)).append(same);

    String zipped = sb.toString();
    return zipped.length() <= len ? zipped : str;
  }
}