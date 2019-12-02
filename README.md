# meaningful-anagrams
This program lists out all the anagrams of the input word that could be broken down into meaningful substrings.  
It works by reading through the SOWPODS dictionary to find words that could be substrings of an anagram  
of the input word. It then recursively removes meaningful substrings from the input and prints the generated  
anagrams.  

## Compilation  
```
javac GenerateAnagrams.java
```

## Usage  
```
java GenerateAnagrams <input-word>
```


