import java.util.HashSet;

boolean isUniqueChars(String str) {
  if(str.length() > 128) return false;
  boolean[] char_set = new boolean[128]
  for(int i = 0; i < str.length; i++) {
    int val = str.charAt(i)
    if(char_set[val]) {
      return false;
    }
     char_set[val] = true;
  }
  return true;
}

// 時間計算量、空間計算量ともにO(1)
// これはNが定数(128)によるものだから
// O記法はNの成長率を見る。定数は変化しないので成長率が一定
// よってO(1)となる