package com.bosch.example.impl;

// import com.bosch.example.impl.Palindromo;
import com.bosch.example.services.PalindromoService;

public class PalindromoImplementation implements PalindromoService {
    @Override
    public Palindromo reverse(String string) {
        StringBuilder s = new StringBuilder(string);
        String sReversed = s.reverse().toString();
        Boolean isPalindromo = sReversed.equals(string) ? true : false;
        Palindromo p = new Palindromo(s, isPalindromo);

        return p;
    }
    
}
