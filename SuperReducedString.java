public class SuperReducedString {

    static String superReducedString(String s) {


        // this loop will test all characters up to the length of the input string.
        for (int i = 1; i < s.length(); i++) {

            // the program tests to see if a given character is the same as the character that come before, to check for duplicates
            // it then isolates and removes the duplicate characters, by concatenating the substrings finishing before and resuming after the duplicate characters
            // finally, it resets i so that re-test the new string after the removal of each duplication, by restarting the loop, until all duplicates in the original input string are expunged.

            if (s.charAt(i) == s.charAt(i-1)) {
                s = s.substring(0, i-1) + s.substring(i+1, s.length());
                i = 0;
            }



        }

        // this ensures that an empty string is reflected in the result.

        if (s.length() ==0) {
            return "Empty String";
        }

        // this returns the filtered string

        else {
            return s;
        }
    }

    // this program works - but one disadvantage is that it creates a new string every time it finds a duplicate whilst looping, since strings are immutable in java. Might this lead to performance issues/garbage collection happening each time the loops loops through?

    public static void main(String[] args) {
        System.out.println(superReducedString("aabbbcc"));
        System.out.println(superReducedString("dhudehjfkjfjfjjjddjhdsodfjddhfhgdehdhdhhshshshshshvffvfdgdggdgdgdjjjj"));
        System.out.println(superReducedString("iDfh5DbuvzuGPtWeS5hZ5JsSbsdY3cKCz5nM21mOrYIefFRaqWnb6ELx5ueE11FKa9J8njIqcmZcEaomNwfImQ5CCsB4pItLJozEMqpoyoOutMmWJJsgDDtrmchBV2gtAzYEdWwOgIwZt0s68TUCcGg6H57uLT5WgqduOd2lzaL9Idj39sZObFvw7zPvW8E0Y9vUNttbGsFrzB6QLuYz9mt2NsjgDf88pt0ayCbWXfkuOUSk7KlZfcRNRxJjDtWJhALukcjStQG6l3E1VFMTcKOyEGYL8PIu33p5kJoC1QjQ9wFRggQ3gfDRbvrIhB2M25bgFkVQXgW1XQwa9b0SN38xAictT6GsATmX3ZdhmnDpILujoHr8hANYA5B3CBzfsQC5XKZct34edRLaUZ0VMnXwdwSAzsmZfTM5f2NMRCL09gRMkEPMcrUiPFl9pFAbFU5ZqJnkzL1s5kYsBnMQswaTz6sQ5yL82eTbM8YjqxXUMSuAbPQhrfvLj6aOudPRMboNIHQHA06wLwPxq7r1XzaxNF6OGoC0l53KOJ1Y99xo5Iz1DF4m7KjVXod8SqQ3PeTQ6RSkQKKhU5COtpzFr5Efz0UPka4BhQqzz5C5jQBK6tJ7ZyvQX3PELcJO4Z2vUEsbarSQF6z2j2NNukHDpK9wNKYuFsEpSksCjRZM1CXQRF70qs6iA5GXu2rjqqqdd7jbnuOR79i2o5FAvu26YTRBklCAC6cHhRNroKDX9MwK4WZmNKNapm215ID6YpwkYZZ5ptRs8mww6zqBZQAiE1IdYMYE0mf19yrMdXGoheB3nKNKZ7NGIX8y73B5qzbxXwze18xxoJJnktkBVLz0VRAvmLsKE1ZHipPvBziaOU69AszLtZFXyiLFO9fS8Gh0E9H9UceQG2ff928ie5jeRYNyPKO1bJisiogYQTekuC2kwZKwgv453NaG4jEbDiEbKsJrK51LM1ocbD5Qt8GUq70Fm2z4Q1b6mN34ErgB\n"));
    }

    //here I tested with a very long string - there was no discernible performance drop-off. But maybe if the program was handling lots of requests, it might struggle. I will research to see if there's an alternative tool rather than immutable strings.
}
