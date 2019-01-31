# LCS (Group Collaboration)
Longest Common Substring--Dynamic Programming Implementation
By: Novia H., Chris C., Ryan M.


IDE: Eclipse Jee Photon 64-bit (Using JDK 10.0.2)
Platform: Windows 10 Pro 64-bit

LCS of DNA strands:

This program finds the Longest Common Sub-Sequences (LCS) of 2 given DNA strands. This program runs from main method in LCS_DNA.java class.
It is modularized for scalability. It uses the fileStream method to parse the data from the input file and puts them into an ArrayList data
structure for storage. This function also returns a status code to the main method in order to interpret the findings in the input file. If
the input file is not empty and the file exists, pairs will be created from the data read in from the input file. If the number of lines
read is even, then pairs are created normally and the whole ArrayList is used. If the number of lines is odd, the last element of the
ArrayList is ignored. The main method then passes the pairs of strings, one pair at a time, into Compute_LCS, where the LCS table is created.

From the table, the LCS String and LCS Value are derived and written to the output file for a given pair. The main method records the time 
it takes to process the ArrayList and writes the result in nanoseconds and milliseconds to the output file.

The major data structures used include one ArrayList and one 2D Array. The ArrayList holds the DNA strands read in fromthe input file. From here, strings are extracted from it in pairs and fed into the Compute_LCS function. The 2D Array is what represents the LCS table in Compute_LCS. By looking at the two Strings passed to the function, the LCS table is built in the first half of the function, and
the LCS value will be in the final element once complete.
