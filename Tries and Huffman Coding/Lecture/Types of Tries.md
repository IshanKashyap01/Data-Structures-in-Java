# Types of Tries

## Simple Tries

- Words are stored as linked character nodes

- For ex. "word" and "words" will be stored as w-o-r-**d**-**s** where d and s
are *terminal nodes*

## Compressed Tries

- Words are compressed to save space

- For ex. "Word" and "Words" will be stored as "wor" with child nodes "d" and "ds"

## Suffix Tries

- Every substring of a word is also stored separately

- For ex. entering "Word" will make the following entries: "Word", "ord", "rd",
"d"
