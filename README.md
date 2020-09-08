# Lab2
CISC 3130 Lab#2

This repository was created to display my source code, input and output of the second lab assignment for the course CISC 3130. The assignment was to read data from a text file that was given from a record label executive in CSV format of a weekly report containing the top streamed music artists on Spotify Charts, and to process this list of information and report who appeared on the top streamed list and how many times they appear.

# Installation
These are the instructions on how to run my program/code, as well as the description of the technologies I used.

## Dependencies/Technologies
* Java 8 IDE (Netbeans 8.2) https://netbeans.org/downloads/8.2/rc/

NetBeans is is a free and open source integrated development environment (IDE) for Java. It runs on Windows, macOS, Linux and Solaris operating systems. I used this IDE to create/compile/run my program. As well as created my text file and integrated the CSV file from Spotify Charts https://spotifycharts.com/regional/global/weekly/latest

## Setup/Instructions
These are the steps to compile Report.java and run the program Report. Source code is found in the src/report folder and the CSV file is called regional-global-weekly-latest.csv. These steps are for use with command line workflow such as terminal.

1. Sign up for a GitHub account if you don't have one. Set up your SSH keys with github.
2. Clone this repository to your machine to get a copy.
3. Move into the project's root directory with cd lab2
4. Move again into the subdirectory src/report using the command cd src/report
5. Compile the java file using the java compiler command javac Report.java
6. Run the compiled java program with the java command java Report

The output should be the same as the output text file: Artists-Weekof09032020.txt

## Folder Structure
* Source Code is saved into the src/report folder.
* Data is called regional-global-weekly-latest.csv which is saved into the Report folder.
* Output is called Artists-Weekof09032020.txt which is saved into the Report folder.
