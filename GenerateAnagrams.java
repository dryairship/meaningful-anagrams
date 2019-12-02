import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;
public class GenerateAnagrams
{
    static int newFreq[];
    public static void printAnagrams(String[] validWords, int freq[], String wordTillNow, int remainingLength){
        boolean isAnagramComplete = true;
        for(int i=0; i<26; i++){
            if(freq[i]!=0) {
                isAnagramComplete = false;
                break;
            }
        }
        if(isAnagramComplete){
            System.out.println(wordTillNow);
            return;
        }
        boolean isValid = true;
        for(int i=0; i<validWords.length; i++){
            if(validWords[i].length() > remainingLength)
                continue;
            newFreq = Arrays.copyOf(freq, 26);
            isValid = true;
            for(char c : validWords[i].toCharArray()){
                newFreq[c-65]--;
                if(newFreq[c-65]<0)
                    isValid=false;
            }
            if(isValid){
                printAnagrams(validWords, newFreq, wordTillNow+"-"+validWords[i], remainingLength-validWords[i].length());
            }
        }
    }
    
    public static Vector<String> getWordsThatCouldBeSubstrings(String str) throws Exception{
        Vector<String> validWords = new Vector<>();
        int freq[] = new int[26];
        for(char c : str.toCharArray())
            freq[c-65]++;
        
        int freq2[];
        boolean valid;
        Scanner sc = new Scanner(new File("sowpods.txt"));
        while(sc.hasNext()){
            freq2 = Arrays.copyOf(freq, 26);
            String wrd = sc.next();
            valid = true;
            for(char c: wrd.toCharArray()){
                freq2[c-65]--;
                if(freq2[c-65]<0){
                    valid = false;
                    break;
                }
            }
            if(valid)
                validWords.add(wrd);
        }
        return validWords;
    }
    
    public static void main(String args[]) throws Exception{
        String str = args[0].toUpperCase();
        Vector<String> validWords = getWordsThatCouldBeSubstrings(str);
        String validWordsArray[] = new String[validWords.size()];
        validWords.copyInto(validWordsArray);
        
        int freq[] = new int[26];
        for(char c : str.toCharArray())
            freq[c-65]++;
            
        printAnagrams(validWordsArray, freq, "", str.length());
    }
}

