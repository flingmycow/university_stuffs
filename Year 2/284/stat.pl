#!/usr/bin/perl
use CGI qw (: all );
use LWP::Simple qw(get);
print header , "\n", start_html({-title=>�URL retrieval �,
-author=>�<your_email_address>�}), "\n";
if (param(�URL �)) {
print h1("Environment variables"), br(), "\n"; foreach $key (keys %ENV) {
print "The value of $key is $ENV{$key}", br(), "\n"; }
print h1("Parameters"), br(), "\n"; foreach $key (param()) {
print "The value of $key is ",param($key), br(), "\n"; }
print h1("Content of ".param(�URL�)), "\n"; # Retrieve URL here and assign it to $text
print $text , br(), "\n"; }
print h1("URL retrieval"), "\n";
print start_form({-method=>"POST", -action=>"http://cgi.csc.liv.ac.uk/".
"cgi-bin/cgiwrap/<user>/demo2"});
print "URL: ";
2
print textfield({-name=>�URL�, -size=>200}), "\n";
print br(), "\n";
print submit({-name=>�submit �,
-value=>�Process �}), "\n"; print end_form , end_html;
