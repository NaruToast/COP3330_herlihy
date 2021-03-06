public class Decrypter {
    public static int[] String2IntArray(String code, int[] codeArray){
        for(int i = 0; i < code.length(); i++){
            codeArray[i] = Character.getNumericValue(code.charAt(i));
        }
        return codeArray;
    }

    public static String Decrypt(String code){
        int buffer;
        int[] codeArray = new int[code.length()];
        String myReturn = "";
        codeArray = String2IntArray(code, codeArray);
        buffer = codeArray[0];
        codeArray[0] = codeArray[2];
        codeArray[2] = buffer;
        buffer = codeArray[1];
        codeArray[1] = codeArray[3];
        codeArray[3] = buffer;
        for (int i = 0; i < code.length(); i++) {
            if(7 <= codeArray[i]){
                codeArray[i] -= 7;
            }else{
                codeArray[i] += 3;
            }
            myReturn += (char)(codeArray[i]+48);
        }
        return myReturn;
    }
}
