#!/usr/bin/perl
# Author: <fill in your name> # My first CGI Perl script.
use CGI qw (: all );
print header;
foreach $key (keys %ENV) {
print "The value of $key is $ENV{$key}", br(), "\n"; }
