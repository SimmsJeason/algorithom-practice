package JZoffer;

public class JZ53 {
    /**
     * 使用排除法做
     *
     * 1.小数点，e,E 只能出现一次
     * 2. 符号只能出现在开头和e, E的后边
     * 3. 字符应该在数字 字符的范围中
     *
     */
    public boolean isNumeric(char[] str) {

        if(str.length == 0){
            return false;
        }

        boolean sign = false, e = false, node = false;

      for(int i =0 ; i< str.length; i++){

          if(str[i] == 'e' || str[i] =='E'){
              if(e){
                  return false;
              }
              if(i+1 == str.length){
                  return false;
              }
              e = true;

          }else if(str[i] == '+' || str[i] == '-'){
              //第二次出现符号
              if(sign && (str[i-1] != 'e' && str[i-1] != 'E')){
                  return false;
              }

              //第一次出现符号
              if(!sign && i>0 && (str[i-1] != 'e' && str[i-1] != 'E')){
                  return false;
              }
              sign = true;

          }else if(str[i] == '.'){
              if(e ||node){//e 后边不能有， 小数点不能有俩个
                  return false;
              }
              node = true;
          }else if(str[i] < '0' || str[i] > '9'){
              return false;
          }
      }

      return true;
    }

}
