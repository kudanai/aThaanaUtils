package com.athaanautils;

/**
 * Helper library to do thaana conversions
 */
public class ThaanaConversions {

    /**
     * transposes a character sequence to the equivalent
     * thaana letter, based on the segha phonetic keyboard
     * layout that is most predominant now.
     *
     * @param s CharSequence to transpose
     * @return CharSequence (string) with the transpositions
     */
    public static CharSequence transposePhoneticSegha(CharSequence s) {
        String transposed = s.toString();

        // loop through the string, and replace all instances
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char trans = transposePhoneticSegha(c);
            if (c == trans) continue;
            transposed = transposed.replace(c, trans);
        }

        return transposed;
    }

    /**
     * transposes a single character to the equivalent
     * thaana letter, based on the segha phonetic keyboard
     * layout that is most predominant now.
     *
     * @param c the char to transpose
     * @return the transposed char
     */
    public static char transposePhoneticSegha(char c) {

        switch (c) {
            //basic consonants
            case 'h':
                return '\u0780';
            case 'S':
                return '\u0781';
            case 'n':
                return '\u0782';
            case 'r':
                return '\u0783';
            case 'b':
                return '\u0784';
            case 'L':
                return '\u0785';
            case 'k':
                return '\u0786';
            case 'w':
                return '\u0787';
            case 'v':
                return '\u0788';
            case 'm':
                return '\u0789';
            case 'f':
                return '\u078A';
            case 'd':
                return '\u078B';
            case 't':
                return '\u078C';
            case 'l':
                return '\u078D';
            case 'g':
                return '\u078E';
            case 'N':
                return '\u078F';
            case 's':
                return '\u0790';
            case 'D':
                return '\u0791';
            case 'z':
                return '\u0792';
            case 'T':
                return '\u0793';
            case 'y':
                return '\u0794';
            case 'p':
                return '\u0795';
            case 'j':
                return '\u0796';
            case 'c':
                return '\u0797';

            // accented consonants
            case 'X':
                return '\u0798';
            case 'H':
                return '\u0799';
            case 'K':
                return '\u079A';
            case 'J':
                return '\u079B';
            case 'R':
                return '\u079C';
            case 'C':
                return '\u079D';
            case 'M':
                return '\u079E';
            case 'B':
                return '\u079F';
            case 'Y':
                return '\u07A0';
            case 'Z':
                return '\u07A1';
            case 'W':
                return '\u07A2';
            case 'G':
                return '\u07A3';
            case 'Q':
                return '\u07A4';
            case 'V':
                return '\u07A5';

            // diacritics
            case 'a':
                return '\u07A6';
            case 'A':
                return '\u07A7';
            case 'i':
                return '\u07A8';
            case 'I':
                return '\u07A9';
            case 'u':
                return '\u07AA';
            case 'U':
                return '\u07AB';
            case 'e':
                return '\u07AC';
            case 'E':
                return '\u07AD';
            case 'o':
                return '\u07AE';
            case 'O':
                return '\u07AF';
            case 'q':
                return '\u07B0';

            // special and punctuation
            case 'F':
                return '\uFDF2';
            case '?':
                return '\u061F';
            case 'x':
                return '\u00D7';
            case 'P':
                return '\u00F7';
            case ';':
                return '\u061B';
            case ',':
                return '\u060C';

            // default case return original character
            default:
                return c;

        } // end switch statement

    } //end transposePhoneticSegha

} //end class
